package com.moon.vip.infra.vo.student;

import java.io.Serializable;

/**
 * 班级VO
 * ClassVO<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月29日-下午6:32:44 <BR>
 * @version 1.0.0
 * 
 */
public class ClassVO implements Serializable{

	private static final long serialVersionUID = -7374576250804816079L;
	
	/***id***/
	private Integer id;
	
	/***专业名称***/
	private String courseName;
	
	/***父节点id***/
	private Integer partentId;
	
	/***是否有效***/
	private String isValid;
	
	/***专业id***/
	private String codeKey;
	
	/***专业前缀**/
	private String codeValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getPartentId() {
		return partentId;
	}

	public void setPartentId(Integer partentId) {
		this.partentId = partentId;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "ClassVO [id=" + id + ", courseName=" + courseName + ", partentId=" + partentId + ", isValid=" + isValid
				+ ", codeKey=" + codeKey + ", codeValue=" + codeValue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isValid == null) ? 0 : isValid.hashCode());
		result = prime * result + ((partentId == null) ? 0 : partentId.hashCode());
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
		ClassVO other = (ClassVO) obj;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isValid == null) {
			if (other.isValid != null)
				return false;
		} else if (!isValid.equals(other.isValid))
			return false;
		if (partentId == null) {
			if (other.partentId != null)
				return false;
		} else if (!partentId.equals(other.partentId))
			return false;
		return true;
	}

	public String getCodeKey() {
		return codeKey;
	}

	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	
}
