package com.moon.vip.infra.vo.sys;

import java.io.Serializable;

import com.moon.vip.infra.util.Md5Util;

/**
 * 密码修改ＶＯ
 * EmployeePasswordVO<BR>
 * 创建人:向新 <BR>
 * 时间：2015年12月23日-下午1:23:41 <BR>
 * @version 1.0.0
 * 
 */
public class EmployeePasswordVO implements Serializable{

	private static final long serialVersionUID = -7436852979456919674L;
	
	/** 员工ID**/
	private Integer id;
	/** 员工编号**/
	private String employeeCode;
	/** 新密码**/
	private String newPwd;
	/** 旧密码**/
	private String oldPwd;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = Md5Util.encoderByMd5(newPwd);
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = Md5Util.encoderByMd5(oldPwd);
	}
	@Override
	public String toString() {
		return "EmployeePasswordVO [id=" + id + ", employeeCode=" + employeeCode + ", newPwd=" + newPwd + ", oldPwd="
				+ oldPwd + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeCode == null) ? 0 : employeeCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((newPwd == null) ? 0 : newPwd.hashCode());
		result = prime * result + ((oldPwd == null) ? 0 : oldPwd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePasswordVO other = (EmployeePasswordVO) obj;
		if (employeeCode == null) {
			if (other.employeeCode != null)
				return false;
		} else if (!employeeCode.equals(other.employeeCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (newPwd == null) {
			if (other.newPwd != null)
				return false;
		} else if (!newPwd.equals(other.newPwd))
			return false;
		if (oldPwd == null) {
			if (other.oldPwd != null)
				return false;
		} else if (!oldPwd.equals(other.oldPwd))
			return false;
		return true;
	}
	
	
	
	
	
}
