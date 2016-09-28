package com.moon.socket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;
/**
 * 
* @ClassName: PropertiesInit 
* @Description: TODO(读取配置文件，如果读取失败，则为默认配置) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月25日 下午4:02:02 
*
 */
public class PropertiesInit {
	
	public PropertiesInit(String configPath) throws Exception{
		setSocketConfig(configPath);
		init();
	}
	private Properties pro;
	private String socketConfig;
    private static final Logger logger = Logger.getLogger(PropertiesInit.class);
	public void setSocketConfig(String socketConfig) {
		this.socketConfig = socketConfig;
	}
	public void setPro(Properties pro) {
		this.pro = pro;
	}
	public Properties getPro(){
		return this.pro;
	}
	public void init() throws Exception{
		String location = SystemPropertyUtils.resolvePlaceholders(socketConfig);
		String proPath = ResourceUtils.getURL(location).getFile();
		readPro(proPath);
		System.out.println(proPath);
	}
	public void readPro(String proPath){
		try{
		  FileInputStream fs = new FileInputStream(proPath); //读取properties 文件
		  setPro(new Properties());
		  pro.load(fs);
		}catch(FileNotFoundException e){
			logger.error("config file no exist!");
		}catch (IOException e) {
			logger.error("the type of file unknow!");
		}catch (Exception e) {
			logger.error("unknow exception!");
		}
   }
}