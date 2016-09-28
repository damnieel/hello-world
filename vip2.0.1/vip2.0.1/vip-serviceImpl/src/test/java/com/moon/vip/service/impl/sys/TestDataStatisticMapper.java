package com.moon.vip.service.impl.sys;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.application.sys.DataStatisticMapper;
import com.moon.vip.infra.vo.questionnaire.QstStatisticVO;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
import com.moon.vip.infra.vo.sys.ComponentVO;
import com.moon.vip.infra.vo.sys.LearningAimVO;
import com.moon.vip.model.questionnaire.Questionnaire;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestDataStatisticMapper {
	
	
	
	@Autowired 
	private DataStatisticMapper dataStatisticMapper;
	
	@Test
	public void test1(){
		StatisticSearchParams param=new StatisticSearchParams();
		HashSet<Integer> opClaIds=new HashSet<Integer>();
		opClaIds.add(1);
		opClaIds.add(3);
		param.setOrgProCalId(1);
		param.setOpClaIds(opClaIds);
		 ComponentVO  componentVO =	dataStatisticMapper.selectComponentStatistic(param);
		 LearningAimVO learningAimVO=	dataStatisticMapper.selectLearnAimStatistic(param);
		 System.out.println(componentVO);
		 System.out.println(learningAimVO);
	}
	
	@Test
	public void test2(){
		StatisticSearchParams param=new StatisticSearchParams();
		param.setOrgProCalId(1);
		List<QstStatisticVO> list=dataStatisticMapper.selectQuestionStatistic(param);
		System.out.println(list);
	}
}
