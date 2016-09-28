package com.moon.vip.infra.constants;

/**
 * 类名称：EnumAuthAction.java<br/>
 * 日期：2016年1月8日 下午2:50:12<br/>
 * 类描述：数据权限操作类型<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年1月8日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public enum EnumAuthAction {

	SELECT("select"),
	INSERT("insert"),
	UPDATE("update"),
	DELETE("delete")
	;
	public String type;
	
	EnumAuthAction(String type) {
		this.type = type;
	}
}
