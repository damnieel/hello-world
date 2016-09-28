package com.moon.vip.service.rules;

import java.io.Serializable;

import com.moon.vip.infra.rules.Body;

/**
 * 类名称：MaterialSubscriber.java<br/>
 * 日期：2015年12月31日 下午5:17:48<br/>
 * 类描述：替换服务提供者工作所需资源<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月31日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class ResourceSubscriber implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3362354070603218337L;
	
	private IReplaceService replaceService;
	private Body body;
	
	public IReplaceService getReplaceService() {
		return replaceService;
	}
	public void setReplaceService(IReplaceService replaceService) {
		this.replaceService = replaceService;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "ResourceSubscriber [replaceService=" + replaceService + ", body=" + body + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((replaceService == null) ? 0 : replaceService.hashCode());
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
		ResourceSubscriber other = (ResourceSubscriber) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (replaceService == null) {
			if (other.replaceService != null)
				return false;
		} else if (!replaceService.equals(other.replaceService))
			return false;
		return true;
	}
	
	
}
