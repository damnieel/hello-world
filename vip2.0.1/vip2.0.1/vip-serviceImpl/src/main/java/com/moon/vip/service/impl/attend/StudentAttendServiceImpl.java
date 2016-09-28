package com.moon.vip.service.impl.attend;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.moon.vip.application.assignment.HomeworkSqlMapper;
import com.moon.vip.application.inspect.InspectDetailSqlMapper;
import com.moon.vip.infra.constants.EnumAttendException;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.AttendanceException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.attendance.AttendDetailVO;
import com.moon.vip.infra.vo.attendance.AttendSercherParams;
import com.moon.vip.infra.vo.attendance.DelAttenParamsVO;
import com.moon.vip.infra.vo.attendance.StuAttendanceVO;
import com.moon.vip.infra.vo.homework.ClassAndTeacherVO;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;
import com.moon.vip.service.attend.IStudentAttendService;
import com.moon.vip.service.search.SearchBase;
import com.moon.vip.service.sys.IGetChildListService;

@Service("studentAttendService")
public class StudentAttendServiceImpl implements IStudentAttendService {

	private static Logger logger = Logger.getLogger(StudentAttendServiceImpl.class);
	@Autowired
	@Qualifier("HmworkRecordSearch")
	private SearchBase<SearchParamsWithDept, ClassAndTeacherVO> searchService;
	@Autowired
	@Qualifier("stuAttendSearcher")
	private SearchBase<AttendSercherParams, StuAttendanceVO> stuAttendService;
	@Autowired
	private HomeworkSqlMapper hmworkSqlMapper;
	@Autowired
	private InspectDetailSqlMapper inspectDetailSqlMapper;
    @Autowired
    private IGetChildListService getChildListService;
	/** 获取所有班级信息 **/
	public List<ClassAndTeacherVO> getClassInfoByParams(SearchParamsWithDept searchParams) {
		validateParams(searchParams);
		return searchService.search(searchParams);
	}

	/** 获取班级总数 **/
	public int getCountClassByParams(SearchParamsWithDept searchParams) {
		validateParams(searchParams);
		return searchService.getSearchResultCount(searchParams);
	}

	/** 判断参数是否有效 **/
	private boolean validateParams(SearchParamsWithDept searchParams) {
		if (searchParams == null || searchParams.getOrgProCalId() == 0) {
			logger.warn("学生考勤搜索参数为空");
			throw new BusinessException(EnumCodeException.E0001);
		}
		return true;
	}

	/** 获取班级信息 **/
	public ClassAndTeacherVO getClassInfoById(Integer classId) {
		if (classId == null) {
			throw new BusinessException(EnumCodeException.E0001);
		}
		SearchParamsWithDept searchParams = new SearchParamsWithDept();
		searchParams.setOrgProCalId(classId);
		List<ClassAndTeacherVO> list = searchService.search(searchParams);
	   if (list == null || list.size() == 0) {
			logger.error(String.format("班级Id[%s]参数有误", classId));
			throw new BusinessException(EnumCodeException.E0007);
		}
		return list.get(0);
	}

	/** 获取班级考勤情况 **/
	public List<StuAttendanceVO> getStuAttendanceByParams(AttendSercherParams params) {
		validateParams(params);
		return stuAttendService.search(params);
	}

	/** 获取情况记录总数 **/
	public int getCountStuAttenByParams(AttendSercherParams searchParams) {
		validateParams(searchParams);
		return stuAttendService.getSearchResultCount(searchParams);
	}

	/** 删除考勤记录 **/
	public String deleteAttenRecord(DelAttenParamsVO delParams,String empCode) {
		if(delParams.getClassId()== 0  || delParams.getStuId() == 0){
			throw new AttendanceException(EnumAttendException.DAERR0009);
		}
		try{
		int i = inspectDetailSqlMapper.delRecordByParams(delParams);
		logger.warn(String.format("[%s]在[%s]删除了[%s]条记录，参数为classId[%s],stuId[%s],date[%s]",
				empCode,new Date(),i,delParams.getClassId(),delParams.getStuId(),delParams.getDate()));
		return "success";
		}catch(Exception e){
			System.out.println(e);
			logger.error(String.format("删除失败 ，课程iD[%s] 学生iD[%s] 时间[%s]",delParams.getClassId(), delParams.getStuId(),delParams.getDate()));
			throw new AttendanceException(EnumAttendException.DAERR0010);
		}
	}

	public List<AttendDetailVO> getStuAttenDetail(DelAttenParamsVO detailParams) {
		if(detailParams.getClassId() == 0 || detailParams.getStuId() == 0 ){
			throw new AttendanceException(EnumAttendException.DAERR0009);
		}
		if(detailParams.getDate() == null){
			detailParams.setDate(new Date());
		}
		 List<AttendDetailVO> list = inspectDetailSqlMapper.getStuAttenDetail(detailParams);
		 return list;
	}

	public List<StuAttendanceVO> getUnAttenStus(AttendSercherParams params) {
		String orgList = getChildListService.getChildList(params.getOrgProCalId());
		String[] orgs = orgList.split(",");
		List<StuAttendanceVO> list = inspectDetailSqlMapper.getUnAttendStus(orgs,params);
		return list;
	}

	public int getCountUnAttenStus(AttendSercherParams params) {
		String orgList = getChildListService.getChildList(params.getOrgProCalId());
		String[] orgs = orgList.split(",");
		int a = inspectDetailSqlMapper.getCountUnAttendStus(orgs,params);
		return a;
	}
}
