package com.moon.vip.infra.vo.sys.userManage;

import java.io.Serializable;

/**
 * @ClassName: UserManageVO 
 * @Description: TODO(用户管理类) 
 * @author 大枫
 * @date 2016年1月6日 上午11:02:24 
 *
 */
public class UserManageVO implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = -5971517914860220022L;
	/**
	 * 用户id
	 */
	private String id;
	/**
	 * 用户名称
	 */
	private String name;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 用户工号
	 */
	private String employeeCode;
	/**
	 * 部门名称
	 */
	private String organizationName;
	/**
	 * 角色id
	 */
	private String roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 员工和角色对应信息表id
	 */
	private String empRoleId;
	@Override
	public String toString() {
		return "UserManageVO [id=" + id + ", name=" + name + ", nickName=" + nickName + ", employeeCode="
				+ employeeCode + ", organizationName=" + organizationName + ", roleId=" + roleId + ", roleName="
				+ roleName + ", empRoleId=" + empRoleId + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getEmpRoleId() {
		return empRoleId;
	}
	public void setEmpRoleId(String empRoleId) {
		this.empRoleId = empRoleId;
	}
	
}
