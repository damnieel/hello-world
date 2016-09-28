package com.moon.vip.infra.vo.report;

import java.io.Serializable;

/**
 * 报表统计展示数据
 * ReportVO<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月29日-上午11:10:21 <BR>
 * @version 2.0.0
 *
 */
public class ReportVO implements Serializable{
	private static final long serialVersionUID = -2572851249476576237L;
	private Integer organizationId;
	private String organizationName;
	private double percenage;
	
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public double getPercenage() {
		return percenage;
	}
	public void setPercenage(double percenage) {
		this.percenage = percenage;
	}
	@Override
	public String toString() {
		return "ReportVO [organizationId=" + organizationId + ", organizationName=" + organizationName + ", percenage="
				+ percenage + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((organizationId == null) ? 0 : organizationId.hashCode());
		result = prime * result + ((organizationName == null) ? 0 : organizationName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(percenage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ReportVO other = (ReportVO) obj;
		if (organizationId == null) {
			if (other.organizationId != null)
				return false;
		} else if (!organizationId.equals(other.organizationId))
			return false;
		if (organizationName == null) {
			if (other.organizationName != null)
				return false;
		} else if (!organizationName.equals(other.organizationName))
			return false;
		if (Double.doubleToLongBits(percenage) != Double.doubleToLongBits(other.percenage))
			return false;
		return true;
	}
	
}
