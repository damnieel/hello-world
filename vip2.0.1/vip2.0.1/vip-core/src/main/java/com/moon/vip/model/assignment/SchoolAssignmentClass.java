package com.moon.vip.model.assignment;

import java.util.Date;

public class SchoolAssignmentClass {
	private Integer id;
	private Integer professionId;
	private Integer classId;
	private Date checkDate;
	private Integer submitNumber;
	private Integer hiatusNumber;
	private String note;
	private Date createTime;
	private String creator;
	private Date modifyTime;
	private String modifyUser;
	private Integer version;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
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

}
