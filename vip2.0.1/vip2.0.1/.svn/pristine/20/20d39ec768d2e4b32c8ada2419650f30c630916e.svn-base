package com.moon.vip.infra.vo.sys.roleManage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @ClassName: RoleMenuDataOperVO 
 * @Description: 角色管理页面VO
 * @author 大枫
 * @date 2016年1月16日 下午4:00:09 
 *
 */
public class RoleMenuDataOperVO implements Serializable{

	private static final long serialVersionUID = 5000048667648704837L;
	/**
	 * 角色id
	 */
	private Integer roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 菜单id
	 */
	private Integer menuId;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 父菜单id
	 */
	private Integer menuParentId;
	/**
	 * 菜单权限树
	 */
	private List<TreeVO> menuAuth;
	/**
	 * 规则id
	 */
	private Integer ruleId;
	/**
	 * 规则名称
	 */
	private String ruleName;
	/**
	 * 操作id
	 */
	private Integer actId;
	/**
	 * 操作名称
	 */
	private String actName;
	/**
	 * 规则 操作权限树
	 */
	private List<TreeVO> ruleAct;
	@Override
	public String toString() {
		return "RoleMenuDataOperVO [roleId=" + roleId + ", roleName=" + roleName + ", menuId=" + menuId + ", menuName="
				+ menuName + ", menuParentId=" + menuParentId + ", ruleId=" + ruleId + ", ruleName=" + ruleName
				+ ", actId=" + actId + ", actName=" + actName + "]";
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getRuleId() {
		return ruleId;
	}
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public Integer getActId() {
		return actId;
	}
	public void setActId(Integer actId) {
		this.actId = actId;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public Integer getMenuParentId() {
		return menuParentId;
	}
	public void setMenuParentId(Integer menuParentId) {
		this.menuParentId = menuParentId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setMenuAuth(List<TreeVO> menuAuth) {
		this.menuAuth = menuAuth;
	}
	public void setRuleAct(List<TreeVO> ruleAct) {
		this.ruleAct = ruleAct;
	}
	public List<TreeVO> getMenuAuth() {
		if(menuAuth == null) {
			menuAuth = new ArrayList<TreeVO>();
		}
		return menuAuth;
	}
	public List<TreeVO> getRuleAct() {
		if(ruleAct == null) {
			ruleAct = new ArrayList<TreeVO>();
		}
		return ruleAct;
	}	
}
