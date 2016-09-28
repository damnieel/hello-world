package com.moon.vip.infra.rules;

import java.io.Serializable;

import com.moon.vip.infra.constants.EnumOrder;

/**
 * 类名称：Order.java<br/>
 * 日期：2015年12月29日 上午10:57:41<br/>
 * 类描述：字段排序方式定义<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1112788459871715381L;
	
	public Field field;
	public EnumOrder eOrder;
	
	@Override
	public String toString() {
		return "Order [field=" + field + ", eOrder=" + eOrder + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eOrder == null) ? 0 : eOrder.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
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
		Order other = (Order) obj;
		if (eOrder != other.eOrder)
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		return true;
	}


}