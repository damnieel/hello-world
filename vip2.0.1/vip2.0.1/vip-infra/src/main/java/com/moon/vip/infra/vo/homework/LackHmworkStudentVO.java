package com.moon.vip.infra.vo.homework;

import java.io.Serializable;

/**
 * 缺交作业学生
 * LackHworkStudentVO<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月23日-下午7:16:58 <BR>
 * @version 2.0.0
 *
 */
public class LackHmworkStudentVO implements Serializable{
	private static final long serialVersionUID = 5307173585958619265L;
	private int lackNumber;
	private String professionCode;
	private String claName;
	private String telephone;
	private String name;
	private String nickName;
	private String qq;
	private String yy;
	
	public int getLackNumber() {
		return lackNumber;
	}
	public void setLackNumber(int lackNumber) {
		this.lackNumber = lackNumber;
	}
	public String getProfessionCode() {
		return professionCode;
	}
	public void setProfessionCode(String professionCode) {
		this.professionCode = professionCode;
	}
	public String getClaName() {
		return claName;
	}
	public void setClaName(String claName) {
		this.claName = claName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getYy() {
		return yy;
	}
	public void setYy(String yy) {
		this.yy = yy;
	}
	@Override
	public String toString() {
		return "LackHmworkStudentVO [lackNumber=" + lackNumber + ", professionCode=" + professionCode + ", claName="
				+ claName + ", telephone=" + telephone + ", name=" + name + ", nickName=" + nickName + ", qq=" + qq
				+ ", yy=" + yy + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((claName == null) ? 0 : claName.hashCode());
		result = prime * result + lackNumber;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((professionCode == null) ? 0 : professionCode.hashCode());
		result = prime * result + ((qq == null) ? 0 : qq.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((yy == null) ? 0 : yy.hashCode());
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
		LackHmworkStudentVO other = (LackHmworkStudentVO) obj;
		if (claName == null) {
			if (other.claName != null)
				return false;
		} else if (!claName.equals(other.claName))
			return false;
		if (lackNumber != other.lackNumber)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (professionCode == null) {
			if (other.professionCode != null)
				return false;
		} else if (!professionCode.equals(other.professionCode))
			return false;
		if (qq == null) {
			if (other.qq != null)
				return false;
		} else if (!qq.equals(other.qq))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (yy == null) {
			if (other.yy != null)
				return false;
		} else if (!yy.equals(other.yy))
			return false;
		return true;
	}
	
}
