package com.moon.vip.infra.rules;

import java.io.Serializable;

/**
 * 类名称：Field.java<br/>
 * 日期：2015年12月29日 上午10:42:19<br/>
 * 类描述：字段定义<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class Field implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -391051111562470122L;
	
	public String field;

	@Override
	public String toString() {
		return "Field [field=" + field + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Field other = (Field) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		return true;
	}

	
}