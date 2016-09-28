package com.moon.vip.infra.exception;

import com.moon.vip.infra.constants.EnumCodeException;


/**
 * 类名称：BusinessException.java<br/>
 * 日期：2015年11月20日 下午3:31:19<br/>
 * 类描述：自定义业务异常<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年11月20日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class BusinessException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1591925825642765482L;
	
	private String exceptionMsg;
	private String code;
	
	public BusinessException(String msg) {
		super(msg);
		this.setExceptionMsg(msg);
	}
	
	public BusinessException(EnumCodeException codeException) {
		super(codeException.code);
		setEnumCodeExcetion(codeException);
	}
	
	public BusinessException(String msg, Exception ex) {
		super(msg, ex);
		this.setExceptionMsg(msg);
	}
	
	public BusinessException(EnumCodeException codeException, Object... args) {
		super(codeException.code);
		setEnumCodeExcetion(codeException, args);
	}
	
	public BusinessException(EnumCodeException codeException, Exception ex) {
		super(codeException.code, ex);
		setEnumCodeExcetion(codeException);
	}
	
	public BusinessException(EnumCodeException codeException, Exception ex, Object... args) {
		super(codeException.code, ex);
		setEnumCodeExcetion(codeException, args);
	}

	private void setEnumCodeExcetion(EnumCodeException codeException, Object... args) {
		this.setCode(codeException.code);
		this.setExceptionMsg(String.format(codeException.msg, args));
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	private void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getCode() {
		return code;
	}

	private void setCode(String code) {
		this.code = code;
	}
	
}
