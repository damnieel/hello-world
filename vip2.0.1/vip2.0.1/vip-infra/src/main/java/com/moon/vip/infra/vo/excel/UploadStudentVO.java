package com.moon.vip.infra.vo.excel;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: UploadStudentVO 
 * @Description: 上传学员信息的Excel接收类
 * @author 大枫
 * @date 2015年12月24日 下午6:48:17 
 *
 */
public class UploadStudentVO implements Serializable{

	private static final long serialVersionUID = -8876218992783926675L;
	/**
	 * 数据所在的序号
	 */
	private int dataId;
	/**
	 * 专业对应专业名称的id
	 */
	private int opProId;
	/**
	 * 上传数据者id
	 */
	private String creator;
	/**
	 * 学员id， 插入数据库后返回的id
	 */
	private int id;
	/**
	 * 学员专业id， 用于更新学员专业信息
	 */
	private int profId;
	/**
	 * 数据状态，0：旧学员旧专业 1：旧学员新专业 2：新学员新专业
	 */
	private int state;
	/**
	 * 学员编号
	 */
	private String codeNo;	
	
	/************************************************************/
	/**
	 * 专业编号
	 */
	private String professionCode;
	/**
	 * 学员姓名
	 */
	private String name;
	/**
	 * 邮箱
	 */
	private String email;	
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * QQ号码
	 */
	private String QQ;
	/**
	 * YY号码
	 */
	private String YY;
	/**
	 * 身份证号码
	 */
	private String idCard;
	/**
	 * 紧急联系人
	 */
	private String emergencyPerson;

	/**
	 * 紧急联系人电话
	 */
	private String emergencyTelephone;
	/**
	 * 与紧急联系人的关系
	 */
	private String contratRelationshipsCode;
	/**
	 * 专业名称
	 */
	private String professionalName;
	/**
	 * 专业价格
	 */
	private double amountPayable;
	/**
	 * 支付方式， 码表中有体现 type = payment
	 */
	private String payMethod;
	/**
	 * 实付金额
	 */
	private double payment;
	/**
	 * 报名时间
	 */
	private Date enterDate;
	/**
	 * 备注
	 */
	private String remark;
	
	public String getProfessionCode() {
		return professionCode;
	}
	public void setProfessionCode(String professionCode) {
		this.professionCode = professionCode;
	}
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public String getEmergencyPerson() {
		return emergencyPerson;
	}
	public void setEmergencyPerson(String emergencyPerson) {
		this.emergencyPerson = emergencyPerson;
	}
	public String getEmergencyTelephone() {
		return emergencyTelephone;
	}
	public void setEmergencyTelephone(String emergencyTelephone) {
		this.emergencyTelephone = emergencyTelephone;
	}
	public String getContratRelationshipsCode() {
		return contratRelationshipsCode;
	}
	public void setContratRelationshipsCode(String contratRelationshipsCode) {
		this.contratRelationshipsCode = contratRelationshipsCode;
	}
	public String getProfessionalName() {
		return professionalName;
	}
	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}
	public double getAmountPayable() {
		return amountPayable;
	}
	public void setAmountPayable(double amountPayable) {
		this.amountPayable = amountPayable;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public Date getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "UploadStudentVO [dataId=" + dataId + ", opProId=" + opProId + ", creator=" + creator + ", id=" + id
				+ ", profId=" + profId + ", state=" + state + ", professionCode=" + professionCode + ", codeNo="
				+ codeNo + ", name=" + name + ", email=" + email + ", sex=" + sex + ", telephone=" + telephone
				+ ", QQ=" + QQ + ", YY=" + YY + ", idCard=" + idCard + ", emergencyPerson=" + emergencyPerson
				+ ", emergencyTelephone=" + emergencyTelephone + ", contratRelationshipsCode="
				+ contratRelationshipsCode + ", professionalName=" + professionalName + ", amountPayable="
				+ amountPayable + ", payMethod=" + payMethod + ", payment=" + payment + ", enterDate=" + enterDate
				+ ", remark=" + remark + "]";
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProfId() {
		return profId;
	}
	public void setProfId(int profId) {
		this.profId = profId;
	}
	public int getOpProId() {
		return opProId;
	}
	public void setOpProId(int opProId) {
		this.opProId = opProId;
	}
	public int getDataId() {
		return dataId;
	}
	public void setDataId(int dataId) {
		this.dataId = dataId;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
}