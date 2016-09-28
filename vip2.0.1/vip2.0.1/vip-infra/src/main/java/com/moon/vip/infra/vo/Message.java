package com.moon.vip.infra.vo;

import java.io.Serializable;

/**
 * 
* @ClassName: Message 
* @Description: 后台返回到前端 
* @Param:   
* @author qingyu <a href="mailto:2190234029@qq.com">dengrihui</a>
* @date 2016年1月14日 上午10:35:02 
*
 */
public class Message implements Serializable {

	/** **/
	private static final long serialVersionUID = -5188903807129405811L;
	/** 返回成功或失败 **/
	private String result;
	/** 返回消息编码 **/
	private String code;
	/** 具体消息内容 **/
	private String msg;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Message [result=" + result + ", code=" + code + ", msg=" + msg + "]";
	}
	
	
}
