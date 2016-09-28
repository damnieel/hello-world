package com.moon.vip.service.impl.report;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.report.HmworkRptSqlMapper;
import com.moon.vip.infra.util.DateUtil;
import com.moon.vip.infra.vo.report.ReportVO;
import com.moon.vip.service.report.IReportService;

/**
 * 作业统计服务实现类
 * HmworkRptServiceImpl<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月30日-下午12:39:34 <BR>
 * @version 2.0.0
 *
 */
@Service("hmworkRptService")
public class HmworkRptServiceImpl implements IReportService<ReportVO>{
	
	private Logger logger = Logger.getLogger(HmworkRptServiceImpl.class);
	@Autowired
	private HmworkRptSqlMapper hmworkRptSqlMapper;
	
	public List<ReportVO> getWeeklyReport(Date week, int organizationId, HashSet<Integer> opClaIds) {
		if(week == null) return null;
		logger.info(String.format("作业统计周报查询，查询参数[week:%s,organizationId:%d]", week.toString(),organizationId));
		return hmworkRptSqlMapper.selectWeeklyReport(week, organizationId, opClaIds);
	}

	public List<ReportVO> getMonthlyReport(Date yearMonth, int organizationId, @Param("opClaIds")HashSet<Integer> opClaIds) {
		if(yearMonth == null) return null;
		logger.info(String.format("作业统计月报查询，查询参数[yearMonth:%s,organizationId:%d]", yearMonth.toString(),organizationId));
		return hmworkRptSqlMapper.selectMonthlyReport(yearMonth, organizationId, opClaIds);
	}

	public List<ReportVO> getYearlyReport(Date year, int organizationId, HashSet<Integer> opClaIds) {
		if(year == null) return null;
		logger.info(String.format("作业统计年报查询，查询参数[year:%s,organizationId:%d]", year.toString(),organizationId));
		return hmworkRptSqlMapper.selectYearlyReport(year, organizationId, opClaIds);
	}

	public List<ReportVO> getTimesRangeReport(Date startDate, Date endDate, int organizationId, HashSet<Integer> opClaIds) {
		if(startDate == null || endDate == null) return null;
		logger.info(String.format("作业统计时间段查询，查询参数[startDate:%s,endDate:%s,organizationId:%d]", 
				startDate.toString(),endDate.toString(),organizationId));
		return hmworkRptSqlMapper.selectTimesRangeReport(startDate, endDate, organizationId, opClaIds);
	}

	public boolean makeWeeklyReport(Date week, int organizationId) {
		if(week == null) return false;
		logger.info(String.format("生成作业统计周汇总，参数[week:%s,organizationId:%d]", week.toString(),organizationId));
		hmworkRptSqlMapper.deleteWeeklyReport(week, organizationId);
		hmworkRptSqlMapper.insertWeeklyReport(DateUtil.getWeekStartTime(week), DateUtil.getWeekEndTime(week), organizationId);
		return true;
	}

	public boolean makeMonthlyReport(Date yearMonth, int organizationId) {
		if(yearMonth == null) return false;
		logger.info(String.format("生成作业统计月汇总，参数[yearMonth:%s,organizationId:%d]", yearMonth.toString(),organizationId));
		hmworkRptSqlMapper.deleteMonthlyReport(yearMonth, organizationId);
		hmworkRptSqlMapper.insertMonthlyReport(DateUtil.getMonthStartTime(yearMonth), DateUtil.getMonthEndTime(yearMonth), organizationId);
		return true;
	}

	public boolean makeYearlyReport(Date year, int organizationId) {
		if(year == null) return false;
		logger.info(String.format("生成作业统计年汇总，参数[year:%s,organizationId:%d]", year.toString(),organizationId));
		hmworkRptSqlMapper.deleteYearlyReport(year, organizationId);
		hmworkRptSqlMapper.insertYearlyReport(DateUtil.getYear(year), organizationId);
		return true;
	}

}
