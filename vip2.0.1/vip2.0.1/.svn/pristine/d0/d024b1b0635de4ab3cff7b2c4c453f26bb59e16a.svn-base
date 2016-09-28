package com.moon.vip.infra.constants;

import java.io.Serializable;

public class Message implements Serializable{

	private static final long serialVersionUID = -376428323148723530L;

	/** 返回成功或失败 **/
	private boolean result;
	/** 返回消息编码 **/
	private String code;
	/** 具体消息内容 **/
	private String msg;
	
	/**   
	 * @方法名: setResultMsg   
	 * @描述: 设置返回前端页面消息
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:36:44   
	 */  
	public void setResultMsg(boolean result,String msg){
		this.result=result;
		this.msg=msg;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + (this.result ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (result != other.result)
			return false;
		return true;
	}
}
