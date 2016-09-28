package com.moon.vip.infra.rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.moon.vip.infra.constants.EnumReference;
import com.moon.vip.infra.constants.EnumReplaceType;

/**
 * 类名称：Content.java<br/>
 * 日期：2015年12月31日 下午2:40:43<br/>
 * 类描述：TODO<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月31日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
@SuppressWarnings("rawtypes")
public class Body implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7261638897089176064L;
	
	private EnumReference reference;
	private EnumReplaceType type;
	private List values = new ArrayList();
	
	public EnumReference getReference() {
		return reference;
	}
	public void setReference(EnumReference reference) {
		this.reference = reference;
	}
	public EnumReplaceType getType() {
		return type;
	}
	public void setType(EnumReplaceType type) {
		this.type = type;
	}
	public List getValues() {
		return values;
	}
	@SuppressWarnings("unchecked")
	public void addValues(Object o) {
		this.values.add(o);
	}
	@Override
	public String toString() {
		return "Replace [reference=" + reference + ", type=" + type + ", values=" + values + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((values == null) ? 0 : values.hashCode());
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
		Body other = (Body) obj;
		if (reference != other.reference)
			return false;
		if (type != other.type)
			return false;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}


}