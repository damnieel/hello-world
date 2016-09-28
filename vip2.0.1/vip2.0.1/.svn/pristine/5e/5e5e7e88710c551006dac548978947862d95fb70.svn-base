package com.moon.vip.controller.sys;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.sys.EmployeePasswordVO;
import com.moon.vip.service.sys.IEmployeePasswordService;

/**
 * 类名称：EmployeePasswordController.java<br/>
 * 日期：2015年12月24日 下午1:46:43<br/>
 * 类描述：修改密码控制器<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * @author 向新</a><br/>
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/personal")
public class EmployeePasswordController extends BaseController{
	
	@Autowired
	private IEmployeePasswordService employeePasswordService;
	
	/**
	 * 显示密码修改页面<BR>
	 * 方法名：password<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年1月6日-下午1:27:10 <BR>
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping("/pwd")
	public ModelAndView password(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/sys/password");
		return mv;
	}
	
	/**
	 * 密码修改<BR>
	 * 方法名：updatePasswordById<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年1月6日-下午1:27:10 <BR>
	 * @return Message<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping(value="/updatePassword",method = RequestMethod.POST)
	@ResponseBody
	public Message updatePasswordById(HttpServletRequest request,EmployeePasswordVO employeePassword){ 
		Message message=new Message();
		com.moon.client.vo.Message  cmessage =new com.moon.client.vo.Message();
		/** 获取保存在session中的信息**/
		EmployeeLoginVO employee=getUserInfo();
		/** 获取session中的员工工号**/
		employeePassword.setEmployeeCode(employee.getEmployeeCode());
		if(SysConstantsVal.SSO){
			cmessage=employeePasswordService.updatePasswordWithSsoById(request, employeePassword);
		}else{
			cmessage=employeePasswordService.updatePasswordById(employeePassword);
		}
		if(cmessage==null){
			message.setMsg("系统错误");
			message.setResult(false);
			return message;
		}
		message.setCode(cmessage.getCode());
		message.setMsg(cmessage.getDesc());
		message.setResult(cmessage.isSuccess());
		return message;
	}
	
}
