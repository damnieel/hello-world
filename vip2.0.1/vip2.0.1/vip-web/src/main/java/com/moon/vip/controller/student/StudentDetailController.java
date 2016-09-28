//package com.moon.vip.controller.student;
//
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.alibaba.fastjson.JSON;
//import com.moon.platform.commons.util.BlankUtil;
//import com.moon.vip.controller.BaseController;
//import com.moon.vip.controller.uploadStudentData.UploadUtil;
//import com.moon.vip.infra.vo.EmployeeLoginVO;
//import com.moon.vip.infra.vo.student.ClassVO;
//import com.moon.vip.infra.vo.student.CourseVO;
//import com.moon.vip.infra.vo.student.ProfessionalVO;
//import com.moon.vip.infra.vo.student.StuProfessionalVO;
//import com.moon.vip.infra.vo.student.StudentCodeVO;
//import com.moon.vip.infra.vo.student.StudentVO;
//import com.moon.vip.service.student.IProfessionalService;
//import com.moon.vip.service.student.IRepeatStudentService;
//import com.moon.vip.service.student.IStudentArchivesService;
//import com.moon.vip.service.sys.IProfessionSquenceService;
//
///**
// * 学员信息模块
// * StudentDetailController<BR>
// * 创建人:娴贵 <BR>
// * 时间：2015年12月30日-下午9:07:57 <BR>
// * @version 1.0.0
// * 
// */
///*@Controller
//@RequestMapping("/student/studentDetail")*/
//public class StudentDetailController extends BaseController{
//	
//	@Autowired
//	private IStudentArchivesService iStudentArchivesService;
//	@Autowired
//	private IProfessionalService iProfessionalService;
//	@Autowired
//	private IRepeatStudentService iRepeatStudentService;
//	@Autowired
//	private IProfessionSquenceService iprofessionSquenceService;
//	@Autowired	
//	private UploadUtil upload;
//	
//	private String ICON_IMG="IconImg";
//	private String IDCARD_A="idcardA";
//	private String IDCARD_B="idcardB";
//	/**
//	 * 学员信息列表页面<BR>
//	 * 方法名：studentList<BR>
//	 * 创建人：娴贵 <BR>
//	 * 时间：2015年12月31日-下午3:32:12 <BR>
//	 * @return ModelAndView<BR>
//	 * @exception <BR>
//	 * @since  1.0.0
//	*/
//	@RequestMapping("/studentList")
//	private ModelAndView studentList(HttpServletResponse response){
//		ModelAndView modelAndView = new ModelAndView();
//		Cookie cookie = new Cookie("menu", "studentInfoPages");
//		cookie.setPath("/");
//		response.addCookie(cookie);		
//		modelAndView.setViewName("/page/student/studentList");
//		return modelAndView;
//	}
//	
//	/**
//	 * 学员信息列表模板页面<BR>
//	 * 方法名：studentTemplate<BR>
//	 * 创建人：娴贵 <BR>
//	 * 时间：2015年12月31日-下午3:37:30 <BR>
//	 * @return ModelAndView<BR>
//	 * @exception <BR>
//	 * @since  1.0.0
//	*/
//	@RequestMapping("/studentTemplate")
//	private ModelAndView studentTemplate(StudentVO studentVO){
//		ModelAndView modelAndView = new ModelAndView();
//		studentVO.setOpClaIds(achieveAuth());
//		List<StudentVO> list =new ArrayList<StudentVO>();
//		if(studentVO.getIsArrears().equals("type")){
//			studentVO.setIsArrears("");
//		}
//		List<StudentVO> student = iStudentArchivesService.selectAllStudent(studentVO);
//		for (StudentVO studentVO2 : student) {
//			int i =iStudentArchivesService.selectIsRefund(studentVO2.getId());
//			if(i >0){
//				studentVO2.setIsArrears("是");
//			}else{
//				studentVO2.setIsArrears("否");
//			}
//			studentVO2.setStuName(studentVO2.getStuName());
//			list.add(studentVO2);
//		}
//		int count = iStudentArchivesService.selectAllStudentCount(studentVO);
//		modelAndView.addObject("count", count);
//		//modelAndView.addObject("offset", studentVO.getOffset());
//		modelAndView.addObject("student", list);
//		modelAndView.setViewName("/page/student/studentTemplate");
//		return modelAndView;
//	}
//	
//	/**
//	 * 查看个人详情<BR>
//	 * 方法名：personalDetail<BR>
//	 * 创建人：娴贵 <BR>
//	 * 时间：2016年1月4日-上午10:57:13 <BR>
//	 * @return ModelAndView<BR>
//	 * @exception <BR>
//	 * @since  1.0.0
//	*/
//	@RequestMapping("/personalDetail/{id}")
//	public ModelAndView personalDetail(@PathVariable("id")Integer id){
//		ModelAndView modelAndView = new ModelAndView();
//	    StudentVO studentVO = iStudentArchivesService.selectStuDetail(id);/***获取个人信息***/
//	    if(studentVO.getEducationBackgroundKey() == null || "".equals(studentVO.getEducationBackgroundKey())){
//	    	studentVO.setEducationBackgroundValue("无学历");
//	    }else{
//	    	StudentVO degree =iStudentArchivesService.selectByDegree(studentVO.getEducationBackgroundKey());/***从码表获取学历***/
//	    	studentVO.setEducationBackgroundValue(degree.getEducationBackgroundValue());
//	    }
//	    if(studentVO.getOccupationCodeKey() == null || "".equals(studentVO.getOccupationCodeKey())){
//	    	studentVO.setOccupationCodeValue("无职业");
//	    }else{
//	    	StudentVO professional =iStudentArchivesService.selectByProfessional(studentVO.getOccupationCodeKey());/***从码表获取职业***/
//	    	if(professional == null ){
//	    		studentVO.setOccupationCodeValue("无职业");
//	    	}else{
//	    		studentVO.setOccupationCodeValue(professional.getOccupationCodeValue());
//	    	}
//	    }
//	    List<CourseVO> list = new  ArrayList<CourseVO>();
//		List<CourseVO> course =iStudentArchivesService.selectCourseDetail();
//		for (CourseVO courseVO : course) {
//			if(courseVO.getRemark() ==null || "".equals(courseVO.getRemark())){
//				courseVO.setRemark("无");	
//			}
//			if(courseVO.getArrears().intValue() == 0 || courseVO.getArrears() == null){/***转化尾款0.00***/
//				courseVO.setArrears(new BigDecimal(0));
//			}
//			if(courseVO.getRefundMonetary() == null || courseVO.getRefundMonetary().intValue() == 0){/***转化退款0.00***/
//				courseVO.setRefundMonetary(new BigDecimal(0));
//			}
//			if(courseVO.getPayMethodKey() == null || "".equals(courseVO.getPayMethodKey())){
//				courseVO.setPayMethodValue("其他方式");
//			}else{
//				CourseVO payMethodValue =iStudentArchivesService.selectByPayment(courseVO.getPayMethodKey());/***从码表获取支付方式***/
//				courseVO.setPayMethodValue(payMethodValue.getPayMethodValue());
//			}
//		    if(courseVO.getRefundReasonKey() == null ||"".equals(courseVO.getRefundReasonKey())){
//		    	courseVO.setPayMethodValue("无");
//		    	
//		    }else{
//		    	CourseVO RefundReason=iStudentArchivesService.selectByRefundReason(courseVO.getRefundReasonKey());/***从码表获取退费原因***/
//		    	courseVO.setRefundReasonVlaue(RefundReason.getRefundReasonVlaue());
//		    }
//			list.add(courseVO);
//		}
//		modelAndView.addObject("student", studentVO);
//		modelAndView.addObject("course", list);
//		modelAndView.setViewName("/page/student/personalDetail");
//		return modelAndView;
//	}
//	
//	/**
//	 * 跳转到添加学员信息页面<BR>
//	 * 方法名：addStudentMessage<BR>
//	 * 创建人：娴贵 <BR>
//	 * 时间：2016年1月4日-下午8:36:14 <BR>
//	 * @param studentVO
//	 * @return ModelAndView<BR>
//	 * @exception <BR>
//	 * @since  1.0.0
//	*/
//	@RequestMapping(value ="/addStudentMessage/{id}",method ={RequestMethod.POST,RequestMethod.GET})
//    public ModelAndView addStudentMessage(@PathVariable("id")Integer id){
//		ModelAndView modelAndView = new ModelAndView();
//		/***获取所有下拉列表的值***/
//        List<ProfessionalVO> professionalVOs = iProfessionalService.selectALLDownbox();
//        List<ClassVO> classVOs = iStudentArchivesService.selectCourse();
//      
//        /***获取个人信息(跳到编辑页面)***/
//        if(id != -1){
//        	StudentVO studentVO = iStudentArchivesService.selectStuDetail(id);
//    	    if(studentVO.getEducationBackgroundKey() == null || "".equals(studentVO.getEducationBackgroundKey())){
//    	    	studentVO.setEducationBackgroundValue("无学历");
//    	    }else{
//    	    	StudentVO degree =iStudentArchivesService.selectByDegree(studentVO.getEducationBackgroundKey());/***从码表获取学历***/
//    	    	studentVO.setEducationBackgroundValue(degree.getEducationBackgroundValue());
//    	    }
//    	    if(studentVO.getOccupationCodeKey() == null || "".equals(studentVO.getOccupationCodeKey())){
//    	    	studentVO.setOccupationCodeValue("无职业");
//    	    }else{
//    	    	StudentVO professional =iStudentArchivesService.selectByProfessional(studentVO.getOccupationCodeKey());/***从码表获取职业***/
//    	    	if(professional !=null){
//    	    		studentVO.setOccupationCodeValue(professional.getOccupationCodeValue());
//    	    	}else{
//    	    		studentVO.setOccupationCodeValue("无职业");
//    	    	}
//    	    }
//    	    List<CourseVO> list = new  ArrayList<CourseVO>();
//    		List<CourseVO> course =iStudentArchivesService.selectCourseDetail(id);
//    		for (CourseVO courseVO : course) {
//    			if(courseVO.getRemark() ==null || "".equals(courseVO.getRemark())){
//    				courseVO.setRemark("无");	
//    			}
//    			if(courseVO.getArrears().intValue() == 0 || courseVO.getArrears() == null){/***转化尾款0.00***/
//    				courseVO.setArrears(new BigDecimal(0));
//    			}
//    			if(courseVO.getRefundMonetary() == null || courseVO.getRefundMonetary().intValue() == 0){/***转化退款0.00***/
//    				courseVO.setRefundMonetary(new BigDecimal(0));
//    			}
//    			if(courseVO.getPayMethodKey() == null || "".equals(courseVO.getPayMethodKey())){
//    				courseVO.setPayMethodValue("其他方式");
//    			}else{
//    				CourseVO payMethodValue =iStudentArchivesService.selectByPayment(courseVO.getPayMethodKey());/***从码表获取支付方式***/
//    				courseVO.setPayMethodValue(payMethodValue.getPayMethodValue());
//    			}
//    		    if(courseVO.getRefundReasonKey() == null ||"".equals(courseVO.getRefundReasonKey())){
//    		    	courseVO.setPayMethodValue("无");
//    		    	
//    		    }else{
//    		    	CourseVO RefundReason=iStudentArchivesService.selectByRefundReason(courseVO.getRefundReasonKey());/***从码表获取退费原因***/
//    		    	courseVO.setRefundReasonVlaue(RefundReason.getRefundReasonVlaue());
//    		    }
//    		    if(courseVO.getStatues().equals("reading") || "".equals(courseVO.getStatues())){
//    				courseVO.setStatuesValue("在读");
//    			}else if (courseVO.getStatues().equals("drop")){
//    				courseVO.setStatuesValue("退学");
//    			}else if(courseVO.getStatues().equals("pause")){
//    				courseVO.setStatuesValue("休学");
//    			}else if(courseVO.getStatues().equals("continues")){
//    				courseVO.setStatuesValue("复学");
//                }else if(courseVO.getStatues().equals("stay")){
//                	courseVO.setStatuesValue("留级");
//                }else if(courseVO.getStatues().equals("end")){
//                	courseVO.setStatuesValue("结束");
//                }
//    			list.add(courseVO);
//    		}
//    		modelAndView.addObject("student", studentVO);
//    		modelAndView.addObject("courseVO", list);
//        }
//        modelAndView.addObject("professional", professionalVOs);
//        modelAndView.addObject("course", classVOs);
//		modelAndView.setViewName("/page/student/addStudentMessage");
//		return modelAndView;
//	}
//	
//	/****获取所有添加专业信息所需要的下拉值（支付方式和退费原因）***/
//	@RequestMapping(value = "/selectALLDownboxValue",method = {RequestMethod.POST,RequestMethod.GET})
//	@ResponseBody
//	public List<ProfessionalVO> selectALLDownboxValue(){
//		/***获取所有下拉列表的值***/
//        List<ProfessionalVO> professionalVOs = iProfessionalService.selectALLDownbox();
//		return professionalVOs;
//	}
//	
//	/***获取所有添加专业信息所需要的下拉值(专业)***/
//	@RequestMapping(value = "/selectMoreCourse",method = {RequestMethod.POST,RequestMethod.GET})
//	@ResponseBody
//	public List<ClassVO> selectMoreCourse(Integer id){
//		/***获取所有下拉列表的值***/
//		List<ClassVO> classVOs = iStudentArchivesService.selectCourse();
//		return classVOs;
//	}
//	
//	/**
//	 * 删除课程专业信息<BR>
//	 * 方法名：deleteCourse<BR>
//	 * 创建人：娴贵 <BR>
//	 * 时间：2016年1月15日-上午11:27:10 <BR>
//	 * @param pId
//	 * @return String<BR>
//	 * @exception <BR>
//	 * @since  1.0.0
//	*/
//	@RequestMapping(value = "/deleteCourse/{pId}",method ={RequestMethod.GET,RequestMethod.POST})
//	@ResponseBody
//	public String deleteCourse(@PathVariable("pId")Integer pId){
//		int i = iStudentArchivesService.deleteCourse(pId);
//		if(i > 0){
//			return "success";
//		}
//		return "fail";
//	}
//	
//	/**
//	 * 保存学员信息<BR>
//	 * 方法名：saveStudentDetail<BR>
//	 * 创建人：娴贵 <BR>
//	 * 时间：2016年1月4日-下午9:04:12 <BR>
//	 * @param studentVO
//	 * @return ModelAndView<BR>
//	 * @throws Exception 
//	 * @exception <BR>
//	 * @since  1.0.0
//	*/
//	@RequestMapping(value ="/saveStudentDetail",method = { RequestMethod.POST, RequestMethod.GET })
//	@ResponseBody
//	public String saveStudentDetail(StudentVO studentVO,HttpSession session,HttpServletRequest request) throws Exception{
//	    EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
////	    StudentVO vo = iStudentArchivesService.selectPersonalDetail(studentVO);
////		if(vo !=null){
////			return "exist";
////		}
//	    Map<String, String> nameUrl = upload.upload(request, null);
//	    /***保存图片地址***/
//	    addUrlToVO(nameUrl, studentVO);
//		if(studentVO.getEducationBackgroundKey().equals("请选择")){
//			studentVO.setEducationBackgroundKey("unEducation");
//		}
//		studentVO.setCreateTime(new Date());
//		studentVO.setCreator(employee.getEmployeeCode());
//		studentVO.setIsValid("Y");
//	    /***生成学员编号***/
//	    if(studentVO.getId() == null){
//	    	studentCodeNumber(studentVO);
//	    	int i = iStudentArchivesService.insertStuArchives(studentVO);
//	    	if(i>0){
//	    		return "success";	
//	    	}
//	    }else{
//	    	int i =iStudentArchivesService.updateStuArchives(studentVO);
//	    	if(i>0){
//	    		return "success";	
//	    	}
//	    }
//	    return "fail";
//	}
//	
//	
//	
//	
//	/***生成学员编号***/
//	private void studentCodeNumber(StudentVO studentVO) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//		   StudentCodeVO student = iStudentArchivesService.selectStudentCodeMax();/**查询最大学员编号**/
//		   StudentCodeVO codeVO = new StudentCodeVO(); 
//		   codeVO.setStudentCodeTime(new Date());
//		   if(student == null ){/***系统没有编号，添加一条 （时间+编号）**/
//			   codeVO.setStudentCodeNumber(1);
//			   iStudentArchivesService.insertStudentCodeMax(codeVO);
//			   String s = sdf.format(new Date());
//			   String[] sss = s.split("-");
//			   studentVO.setCodeNo("TZs"+sss[0]+sss[1]+1);
//		   }else{/**存在的记录的时间**/
//			    String s1 = sdf.format(student.getStudentCodeTime());
//			    String s2 = sdf.format(new Date());/**当前时间**/
//			    String[] s11 = s1.split("-");
//			    String[] s22 = s2.split("-");
//				if(Integer.valueOf(s11[0]) <= Integer.valueOf(s22[0])){
//					 if(Integer.valueOf(s11[0])-Integer.valueOf(s22[0])==0){/***年份相同***/
//						     if((Integer.valueOf(s22[1]) - Integer.valueOf(s11[1]))>0){/***比较月份不同***/
//						    	   codeVO.setStudentCodeNumber(1);
//								   iStudentArchivesService.insertStudentCodeMax(codeVO);
//								   studentVO.setCodeNo("TZs"+s22[0]+s22[1]+1);
//						      }else{/***月份相同***/
//						    	   codeVO.setId(student.getId());
//						    	   codeVO.setStudentCodeNumber(student.getStudentCodeNumber()+1);
//								   iStudentArchivesService.updateStudentCodeMax(codeVO);
//								   studentVO.setCodeNo("TZs"+s22[0]+s22[1]+(student.getStudentCodeNumber()+1));
//								   int count =iStudentArchivesService.selectStudentCode(studentVO.getCodeNo());
//								   /***判断生成的学员编号是否存在***/
//								   if(count > 0){
//										for(int bb = codeVO.getStudentCodeNumber()+1;bb < 50000;bb++){
//										    studentVO.setCodeNo("TZs"+s22[0]+s22[1]+bb);
//											int counts =iStudentArchivesService.selectStudentCode(studentVO.getCodeNo());
//											if(counts == 0){
//												codeVO.setStudentCodeNumber(bb);;
//												iStudentArchivesService.updateStudentCodeMax(codeVO);
//												studentVO.setCodeNo("TZs"+s22[0]+s22[1]+bb);
//												break;
//											}
//										}
//									 }
//							  }
//					   }else{/***年份不同***/
//						     codeVO.setStudentCodeNumber(1);
//						     codeVO.setStudentCodeTime(new Date());
//						     iStudentArchivesService.insertStudentCodeMax(codeVO);
//						     StudentCodeVO students = iStudentArchivesService.selectStudentCodeMax();
//						     studentVO.setCodeNo("TZs"+s22[0]+s22[1]+1);
//						     int count =iStudentArchivesService.selectStudentCode(studentVO.getCodeNo());
//							 /***判断生成的学员编号是否存在***/
//						     if(count > 0){
//								for(int bb = codeVO.getStudentCodeNumber()+1;bb < 50000;bb++){
//								    studentVO.setCodeNo("TZs"+s22[0]+s22[1]+bb);
//									int counts =iStudentArchivesService.selectStudentCode(studentVO.getCodeNo());
//									if(counts == 0){
//										codeVO.setStudentCodeNumber(bb);
//										codeVO.setId(students.getId());
//										iStudentArchivesService.updateStudentCodeMax(codeVO);
//										studentVO.setCodeNo("TZs"+s22[0]+s22[1]+bb);
//										break;
//									}
//								}
//							 }
//				      }
//				}
//		   }
//	}
//	
//	/***保存图片地址***/
//	private void addUrlToVO(Map<String, String> urlMap,StudentVO studentVO){
//		/**头像**/
//		if(!BlankUtil.isBlank(urlMap.get(ICON_IMG))){
//			studentVO.setStuPictureUrl(urlMap.get(ICON_IMG));
//		}
//		/**身份证正面**/
//		if(!BlankUtil.isBlank(urlMap.get(IDCARD_A))){
//			studentVO.setCardFrontAddress(urlMap.get(IDCARD_A));
//		}
//		/**身份证反面**/
//		if(!BlankUtil.isBlank(urlMap.get(IDCARD_B))){
//			studentVO.setCardReverseAddress(urlMap.get(IDCARD_B));
//		}
//	} 
//	
//	/**
//	 * 查看是否保存了学员基础信息<BR>
//	 * 方法名：selectPersonalDetail<BR>
//	 * 创建人：娴贵 <BR>
//	 * 时间：2016年1月8日-下午8:15:23 <BR>
//	 * @param studentVO
//	 * @return int<BR>
//	 * @exception <BR>
//	 * @since  1.0.0
//	*/
//	@RequestMapping(value = "/selectPersonalDetail" ,method = { RequestMethod.POST, RequestMethod.GET })
//	@ResponseBody
//	public int selectPersonalDetail(StudentVO studentVO){
//		StudentVO vo = iStudentArchivesService.selectPersonalDetail(studentVO);
//		if(vo !=null){
//			int id=vo.getId();
//			return id;
//		}
//		return 0;
//	}
//	
//	
//	/**
//	 * 保存学员专业信息<BR>
//	 * 方法名：saveStudentCourse<BR>
//	 * 创建人：娴贵 <BR>
//	 * 时间：2016年1月5日-下午1:43:26 <BR>
//	 * @param courseVOs
//	 * @return ModelAndView<BR>
//	 * @exception <BR>
//	 * @since  1.0.0
//	*/
//	@RequestMapping(value = "/saveStudentCourse",method = { RequestMethod.POST, RequestMethod.GET })
//	@ResponseBody
//	public  String saveStudentCourse(HttpSession session,String courseList){
//		EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
//		List<StuProfessionalVO> list = new ArrayList<StuProfessionalVO>();
//		List<StuProfessionalVO> course = JSON.parseArray(courseList, StuProfessionalVO.class);
//		for (StuProfessionalVO courseVO : course) {
//			if("".equals(courseVO.getIsRefund()) || courseVO.getIsRefund() == null){/**是否退费**/
//				courseVO.setIsRefund("N");
//			}
//			if("".equals(courseVO.getRefundReason()) || courseVO.getRefundReason() == null){
//				courseVO.setRefundReason("noReason");
//			}
//			if(courseVO.getStatues() ==null || "".equals(courseVO.getStatues())){
//				courseVO.setStatues("reading");
//			}
//			BigDecimal amt= courseVO.getArrears(); 
//			if(amt.equals(BigDecimal.ZERO)){/**是否欠费**/
//				courseVO.setIsArrears("N");
//			}else{
//				courseVO.setIsArrears("Y");
//		    }
//			if(courseVO.getRefundMonetary() == null || courseVO.getRefundMonetary().intValue() == 0){/***转化退款0.00***/
//				courseVO.setRefundMonetary(new BigDecimal(0));
//			}
//			    courseVO.setIsValid("Y");
//				courseVO.setCreateTime(new Date());
//				courseVO.setCreator(employee.getEmployeeCode());
//			if(courseVO.getpId() == null){
//				/***生成学员专业编码****/
//				courseVO.setProfessionCode(iprofessionSquenceService.getStudentCode(courseVO.getEnterDate(), courseVO.getOpProId()));
//				list.add(courseVO);
//			}else{/**查询修改的学员编号是否存在**/
//				int j = iRepeatStudentService.selectStuProCode(courseVO.getProfessionCode());
//				if(j > 1){
//					return "error";
//				}else{
//					courseVO.setModifyTime(new Date());
//					courseVO.setModifyUser(employee.getEmployeeCode());
//					iStudentArchivesService.updateStuProfessional(courseVO);
//				}
//				
//			}
//		}  
//		    if(list.size() !=0){
//		    	int i = iStudentArchivesService.insertStuProfessional(list);
//		    	if(i>0){
//		    		return "success";
//		    	}
//		    	return "fail";
//		    }
//		    return "success";
//	}
//}
//
