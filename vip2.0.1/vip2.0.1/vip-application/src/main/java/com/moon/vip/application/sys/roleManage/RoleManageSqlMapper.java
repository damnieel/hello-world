package com.moon.vip.application.sys.roleManage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.sys.roleManage.RoleMenuDataOperVO;

public interface RoleManageSqlMapper {
	
	/**
	 * 根据roleId 获取菜单，数据权限<br/> 
	 * @Title: selectDataMenuByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月16日 下午4:22:52  <br/> 
	 * @param roleId
	 * @return
	 * RoleMenuDataOperVO
	 * @throws  <br/>
	 */
	public List<RoleMenuDataOperVO> selectDataMenuByRoleId(@Param("roleId")Integer roleId);
	/**
	 * 如果roleId =0 获取所有， 如果roleId有值，就获取该角色的所有菜单 <br/> 
	 * @Title: selectMenuResByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月18日 上午11:20:35  <br/> 
	 * @param roleId
	 * @return
	 * List<>
	 * @throws  <br/>
	 */
	public List<RoleMenuDataOperVO> selectMenuResByRoleId(@Param("roleId")Integer roleId);

	/**
	 * 如果roleId =0 获取所有， 如果roleId有值，就获取该角色的所有规则和操 <br/> 
	 * @Title: selectMenuResByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月18日 上午11:20:35  <br/> 
	 * @param roleId
	 * @return
	 * List<>
	 * @throws  <br/>
	 */
	public List<RoleMenuDataOperVO> selectDataActByRoleId(@Param("roleId")Integer roleId);
}
