package com.moon.vip.application.sys;

public interface RoleDataActionSqlMapper {
	/**
	 * 根据角色删除所有的数据和操作权限<br/> 
	 * @Title: deleteDataActByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月23日 下午1:41:19  <br/> 
	 * @param roleId
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public void deleteDataActByRoleId(Integer roleId);
}