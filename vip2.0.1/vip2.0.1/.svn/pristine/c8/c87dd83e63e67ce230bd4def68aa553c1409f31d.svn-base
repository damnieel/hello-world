package com.moon.vip.infra.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestDateUtil {
	
	@Test
	public void testDateUtil() throws ParseException{
		Date currentDate = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当前时间0点:"+df.format(DateUtil.getTimesMorning(currentDate)));
		System.out.println("当前时间24点:"+df.format(DateUtil.getTimesNight(currentDate)));
		System.out.println("周开始时间："+df.format(DateUtil.getWeekStartTime(currentDate)));
		System.out.println("周结束时间："+df.format(DateUtil.getWeekEndTime(currentDate)));
		System.out.println("月开始时间："+df.format(DateUtil.getMonthStartTime(currentDate)));
		System.out.println("月结束时间："+df.format(DateUtil.getMonthEndTime(currentDate)));
		System.out.println("季度开始："+df.format(DateUtil.getQuarterStartTime(currentDate)));
		System.out.println("季度结束："+df.format(DateUtil.getQuarterEndTime(currentDate)));
		System.out.println("下一周："+df.format(DateUtil.getNextWeek(currentDate)));
		System.out.println("上一周："+df.format(DateUtil.getLastWeek(currentDate)));
		System.out.println("下一个月："+df.format(DateUtil.getNextMonth(currentDate)));
		System.out.println("上一个月："+df.format(DateUtil.getLastMonth(currentDate)));
		System.out.println("下一个季度："+df.format(DateUtil.getNextQuarter(currentDate)));
		System.out.println("上一个季度"+df.format(DateUtil.getLastQuarter(currentDate)));
		System.out.println("下一年："+df.format(DateUtil.getNextYear(currentDate)));
		System.out.println("上一年："+df.format(DateUtil.getLastYear(currentDate)));
		System.out.println("年初："+df.format(DateUtil.getYearStartTime(currentDate)));
		System.out.println("年末："+df.format(DateUtil.getYearEndTime(currentDate)));
		
		System.out.println("WeekOfYear："+DateUtil.getWeekOfYear(df.parse("2015-12-28 00:00:00")));
		System.out.println("MonthOfYear："+DateUtil.getMonthOfYear(currentDate));
	}

}
