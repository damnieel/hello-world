package com.moon.socket;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
/**
 * 
* @ClassName: WebSocketConfig 
* @Description: TODO(实现webSocket 必须实现的配置类) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月25日 下午4:03:03 
*
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	private static final Logger  logger = Logger.getLogger(WebSocketConfig.class);
	private static final String serve = "/websocket/chatMessageServer.htmls";
	private static final String jsServe = "/sockjs/chatMessageServer.htmls";
	private String socketConfig;
	private Properties pro;
	private String serverName;
	private String jsServerName;
	public void setPro(Properties pro) {
		this.pro = pro;
	}
	public void setSocketConfig(String socketConfig) {
		this.socketConfig = socketConfig;
	}
	public void init(){
		try {
			setPro(new PropertiesInit(socketConfig).getPro());
			readPro();
			logger.info("获取配置文件。。。");
		} catch (Exception e) {
		    logger.warn("配置文件读取失败,执行默认配置");
			setPro(null);
			readPro();
		}
	}
	public void readPro(){
		if(pro != null){
			serverName = pro.getProperty("serve",serve);
			jsServerName = pro.getProperty("jsServe",jsServe);
		}
		else{
			serverName = serve;
		}   jsServerName = jsServe;
	}
	
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    	logger.info(String.format("服务端地址[%s]", serverName));
    	logger.info(String.format("js服务端地址[%s]", jsServerName));
    	registry.addHandler(chatMessageHandler(),serverName).addInterceptors(getInterceter());
    	registry.addHandler(chatMessageHandler(), jsServerName).addInterceptors(getInterceter()).withSockJS();
    	logger.info("创建websocket成功");
    }
    
    @Bean
    public WebsocketEndPoint chatMessageHandler(){
         return new WebsocketEndPoint(pro);
    }
    @Bean
    public CustomSocketConfig getInterceter(){
    	return new CustomSocketConfig(pro);
    }

}