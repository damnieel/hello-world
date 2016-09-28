package com.moon.vip.infra.vo.sys.roleManage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * 
 * @ClassName: EmpRoleRuleDataAct 
 * @Description: 员工角色规则数据操作类
 * @author 大枫
 * @date 2016年1月28日 下午2:48:10 
 *
 */
public class EmpRoleRuleDataAct implements Serializable{
	
	private static final long serialVersionUID = -5068676015762327218L;
	/**
	 * 角色代码
	 */
	private String roleCode;
	/**
	 * 规则id
	 */
	private Integer ruleId;
	/**
	 * 规则内容
	 */
	private String ruleContent;
	/**
	 * 操作Id
	 */
	private Integer actionId;
	/**
	 * 操作类型
	 */
	private String actType;
	/**
	 * 操作类型数组
	 */
	private List<String> actList;
	/**
	 * 规则内容对应的权限orgId
	 */
	private HashSet<Integer> orgAuthSet;
	@Override
	public String toString() {
		return "EmpRoleRuleDataAct [roleCode=" + roleCode + ", ruleId=" + ruleId + ", ruleContent=" + ruleContent
				+ ", actionId=" + actionId + ", actType=" + actType + ", actList=" + actList + ", orgAuthSet="
				+ orgAuthSet + "]";
	}
	public Integer getRuleId() {
		return ruleId;
	}
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	public String getRuleContent() {
		return ruleContent;
	}
	public void setRuleContent(String ruleContent) {
		this.ruleContent = ruleContent;
	}
	public Integer getActionId() {
		return actionId;
	}
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	public String getActType() {
		return actType;
	}
	public void setActType(String actType) {
		this.actType = actType;
	}
	public HashSet<Integer> getOrgAuthSet() {
		return orgAuthSet;
	}
	public void setOrgAuthSet(HashSet<Integer> orgAuthSet) {
		this.orgAuthSet = orgAuthSet;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public List<String> getActList() {
		if(actList == null) {
			actList = new ArrayList<String>();
			return actList;
		}
		return actList;
	}
	public void setActList(List<String> actList) {
		this.actList = actList;
	}
	
}
