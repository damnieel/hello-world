package com.moon.vip.infra.vo.search;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 搜索条件中增加时间段（起始时间，结束时间）
 * StatisticSearchParamsVO<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月23日-下午6:17:38 <BR>
 * @version 2.0.0
 *
 */
public class StatisticSearchParams extends SearchParamsWithDept {
	private static final long serialVersionUID = 401563079310554192L;
	/**
	 * 开始时间
	 */
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date startDate;
	/**
	 * 结束时间
	 */
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date endDate;
	
	/**
	 * 时间类型（本周，上周 ，本月，上月等，时间区间）
	 */
	private int timeRangeType;

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

	public int getTimeRangeType() {
		return timeRangeType;
	}

	public void setTimeRangeType(int timeRangeType) {
		this.timeRangeType = timeRangeType;
	}

	@Override
	public String toString() {
		return super.toString()+",StatisticSearchParams [startDate=" + startDate + ", endDate=" + endDate + ", timeRangeType="
				+ timeRangeType + "]";
	}
	
}
