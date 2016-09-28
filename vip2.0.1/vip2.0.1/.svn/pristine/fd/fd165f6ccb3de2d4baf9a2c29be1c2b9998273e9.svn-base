package com.moon.vip.infra.vo.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
* @ClassName: SearchVO 
* @Description: TODO(前端不同条件查询字段的VO)  
* @Param:   
* @author qingyu <a href="mailto:2190234029@qq.com">dengrihui</a>
* @date 2015年12月31日 下午2:59:07 
*
 */
public class SearchVO implements Serializable{
	
	
	/** 
	* @Fields serialVersionUID : TODO( ) 
	*/ 
	private static final long serialVersionUID = 8015396621254702727L;
	/*职能ID*/
	private int organizationId;
    /*开始时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	/*结束时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	/*关键字*/
	private String keyWord;
	
	/**
	 * 数据权限过滤集合
	 */
	private HashSet<Integer> opClaIds;
	/*起始位置*/
	private int pageNo;
	/*展示数量*/
	private int pSize;
	
	/*** 搜索组织结合***/
	private HashSet<Integer> searchOpClaIds;
	
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
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
	public HashSet<Integer> getOpClaIds() {
		return opClaIds;
	}
	public void setOpClaIds(HashSet<Integer> opClaIds) {
		this.opClaIds = opClaIds;
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
	
	public HashSet<Integer> getSearchOpClaIds() {
		return searchOpClaIds;
	}
	
	public void setSearchOpClaIds(HashSet<Integer> searchOpClaIds) {
		this.searchOpClaIds = searchOpClaIds;
	}
	
	@Override
	public String toString() {
		return "SearchVO [organizationId=" + organizationId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", keyWord=" + keyWord + ", opClaIds=" + opClaIds + ", pageNo=" + pageNo + ", pSize=" + pSize + "]";
	}
	
}
