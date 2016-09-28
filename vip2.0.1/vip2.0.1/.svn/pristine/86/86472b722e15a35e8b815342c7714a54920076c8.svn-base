package com.moon.vip.service.impl.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.infra.vo.report.StuPrefessVO;
import com.moon.vip.infra.vo.search.StuProfessSearchParams;
import com.moon.vip.service.search.SearchBase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/spring/root-test.xml"})
public class TestStuProcessSearcher {

	@Autowired
	@Qualifier("stuProfessSearch")
	private SearchBase<StuProfessSearchParams, StuPrefessVO> stuProfessSeacher;
	
	@Test
	public void testExcuteSearch(){
		StuProfessSearchParams searchParams = new StuProfessSearchParams();
//		searchParams.setSearchKey("三");
		searchParams.setOrgProCalId(3);
		System.out.println(stuProfessSeacher.getSearchResultCount(searchParams));
		System.out.println(stuProfessSeacher.search(searchParams));
	}
}
