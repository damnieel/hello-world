package com.moon.vip.service.impl.sys;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.moon.vip.application.sys.RoleMenuResourceSqlMapper;
import com.moon.vip.infra.vo.RoleVO;
import com.moon.vip.infra.vo.sys.MenuVO;
import com.moon.vip.service.sys.IMenuService;

@Service("iMenuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private RoleMenuResourceSqlMapper roleMenuResourceSqlMapper;
	
	@Cacheable("GetMainMenu")
	public List<MenuVO> getMenu(HashSet<Integer> roles) {
		return roleMenuResourceSqlMapper.findMainMenuByRoleId(roles);
	}
	
	@Cacheable("GetSubMenu")
	public List<MenuVO> getSubMenu(HashSet<Integer> roles) {
		return roleMenuResourceSqlMapper.findSubMenuByRoleId(roles);
	}
	
	@Cacheable("GetAllSubMenu")
	public List<MenuVO> getAllSubMenu() {
		return roleMenuResourceSqlMapper.findAllSubMenu();
	}

	public HashSet<Integer> getRolesStr(List<RoleVO> roleList) {
		HashSet<Integer> roleIds = new HashSet<Integer>();
		for(RoleVO r: roleList) {
			roleIds.add(r.getRoleId());
		}
		return roleIds;
	}
	
	
}
