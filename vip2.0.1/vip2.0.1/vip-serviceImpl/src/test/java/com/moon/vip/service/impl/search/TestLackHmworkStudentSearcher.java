package com.moon.vip.service.impl.search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.infra.vo.homework.LackHmworkStudentVO;
import com.moon.vip.infra.vo.search.LackHmworkSearchParams;
import com.moon.vip.service.search.SearchBase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestLackHmworkStudentSearcher {

	@Autowired
	@Qualifier("lackHmworkSearch")
	private SearchBase<LackHmworkSearchParams,LackHmworkStudentVO> seacher;
	
	@Test
	public void testExcuteSearch() throws ParseException{
		LackHmworkSearchParams searchParams = new LackHmworkSearchParams();
		searchParams.setSearchKey("三");
		searchParams.setOrgProCalId(121);
		searchParams.setLackNumber(2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		searchParams.setStartDate(sdf.parse("2015-12-01"));
		searchParams.setEndDate(sdf.parse("2015-12-27"));
		HashSet<Integer> opClaIdsSet = new HashSet<Integer>();
		opClaIdsSet.add(1);
		/*opClaIdsSet.add(190);*/
		searchParams.setOpClaIds(opClaIdsSet);
		System.out.println(seacher.getSearchResultCount(searchParams));
		List<LackHmworkStudentVO>  lackStuVOList = seacher.search(searchParams);
		for(LackHmworkStudentVO lkStuVO : lackStuVOList){
			System.out.println(lkStuVO.toString());
		}
	}
}
