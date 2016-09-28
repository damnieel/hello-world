package com.moon.vip.infra.vo.homework;

import java.io.Serializable;

/**
 * 提交作业学生记录类
 * StudentHomeworkVO<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月23日-下午7:28:03 <BR>
 * @version 2.0.0
 *
 */
public class StudentHmworkVO implements Serializable{
	private static final long serialVersionUID = 833381238629491885L;
	private Integer id;
	private Integer sacId;
	private Integer studentId;
	private String professionCode;
	private String studentName;
	private Integer checkStatus;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSacId() {
		return sacId;
	}
	public void setSacId(Integer sacId) {
		this.sacId = sacId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getProfessionCode() {
		return professionCode;
	}
	public void setProfessionCode(String professionCode) {
		this.professionCode = professionCode;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public Integer getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	@Override
	public String toString() {
		return "StudentHmworkVO [id=" + id + ", studentId=" + studentId + ", professionCode=" + professionCode
				+ ", studentName=" + studentName + ", checkStatus=" + checkStatus + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkStatus == null) ? 0 : checkStatus.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((professionCode == null) ? 0 : professionCode.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
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
		StudentHmworkVO other = (StudentHmworkVO) obj;
		if (checkStatus == null) {
			if (other.checkStatus != null)
				return false;
		} else if (!checkStatus.equals(other.checkStatus))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (professionCode == null) {
			if (other.professionCode != null)
				return false;
		} else if (!professionCode.equals(other.professionCode))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}

}
