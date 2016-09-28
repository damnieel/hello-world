package com.moon.vip.infra.vo.student;

import java.io.Serializable;
import java.util.Date;

public class StudentFilesVO implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO( ) 
	*/ 
	private static final long serialVersionUID = -4245473637881779526L;
	private int id;
	private int stuId;
	private int opProId;
	private Date createTime;
	private String professionCode;
	private String studentName;
	private String studentNameSpell;
	private String sex;
	private String stuPictureUrl;
	private String birthday;
	private String idCard;
	private String educationBackground;
	private String professionName;
	private String nativePlace;
	private String postalCode;
	private String school;
	private String address;
	private String studentResources;
	private String otherResources;
	private String costResources;
	private String telephone;
	private String qq;
	private String email;
	private String hobbies;
	private String studyBasis;
	private String componentCode;
	private String cardFrontAddress;
	private String cardReverseAddress;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getProfessionCode() {
		return professionCode;
	}
	public void setProfessionCode(String professionCode) {
		this.professionCode = professionCode;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNameSpell() {
		return studentNameSpell;
	}
	public void setStudentNameSpell(String studentNameSpell) {
		this.studentNameSpell = studentNameSpell;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEducationBackground() {
		return educationBackground;
	}
	public void setEducationBackground(String educationBackground) {
		this.educationBackground = educationBackground;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStudentResources() {
		return studentResources;
	}
	public void setStudentResources(String studentResources) {
		this.studentResources = studentResources;
	}
	public String getOtherResources() {
		return otherResources;
	}
	public void setOtherResources(String otherResources) {
		this.otherResources = otherResources;
	}
	public String getCostResources() {
		return costResources;
	}
	public void setCostResources(String costResources) {
		this.costResources = costResources;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getStudyBasis() {
		return studyBasis;
	}
	public void setStudyBasis(String studyBasis) {
		this.studyBasis = studyBasis;
	}
	public String getComponentCode() {
		return componentCode;
	}
	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}
	public String getCardFrontAddress() {
		return cardFrontAddress;
	}
	public void setCardFrontAddress(String cardFrontAddress) {
		this.cardFrontAddress = cardFrontAddress;
	}
	public String getCardReverseAddress() {
		return cardReverseAddress;
	}
	public void setCardReverseAddress(String cardReverseAddress) {
		this.cardReverseAddress = cardReverseAddress;
	}
	@Override
	public String toString() {
		return "StudentFilesVO [id=" + id + ", stuId=" + stuId + ", opProId=" + opProId + ", createTime=" + createTime
				+ ", professionCode=" + professionCode + ", studentName=" + studentName + ", studentNameSpell="
				+ studentNameSpell + ", sex=" + sex + ", stuPictureUrl=" + stuPictureUrl + ", birthday=" + birthday
				+ ", idCard=" + idCard + ", educationBackground=" + educationBackground + ", professionName="
				+ professionName + ", nativePlace=" + nativePlace + ", postalCode=" + postalCode + ", school=" + school
				+ ", address=" + address + ", studentResources=" + studentResources + ", otherResources="
				+ otherResources + ", costResources=" + costResources + ", telephone=" + telephone + ", qq=" + qq
				+ ", email=" + email + ", hobbies=" + hobbies + ", studyBasis=" + studyBasis + ", componentCode="
				+ componentCode + ", cardFrontAddress=" + cardFrontAddress + ", cardReverseAddress="
				+ cardReverseAddress + "]";
	}
	public String getStuPictureUrl() {
		return stuPictureUrl;
	}
	public void setStuPictureUrl(String stuPictureUrl) {
		this.stuPictureUrl = stuPictureUrl;
	}
	public int getOpProId() {
		return opProId;
	}
	public void setOpProId(int opProId) {
		this.opProId = opProId;
	}
	
	

}
