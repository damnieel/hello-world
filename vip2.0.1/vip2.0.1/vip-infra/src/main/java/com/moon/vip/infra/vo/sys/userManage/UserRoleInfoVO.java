package com.moon.vip.infra.vo.sys.userManage;

import java.io.Serializable;

/**
 * 
 * @ClassName: UserRoleInfoVO 
 * @Description: 管理用户和角色关系的vo
 * @author 大枫
 * @date 2016年1月8日 下午4:33:49 
 *
 */
public class UserRoleInfoVO implements Serializable{

	private static final long serialVersionUID = -5111655412397222969L;

	/**
	 * 角色id
	 */
	private Integer roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 角色范围
	 */
	private String scope;
	@Override
	public String toString() {
		return "UserRoleInfoVO [roleId=" + roleId + ", roleName=" + roleName + ", scope=" + scope + "]";
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}	
	
}
