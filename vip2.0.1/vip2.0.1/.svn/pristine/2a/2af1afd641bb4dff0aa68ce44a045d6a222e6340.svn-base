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

import com.moon.vip.infra.vo.report.ReportVO;
import com.moon.vip.service.report.IReportService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:META-INF/spring/root-test.xml"})
public class TestLeaveSchoolRptServiceImpl {
	@Autowired
	@Qualifier("leaveSchoolRptService")
	private IReportService<ReportVO> lSchlRptService;
	
	@Test
	public void testGetTimesRangeReport() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse("2015-06-12");
		Date endDate = sdf.parse("2015-12-29");
		int organizationId =1;
		HashSet<Integer> opClaIdsSet = new HashSet<Integer>();
		opClaIdsSet.add(3);
		opClaIdsSet.add(190);
		System.out.println(lSchlRptService.getTimesRangeReport(startDate, endDate, organizationId, opClaIdsSet).toString());
	}
	
	@Test
	public void testGetMonthlyReport() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date YearMonth = sdf.parse("2015-12-12");
		int organizationId =1;
		HashSet<Integer> opClaIdsSet = new HashSet<Integer>();
		opClaIdsSet.add(3);
		opClaIdsSet.add(190);
		System.out.println(lSchlRptService.getMonthlyReport(YearMonth, organizationId, opClaIdsSet).toString());
	}
	
	@Test
	public void testGetWeeklyReport() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date year = sdf.parse("2015-12-28");
		int organizationId =1;
		HashSet<Integer> opClaIdsSet = new HashSet<Integer>();
		opClaIdsSet.add(3);
		opClaIdsSet.add(190);
		System.out.println(lSchlRptService.getWeeklyReport(year, organizationId, opClaIdsSet).toString());
	}
}
