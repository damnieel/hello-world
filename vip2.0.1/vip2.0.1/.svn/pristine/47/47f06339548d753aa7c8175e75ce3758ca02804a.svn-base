package com.moon.vip.infra.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 类名称：DateUtil.java<br/>
 * 日期：2015年8月26日 下午12:39:23<br/>
 * 类描述：时间日期工具类<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年8月26日 如若 TODO<br/>
 * 
 * @author <a href="mailto:mengxi2011@foxmail.com">Administrator</a><br/>
 * @version 1.0.0
 */
public class DateUtil {
	/**
	 * 日期：2015年8月26日 下午12:40:21<br/>
	 * 描述：计算两个时间差<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午12:40:21 如若 <br/>
	 * 修改备注：TODO<br/>
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 * <br/>
	 *             long
	 */
	public static long getDifference(String startTime, String endTime) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = df.parse(startTime);
		Date d2 = df.parse(endTime);
		return d1.getTime() - d2.getTime();
	}

	/**
	 * 日期：2015年9月29日 下午9:10:31<br/>
	 * 描述：获取当前年月<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午9:10:31 如若 <br/>
	 * 修改备注：TODO<br/>
	 * 
	 * @return<br/> String
	 */
	public static String getYearMonth() {
		int year;
		int month;
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		String date = year + "-" + (month < 10 ? "0" + month : month);
		return date;
	}

	/**
	 * 日期：2015年9月29日 下午9:53:37<br/>
	 * 描述：获取某月的最后一天<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午9:53:37 如若 <br/>
	 * 修改备注：TODO<br/>
	 * 
	 * @param yearMonth
	 * @return<br/> Date
	 */
	public static String getLastDayOfMonth(String yearMonth) {
		Calendar calendar = Calendar.getInstance();
		String[] date = yearMonth.split("-");
		int year = Integer.valueOf(date[0]);
		int month = Integer.valueOf(date[1]);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, lastDay);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfMonth = sdf.format(calendar.getTime());
		return lastDayOfMonth;
	}

	/**
	 * 获得当天0点时间<BR>
	 * 方法名：getTimesMorning<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午4:51:12 <BR>
	 * 
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since 2.0.0
	 */
	public static Date getTimesMorning(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获得当天24点时间<BR>
	 * 方法名：getTimesNight<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午4:51:29 <BR>
	 * 
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since 2.0.0
	 */
	public static Date getTimesNight(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获得本周一0点时间<BR>
	 * 方法名：getWeekStartTime<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午4:53:02 <BR>
	 *
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since 2.0.0
	 */
	public static Date getWeekStartTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
			cal.add(Calendar.DAY_OF_WEEK, -6);
		}else{
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		}
		return cal.getTime();
	}

	/**
	 * 获得本周日24点时间<BR>
	 * 方法名：getWeekEndTime<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午4:53:14 <BR>
	 *
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since 2.0.0
	 */
	public static Date getWeekEndTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getWeekStartTime(date));
		cal.add(Calendar.DAY_OF_WEEK, 7);
		return cal.getTime();
	}

	/**
	 * 获取下一周时间<BR>
	 * 方法名：getNextWeek<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午5:15:45 <BR>
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getNextWeek(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)+7);
		return cal.getTime();
	}
	
	/**
	 * 获取上一周时间<BR>
	 * 方法名：getLastWeek<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午5:16:30 <BR>
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getLastWeek(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)-7);
		return cal.getTime();
	}
	/**
	 * 获得本月第一天0点时间<BR>
	 * 方法名：gettMonthStartTime<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午4:53:35 <BR>
	 * 
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since 2.0.0
	 */
	public static Date getMonthStartTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	/**
	 * 获得本月最后一天24点时间<BR>
	 * 方法名：getMonthEndTime<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午4:54:15 <BR>
	 * 
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since 2.0.0
	 */
	public static Date getMonthEndTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 24);
		return cal.getTime();
	}

	/**
	 * 获取下一个月时间<BR>
	 * 方法名：getNextMonth<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午5:17:16 <BR>
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getNextMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH,1);
		return cal.getTime();
	}
	
	/**
	 * 获取上一个月时间<BR>
	 * 方法名：getLastMonth<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午5:17:16 <BR>
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getLastMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH,-1);
		return cal.getTime();
	}
	
	/**
	 * 当前季度的开始时间<BR>
	 * 方法名：geQuarterStartTime<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午4:55:59 <BR>
	 * 
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since 2.0.0
	 */
	public static Date getQuarterStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				c.set(Calendar.MONTH, 1);
			else if (currentMonth >= 4 && currentMonth <= 6)
				c.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				c.set(Calendar.MONTH, 4);
			else if (currentMonth >= 10 && currentMonth <= 12)
				c.set(Calendar.MONTH, 9);
			c.set(Calendar.DATE, 1);
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前季度的结束时间<BR>
	 * 方法名：getQuarterEndTime<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午4:59:00 <BR>
	 * 
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getQuarterEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				c.set(Calendar.MONTH, 2);
				c.set(Calendar.DATE, 31);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 8);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			c.set(Calendar.DAY_OF_MONTH,c.get(Calendar.DAY_OF_MONTH)+1);
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * 获取下一个季度的时间<BR>
	 * 方法名：getNextQuarter<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午5:20:40 <BR>
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getNextQuarter(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH,3);
		return cal.getTime();
	}
	
	/**
	 * 获取上一个季度的时间<BR>
	 * 方法名：getLastQuarter<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午5:19:57 <BR>
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getLastQuarter(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH,-3);
		return cal.getTime();
	}
	
	/**
	 * 获取一年的开始时间<BR>
	 * 方法名：getYearStartTime<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午6:39:44 <BR>
	 * @param date
	 * @return
	 * @throws ParseException Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getYearStartTime(Date date){
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			now = longSdf.parse(shortSdf.format(date) + "-01-01 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * 获取一年的结束时间<BR>
	 * 方法名：getYearEndTime<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午6:39:26 <BR>
	 * @param date
	 * @return
	 * @throws ParseException Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getYearEndTime(Date date){
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			now = longSdf.parse(shortSdf.format(getNextYear(date)) + "-01-01 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * 获取下一年时间<BR>
	 * 方法名：getNextYear<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午5:22:09 <BR>
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getNextYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.YEAR,cal.get(Calendar.YEAR)+1);
		return cal.getTime();
	}
	
	/**
	 * 获取上一年时间<BR>
	 * 方法名：getLastYear<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午5:22:27 <BR>
	 * @param date
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static Date getLastYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.YEAR,cal.get(Calendar.YEAR)-1);
		return cal.getTime();
	}
	
	/**
	 * 获取一个日期在一年中的第几周<BR>
	 * 方法名：getWeekOfYear<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午12:18:36 <BR>
	 * @param date
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static int getWeekOfYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * 一年中的第几月<BR>
	 * 方法名：getMonthOfYear<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午12:26:44 <BR>
	 * @param date
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static int getMonthOfYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH)+1;
	}
	
	/**
	 * 获取日期年份<BR>
	 * 方法名：getYear<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午3:48:45 <BR>
	 * @param date
	 * @return String<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static String getYear(Date date){
		if(date == null) return null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return df.format(date);
	}
}
