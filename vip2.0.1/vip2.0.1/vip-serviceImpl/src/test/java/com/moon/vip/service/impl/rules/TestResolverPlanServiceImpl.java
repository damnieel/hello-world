package com.moon.vip.service.impl.rules;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.service.rules.IResolverPlanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:META-INF/spring/root-test.xml"})
public class TestResolverPlanServiceImpl {

	@Autowired
	@Qualifier("resolverPlanService")
	private IResolverPlanService resolverPlanService;
	
	@Test
	public void testResolverJson() {
		//略复杂json串解析
		//String json = "{\"condition\":{\"expressionList\":[{\"field\":{\"field\":\"type\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_TEACHER\"},{\"field\":{\"field\":\"employee_code\"},\"oper\":\"EQUAL\",\"reference\":\"CUSTOM\"}], \"expOper\" : \"AND\", \"conditionList\" : [{\"expressionList\":[{\"field\":{\"field\":\"type1\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_TEACHER\"},{\"field\":{\"field\":\"employee_code1\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_EMPLOYEE\"}], \"expOper\" : \"OR\", \"conditionList\" : []}], \"conOper\" : \"OR\"},\"fieldList\":[{\"field\":\"op.ID\"}],\"order\":{\"field\":{\"field\":\"op.ID\"},\"order\":\"ASC\"},\"principal\":{\"alias\":\"op\",\"link\":\"op.ID\",\"name\":\"vip_organizational_professional\",\"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"manager\",\"link\":\"manager.op_id\",\"name\":\"vip_OP_manager\", \"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"mana\",\"link\":\"mana.op_id\",\"name\":\"vip_OP_manager\"}}}}";
		//班主任数据权限获取json
		String json = "{\"condition\":{\"expressionList\":[{\"field\":{\"field\":\"manager.type\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_TEACHER\"},{\"field\":{\"field\":\"manager.employee_code\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_EMPLOYEE\"},{\"field\":{\"field\":\"op.is_valid\"},\"oper\":\"EQUAL\",\"reference\":\"CUSTOM\",\"customRefer\":{\"type\":\"STRING\",\"values\":[\"Y\"]}}], \"expOper\" : \"AND\", \"conditionList\" : [], \"conOper\" : \"OR\"},\"fieldList\":[{\"field\":\"op.ID\"}],\"order\":{\"field\":{\"field\":\"op.ID\"},\"order\":\"ASC\"},\"principal\":{\"alias\":\"op\",\"link\":\"op.ID\",\"name\":\"vip_organizational_professional\",\"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"manager\",\"link\":\"manager.op_id\",\"name\":\"vip_OP_manager\", \"oper\":\"LEFT_JOIN\"}}}";
		String content = resolverPlanService.resolverJson(json);
		System.out.println(content);
	}
}
