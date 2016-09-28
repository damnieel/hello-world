package com.moon.vip.controller.student;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.student.StudentVO;
import com.moon.vip.service.student.IStudentArchivesSearchService;
/**
 * 学员数据上传错误，   搜索查询
 * StudentDetailController<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月30日-下午9:07:57 <BR>
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/student/studentSearch")
public class StudentSearchController extends BaseController{
	
	@Autowired
	private IStudentArchivesSearchService iStudentArchivesService;

	
	/**
	 * 学员信息列表模板页面<BR>
	 * 方法名：studentTemplate<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月31日-下午3:37:30 <BR>
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping("/studentSearchTemplate")
	private ModelAndView studentTemplate(StudentVO studentVO){
		ModelAndView modelAndView = new ModelAndView();
		List<StudentVO> students = iStudentArchivesService.selectAllStudent(studentVO);
		int count = iStudentArchivesService.selectAllStudentCount(studentVO);
		modelAndView.addObject("count", count);
		modelAndView.addObject("student", students);
		modelAndView.setViewName("/page/student/studentSearchTemplate");
		return modelAndView;
	}
	
	
	/**
	 * 修改学员基础信息<BR>
	 * 方法名：updateStudent<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年2月18日-上午10:51:56 <BR>
	 * @param studentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping("/updateStudent")
	@ResponseBody
	private int updateStudent(StudentVO studentVO,HttpSession session){
		EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
        int count = iStudentArchivesService.selectStuExist(studentVO);
        if(count > 0){
        	return 2;
        }else{
        	studentVO.setModifyTime(new Date());
        	studentVO.setModifyUser(employee.getEmployeeCode());
        	int result = iStudentArchivesService.updateStudent(studentVO);
        	if(result > 0){
        		return 1;
        	}
        	return 0;
        }
	}

}

