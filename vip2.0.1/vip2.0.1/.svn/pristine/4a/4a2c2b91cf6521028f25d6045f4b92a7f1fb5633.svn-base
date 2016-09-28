package com.moon.vip.infra.vo.student;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 存取学员编号，专业编号
 * StudentCodeVO<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月30日-下午6:39:58 <BR>
 * @version 1.0.0
 * 
 */
public class StudentCodeVO implements Serializable{

	private static final long serialVersionUID = -3131312897105924390L;
	
	private Integer id;
	
	/***学员录入时间***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date studentCodeTime;

	/***学员编号最大值***/
	private Integer studentCodeNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStudentCodeTime() {
		return studentCodeTime;
	}

	public void setStudentCodeTime(Date studentCodeTime) {
		this.studentCodeTime = studentCodeTime;
	}

	public Integer getStudentCodeNumber() {
		return studentCodeNumber;
	}

	public void setStudentCodeNumber(Integer studentCodeNumber) {
		this.studentCodeNumber = studentCodeNumber;
	}

	@Override
	public String toString() {
		return "StudentCodeVO [id=" + id + ", studentCodeTime=" + studentCodeTime + ", studentCodeNumber="
				+ studentCodeNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((studentCodeNumber == null) ? 0 : studentCodeNumber.hashCode());
		result = prime * result + ((studentCodeTime == null) ? 0 : studentCodeTime.hashCode());
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
		StudentCodeVO other = (StudentCodeVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (studentCodeNumber == null) {
			if (other.studentCodeNumber != null)
				return false;
		} else if (!studentCodeNumber.equals(other.studentCodeNumber))
			return false;
		if (studentCodeTime == null) {
			if (other.studentCodeTime != null)
				return false;
		} else if (!studentCodeTime.equals(other.studentCodeTime))
			return false;
		return true;
	}


}
