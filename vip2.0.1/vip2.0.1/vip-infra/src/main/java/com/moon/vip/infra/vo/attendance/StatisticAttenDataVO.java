package com.moon.vip.infra.vo.attendance;

import java.util.List;

public class StatisticAttenDataVO {
	
	private int percentType ;//0：出勤率 ,1 ：缺勤 率 , 2：请假率
	
	private List<OrgNameAndAttenDataVO> orgNameAndData;

	public int getPercentType() {
		return percentType;
	}

	public void setPercentType(int percentType) {
		this.percentType = percentType;
	}

	public List<OrgNameAndAttenDataVO> getOrgNameAndData() {
		return orgNameAndData;
	}

	public void setOrgNameAndData(List<OrgNameAndAttenDataVO> orgNameAndData) {
		this.orgNameAndData = orgNameAndData;
	}
 
}
