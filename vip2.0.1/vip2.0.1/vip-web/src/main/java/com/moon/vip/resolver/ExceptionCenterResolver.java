package com.moon.vip.resolver;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.exception.BusinessException;

/**
 * 类名称：ExceptionInterceptor.java<br/>
 * 日期：2016年4月14日 下午9:00:41<br/>
 * 类描述：异常拦截器<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年4月14日 Roy TODO<br/>
 * 
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class ExceptionCenterResolver extends ExceptionHandlerExceptionResolver {

	private static Logger logger = Logger.getLogger(ExceptionCenterResolver.class);
	
	private String defaultErrorView;
	private AbstractJackson2HttpMessageConverter messageConverter;

	protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response,
			HandlerMethod handlerMethod, Exception exception) {

		Message message = new Message();
		if(exception instanceof BusinessException) {
			BusinessException be = (BusinessException) exception;
			message.setCode(be.getCode());
			message.setMsg(be.getMessage());
		} 
		//TODO 可添加其他异常类型
		else {
			message.setCode("E00000");
			message.setMsg("未知系统异常,请联系管理员");
		}
		logger.error(exception);
		//处理ajax请求
		if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ 
			try {
				writeMessage(request, response, message);
			} catch (IOException e) {
				logger.error(e);
			}
			return new ModelAndView();
		}
		//返回错误信息到页面
		ModelAndView view = new ModelAndView(this.getDefaultErrorView());
		view.addObject("message", message);
		return view;

	}

	private void writeMessage(HttpServletRequest request, HttpServletResponse response, Message message)
			throws IOException {
		HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
		messageConverter.write(message, MediaType.APPLICATION_JSON, outputMessage);
	}

	public String getDefaultErrorView() {
		return defaultErrorView;
	}

	public void setDefaultErrorView(String defaultErrorView) {
		this.defaultErrorView = defaultErrorView;
	}
	
	public AbstractJackson2HttpMessageConverter getMessageConverter() {
		return messageConverter;
	}

	public void setMessageConverter(AbstractJackson2HttpMessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}
}
