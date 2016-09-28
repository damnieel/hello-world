package com.moon.vip.application.sys;

import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.sys.MenuVO;

public interface RoleMenuResourceSqlMapper {
	/**
	 * 根据roleId获取其所有的主菜单<br/> 
	 * @Title: findMainMenuByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月24日 下午12:55:13  <br/> 
	 * @param roles
	 * @return
	 * List<MenuVO>
	 * @throws  <br/>
	 */
	List<MenuVO> findMainMenuByRoleId(@Param("roleId")HashSet<Integer> roles);
	/**
	 * 根据roleId获取其所有的子菜单<br/> 
	 * @Title: findSubMenuByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月24日 下午12:56:09  <br/> 
	 * @param roles
	 * @return
	 * List<MenuVO>
	 * @throws  <br/>
	 */
	List<MenuVO> findSubMenuByRoleId(@Param("roleId")HashSet<Integer> roles);
	/**
	 * 获取所有的子菜单信息<br/> 
	 * @Title: findAllSubMenu <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月20日 下午3:26:29  <br/> 
	 * @return
	 * List<MenuVO>
	 * @throws  <br/>
	 */
	List<MenuVO> findAllSubMenu();
}
