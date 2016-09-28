package com.moon.vip.service.rules;

import com.moon.vip.infra.rules.Rules;


/**
 * 类名称：RulesResolver.java<br/>
 * 日期：2015年12月29日 上午11:10:24<br/>
 * 类描述：规则解析器抽象基类<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public abstract class RulesResolverBase implements IResolverService {

	private IResolverService resolver;

	public void setResolver(IResolverService resolver) {
		this.resolver = resolver;
	}

	public void parse(Rules rules) {
		if(this.resolver != null) {
			this.resolver.parse(rules);
		}
	}
	
}