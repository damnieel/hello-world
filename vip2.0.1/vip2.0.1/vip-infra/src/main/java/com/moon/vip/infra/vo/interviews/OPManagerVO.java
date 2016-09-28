package com.moon.vip.infra.vo.interviews;

import java.io.Serializable;
import java.util.Date;

public class OPManagerVO implements Serializable{
    /** 
	* @Fields serialVersionUID : TODO( ) 
	*/ 
	private static final long serialVersionUID = 1997094983972790365L;

	private Integer id;

    private Integer opId;

    private String type;

    private String employeeCode;

    private Date createTime;

    private String creator;

    private Date modifyTime;

    private String modifyUser;

    private Integer version;
    
    private String nickName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOpId() {
		return opId;
	}

	public void setOpId(Integer opId) {
		this.opId = opId;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "OPManagerVO [id=" + id + ", opId=" + opId + ", type=" + type + ", employeeCode=" + employeeCode
				+ ", createTime=" + createTime + ", creator=" + creator + ", modifyTime=" + modifyTime
				+ ", modifyUser=" + modifyUser + ", version=" + version + ", nickName=" + nickName + "]";
	}
    
   
	
}