package com.moon.vip.model.major;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.moon.vip.infra.vo.search.SearchParamsBase;
/**
 * 专业框架模型层
 * @author wesley
 *
 */
public class ColonyAndBranch extends SearchParamsBase{
	private static final long serialVersionUID = 7277007513832026514L;
	private String oldCode;
	private Integer id;
	private String name;
	private String oldName;
	private String content;
	private String appointPerson;
	private List<String> adviserList;
	private List<String> teacherList;
	private String adviser;
	private String adviserName;
	private String colonyName;
	private Integer branchId;
	private String branchName;
	private String majorName;
	private Integer majorId;
	private String teacherName;
	private String teacher;
	private List<String> list;
	private String majorCode;
	private String majorCodeKey;
	private String majorCodeValue;
	private String employeeCode;
	private String superior;
	private Integer roleId;
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date createTime;
	private String creator;
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date modifyTime;
	private String modifyPerson;
	private String type;
	
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getOldCode() {
		return oldCode;
	}
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAppointPerson() {
		return appointPerson;
	}
	public void setAppointPerson(String appointPerson) {
		this.appointPerson = appointPerson;
	}
	public String getAdviser() {
		return adviser;
	}
	public void setAdviser(String adviser) {
		this.adviser = adviser;
	}
	public String getAdviserName() {
		return adviserName;
	}
	public void setAdviserName(String adviserName) {
		this.adviserName = adviserName;
	}
	public String getColonyName() {
		return colonyName;
	}
	public void setColonyName(String colonyName) {
		this.colonyName = colonyName;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public Integer getMajorId() {
		return majorId;
	}
	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String getMajorCode() {
		return majorCode;
	}
	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
	public String getMajorCodeKey() {
		return majorCodeKey;
	}
	public void setMajorCodeKey(String majorCodeKey) {
		this.majorCodeKey = majorCodeKey;
	}
	public String getMajorCodeValue() {
		return majorCodeValue;
	}
	public void setMajorCodeValue(String majorCodeValue) {
		this.majorCodeValue = majorCodeValue;
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
	public String getModifyPerson() {
		return modifyPerson;
	}
	public void setModifyPerson(String modifyPerson) {
		this.modifyPerson = modifyPerson;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getSuperior() {
		return superior;
	}
	public void setSuperior(String superior) {
		this.superior = superior;
	}
	public List<String> getAdviserList() {
		return adviserList;
	}
	public void setAdviserList(List<String> adviserList) {
		this.adviserList = adviserList;
	}
	public List<String> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<String> teacherList) {
		this.teacherList = teacherList;
	}
}
