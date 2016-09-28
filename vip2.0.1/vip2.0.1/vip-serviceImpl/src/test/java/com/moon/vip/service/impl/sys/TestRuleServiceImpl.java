package com.moon.vip.service.impl.sys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
import com.moon.vip.infra.constants.EnumAuthAction;
import com.moon.vip.service.sys.IRuleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestRuleServiceImpl {

	@Autowired
	@Qualifier("ruleService")
	private IRuleService ruleService;
	
	@Test
	public void testGetAuthForOrgProfessional() {
		//超级管理员查询权限
//		ruleService.getAuthForOrgProfessional("01053", EnumAuthAction.SELECT, Lists.newArrayList("super"));
		ruleService.getAuthForOrgProfessional("01053", EnumAuthAction.SELECT, Lists.newArrayList("orgLeader"));
	}
}
