package com.moon.vip.infra.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: EmployeeLoginVO 
 * @Description: 员工登陆后，保存在session内的信息
 * @author 大枫
 * @date 2015年12月23日 下午6:13:43 
 *
 */
public class EmployeeLoginVO implements Serializable {

	private static final long serialVersionUID = 766173720221402590L;
	/**
	 * 员工工号
	 */
	private String employeeCode;
	/**
	 * 员工id
	 */
	private int id;
	/**
	 * 员工名称
	 */
	private String name;
	/**
	 * 员工昵称
	 */
	private String nickName;
	/**
	 * 所属组织机构id
	 */
	private int organizationId;
	/**
	 * 所属组织机构名称
	 */
	private String organizationName;
	/**
	 * 菜单资源角色id
	 */
	private Integer roleId;
	/**
	 * 单个或者以逗号分隔的字符串
	 */
	private String roleCode;
	/**
	 * 单个或者以逗号分隔的字符串
	 */
	private String roleName;
	/**
	 * 角色list
	 */
	private List<RoleVO> roleList;
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	@Override
	public String toString() {
		return "EmployeeLoginVO [employeeCode=" + employeeCode + ", id=" + id + ", name=" + name + ", nickName="
				+ nickName + ", organizationId=" + organizationId + ", organizationName=" + organizationName
				+ ", roleId=" + roleId + ", roleCode=" + roleCode + ", roleName=" + roleName + ", roleList=" + roleList
				+ "]";
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
	public List<RoleVO> getRoleList() {
		if(roleList == null) {
			return new ArrayList<RoleVO>();
		}
		return roleList;
	}
	public void setRoleList(List<RoleVO> roleList) {
		this.roleList = roleList;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


}
