package com.moon.vip.infra.vo.interviews;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class InterviewsVO implements Serializable{
    /** 
	* @Fields serialVersionUID : TODO( ) 
	*/ 
	private static final long serialVersionUID = -9083134985623030185L;
	private Integer id;
	private Integer opProId;
    private String codeNo;
    private String studentName;
    private String qq;
    private Integer professionId;
    private String professionName;
    private String teacherName;
    private String interviewerCode;
    private String interviewerName;
    private String occupationCode;
    private String occupationName;
    private Integer learnAimCode;
    private String learnAimContent;
    private String suggest;
    private String puzzle;
    private String note;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date interviewTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Integer getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public String getOccupationCode() {
		return occupationCode;
	}
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}
	public String getOccupationName() {
		return occupationName;
	}
	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}
	public Integer getLearnAimCode() {
		return learnAimCode;
	}
	public void setLearnAimCode(Integer learnAimCode) {
		this.learnAimCode = learnAimCode;
	}
	public String getLearnAimContent() {
		return learnAimContent;
	}
	public void setLearnAimContent(String learnAimContent) {
		this.learnAimContent = learnAimContent;
	}
	public String getSuggest() {
		return suggest;
	}
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	public String getPuzzle() {
		return puzzle;
	}
	public void setPuzzle(String puzzle) {
		this.puzzle = puzzle;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "InterviewsVO [id=" + id + ", opProId=" + opProId + ", codeNo=" + codeNo + ", studentName="
				+ studentName + ", qq=" + qq + ", professionId=" + professionId + ", professionName=" + professionName
				+ ", teacherName=" + teacherName + ", interviewerCode=" + interviewerCode + ", interviewerName="
				+ interviewerName + ", occupationCode=" + occupationCode + ", occupationName=" + occupationName
				+ ", learnAimCode=" + learnAimCode + ", learnAimContent=" + learnAimContent + ", suggest=" + suggest
				+ ", puzzle=" + puzzle + ", note=" + note + "]";
	}
	public String getInterviewerCode() {
		return interviewerCode;
	}
	public void setInterviewerCode(String interviewerCode) {
		this.interviewerCode = interviewerCode;
	}
	public Integer getOpProId() {
		return opProId;
	}
	public void setOpProId(Integer opProId) {
		this.opProId = opProId;
	}
	public Date getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}
	
	
    
}