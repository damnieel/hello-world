package com.moon.vip.service.impl.sys.roleManage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.moon.vip.application.sys.DataRuleSqlMapper;
import com.moon.vip.application.sys.EmployeeRoleSqlMapper;
import com.moon.vip.application.sys.RoleDataActionMapper;
import com.moon.vip.application.sys.RoleDataActionSqlMapper;
import com.moon.vip.application.sys.RoleMapper;
import com.moon.vip.application.sys.RoleMenuMapper;
import com.moon.vip.application.sys.RoleSqlMapper;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.util.StringUtil;
import com.moon.vip.infra.vo.sys.roleManage.RoleDataOperVO;
import com.moon.vip.infra.vo.sys.roleManage.RoleMenuDataOperVO;
import com.moon.vip.infra.vo.sys.roleManage.TreeVO;
import com.moon.vip.model.sys.ActionType;
import com.moon.vip.model.sys.DataRule;
import com.moon.vip.model.sys.Role;
import com.moon.vip.model.sys.RoleDataAction;
import com.moon.vip.model.sys.RoleMenu;
import com.moon.vip.service.sys.roleManage.IRoleManageService;
import com.moon.vip.service.sys.userManage.IUserManageService;
import com.moon.vip.application.sys.roleManage.RoleManageSqlMapper;
import com.moon.vip.application.sys.ActionTypeMapper;

@Service("iRoleManageService")
public class RoleManageServiceImpl implements IRoleManageService {

	private Logger logger = Logger.getLogger(RoleManageServiceImpl.class);
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleSqlMapper roleSqlMapper;
	
	@Autowired
	private RoleManageSqlMapper roleManageSqlMapper;
	
	@Autowired
	private EmployeeRoleSqlMapper employeeRoleSqlMapper;
	
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	
	@Autowired
	private DataRuleSqlMapper dataRuleSqlMapper;
	
	@Autowired
	private ActionTypeMapper actionTypeMapper;
	
	@Autowired
	private IUserManageService iUserManageService;
	
	@Autowired
	private RoleDataActionSqlMapper roleDataActionSqlMapper;
	
	@Autowired
	private RoleDataActionMapper roleDataActionMapper;
	
	public int selectOperType(RoleDataOperVO roleDataOperVO) {
		return roleSqlMapper.selectOperType(roleDataOperVO);
	}

	
	private TreeVO getTree(RoleMenuDataOperVO vo, String type) {
		TreeVO m = new TreeVO();
		if(type.equalsIgnoreCase("menu")) {
			if(vo.getMenuId() == null || vo.getMenuName() == null) {
				return null;
			}
			m.setId(vo.getMenuId());
			m.setName(vo.getMenuName());
		}
		if(type.equalsIgnoreCase("rule")) {
			if(vo.getRuleId() == null || vo.getRuleName() == null) {
				return null;
			}
			m.setId(vo.getRuleId());
			m.setName(vo.getRuleName());
		}
		if(type.equalsIgnoreCase("act")) {
			if(vo.getActId() == null || vo.getActName() == null) {
				return null;
			}
			m.setId(vo.getActId());
			m.setName(vo.getActName());
		}
		return m;
	}
	private int hasNewDataId(RoleMenuDataOperVO vo, Integer id, String type) {
		int index = -1;
		if(type.equalsIgnoreCase("menu")) {
/*			if(vo.getMenuAuth() == null) {
				
			}*/
			for(int i=0;i<vo.getMenuAuth().size();i++) {
				if(vo.getMenuAuth().get(i).getId().equals(id)) {
					index = i;
					break;
				}
			}
		}
		if(type.equalsIgnoreCase("rule")) {
			for(int i=0;i<vo.getRuleAct().size();i++) {
				if(vo.getRuleAct().get(i).getId().equals(id)) {
					index = i;
					break;
				}
			}
		}
		if(type.equalsIgnoreCase("act")) {
			for(int i=0;i<vo.getRuleAct().size();i++) {
				for(int j=0;i<vo.getRuleAct().get(i).getTree().size();i++) {
					if(vo.getRuleAct().get(i).getTree().get(j).getId().equals(id)) {
						index = i;
						break;
					}
				}
			}
		}
		return index;
	}
	private int hasActId(RoleMenuDataOperVO vo, Integer id, int ruleIndexId) {
		int index = -1;
		for(int i=0;i<vo.getRuleAct().get(ruleIndexId).getTree().size();i++) {
			if(vo.getRuleAct().get(ruleIndexId).getTree().get(i).getId().equals(id)) {
				index = i;
				break;
			}
		}
		return index;
	}

	private int hasSubMenuId(RoleMenuDataOperVO vo, Integer id, Integer mainId) {
		int index = -1;
		for(int i=0;i<vo.getMenuAuth().get(mainId).getTree().size();i++) {
			if(vo.getMenuAuth().get(mainId).getTree().get(i).getId().equals(id)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public List<RoleMenuDataOperVO> selectDataMenuByRoleId(Integer roleId) {
		List<RoleMenuDataOperVO> list = roleManageSqlMapper.selectDataMenuByRoleId(roleId);
		List<RoleMenuDataOperVO> resList = new ArrayList<RoleMenuDataOperVO>();
		int resIndex = 0;

		/**
		 * 将第一个数据加入到菜单树 和 规则数
		 */
		resList.add(list.get(0));
		if(getTree(resList.get(0), "menu") != null)
			resList.get(0).getMenuAuth().add(getTree(resList.get(0), "menu"));
		if(getTree(resList.get(0), "rule") != null)
			resList.get(0).getRuleAct().add(getTree(resList.get(0), "rule"));
		
		for(int i=0; i< list.size();i++) {
			/**
			 * 一个角色的数据
			 */
			if(resList.get(resIndex).getRoleId().equals(list.get(i).getRoleId())) {	
				/**
				 * 调整菜单信息
				 */
				if(list.get(i).getMenuParentId() == null) {
					if(hasNewDataId(resList.get(resIndex), list.get(i).getMenuId(), "menu") == -1) {
						if(getTree(list.get(i), "menu") != null)
							resList.get(resIndex).getMenuAuth().add(getTree(list.get(i), "menu"));
					} 
				} else {
					int k = hasNewDataId(resList.get(resIndex), list.get(i).getMenuParentId(), "menu");
					if(k == -1) {
						logger.info("该子菜单没有主菜单");
					} else {
						if(hasSubMenuId(resList.get(resIndex), list.get(i).getMenuId(), k) == -1)
							if(getTree(list.get(i), "menu") != null)
								resList.get(resIndex).getMenuAuth().get(k).getTree().add(getTree(list.get(i), "menu"));
					}
				}				
				/**
				 * 调整规则信息
				 */
				int ruleIdIndex = hasNewDataId(resList.get(resIndex), list.get(i).getRuleId(), "rule");
				if(ruleIdIndex == -1) {
					if(getTree(list.get(i), "rule") != null)
						resList.get(resIndex).getRuleAct().add(getTree(list.get(i), "rule"));

					if(getTree(list.get(i), "act") != null)
						resList.get(resIndex).getRuleAct().get(resList.get(resIndex).getRuleAct().size()-1)
							.getTree().add(getTree(list.get(i), "act"));
					
				} else {
					int index = hasActId(resList.get(resIndex), list.get(i).getActId(), ruleIdIndex);
					if(index == -1) {
						if(getTree(list.get(i), "act") != null)
							resList.get(resIndex).getRuleAct().get(ruleIdIndex).getTree().add(getTree(list.get(i), "act"));
					} 
				}
				
			} else {
				resList.add(list.get(i));
				if(getTree(list.get(i), "menu") != null) {
					resList.get(resList.size() - 1).getMenuAuth().add(getTree(list.get(i), "menu"));
				}
				if(getTree(list.get(i), "rule") != null) {
					resList.get(resList.size() - 1).getRuleAct().add(getTree(list.get(i), "rule"));
				}
				resIndex ++;
			}			
		}		
		return resList;
	}


	public List<TreeVO> selectMenuResByRoleId(Integer roleId) {
		List<RoleMenuDataOperVO> menuList = roleManageSqlMapper.selectMenuResByRoleId(roleId);
		List<TreeVO> resList = new ArrayList<TreeVO>();
		for(RoleMenuDataOperVO vo : menuList) {
			if(vo.getMenuParentId() == null) {
				resList.add(getTree(vo, "menu"));
			} else {
				for(TreeVO tree : resList) {
					if(tree.getId().equals(vo.getMenuParentId())) {
						tree.getTree().add(getTree(vo, "menu"));
					}
				}
			}
		}
		return resList;
	}


	public List<TreeVO> selectDataActByRoleId(Integer roleId) {
		List<RoleMenuDataOperVO> dataActList = roleManageSqlMapper.selectDataActByRoleId(roleId);
		List<TreeVO> resList = new ArrayList<TreeVO>();
		List<TreeVO> resList2 = new ArrayList<TreeVO>();

		for(RoleMenuDataOperVO vo:dataActList) {
			TreeVO rule = getTree(vo, "rule");
			rule.getTree().add(getTree(vo, "act"));
			resList.add(rule);
		}
		if(resList.size() == 0) {
			return null;
		}
		
		resList2.add(resList.get(0));
		for(TreeVO tree: resList) {
			int index = TreeHasEm(resList2, tree.getId());
			if(index != -1) {
				int actId = tree.getTree().get(0).getId();
				if(TreeHasEm(resList2.get(index).getTree(), actId) == -1) {
					resList2.get(index).getTree().add(tree.getTree().get(0));
				}
			} else {
				resList2.add(tree);
			}
		}
		return resList2;
	}
	private int TreeHasEm(List<TreeVO> list, Integer id) { 
		for(int i=0; i< list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;		
	}

	public Message editRoleMenuAction(List<Integer> menuIds, int roleId, String userCode) {
		Message msg = new Message();
		employeeRoleSqlMapper.deleteByRoleId(roleId);
		
		if(menuIds != null) {
			for(int i=0;i<menuIds.size();i++) {
				RoleMenu rm = new RoleMenu();
				rm.setCreateTime(new Date());
				rm.setCreator(userCode);
				rm.setMenuId(menuIds.get(i));
				rm.setRoleId(roleId);
				int k = roleMenuMapper.insertSelective(rm);
				if(k == 0) {
					msg.setResult(false);
					msg.setMsg("插入失败 rm :" + rm);
					return msg;
				}
				logger.info("更改角色菜单 插入rm: " + rm);
			}
			iUserManageService.clearUserCashe();			
		}
		msg.setResult(true);	
		return msg;
	}


	public List<DataRule> selectAllRule() {
		return dataRuleSqlMapper.selectAllRule();
	}


	public List<ActionType> selectAllAct() {
		return actionTypeMapper.selectAllAct();
	}


	public Message insertDataActByRoleId(String ruleActId, String roleId, String creator) {
		
		Message msg = new Message();
		roleDataActionSqlMapper.deleteDataActByRoleId(Integer.valueOf(roleId));
		List<RoleMenuDataOperVO> dataActList = JSONArray.parseArray(ruleActId, RoleMenuDataOperVO.class);
		for(RoleMenuDataOperVO vo :dataActList) {
			RoleDataAction rda = new RoleDataAction();
			rda.setRoleId(Integer.valueOf(roleId));
			rda.setRuleId(vo.getRuleId());
			rda.setActionId(vo.getActId());
			
			rda.setCreateTime(new Date());
			rda.setCreator(creator);
			
			int k = roleDataActionMapper.insertSelective(rda);
			if(k == 0) {
				msg.setResult(false);
				msg.setMsg("插入该角色数据和权限失败");
				return msg;
			}
		}
		iUserManageService.clearUserCashe();
		msg.setMsg("更改角色数据和操作权限成功");
		msg.setResult(true);
		return msg;
	}


	public Message insertOrUpdateRole(Role role, String userCode) {
		Message msg = new Message();
		
		if(StringUtil.isNull(role.getName()) || StringUtil.isNull(role.getDescription()) 
				|| StringUtil.isNull(role.getCode())) {
			msg.setResult(false);
			msg.setMsg("名称或者描述或者代码为空， 请填写后保存");
			return msg;
		}
		
		if(role.getId() == null) {
			//插入数据
			int k = roleSqlMapper.selectByRoleName(role.getName());
			if(k != 0) {
				msg.setResult(false);
				msg.setMsg("系统中存在该角色的名称， 请更换名称");
				return msg;
			}
			
			role.setCreateTime(new Date());
			role.setCreator(userCode);
			role.setIsValid("Y");
			
			int index;
			try {
				index = roleMapper.insertSelective(role);
				if(index == 0) {
					msg.setResult(false);
					msg.setMsg("插入角色信息失败");
					return msg;
				}
			} catch (Exception e) {
				logger.info("异常处理：角色Code重复， 请更改");
				String exceptionType = e.getCause().getLocalizedMessage();
				if(exceptionType.contains("uq_code")) {
					msg.setResult(false);
					msg.setMsg("角色Code重复， 请更改");
					return msg;
				} else {
					e.printStackTrace(); 
				}
			}
		} else {
			//更新数据
			role.setUpdateTime(new Date());
			role.setUpdator(userCode);
			int j = roleMapper.updateByPrimaryKeySelective(role);
			if(j == 0) {
				msg.setResult(false);
				msg.setMsg("更新角色信息失败");
				return msg;
			}
		}
		
		msg.setResult(true);
		msg.setMsg("插入角色信息成功");
		return msg;
	}


	public Message deleteRoleByRoleId(Integer roleId, String updator) {
		Message msg = new Message();
		Role role = new Role();
		role.setId(roleId);
		role.setIsValid("N");
		role.setUpdateTime(new Date());
		role.setUpdator(updator);
		int k = roleMapper.updateByPrimaryKeySelective(role);
		if(k == 0) {
			msg.setResult(false);
			msg.setMsg("删除角色失败！");
			return msg;
		} else {
			msg.setResult(true);
			msg.setMsg("删除角色成功");
			return msg;
		}
	}
}
