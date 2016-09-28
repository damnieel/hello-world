package com.moon.vip.application.report;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.report.ReportVO;

/**
 * 作业统计报表
 * HmworkRptSqlMapper<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月29日-下午7:37:02 <BR>
 * @version 2.0.0
 *
 */
public interface HmworkRptSqlMapper {
	/**
	 * 查询周报<BR>
	 * 方法名：selectWeeklyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-上午10:19:21 <BR>
	 * @param year
	 * @param week
	 * @param OrganizationId
	 * @return List<ReportVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<ReportVO> selectWeeklyReport(@Param("yearWeek")Date yearWeek, @Param("orgId")int organizationId, @Param("opClaIds")HashSet<Integer> opClaIds);
	/**
	 * 查询月报<BR>
	 * 方法名：selectMonthlyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-上午10:20:00 <BR>
	 * @param year
	 * @param month
	 * @param OrganizationId
	 * @return List<ReportVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<ReportVO> selectMonthlyReport(@Param("yearMonth")Date yearMonth, @Param("orgId")int organizationId, @Param("opClaIds")HashSet<Integer> opClaIds);
	/**
	 * 查询年报<BR>
	 * 方法名：selectYearlyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-上午10:20:15 <BR>
	 * @param year
	 * @param OrganizationId
	 * @return List<ReportVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<ReportVO> selectYearlyReport(@Param("year")Date year, @Param("orgId")int organizationId, @Param("opClaIds")HashSet<Integer> opClaIds);
	/**
	 * 查询任意时间段报表<BR>
	 * 方法名：selectTimesRangeReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-上午10:20:26 <BR>
	 * @param startDate
	 * @param endDate
	 * @param OrganizationId
	 * @return List<ReportVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<ReportVO> selectTimesRangeReport(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("orgId")int organizationId, @Param("opClaIds")HashSet<Integer> opClaIds);
	/**
	 * 删除周报<BR>
	 * 方法名：deleteWeeklyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午1:33:08 <BR>
	 * @param yearWeek
	 * @param organizationId
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int deleteWeeklyReport(@Param("yearWeek")Date yearWeek, @Param("orgId")int organizationId);
	/**
	 * 删除月报<BR>
	 * 方法名：deleteMonthlyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午1:33:26 <BR>
	 * @param yearMonth
	 * @param organizationId
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int deleteMonthlyReport(@Param("yearMonth")Date yearMonth, @Param("orgId")int organizationId);
	/**
	 * 删除年报<BR>
	 * 方法名：deleteYearlyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午1:33:38 <BR>
	 * @param year
	 * @param organizationId
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int deleteYearlyReport(@Param("year")Date year, @Param("orgId")int organizationId);
	/**
	 * 汇总周报数据<BR>
	 * 方法名：insertWeeklyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午1:33:51 <BR>
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int insertWeeklyReport(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("orgId")int organizationId);
	/**
	 * 汇总月报数据<BR>
	 * 方法名：insertMonthlyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午1:34:07 <BR>
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int insertMonthlyReport(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("orgId")int organizationId);
	/**
	 * 汇总年报数据<BR>
	 * 方法名：insertYearlyReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午1:34:42 <BR>
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int insertYearlyReport(@Param("year")String year, @Param("orgId")int organizationId);
}
