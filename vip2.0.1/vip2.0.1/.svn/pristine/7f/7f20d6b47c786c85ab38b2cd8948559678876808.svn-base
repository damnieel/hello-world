package com.moon.vip.job;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.moon.vip.infra.util.DateUtil;
import com.moon.vip.infra.vo.attendance.AttendNumsVO;
import com.moon.vip.service.report.IReportService;
/**
 * 
* @ClassName: AttendRptJob 
* @Description: TODO(考勤记录定时报表) 
* @author  陈海  - （怡宝 ）
* @date 2016年1月6日 下午2:59:21 
*
 */
public class AttendRptJob {
	
	@Autowired
	@Qualifier("attendReportService")
	private IReportService<AttendNumsVO> attendReportService;
	
	public void makeWeeklyReport(){
		Date today = new Date();
		Date week = DateUtil.getLastWeek(today);
		int organizationId = 0;
		attendReportService.makeWeeklyReport(week, organizationId);
	}
	
	public void makeMonthlyReport(){
		Date today = new Date();
		Date yearMonth = DateUtil.getLastMonth(today);
		int organizationId = 0;
		attendReportService.makeMonthlyReport(yearMonth, organizationId);
	}

	public void makeYearlyReport(){
		Date today = new Date();
		Date year = DateUtil.getLastYear(today);
		int organizationId = 0;
		attendReportService.makeYearlyReport(year, organizationId);
	}

}
