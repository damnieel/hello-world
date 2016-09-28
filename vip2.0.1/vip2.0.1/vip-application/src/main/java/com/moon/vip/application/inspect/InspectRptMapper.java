package com.moon.vip.application.inspect;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.attendance.AttendNumsVO;

/**
 * 
* @ClassName: InspectRptMapper 
* @Description: TODO(考勤报表mapper) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月31日 下午4:39:38 
*
 */
public interface InspectRptMapper {
    /**
     * 
    * @Author：  陈海  - （怡宝 ）
    * @Title: deleteWeeklyReport 
    * @Description: TODO(删除周报) 
    * @param @param yearWeek
    * @param @param organizationId
    * @param @return    设定文件 
    * @return int    返回类型 
    * @date 2015年12月31日 下午4:54:40 
    * @throws
     */
	public int deleteWeeklyReport(@Param("yearWeek")Date yearWeek, @Param("orgId")int organizationId);
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: deleteMonthlyReport 
	* @Description: TODO(删除月报) 
	* @param @param yearMonth
	* @param @param organizationId
	* @param @return    设定文件 
	* @return int    返回类型 
	* @date 2015年12月31日 下午4:55:03 
	* @throws
	 */
	public int deleteMonthlyReport(@Param("yearMonth")Date yearMonth, @Param("orgId")int organizationId);
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: deleteYearlyReport 
	* @Description: TODO(删除年报) 
	* @param @param year
	* @param @param organizationId
	* @param @return    设定文件 
	* @return int    返回类型 
	* @date 2015年12月31日 下午4:55:18 
	* @throws
	 */
	public int deleteYearlyReport(@Param("year")Date year, @Param("orgId")int organizationId);
	
	  /**
	   * 
	  * @Author：  陈海  - （怡宝 ）
	  * @Title: insertWeeklyReport 
	  * @Description: TODO(制作周报) 
	  * @param @param startDate
	  * @param @param endDate
	  * @param @param organizationId
	  * @param @return    设定文件 
	  * @return int    返回类型 
	  * @date 2015年12月31日 下午4:59:26 
	  * @throws
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
	/**
	  *  获取该部门周报<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	 * @param opClaIds 
	  * @Title: getWeeklyReport <br/>
	  * @return List<AttendNumsVO>    返回类型 <br/>
	  * @date 2015年12月31日 下午8:30:05 <br/>
	  * @throws <br/>
	  *
	 */
	public List<AttendNumsVO> getWeeklyReport(@Param("week")Date week, @Param("organizationId")int organizationId, @Param("opClaIds")HashSet<Integer> opClaIds);
	/**
	  * 获取该部门月报<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	 * @param opClaIds 
	  * @Title: getMonthlyReport <br/>
	  * @return List<AttendNumsVO>    返回类型 <br/>
	  * @date 2015年12月31日 下午8:30:49 <br/>
	  * @throws <br/>
	  *
	 */
	public List<AttendNumsVO> getMonthlyReport(@Param("yearMonth")Date yearMonth, @Param("organizationId")int organizationId,  @Param("opClaIds")HashSet<Integer> opClaIds);
	
	/**
	  * 获取部门年报<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	 * @param opClaIds 
	  * @Title: getYearlyReport <br/>
	  * @return List<AttendNumsVO>    返回类型 <br/>
	  * @date 2015年12月31日 下午8:31:24 <br/>
	  * @throws <br/>
	  *
	 */
	public List<AttendNumsVO> getYearlyReport(@Param("year")Date year, @Param("organizationId")int organizationId, @Param("opClaIds") HashSet<Integer> opClaIds);
}