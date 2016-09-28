package com.moon.vip.application.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.sys.userManage.UserRoleInfoVO;
import com.moon.vip.infra.vo.sys.roleManage.RoleDataOperVO;

public interface RoleSqlMapper {
	/**
	 * 获取角色信息<br/> 
	 * @Title: selectAllRole <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月6日 下午2:50:13  <br/> 
	 * @return
	 * List<Role>
	 * @throws  <br/>
	 */
	List<UserRoleInfoVO> selectAllRole();
	
	/**
	 * 根据工号查找该员工所有的roleid<br/> 
	 * @Title: selectRoleIdByEmpCode <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月8日 下午8:24:28  <br/> 
	 * @param employeeCode
	 * @return
	 * List<Integer>
	 * @throws  <br/>
	 */
	List<Integer> selectRoleIdByEmpCode(@Param("employeeCode")String employeeCode);
	/**
	 * 根据用户id删除所有的empRoleId<br/> 
	 * @Title: delByUserId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月8日 下午8:54:33  <br/> 
	 * @param id
	 * @return
	 * int
	 * @throws  <br/>
	 */
	void delByUserId(int id);
	/**
	 * 根据员工id roleid 和动作类型来确定是否显示标签<br/> 
	 * @Title: selectOperType <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月14日 下午3:28:34  <br/> 
	 * @param roleDataOperVO
	 * @return
	 * int
	 * @throws  <br/>
	 */
	int selectOperType(RoleDataOperVO roleDataOperVO);
	/**
	 * 数据库中是否存在该角色<br/> 
	 * @Title: selectByRoleName <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月23日 下午6:10:57  <br/> 
	 * @param roleName
	 * @return
	 * int
	 * @throws  <br/>
	 */
	int selectByRoleName(@Param("roleName")String roleName);
}