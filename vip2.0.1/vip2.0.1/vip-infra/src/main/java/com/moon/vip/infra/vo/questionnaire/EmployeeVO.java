package com.moon.vip.infra.vo.questionnaire;

import java.io.Serializable;

/**
 * 用于查询工号，昵称
 * EmployeeVO<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月26日-下午5:58:44 <BR>
 * @version 1.0.0
 * 
 */
public class EmployeeVO implements Serializable {

	private static final long serialVersionUID = -957162658642734692L;
	
	private Integer id;
	
	/***工号***/
	private String employeeCode;
	
	/***姓名***/
	private String employeeName;
	
	/***昵称***/
	private String nickName;

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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", employeeCode=" + employeeCode + ", employeeName=" + employeeName
				+ ", nickName=" + nickName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeCode == null) ? 0 : employeeCode.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
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
		EmployeeVO other = (EmployeeVO) obj;
		if (employeeCode == null) {
			if (other.employeeCode != null)
				return false;
		} else if (!employeeCode.equals(other.employeeCode))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}

}
