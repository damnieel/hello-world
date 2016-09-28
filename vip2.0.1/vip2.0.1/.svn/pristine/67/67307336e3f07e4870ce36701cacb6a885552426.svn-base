package com.moon.vip.infra.rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.moon.vip.infra.constants.EnumOperation;

/**
 * 类名称：Condition.java<br/>
 * 日期：2015年12月29日 上午10:28:49<br/>
 * 类描述：规则限定条件<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class Condition implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 611433325298860318L;
	
	private List<Expression> expressionList = new ArrayList<Expression>();
	/**
	 * Expression中操作符
	 */
	private EnumOperation expOper;
	private List<Condition> conditionList = new ArrayList<Condition>();
	/**
	 * 分组操作符
	 */
	private EnumOperation conOper;

	public void addExpressionList(Expression exp) {
		this.expressionList.add(exp);
	}
	
	public List<Expression> getExpressionList() {
		return this.expressionList;
	}

	public EnumOperation getExpOper() {
		return expOper;
	}

	public void setExpOper(EnumOperation expOper) {
		this.expOper = expOper;
	}

	public List<Condition> getConditionList() {
		return conditionList;
	}

	public void addConditionList(Condition condition) {
		this.conditionList.add(condition);
	}

	public EnumOperation getConOper() {
		return conOper;
	}

	public void setConOper(EnumOperation conOper) {
		this.conOper = conOper;
	}

	@Override
	public String toString() {
		return "Condition [expressionList=" + expressionList + ", expOper=" + expOper + ", conditionList="
				+ conditionList + ", conOper=" + conOper + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conOper == null) ? 0 : conOper.hashCode());
		result = prime * result + ((conditionList == null) ? 0 : conditionList.hashCode());
		result = prime * result + ((expOper == null) ? 0 : expOper.hashCode());
		result = prime * result + ((expressionList == null) ? 0 : expressionList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condition other = (Condition) obj;
		if (conOper != other.conOper)
			return false;
		if (conditionList == null) {
			if (other.conditionList != null)
				return false;
		} else if (!conditionList.equals(other.conditionList))
			return false;
		if (expOper != other.expOper)
			return false;
		if (expressionList == null) {
			if (other.expressionList != null)
				return false;
		} else if (!expressionList.equals(other.expressionList))
			return false;
		return true;
	}

	
}