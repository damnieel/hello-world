package com.moon.vip.service.impl.report;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.report.LeaveSchoolSqlMapper;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.util.DateUtil;
import com.moon.vip.infra.vo.report.ReportVO;
import com.moon.vip.service.report.IReportService;

/**
 * 退学率统计服务实现类
 * LeaveSchoolRptServiceImpl<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月29日-下午4:45:18 <BR>
 * @version 2.0.0
 *
 */
@Service("leaveSchoolRptService")
public class LeaveSchoolRptServiceImpl implements IReportService<ReportVO> {
	public static Logger logger = Logger.getLogger(LeaveSchoolRptServiceImpl.class);
	@Autowired
	private LeaveSchoolSqlMapper leaveSchlSqlMapper;
	
	public List<ReportVO> getWeeklyReport(Date week, int organizationId, HashSet<Integer> opClaIds) {
		if(week == null ||organizationId == 0 ) return null;
		Date startDate = DateUtil.getWeekStartTime(week);
		Date endDate = DateUtil.getWeekEndTime(week);
		return getTimesRangeReport(startDate, endDate, organizationId, opClaIds);
	}

	public List<ReportVO> getMonthlyReport(Date YearMonth, int organizationId, HashSet<Integer> opClaIds) {
		if(YearMonth == null ||organizationId == 0 ) return null;
		Date startDate = DateUtil.getMonthStartTime(YearMonth);
		Date endDate = DateUtil.getMonthEndTime(YearMonth);
		return getTimesRangeReport(startDate, endDate, organizationId, opClaIds);
	}

	public List<ReportVO> getYearlyReport(Date year, int organizationId, HashSet<Integer> opClaIds) {
		if(year == null ||organizationId == 0 ) return null;
		Date startDate = DateUtil.getYearStartTime(year);
		Date endDate = DateUtil.getYearEndTime(year);
		return getTimesRangeReport(startDate, endDate, organizationId, opClaIds);
	}

	public List<ReportVO> getTimesRangeReport(Date startDate, Date endDate, int organizationId, HashSet<Integer> opClaIds) {
		if(startDate == null || endDate == null || organizationId == 0) return null;
		if(DateUtil.getLastYear(endDate).after(startDate)){
			throw new BusinessException(EnumCodeException.E0008);
		}
		logger.info(String.format("退学率报表查询参数[startDate:%s,endDate:%s,orgId:%d]", 
				startDate.toString(),
				endDate.toString(),
				organizationId));
		return leaveSchlSqlMapper.getPercenageOfDeptOnTimesRange(startDate, endDate, organizationId, opClaIds);
	}

	public boolean makeWeeklyReport(Date week, int organizationId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean makeMonthlyReport(Date YearMonth, int organizationId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean makeYearlyReport(Date year, int organizationId) {
		// TODO Auto-generated method stub
		return false;
	}

}
