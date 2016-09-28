package com.moon.vip.infra.vo.search;

import java.io.Serializable;
import java.util.HashSet;

public class SearchParamsBase implements Serializable{
	private static final long serialVersionUID = -6825804040104427143L;
	/**
	 * 数据权限过滤集合
	 */
	private HashSet<Integer> opClaIds;
	/**
	 * 搜索关键字
	 */
	private String searchKey;
	/**
	 * 分页显示分页起始行，默认0
	 */
	private int startNumber = 0;
	/**
	 * 分页显示每页记录数,默认10
	 */
	private int pageSize = 10;

	public HashSet<Integer> getOpClaIds() {
		return opClaIds;
	}

	public void setOpClaIds(HashSet<Integer> opClaIds) {
		this.opClaIds = opClaIds;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	
	public int getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "SearchParamsBase [opClaIds=" + opClaIds + ", searchKey=" + searchKey + ", startNumber=" + startNumber
				+ ", pageSize=" + pageSize + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opClaIds == null) ? 0 : opClaIds.hashCode());
		result = prime * result + pageSize;
		result = prime * result + ((searchKey == null) ? 0 : searchKey.hashCode());
		result = prime * result + startNumber;
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
		SearchParamsBase other = (SearchParamsBase) obj;
		if (opClaIds == null) {
			if (other.opClaIds != null)
				return false;
		} else if (!opClaIds.equals(other.opClaIds))
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (searchKey == null) {
			if (other.searchKey != null)
				return false;
		} else if (!searchKey.equals(other.searchKey))
			return false;
		if (startNumber != other.startNumber)
			return false;
		return true;
	}

}
