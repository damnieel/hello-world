package com.moon.vip.service.impl.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.jute.Record;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moon.vip.application.assignment.HomeworkSqlMapper;
import com.moon.vip.application.inspect.InspectDetailSqlMapper;
import com.moon.vip.infra.vo.attendance.AttendSercherParams;
import com.moon.vip.infra.vo.attendance.StuAttendanceVO;
import com.moon.vip.infra.vo.homework.ClassAndTeacherVO;
import com.moon.vip.infra.vo.search.SearchParamsBase;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;
import com.moon.vip.service.search.SearchBase;
@Component("stuAttendSearcher")
public class StuAttendSearcher extends SearchBase<AttendSercherParams,StuAttendanceVO> {

	private static Logger logger = Logger.getLogger(StuAttendSearcher.class);
	@Autowired
	private InspectDetailSqlMapper inspectDetailSqlMapper;
	
	public List<StuAttendanceVO> excuteSearchOrigner(AttendSercherParams searchParams) {
		Integer num = searchParams.getAbsenceSum();
		 List<StuAttendanceVO> studentlists = new ArrayList<StuAttendanceVO>();
		if(num == null){ //需要查找该班级所有的学生
			 studentlists = inspectDetailSqlMapper.findStudentByClassId(searchParams);
			 if(studentlists == null || studentlists.size()==0 ){
				 return studentlists;
			 }
		}
		List<StuAttendanceVO> list = inspectDetailSqlMapper.getStudentAttendByStuIds(searchParams.getOrgProCalId(),studentlists);
		HashMap<Integer,StuAttendanceVO > attendRecord = new HashMap<Integer, StuAttendanceVO>();
		if(list != null && list.size() > 0){
			for(StuAttendanceVO stu :list){
				attendRecord.put(stu.getStuId(),stu);
			}
		}
		for(StuAttendanceVO record : studentlists){
			StuAttendanceVO attendSum = attendRecord.get(record.getStuId());
			if(attendSum != null ){
			record.setAbsenceSum(attendSum.getAbsenceSum());
			record.setAttendanceSum(attendSum.getAttendanceSum());
			record.setLeaveSum(attendSum.getLeaveSum());
			}
		}
		return studentlists;
	}
	
	
	@Override
	public List<StuAttendanceVO> excuteSearch(AttendSercherParams searchParams) {
		 int claId = searchParams.getOrgProCalId();
		 List<StuAttendanceVO> studentlists = new ArrayList<StuAttendanceVO>();
			 studentlists = inspectDetailSqlMapper.findStuByClaIdInAtdTable(searchParams);
//			 if(studentlists == null || studentlists.size()==0 ){
//				 return studentlists;
//		 }
//		List<StuAttendanceVO> list = inspectDetailSqlMapper.getStuArchesByStuIds(claId,studentlists);
//		HashMap<Integer,StuAttendanceVO > attendRecord = new HashMap<Integer, StuAttendanceVO>();
//		if(list != null && list.size() > 0){
//			for(StuAttendanceVO stu :list){
//				attendRecord.put(stu.getStuId(),stu);
//			}
//		}
//		for(StuAttendanceVO record : studentlists){
//			StuAttendanceVO stuArchies = attendRecord.get(record.getStuId());
//			if(stuArchies != null ){
//			record.setStuCode(stuArchies.getStuCode());
//			record.setClassId(stuArchies.getClassId());
//			record.setStuName(stuArchies.getStuName());
//			record.setStuId(stuArchies.getStuId());
//			}
//		}
		return studentlists;
	}
	
	
	
    @Override
	public int excuteGetSearchResultCount(AttendSercherParams searchParams) {
	    int sum = inspectDetailSqlMapper.getCountStudentByClassId(searchParams);
    	return sum;
	}

}
