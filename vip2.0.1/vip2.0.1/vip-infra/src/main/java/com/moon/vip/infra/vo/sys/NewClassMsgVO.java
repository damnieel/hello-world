package com.moon.vip.infra.vo.sys;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class NewClassMsgVO {
	private Integer orgId;
	private Integer parentId;
	private String className;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private String advCode;
	private String teachCode;
	private String creator;
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAdvCode() {
		return advCode;
	}
	public void setAdvCode(String advCode) {
		this.advCode = advCode;
	}
	public String getTeachCode() {
		return teachCode;
	}
	public void setTeachCode(String teachCode) {
		this.teachCode = teachCode;
	}
	@Override
	public String toString() {
		return "NewClassMsgVO [orgId=" + orgId + ", parentId=" + parentId + ", className=" + className + ", startDate="
				+ startDate + ", endDate=" + endDate + ", advCode=" + advCode + ", teachCode=" + teachCode
				+ ", creator=" + creator + "]";
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
