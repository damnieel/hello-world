package com.moon.vip.controller;

import java.io.IOException;
import java.util.Map;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.moon.vip.infra.vo.EmployeeLoginVO;

/**
 * 
 * @ClassName: ExceptionCatchController 
 * @Description: TODO(异常捕捉公用类) 
 * @author 大枫
 * @date 2016年2月15日 下午2:41:53 
 *
 */
@ControllerAdvice
public class ExceptionCatchController extends BaseController{

//	private Logger logger = Logger.getLogger(ExceptionCatchController.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) throws IOException {
		ModelAndView mav = new ModelAndView();
		e.printStackTrace();
		String eJson = (String) JSON.toJSON(e).toString();
		EmployeeLoginVO employee = getUserInfo();
		
		mav.addObject("error", eJson);
		String errorInfo = String.format("用户（%s）发起请求（%s）异常", 
				employee.getEmployeeCode(), getRequest().getRequestURL().toString());
		
//		Map<Object , Object> map = getRequest().getParameterMap();
//		if(map !=null && map.size() > 0) {
//			errorInfo += "参数： ";
//			for(Object keySet:map.keySet()) {
//				errorInfo += keySet.toString() + "-" + map.get(keySet) + "\n"; 
//			}
//		}
//		
		mav.addObject("errorInfo", errorInfo);
		mav.setViewName("/page/error/error");
		return mav;
	}
}
