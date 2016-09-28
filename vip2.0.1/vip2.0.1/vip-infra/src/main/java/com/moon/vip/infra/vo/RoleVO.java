package com.moon.vip.infra.vo;

import java.io.Serializable;
/**
 * 
 * @ClassName: RoleVO 
 * @Description: 用户角色信息
 * @author A18ccms a18ccms_gmail_com 
 * @date 2016年1月8日 下午12:37:51 
 *
 */
public class RoleVO implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = 6412379518682435892L;
	/**
	 * 用户角色id
	 */
	private Integer roleId;
	/**
	 * 用户角色Code
	 */
	private String roleCode;
	@Override
	public String toString() {
		return "RoleVO [roleId=" + roleId + ", roleCode=" + roleCode + "]";
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}	
}
