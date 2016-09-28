package com.moon.vip.infra.vo.student;

import java.io.Serializable;


/**
 * 用于学员信息的下拉列表值的获取
 * CodeTableVO<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月28日-下午8:04:22 <BR>
 * @version 1.0.0
 * 
 */
public class CodeTableVO implements Serializable{

	private static final long serialVersionUID = 5824487121852971766L;
	
	/***类型***/
	private String type;
	
	/***key***/
	private String codeKey;
	
	/***value***/
	private String codeValue;
	
	/***退费原因***/
	private String refundReason;
	
	/***支付方式***/
	private String payment;
	
	/***学历***/
	private String degree;
	
	/***职业***/
	private String professional;

	public String getCodeKey() {
		return codeKey;
	}

	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	@Override
	public String toString() {
		return "CodeTableVO [type=" + type + ", codeKey=" + codeKey + ", codeValue=" + codeValue + ", refundReason="
				+ refundReason + ", payment=" + payment + ", degree=" + degree + ", professional=" + professional + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeKey == null) ? 0 : codeKey.hashCode());
		result = prime * result + ((codeValue == null) ? 0 : codeValue.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((professional == null) ? 0 : professional.hashCode());
		result = prime * result + ((refundReason == null) ? 0 : refundReason.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		CodeTableVO other = (CodeTableVO) obj;
		if (codeKey == null) {
			if (other.codeKey != null)
				return false;
		} else if (!codeKey.equals(other.codeKey))
			return false;
		if (codeValue == null) {
			if (other.codeValue != null)
				return false;
		} else if (!codeValue.equals(other.codeValue))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (professional == null) {
			if (other.professional != null)
				return false;
		} else if (!professional.equals(other.professional))
			return false;
		if (refundReason == null) {
			if (other.refundReason != null)
				return false;
		} else if (!refundReason.equals(other.refundReason))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

}
