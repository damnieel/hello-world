package com.moon.vip.infra.vo.student;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用于查看学员专业详情
 * CourseVO<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月30日-下午5:10:53 <BR>
 * @version 1.0.0
 * 
 */
public class CourseVO implements Serializable{

	private static final long serialVersionUID = 3847248091647940955L;
	
	private Integer pId;
	 
	/****专业编号（专业前缀加年月+1→N）**/
	private String professionCode;
	
	/***专业id***/
	private Integer opProId;
	
	/***专业名称***/
	private String courseName;
	
	/***专业报名时间***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enterDate;
	
	/***专业价格***/
	private BigDecimal amountPayable;
	
	/***支付方式***/
	private String payMethodKey;
	private String payMethodValue;
	
	/***实付金额***/
	private BigDecimal payment;
	
	/***尾款***/
	private BigDecimal arrears;
	
	/***是否退费***/
	private String isRefund;
	
	/****退费金额**/
	private BigDecimal refundMonetary;
	
	/***退费原因***/
	private String refundReasonKey;
	private String refundReasonVlaue;
	
	/***专业备注***/
	private String remark;
	
	/***班级id***/
    private	Integer opClaId;
    
    /***班级名称***/
    private String className;
	
	/***学员状态***/
	private String statues;
	private String statuesValue;
	
	/***状态变更时间***/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date changeTime;
	
	/***状态变更原因***/
	private String changeReason;
	
	/***班级是否有效***/
	private String isValidClass;
	
	/***学员id***/
	private Integer studentId;

	/*** 数据权限过滤集合***/
	private HashSet<Integer> opClaIds;
	
	
	public String getProfessionCode() {
		return professionCode;
	}

	public void setProfessionCode(String professionCode) {
		this.professionCode = professionCode;
	}

	public Integer getOpProId() {
		return opProId;
	}

	public void setOpProId(Integer opProId) {
		this.opProId = opProId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public BigDecimal getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(BigDecimal amountPayable) {
		this.amountPayable = amountPayable;
	}

	public String getPayMethodKey() {
		return payMethodKey;
	}

	public void setPayMethodKey(String payMethodKey) {
		this.payMethodKey = payMethodKey;
	}

	public String getPayMethodValue() {
		return payMethodValue;
	}

	public void setPayMethodValue(String payMethodValue) {
		this.payMethodValue = payMethodValue;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public BigDecimal getArrears() {
		return arrears;
	}

	public void setArrears(BigDecimal arrears) {
		this.arrears = arrears;
	}

	public String getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}

	public BigDecimal getRefundMonetary() {
		return refundMonetary;
	}

	public void setRefundMonetary(BigDecimal refundMonetary) {
		this.refundMonetary = refundMonetary;
	}

	public String getRefundReasonKey() {
		return refundReasonKey;
	}

	public void setRefundReasonKey(String refundReasonKey) {
		this.refundReasonKey = refundReasonKey;
	}

	public String getRefundReasonVlaue() {
		return refundReasonVlaue;
	}

	public void setRefundReasonVlaue(String refundReasonVlaue) {
		this.refundReasonVlaue = refundReasonVlaue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOpClaId() {
		return opClaId;
	}

	public void setOpClaId(Integer opClaId) {
		this.opClaId = opClaId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStatues() {
		return statues;
	}

	public void setStatues(String statues) {
		this.statues = statues;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	public String getIsValidClass() {
		return isValidClass;
	}

	public void setIsValidClass(String isValidClass) {
		this.isValidClass = isValidClass;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "CourseVO [pId=" + pId + ", professionCode=" + professionCode + ", opProId=" + opProId + ", courseName="
				+ courseName + ", enterDate=" + enterDate + ", amountPayable=" + amountPayable + ", payMethodKey="
				+ payMethodKey + ", payMethodValue=" + payMethodValue + ", payment=" + payment + ", arrears=" + arrears
				+ ", isRefund=" + isRefund + ", refundMonetary=" + refundMonetary + ", refundReasonKey="
				+ refundReasonKey + ", refundReasonVlaue=" + refundReasonVlaue + ", remark=" + remark + ", opClaId="
				+ opClaId + ", className=" + className + ", statues=" + statues + ", statuesValue=" + statuesValue
				+ ", changeTime=" + changeTime + ", changeReason=" + changeReason + ", isValidClass=" + isValidClass
				+ ", studentId=" + studentId + ", opClaIds=" + opClaIds + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountPayable == null) ? 0 : amountPayable.hashCode());
		result = prime * result + ((arrears == null) ? 0 : arrears.hashCode());
		result = prime * result + ((changeReason == null) ? 0 : changeReason.hashCode());
		result = prime * result + ((changeTime == null) ? 0 : changeTime.hashCode());
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((enterDate == null) ? 0 : enterDate.hashCode());
		result = prime * result + ((isRefund == null) ? 0 : isRefund.hashCode());
		result = prime * result + ((isValidClass == null) ? 0 : isValidClass.hashCode());
		result = prime * result + ((opClaId == null) ? 0 : opClaId.hashCode());
		result = prime * result + ((opProId == null) ? 0 : opProId.hashCode());
		result = prime * result + ((pId == null) ? 0 : pId.hashCode());
		result = prime * result + ((payMethodKey == null) ? 0 : payMethodKey.hashCode());
		result = prime * result + ((payMethodValue == null) ? 0 : payMethodValue.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((professionCode == null) ? 0 : professionCode.hashCode());
		result = prime * result + ((refundMonetary == null) ? 0 : refundMonetary.hashCode());
		result = prime * result + ((refundReasonKey == null) ? 0 : refundReasonKey.hashCode());
		result = prime * result + ((refundReasonVlaue == null) ? 0 : refundReasonVlaue.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((statues == null) ? 0 : statues.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseVO other = (CourseVO) obj;
		if (amountPayable == null) {
			if (other.amountPayable != null)
				return false;
		} else if (!amountPayable.equals(other.amountPayable))
			return false;
		if (arrears == null) {
			if (other.arrears != null)
				return false;
		} else if (!arrears.equals(other.arrears))
			return false;
		if (changeReason == null) {
			if (other.changeReason != null)
				return false;
		} else if (!changeReason.equals(other.changeReason))
			return false;
		if (changeTime == null) {
			if (other.changeTime != null)
				return false;
		} else if (!changeTime.equals(other.changeTime))
			return false;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (enterDate == null) {
			if (other.enterDate != null)
				return false;
		} else if (!enterDate.equals(other.enterDate))
			return false;
		if (isRefund == null) {
			if (other.isRefund != null)
				return false;
		} else if (!isRefund.equals(other.isRefund))
			return false;
		if (isValidClass == null) {
			if (other.isValidClass != null)
				return false;
		} else if (!isValidClass.equals(other.isValidClass))
			return false;
		if (opClaId == null) {
			if (other.opClaId != null)
				return false;
		} else if (!opClaId.equals(other.opClaId))
			return false;
		if (opProId == null) {
			if (other.opProId != null)
				return false;
		} else if (!opProId.equals(other.opProId))
			return false;
		if (pId == null) {
			if (other.pId != null)
				return false;
		} else if (!pId.equals(other.pId))
			return false;
		if (payMethodKey == null) {
			if (other.payMethodKey != null)
				return false;
		} else if (!payMethodKey.equals(other.payMethodKey))
			return false;
		if (payMethodValue == null) {
			if (other.payMethodValue != null)
				return false;
		} else if (!payMethodValue.equals(other.payMethodValue))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (professionCode == null) {
			if (other.professionCode != null)
				return false;
		} else if (!professionCode.equals(other.professionCode))
			return false;
		if (refundMonetary == null) {
			if (other.refundMonetary != null)
				return false;
		} else if (!refundMonetary.equals(other.refundMonetary))
			return false;
		if (refundReasonKey == null) {
			if (other.refundReasonKey != null)
				return false;
		} else if (!refundReasonKey.equals(other.refundReasonKey))
			return false;
		if (refundReasonVlaue == null) {
			if (other.refundReasonVlaue != null)
				return false;
		} else if (!refundReasonVlaue.equals(other.refundReasonVlaue))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (statues == null) {
			if (other.statues != null)
				return false;
		} else if (!statues.equals(other.statues))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getStatuesValue() {
		return statuesValue;
	}

	public void setStatuesValue(String statuesValue) {
		this.statuesValue = statuesValue;
	}

	public HashSet<Integer> getOpClaIds() {
		return opClaIds;
	}

	public void setOpClaIds(HashSet<Integer> opClaIds) {
		this.opClaIds = opClaIds;
	}
}
