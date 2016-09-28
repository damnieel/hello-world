package com.moon.vip.service.impl.sys.userManage;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.moon.client.sso.SingleSingOn;
import com.moon.client.vo.AccountVO;
import com.moon.vip.application.sys.EmployeeBaseMapper;
import com.moon.vip.application.sys.EmployeeBaseSqlMapper;
import com.moon.vip.application.sys.EmployeeRoleMapper;
import com.moon.vip.application.sys.EmployeeRoleSqlMapper;
import com.moon.vip.application.sys.RoleSqlMapper;
import com.moon.vip.application.sys.userManage.UserManagerSqlMapper;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.infra.vo.sys.userManage.UserManageVO;
import com.moon.vip.infra.vo.sys.userManage.UserParamsVO;
import com.moon.vip.infra.vo.sys.userManage.UserRoleInfoVO;
import com.moon.vip.model.sys.EmployeeBase;
import com.moon.vip.model.sys.EmployeeRole;
import com.moon.vip.service.sys.IClearCacheService;
import com.moon.vip.service.sys.userManage.IUserManageService;

@Service("iUserManageService")
public class UserManageServiceImpl implements IUserManageService {
	@Autowired
	private UserManagerSqlMapper userManagerSqlMapper;
	
	@Autowired
	private RoleSqlMapper roleSqlMapper;
	
	@Autowired
	private  EmployeeRoleMapper employeeRoleMapper;

	@Autowired
	private  EmployeeRoleSqlMapper employeeRoleSqlMapper;
	@Autowired
	private EmployeeBaseMapper employeeBaseMapper;
	@Autowired
	private EmployeeBaseSqlMapper employeeBaseSqlMapper;
	@Autowired
	private SingleSingOn singleSingOn;
	
	@Autowired
	private IClearCacheService iClearCacheService;
	
	@Autowired
	private SingleSingOn singleSignOn;

	private Logger logger = Logger.getLogger(UserManageServiceImpl.class);
	
	public void clearUserCashe() {
		iClearCacheService.clearAuthForOrgProfessional();
		iClearCacheService.clearConvertAuthToJSONArray();
		iClearCacheService.clearGetMainMenu();
		iClearCacheService.clearGetSubMenu();
		iClearCacheService.clearGetChildList();
		iClearCacheService.clearGetAllSubMenu();
		iClearCacheService.clearGetParentOrgList();
		iClearCacheService.clearGetChildOrgList();
		iClearCacheService.clearGetAllOrganization();
		iClearCacheService.clearSelectDataActByEmpId();
		
	}
	public List<UserManageVO> selectUserManageData(ParamsVO paramsVO) {
		return userManagerSqlMapper.selectUserManageData(paramsVO);
	}
	public int selectUserManageDataCount(ParamsVO paramsVO) {
		return userManagerSqlMapper.selectUserManageDataCount(paramsVO);
	}
	public UserManageVO selectEmpByEmpCode(String employeeCode) {
		return userManagerSqlMapper.selectEmpByEmpCode(employeeCode);
	}
	public List<UserRoleInfoVO> selectAllRole() {
		return roleSqlMapper.selectAllRole();
	}
	public Message insertEmpRole(String creator, String id, String roleId) {
		Message msg = new Message();
		EmployeeRole empRole = new EmployeeRole();

		empRole.setUpdateTime(new Date());
		empRole.setUpdator(creator);
		empRole.setCreateTime(new Date());
		empRole.setCreator(creator);
		empRole.setEmployeeId(Integer.valueOf(id));
		empRole.setRoleId(Integer.valueOf(roleId));
		int k = employeeRoleMapper.insertSelective(empRole);
		if(k==0) {
			msg.setResult(false);
			msg.setMsg("保存角色失败");
			return msg;
		} else {
			clearUserCashe();
			msg.setResult(true);
			msg.setMsg("保存角色成功");
			return msg;
		}
	}
	
	
	/**
	 * 
	 * 日期：2016年3月30日 上午11:17:27<br/>
	 * 描述：根据用户账号删除用户记录<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午11:17:27 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param employeeId
	 * @return<br/>
	 * Message
	 */
	 private Message delEmpRec(Integer employeeId) {
		Message msg = new Message();
	    int i = employeeRoleSqlMapper.deleteEmpRoleByEmpId(employeeId); //根据员工Id删除角色信息
	    logger.info(String.format("删除员工id为[%s]的角色记录[%s]条", employeeId,i));
	    employeeBaseMapper.deleteByPrimaryKey(employeeId);  //根据主键删除用户基础信息
	    logger.info(String.format("删除员工id为[%s]的基础信息成功", employeeId));
		clearUserCashe();
		msg.setResult(true);
		msg.setMsg("删除成功");
		return msg;
	}
	public Message resetPsw(String id) {
		Message msg = new Message();
		if(id == null) {
			msg.setResult(false);
			msg.setMsg("页面错误，请重新登陆");
			return msg;
		}

		EmployeeBase e = employeeBaseMapper.selectByPrimaryKey(Integer.valueOf(id));
		EmployeeBase eb = new EmployeeBase();
		eb.setId(Integer.valueOf(id));
		eb.setPassword(SysConstantsVal.INITPASSWORD);
		int k = employeeBaseMapper.updateByPrimaryKeySelective(eb);

		logger.info(String.format("员工信息%s被重置密码--%d", e.toString(), k));
		if(k==0) {
			msg.setResult(false);
			msg.setMsg("重置密码失败");
			return msg;
		} else {
			msg.setResult(true);
			msg.setMsg("重置密码成功");
			return msg;
		}

	}
	public Message assignRole(ParamsVO paramsVO) {
		Message msg = new Message();
		String[] ids = paramsVO.getIdArray().split(",");
		String[] roleIds = paramsVO.getRoleIdArray().split(",");
		for(int i=0;i<ids.length;i++) {
			roleSqlMapper.delByUserId(Integer.valueOf(ids[i]));
			for(int j=0;j<roleIds.length;j++) {
				msg = insertEmpRole(paramsVO.getCreator(), ids[i], roleIds[j]);
				if(!msg.isResult()) {
					return msg;
				}
			}
		}
		clearUserCashe();
		msg.setResult(true);
		msg.setMsg("分配角色成功");;
		return msg;
	}

	public int checkRepeat(String employeeCode, String nickName) {
		return userManagerSqlMapper.countEmployeeByParams(employeeCode,nickName);
	}
	public Message addUser(HttpServletRequest request,UserParamsVO paramsVO,String creator) {
		Message msg = new Message();
		if(checkRepeat(paramsVO.getEmployeeCode(), paramsVO.getNickName() )> 0){
			msg.setResult(false);
			msg.setMsg("用户信息已存在");
		}
		EmployeeBase record = new EmployeeBase();
		BeanUtils.copyProperties(paramsVO, record);
		record.setCreateTime(new Date());
		record.setCreator(creator);
	    employeeBaseMapper.insertSelective(record);
		EmployeeRole role = new EmployeeRole();
		BeanUtils.copyProperties(record, role);
		role.setId(null); //不传Id
		role.setEmployeeId(record.getId());
		role.setRoleId(paramsVO.getRoleId());
		employeeRoleMapper.insertSelective(role);
		addUserToSso(request, record);
		clearUserCashe();
		msg.setResult(true);
		msg.setMsg("增添用户成功");;
		return msg;
	}
	
	private void addUserToSso(HttpServletRequest request,EmployeeBase record){
		AccountVO account = new AccountVO();
		account.setAccount(record.getEmployeeCode());
		account.setCreateTime(record.getCreateTime());
		account.setCreator(record.getCreator());
		account.setIsDelete("y");
		account.setSystemCode(singleSingOn.getSystemCode());
		com.moon.client.vo.Message msg = singleSingOn.addNewAccount(request, account);
		if(!msg.isSuccess()){
			logger.error(msg.getDesc() + msg.getRespBody());
			throw new BusinessException(EnumCodeException.ADD_USER_TO_SSO_ERROR);
		}
	}

	
	/**
	 * 调用SSO接口对用户进行删除
	 */
	public Message delEmpRoleBySso(HttpServletRequest request,String emproleid) {
		Message message=new Message();
		com.moon.client.vo.Message  cmessage =new com.moon.client.vo.Message();
		
		cmessage= singleSignOn.removeSystemAuthorization(request, singleSignOn.getSystemCode(), emproleid);
		if(cmessage==null){
			message.setMsg("系统错误");
			message.setResult(false);
			return message;
		}
		message.setCode(cmessage.getCode());
		message.setMsg(cmessage.getDesc());
		message.setResult(cmessage.isSuccess());
		logger.info(String.format("操作ID%s",emproleid));
		return message;
	}
	public int checkRepeatAnd(String employeeCode, String nickName) {
		return userManagerSqlMapper.countEmploye(employeeCode,nickName);
	}
	public Message editUser(UserParamsVO paramsVO, String employeeCode) {
		Message msg=new Message();
		UserManageVO user= userManagerSqlMapper.selectEmpByEmpCode(paramsVO.getEmployeeCode());
		List<EmployeeRole> list = employeeRoleSqlMapper.selectByEmpId(user.getId());
		EmployeeRole role ;
		EmployeeBase emp = new EmployeeBase();
		emp.setName(paramsVO.getName());
		emp.setNickName(paramsVO.getNickName());
		emp.setId(Integer.valueOf(user.getId()));
	    employeeBaseMapper.updateByPrimaryKeySelective(emp);
	    if(list == null || list.size() == 0){
	    	role = getNewEmployeeRole(paramsVO,employeeCode);
	    	role.setEmployeeId(Integer.valueOf(user.getId()));
	    	employeeRoleMapper.insertSelective(role);
	    }
	    else if(list.size()> 1){
	    	msg.setResult(true);
	  		msg.setMsg("用户角色信息有误，存在多于1条的记录，联系管理员");;
	  		return msg;
	    }
	    else{
	        role = list.get(0);
	    	role.setRoleId(paramsVO.getRoleId());
	    	role.setUpdator(employeeCode);
	    	role.setUpdateTime(new Date());
	        employeeRoleMapper.updateByPrimaryKeySelective(list.get(0));
	    }
	    logger.info(String.format("[%s]更新员工基础信息[%s]", employeeCode,paramsVO.toString()));
	    
	    msg.setResult(true);
		msg.setMsg("修改用户成功");;
		return msg;
	}

   
	private EmployeeRole getNewEmployeeRole(UserParamsVO paramsVO, String employeeCode){
		EmployeeRole empRole = new EmployeeRole();
		empRole.setCreateTime(new Date());
		empRole.setCreator(employeeCode);
		//empRole.setEmployeeId(Integer.valueOf(paramsVO.getId()));
		empRole.setRoleId(paramsVO.getRoleId());
		empRole.setUpdateTime(new Date());
		empRole.setUpdator(employeeCode);
		return empRole;
	}
	public Message deleteEmpoyee(HttpServletRequest request,Integer employeeId,String employeeCode) {
		Message msg = new Message();
		if(employeeId == null || StringUtils.isEmpty(employeeCode)) {
			msg.setResult(false);
			msg.setMsg("员工工号或员工Id为空,删除失败");
			return msg;
		}
		msg = delEmpRec(employeeId);
		if(SysConstantsVal.SSO){  
			msg = delEmpRoleBySso(request, employeeCode);
			if(!msg.isResult()) {
				logger.error(String.format("在sso系统删除[%s]的vip权限失败,数据回滚", employeeCode));
				throw new BusinessException(EnumCodeException.DEL_USER_IN_SSO_FAIL);
			}
			logger.info(String.format("在sso系统删除了用户[%s]的vip权限", employeeCode));
		}
		return msg;
	}
}
