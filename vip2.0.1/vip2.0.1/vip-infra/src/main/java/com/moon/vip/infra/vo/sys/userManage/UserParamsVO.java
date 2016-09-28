package com.moon.vip.infra.vo.sys.userManage;

public class UserParamsVO {
	private Integer id;
	private String employeeCode;
	private String name;
	private String nickName;
	private Integer roleId;
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "UserParamsVO [employeeCode=" + employeeCode + ", name=" + name + ", nickName=" + nickName + ", roleId="
				+ roleId + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
