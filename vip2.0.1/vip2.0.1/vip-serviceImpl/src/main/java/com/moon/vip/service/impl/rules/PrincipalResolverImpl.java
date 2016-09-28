package com.moon.vip.service.impl.rules;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.rules.Principal;
import com.moon.vip.infra.rules.Rules;
import com.moon.vip.infra.util.StringUtil;
import com.moon.vip.service.rules.RulesResolverBase;

/**
 * 类名称：PrincipalResolverImpl.java<br/>
 * 日期：2015年12月29日 下午12:31:16<br/>
 * 类描述：主体解析器<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
@Service("principalResolver")
public class PrincipalResolverImpl extends RulesResolverBase {

	private static Logger logger = Logger.getLogger(PrincipalResolverImpl.class);
	
	public void parse(Rules rules){
		super.parse(rules);
		Principal t = rules.getPrincipal();
		checkPrincipal(t);
		StringBuilder sb = new StringBuilder();
		sb.append(" FROM ");
		sb.append(t.name).append(" ").append(t.alias).append(" ");
		if(t.principal != null && t.principal.name != null) {
			packagingPrincial(t, t.principal, sb);
		}
		logger.info(String.format("Principal解析器，解析结果为: %s", sb.toString()));
		rules.appendParseResult(sb);
	}

	private void packagingPrincial(Principal source, Principal child, StringBuilder sb) {

		checkPrincipal(child);
		sb.append(source.oper.key).append(" ");
		sb.append(child.name).append(" ").append(child.alias).append(" ");
		if (StringUtil.isNull(source.link) || StringUtil.isNull(child.link)) {
			throw new BusinessException(EnumCodeException.E0105);
		}
		sb.append(" on ").append(source.link).append(" = ").append(child.link).append(" ");
		if(child.principal != null) {
			packagingPrincial(child, child.principal, sb);
		}
	}

	private void checkPrincipal(Principal t) {
		if(t == null || StringUtil.isNull(t.name)) {
			throw new BusinessException(EnumCodeException.E0103);
		}
		if(StringUtil.isNull(t.alias)) {
			throw new BusinessException(EnumCodeException.E0104);
		}
	}
	
	public static void main(String[] args) {
		PrincipalResolverImpl resolver = new PrincipalResolverImpl();
		String json = "{\"condition\":{\"expressionList\":[{\"field\":{\"field\":\"type\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_TEACHER\"},{\"field\":{\"field\":\"employee_code\"},\"oper\":\"EQUAL\",\"reference\":\"CUSTOM\"}], \"expOper\" : \"AND\", \"conditionList\" : [{\"expressionList\":[{\"field\":{\"field\":\"type1\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_TEACHER\"},{\"field\":{\"field\":\"employee_code1\"},\"oper\":\"EQUAL\",\"reference\":\"CUSTOM\"}], \"expOper\" : \"OR\", \"conditionList\" : []}], \"conOper\" : \"OR\"},\"fieldList\":[{\"field\":\"op.ID\"}],\"order\":{\"field\":{\"field\":\"op.ID\"},\"order\":\"ASC\"},\"principal\":{\"alias\":\"op\",\"link\":\"op.ID\",\"name\":\"vip_organizational_professional\",\"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"manager\",\"link\":\"manager.op_id\",\"name\":\"vip_OP_manager\", \"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"mana\",\"link\":\"mana.op_id\",\"name\":\"vip_OP_manager\"}}}}";
		Rules rules = JSON.parseObject(json, Rules.class);
		System.out.println(rules);
		resolver.parse(rules);
	}

}