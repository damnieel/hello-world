package com.moon.vip.infra.vo.homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 班级提交作业情况
 * ClassHomeWorkVO<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月23日-下午7:37:32 <BR>
 * @version 2.0.0
 *
 */
public class ClassHmworkVO implements Serializable{
	private static final long serialVersionUID = -5031122507246101745L;
	private Integer id;
	private List<StudentHmworkVO> studentHomeworkList;
	private Integer professionId;
	private Integer classId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date oldCheckDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkDate;
	private Date createTime;
	private String creator;
	private Date modifyTime;
	private String modifyUser;
	private Integer version;
	private Integer submitNumber;
	private Integer hiatusNumber;
	private String note;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ClassHmworkVO(){
		this.studentHomeworkList = new ArrayList<StudentHmworkVO>();
	}
	public List<StudentHmworkVO> getStudentHomeworkList() {
		return studentHomeworkList;
	}
	public void setStudentHomeworkList(List<StudentHmworkVO> studentHomeworkList) {
		this.studentHomeworkList = studentHomeworkList;
	}
	public Integer getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Date getOldCheckDate() {
		return oldCheckDate;
	}
	public void setOldCheckDate(Date oldCheckDate) {
		this.oldCheckDate = oldCheckDate;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getSubmitNumber() {
		return submitNumber;
	}
	public void setSubmitNumber(Integer submitNumber) {
		this.submitNumber = submitNumber;
	}
	public Integer getHiatusNumber() {
		return hiatusNumber;
	}
	public void setHiatusNumber(Integer hiatusNumber) {
		this.hiatusNumber = hiatusNumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "ClassHmworkVO [id=" + id + ", studentHomeworkList=" + studentHomeworkList + ", professionId="
				+ professionId + ", classId=" + classId + ", oldCheckDate=" + oldCheckDate + ", checkDate=" + checkDate
				+ ", createTime=" + createTime + ", creator=" + creator + ", modifyTime=" + modifyTime
				+ ", modifyUser=" + modifyUser + ", version=" + version + ", submitNumber=" + submitNumber
				+ ", hiatusNumber=" + hiatusNumber + ", note=" + note + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkDate == null) ? 0 : checkDate.hashCode());
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((hiatusNumber == null) ? 0 : hiatusNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + ((modifyUser == null) ? 0 : modifyUser.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((oldCheckDate == null) ? 0 : oldCheckDate.hashCode());
		result = prime * result + ((professionId == null) ? 0 : professionId.hashCode());
		result = prime * result + ((studentHomeworkList == null) ? 0 : studentHomeworkList.hashCode());
		result = prime * result + ((submitNumber == null) ? 0 : submitNumber.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		ClassHmworkVO other = (ClassHmworkVO) obj;
		if (checkDate == null) {
			if (other.checkDate != null)
				return false;
		} else if (!checkDate.equals(other.checkDate))
			return false;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (hiatusNumber == null) {
			if (other.hiatusNumber != null)
				return false;
		} else if (!hiatusNumber.equals(other.hiatusNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (modifyUser == null) {
			if (other.modifyUser != null)
				return false;
		} else if (!modifyUser.equals(other.modifyUser))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (oldCheckDate == null) {
			if (other.oldCheckDate != null)
				return false;
		} else if (!oldCheckDate.equals(other.oldCheckDate))
			return false;
		if (professionId == null) {
			if (other.professionId != null)
				return false;
		} else if (!professionId.equals(other.professionId))
			return false;
		if (studentHomeworkList == null) {
			if (other.studentHomeworkList != null)
				return false;
		} else if (!studentHomeworkList.equals(other.studentHomeworkList))
			return false;
		if (submitNumber == null) {
			if (other.submitNumber != null)
				return false;
		} else if (!submitNumber.equals(other.submitNumber))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
}
