package com.moon.socket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * 
* @ClassName: WebSocketIntercepter 
* @Description: TODO(连接的拦截器) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月25日 下午4:05:11 
*
 */
public abstract class WebSocketIntercepter extends HttpSessionHandshakeInterceptor {
    private static Logger logger = Logger.getLogger(WebSocketIntercepter.class);
	
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
		logger.info("Before Handshake");
		if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                //使用userName区分WebSocketHandler，以便定向发送消息
                Integer userName = getId(session);
                if(userName == null){
                  return false;	
                }
                attributes.put("socketName",userName);
                
            }
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
	}
	
	   public abstract Integer getId(HttpSession session);
		
	

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
		logger.info("After Handshake");
		super.afterHandshake(request, response, wsHandler, ex);
	}
	

}