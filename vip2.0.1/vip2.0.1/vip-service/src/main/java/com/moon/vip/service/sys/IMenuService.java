package com.moon.vip.service.sys;

import java.util.HashSet;
import java.util.List;

import com.moon.vip.infra.vo.RoleVO;
import com.moon.vip.infra.vo.sys.MenuVO;

/**
 * 
 * @ClassName: IMenuService 
 * @Description: 菜单资源查询
 * @author 大枫
 * @date 2016年1月8日 下午1:37:30 
 *
 */
public interface IMenuService {
	/**
	 * 查询主菜单<br/> 
	 * @Title: getMenu <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月8日 下午1:37:02  <br/> 
	 * @param roles
	 * @return
	 * List<MenuVO>
	 * @throws  <br/>
	 */
	public 	List<MenuVO> getMenu(HashSet<Integer> roles);
	
	/**
	 * 查询子菜单， 当参数为null时， 获取全部的子菜单<br/> 
	 * @Title: getSubMenu <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月8日 下午1:37:15  <br/> 
	 * @param roles
	 * @return
	 * List<MenuVO>
	 * @throws  <br/>
	 */
	public List<MenuVO> getSubMenu(HashSet<Integer> roles);
	
	/**
	 * 获取所有的子菜单信息<br/> 
	 * @Title: getAllSubMenu <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月20日 下午3:30:12  <br/> 
	 * @return
	 * List<MenuVO>
	 * @throws  <br/>
	 */
	public List<MenuVO> getAllSubMenu();
	/**
	 * 从list获取roles的字符串， 以逗号相隔<br/> 
	 * @Title: getRolesStr <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月8日 下午1:34:15  <br/> 
	 * @param roleList
	 * @return
	 * String
	 * @throws  <br/>
	 */
	public HashSet<Integer> getRolesStr(List<RoleVO> roleList);
}
