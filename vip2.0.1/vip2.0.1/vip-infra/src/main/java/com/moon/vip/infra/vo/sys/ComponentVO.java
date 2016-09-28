package com.moon.vip.infra.vo.sys;

import java.io.Serializable;

public class ComponentVO implements Serializable {
	
	/** 
	* @Fields serialVersionUID : TODO( ) 
	*/ 
	private static final long serialVersionUID = 4558302537744077570L;
	private int worker;
	private int unemployee;
	private int student;
	private int other;
	private int componentRecord;
	public int getWorker() {
		return worker;
	}
	public void setWorker(int worker) {
		this.worker = worker;
	}
	public int getUnemployee() {
		return unemployee;
	}
	public void setUnemployee(int unemployee) {
		this.unemployee = unemployee;
	}
	public int getStudent() {
		return student;
	}
	public void setStudent(int student) {
		this.student = student;
	}
	public int getOther() {
		return other;
	}
	public void setOther(int other) {
		this.other = other;
	}
	public int getComponentRecord() {
		return componentRecord;
	}
	public void setComponentRecord(int componentRecord) {
		this.componentRecord = componentRecord;
	}
	@Override
	public String toString() {
		return "ComponentVO [worker=" + worker + ", unemployee=" + unemployee + ", student=" + student + ", other="
				+ other + ", componentRecord=" + componentRecord + "]";
	}
	
	
	
	
	
}
