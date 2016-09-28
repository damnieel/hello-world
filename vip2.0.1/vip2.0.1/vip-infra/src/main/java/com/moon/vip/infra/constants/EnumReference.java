package com.moon.vip.infra.constants;

/**
 * 类名称：EnumReference.java<br/>
 * 日期：2015年12月29日 上午10:38:36<br/>
 * 类描述：引用值枚举类<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public enum EnumReference {
	CURRENT_TEACHER(":current_teacher", "班级当前讲师"),
	CURRENT_ADVISER(":current_adviser", "班级当前班主任"),
	CURRENT_EMPLOYEE(":current_employee", "当前登录员工"),
	SUB_NODE(":sub_node", "管辖其下子机构"),
	ALL(":all","所有"),
	CUSTOM(":custom", "自定义");

	public String type;
	public String desc;

	/**
	 * 
	 * @param type
	 * @param desc    desc
	 */
	EnumReference(String type, String desc){
		this.type = type;
		this.desc = desc;
	}
}