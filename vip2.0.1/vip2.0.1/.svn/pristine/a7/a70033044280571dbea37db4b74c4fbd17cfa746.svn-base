package com.moon.vip.controller.sys.roleManage;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.moon.vip.application.sys.RoleSqlMapper;
import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.util.StringUtil;
import com.moon.vip.infra.vo.sys.roleManage.RoleMenuDataOperVO;
import com.moon.vip.infra.vo.sys.roleManage.TreeVO;
import com.moon.vip.model.sys.ActionType;
import com.moon.vip.model.sys.DataRule;
import com.moon.vip.model.sys.Role;
import com.moon.vip.service.sys.roleManage.IRoleManageService;
import com.moon.vip.service.sys.userManage.IUserManageService;
import com.moon.vip.application.sys.RoleMapper;

@Controller
@RequestMapping("admin/roleManage")
public class RoleManagerController extends BaseController{

	private Logger logger = Logger.getLogger(RoleManagerController.class);
	@Autowired
	private IUserManageService iUserManageService;
	
	@Autowired
	private IRoleManageService iRoleManageService;
	
	@Autowired
	private RoleSqlMapper roleSqlMapper;
	@Autowired
	private RoleMapper roleMapper;
	
	@RequestMapping("/roleManagePage")
	public String touserManagerPage(Model model) {
		logger.info(String.format("管理员%s进入角色管理页面", getUserCode()));
		List<RoleMenuDataOperVO> roleList = iRoleManageService.selectDataMenuByRoleId(0);
		model.addAttribute("list", roleList);
		return "/page/sys/roleManage/roleManagePage";
	}
	@RequestMapping("/addRolePage")
	public String toAddUserPage(Model model) {
		logger.info(String.format("管理员%s进入编辑角色页面", getUserCode()));
		if(getRequest().getParameter("roleId") != null) {//根据roleid获取role内容
			String roleId = getRequest().getParameter("roleId");
			Role roleInfo = roleMapper.selectByPrimaryKey(Integer.valueOf(roleId));
			model.addAttribute("roleInfo", roleInfo);
		} 
		return "/page/sys/roleManage/addRole";
	}
	@RequestMapping("/editRoleMenu")
	public String editRoleMenu(Model model) {
		String roleId = getRequest().getParameter("roleId");
		List<TreeVO> allMenu = iRoleManageService.selectMenuResByRoleId(0);
		List<TreeVO> roleIdMenu = iRoleManageService.selectMenuResByRoleId(Integer.valueOf(roleId));
		List<Integer> idList = new ArrayList<Integer>();
		for(TreeVO tree: roleIdMenu) {
			for(TreeVO t: tree.getTree()) {
				idList.add(t.getId());
			}
		}
		model.addAttribute("roleId", roleId);
		model.addAttribute("allMenu", allMenu);
		model.addAttribute("idList", idList);
		return "/page/sys/roleManage/editMenuAuth";
	}

	@RequestMapping("/editRoleMenuAction")
	@ResponseBody
	public Message editRoleMenuAction(@RequestParam(value = "menuIds[]", required=false)List<Integer> menuIds, Integer roleId) {
		Message msg = new Message();
		
		if(roleId == null || roleId == 0) {
			msg.setMsg("角色id为空， 请联系管理员");
			msg.setResult(false);
			return msg;
		}

		msg = iRoleManageService.editRoleMenuAction(menuIds, roleId, getUserCode());
		
		if(menuIds == null) {
			logger.info(String.format("管理员%s将角色（%d）菜单全部删除，结果：%s", 
					getUserCode(), roleId, msg.toString()));
		} else {
			logger.info(String.format("管理员%s将角色（%d）菜单更改为%s，结果：%s", 
					getUserCode(), roleId, menuIds.toString(), msg.toString()));
		}
		return msg;
	}
	@RequestMapping("/editDataAct")
	public String editDataAct(Model model) {
		List<DataRule> ruleList = iRoleManageService.selectAllRule();
		List<ActionType> actList = iRoleManageService.selectAllAct();
		
		String roleId = getRequest().getParameter("roleId");
		List<TreeVO> dataActList = iRoleManageService.selectDataActByRoleId(Integer.valueOf(roleId));
		String list = JSONArray.toJSONString(dataActList);
		model.addAttribute("ruleList", ruleList);
		model.addAttribute("actList", actList);
		model.addAttribute("dataActList", list);
		model.addAttribute("roleId", roleId);
		return "/page/sys/roleManage/editDataActAuth";
	}	
	@RequestMapping("/editDataActAction")
	@ResponseBody
	public Message editDataActAction(String ruleActId, String roleId) {
		Message msg = new Message();
		
		if(StringUtil.isNull(roleId)) {
			msg.setMsg("角色id为空， 请联系管理员");
			msg.setResult(false);
			return msg;
		}
		
		msg = iRoleManageService.insertDataActByRoleId(ruleActId, roleId, getUserCode());
		logger.info(String.format("管理员%s将角色%s的数据操作权限更改为%s，结果：%s", 
				getUserCode(),roleId, ruleActId, msg.toString()));
		return msg;
	}
	@RequestMapping("/saveRole")
	@ResponseBody
	public Message saveRole(Role role) {
		Message msg = new Message();
		if(role.getId() != null) {
			if(role.getId().compareTo(7) == -1) {
				msg.setResult(false);
				msg.setMsg("角色为默认角色，不能编辑该角色");
				return msg;
			}			
		}
		
		msg = iRoleManageService.insertOrUpdateRole(role, getUserCode());
		
		logger.info(String.format("管理员%s添加新角色%s,结果：%s", 
				getUserCode(), role.toString(), msg.toString()));
		return msg;
	}
	@RequestMapping("/deleteRoleByRoleId")
	@ResponseBody
	public Message deleteRoleByRoleId(Integer roleId) {
		Message msg = new Message();
		
		if(roleId == null || roleId.equals(0)) {
			msg.setResult(false);
			msg.setMsg("角色id为空，无法删除该角色");
			return msg;
		}
		if(roleId.compareTo(7) == -1) {
			msg.setResult(false);
			msg.setMsg("角色为默认角色，不能编辑该角色");
			return msg;
		}
		
		msg = iRoleManageService.deleteRoleByRoleId(roleId, getUserCode());		
		logger.info(String.format("管理员%s删除角色%d,结果：%s", getUserCode(), roleId, msg.toString()));
		return msg;
	}
}
