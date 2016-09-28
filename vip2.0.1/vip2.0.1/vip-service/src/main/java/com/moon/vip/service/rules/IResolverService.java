package com.moon.vip.service.rules;

import com.moon.vip.infra.rules.Rules;


/**
 * 类名称：IResolver.java<br/>
 * 日期：2015年12月29日 上午11:05:34<br/>
 * 类描述：规则解析<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public interface IResolverService {

	 /**
	 * 日期：2015年12月29日 上午11:06:24<br/>
	 * 描述：具体规则解析实现<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午11:06:24 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param rules
	 * @return<br/>
	 */
	public void parse(Rules rules);
	
	public void setResolver(IResolverService resolver);

}