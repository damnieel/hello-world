package com.moon.vip.infra.vo.questionnaire;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import org.springframework.format.annotation.DateTimeFormat;

public class QuestionnaireVO implements Serializable{

	private static final long serialVersionUID = -5839894095756146221L;
	
	private Integer id;
	
	/***专业id***/
	private Integer proId;
	
	/***组织机构-专业-id***/
	private String opProIds;
	
	/***专业名称***/
	private String courseName;
	
	/***问卷表讲师工号***/
	private String techerCode;
	
	/***讲师昵称***/
	private String nickName;
	
	/***讲师名字***/
	private String teacherName;
	
	/***员工表讲师工号***/
	private String employeeCode;

	/***调查学员数***/
	private int investigationsNumber;
	
	/***调查日期***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date investigationsDate;
	
	/***优秀比例***/
	private Double excellent;
	
	/***评良比率***/
	private Double good;
	
	/***评中比率***/
	private Double medium;
	
	/***评差比率***/
	private Double bad;
	
	/***学员问题***/
	private String question;
	
	/***解决措施***/
	private String solution;
	
	/***附件名称***/
	private String annexName;
	
	/***附件地址***/
	private String annexAddress;
	
	/***创建时间***/
	private Date createTime;
	
	/***创建人（工号）***/
	private String creator;
	
	/***修改时间***/
	private Date modifyTime;
	
	/***修改人***/
	private String modifyUser;
	
	/***版本***/
	private int version;
	
	/***起始页***/
	private int offset;
	
	/***每页大小***/
	private int pageSize;
	
	/***输入框的参数***/
	private String keyword;
	
	/***开始时间（用于搜索）***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	
	/***结束时间（用于搜索）***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	
	/***评优起始值***/
	private Double startGood;
	
	/***评优结束值***/
	private Double endGood;
	
	/*** 职能ID***/
	private Integer organizationId;
	
	/*** 数据权限过滤集合***/
	private HashSet<Integer> opClaIds;
	
	/*** 搜索组织结合***/
	private HashSet<Integer> searchOpClaIds;
	
	/***集群id***/
	private Integer cid;
	private String cName;
	/***部门id***/
	private Integer deid;
	private String dName; 

	


	public String getOpProIds() {
		return opProIds;
	}

	public void setOpProIds(String opProIds) {
		this.opProIds = opProIds;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTecherCode() {
		return techerCode;
	}

	public void setTecherCode(String techerCode) {
		this.techerCode = techerCode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public int getInvestigationsNumber() {
		return investigationsNumber;
	}

	public void setInvestigationsNumber(int investigationsNumber) {
		this.investigationsNumber = investigationsNumber;
	}

	public Date getInvestigationsDate() {
		return investigationsDate;
	}

	public void setInvestigationsDate(Date investigationsDate) {
		this.investigationsDate = investigationsDate;
	}

	public Double getExcellent() {
		return excellent;
	}

	public void setExcellent(Double excellent) {
		this.excellent = excellent;
	}

	public Double getGood() {
		return good;
	}

	public void setGood(Double good) {
		this.good = good;
	}

	public Double getMedium() {
		return medium;
	}

	public void setMedium(Double medium) {
		this.medium = medium;
	}

	public Double getBad() {
		return bad;
	}

	public void setBad(Double bad) {
		this.bad = bad;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getAnnexAddress() {
		return annexAddress;
	}

	public void setAnnexAddress(String annexAddress) {
		this.annexAddress = annexAddress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Double getStartGood() {
		return startGood;
	}

	public void setStartGood(Double startGood) {
		this.startGood = startGood;
	}

	public Double getEndGood() {
		return endGood;
	}

	public void setEndGood(Double endGood) {
		this.endGood = endGood;
	}

	@Override
	public String toString() {
		return "QuestionnaireVO [id=" + id + ", proId=" + proId + ", opProIds=" + opProIds + ", courseName="
				+ courseName + ", techerCode=" + techerCode + ", nickName=" + nickName + ", teacherName=" + teacherName
				+ ", employeeCode=" + employeeCode + ", investigationsNumber=" + investigationsNumber
				+ ", investigationsDate=" + investigationsDate + ", excellent=" + excellent + ", good=" + good
				+ ", medium=" + medium + ", bad=" + bad + ", question=" + question + ", solution=" + solution
				+ ", annexName=" + annexName + ", annexAddress=" + annexAddress + ", createTime=" + createTime
				+ ", creator=" + creator + ", modifyTime=" + modifyTime + ", modifyUser=" + modifyUser + ", version="
				+ version + ", offset=" + offset + ", pageSize=" + pageSize + ", keyword=" + keyword + ", startTime="
				+ startTime + ", endTime=" + endTime + ", startGood=" + startGood + ", endGood=" + endGood
				+ ", organizationId=" + organizationId + ", opClaIds=" + opClaIds + ", searchOpClaIds="
				+ searchOpClaIds + ", cid=" + cid + ", cName=" + cName + ", deid=" + deid + ", dName=" + dName + "]";
	}

	public String getAnnexName() {
		return annexName;
	}

	public void setAnnexName(String annexName) {
		this.annexName = annexName;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public HashSet<Integer> getOpClaIds() {
		return opClaIds;
	}

	public void setOpClaIds(HashSet<Integer> opClaIds) {
		this.opClaIds = opClaIds;
	}

	public HashSet<Integer> getSearchOpClaIds() {
		return searchOpClaIds;
	}

	public void setSearchOpClaIds(HashSet<Integer> searchOpClaIds) {
		this.searchOpClaIds = searchOpClaIds;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getDeid() {
		return deid;
	}

	public void setDeid(Integer deid) {
		this.deid = deid;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	
}
