package com.moon.vip.controller.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.client.constants.CookieKey;
import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.util.Md5Util;
import com.moon.vip.infra.vo.LoginInfoVO;
import com.moon.vip.service.login.IEmployeeLoginService;

/**
 * 
 * @ClassName: LoginController 
 * @Description: 登陆控制层
 * @author 大枫
 * @date 2015年12月23日 下午7:12:35 
 *
 */
@Controller
@RequestMapping("/admin/employee")
public class LoginController extends BaseController{
	
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private IEmployeeLoginService iEmployeeLoginService;
	@RequestMapping("/login")
	public ModelAndView toLoginPage() {
		return (new ModelAndView("/page/login"));
	}
	@RequestMapping("/test")
	public ModelAndView test() {
		return (new ModelAndView("/page/login"));
	}

	@RequestMapping("/loginAction")
	@ResponseBody
	public Message loginAction(HttpServletResponse resp,LoginInfoVO loginInfoVO) {

		logger.info(String.format("员工编号为[%s]用户发起登录请求", loginInfoVO.getEmployeeCode()));
		Message msg = new Message();
	
		try {
			iEmployeeLoginService.checkLoginParams(loginInfoVO, getSession());
			loginInfoVO.setPassword(Md5Util.encoderByMd5(loginInfoVO.getPassword()));//MD5加密
			//判断是否采用sso登录
			if(SysConstantsVal.SSO){
				msg.setResult(iEmployeeLoginService.CompareEmployeeBySSO(resp,loginInfoVO, getSession()));
			}else{
			    msg.setResult(iEmployeeLoginService.CompareEmployeeByCodeAndPwd(loginInfoVO, getSession()));
			}
		} catch (BusinessException e) {
			msg.setResult(false);
			msg.setCode(e.getCode());
			msg.setMsg(e.getExceptionMsg());
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}	

	@RequestMapping(value="/getLoginCount",method=RequestMethod.GET)
	@ResponseBody
	public int getLoginCount(HttpSession session){
		String loginCount = (String) session.getAttribute("loginCount");
		if(StringUtils.isEmpty(loginCount)){
			loginCount="0";
		}
		return Integer.valueOf(loginCount);
	}
	@RequestMapping("/logout")
	public String loginOut(HttpServletResponse resp) {
		getSession().invalidate(); // 清除session
		//SSO清除cookie
		if(SysConstantsVal.SSO){
			Cookie killMyCookie = new Cookie(CookieKey.TOKEN_CODE_KEY,null);   
	          killMyCookie.setMaxAge(0);   
	          killMyCookie.setPath("/");   
	          resp.addCookie(killMyCookie);   
		}
		return "/page/login";
	}
}