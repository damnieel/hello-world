package com.moon.vip.application.sys;

import java.util.List;

import com.moon.vip.model.sys.EmployeeRole;

public interface EmployeeRoleSqlMapper {
   
	/**
	 * 删除角色的所有菜单<br/> 
	 * @Title: deleteByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月18日 下午3:39:34  <br/> 
	 * @param roleId
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int deleteByRoleId(int roleId);
	
	/**
	 * 
	 * 日期：2016年3月28日 下午9:44:20<br/>
	 * 描述：根据员工id 获取角色<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午9:44:20 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param id
	 * @return<br/>
	 * List<EmployeeRole>
	 */

	public List<EmployeeRole> selectByEmpId(String id);
	
	
	/**
	 * 
	 * 日期：2016年3月30日 上午11:19:45<br/>
	 * 描述：根据用户Id删除角色信息<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午11:19:45 ruruo <br/>
	 * 修改备注：TODO<br/>
	 * @param employeeId
	 * @return<br/>
	 * int
	 */

	public int deleteEmpRoleByEmpId(Integer employeeId);
}