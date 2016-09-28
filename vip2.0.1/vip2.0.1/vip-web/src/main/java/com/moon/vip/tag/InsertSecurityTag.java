package com.moon.vip.tag;

import javax.servlet.jsp.JspException;

import com.moon.vip.infra.constants.EnumAuthAction;

/**
 * 
 * @ClassName: SecurityTag 
 * @Description: 系统权限自定义标签
 * @author 大枫
 * @date 2016年1月13日 下午5:00:54 
 *
 */
public class InsertSecurityTag extends SecurityTag{

	private static final long serialVersionUID = -5878713607954923160L;
	/**
	 * 操作类型
	 */
	private String operType;	
	/**
	 * 数据是属于哪个班级或者专业的
	 */
	private Integer organizationId;
	
	@Override
	public int doAfterBody() throws JspException {
		super.setOperType(EnumAuthAction.INSERT.type);
		super.setOrganizationId(this.organizationId);
		return super.doAfterBody();
	}
	
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}	
	
}
