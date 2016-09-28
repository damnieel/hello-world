package com.moon.vip.service.impl.report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.infra.vo.attendance.AttenStatisticVO;
import com.moon.vip.infra.vo.report.ReportVO;
import com.moon.vip.service.report.IReportService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/spring/root-test.xml"})
public class TestAtten {

	@Autowired
	@Qualifier("attendReportService")
	private IReportService<AttenStatisticVO> hmworkRptService;
	
	@Test
	public void testGetWeeklyReport() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date week = df.parse("2015-12-28");
		int organizationId = 121;
		HashSet<Integer> opClaIdsSet = new HashSet<Integer>();
		opClaIdsSet.add(3);
		opClaIdsSet.add(190);
		System.out.println(hmworkRptService.getWeeklyReport(week, organizationId, opClaIdsSet));
	}
	@Test
	public void testGetMonthlyReport() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date yearMonth = df.parse("2015-10-28");
		int organizationId = 1;
		HashSet<Integer> opClaIdsSet = new HashSet<Integer>();
		opClaIdsSet.add(3);
		opClaIdsSet.add(190);
		System.out.println(hmworkRptService.getMonthlyReport(yearMonth, organizationId, opClaIdsSet));
	}
	@Test
	public void testGetYearlyReport() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date year = df.parse("2015-12-28");
		int organizationId = 121;
		HashSet<Integer> opClaIdsSet = new HashSet<Integer>();
		opClaIdsSet.add(3);
		opClaIdsSet.add(190);
		System.out.println(hmworkRptService.getYearlyReport(year, organizationId, opClaIdsSet));
	}
	@Test
	public void testGetTimesRangeReport() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = df.parse("2015-12-21");
		Date endDate = df.parse("2015-12-30");
		int organizationId = 121;
		HashSet<Integer> opClaIdsSet = new HashSet<Integer>();
		opClaIdsSet.add(3);
		opClaIdsSet.add(190);
		System.out.println(hmworkRptService.getTimesRangeReport(startDate, endDate, organizationId, opClaIdsSet));
	}
	
	@Test
	public void testMakeWeeklyReport() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date week = df.parse("2015-12-26");
		int organizationId = 121;
		hmworkRptService.makeWeeklyReport(week, organizationId);
	}
	@Test
	public void testMakeMonthlyReport() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date yearMonth = df.parse("2015-11-26");
		int organizationId = 0;
		hmworkRptService.makeMonthlyReport(yearMonth, organizationId);
	}
	@Test
	public void testYearlyReport() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date year = df.parse("2015-12-26");
		int organizationId = 0;
		hmworkRptService.makeYearlyReport(year, organizationId);
	}
}
