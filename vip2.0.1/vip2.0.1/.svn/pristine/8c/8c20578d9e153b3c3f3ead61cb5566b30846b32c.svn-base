package com.moon.vip.service.impl.attend;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.inspect.InspectRptMapper;
import com.moon.vip.infra.util.DateUtil;
import com.moon.vip.infra.vo.attendance.AttendNumsVO;
import com.moon.vip.service.report.IReportService;
@Service("attendReportService")
public class AttendReportServiceImpl implements IReportService<AttendNumsVO>{
    private static Logger logger = Logger.getLogger(AttendReportServiceImpl.class);
    @Autowired
    private InspectRptMapper inspectRptMapper;
	public List<AttendNumsVO> getWeeklyReport(Date week, int organizationId, HashSet<Integer> opClaIds) {
		  logger.info(String.format("获取部门[%s]上周周报[%s]",organizationId,week));
		  return inspectRptMapper.getWeeklyReport( week, organizationId,opClaIds);
	}

	public List<AttendNumsVO> getMonthlyReport(Date yearMonth, int organizationId, HashSet<Integer> opClaIds) {
		  logger.info(String.format("获取部门[%s]上月月报[%s]",organizationId,yearMonth));
		   return  inspectRptMapper.getMonthlyReport( yearMonth,  organizationId,opClaIds);
	}

	public List<AttendNumsVO> getYearlyReport(Date year, int organizationId, HashSet<Integer> opClaIds) {
		 logger.info(String.format("获取部门[%s]上一年年报[%s]",organizationId,year));
		 return inspectRptMapper.getYearlyReport( year, organizationId,opClaIds);
	}

	public List<AttendNumsVO> getTimesRangeReport(Date startDate, Date endDate, int organizationId, HashSet<Integer> opClaIds) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean makeWeeklyReport(Date week, int organizationId) {
		if(week == null) return false;
		logger.info(String.format("生成考勤统计周汇总，参数[week:%s,organizationId:%d]", DateUtil.getWeekStartTime(week).toString()+"-"+DateUtil.getWeekEndTime(week).toString(),organizationId));
		inspectRptMapper.deleteWeeklyReport(week, organizationId);
		inspectRptMapper.insertWeeklyReport(DateUtil.getWeekStartTime(week), DateUtil.getWeekEndTime(week), organizationId);
		return true;
	}

	public boolean makeMonthlyReport(Date yearMonth, int organizationId) {
		if(yearMonth == null) return false;
		logger.info(String.format("生成考勤统计月汇总，参数[yearMonth:%s,organizationId:%d]", yearMonth.toString(),organizationId));
		inspectRptMapper.deleteMonthlyReport(yearMonth, organizationId);
		inspectRptMapper.insertMonthlyReport(DateUtil.getMonthStartTime(yearMonth), DateUtil.getMonthEndTime(yearMonth), organizationId);
		return true;
	}

	public boolean makeYearlyReport(Date year, int organizationId) {
		if(year == null) return false;
		logger.info(String.format("生成考勤统计年汇总，参数[year:%s,organizationId:%d]", year.toString(),organizationId));
		inspectRptMapper.deleteYearlyReport(year, organizationId);
		inspectRptMapper.insertYearlyReport(DateUtil.getYear(year), organizationId);
		return true;
	}


}
