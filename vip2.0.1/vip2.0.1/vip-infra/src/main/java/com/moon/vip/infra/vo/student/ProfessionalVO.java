package com.moon.vip.infra.vo.student;

import java.io.Serializable;
import java.util.Date;

/**
 * 职业数据ＶＯ
 * ProfessionalVO<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月23日-下午6:48:41 <BR>
 * @version 1.0.0
 * 
 */
public class ProfessionalVO implements Serializable{


	private static final long serialVersionUID = 4185871764096535406L;
	
	private int id;
	
	/***类型***/
	private String type;
	
	/***类型名称***/
	private String typeName;
	
	/***职业键key***/
	private String  codeKey;
	
	/***职业值***/
	private String codeValue;

	/***排序***/
	private int codeOrder;
	
	/***是否显示***/
	private String isValid;
	
	/***创建时间***/
	private Date createTime;
	
	/***创建人工号***/
	private String creator;
	
	/***修改时间***/
	private Date modifyTime;
	
	/***起始页***/
	private int offset;
	
	/***每页大小***/
	private int pageSize;
	
	/***专业***/
	private String course;
	
	/**专业前缀***/
	private String coursePrefix;
	
	/***学历***/
	private String degree;
	
	/***支付方式***/
	private String payment;
    
    /***退费原因***/
    private String refundReason;
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

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

	public int getCodeOrder() {
		return codeOrder;
	}

	public void setCodeOrder(int codeOrder) {
		this.codeOrder = codeOrder;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCoursePrefix() {
		return coursePrefix;
	}

	public void setCoursePrefix(String coursePrefix) {
		this.coursePrefix = coursePrefix;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	@Override
	public String toString() {
		return "ProfessionalVO [id=" + id + ", type=" + type + ", typeName=" + typeName + ", codeKey=" + codeKey
				+ ", codeValue=" + codeValue + ", codeOrder=" + codeOrder + ", isValid=" + isValid + ", createTime="
				+ createTime + ", creator=" + creator + ", modifyTime=" + modifyTime + ", offset=" + offset
				+ ", pageSize=" + pageSize + ", course=" + course + ", coursePrefix=" + coursePrefix + ", degree="
				+ degree + ", payment=" + payment + ", refundReason=" + refundReason + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeKey == null) ? 0 : codeKey.hashCode());
		result = prime * result + codeOrder;
		result = prime * result + ((codeValue == null) ? 0 : codeValue.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((coursePrefix == null) ? 0 : coursePrefix.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + id;
		result = prime * result + ((isValid == null) ? 0 : isValid.hashCode());
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + offset;
		result = prime * result + pageSize;
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((refundReason == null) ? 0 : refundReason.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
		ProfessionalVO other = (ProfessionalVO) obj;
		if (codeKey == null) {
			if (other.codeKey != null)
				return false;
		} else if (!codeKey.equals(other.codeKey))
			return false;
		if (codeOrder != other.codeOrder)
			return false;
		if (codeValue == null) {
			if (other.codeValue != null)
				return false;
		} else if (!codeValue.equals(other.codeValue))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (coursePrefix == null) {
			if (other.coursePrefix != null)
				return false;
		} else if (!coursePrefix.equals(other.coursePrefix))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (id != other.id)
			return false;
		if (isValid == null) {
			if (other.isValid != null)
				return false;
		} else if (!isValid.equals(other.isValid))
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (offset != other.offset)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
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
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		return true;
	}

}
