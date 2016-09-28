package com.moon.vip.interceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.moon.client.exception.WebClientException;
import com.moon.client.sso.SingleSingOn;
import com.moon.client.vo.Message;
import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.infra.constants.EnumAuthAction;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.ParamsName;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.constants.UrlInfoMsg;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.LoginInfoVO;
import com.moon.vip.infra.vo.RoleVO;
import com.moon.vip.infra.vo.UrlInfoVO;
import com.moon.vip.infra.vo.sys.MenuVO;
import com.moon.vip.service.login.IEmployeeLoginService;
import com.moon.vip.service.sys.IMenuService;
import com.moon.vip.service.sys.IOrgProfessionalService;
import com.moon.vip.service.sys.IRuleService;
/**
 * 
 * @ClassName: LoginInterceptor 
 * @Description: 拦截登陆url
 * @author 大枫
 * @date 2016年1月20日 下午3:38:38 
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
	  
	@Autowired
	private IRuleService ruleService;
	  
	@Autowired
	private IOrgProfessionalService iOrgProfessionalService;

	@Autowired
	private IMenuService iMenuService;
	
	@Autowired
	private OrganizationalProfessionalSqlMapper orgSqlMapper;
	
	@Autowired
	private SingleSingOn singleSignOn;
	
	@Autowired
	private IEmployeeLoginService iEmployeeLoginService;
	
	private Logger logger = Logger.getLogger(LoginInterceptor.class);
	private static String SPOT="[.]";
	private static String SPRIT ="/";	
	private static String NUM_REG = "^-?\\d+$";
    private static String STAFF =",";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if(!checkLogin(request, response, handler)){
	      return false;
       }
       else{
    	  boolean result = checkPower(request, response, handler);
    	  if(!result){
    		  if(isAjaxRequest(request)){
    			 returnMsg(response); 
    		  }
    		  else{
	    		  request.setCharacterEncoding("UTF-8");
				  response.setCharacterEncoding("UTF-8");
			      response.sendRedirect(request.getContextPath() + "/error/noPower.htmls");
    		  }
    	  }
    	  return result;
       }
       
	 }
	
	/**
	  * 判断权限<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: checkPower <br/>
	  * @return boolean    返回类型 <br/>
	  * @date 2016年1月27日 下午6:24:32 <br/>
	  * @throws <br/>
	  *
	 */
     private boolean checkPower(HttpServletRequest request, HttpServletResponse response, Object handler){
    	 String url = request.getServletPath();
         String[] urls = getStandUrl(url); //url信息
         UrlInfoVO u = ParamsName.getParamsName().get(urls[0]);
         if(u == null){
        	 return true;
         }
         HashSet<Integer> set = achieveAuth(request ,u.getType());
         if(u.getParameter().equals(UrlInfoMsg.ROAD_PATH)){ //路径变量
        	 return isHasPower(set,u.getParameterType(),urls[u.getPosition()]);
         }
    	 Map map= request.getParameterMap();
    	 Object o = map.get(u.getParameter());
    	 if(o == null){
    		 logger.error("未找到预期的参数");
    		 return false;
    	 }
         String[] value = new String[1];
         if(o instanceof String[]){
             value=(String[])o;
         }else{
             value[0]=o.toString();
         }
         if(u.isCollection()){
        	 value = value[0].split(STAFF);
         }
         return isHasPower(set,u.getParameterType(),value);
//	     Set keSet=map.entrySet();
//	     for(Iterator itr=keSet.iterator();itr.hasNext();){
//	         Map.Entry me=(Map.Entry)itr.next();
//	         Object ok=me.getKey();
//	         if(u.getParameter() != ok.toString()){
//	        	 break;
//	         }
//	         Object ov = me.getValue();
//	         String[] value=new String[1];
//	         if(ov instanceof String[]){
//	             value=(String[])ov;
//	         }else{
//	             value[0]=ov.toString();
//	         }
//	         System.out.println(ok+":"+ value[0]);
//	         return isHasPower(set,u.getParameterType(),value);
//	     }
     }
	private boolean isHasPower(HashSet<Integer> set, String parameterType, String... params) {
		logger.info(String.format("验证权限参数[%s][%s]", parameterType,Arrays.toString(params)));
		if(params.equals("-1")){
			return true;
		}
		if(parameterType.equals(UrlInfoMsg.ORGANIZATION_ID)){
			for(int i = 0;i < params.length; i++){
			  if (!set.contains(Integer.valueOf(params[i]))){
				 logger.error("没有权限");
				 return false; 
			  }
			}
		}
		if(parameterType.equals(UrlInfoMsg.CLASS_ID)){
			List<Integer> a = orgSqlMapper.findWhereOrgInCla(params);
		    for(Integer k:a){
				if (!set.contains(k)){
					logger.error("没有权限");
					return false; 
				}
			}
		}
		if(parameterType.equals(UrlInfoMsg.PROFESSION_ID)){
			List<Integer> a = orgSqlMapper.findWhereOrgInPro(params);
		    for(Integer k:a){
				if (!set.contains(k)){
					logger.error("没有权限");
					return false; 
				}
			}
		}
		if(parameterType.equals(UrlInfoMsg.STUDENT_ID)){
			int flag = 0;
			List<Integer> a = orgSqlMapper.findWhereOrgInStu(params[0]);
		    for(Integer k:a){
				if (set.contains(k)){
					flag = 1;
				}
			}
		    if(flag == 0){
		    	logger.error("没有权限");
		    	return false;
		    }
		}
		if(parameterType.equals(UrlInfoMsg.QUESTION_ID)){
			Integer a = orgSqlMapper.findWhereOrgInQus(params[0]);
		    if (!set.contains(a)){
				return false;	
		    }
		}
		
		if(parameterType.equals(UrlInfoMsg.QUESTION_ID)){
			Integer a = orgSqlMapper.findWhereOrgInQus(params[0]);
		    if (!set.contains(a)){
				return false;	
		    }
		}
		if(parameterType.equals(UrlInfoMsg.INTERVIEW_ID)){
			for(String p :params){
				Integer a = orgSqlMapper.findWhereOrgInItv(p);
			    if (!set.contains(a)){
					return false;	
			    }
		    }
		}
		if(parameterType.equals(UrlInfoMsg.PROFESSION_ATTACH_ID)){
			Integer a = orgSqlMapper.findWhereOrgInProAth(params[0]);
		    if (!set.contains(a)){
				return false;	
		    }
		}
		return true;
	}

	private boolean checkLogin(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
			// 获取请求的URL
			String url = request.getRequestURL().toString();
			// 获取当前登录实体
			Object obj = request.getSession().getAttribute("employee");
			
			if (null == obj) {
				//SSO登录
				if(this.ssoValidater(request)){
					// 如果session中不存在登录者实体，则弹出框提示重新登录
					// 设置request和response的字符集，防止乱码
					request.setCharacterEncoding("UTF-8");
					response.setCharacterEncoding("UTF-8");
					response.sendRedirect(request.getContextPath() + "/admin/employee/login.htmls");
		//			request.getRequestDispatcher("/admin/employee/login.htmls").forward(request, response);// 将请求重定向到登录页面
					return false;
				}
			}
			
			//SSO访问是否开启
			if(SysConstantsVal.SSO){
			//再次获取当前登录实体
			obj = request.getSession().getAttribute("employee");
			}
			
			EmployeeLoginVO employee = (EmployeeLoginVO) obj;
			/**
			 * 菜单权限验证
			 */
			boolean checkFlag = false; 
			List<MenuVO> menuList = iMenuService.getAllSubMenu();
			for(MenuVO menu:menuList) {
				if(url.contains(menu.getUrl())) {
					checkFlag = true;
					break;
				}
			}
			
			if(checkFlag) {
				boolean flag = false;
				for(RoleVO role : employee.getRoleList()) {
					List<MenuVO> userMenuList = iMenuService.getSubMenu(Sets.newHashSet(role.getRoleId()));
					for(MenuVO userMenu: userMenuList) {
						if(url.contains(userMenu.getUrl())) {
							flag = true;
							break;
						}
					}
				}
				if(flag) {
					return true;
				} else {
					if(url.contains("/interview/showPage.htmls")) {
						logger.info(String.format("访问url：%s, 为菜单url，但是该用户（%s）没有该菜单的访问权限"
								, url,employee.getEmployeeCode()));
						request.setCharacterEncoding("UTF-8");
						response.setCharacterEncoding("UTF-8");
		
						request.getSession().invalidate();//清空session
						request.getRequestDispatcher("/error/noPower.htmls").forward(request, response);// 将请求重定向到登录页面
						return false;
						
					} else {
						request.setCharacterEncoding("UTF-8");
						response.setCharacterEncoding("UTF-8");
						Cookie cookie = new Cookie("menu", "interviewRecord");
						cookie.setPath("/");
						response.addCookie(cookie);		
						request.getRequestDispatcher("/interview/showPage.htmls").forward(request, response);// 将请求重定向到登录页面
						return true;
					}
				}
				
			} else {
				return true;
			}
		}
	 /**
	   * 获取权限<br/>
	   * @Author：  陈海  - （怡宝 ）<br/>
	   * @Title: achieveAuth <br/>
	   * @return HashSet<Integer>    返回类型 <br/>
	   * @date 2016年1月27日 下午6:32:58 <br/>
	   * @throws <br/>
	   *
	  */
	protected HashSet<Integer> achieveAuth(HttpServletRequest request,EnumAuthAction action) {
		EmployeeLoginVO employeeInfo = (EmployeeLoginVO) request.getSession().getAttribute("employee");
		HashSet<Integer> authList = ruleService.getAuthForOrgProfessional(
				employeeInfo.getEmployeeCode(), action, packagingRoleCodeList(employeeInfo));
		authList = iOrgProfessionalService.convertSecurity(authList);
		if(authList.size() == 0) {
			authList.add(0);
		}
		logger.info("检验权限部门id：" + authList);
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
	private String[] getStandUrl(String url){
		int i = 0;
		String[] urls = url.split(SPOT);
		String[] orign = urls[0].split(SPRIT);
 		for(int k = orign.length - 1 ;k >=0 ;k--){
	 		if(Pattern.compile(NUM_REG).matcher(orign[k]).find()){
	 			i+=1;
	 		}
	 		else{
	 			break; //不匹配直接退出循环
	 		}
 		}
 		StringBuffer sb = new StringBuffer();
 		for(int j =0 ;j < orign.length -i ;j++){
 			sb.append(orign[j]+SPRIT);
 		}
 		String[] target = new String[i+1];
 		target[0] = sb.substring(0,sb.length()-1).toString();
 		for(int k = 1;k < i+1;k++){
 		 target[k] = orign[orign.length -k];
 		}
		return target;
	}
	
	private void returnMsg(HttpServletResponse response) throws IOException{
		String jsonStr = "FAIL";
		response.setHeader("Json-Exception", "jsExc");
		render(jsonStr, "text/x-json;charset=UTF-8", response);
	
	}
	/**
	 * 判断请求是否为ajax请求
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected boolean isAjaxRequest(HttpServletRequest request) {
	  return  (request.getHeader("X-Requested-With") != null  
		 && "XMLHttpRequest".equals( request.getHeader("X-Requested-With").toString())   ) ;
	}
	
	protected void render(String text, String contentType, HttpServletResponse response) throws IOException{
		response.setContentType(contentType);
		response.getWriter().write(text);
		response.flushBuffer();
	}
	
	
	/**
	 * 描述：验证sso登录状态<br/>
	 * 日期：2016年3月21日 下午8:32:41<br/>
	 * 修改说明（时间、人）：<br/>
	 * @author zhumin <br/>
	 * 修改备注：TODO<br/>
	 * @param request
	 * @param flag
	 * @return<br/>
	 * boolean
	 */
	private boolean ssoValidater(HttpServletRequest request){
		//SSO访问是否开启
		if(SysConstantsVal.SSO){
			try{
				Message result = singleSignOn.authConfirmLogin(request,singleSignOn.getSystemCode());
				if(result.getRespBody()!=null || result.isSuccess()){
					Map map = (Map) JSON.parse(result.getRespBody());
					String account = (String) map.get("account");
					String password = (String) map.get("password");
					String name = (String) map.get("name");
					String nickname = (String) map.get("nickname");
					LoginInfoVO vo = new LoginInfoVO();
					vo.setEmployeeCode(account);
					vo.setPassword(password);
					EmployeeLoginVO loginResult = iEmployeeLoginService.findEmployeeByCodeAndPwd(vo);
					//来自sso的公共用户信息放入session
					loginResult.setName(name);
					loginResult.setNickName(nickname);
					if (loginResult != null) {
						if(loginResult.getRoleList().size() == 0) {
							logger.info(String.format("员工编号为[%s]用户,无角色信息，员工信息有误!", vo.getEmployeeCode()));
							throw new BusinessException(EnumCodeException.E0003, String.format("员工编号为[%s]用户,无角色信息，员工信息有误!", vo.getEmployeeCode()));
						}
						
						request.getSession().setAttribute("employee", loginResult);
						request.getSession().setAttribute("userId", loginResult.getId());
						logger.info(String.format("员工编号为[%s]用户,登录成功!", vo.getEmployeeCode()));
						return false;
				    }
				}
			 }catch(WebClientException e){
				  logger.warn("cookie取得失败");
				  return true;
			  }
			
		}
		
		return true;
	}
	  
 }
	