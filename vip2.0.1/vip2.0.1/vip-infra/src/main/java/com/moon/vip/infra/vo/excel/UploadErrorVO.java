package com.moon.vip.infra.vo.excel;

import java.util.Map;

/**
 * 
 * @ClassName: UploadErrorVO 
 * @Description: 错误返回
 * @author 大枫
 * @date 2015年12月25日 下午4:26:18 
 *
 */
public class UploadErrorVO extends UploadStudentVO {

	private static final long serialVersionUID = 4601936356611144773L;
	
	private Map<String, Object> errorMap;

	public Map<String, Object> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, Object> errorMap) {
		this.errorMap = errorMap;
	}

	@Override
	public String toString() {
		return super.toString() + "UploadErrorVO [errorMap=" + errorMap + "]";
	}
	
}
