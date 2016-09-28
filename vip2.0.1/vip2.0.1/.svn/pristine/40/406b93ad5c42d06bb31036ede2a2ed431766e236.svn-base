package com.moon.vip.service.impl.rules;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.EnumOperation;
import com.moon.vip.infra.constants.EnumReference;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.rules.Condition;
import com.moon.vip.infra.rules.Expression;
import com.moon.vip.infra.rules.Rules;
import com.moon.vip.infra.util.RuleUtil;
import com.moon.vip.infra.util.StringUtil;
import com.moon.vip.service.rules.RulesResolverBase;

/**
 * 类名称：ConditionResolverImpl.java<br/>
 * 日期：2015年12月29日 上午11:26:54<br/>
 * 类描述：条件解析器<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
@Service("conditionResolver")
public class ConditionResolverImpl extends RulesResolverBase {

	private static Logger logger = Logger.getLogger(ConditionResolverImpl.class);
	
	public void parse(Rules rules){
		super.parse(rules);
		Condition t = rules.getCondition();
		StringBuilder sb = new StringBuilder();
		sb.append(" WHERE 1 = 1 ");
		if(t.getExpressionList() == null || t.getExpressionList().size() == 0) {
			return;
		}
		sb.append(" and ");
		parseExpression(t, sb);
		logger.info(String.format("Condition解析器，解析结果为: %s", sb.toString()));
		rules.appendParseResult(sb);
	}

	private void parseExpression(Condition t, StringBuilder sb) {
		List<Expression> expList = t.getExpressionList();
		checkOper(t.getExpOper());
		for(int i = 0; i < expList.size(); i++) {
			Expression exp = expList.get(i);
			if(i == 0) {
				sb.append("(");
			}
			if(StringUtil.isNull(exp.field.field)) {
				throw new BusinessException(EnumCodeException.E0106);
			}
			if(EnumReference.ALL.type.equals(exp.reference.type)) {
				sb.append("1 = 1 ");
				appendEnd(sb, expList, i);
				continue;
			}
			sb.append(exp.field.field).append(" ").append(exp.oper.key).append(" ");
			packagingValuesByOper(sb, exp);
			if(i < expList.size() - 1) {//添加操作条件
				sb.append(t.getExpOper().key).append(" ");
			}
			appendEnd(sb, expList, i);
		}
		if(t.getConditionList() != null && t.getConditionList().size() != 0) {
			List<Condition> conditionList = t.getConditionList();
			for(Condition condition : conditionList) {
				if(condition.getConditionList() != null && condition.getConditionList().size() != 0) {
					checkOper(t.getConOper());
				}
				sb.append(" ").append(t.getConOper().key).append(" ");
				parseExpression(condition, sb);
			}
		}
	}

	public void appendEnd(StringBuilder sb, List<Expression> expList, int i) {
		if(i == expList.size() - 1 && sb.indexOf("(") != -1) {
			sb.append(")");
		}
	}

	 /**
	 * 日期：2016年1月5日 下午6:18:13<br/>
	 * 描述：操作符为in或not in的值添加括号进行包裹<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午6:18:13 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param sb
	 * @param exp
	 * @return<br/>
	 * boolean
	 */
	public boolean packagingValuesByOper(StringBuilder sb, Expression exp) {
		boolean isAppend = false;
		switch (exp.oper) {
		case IN:
			sb.append("(");
			isAppend = true;
			break;
		case NOT_IN:
			sb.append("(");
			isAppend = true;
			break;
		default:
			break;
		}
		if(EnumReference.CUSTOM.type.equals(exp.reference.type)) {
			//值数量大于1且操作符不是in或not in
			if(exp.customRefer.getValues().size() > 1 ) {
				if(!EnumOperation.IN.key.equals(exp.oper.key) && !EnumOperation.NOT_IN.key.equals(exp.oper.key)) {
					throw new BusinessException(EnumCodeException.E0115);
				}
			}
			sb.append(RuleUtil.listToParams(exp.customRefer.type, exp.customRefer.getValues()));
		} else {
			sb.append(exp.reference.type).append(" ");
		}
		if(isAppend) {
			sb.append(")");
		}
		return isAppend;
	}

	private void checkOper(EnumOperation oper) {
		if(oper == null) {
			throw new BusinessException(EnumCodeException.E0107);
		}
	}

	public static void main(String[] args) {
		ConditionResolverImpl resolver = new ConditionResolverImpl();
		String json = "{\"condition\":{\"expressionList\":[{\"field\":{\"field\":\"type\"},\"oper\":\"EQUAL\",\"reference\":\"ALL\"},{\"field\":{\"field\":\"employee_code\"},\"oper\":\"EQUAL\",\"reference\":\"CUSTOM\"}], \"expOper\" : \"AND\", \"conditionList\" : [{\"expressionList\":[{\"field\":{\"field\":\"type1\"},\"oper\":\"EQUAL\",\"reference\":\"CURRENT_TEACHER\"},{\"field\":{\"field\":\"employee_code1\"},\"oper\":\"EQUAL\",\"reference\":\"CUSTOM\"}], \"expOper\" : \"OR\", \"conditionList\" : []}], \"conOper\" : \"OR\"},\"fieldList\":[{\"field\":\"op.ID\"}],\"order\":{\"field\":{\"field\":\"op.ID\"},\"order\":\"ASC\"},\"principal\":{\"alias\":\"op\",\"link\":\"op.ID\",\"name\":\"vip_organizational_professional\",\"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"manager\",\"link\":\"manager.op_id\",\"name\":\"vip_OP_manager\", \"oper\":\"LEFT_JOIN\",\"principal\":{\"alias\":\"mana\",\"link\":\"mana.op_id\",\"name\":\"vip_OP_manager\"}}}}";
		Rules rules = JSON.parseObject(json, Rules.class);
		resolver.parse(rules);
		System.out.println(rules);
	}
}