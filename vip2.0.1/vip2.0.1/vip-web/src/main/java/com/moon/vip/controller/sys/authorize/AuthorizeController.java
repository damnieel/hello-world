package com.moon.vip.controller.sys.authorize;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.client.vo.Message;
import com.moon.vip.controller.BaseController;
import com.moon.vip.controller.sys.roleManage.RoleManagerController;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.student.StuAuthVO;
import com.moon.vip.infra.vo.sys.AuthSearchParams;
import com.moon.vip.service.sys.authManage.IAuthStuService;

/**
 * 
 * 类名称：AuthorizeController.java<br/>
 * 日期：2016年6月16日 下午7:10:40<br/>
 * 类描述：授权管理<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年6月16日 chenhai  TODO<br/>
 * @author <a href="mailto:937870526@qq.com"></a><br/>
 * @version 1.0.0
 */
@Controller
@RequestMapping("admin/authorize")
public class AuthorizeController extends BaseController{

	private Logger logger = Logger.getLogger(RoleManagerController.class);
	@Autowired
	private IAuthStuService authStuService;

    /**
     * 
     * 日期：2016年6月16日 下午6:46:05<br/>
     * 描述：获取授权页面<br/>
     * 修改说明（时间、人）：<br/>
     * 下午6:46:05 chenhai <br/>
     * 修改备注：TODO<br/>
     * @param searchParams
     * @return<br/>
     * ModelAndView
     */
	@RequestMapping("getPage")
	public ModelAndView getClassPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/sys/authManage/authStuPage");
		return mv;
	}
	
	/**
	 * 
	 * 日期：2016年6月16日 下午6:48:10<br/>
	 * 描述：TODO<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午6:48:10 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param searchParams
	 * @return<br/>
	 * ModelAndView
	 */
	@RequestMapping("getAuthStuInfo")
	public ModelAndView getAuthStuInfoByParams(AuthSearchParams searchParams){
		ModelAndView mv =new ModelAndView();
		try{
			searchParams.setOpClaIds(achieveAuth());
			List<StuAuthVO> list = authStuService.getAuthStuInfo(searchParams);
			mv.addObject("list", list);
		}catch(BusinessException e){
			logger.error(e.getCode()+":"+e.getExceptionMsg());
			mv.setViewName("/page/error/error");
			mv.addObject("error", e.getCode()+":"+e.getExceptionMsg());
			return mv;
		}catch(Exception e){
			logger.error("未知异常",e);
			mv.setViewName("/page/error/error");
			mv.addObject("error", e);
			return mv;
		}
		mv.setViewName("/page/sys/authManage/authStuTemp");
		return mv;
	}
	/**
	 * 
	 * 日期：2016年6月16日 下午7:12:16<br/>
	 * 描述：获取对应授权状态等条件学生数量<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午7:12:16 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param searchParams
	 * @return<br/>
	 * int
	 */
	@RequestMapping("getStuCount")
	@ResponseBody
	public int getCountStuByParams(AuthSearchParams searchParams){
		try{
		 searchParams.setOpClaIds(achieveAuth());
		 return authStuService.getCountStuByParams(searchParams);
		}catch(BusinessException e){
			logger.error(String.format("获取学生总数异常,异常信息[%s]",e.getCode()+":"+e.getExceptionMsg()));
			return 0;
		}catch(Exception e){
			logger.error("未知异常",e);
			return 0;
		}
    }
	/**
	 * 
	 * 日期：2016年6月17日 下午7:28:39<br/>
	 * 描述：TODO<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午7:28:39 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @return<br/>
	 * Message
	 */
	@RequestMapping("authStu")
	@ResponseBody
	public Message authStu(Integer stuId, String account) {
		Message msg = new Message();
		EmployeeLoginVO employee = getUserInfo();
		try {
           return authStuService.authStudent(stuId, account,employee);
		} catch (BusinessException e) {
			logger.error(e.getCode() + ":" + e.getExceptionMsg());
			msg.setSuccess(false);
			msg.setRespBody(e.getExceptionMsg());
			return msg;
		} catch (Exception e) {
			logger.error("未知异常", e);
			msg.setSuccess(false);
			msg.setRespBody("未知异常");
			msg.setDesc(e.getMessage());
			return msg;
		}
	}
	
	
	@RequestMapping("cancelAuthStu")
	@ResponseBody
	public Message cancelAuthStu(String stuId) {
		Message msg = new Message();
		EmployeeLoginVO employee = getUserInfo();
		try {
           if( authStuService.cancelAuthStuByStuIds(stuId, employee) > 0){
        	   msg.setSuccess(true);
           }
           return msg;
		}  catch (Exception e) {
			logger.error("未知异常", e);
			msg.setSuccess(false);
			msg.setRespBody("未知异常");
			msg.setDesc(e.getMessage());
			return msg;
		}
	}
	
}



