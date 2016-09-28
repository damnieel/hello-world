package com.moon.vip.infra.vo.search;

public class StuProfessSearchParams extends SearchParamsWithDept {

	private static final long serialVersionUID = -7417073658702958203L;
	private int professNumber;
	
	public int getProfessNumber() {
		return professNumber;
	}
	public void setProfessNumber(int professNumber) {
		this.professNumber = professNumber;
	}
	@Override
	public String toString() {
		return super.toString()+"StuProfessSearchParams [professNumber=" + professNumber + "]";
	}

}
