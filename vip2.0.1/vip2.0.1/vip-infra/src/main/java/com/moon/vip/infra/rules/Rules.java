package com.moon.vip.infra.rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：Rules.java<br/>
 * 日期：2015年12月29日 上午11:00:23<br/>
 * 类描述：规则体结构定义<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class Rules implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 644047521865064638L;
	
	private List<Field> fieldList = new ArrayList<Field>();
	private Principal principal;
	private Condition condition;
	private List<Order> orderList = new ArrayList<Order>();
	private StringBuilder parseResult = new StringBuilder();
	
	public List<Field> getFieldList() {
		return fieldList;
	}
	public void addFieldList(Field field) {
		this.fieldList.add(field);
	}
	public Principal getPrincipal() {
		return principal;
	}
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void addOrderList(Order order) {
		this.orderList.add(order);
	}
	public StringBuilder getParseResult() {
		return parseResult;
	}
	public void appendParseResult(StringBuilder parseResult) {
		this.parseResult.append(parseResult);
	}
	@Override
	public String toString() {
		return "Rules [fieldList=" + fieldList + ", principal=" + principal + ", condition=" + condition
				+ ", orderList=" + orderList + ", parseResult=" + parseResult + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((fieldList == null) ? 0 : fieldList.hashCode());
		result = prime * result + ((orderList == null) ? 0 : orderList.hashCode());
		result = prime * result + ((parseResult == null) ? 0 : parseResult.hashCode());
		result = prime * result + ((principal == null) ? 0 : principal.hashCode());
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
		Rules other = (Rules) obj;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		if (fieldList == null) {
			if (other.fieldList != null)
				return false;
		} else if (!fieldList.equals(other.fieldList))
			return false;
		if (orderList == null) {
			if (other.orderList != null)
				return false;
		} else if (!orderList.equals(other.orderList))
			return false;
		if (parseResult == null) {
			if (other.parseResult != null)
				return false;
		} else if (!parseResult.equals(other.parseResult))
			return false;
		if (principal == null) {
			if (other.principal != null)
				return false;
		} else if (!principal.equals(other.principal))
			return false;
		return true;
	}
	

}