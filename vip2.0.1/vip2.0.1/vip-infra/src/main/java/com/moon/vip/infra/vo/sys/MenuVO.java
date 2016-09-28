package com.moon.vip.infra.vo.sys;

import java.io.Serializable;

/**
 * 
 * @ClassName: MenuVO 
 * @Description: 存储menu资源
 * @author A18ccms a18ccms_gmail_com 
 * @date 2015年12月24日 下午12:39:54 
 *
 */
public class MenuVO implements Serializable {
	
	private static final long serialVersionUID = 5652664588818643720L;
	/**
	 * 菜单ID
	 */
	private Integer id;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 菜单显示样式
	 */
	private String className;
	/**
	 * 菜单name 区分
	 */
	private String menuLableId;
	/**
	 * 菜单响应Url
	 */
	private String url;
	/**
	 * 父节点id
	 */
	private Integer parentId;
	/**
	 * 是否有效 Y or N
	 */
	private String isValid;
	/**
	 * 父节点的menuLableId
	 */
	private String parentMenuLableId;
	/**
	 * 父节点的名称
	 */
	private String parentMenuLableName;
	
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMenuLableId() {
		return menuLableId;
	}
	public void setMenuLableId(String menuLableId) {
		this.menuLableId = menuLableId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	@Override
	public String toString() {
		return "MenuVO [id=" + id + ", name=" + name + ", className=" + className + ", menuLableId=" + menuLableId
				+ ", url=" + url + ", parentId=" + parentId + ", isValid=" + isValid + ", parentMenuLableId="
				+ parentMenuLableId + ", parentMenuLableName=" + parentMenuLableName + "]";
	}
	public String getParentMenuLableId() {
		return parentMenuLableId;
	}
	public void setParentMenuLableId(String parentMenuLableId) {
		this.parentMenuLableId = parentMenuLableId;
	}
	public String getParentMenuLableName() {
		return parentMenuLableName;
	}
	public void setParentMenuLableName(String parentMenuLableName) {
		this.parentMenuLableName = parentMenuLableName;
	}	
	
}
