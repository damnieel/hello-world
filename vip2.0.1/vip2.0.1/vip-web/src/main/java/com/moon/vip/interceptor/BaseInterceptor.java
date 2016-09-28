package com.moon.vip.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.moon.vip.controller.BaseController;
import com.moon.vip.controller.ControllerContext;
/**
 * 
* @ClassName: BaseInterceptor 
* @Description: TODO(拦截器，将请求对象注入controllerContext) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月24日 下午3:38:56 
*
 */
public class BaseInterceptor  extends HandlerInterceptorAdapter{
	 public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler)
		        throws Exception {
		     if (handler instanceof BaseController) {
		     }
		     //注入Request/Response对象至SpringMVC执行上下文对象中
		      ControllerContext.getContext().setRequest(httpServletRequest);
		      ControllerContext.getContext().setResponse(httpServletResponse);
		     return super.preHandle(httpServletRequest, httpServletResponse, handler);
		   }
		}