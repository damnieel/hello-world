package com.moon.socket;

import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * 
* @ClassName: CustomSocketConfig 
* @Description: TODO(获取登录者ID，作为唯一标识) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月25日 下午4:01:17 
*
 */

public class CustomSocketConfig extends WebSocketIntercepter {
	private static Logger logger = Logger.getLogger(CustomSocketConfig.class);
	
   private String sessionkey;
   public void setSessionkey(String sessionkey) {
	this.sessionkey = sessionkey;
   }
	public CustomSocketConfig(Properties pro){
		if(pro != null)
		 setSessionkey(pro.getProperty("sessionkey","userId"));
		else{
	     logger.warn("CustomSocketConfig 执行默认配置");
		 setSessionkey("userId");
		}
	} 
	@Override
	public Integer getId(HttpSession session) {
		Integer id =(Integer) session.getAttribute(sessionkey);
		logger.info(String.format("用户[%s]正在尝试连接",id));
		return id;
	}
}
