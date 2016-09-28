package com.moon.vip.infra.vo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.infra.vo.search.LackHmworkSearchParams;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestLackHworkSearchParams {
	
	@Test
	public void testToString(){
		LackHmworkSearchParams lhworkSearchParams = new LackHmworkSearchParams();
		System.out.println(lhworkSearchParams.toString()); 
	}

}
