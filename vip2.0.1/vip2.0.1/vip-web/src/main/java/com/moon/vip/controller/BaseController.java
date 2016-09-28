package com.moon.vip.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.moon.vip.infra.constants.EnumAuthAction;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.RoleVO;
import com.moon.vip.service.sys.IOrgProfessionalService;
import com.moon.vip.service.sys.IRuleService;
/**
 * 
* @ClassName: BaseController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2015年12月24日 下午3:35:23 
*
 */
public class BaseController {
	  private static Logger logger = Logger.getLogger(BaseController.class);
	  
	  @Autowired
	  private IRuleService ruleService;
	  
	  @Autowired
	  private IOrgProfessionalService iOrgProfessionalService;
	  
	 /**
	  * 
	  * @Author：  陈海  - （怡宝 ）
	  * @Title: getSession 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @return    设定文件 
	  * @return HttpSession    返回类型 
	  * @date 2015年12月24日 下午3:37:41 
	  * @throws
	  */
	  public HttpSession getSession(){
	      return getRequest().getSession();
	  }
	  
	  
	  
	  public HttpServletRequest getRequest(){
		  HttpServletRequest request =  ControllerContext.getContext().getRequest();
		  if(request == null){
			  logger.info("获取请求失败，代码有误");
			  throw new NullPointerException();
		  }
		  return request;
	  }
	  public EmployeeLoginVO  getUserInfo(){
		   EmployeeLoginVO emp =  (EmployeeLoginVO) getSession().getAttribute("employee");
		   if(emp == null){
			   logger.error("获取员工登陆信息失败");
			   throw new NullPointerException();
		   }
		   return emp;
	  }
	  public int  getUserId(){
		  return getUserInfo().getId();
	  }
	  public String getUserCode(){
		  return getUserInfo().getEmployeeCode();
	  }
	  
	   /**
	 * 日期：2016年1月11日 上午11:20:42<br/>
	 * 描述：获取当前用户登录数据权限<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午11:20:42 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @return<br/>
	 * HashSet<Integer>
	 */
	protected HashSet<Integer> achieveAuth() {
		EmployeeLoginVO employeeInfo = getUserInfo();
		HashSet<Integer> authList = ruleService.getAuthForOrgProfessional(
				employeeInfo.getEmployeeCode(), EnumAuthAction.SELECT, packagingRoleCodeList(employeeInfo));
		authList = iOrgProfessionalService.convertSecurity(authList);
		if(authList.size() == 0) {
			authList.add(0);
		}
		logger.info("权限部门id：" + authList);
		return authList;
	}
	private List<String> packagingRoleCodeList(EmployeeLoginVO employeeInfo) {
		List<RoleVO> roleList = employeeInfo.getRoleList();
		List<String> roleCodeList = Lists.newArrayList();
		for(RoleVO role : roleList) {
			if(role != null && role.getRoleCode() != null) {
				roleCodeList.add(role.getRoleCode());
			}
		}
		return roleCodeList;
	}
}
