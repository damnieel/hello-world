package com.moon.vip.infra.vo.sys;

/** @author 雷雷
 *  OrganizationalProfessionalSqlMapper.xml对应的实体类
 */
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TeacherVO implements Serializable  {
     /**op_id**/
	private Integer opId;
	/**取值**/
	private String type;
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}

	private String type1;
	
	/**employee_code**/
	private String employeeCode;
	public String getEmployeeCode1() {
		return employeeCode1;
	}
	public void setEmployeeCode1(String employeeCode1) {
		this.employeeCode1 = employeeCode1;
	}

	private String employeeCode1;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;
	/**creator**/
	private String creator;
	/*name*/
	private String name;
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

	/**别民**/
	private String nickName;
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getOpId() {
		return opId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime2) {
		this.createTime = createTime2;
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
	@Override
	public String toString() {
		return "TeacherVO [opId=" + opId + ", type=" + type + ", type1=" + type1 + ", employeeCode=" + employeeCode
				+ ", employeeCode1=" + employeeCode1 + ", createTime=" + createTime + ", creator=" + creator
				+ ", name=" + name + ", nickName=" + nickName + "]";
	}
	public void setEmployeeCode(String string) {
		this.employeeCode = string;
	}
	
	
}
