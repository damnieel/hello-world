package com.moon.vip.infra.exception;

import com.moon.vip.infra.constants.EnumAttendException;
/**
 * 
* @ClassName: AttendanceException 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月24日 下午5:28:39 
*
 */
public class AttendanceException extends RuntimeException {

	private static final long serialVersionUID = -2615583720379887804L;
	private String exceptionMsg;
	private String code;
	
	public AttendanceException(String msg) {
		super(msg);
		this.setExceptionMsg(msg);
	}
	
	public AttendanceException(EnumAttendException codeException) {
		super(codeException.code);
		setEnumCodeExcetion(codeException);
	}
	
	public AttendanceException(String msg, Exception ex) {
		super(msg, ex);
		this.setExceptionMsg(msg);
	}
	
	public AttendanceException(EnumAttendException codeException, Object... args) {
		super(codeException.code);
		setEnumCodeExcetion(codeException, args);
	}
	
	public AttendanceException(EnumAttendException codeException, Exception ex) {
		super(codeException.code, ex);
		setEnumCodeExcetion(codeException);
	}

	private void setEnumCodeExcetion(EnumAttendException codeException, Object... args) {
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
