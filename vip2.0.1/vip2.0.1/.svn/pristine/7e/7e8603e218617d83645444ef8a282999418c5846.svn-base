package com.moon.vip.job;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.moon.vip.infra.util.DateUtil;
import com.moon.vip.infra.vo.report.ReportVO;
import com.moon.vip.service.report.IReportService;

/**
 * 作业统计的任务调度
 * HmworkRptJob<BR>
 * 创建人:lqc <BR>
 * 时间：2016年1月4日-下午6:25:06 <BR>
 * @version 2.0.0
 *
 */
@Component("hworkJob")
public class HmworkRptJob {
	@Autowired
	@Qualifier("hmworkRptService")
	private IReportService<ReportVO> hmworkRptService;
	
	public void makeWeeklyReport(){
		Date today = new Date();
		Date week = DateUtil.getLastWeek(today);
		int organizationId = 0;
		hmworkRptService.makeWeeklyReport(week, organizationId);
	}
	
	public void makeMonthlyReport(){
		Date today = new Date();
		Date yearMonth = DateUtil.getLastMonth(today);
		int organizationId = 0;
		hmworkRptService.makeMonthlyReport(yearMonth, organizationId);
	}

	public void makeYearlyReport(){
		Date today = new Date();
		Date year = DateUtil.getLastYear(today);
		int organizationId = 0;
		hmworkRptService.makeYearlyReport(year, organizationId);
	}
}
