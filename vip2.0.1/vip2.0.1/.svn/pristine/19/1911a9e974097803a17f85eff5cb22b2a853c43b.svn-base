package com.moon.vip.service.impl.rules;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
import com.moon.vip.application.sys.DataRuleSqlMapper;
import com.moon.vip.application.sys.RuleSqlMapper;
import com.moon.vip.infra.constants.EnumReference;
import com.moon.vip.service.rules.IResolverPlanService;
import com.moon.vip.service.rules.ISubscriberReplaceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:META-INF/spring/root-test.xml"})
public class TestSubscriberReplaceImpl {
	
	@Autowired
	@Qualifier("resolverPlanService")
	private IResolverPlanService resolverPlanService;
	@Autowired
	@Qualifier("subscriberReplaceService")
	private ISubscriberReplaceService subscriberReplaceService;
	
	@Autowired
	private RuleSqlMapper ruleSqlMapper;
	@Autowired
	private DataRuleSqlMapper dataRuleSqlMapper;
	
	@Test
	public void testExcute() {
		//班主任数据权限获取json
//		String json = "{\"condition\":{\"expressionList\":[{\"field\":{\"field\":\"manager.type\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_ADVISER\"},{\"field\":{\"field\":\"manager.employee_code\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_EMPLOYEE\"},{\"field\":{\"field\":\"op.is_valid\"},\"oper\":\"EQUAL\",\"reference\":\"CUSTOM\",\"customRefer\":{\"type\":\"STRING\",\"values\":[\"Y\"]}}], \"expOper\" : \"AND\", \"conditionList\" : [], \"conOper\" : \"OR\"},\"fieldList\":[{\"field\":\"op.ID\"}],\"order\":{\"field\":{\"field\":\"op.ID\"},\"order\":\"ASC\"},\"principal\":{\"alias\":\"op\",\"link\":\"op.ID\",\"name\":\"vip_organizational_professional\",\"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"manager\",\"link\":\"manager.op_id\",\"name\":\"vip_OP_manager\", \"oper\":\"LEFT_JOIN\"}}}";
		//包含条件分组的班主任数据权限获取json
//		String json = "{\"condition\":{\"expressionList\":[{\"field\":{\"field\":\"manager.type\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_ADVISER\"},{\"field\":{\"field\":\"manager.employee_code\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_EMPLOYEE\"}], \"expOper\" : \"AND\", \"conditionList\" : [{\"expressionList\":[{\"field\":{\"field\":\"op.is_valid\"},\"oper\":\"EQUAL\",\"reference\":\"CUSTOM\",\"customRefer\":{\"type\":\"STRING\",\"values\":[\"Y\"]}}], \"expOper\" : \"AND\", \"conditionList\" : [], \"conOper\" : \"OR\"}], \"conOper\" : \"AND\"},\"fieldList\":[{\"field\":\"op.ID\"}],\"order\":{\"field\":{\"field\":\"op.ID\"},\"order\":\"ASC\"},\"principal\":{\"alias\":\"op\",\"link\":\"op.ID\",\"name\":\"vip_organizational_professional\",\"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"manager\",\"link\":\"manager.op_id\",\"name\":\"vip_OP_manager\", \"oper\":\"LEFT_JOIN\"}}}";
		//包含条件分组的班主任数据权限获取json,多值
		//String json = "{\"condition\":{\"expressionList\":[{\"field\":{\"field\":\"manager.type\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_ADVISER\"},{\"field\":{\"field\":\"manager.employee_code\"},\"oper\":\"IN\",\"reference\":\"CURRENT_EMPLOYEE\"}], \"expOper\" : \"AND\", \"conditionList\" : [{\"expressionList\":[{\"field\":{\"field\":\"op.is_valid\"},\"oper\":\"IN\",\"reference\":\"CUSTOM\",\"customRefer\":{\"type\":\"STRING\",\"values\":[\"Y\", \"N\"]}}], \"expOper\" : \"AND\", \"conditionList\" : [], \"conOper\" : \"OR\"}], \"conOper\" : \"AND\"},\"fieldList\":[{\"field\":\"op.ID\"}],\"order\":{\"field\":{\"field\":\"op.ID\"},\"order\":\"ASC\"},\"principal\":{\"alias\":\"op\",\"link\":\"op.ID\",\"name\":\"vip_organizational_professional\",\"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"manager\",\"link\":\"manager.op_id\",\"name\":\"vip_OP_manager\", \"oper\":\"LEFT_JOIN\"}}}";
		
//		String json = "{\"condition\":{\"expressionList\":[{\"field\":{\"field\":\"leader.employee_code\"},\"oper\":\"IN\",\"reference\":\"CURRENT_EMPLOYEE\"}], \"expOper\" : \"AND\", \"conditionList\" : [{\"expressionList\":[{\"field\":{\"field\":\"op.is_valid\"},\"oper\":\"IN\",\"reference\":\"CUSTOM\",\"customRefer\":{\"type\":\"STRING\",\"values\":[\"Y\", \"N\"]}}], \"expOper\" : \"AND\", \"conditionList\" : [], \"conOper\" : \"OR\"}], \"conOper\" : \"AND\"},\"fieldList\":[{\"field\":\"op.ID\"}],\"order\":{\"field\":{\"field\":\"op.ID\"},\"order\":\"ASC\"},\"principal\":{\"alias\":\"op\",\"link\":\"op.ID\",\"name\":\"vip_organizational_professional\",\"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"leader\",\"link\":\"leader.op_id\",\"name\":\"vip_OP_leader\", \"oper\":\"LEFT_JOIN\"}}}";
		//包含ALL条件解析
		String json = "{\"condition\":{\"expressionList\":[{\"field\":{\"field\":\"op.ID\"},\"oper\":\"IN\",\"reference\":\"ALL\"}], \"expOper\" : \"AND\", \"conditionList\" : [{\"expressionList\":[{\"field\":{\"field\":\"op.is_valid\"},\"oper\":\"IN\",\"reference\":\"CUSTOM\",\"customRefer\":{\"type\":\"STRING\",\"values\":[\"Y\"]}}], \"expOper\" : \"AND\", \"conditionList\" : [], \"conOper\" : \"OR\"}], \"conOper\" : \"AND\"},\"fieldList\":[{\"field\":\"op.ID\"}],\"order\":{\"field\":{\"field\":\"op.ID\"},\"order\":\"ASC\"},\"principal\":{\"alias\":\"op\",\"link\":\"op.ID\",\"name\":\"vip_organizational_professional\",\"oper\":\"LEFT_JOIN\",\"principal\":{}}}";
		//自定义解析
//		String json = "{\"condition\":{\"expressionList\":[{\"field\":{\"field\":\"op.ID\"},\"oper\":\"IN\",\"reference\":\"CUSTOM\",\"customRefer\":{\"type\":\"INTEGER\",\"values\":[3,5]}}], \"expOper\" : \"AND\", \"conditionList\" : [{\"expressionList\":[{\"field\":{\"field\":\"op.is_valid\"},\"oper\":\"IN\",\"reference\":\"CUSTOM\",\"customRefer\":{\"type\":\"STRING\",\"values\":[\"Y\"]}}], \"expOper\" : \"AND\", \"conditionList\" : [], \"conOper\" : \"OR\"}], \"conOper\" : \"AND\"},\"fieldList\":[{\"field\":\"op.ID\"}],\"order\":{\"field\":{\"field\":\"op.ID\"},\"order\":\"ASC\"},\"principal\":{\"alias\":\"op\",\"link\":\"op.ID\",\"name\":\"vip_organizational_professional\",\"oper\":\"LEFT_JOIN\",\"principal\":{}}}";
		String sql = resolverPlanService.resolverJson(json);
		System.out.println(sql);

		String result = subscriberReplaceService.createReplaceContent(sql)
				.setString(EnumReference.CURRENT_ADVISER, "adviser")
				.setString(EnumReference.CURRENT_EMPLOYEE, "00001").excute();
		System.out.println(result);
		result = result.replaceAll("and \\(1 = 1 \\)", "");
		System.out.println("替换之后的sql： " + result);
		List<Map<String, Object>> ruleList = ruleSqlMapper.excutRule(result);
		for(Map<String, Object> map : ruleList) {
			for(String key : map.keySet()) {
				System.out.println(String.format("key: %s, value: %s", key, map.get(key)));
			}
		}
	}
	
	@Test
	public void testRuleContent() {
		List<String> ruleList = dataRuleSqlMapper.selectByRoleActionType("select",  Lists.newArrayList("adviser"));
		for(String rule :ruleList) {
			System.out.println(rule);
		}
	}
}