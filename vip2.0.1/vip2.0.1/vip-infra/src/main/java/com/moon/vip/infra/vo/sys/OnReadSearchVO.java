package com.moon.vip.infra.vo.sys;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @ClassName: OnReadSearchVO 
 * @Description: TODO(在读页面的Search信息) 
 * @author 大枫
 * @date 2016年1月6日 下午7:47:45 
 *
 */
public class OnReadSearchVO implements Serializable {

	private static final long serialVersionUID = -4814726919790243619L;
	/**
	 * 职能ID
	 */
	private Integer organizationId;
    /**
     * 报名时间 搜索起始时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	/**
	 * 报名时间 搜索结束时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	/**
	 * 关键字
	 */
	private String keyWord;
	/**
	 * 起始页数
	 */
	private int pageNo;
	/**
	 * 每页数量
	 */
	private int pSize;
	/**
	 * 是否欠款 Y or N
	 */
	private String isArrears;
	/**
	 * 是否退费 Y or N
	 */
	private String isRefund;
	/**
	 * 学员班级状态
	 */
	private String gradeStatue;
	/**
	 * 退休学搜索起始日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startChangeTime;
	/**
	 * 退休学搜索结束日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endChangeTime;
	/**
	 * 学员状态 退学或者休学等
	 */
	private String statue;
	
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
	public String getGradeStatue() {
		return gradeStatue;
	}
	public void setGradeStatue(String gradeStatue) {
		this.gradeStatue = gradeStatue;
	}
	@Override
	public String toString() {
		return "OnReadSearchVO [organizationId=" + organizationId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", keyWord=" + keyWord + ", pageNo=" + pageNo + ", pSize=" + pSize + ", isArrears=" + isArrears
				+ ", isRefund=" + isRefund + ", gradeStatue=" + gradeStatue + ", startChangeTime=" + startChangeTime
				+ ", endChangeTime=" + endChangeTime + ", statue=" + statue + "]";
	}
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
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
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getpSize() {
		return pSize;
	}
	public void setpSize(int pSize) {
		this.pSize = pSize;
	}
	public Date getStartChangeTime() {
		return startChangeTime;
	}
	public void setStartChangeTime(Date startChangeTime) {
		this.startChangeTime = startChangeTime;
	}
	public Date getEndChangeTime() {
		return endChangeTime;
	}
	public void setEndChangeTime(Date endChangeTime) {
		this.endChangeTime = endChangeTime;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	
}
