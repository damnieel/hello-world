package com.moon.vip.infra.rules;

import java.io.Serializable;

import com.moon.vip.infra.constants.EnumOperation;

/**
 * 类名称：Principal.java<br/>
 * 日期：2015年12月29日 上午10:59:11<br/>
 * 类描述：主体结构定义<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class Principal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7666656467318899855L;
	
	public String alias;
	public String name;
	public EnumOperation oper;
	public String link;
	public Principal principal;
	
	@Override
	public String toString() {
		return "Principal [alias=" + alias + ", name=" + name + ", oper=" + oper + ", link=" + link + ", principal="
				+ principal + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((oper == null) ? 0 : oper.hashCode());
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
		Principal other = (Principal) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (oper != other.oper)
			return false;
		if (principal == null) {
			if (other.principal != null)
				return false;
		} else if (!principal.equals(other.principal))
			return false;
		return true;
	}

}