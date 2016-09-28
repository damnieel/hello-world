package com.moon.vip.controller.student;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.student.StudentVO;
import com.moon.vip.service.student.IStudentRepeatService;


/**
 * 问题数据
 * StudentRepeatController<BR>
 * 创建人:娴贵 <BR>
 * 时间：2016年1月23日-下午6:23:48 <BR>
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/student/studentPersonal")
public class StudentRepeatController extends BaseController{
	private static Logger logger = Logger.getLogger(StudentRepeatController.class);
	
	@Autowired
	private IStudentRepeatService iStudentRepeatService;
	
	
	
	@RequestMapping("/studentRepeatPage")
	public ModelAndView studentRepeatPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/repeatStudent/studentRepeatPage");
		return mv;
	}

	/**
	 * 展示学员信息<BR>
	 * 方法名：allStudentArchives<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月23日-下午6:23:16 <BR>
	 * @param studentVO
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping(value = "/allStudentArchives" , method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView allStudentArchives(StudentVO studentVO){
		ModelAndView mv = new ModelAndView();
		studentVO.setOpClaIds(achieveAuth());
	    List<StudentVO> listVO = iStudentRepeatService.allStudentArchives(studentVO);
	    mv.addObject("list", listVO);
	    mv.setViewName("/page/repeatStudent/studentRepeatTemplate");
	    return mv;
	}
	
	@RequestMapping(value = "/allStudentArchivesCount" , method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public int allStudentArchivesCount(StudentVO studentVO){
		studentVO.setOpClaIds(achieveAuth());
	    return iStudentRepeatService.allStudentArchivesCount(studentVO);
	}
	
	
	/**
	 * 删除学员信息<BR>
	 * 方法名：deleteStudentRepeat<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月23日-下午6:23:00 <BR>
	 * @param id
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping(value = "/deleteStudentRepeat" , method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String deleteStudentRepeat(StudentVO studentVO,HttpSession session){
		EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
		int i = iStudentRepeatService.stuRelevanceProfessional(studentVO.getId());/**是否存在关联的专业**/
		if(i == 0){
		   logger.info("删除问题数据人的工号："+employee.getEmployeeCode()+"，修改时间："+new Date());
		   int j = iStudentRepeatService.deleteStudentArchives(studentVO.getId());
		   if(j > 0){
			   return "success";
		   }
		   return "usuccess";
		}
		return "fail";
	}
	
}
