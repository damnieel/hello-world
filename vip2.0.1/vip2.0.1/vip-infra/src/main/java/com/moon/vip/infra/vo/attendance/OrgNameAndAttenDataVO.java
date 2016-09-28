package com.moon.vip.infra.vo.attendance;

public class OrgNameAndAttenDataVO {
	private int orgId;
	private String orgName ;
    private double percent;
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	} 
}
