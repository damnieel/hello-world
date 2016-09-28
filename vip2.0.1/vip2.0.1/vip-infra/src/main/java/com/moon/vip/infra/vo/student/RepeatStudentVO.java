package com.moon.vip.infra.vo.student;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 重复数据（针对专业编号相同的）
 * RepeatStudentVO<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月31日-下午12:13:03 <BR>
 * @version 1.0.0
 * 
 */
public class RepeatStudentVO implements Serializable{

	private static final long serialVersionUID = -1698666343478108582L;
	
	private Integer id;
	
	/***专业编号***/
	private String professionCode;
	
	/***学员姓名***/
	private String stuName;
	
	/***专业id***/
	private Integer opProId;
	
	/***专业价格***/
	private BigDecimal amountPayable;
	
	/***实付金额***/
	private String payment;
	
	/***尾款***/
	private BigDecimal arrears;
	
	/***手机号码***/
	private String telephone;
	
	/***qq***/
	private String QQ;
	
	/***报名时间***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enterDate;
	
	/***是否欠款***/
	private String isArrears;
	
	/***是否退费***/
	private String isRefund;
	
	/***学员专业状态***/
	private String statues;
	
	/***专业备注***/
	private String remark;
	
	/***专业名称***/
	private String course;
	
	/******************搜索条件**********************/
	/***起始页***/
	private Integer offset;
	
	/***每页大小***/
	private Integer pageSize;
	
	/***搜索框关键字***/
	private String keyword;
	
	/***报名时间（开始时间）***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private  Date startTime;
	
	/***报名时间（结束时间）***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	
	/*** 职能ID***/
	private Integer organizationId;
	
	/*** 数据权限过滤集合***/
	private HashSet<Integer> opClaIds;
	
	/*** 搜索组织结合***/
	private HashSet<Integer> searchOpClaIds;

	/***************************************/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfessionCode() {
		return professionCode;
	}

	public void setProfessionCode(String professionCode) {
		this.professionCode = professionCode;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getOpProId() {
		return opProId;
	}

	public void setOpProId(Integer opProId) {
		this.opProId = opProId;
	}

	public BigDecimal getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(BigDecimal amountPayable) {
		this.amountPayable = amountPayable;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public BigDecimal getArrears() {
		return arrears;
	}

	public void setArrears(BigDecimal arrears) {
		this.arrears = arrears;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getIsArrears() {
		return isArrears;
	}

	public void setIsArrears(String isArrears) {
		this.isArrears = isArrears;
	}

	public String getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}

	public String getStatues() {
		return statues;
	}

	public void setStatues(String statues) {
		this.statues = statues;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "RepeatStudentVO [id=" + id + ", professionCode=" + professionCode + ", stuName=" + stuName
				+ ", opProId=" + opProId + ", amountPayable=" + amountPayable + ", payment=" + payment + ", arrears="
				+ arrears + ", telephone=" + telephone + ", QQ=" + QQ + ", enterDate=" + enterDate + ", isArrears="
				+ isArrears + ", isRefund=" + isRefund + ", statues=" + statues + ", remark=" + remark + ", course="
				+ course + ", offset=" + offset + ", pageSize=" + pageSize + ", keyword=" + keyword + ", startTime="
				+ startTime + ", endTime=" + endTime + ", organizationId=" + organizationId + ", opClaIds=" + opClaIds
				+ ", searchOpClaIds=" + searchOpClaIds + "]";
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public HashSet<Integer> getOpClaIds() {
		return opClaIds;
	}

	public void setOpClaIds(HashSet<Integer> opClaIds) {
		this.opClaIds = opClaIds;
	}

	public HashSet<Integer> getSearchOpClaIds() {
		return searchOpClaIds;
	}

	public void setSearchOpClaIds(HashSet<Integer> searchOpClaIds) {
		this.searchOpClaIds = searchOpClaIds;
	}
	
}
