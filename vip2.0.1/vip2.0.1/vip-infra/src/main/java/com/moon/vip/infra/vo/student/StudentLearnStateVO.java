package com.moon.vip.infra.vo.student;

import java.io.Serializable;
import java.util.Date;

public class StudentLearnStateVO implements Serializable {
	 /** 
	* @Fields serialVersionUID : TODO( ) 
	*/ 
	private static final long serialVersionUID = 9001062286135246545L;
	 private int id;
	 private int stuId;
	 private String studentName;
	 private String professionName;
	 private int shouldAttendance;
	 private int leaveNumber;
	 private int factAttendance;
	 private int shouldTask;
	 private int factTask;
	 private Date endDate;
	 private String certificate;
	 private String rewardsPunishments;
	 private String wordMouth;
	 private String appraise;
	 private String modifyUser;
	 private Date modifyTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public int getShouldAttendance() {
		return shouldAttendance;
	}
	public void setShouldAttendance(int shouldAttendance) {
		this.shouldAttendance = shouldAttendance;
	}
	public int getLeaveNumber() {
		return leaveNumber;
	}
	public void setLeaveNumber(int leaveNumber) {
		this.leaveNumber = leaveNumber;
	}
	public int getFactAttendance() {
		return factAttendance;
	}
	public void setFactAttendance(int factAttendance) {
		this.factAttendance = factAttendance;
	}
	public int getShouldTask() {
		return shouldTask;
	}
	public void setShouldTask(int shouldTask) {
		this.shouldTask = shouldTask;
	}
	public int getFactTask() {
		return factTask;
	}
	public void setFactTask(int factTask) {
		this.factTask = factTask;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getRewardsPunishments() {
		return rewardsPunishments;
	}
	public void setRewardsPunishments(String rewardsPunishments) {
		this.rewardsPunishments = rewardsPunishments;
	}
	public String getWordMouth() {
		return wordMouth;
	}
	public void setWordMouth(String wordMouth) {
		this.wordMouth = wordMouth;
	}
	public String getAppraise() {
		return appraise;
	}
	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	@Override
	public String toString() {
		return "StudentLearnStateVO [id=" + id + ", stuId=" + stuId + ", studentName=" + studentName
				+ ", professionName=" + professionName + ", shouldAttendance=" + shouldAttendance + ", leaveNumber="
				+ leaveNumber + ", factAttendance=" + factAttendance + ", shouldTask=" + shouldTask + ", factTask="
				+ factTask + ", endDate=" + endDate + ", certificate=" + certificate + ", rewardsPunishments="
				+ rewardsPunishments + ", wordMouth=" + wordMouth + ", appraise=" + appraise + ", modifyUser="
				+ modifyUser + ", modifyTime=" + modifyTime + "]";
	}
	

	 
}
