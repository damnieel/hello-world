package com.moon.vip.controller.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.EnumAuthAction;
import com.moon.vip.service.sys.IClearCacheService;
import com.moon.vip.service.sys.IRuleService;

@Controller
@Scope("session")
@RequestMapping("/example")
public class ExampleController extends BaseController {

	private static Logger logger = Logger.getLogger(ExampleController.class);
	
	@Autowired
	private IRuleService ruleService;
	@Autowired
	private IClearCacheService clearCacheService;
	
	@RequestMapping("getAuthForOrgProfessional")
	@ResponseBody
	public HashSet<Integer> getAuthForOrgProfessional(String employeeCode, @RequestParam(value = "roleCodeList[]") String[] roleCodeList) {
		
		return ruleService.getAuthForOrgProfessional(employeeCode, EnumAuthAction.SELECT, Lists.newArrayList(roleCodeList));
	}
	
	@RequestMapping("clearAllCache")
	public void clearAllCache() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<IClearCacheService> clazz = IClearCacheService.class;
		
		for(Method method : clazz.getMethods()) {
			logger.info(String.format("%s方法被调用", method));
			method.invoke(clearCacheService);
		}
//		clearCacheService.clearAuthForOrgProfessional();
	}
}
