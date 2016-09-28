package com.moon.vip.controller.divideGrade;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.onReadPage.OnReadPageStudentsVO;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.service.onReadStudent.INotReadService;

@Controller
@RequestMapping("admin/notReadPage")
public class NotReadPageController extends BaseController{
	
	private Logger logger = Logger.getLogger(NotReadPageController.class);
	@Autowired
	private INotReadService iNotReadService;	
	
	@RequestMapping("/notReadPage")
	public String toBackPage() {
		return "/page/onReadStu/notReadPage";
	}
	
	@RequestMapping("/getNotReadStuCount")
	@ResponseBody
	public int getNotReadStuCount(ParamsVO paramsVO) {
		paramsVO.setExistClass(false);
		paramsVO.setOpClaIds(achieveAuth());
		int count = iNotReadService.selectNotReadStudentCount(paramsVO);
		logger.info("获取非在读学员数量count="+count);
		logger.info("参数paramsVO="+paramsVO);
		return count;
	}	
	@RequestMapping("/getNotReadStu")
	@ResponseBody
	public ModelAndView getNotReadStu(ParamsVO paramsVO) {
		logger.info("获取非在读学员数据paramsVO="+paramsVO);
		ModelAndView modelAndView = new ModelAndView();
		paramsVO.setExistClass(false);
		paramsVO.setOpClaIds(achieveAuth());
		List<OnReadPageStudentsVO> studentList = iNotReadService.selectNotReadStudent(paramsVO);
		modelAndView.addObject("studentlist", studentList);
		modelAndView.addObject("type", "notread");
		modelAndView.setViewName("/page/onReadStu/undivStudentTemp");
		return modelAndView;
	}
	@RequestMapping("/backReadAction")
	@ResponseBody
	public Message backReadAction(ParamsVO paramsVO, HttpSession session) {
		logger.info("复学服务器接收 paramsVO: " + paramsVO);
		EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
		paramsVO.setCreator(employee.getEmployeeCode());
		Message msg = iNotReadService.backReadAction(paramsVO);
		
		logger.info(String.format("员工(%s)将学员(%s)专业(%s)复学", 
				employee.getEmployeeCode(), paramsVO.getIdArray(), paramsVO.getProfOrgIdArray()) 
				+ "Result: Message_" + msg);
		return msg;
	}	
}
