package com.moon.vip.controller.sys.userManage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.application.sys.RoleSqlMapper;
import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.infra.vo.sys.userManage.UserManageVO;
import com.moon.vip.infra.vo.sys.userManage.UserParamsVO;
import com.moon.vip.infra.vo.sys.userManage.UserRoleInfoVO;
import com.moon.vip.service.sys.userManage.IUserManageService;

@Controller
@RequestMapping("admin/userManage")
public class UserManagerController extends BaseController{

	private Logger logger = Logger.getLogger(UserManagerController.class);
	@Autowired
	private IUserManageService iUserManageService;
	
	@Autowired
	private RoleSqlMapper roleSqlMapper;
	
	@RequestMapping("/userManagePage")
	public ModelAndView touserManagerPage() {
		ModelAndView mav=new ModelAndView();
		List<UserRoleInfoVO>  roleList=iUserManageService.selectAllRole();
		mav.addObject("roleList", roleList);
		mav.setViewName("/page/sys/userManage/userManagePage");
		logger.info(String.format("员工（%s）进入用户管理", getUserCode()));
		return mav;
	}
	@RequestMapping("/addUserPage")
	public String toAddUserPage(Model model, String employeeCode) {
		List<UserRoleInfoVO> roleList = iUserManageService.selectAllRole();
		if(employeeCode != null) {
			UserManageVO addUserVO = iUserManageService.selectEmpByEmpCode(employeeCode);
			model.addAttribute("addUserVO", addUserVO);
			List<Integer> roleIdList = roleSqlMapper.selectRoleIdByEmpCode(employeeCode);
			model.addAttribute("roleIdList", roleIdList);
		}
		model.addAttribute("roleList", roleList);
		return "/page/sys/userManage/addUser";
	}
	
	@RequestMapping("/getUserCount")
	@ResponseBody
	public int getUserCount(ParamsVO paramsVO) {
		int count = iUserManageService.selectUserManageDataCount(paramsVO);		
		return count;
	}
	@RequestMapping("/getUserData")
	public ModelAndView getUserData(ParamsVO paramsVO) {
		ModelAndView modelAndView = new ModelAndView();
		List<UserManageVO> userList = iUserManageService.selectUserManageData(paramsVO);
		modelAndView.addObject("list", userList);
		modelAndView.setViewName("/page/sys/userManage/userManageTemplate");
		return modelAndView;
	}
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public UserManageVO getUserInfo(String employeeCode) {
		logger.info("获取工号的员工信息  employeeCode: " + employeeCode);
		
		UserManageVO addUserVO = iUserManageService.selectEmpByEmpCode(employeeCode);
		return addUserVO;
	}	
	/**
	 * 
	 * checkRepeat(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param employeeCode 工号
	 * @param nickName  昵称
	 * @return
	  *int
	 * @exception
	 * @since  1.0.0
	 */
	@RequestMapping("/checkRepeat")
	@ResponseBody
	public int checkRepeat(String employeeCode,String nickName){
		return  iUserManageService.checkRepeat(employeeCode, nickName);
	}
	
	
	@RequestMapping("/checkRepeatByCodeandNicName")
	@ResponseBody
	public int checkRepeatByCodeandNicName(String employeeCode,String nickName){
		return  iUserManageService.checkRepeatAnd(employeeCode, nickName);
	}
		
	/**
	 * 
	 * assignRole(增添用户)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param paramsVO
	 * @return
	 * Message
	 * @exception
	 * @since  1.0.0
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public Message addUser(HttpServletRequest request,UserParamsVO paramsVO) {
		logger.info(String.format("增添员工[%s]。 管理员（%s）", 
				paramsVO.toString(), getUserInfo().getEmployeeCode()));
		
		Message msg = new Message();
	   try{
			msg = iUserManageService.addUser(request,paramsVO,getUserInfo().getEmployeeCode());
			return msg;
	   }catch(BusinessException e){
		   msg.setResult(false);
		   msg.setMsg("增添用户到SSO系统失败");
		   return msg;
	   }catch(Exception e){
		   logger.error("增添用户失败",e);
		   msg.setResult(false);
		   msg.setMsg("增添用户失败");
		   return msg;
	   }
	}	
	
	/**
	 * 
	 * 日期：2016年3月29日 上午11:09:45<br/>
	 * 描述：修改员工数据<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午11:09:45 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param paramsVO
	 * @return<br/>
	 * Message
	 */
	@RequestMapping("/editUser")
	@ResponseBody
	public Message editUser(UserParamsVO paramsVO) {
		logger.info(String.format("修改员工[%s]。 管理员（%s）", 
				paramsVO.toString(), getUserInfo().getEmployeeCode()));
		
		Message msg = new Message();
	   try{
			msg = iUserManageService.editUser(paramsVO,getUserInfo().getEmployeeCode());
			return msg;
	   }catch(Exception e){
		   logger.error("修改用户失败",e);
		   msg.setResult(false);
		   msg.setMsg("修改用户失败");
		   return msg;
	   }
	}	
	
	
	
	
	
	
	
	

	@RequestMapping("/saveRole")
	@ResponseBody
	public Message saveRole(ParamsVO paramsVO, HttpSession session) {
		logger.info(getUserCode() + "保存角色");
		
		Message msg = new Message();
		EmployeeLoginVO emp = (EmployeeLoginVO) session.getAttribute("employee");
		paramsVO.setCreator(emp.getEmployeeCode());
		msg = iUserManageService.insertEmpRole(paramsVO.getCreator(), paramsVO.getIdArray(), paramsVO.getRoleIdArray());
		
		logger.info(String.format("员工(%s)将员工(id%s)配置角色(id%s), 配置结果: %s", 
				emp.getEmployeeCode(), paramsVO.getIdArray(), paramsVO.getRoleIdArray(), msg.getMsg()));
		
		return msg;
	}	
	
	@RequestMapping("/delEmpRole")
	@ResponseBody
	public Message delEmpRole(HttpServletRequest request,Integer employeeId, String  employeeCode) {
		  logger.info(String.format("员工（%s）执行删除员工[%s]操作", getUserCode(),employeeCode));
		  try{
		     return iUserManageService.deleteEmpoyee(request,employeeId,employeeCode);
		  }catch(BusinessException e){
			   Message msg = new Message();
			   msg.setResult(false);
			   msg.setMsg(e.getExceptionMsg());
			   return msg;
		  }catch (Exception e) {
			   logger.error("服务器异常，删除失败", e);
			   Message msg = new Message();
			   msg.setResult(false);
			   msg.setMsg("服务器异常,删除失败,请联系管理员");
			   return msg;
		  }
		
	}		
	
	@RequestMapping("/resetPsw")
	@ResponseBody
	public Message resetPsw(String id) {
		logger.info(String.format("员工（%s）执行重置密码操作", getUserCode()));
		
		return iUserManageService.resetPsw(id);
	}	
	
	@RequestMapping("/assignRole")
	@ResponseBody
	public Message assignRole(ParamsVO paramsVO) {
		logger.info(String.format("重新为员工（id-%s）配置角色（id-%s）。 管理员（%s）", 
				paramsVO.getIdArray(), paramsVO.getRoleIdArray(), getUserInfo().getEmployeeCode()));
		
		Message msg = new Message();
		paramsVO.setCreator(getUserInfo().getEmployeeCode());
		msg = iUserManageService.assignRole(paramsVO);
		return msg;
	}	
	
	
	@RequestMapping("/editUserPage")
	public String editUserPage(Model model, String employeeCode) {
		List<UserRoleInfoVO> roleList = iUserManageService.selectAllRole();
		if(employeeCode != null) {
			UserManageVO addUserVO = iUserManageService.selectEmpByEmpCode(employeeCode);
			model.addAttribute("addUserVO", addUserVO);
			List<Integer> roleIdList = roleSqlMapper.selectRoleIdByEmpCode(employeeCode);
			model.addAttribute("roleIdList", roleIdList);
		}
		model.addAttribute("type", "edit");
		model.addAttribute("roleList", roleList);
		return "/page/sys/userManage/addUser";
	}
	
}
