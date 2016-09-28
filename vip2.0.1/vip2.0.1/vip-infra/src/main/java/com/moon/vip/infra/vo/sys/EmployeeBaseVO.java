package com.moon.vip.infra.vo.sys;
/**
 * @author 雷雷
 * OrganizationalProfessionalSqlMapper.xml对应的实体类
 * 
 *
 */
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeBaseVO implements Serializable{
	
	/**employee_code**/
	private int employeeCode;
	/**名字**/
	private String name;
	/**别名**/
	private String nickName;
	/**creator**/
	private String creator;
	 /**创建时间**/
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "EmployeeBaseVO [employeeCode=" + employeeCode + ", name=" + name + ", nickName=" + nickName
				+ ", creator=" + creator + ", createTime=" + createTime + ", organizationId=" + organizationId + "]";
	}
	public int getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(int i) {
		this.employeeCode = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	/**organization_id**/
	private Integer organizationId;
}
