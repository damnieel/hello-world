package com.moon.vip.infra.vo.attendance;

import com.moon.vip.infra.vo.search.StatisticSearchParams;

public class AttendSercherParams extends StatisticSearchParams{

	private static final long serialVersionUID = 6629237861031557791L;
	private Integer absenceSum;
	private Integer isUnAttend; /**1:true 0:false**/
	public Integer getAbsenceSum() {
		return absenceSum;
	}
	public void setAbsenceSum(Integer absenceSum) {
		this.absenceSum = absenceSum;
	}
	@Override
	public String toString() {
		return super.toString()+"AttendSercherParams [absenceSum=" + absenceSum + "]";
	}
	public Integer getIsUnAttend() {
		return isUnAttend;
	}
	public void setIsUnAttend(Integer isUnAttend) {
		this.isUnAttend = isUnAttend;
	}

}
