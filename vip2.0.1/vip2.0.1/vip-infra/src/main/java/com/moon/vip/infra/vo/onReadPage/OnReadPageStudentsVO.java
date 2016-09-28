package com.moon.vip.infra.vo.onReadPage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OnReadPageStudentsVO implements Serializable{

	private static final long serialVersionUID = -777670399773290950L;
	/**
	 * 学员id
	 */
	private Integer id;
	/**
	 * 专业价格 vip_student_class
	 */
	private double amountPayable;
	/**
	 * 尾款金额
	 */
	private double arrears;
	/**
	 * 退、休学日期 状态更改日期
	 */
	private Date changeTime;
	/**
	 * 已分班时的删除学员  Y or N
	 * vip_student_class
	 */
	private String classValid;
	/**
	 * 学员编号
	 */
	private String codeNo;
	/**
	 * 报名时间  vip_student_professional enter_date
	 */
	private Date enterDate;
	/**
	 * 是否欠款 Y or N
	 */
	private String isArrears;
	/**
	 * 是否退费 Y or N
	 */
	private String isRefund;
	/**
	 * 学员姓名
	 */
	private String name;
	/**
	 * 实付金额  vip_student_class
	 */
	private double payment;
	/**
	 * 未分班时，删除学员 Y or N
	 * vip_student_professional
	 */
	private String professionalValid;
	/**
	 * 专业名称 对应vip_student_class: profession_code vip_student_class
	 */
	private String professionName;
	/**
	 * 专业信息id
	 */
	private Integer professionId;	
	/**
	 * 专业orgid
	 */
	private Integer professionOrgId;
	/**
	 * qq号码
	 */
	private String QQ;
	/**
	 * 退费原因
	 */
	private String refundReason;
	/**
	 * 备注   vip_student_class
	 */
	private String remark;
	/**
	 * 学员状态
	 * reading : 在读  drop : 退学  pause : 休学  continue : 复学  stay ： 留级
	 */
	private String status;
	/**
	 * 学员状态中文显示
	 */
	private String codeStatus;
	/**
	 * 手机号码
	 */
	private String telephone;
	/**
	 * 班级名称
	 */
	private String gradeName;
	/**
	 * 班级信息id
	 */
	private String gradeId;
	/**
	 * 班级Orgid
	 */
	private String gradeOrgId;
	/**
	 * 班级状态
	 */
	private String gradeStatue;
	/**
	 * 学员状态改变原因
	 */
	private String changeReason;
	/**
	 * 班级信息创建时间
	 */
	private Date gradeCreateTime;
	/**
	 * 树结构
	 */
	private List<OnReadPageStudentsVO> onReadList; 
	
	public double getAmountPayable() {
		return amountPayable;
	}
	public void setAmountPayable(double amountPayable) {
		this.amountPayable = amountPayable;
	}
	public double getArrears() {
		return arrears;
	}
	public void setArrears(double arrears) {
		this.arrears = arrears;
	}
	public Date getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	public String getClassValid() {
		return classValid;
	}
	public void setClassValid(String classValid) {
		this.classValid = classValid;
	}
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
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
	public String getIsRefund() {
		return isRefund;
	}
	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public String getProfessionalValid() {
		return professionalValid;
	}
	public void setProfessionalValid(String professionalValid) {
		this.professionalValid = professionalValid;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "OnReadPageStudentsVO [id=" + id + ", amountPayable=" + amountPayable + ", arrears=" + arrears
				+ ", changeTime=" + changeTime + ", classValid=" + classValid + ", codeNo=" + codeNo + ", enterDate="
				+ enterDate + ", isArrears=" + isArrears + ", isRefund=" + isRefund + ", name=" + name + ", payment="
				+ payment + ", professionalValid=" + professionalValid + ", professionName=" + professionName
				+ ", professionId=" + professionId + ", professionOrgId=" + professionOrgId + ", QQ=" + QQ
				+ ", refundReason=" + refundReason + ", remark=" + remark + ", status=" + status + ", codeStatus="
				+ codeStatus + ", telephone=" + telephone + ", gradeName=" + gradeName + ", gradeId=" + gradeId
				+ ", gradeOrgId=" + gradeOrgId + ", gradeStatue=" + gradeStatue + ", changeReason=" + changeReason
				+ ", gradeCreateTime=" + gradeCreateTime + ", onReadList=" + onReadList + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeStatue() {
		return gradeStatue;
	}
	public void setGradeStatue(String gradeStatue) {
		this.gradeStatue = gradeStatue;
	}
	public Integer getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}
	public String getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	public List<OnReadPageStudentsVO> getOnReadList() {
		if(onReadList == null) {
			return new ArrayList<OnReadPageStudentsVO>();
		}
		return onReadList;
	}
	public void setOnReadList(List<OnReadPageStudentsVO> onReadList) {
		this.onReadList = onReadList;
	}
	public String getCodeStatus() {
		return codeStatus;
	}
	public void setCodeStatus(String codeStatus) {
		this.codeStatus = codeStatus;
	}
	public Date getGradeCreateTime() {
		return gradeCreateTime;
	}
	public void setGradeCreateTime(Date gradeCreateTime) {
		this.gradeCreateTime = gradeCreateTime;
	}
	public Integer getProfessionOrgId() {
		return professionOrgId;
	}
	public void setProfessionOrgId(Integer professionOrgId) {
		this.professionOrgId = professionOrgId;
	}
	public String getGradeOrgId() {
		return gradeOrgId;
	}
	public void setGradeOrgId(String gradeOrgId) {
		this.gradeOrgId = gradeOrgId;
	}
}
