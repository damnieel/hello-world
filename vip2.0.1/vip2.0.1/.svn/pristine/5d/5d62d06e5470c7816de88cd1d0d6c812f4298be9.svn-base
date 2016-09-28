package com.moon.vip.service.impl.attend;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.reader.ExcelWriter;
import com.moon.vip.application.inspect.InspectDetailSqlMapper;
import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.infra.vo.attendance.OrgNameVO;
import com.moon.vip.service.attend.IAttendXslMakerService;
@Service("attendXslMakerService")
public class AttendXslMakerServiceImpl implements IAttendXslMakerService {
	@Autowired
	private InspectDetailSqlMapper  inspectDetailSqlMapper;
	@Autowired
	private OrganizationalProfessionalSqlMapper organizationalProfessionalSqlMapper;
	private static Logger logger = Logger.getLogger(AttendXslMakerServiceImpl.class);
	public OrgNameVO getOrg(){
		List<OrgNameVO> list = inspectDetailSqlMapper.getOrg();
		int i = getRanDom(list.size()-1);
		return list.get(i);
	}
	public List<String> getStuCode(Integer classId){
		return organizationalProfessionalSqlMapper.getStuCode(classId);
	}
	private int getRanDom(Integer num){
	      double a = Math.random();
	      int result = (int) (a*num);
	      return result;
	}
	
	public void getExcel(int month){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH,month);
		OrgNameVO o = getOrg();
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		String[] head = getHead(o);
		List<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>();
		list.add(getMapZero(maxDay, month));
		List<String> stuCodes = getStuCode(o.getId());
		if(stuCodes == null || stuCodes.size() ==0){
			list.add(getRecord("班级尚未查询到学生", 0));
		}
		else{
			for(int i =0;i < stuCodes.size();i++){
				list.add(getRecord(stuCodes.get(i), maxDay));
			}
		}
		try {
			OutputStream out = new FileOutputStream("E://b.xls");
			ExcelWriter<Map<Integer,String>> e = new ExcelWriter<Map<Integer,String>>();
			e.exportExcel(head, list,out);
		} catch (FileNotFoundException e1) {
			logger.error("文件路径找不到", e1);
		}
	}
	private Map<Integer,String> getRecord(String Stucode,int maxDay){
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(0,Stucode);
		for(int i = 1 ;i<maxDay;i++){
			map.put(i, String.valueOf(getRanDom(3)));
		}
		return map;
	}
		
	private Map<Integer,String> getMapZero(int maxDay,int month){
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(0, "学员编号");
		for(int i=1;i<maxDay;i++){
			map.put(i, "2015/"+month+"/"+i);
		}
		return map;
	}
	private String[] getHead(	OrgNameVO o ) {
		String[] head = new String[6];
		head[0] = "部门";
		head[1] = o.getOrgName();
		head[2] = "专业";
		head[3] = o.getProName();
		head[4] = "班级";
		head[5] = o.getClassName();		
		return head;
	}
	

}
