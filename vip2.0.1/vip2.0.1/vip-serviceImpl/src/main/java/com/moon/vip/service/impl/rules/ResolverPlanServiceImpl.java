package com.moon.vip.service.impl.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.moon.vip.infra.rules.Rules;
import com.moon.vip.service.rules.IResolverService;
import com.moon.vip.service.rules.IResolverPlanService;


@Service("resolverPlanService")
public class ResolverPlanServiceImpl implements IResolverPlanService {

	@Autowired
	@Qualifier("fieldResolver")
	private IResolverService fieldResolver;
	@Autowired
	@Qualifier("principalResolver")
	private IResolverService principalResolver;
	@Autowired
	@Qualifier("conditionResolver")
	private IResolverService conditionResolver;
	@Autowired
	@Qualifier("orderResolver")
	private IResolverService orderResolver;
	@Autowired
	@Qualifier("plannResolver")
	private IResolverService plannResolver;

	/**
	 * 
	 * @param rules
	 */
	public String resolverJson(String json){
		Rules rules = JSON.parseObject(json, Rules.class);
		fieldResolver.setResolver(plannResolver);
		principalResolver.setResolver(fieldResolver);
		conditionResolver.setResolver(principalResolver);
		orderResolver.setResolver(conditionResolver);
		orderResolver.parse(rules);
		return rules.getParseResult().toString();
	}

}