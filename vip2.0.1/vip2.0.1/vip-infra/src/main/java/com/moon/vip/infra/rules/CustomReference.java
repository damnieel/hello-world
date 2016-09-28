package com.moon.vip.infra.rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.moon.vip.infra.constants.EnumReplaceType;
import com.moon.vip.infra.constants.IsValidType;

/**
 * 类名称：CustomReference.java<br/>
 * 日期：2016年1月5日 下午2:19:08<br/>
 * 类描述：自定义引用类型时，值存储结构<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年1月5日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
@SuppressWarnings("rawtypes")
public class CustomReference implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -55605785196024549L;
	
	public EnumReplaceType type;
	private List values = new ArrayList();
	
	@SuppressWarnings("unchecked")
	public void addValues(Object obj) {
		values.add(obj);
	}
	
	public List getValues() {
		return this.values;
	}

	@Override
	public String toString() {
		return "CustomReference [type=" + type + ", values=" + values + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		CustomReference other = (CustomReference) obj;
		if (type != other.type)
			return false;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		CustomReference refer = new CustomReference();
		refer.type = EnumReplaceType.STRING;
		refer.addValues(IsValidType.Y_VALUE);
		System.out.println(JSON.toJSONString(refer));
	}
}