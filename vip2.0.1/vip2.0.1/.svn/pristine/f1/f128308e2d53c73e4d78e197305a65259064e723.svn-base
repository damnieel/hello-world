package com.moon.vip.service.impl.attend;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.moon.socket.WebsocketEndPoint;
import com.moon.vip.application.inspect.InspectDetailSqlMapper;
import com.moon.vip.application.student.StudentProfessionalSqlMapper;
import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.infra.constants.EnumAttendException;
import com.moon.vip.infra.exception.AttendanceException;
import com.moon.vip.infra.vo.attendance.AttendanceErrorVO;
import com.moon.vip.infra.vo.attendance.ClassIdAndParentIdVO;
import com.moon.vip.model.inspect.InspectDetail;
import com.moon.vip.service.attend.IAttendImportService;
import com.moon.vip.service.attend.IAttendInsertService;

/**
 * 
* @ClassName: AttendImportServiceImpl 
* @Description: TODO(考勤记录导入实现类) 
* @author  陈海  - （怡宝 ）
* @date 2016年1月6日 下午3:11:07 
*
 */
@Service("attendImportService")
public class AttendImportServiceImpl implements IAttendImportService {
	@Autowired
	private IAttendInsertService attendInsertService;
	@Autowired
	private WebsocketEndPoint websocketEndPoint;
	@Autowired
	private OrganizationalProfessionalSqlMapper organizationalProfessionalSqlMapper;
	@Autowired
	private StudentProfessionalSqlMapper studentProfessionalSqlMapper;
	@Autowired
	private InspectDetailSqlMapper inspectDetailSqlMapper;
	private static Logger logger = Logger.getLogger(AttendImportServiceImpl.class);
    private static final String WHIPPER_DATE_FORMAT ="yyyy-MM-dd";
    private static final String SPRIT_DATE_FORMAT = "yyyy/MM/dd";
	public boolean insertAttendRecords(List<InspectDetail> atRecords,
			int empId) {
		if (atRecords == null || atRecords.size() == 0) {
			logger.error("要导入的数据为空!");
			throw new NullPointerException();
		}
		int recordSize = atRecords.size();
		//ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
       // executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); //任务拒绝策略，启用主线程
		//List<Exception> exceptionList = Collections.synchronizedList(new ArrayList<Exception>()); //线程异常收集容器
        List<InspectDetail> records = new ArrayList<InspectDetail>();
		for (int i = 0; i < recordSize; i++) {
				records.add(atRecords.get(i));
				if(i%100 == 0 || i == recordSize -1){
				    attendInsertService.insertAttendRecord(records);
					//creatThread(executor, records,exceptionList);
					sendPercent(i, recordSize, empId);
					records = new ArrayList<InspectDetail>(); //新建容器
				}
		}
		/**等待所有进程结束**/
		//executor.shutdown();
		//while(true){
			//if(executor.isTerminated()){
//				if(exceptionList.size() == 0){
//					throw new AttendanceException(EnumAttendException.ATEXP0009);
//				}
				websocketEndPoint.sendMessageToUser(empId,String.format("导入完成,共导入%s条记录", recordSize));
				List<Integer> list = inspectDetailSqlMapper.checkRepeat();
				if(list != null && list.size() > 0){
					int a = inspectDetailSqlMapper.deleteRepeat(list);
					logger.info("删掉重复记录共"+ a+ "条");
				}
			//	break;
			//}	
		//}
		return true;
	}
    
//	@Deprecated
//	private void creatThread(ThreadPoolExecutor executor,final List<InspectDetail> records, final List<Exception> list) {
//		 Runnable command =  new Runnable() {
//				public void run() {
//					try{
//					  attendInsertService.insertAttendRecord(records);
//					}catch(AttendanceException e){
//						list.add(e);
//						logger.error(String.format("导入数据发送异常[%s]",e.getExceptionMsg()));
//					}catch (Exception e) {
//						list.add(e);
//						logger.error("未知异常",e);
//					}
//				}
//			};
//		    executor.execute(command);
//	}
	
	private void sendPercent(int current, int size, Integer id) {
		try {
			if (id != null) {
			 NumberFormat numberFormat = NumberFormat.getInstance();
			 numberFormat.setMaximumFractionDigits(2);
			 String result = numberFormat.format((float)current/(float)size*100);
		     websocketEndPoint.sendMessageToUser(id, "正在导入：" + result +"%");
			}
		} catch (Exception e) {
			logger.error("发送消息失败",e);
		}
	}

	private void sendProcess(int current, int size, Integer id) {
		try {
			if (id != null) {
		     websocketEndPoint.sendMessageToUser(id, "正在验证数据："+current+"/"+ size);
			}
		} catch (Exception e) {
			logger.error("发送消息失败",e);
		}
	}

	public List<InspectDetail> changeList(List<Map<Integer, String>> list, List<AttendanceErrorVO> errRecords,String empCode,int id) {
		Integer classId = 0;
		Integer proId = 0;
		int timeSize = 0; //表中考勤的次数
		Date now = new Date();
		List<Date>  attendanceDate ; //考勤日期
		Map<Integer, String> map;
		List<InspectDetail> targetList  = new ArrayList<InspectDetail>();
		websocketEndPoint.sendMessageToUser(id,"正在验证部门信息");
		ClassIdAndParentIdVO info  =  checkOrg(list.get(0)); //验证部门信息
		classId =info.getId(); 
		proId = info.getParentId();
	    websocketEndPoint.sendMessageToUser(id,"正在验证时间");
		attendanceDate = checkTime(list.get(1));  //验证时间信息
		timeSize = attendanceDate.size();
		for(int i = 2;i<list.size();i++){
			map = list.get(i);
			sendProcess(i, list.size(), id);
			targetList.addAll(checkAttendance(i,timeSize,map,errRecords,attendanceDate,classId)); //验证具体数据
		}
		if(errRecords.size() >0){
			websocketEndPoint.sendMessageToUser(id,"验证失败，存在错误信息");
		}
		if( errRecords.size() == 0){ //没有错误数据
		    websocketEndPoint.sendMessageToUser(id,"正在初始化数据");
			for(int i =0;i<targetList.size();i++){
				targetList.get(i).setClassId(classId);
				targetList.get(i).setProfessionId(proId);
				targetList.get(i).setCreateTime(now);
				targetList.get(i).setCreator(empCode);
			}
		}
		return targetList;
	}
   
	/**考勤参数是否正确
	 * @param attendanceDate 
	 * @param classId **/
	private List<InspectDetail> checkAttendance(int row,int timeSize, Map<Integer, String> map, List<AttendanceErrorVO> errRecords, List<Date> attendanceDate, Integer classId) {
	    int mapSize = map.size();
	    String studentCode = map.get(0);
	    int studentId = 0;
	    if(mapSize < timeSize +1){
	    	putErrorRecord(row, map.size(), errRecords, EnumAttendException.DAERR0006) ;  
	    }
		ArrayList<InspectDetail> targetList  = new ArrayList<InspectDetail>();
	    if(!StringUtils.isEmpty(studentCode)){
	    	List<Integer> list = studentProfessionalSqlMapper.getStudentIdByCode(studentCode);
	    	if(list !=null && list.size() == 1){
	    		studentId = list.get(0);
	    		if(!checkIsInClass(classId,studentId)){
	    		 putErrorRecord(row,0,errRecords,EnumAttendException.ATEXP0008);
	    		}
	    	}
	    	else if(list !=null && list.size() > 1){
	    		logger.error(String.format("学号重复[%s]", studentCode));
	    		putErrorRecord(row,0,errRecords,EnumAttendException.DAERR0007);
	    	}
	    	else{
	    		logger.error(String.format("学号不存在[%s]", studentCode));
	    		putErrorRecord(row,0,errRecords,EnumAttendException.DAERR0008);
	    	}
	    }
	    else{
	    	putErrorRecord(row,0,errRecords,EnumAttendException.DAERR0008);
	    }
	    for(int i = 1;i<= timeSize; i++){
	    	try{
	    	  int re = Integer.valueOf(map.get(i));
	    	  if(re == 0 || re == 1 || re == 2){
	    		  InspectDetail record = new InspectDetail();
	    		  record.setStudentId(studentId);
	    		  record.setInspectStatus(re);
	    		  record.setInspectDate(attendanceDate.get(i-1));
	    		  targetList.add(record);
	    	  }
	    	  else{ //验证记录是否为0，1，2
	    		  logger.error(String.format("考勤参数错误[%s]", map.get(i))); 
	    		  putErrorRecord(row, i, errRecords,EnumAttendException.ATEXP0006);
	    	  }
	    	}catch(NumberFormatException e){
	    		logger.error(String.format("考勤数据错误[%s]", map.get(i)));
	    		  putErrorRecord(row, i, errRecords,EnumAttendException.ATEXP0006);
	    	}catch(IndexOutOfBoundsException e){
	    		 putErrorRecord(row, map.size(), errRecords, EnumAttendException.DAERR0005) ;  
	    	}
	    	
	    }
		return targetList;
		
	}
	
	/**验证学生是否在该班级内**/
	private boolean checkIsInClass(Integer classId, int studentId) {
		int a = inspectDetailSqlMapper.checkIsInClass(classId,studentId);
		if(a == 0 || a > 1){
			logger.error(String.format("该学生[%s]不在该班级[%s]内", studentId,classId));
			return false;
		}
		return true;
	}

	/**增加错误数据到容器中**/
	private AttendanceErrorVO putErrorRecord(int row ,int i,List<AttendanceErrorVO> errRecords, EnumAttendException e){
		AttendanceErrorVO errRecord = new AttendanceErrorVO();
		errRecord.setRow(row + 1);
		errRecord.setColumn(i+1);
		errRecord.setReason(e.msg);
		errRecords.add(errRecord);
		return errRecord;
	}
	
    /**测试时间格式是否正确，并返回时间**/
	private  List<Date>  checkTime(Map<Integer, String> map) {
		Integer times = map.size();
		if(times < 2){
			throw new AttendanceException(EnumAttendException.DAERR0003);
		}
		List<Date>  attendanceDate = new ArrayList<Date>(); 
		for(int i = 1;i < times;i++){
			String date = map.get(i);
			if(date ==null){
				break;
			}
			attendanceDate.add(transferData(date));
		}
		return attendanceDate;
	}
	
    /**转换格式**/
	private Date transferData(String date){
		 SimpleDateFormat dff = new SimpleDateFormat(WHIPPER_DATE_FORMAT); 
		 SimpleDateFormat dsf = new SimpleDateFormat(SPRIT_DATE_FORMAT); 
		 Date resultdate;
	     try {
	    	  System.out.println(dff.parse(date));
	    	  resultdate = dff.parse(date);
		    } catch (ParseException e) {
			try {
			   resultdate =  dsf.parse(date);
			 } catch (ParseException e1) {
			  logger.error(String.format("日期格式错误[%s]", date));
			  throw new AttendanceException(EnumAttendException.DAERR0004);
			}
		}
        if (resultdate.after( new Date()) || resultdate.before(new GregorianCalendar(1970, 1, 1).getTime())){
      	    logger.error(String.format("日期区间错误[%s]", date));
			throw new AttendanceException(EnumAttendException.DAERR0011);
		}
			return resultdate;
	     
	}
	/**验证组织框架信息是否正确**/
	private ClassIdAndParentIdVO checkOrg(Map<Integer, String> map) {
		String orgName  = map.get(1);
		String proName  = map.get(3);
		String className = map.get(5);
		if(StringUtils.isEmpty(orgName) || StringUtils.isEmpty(proName) || StringUtils.isEmpty(className)){
			  logger.error(String.format("组织框架信息填写不完整,部门:[%s]专业[%s]课程[%s]", orgName,proName,className));	
			throw new AttendanceException(EnumAttendException.DAERR0000);
		}
		List<ClassIdAndParentIdVO> classId =  organizationalProfessionalSqlMapper.selectClassId(orgName,proName,className);
		if(null == classId){
			logger.error(String.format("班级未找到,部门:[%s]专业[%s]课程[%s]", orgName,proName,className));	
			throw new AttendanceException(EnumAttendException.DAERR0001);
		}
		if(classId.size() == 1){
			logger.info(String.format("课程ID[%s],专业Id[%s]",classId.get(0).getId(),classId.get(0).getParentId()));
			return classId.get(0);
		}
		else{
		  logger.error(String.format("班级定位错误,部门:[%s]专业[%s]课程[%s]", orgName,proName,className));	
	      throw new AttendanceException(EnumAttendException.DAERR0002);
		}
	}
	
}
