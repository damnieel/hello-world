package com.moon.vip.service.login;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.LoginInfoVO;

public interface IEmployeeLoginService {

	/**
	 * 匹配用户的工号和密码，确认是否有权限登陆<br/> 
	 * @Title: findEmployeeByCodeAndPwd <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月23日 下午8:15:14  <br/> 
	 * @param loginInfoVO
	 * @param session 
	 * @return
	 * EmployeeLoginVO
	 * @throws  <br/>
	 */
	public boolean CompareEmployeeByCodeAndPwd(LoginInfoVO loginInfoVO, HttpSession session);
	
	/**
	 * 检查登陆信息是否为空<br/> 
	 * @Title: checkLoginParams <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月23日 下午8:20:50  <br/> 
	 * @param loginInfoVO
	 * @param session 
	 * @param loginCount 
	 * @return
	 * boolean
	 * @throws  <br/>
	 */
	public boolean checkLoginParams(LoginInfoVO loginInfoVO, HttpSession session);
	
	public void addLoginCount(String count, HttpSession session);
	
	/**
	 * 描述：用户的工号和密码，确认是否有权限登陆(SSO)<br/>
	 * 日期：2016年3月21日 下午4:35:13<br/>
	 * 修改说明（时间、人）：<br/>
	 * @author zhumin <br/>
	 * 修改备注：TODO<br/>
	 * @param loginInfoVO
	 * @param session
	 * @return<br/>
	 * boolean
	 */
	public boolean CompareEmployeeBySSO(HttpServletResponse resp,LoginInfoVO loginInfoVO, HttpSession session);
	
	/**
	 * 描述：获取用户信息<br/>
	 * 日期：2016年3月21日 下午7:17:18<br/>
	 * 修改说明（时间、人）：<br/>
	 * @author zhumin <br/>
	 * 修改备注：TODO<br/>
	 * @param loginInfoVO
	 * @return<br/>
	 * EmployeeLoginVO
	 */
	public EmployeeLoginVO findEmployeeByCodeAndPwd(LoginInfoVO loginInfoVO);
}
