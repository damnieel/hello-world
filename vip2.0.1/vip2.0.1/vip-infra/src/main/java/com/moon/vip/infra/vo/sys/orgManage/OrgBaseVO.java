package com.moon.vip.infra.vo.sys.orgManage;

import java.io.Serializable;

/**
 * 机构信息表
 * OrgBaseVO<BR>
 * 创建人:lqc <BR>
 * 时间：2016年1月20日-上午11:00:51 <BR>
 * @version 2.0.0
 *
 */
public class OrgBaseVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6215030853473323646L;

	public Integer id;
	
	public String name;
	
	public Integer pId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	@Override
	public String toString() {
		return "OrgBaseVO [id=" + id + ", name=" + name + ", pId=" + pId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pId == null) ? 0 : pId.hashCode());
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
		OrgBaseVO other = (OrgBaseVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pId == null) {
			if (other.pId != null)
				return false;
		} else if (!pId.equals(other.pId))
			return false;
		return true;
	}

}
