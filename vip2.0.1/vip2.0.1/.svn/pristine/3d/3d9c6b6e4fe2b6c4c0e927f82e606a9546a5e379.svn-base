package com.moon.vip.service.report;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * 报表统计的接口
 * ReportService<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月23日-下午8:06:05 <BR>
 * @version 2.0.0
 *
 */
public interface IReportService <T extends Object> {
	/**
	 * 查询周报<BR>
	 * 方法名：getWeeklyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月23日-下午8:06:25 <BR>
	 * @param week
	 * @return List<Object><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<T> getWeeklyReport(Date week, int organizationId, HashSet<Integer> opClaIds);
	/**
	 * 查询月报<BR>
	 * 方法名：getMonthlyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月23日-下午8:06:43 <BR>
	 * @param YearMonth
	 * @return List<Object><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<T> getMonthlyReport(Date yearMonth, int organizationId, HashSet<Integer> opClaIds);
	/**
	 * 查询年报<BR>
	 * 方法名：getYearlyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月23日-下午8:07:03 <BR>
	 * @param year
	 * @return List<Object><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<T> getYearlyReport(Date year, int organizationId, HashSet<Integer> opClaIds);
	/**
	 * 查询依据时间段的报表<BR>
	 * 方法名：getTimesRangeReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月23日-下午8:07:32 <BR>
	 * @param startDate
	 * @param endDate
	 * @return List<Object><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<T> getTimesRangeReport(Date startDate, Date endDate, int organizationId, HashSet<Integer> opClaIds);
	
	/**
	 * 生成周报<BR>
	 * 方法名：makeWeeklyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午6:42:55 <BR>
	 * @param week
	 * @param organizationId
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public boolean makeWeeklyReport(Date week, int organizationId);
	
	/**
	 * 生成月报<BR>
	 * 方法名：makeMonthlyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午6:43:20 <BR>
	 * @param yearMonth
	 * @param organizationId
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public boolean makeMonthlyReport(Date yearMonth, int organizationId);
	
	/**
	 * 生成年报<BR>
	 * 方法名：makeYearlyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午6:43:37 <BR>
	 * @param year
	 * @param organizationId
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public boolean makeYearlyReport(Date year, int organizationId);

}
