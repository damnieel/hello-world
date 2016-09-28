package com.moon.vip.infra.rules;

import java.io.Serializable;

import com.moon.vip.infra.constants.EnumOperation;
import com.moon.vip.infra.constants.EnumReference;

/**
 * 类名称：Expression.java<br/>
 * 日期：2015年12月29日 上午10:41:28<br/>
 * 类描述：表达式数据结构<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class Expression implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1920113236283872625L;
	
	public Field field;
	public EnumOperation oper;
	public EnumReference reference;
	/**
	 * 当reference为CUSTOM时，存储自定义的值，其他情况为空
	 */
	public CustomReference customRefer;
	@Override
	public String toString() {
		return "Expression [field=" + field + ", oper=" + oper + ", reference=" + reference + ", customRefer="
				+ customRefer + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customRefer == null) ? 0 : customRefer.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((oper == null) ? 0 : oper.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
		Expression other = (Expression) obj;
		if (customRefer == null) {
			if (other.customRefer != null)
				return false;
		} else if (!customRefer.equals(other.customRefer))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (oper != other.oper)
			return false;
		if (reference != other.reference)
			return false;
		return true;
	}

	
}