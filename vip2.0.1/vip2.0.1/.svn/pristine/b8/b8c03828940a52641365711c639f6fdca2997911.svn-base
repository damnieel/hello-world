package com.moon.vip.controller.divideGrade;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.onReadPage.OnReadPageStudentsVO;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.infra.vo.sys.OrgProfessionalInfoVO;
import com.moon.vip.service.onReadStudent.IDivideGradeService;
import com.moon.vip.service.sys.IOrgProfessionalService;


@Controller
@RequestMapping("admin/divideGrade")
public class DivideGradeController extends BaseController{
	
	private Logger logger = Logger.getLogger(DivideGradeController.class);
	@Autowired
	private IDivideGradeService iDivideGradeService;

	@Autowired
	private IOrgProfessionalService iOrgProfessionalService;
	

	@RequestMapping("/onReadPage")
	public String toOnReadPage() {
		logger.info("前往onReadPage页面");
		return "/page/onReadStu/onReadPage";
	}

	@RequestMapping("/getUndivStudentDataCount")
	@ResponseBody
	public int getUndivStudentDataCount(ParamsVO paramsVO) {
		paramsVO.setExistClass(false);
		paramsVO.setOpClaIds(achieveAuth());
		logger.info("获取未分班Count，参数： paramsVO" + paramsVO);
		int count = iDivideGradeService.selectUndivStudentCount(paramsVO);
		return count;
	}

	@RequestMapping("/getDivedStudentDataCount")
	@ResponseBody
	public int getDivedStudentDataCount(ParamsVO paramsVO) {
		paramsVO.setExistClass(true);
		paramsVO.setOpClaIds(achieveAuth());
		logger.info("获取已分班Count，参数： paramsVO" + paramsVO);
		int count = iDivideGradeService.selectDivedStudentCount(paramsVO);
		return count;
	}
	
	@RequestMapping("/getUndivStudentData")
	public ModelAndView getStudentData(ParamsVO paramsVO) {
		ModelAndView modelAndView = new ModelAndView();
		paramsVO.setExistClass(false);
		paramsVO.setOpClaIds(achieveAuth());
		logger.info("获取未分班数据，参数： paramsVO" + paramsVO);
		List<OnReadPageStudentsVO> undivList = iDivideGradeService.selectUndivStudent(paramsVO);
		modelAndView.addObject("studentlist", undivList);
		modelAndView.addObject("type", "undiv");
		modelAndView.setViewName("/page/onReadStu/undivStudentTemp");
		return modelAndView;
	}
	
	@RequestMapping("/getDivedStudentData")
	public ModelAndView getDivedStudentData(ParamsVO paramsVO) {
		ModelAndView modelAndView = new ModelAndView();
		paramsVO.setExistClass(true);
		paramsVO.setOpClaIds(achieveAuth());
		logger.info("获取已分班数据，参数： paramsVO" + paramsVO);
		List<OnReadPageStudentsVO> divList = iDivideGradeService.selectDivedStudent(paramsVO);
		
		int endIndex = paramsVO.getPageNo() + paramsVO.getpSize();
		divList = divList.subList(paramsVO.getPageNo(), 
				divList.size() >= endIndex?endIndex:divList.size());
		
		modelAndView.addObject("studentlist", divList);
		modelAndView.addObject("type", "dived");
		modelAndView.setViewName("/page/onReadStu/undivStudentTemp");
		return modelAndView;
	}
	
	@RequestMapping("/delUndivData")
	@ResponseBody
	public Message delUndivData(ParamsVO paramsVO) {
		Message msg = new Message();
		String result = iDivideGradeService.hasInterviews(paramsVO);
		if(result != null) {
			msg.setResult(false);
			msg.setMsg(result);
			return msg;
		} else {
			//将这些学员的is_valid更新为N
			iDivideGradeService.updateValidArchProf(paramsVO.getIdArray(), paramsVO.getProfOrgIdArray());
		}
		logger.info(String.format("员工(id-%d),删除未分班学员(id-%s, name-%s)专业(profOrgId-%s)", 
						getUserId(), paramsVO.getIdArray(),paramsVO.getNameArray(), 
						paramsVO.getProfOrgIdArray()));
		msg.setResult(true);
		return msg;
	}
	@RequestMapping("/delDivedData")
	@ResponseBody
	public Message delDivedData(ParamsVO paramsVO, HttpSession session) {
		EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
		paramsVO.setCreator(employee.getEmployeeCode());
		Message msg  = iDivideGradeService.delDivedStudent(paramsVO);
		logger.info(String.format("员工(id-%d),删除已分班学员(id-%s, name-%s)专业(profOrgId-%s)班级(gradeOrgId-%s)", 
				getUserId(), paramsVO.getIdArray(),paramsVO.getNameArray(), 
				paramsVO.getProfOrgIdArray(), paramsVO.getGradeOrgIdArray()));
		logger.info("errorMap:" + msg);
		return msg;
	}
	
	@RequestMapping("/divideGrade")
	@ResponseBody
	public Message divideGrade(ParamsVO paramsVO, HttpSession session) {
		Message msg = new Message();
		logger.info("开始分班");
		logger.info("上传内容 paramVO:" + paramsVO);
		EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
		paramsVO.setCreator(employee.getEmployeeCode());
		try {
			iDivideGradeService.divideGrade(paramsVO);
		} catch (BusinessException e) {
			msg.setResult(false);
			msg.setMsg("传入参数为空");
			return msg;
		}
		
		logger.info(String.format("员工(%s)将学员(%s)专业(%s)分到班级(%s)", 
				employee.getEmployeeCode(), paramsVO.getIdArray(), 
				paramsVO.getProfName(),paramsVO.getGradeOrgIdArray()));
		msg.setResult(true);
		return msg;		
	}
	
	@RequestMapping("/getClasses") 
	@ResponseBody
	public List<OrgProfessionalInfoVO> getClasses(String profName) {
		return iDivideGradeService.getClassesByprofName(profName);
	}
	
	@RequestMapping("/getGradesById") 
	@ResponseBody
	public String getGradesById(ParamsVO paramsVO) {
		String grades = iDivideGradeService.selectGradeByStudentId(paramsVO);
		if(grades == null) {
			grades = "获取的班级信息为空，数据库中没有该专业的班级";
			logger.error(grades);
		}
		logger.info(String.format("获取学员(%s)班级(%s)的班级信息", paramsVO.getIdArray(), grades));
		return grades;
	}
	
	
	/**  
	 * 重新分班<br/> 
	 * @Title: reDivideGradeAction <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月5日 下午2:56:44  <br/> 
	 * @param paramsVO
	 * @return
	 * Message
	 * @throws  <br/> 
	 */
	@RequestMapping("/reDivideGradeAction") 
	@ResponseBody
	public Message reDivideGradeAction(ParamsVO paramsVO, HttpSession session) {
		logger.info("重新分班");
		EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
		paramsVO.setCreator(employee.getEmployeeCode());
		Message msg = iDivideGradeService.reDivideGrade(paramsVO);
		logger.info(String.format("将学员(%s)重新分到专业(%s)下班级(%s)", 
				paramsVO.getIdArray(), paramsVO.getProfOrgId(), paramsVO.getGradeOrgIdArray()));
		return msg;
	}
	@RequestMapping("/reDivideGradeActionConfirm") 
	@ResponseBody
	public Message reDivideGradeActionConfirm(ParamsVO paramsVO, HttpSession session) {
		logger.info("重新分班确认");
		EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
		paramsVO.setCreator(employee.getEmployeeCode());
		Message msg = iDivideGradeService.reDivideGradeConfirm(paramsVO);
		return msg;
	}
	
}
