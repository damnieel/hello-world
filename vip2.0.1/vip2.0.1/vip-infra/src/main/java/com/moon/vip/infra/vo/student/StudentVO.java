package com.moon.vip.infra.vo.student;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 学员信息
 * StudentVO<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月23日-下午9:52:49 <BR>
 * @version 1.0.0
 * 
 */
public class StudentVO implements Serializable{

	private static final long serialVersionUID = 3102752219883215325L;
	
	private Integer id;	
	
	
	private String ids;
	
	/***学员编号(TZs-年份-月份-序号（1——N，根据报名日期及进入系统的逻辑顺序）)***/
	private String codeNo;
	
	/***学员姓名***/
	private String stuName;
	
	/***姓名拼音***/
	private String nameSpell;
	
	/***学员昵称***/
	private String nickName;
	
	/***个人照片url***/
	private String stuPictureUrl;
	
	/***性别（码表中获取）***/
	private String sex;
	
	/***出生日期***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	/***手机号码***/
	private String telephone;
	
	/***邮箱地址***/
	private String email;
	
	/***邮编***/
	private String postalCode;
	
	/***QQ账号***/
	private String QQ;
	
	/***YY账号***/
	private String YY;
	
	/***身份证号***/
	private String idCard;
	
	/***身份证正面图片地址***/
	private String cardFrontAddress;
	
	/***身份证反面图片地址***/
	private String cardReverseAddress;
	
	/***学历（码表中获取）***/
	private String educationBackgroundKey;
	private String educationBackgroundValue;
	
	/***紧急联系人***/
	private String emergencyPerson;
	
	/***与紧急联系人关系***/
	private String contratRelationshipsCode;
	
	/***紧急联系人电话***/
	private String emergencyTelephone;
	
	/***详情备注***/
	private String note;
	
	/***是否有效（用于删除）***/
	private String isValid;
	
	/***学员成分***/
	private String componentCode;
	
	/***从事职业***/
	private String occupationCodeKey;
	private String occupationCodeValue;
	
	/***毕业学校***/
	private String school;
	
	/***籍贯***/
	private String nativePlace;
	
	/***家庭地址***/
	private String address;
	
	/***兴趣爱好特长***/
	private String hobbies;
	
	/***信息来源***/
	private String studentResources;
	
	/***其他来源信息记录***/
	private String otherResources;
	
	/***费用来源***/
	private String costResources;
	
	/***创建时间***/
	private Date createTime;
	
	/***创建人（工号）***/
	private String creator;
	
	/***修改时间***/
	private Date modifyTime;
	
	/***修改人***/
	private String modifyUser;
	
	/***版本version***/
	private int version;	
	
	/********************用于搜索的参数Start***************************************/
	/***起始页***/
	private int offset;
	
	/***每页大小***/
	private int pageSize;
	
	/***关键字（搜索框）***/
	private String keyWord;
	
	/***报名时间***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enterDate;
	
	/**是否欠款****/
	private String isArrears;
	
	/***开始时间（用于搜索）***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	
	/***结束时间（用于搜索）***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	
	/***父节点id***/
	private Integer partentId;
	private String partentIds;
	
	/*** 职能ID***/
	private Integer organizationId;
	
	/*** 数据权限过滤集合***/
	private HashSet<Integer> opClaIds;
	
	/*** 搜索组织结合***/
	private HashSet<Integer> searchOpClaIds;
	
    /*****************用于搜索的参数end***************************/
	

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

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getNameSpell() {
		return nameSpell;
	}

	public void setNameSpell(String nameSpell) {
		this.nameSpell = nameSpell;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getStuPictureUrl() {
		return stuPictureUrl;
	}

	public void setStuPictureUrl(String stuPictureUrl) {
		this.stuPictureUrl = stuPictureUrl;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getYY() {
		return YY;
	}

	public void setYY(String yY) {
		YY = yY;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
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

	public String getEducationBackgroundKey() {
		return educationBackgroundKey;
	}

	public void setEducationBackgroundKey(String educationBackgroundKey) {
		this.educationBackgroundKey = educationBackgroundKey;
	}

	public String getEducationBackgroundValue() {
		return educationBackgroundValue;
	}

	public void setEducationBackgroundValue(String educationBackgroundValue) {
		this.educationBackgroundValue = educationBackgroundValue;
	}

	public String getEmergencyPerson() {
		return emergencyPerson;
	}

	public void setEmergencyPerson(String emergencyPerson) {
		this.emergencyPerson = emergencyPerson;
	}

	public String getContratRelationshipsCode() {
		return contratRelationshipsCode;
	}

	public void setContratRelationshipsCode(String contratRelationshipsCode) {
		this.contratRelationshipsCode = contratRelationshipsCode;
	}

	public String getEmergencyTelephone() {
		return emergencyTelephone;
	}

	public void setEmergencyTelephone(String emergencyTelephone) {
		this.emergencyTelephone = emergencyTelephone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getComponentCode() {
		return componentCode;
	}

	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}

	public String getOccupationCodeKey() {
		return occupationCodeKey;
	}

	public void setOccupationCodeKey(String occupationCodeKey) {
		this.occupationCodeKey = occupationCodeKey;
	}

	public String getOccupationCodeValue() {
		return occupationCodeValue;
	}

	public void setOccupationCodeValue(String occupationCodeValue) {
		this.occupationCodeValue = occupationCodeValue;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
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

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getIsArrears() {
		return isArrears;
	}

	public void setIsArrears(String isArrears) {
		this.isArrears = isArrears;
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

	public Integer getPartentId() {
		return partentId;
	}

	public void setPartentId(Integer partentId) {
		this.partentId = partentId;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", ids=" + ids + ", codeNo=" + codeNo + ", stuName=" + stuName + ", nameSpell="
				+ nameSpell + ", nickName=" + nickName + ", stuPictureUrl=" + stuPictureUrl + ", sex=" + sex
				+ ", birthday=" + birthday + ", telephone=" + telephone + ", email=" + email + ", postalCode="
				+ postalCode + ", QQ=" + QQ + ", YY=" + YY + ", idCard=" + idCard + ", cardFrontAddress="
				+ cardFrontAddress + ", cardReverseAddress=" + cardReverseAddress + ", educationBackgroundKey="
				+ educationBackgroundKey + ", educationBackgroundValue=" + educationBackgroundValue
				+ ", emergencyPerson=" + emergencyPerson + ", contratRelationshipsCode=" + contratRelationshipsCode
				+ ", emergencyTelephone=" + emergencyTelephone + ", note=" + note + ", isValid=" + isValid
				+ ", componentCode=" + componentCode + ", occupationCodeKey=" + occupationCodeKey
				+ ", occupationCodeValue=" + occupationCodeValue + ", school=" + school + ", nativePlace="
				+ nativePlace + ", address=" + address + ", hobbies=" + hobbies + ", studentResources="
				+ studentResources + ", otherResources=" + otherResources + ", costResources=" + costResources
				+ ", createTime=" + createTime + ", creator=" + creator + ", modifyTime=" + modifyTime
				+ ", modifyUser=" + modifyUser + ", version=" + version + ", offset=" + offset + ", pageSize="
				+ pageSize + ", keyWord=" + keyWord + ", enterDate=" + enterDate + ", isArrears=" + isArrears
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", partentId=" + partentId + ", partentIds="
				+ partentIds + ", organizationId=" + organizationId + ", opClaIds=" + opClaIds + ", searchOpClaIds="
				+ searchOpClaIds + "]";
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getPartentIds() {
		return partentIds;
	}

	public void setPartentIds(String partentIds) {
		this.partentIds = partentIds;
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

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}


}
