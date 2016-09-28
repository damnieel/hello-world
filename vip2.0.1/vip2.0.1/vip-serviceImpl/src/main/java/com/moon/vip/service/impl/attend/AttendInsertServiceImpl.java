package com.moon.vip.service.impl.attend;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.moon.vip.application.inspect.InspectDetailMapper;
import com.moon.vip.application.inspect.InspectDetailSqlMapper;
import com.moon.vip.infra.constants.EnumAttendException;
import com.moon.vip.infra.exception.AttendanceException;
import com.moon.vip.model.inspect.InspectDetail;
import com.moon.vip.service.attend.IAttendInsertService;
/**
 * 
* @ClassName: AttendInsertServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月24日 下午8:42:19 
*
 */
@Service("attendInsertService")
public class AttendInsertServiceImpl implements IAttendInsertService {
	private static Logger logger = Logger.getLogger(AttendInsertServiceImpl.class);
	@Autowired
	private InspectDetailMapper inspectDetailMapper;
	@Autowired
	private InspectDetailSqlMapper inspectDetailSqlMapper;
	private static Date MIN_DATE = new GregorianCalendar(1970, 1, 1).getTime();
	public boolean insertAttendRecord(List<InspectDetail> atRecords) {
	    for(InspectDetail atRecord : atRecords){
		   checkRecord(atRecord);
	    }
		inspectDetailSqlMapper.insertSelective(atRecords);
		return true;
	}
	public String updateAttendRecord(InspectDetail atRecord) {
		if(!checkRecords(atRecord)){
			int i = inspectDetailSqlMapper.deleteRecord(atRecord);
			if(i > 1){
				throw new AttendanceException(EnumAttendException.DAERR0012);
			}
			if(i == 1){
			  logger.info(String.format("[%s]删除了一条考勤记录", atRecord.getCreator()));
			}
			return "success";
		}
		Integer inspectId = inspectDetailSqlMapper.selectId(atRecord); 
		if (inspectId != null) {
			atRecord.setId(inspectId);
			atRecord.setModifyUser(atRecord.getCreator());
			atRecord.setModifyTime(atRecord.getCreateTime());
			atRecord.setCreator(null);
			atRecord.setCreateTime(null);
			int i = inspectDetailMapper.updateByPrimaryKeySelective(atRecord); //更新操作
			if(i > 1){
				throw new AttendanceException(EnumAttendException.ATEXP0007);
			}
			logger.info(String.format("[%s]更新了一条考勤记录,id为[%s]", atRecord.getModifyUser(),atRecord.getId()));
			return "success";
		}
		inspectDetailMapper.insertSelective(atRecord);
		logger.info(String.format("[%s]新建了一条考勤记录[%s],", atRecord.getCreator(),atRecord.toString()));
		return "success";
	}

	public boolean checkRecords(InspectDetail atRecord){
	    checkBaseRecord(atRecord);
	    if(atRecord.getInspectDate().after(new Date()) || atRecord.getInspectDate().before(MIN_DATE)){
	    	logger.error(String.format("日期区间错误[%s]", atRecord.getInspectDate()));
			throw new AttendanceException(EnumAttendException.DAERR0011);
	    }
		if (atRecord.getInspectStatus() != null && atRecord.getInspectStatus() == 4) {
			return false; //休息日，删除考勤记录
		}
		if (atRecord.getInspectStatus() == null || atRecord.getInspectStatus() > 2) {
			throw new AttendanceException(EnumAttendException.ATEXP0006);
		}
		return true;
	}
	
	public boolean checkRecord(InspectDetail atRecord){
		checkBaseRecord(atRecord);
		if (atRecord.getInspectStatus() == null || atRecord.getInspectStatus() > 2) {
			throw new AttendanceException(EnumAttendException.ATEXP0006);
		}
		return true;
	}
	
	public void checkBaseRecord(InspectDetail atRecord){
		if (StringUtils.isEmpty(atRecord.getStudentId())) {
			throw new AttendanceException(EnumAttendException.ATEXP0002);
		}
		if (StringUtils.isEmpty(atRecord.getProfessionId())) {
			throw new AttendanceException(EnumAttendException.ATEXP0003);
		}
		if (StringUtils.isEmpty(atRecord.getClassId())) {
			throw new AttendanceException(EnumAttendException.ATEXP0004);
		}
		if (StringUtils.isEmpty(atRecord.getInspectDate())) {
			throw new AttendanceException(EnumAttendException.ATEXP0005);
		}
	}

}
