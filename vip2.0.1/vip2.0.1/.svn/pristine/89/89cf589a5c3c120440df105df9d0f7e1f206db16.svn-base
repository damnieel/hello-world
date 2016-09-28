package com.moon.vip.infra.vo.student;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付方法ＶＯ
 * PaymentVO<BR>
 * 创建人:向新 <BR>
 * 时间：2015年12月23日-下午2:24:50 <BR>
 * @version 1.0.0
 * 
 */
public class PaymentVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	/***类型***/
	private String type;
	
	/***类型名称***/
	private String typeName;
	
	/***支付key***/
	private String  codeKey;
	
	/***支付value***/
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

	@Override
	public String toString() {
		return "PaymentVO [id=" + id + ", type=" + type + ", typeName=" + typeName + ", codeKey=" + codeKey
				+ ", codeValue=" + codeValue + ", codeOrder=" + codeOrder + ", isValid=" + isValid + ", createTime="
				+ createTime + ", creator=" + creator + ", modifyTime=" + modifyTime + ", offset=" + offset
				+ ", pageSize=" + pageSize + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeKey == null) ? 0 : codeKey.hashCode());
		result = prime * result + codeOrder;
		result = prime * result + ((codeValue == null) ? 0 : codeValue.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + id;
		result = prime * result + ((isValid == null) ? 0 : isValid.hashCode());
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + offset;
		result = prime * result + pageSize;
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
		PaymentVO other = (PaymentVO) obj;
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
