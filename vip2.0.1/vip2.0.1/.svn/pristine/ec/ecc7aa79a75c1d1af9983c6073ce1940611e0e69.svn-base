package com.moon.vip.controller.major;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.sys.MajorFrameVO;
import com.moon.vip.service.major.IMajorFrameService;
import com.moon.vip.service.sys.IGetChildListService;

/**
 * 专业框架controller层
 * @author wesley
 *
 */
@Controller
@RequestMapping("/majorFrame")
public class MajorFrameController extends BaseController {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(MajorFrameController.class);
	@Autowired
	IMajorFrameService majorFrameService;
	@Autowired
	IGetChildListService iGetChildListService;
	/**   
	 * @方法名: majorFrameTree   
	 * @描述: 导航到专业框架主页面
	 * @作者: wesley
	 * @日期:2016年4月26日下午3:29:52   
	 */  
	@RequestMapping("/majorFrameTree")
	public ModelAndView majorFrameTree() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/page/professional/majorFrame");
		return view;
	}

	/**   
	 * @方法名: allMajorFrameInfo   
	 * @描述: 专业框架全树展示
	 * @作者: wesley         
	 * @日期:2016年4月26日下午3:30:34   
	 */  
	@RequestMapping("/allMajorFrameInfo")
	@ResponseBody
	public List<MajorFrameVO> allMajorFrameInfo() {
		String idStr=iGetChildListService.getChildList(1);//获得组织机构为1下的所有子节点
		List<MajorFrameVO> sourceList = majorFrameService.selectInfoById(idStr);
		return majorFrameService.filterMajorFrame(sourceList, super.achieveAuth());
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：新增职能<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 */
	@RequestMapping("/add")
	@ResponseBody
	public int addFunction(MajorFrameVO majorFrame, HttpSession session) {
		EmployeeLoginVO emp = (EmployeeLoginVO) session.getAttribute("employee");
		Date date = new Date();
		majorFrame.setCreateTime(date);
		majorFrame.setCreator(emp.getEmployeeCode());
		majorFrame.setModifyTime(date);
		majorFrame.setModifyPerson(emp.getEmployeeCode());
		majorFrameService.addBranch(majorFrame);
		if (majorFrame.getId() == null) {
			return -1;
		}
		return majorFrame.getId();
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：删除职能<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 * 修改备注：TODO<br/>
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public int delete(Integer id) {
		return majorFrameService.deleteById(id);
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：删除专业<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 * 修改备注：TODO<br/>
	 */
	@RequestMapping("/deleteMajorById")
	@ResponseBody
	public int deleteMajorById(Integer id) {
		return majorFrameService.deleteMajorById(id);
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：重命名职能<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 * 修改备注：TODO<br/>
	 */
	@RequestMapping("/rename")
	@ResponseBody
	public int rename(MajorFrameVO majorFrame, HttpSession session) {
		EmployeeLoginVO emp = (EmployeeLoginVO) session.getAttribute("employee");
		majorFrame.setModifyTime(new Date());
		majorFrame.setModifyPerson(emp.getEmployeeCode());
		return majorFrameService.rename(majorFrame);
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：增加专业<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 */
	@RequestMapping("/addMajor")
	@ResponseBody
	public int addMajor(MajorFrameVO majorFrame, HttpSession session,
			@RequestParam(value = "teacherList[]", required = false) List<String> teacherList,
			@RequestParam(value = "adviserList[]", required = false) List<String> adviserList) {
		EmployeeLoginVO emp = (EmployeeLoginVO) session.getAttribute("employee");
		if (null == teacherList || null == adviserList) {
			return -10;
		}
		Date date = new Date();
		majorFrame.setCreateTime(date);
		majorFrame.setCreator(emp.getEmployeeCode());
		majorFrame.setModifyTime(date);
		majorFrame.setModifyPerson(emp.getEmployeeCode());
		int id=majorFrameService.addMajor(majorFrame);
		if(id>=0){
			List<MajorFrameVO> adviserLists = setTeacherAndAdviser(adviserList, "adviser", majorFrame.getId(), emp);
			majorFrameService.addTeacherOrAdviser(adviserLists);
			List<MajorFrameVO> teacherLists = setTeacherAndAdviser(teacherList, "teacher", majorFrame.getId(), emp);
			majorFrameService.addTeacherOrAdviser(teacherLists);
		}
		
		return id;
	}
	
	private List<MajorFrameVO> setTeacherAndAdviser(List<String> list, String type, Integer id,
			EmployeeLoginVO emp) {
		Date date = new Date();
		List<MajorFrameVO> majorFrameVoList = new ArrayList<MajorFrameVO>();
		for (String employeeCode : list) {
			MajorFrameVO majorFrameVo = new MajorFrameVO();
			majorFrameVo.setId(id);
			majorFrameVo.setCreateTime(date);
			majorFrameVo.setCreator(emp.getEmployeeCode());
			majorFrameVo.setModifyTime(date);
			majorFrameVo.setModifyPerson(emp.getEmployeeCode());
			majorFrameVo.setType(type);
			majorFrameVo.setEmployeeCode(employeeCode);
			majorFrameVoList.add(majorFrameVo);
		}
		return majorFrameVoList;
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：增加专业代码<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 */
	@RequestMapping("/addMajorCode")
	@ResponseBody
	public int addMajorCode(MajorFrameVO majorFrameVo, HttpSession session) {
		EmployeeLoginVO emp = (EmployeeLoginVO) session.getAttribute("employee");
		Date date=new Date();
		majorFrameVo.setCreateTime(date);
		majorFrameVo.setCreator(emp.getEmployeeCode());
		majorFrameVo.setModifyTime(date);
		majorFrameVo.setModifyPerson(emp.getEmployeeCode());
		majorFrameVo.setProfessionalPrex(SysConstantsVal.PROFESSIONAL_PREX);
		return majorFrameService.addMajorCode(majorFrameVo);
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：修改专业代码<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 */
	@RequestMapping("/updateMajor")
	@ResponseBody
	public int updateMajor(MajorFrameVO majorFrameVo, HttpSession session,
			@RequestParam(value = "teacherArray[]", required = false) List<String> teacherList,
			@RequestParam(value = "adviserArray[]", required = false) List<String> adviserList) {
		EmployeeLoginVO emp = (EmployeeLoginVO) session.getAttribute("employee");
		if (null == teacherList || null == adviserList) {
			return -10;
		}
		Date date = new Date();
		majorFrameVo.setModifyTime(date);
		majorFrameVo.setModifyPerson(emp.getEmployeeCode());
		List<MajorFrameVO> adviserLists = setTeacherAndAdviser(adviserList, "adviser", majorFrameVo.getId(), emp);
		List<MajorFrameVO> teacherLists = setTeacherAndAdviser(teacherList, "teacher", majorFrameVo.getId(), emp);
		return majorFrameService.updateMajor(majorFrameVo, adviserLists, teacherLists);

	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：修改专业代码<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 */
	@RequestMapping("/updateMajorCode")
	@ResponseBody
	public int updateMajorCode(MajorFrameVO majorFrameVo, HttpSession session) {
		EmployeeLoginVO emp = (EmployeeLoginVO) session.getAttribute("employee");
		Date date = new Date();
		majorFrameVo.setCreateTime(date);
		majorFrameVo.setCreator(emp.getEmployeeCode());
		majorFrameVo.setModifyTime(date);
		majorFrameVo.setModifyPerson(emp.getEmployeeCode());
		return majorFrameService.updateMajorCode(majorFrameVo);
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：模糊查询<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 */
	@RequestMapping("/searchContent")
	@ResponseBody
	public ModelAndView searchContent(MajorFrameVO majorFrameVO) {
		ModelAndView mav = new ModelAndView();
		majorFrameVO.setOpClaIds(super.achieveAuth());
		List<MajorFrameVO> list = majorFrameService.searchContent(majorFrameVO);
		for (MajorFrameVO c : list) {
			String[] teacherStr = c.getTeacher().split(","); // 如果讲师超过了三位 省略后面部分
			if (teacherStr.length > 3) {
				StringBuffer sb = new StringBuffer();
				sb.append(teacherStr[0]).append(",").append(teacherStr[1]).append(",").append(teacherStr[2]).append("..");
				c.setTeacherName(sb.toString());
			} else {
				c.setTeacherName(c.getTeacher());
			}
			String[] adviserStr=c.getAdviser().split(",");
			if (adviserStr.length > 3) {
				StringBuffer sb = new StringBuffer();
				sb.append(adviserStr[0]).append(",").append(adviserStr[1]).append(",").append(adviserStr[2]).append("..");
				c.setAdviserName(sb.toString());
			} else {
				c.setAdviserName(c.getAdviser());
			}
		}
		mav.addObject("majorList", list);
		mav.setViewName("/page/professional/majorList");
		return mav;
	}

	

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：根据部门ID查询对应的部门信息和集群<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 * 修改备注：TODO<br/>
	 */
	@RequestMapping("/selectBranchAndColony")
	@ResponseBody
	public MajorFrameVO selectBranchAndColony(MajorFrameVO majorFrameVO) {
		return majorFrameService.selectBranchAndColony(majorFrameVO);
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：查询所有老师或者班主任<br/>
	 * 修改说明（时间、人）：Wesley <br/>
	 * 2016年3月21日 20:11:32  <br/>
	 */
	@RequestMapping("/selectTeacherOrAdviser")
	@ResponseBody
	public List<MajorFrameVO> selectTeacherOrAdviser(MajorFrameVO majorFrameVO) {
		return majorFrameService.selectTeacherOrAdviser(majorFrameVO);
	}
	
	/**
	 * 
	 * @方法名: selectTeacherOrAdviserByCode   
	 * @作用: 根据传递过来的员工数组及类型(讲师teacher 班主任 adviser) 去查询讲师或班主任信息
	 * @作者: wesley
	 * @日期:2016年3月21日 20:07:50
	 */
	@RequestMapping("/selectTeacherOrAdviserByCode")
	@ResponseBody
	public MajorFrameVO selectTeacherOrAdviserByCode(
			@RequestParam(value = "teacherArray[]", required = false) List<String> teacherList,
			@RequestParam(value = "adviserArray[]", required = false) List<String> adviserList, String type) {
		MajorFrameVO majorFrameVO = new MajorFrameVO();
		if("adviser".equals(type)){
			if (null == adviserList) {
				return majorFrameVO;
			}
			majorFrameVO = majorFrameService.selectTeacherOrAdviserByCode(adviserList);
		}
		if("teacher".equals(type)){
			if (null == teacherList) {
				return majorFrameVO;
			}
			majorFrameVO = majorFrameService.selectTeacherOrAdviserByCode(teacherList);
		}
		String str[] = majorFrameVO.getName().split(",");
		StringBuffer sb = new StringBuffer();
		if (str.length <= 5) {
			sb.append(majorFrameVO.getName());
		} else {
			sb.append(str[0]).append(",").append(str[1]).append(",").append(str[2]).append(",").append(str[3])
					.append(",").append(str[4]).append(".....");
		}
		
		if("adviser".equals(type)){
			majorFrameVO.setAdviser(majorFrameVO.getName());
			majorFrameVO.setAdviserName(sb.toString());
		}
		if("teacher".equals(type)){
			majorFrameVO.setTeacher(majorFrameVO.getName());
			majorFrameVO.setTeacherName(sb.toString());
		}
		return majorFrameVO;
	}
	
	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：查询所有的负责人<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 */
	@RequestMapping("/selectAppointPerson")
	@ResponseBody
	public List<MajorFrameVO> selectAppointPerson() {
		return  majorFrameService.selectAppointPerson();
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：查询对应职能已经有的负责人<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 */
	@RequestMapping("/selectAppointPersonById")
	@ResponseBody
	public List<MajorFrameVO> selectAppointPersonById(MajorFrameVO majorFrameVO) {
		return majorFrameService.selectAppointPersonById(majorFrameVO);
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：指定负责人<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 */
	@RequestMapping("/addSuperior")
	@ResponseBody
	public int addSuperior(HttpSession session,
			@RequestParam(value = "superiorArray[]", required = false) List<String> superiorList,
			@RequestParam(value = "id") Integer id) {
		EmployeeLoginVO emp = (EmployeeLoginVO) session.getAttribute("employee");
		MajorFrameVO majorFrameVo=new MajorFrameVO();
		majorFrameVo.setId(id);
		majorFrameService.deleteSuperior(majorFrameVo);
		Date date = new Date();
		
		List<MajorFrameVO> majorFrameVOList = new ArrayList<MajorFrameVO>();
		for (String superior : superiorList) {
			majorFrameVo = new MajorFrameVO();
			majorFrameVo.setId(id);
			majorFrameVo.setSuperior(superior);
			majorFrameVo.setCreateTime(date);
			majorFrameVo.setCreator(emp.getEmployeeCode());
			majorFrameVo.setModifyTime(date);
			majorFrameVo.setModifyPerson(emp.getEmployeeCode());
			majorFrameVOList.add(majorFrameVo);
		}
		
		
		return majorFrameService.addSuperior(majorFrameVOList);
	}

	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：搜索<br/>
	 * 修改说明（时间、人）：搜索老师或者班主任<br/>
	 * 下午2:30:44 Wesley <br/>
	 */

	@RequestMapping("/searchTeacherOrAdviser")
	@ResponseBody
	public List<MajorFrameVO> searchTeacherOrAdviser(MajorFrameVO majorFrameVO) {
		return majorFrameService.searchTeacherOrAdviser(majorFrameVO);
	}

	/**   
	 * @方法名: getTeacherAndAdviser   
	 * @描述: 获得讲师和班主任 （修改弹出展示title）
	 * @作者:    wesley      
	 * @日期:2016年3月21日下午8:14:13   
	 */  
	@RequestMapping("/getTeacherAndAdviser")
	@ResponseBody
	public MajorFrameVO getTeacherAndAdviser(MajorFrameVO majorFrameVO) {
		return majorFrameService.getTeacherAndAdviser(majorFrameVO);
	}

	
	/**   
	 * @方法名: getUpdateTeacherListOrAdviserList   
	 * @描述: 获得未被选中的讲师或者班主任列表
	 * @作者: wesley         
	 * @日期:2016年3月21日下午8:13:33   
	 */  
	@RequestMapping("/getUpdateTeacherListOrAdviserList")
	@ResponseBody
	public List<MajorFrameVO> getUpdateTeacherListOrAdviserList(MajorFrameVO majorFrameVO) {
		return majorFrameService.getUpdateTeacherListOrAdviserList(majorFrameVO);
	}
	
	/**   
	 * @方法名: getChooseTeacherListOrAdviserList   
	 * @描述: 获得已经选择老师或者班主任(修改) 
	 * @作者: wesley    
	 * @日期:2016年3月21日下午8:12:26   
	 */  
	@RequestMapping("/getChooseTeacherListOrAdviserList")
	@ResponseBody
	public List<MajorFrameVO> getChooseTeacherListOrAdviserList(MajorFrameVO majorFrameVO) {
		return majorFrameService.getChooseTeacherListOrAdviserList(majorFrameVO);
	}
	
	
	/**
	 * 日期：2016年1月11日 下午17:00:44<br/>
	 * 描述：模糊查询总条数<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:30:44 Wesley <br/>
	 */
	@RequestMapping("/getSearchCount")
	@ResponseBody
	public int getSearchCount(MajorFrameVO majorFrameVO) {
		majorFrameVO.setOpClaIds(super.achieveAuth());
		return majorFrameService.getSearchCount(majorFrameVO);
	}
	
	/**   
	 * @方法名: updateOrganizationPid   
	 * @描述: 拖拽节点
	 * @作者: wesley         
	 * @日期:2016年4月21日下午7:54:18   
	 */  
	@RequestMapping("/updateOrganizationPid")
	@ResponseBody
	public int updateOrganizationPid(MajorFrameVO majorFrame){
		return majorFrameService.updateOrganizationPid(majorFrame);
	}
	
	
	/**   
	 * @方法名: getClassInfo   
	 * @描述: 获得班级信息  
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午9:01:01   
	 */ 
	@RequestMapping("/getClassInfo")
	@ResponseBody
	public ModelAndView getClassInfo(MajorFrameVO majorFrame){
		majorFrame.setOpClaIds(super.achieveAuth());
		List<MajorFrameVO> list=majorFrameService.getClassInfo(majorFrame);
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("/page/sys/classSettingList");
		return mav;
	}
	
	/**   
	 * @方法名: getClassCount   
	 * @描述: 获得班级总数
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午9:27:39   
	 */
	@RequestMapping("/getClassCount")
	@ResponseBody
	public Integer getClassCount(MajorFrameVO majorFrame){
		majorFrame.setOpClaIds(super.achieveAuth());
		return majorFrameService.getClassCount(majorFrame);
	}
	
	
	/**   
	 * @方法名: addClass   
	 * @描述: 新增班级
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午9:27:39   
	 */
	@RequestMapping("/addClass")
	@ResponseBody
	public Message addClass(MajorFrameVO majorFrame,HttpSession session){
		Message msg=new Message();
		try{
			EmployeeLoginVO emp = (EmployeeLoginVO) session.getAttribute("employee");
			majorFrame.setCreateTime(new Date());
			majorFrame.setCreator(emp.getEmployeeCode());
			majorFrame.setIsEnd(SysConstantsVal.IS_END);
			majorFrame.setIsValid(SysConstantsVal.IS_VALID);
			majorFrame.setType(SysConstantsVal.CLASS_TYPE);
			majorFrameService.addClass(majorFrame);
			msg.setResultMsg(true, "添加班级成功");
		}catch(BusinessException b){
			msg.setResultMsg(false, b.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			msg.setResultMsg(false,"操作失败");
		}
		return msg;
	}
	
}
