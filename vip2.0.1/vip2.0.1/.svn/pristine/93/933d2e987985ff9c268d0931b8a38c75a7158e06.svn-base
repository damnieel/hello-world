package com.moon.vip.service.impl.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.moon.client.sso.SingleSingOn;
import com.moon.client.vo.Message;
import com.moon.vip.application.sys.EmployeeBaseSqlMapper;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.LoginInfoVO;
import com.moon.vip.infra.vo.RoleVO;
import com.moon.vip.service.login.IEmployeeLoginService;


@Service("iEmployeeLoginService")
public class EmployeeLoginServiceImpl implements IEmployeeLoginService {

	private Logger logger = Logger.getLogger(EmployeeLoginServiceImpl.class);
	
	@Autowired
	private EmployeeBaseSqlMapper employeeBaseSqlMapper;
	
	@Autowired
	private SingleSingOn singleSignOn;
	
	public boolean CompareEmployeeByCodeAndPwd(LoginInfoVO loginInfoVO, HttpSession session) {
	
		String loginCount = (String) session.getAttribute("loginCount");
		if (StringUtils.isEmpty(loginCount)) {
			loginCount = "0";
		}	
		/**
		 * 验证登陆密码
		 */
		int k = employeeBaseSqlMapper.selectByloginInfo(loginInfoVO);
		if(k == 0) {
			logger.info(String.format("员工编号为[%s]用户,用户名或密码有误!", loginInfoVO.getEmployeeCode()));
			addLoginCount(loginCount, session);
			throw new BusinessException(EnumCodeException.E0004, String.format("员工编号为[%s]用户,用户名或密码有误!", loginInfoVO.getEmployeeCode()));
		} else if(k != 1) {
			logger.info("登陆失败, 有多个员工信息 工号： " + loginInfoVO.getEmployeeCode());
			addLoginCount(loginCount, session);
			throw new BusinessException(EnumCodeException.E0004, "登陆失败, 有多个员工信息 工号： " + loginInfoVO.getEmployeeCode());
		}
		/**
		 * 获取员工信息，并保存到sesion中
		 */
		EmployeeLoginVO loginResult = findEmployeeByCodeAndPwd(loginInfoVO);
		if (loginResult != null) {
			if(loginResult.getRoleList().size() == 0) {
				logger.info(String.format("员工编号为[%s]用户,无角色信息，员工信息有误!", loginInfoVO.getEmployeeCode()));
				throw new BusinessException(EnumCodeException.E0003, String.format("员工编号为[%s]用户,无角色信息，员工信息有误!", loginInfoVO.getEmployeeCode()));
			}
/*			if (loginResult.getOrganizationId() == 0) {
				logger.info(String.format("员工编号为[%s]用户,无部门信息，员工信息有误!", loginInfoVO.getEmployeeCode()));
				throw new BusinessException(EnumCodeException.E0003);
			}*/
			session.setAttribute("employee", loginResult);
			session.setAttribute("userId", loginResult.getId());
			logger.info(String.format("员工编号为[%s]用户,登录成功!", loginInfoVO.getEmployeeCode()));
			return true;
		} else {
			logger.info(String.format("员工编号为[%s]用户,员工信息错误!", loginInfoVO.getEmployeeCode()));
			// 返回fail
			addLoginCount(loginCount, session);
			throw new BusinessException(EnumCodeException.E0004, 
					"员工编号为"+loginInfoVO.getEmployeeCode()+"被冻结或其他用户信息有误");
		}
	}

	public EmployeeLoginVO findEmployeeByCodeAndPwd(LoginInfoVO loginInfoVO) {
		
		 List<EmployeeLoginVO> empList = new ArrayList<EmployeeLoginVO>();
		 //SSO访问是否开启
		 if(SysConstantsVal.SSO){
		     empList = employeeBaseSqlMapper.findEmployeeBySSOCodeAndPwd(loginInfoVO);
		 }else{
			 empList = employeeBaseSqlMapper.findEmployeeByCodeAndPwd(loginInfoVO); 
		 }
		 List<RoleVO> roleList = new ArrayList<RoleVO>();
		 for(EmployeeLoginVO e: empList) {
			 RoleVO roleVO = new RoleVO();
			 roleVO.setRoleId(e.getRoleId());
			 roleVO.setRoleCode(e.getRoleCode());
			 roleList.add(roleVO);
		 }
		 if(!roleList.isEmpty()) {
			 EmployeeLoginVO employeeInfo = new EmployeeLoginVO();
			 String[] ignoreList = {"roleCode", "roleId", "roleList"};
			 BeanUtils.copyProperties(empList.get(0), employeeInfo, ignoreList);
			 employeeInfo.setRoleList(roleList);
			 return employeeInfo;
		 } else {
			 return null;
		 }
		 
		 
	}

	public boolean checkLoginParams(LoginInfoVO loginInfoVO, HttpSession session) {
		
		String loginCount = (String) session.getAttribute("loginCount");
		if (StringUtils.isEmpty(loginCount)) {
			loginCount = "0";
		}	
		// 判断是否为空
		if (StringUtils.isEmpty(loginInfoVO.getEmployeeCode()) 
				|| StringUtils.isEmpty(loginInfoVO.getPassword()) ) {
			logger.info(String.format("员工编号为[%s]用户,输入参数为空!", loginInfoVO.getEmployeeCode()));
			throw new BusinessException(EnumCodeException.E0002);
		}
		// 判断账号是否在5-8之间
		if (loginInfoVO.getEmployeeCode().length() < 5 || loginInfoVO.getEmployeeCode().length() > 12) {
			logger.info(String.format("员工编号为[%s]用户,输入 账号长度不合法!", loginInfoVO.getEmployeeCode()));
			throw new BusinessException(EnumCodeException.E0002, "工号：", loginInfoVO.getEmployeeCode());
		}
		//登陆次数大于三次，才比对验证码
		if (Integer.valueOf(loginCount) >= 3) {
			if (StringUtils.isEmpty(loginInfoVO.getCode())||(!loginInfoVO.getCode().equalsIgnoreCase((null == session.getAttribute("codeShow")) ? null : session.getAttribute(
					"codeShow").toString()))) {
				logger.info(String.format("员工编号为[%s]用户, 输入 的验证码错误!", loginInfoVO.getCode()));
				addLoginCount(loginCount, session);
				throw new BusinessException(EnumCodeException.E0002, "验证码：", loginInfoVO.getCode());
			}
		}
		return false;
	}

	public void addLoginCount(String count, HttpSession session) {
		int result = Integer.valueOf(count);
		session.setAttribute("loginCount", String.valueOf(++result));
	}

	public boolean CompareEmployeeBySSO(HttpServletResponse resp, LoginInfoVO loginInfoVO, HttpSession session) {
		String loginCount = (String) session.getAttribute("loginCount");
		if (StringUtils.isEmpty(loginCount)) {
			loginCount = "0";
		}	
		/**
		 * 验证登陆密码(sso调用)
		 */
		Message result = singleSignOn.authLogin(resp, loginInfoVO.getEmployeeCode(), loginInfoVO.getPassword(), singleSignOn.getSystemCode());
		if(result.getRespBody()==null||!result.isSuccess()){
			//logger.info(String.format("员工编号为[%s]用户,无角色信息，员工信息有误!", loginInfoVO.getEmployeeCode()));
			//throw new BusinessException(EnumCodeException.E0003, String.format("员工编号为[%s]用户,无角色信息，员工信息有误!", loginInfoVO.getEmployeeCode()));
			throw new BusinessException(String.format(result.getDesc(), loginInfoVO.getEmployeeCode()));
		}
		/**
		 * 获取员工信息，并保存到sesion中
		 */
		EmployeeLoginVO loginResult = findEmployeeByCodeAndPwd(loginInfoVO);

		
		if (loginResult != null) {
			if(loginResult.getRoleList().size() == 0) {
				logger.info(String.format("员工编号为[%s]用户,无角色信息，员工信息有误!", loginInfoVO.getEmployeeCode()));
				throw new BusinessException(EnumCodeException.E0003, String.format("员工编号为[%s]用户,无角色信息，员工信息有误!", loginInfoVO.getEmployeeCode()));
			}
			//来自sso的公共用户信息放入session
			Map map = (Map) JSON.parse(result.getRespBody());
			String name = (String) map.get("name");
			String nickname = (String) map.get("nickname");
			loginResult.setName(name);
			loginResult.setNickName(nickname);
			session.setAttribute("employee", loginResult);
			session.setAttribute("userId", loginResult.getId());
			logger.info(String.format("员工编号为[%s]用户,登录成功!", loginInfoVO.getEmployeeCode()));
			return true;
		} else {
			logger.info(String.format("员工编号为[%s]用户,员工信息错误!", loginInfoVO.getEmployeeCode()));
			// 返回fail
			addLoginCount(loginCount, session);
			throw new BusinessException(EnumCodeException.E0004, 
					"员工编号为"+loginInfoVO.getEmployeeCode()+"被冻结或其他用户信息有误");
		}
	}

}
