//package com.moon.vip.controller.sys;
//
//
//
//import java.util.Date;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.moon.vip.controller.student.PaymentController;
//import com.moon.vip.infra.vo.sys.OrganizationalProfessionalVO;
//import com.moon.vip.infra.vo.sys.TeacherVO;
//import com.moon.vip.service.sys.IClassInFoService;
//
//@Controller
//@RequestMapping("/classinfo/classinfo")
//public class ClassInFoController {
//	private static Logger logger = Logger.getLogger(PaymentController.class);
//	   @Autowired
//       private IClassInFoService iClassInFoService;
//	   
//	   
//	   @RequestMapping("/allMajorFrameInfo")
//	   @ResponseBody
//		public List<OrganizationalProfessionalVO> majorFrameInfo(OrganizationalProfessionalVO organizationalProfessionalVO){
//		 
//		  List<OrganizationalProfessionalVO> a = iClassInFoService.selectInfoById(organizationalProfessionalVO);
////		  System.out.println(a.get(0).getPartentId());
//		  return a;
//		}
//	   
//	   /**
//		 * 班级信息页面<BR>
//		 * 方法名：classinfoList<BR>
//		 * 创建人：龙金 <BR>
//		 * 时间：2015年12月30日-下午2:53:17 <BR>
//		 * @return ModelAndView<BR>
//		 * @exception <BR>
//		 * @since  1.0.0
//		*/
//	   @RequestMapping("/classinfoList")
//	   public ModelAndView classinfoList(OrganizationalProfessionalVO organizationalProfessionalVO){
//		   ModelAndView mv=new ModelAndView();
//		   //老师和班主任
//		
//		    mv.setViewName("/page/sys/classSetting");
//		    return mv;
//	   }
//	   
//	   /**
//		 * 班级信息模板<BR>
//		 * 方法名：classinfoTemplate<BR>
//		 * 创建人：龙金 <BR>
//		 * 时间：2015年12月30日-下午2:54:10 <BR>
//		 * @return ModelAndView<BR>
//		 * @exception <BR>
//		 * @since  1.0.0
//		*/
//	   @RequestMapping("/classSettingList")
//	   @ResponseBody
//	   public ModelAndView classinfoTemplate(OrganizationalProfessionalVO organizationalProfessionalVO){
//		   ModelAndView mv=new ModelAndView();
//		   List<OrganizationalProfessionalVO>list=iClassInFoService.selectAllMar(organizationalProfessionalVO.getId());
//		   List<OrganizationalProfessionalVO> opv=iClassInFoService.selectTecher();
//	       List<OrganizationalProfessionalVO> opvo=iClassInFoService.selectAdviser();
//	       String str=iClassInFoService.selectOrgById(organizationalProfessionalVO.getId());
//	        mv.addObject("str",str);
//	        mv.addObject("list1",opv);
//		    mv.addObject("list2",opvo);
//		    mv.addObject("list3",list);
//		// List<OrganizationalProfessionalVO> op=iClassInFoService.selectAllMar(organizationalProfessionalVO.getId()); 
//		 List<OrganizationalProfessionalVO> organizationalProfessionalVOs = 
//				   iClassInFoService.selectAllClass(organizationalProfessionalVO.getId(),organizationalProfessionalVO.getOffset(), organizationalProfessionalVO.getPageSize());
//		 int count=iClassInFoService.selectClaCount(organizationalProfessionalVO.getId());
//		  
//		  // mv.addObject("list3",op);
//		   mv.addObject("offset",organizationalProfessionalVO.getOffset());
//		  // mv.addObject("id",organizationalProfessionalVO.getId());
//		   mv.addObject("count",count);
//		   mv.addObject("pageSize",organizationalProfessionalVO.getPageSize());
//		   mv.addObject("list",organizationalProfessionalVOs);
//		   mv.setViewName("/page/sys/classSettingList");
//		   return mv;
//		}
//	   
//	 /*  @RequestMapping(value ="/classSettingListCount")
//	   @ResponseBody
//	   public int classinfoTemplateCount(OrganizationalProfessionalVO organizationalProfessionalVO){
//		   int count=iClassInFoService.selectClaCount(organizationalProfessionalVO.getId());
//		   return count;
//		}*/
//	  
//	   
//	   
//	   /**
//		 * 修改班级信息<BR>
//		 * 方法名：updateClass<BR>
//		 * 创建人：龙金 <BR>
//		 * 时间：2015年12月30日-下午2:56:29 <BR>
//		 * @return int<BR>
//		 * @exception <BR>
//		 * @since  1.0.0
//		*/
//	   @RequestMapping("/updateClass")
//	   public int updateClass(){
//			return 0;
//		}
//	   
//	   /**
//		 * 添加班级信息<BR>
//		 * 方法名：addClass<BR>
//		 * 创建人：龙金 <BR>
//		 * 时间：2015年12月30日-下午2:56:51 <BR>
//	 * @param organizationalprofessionalVO 
//		 * @return int<BR>
//		 * @exception <BR>
//		 * @since  1.0.0
//		*/
//	   @RequestMapping("/addClass")
//	   @ResponseBody
//	   public  String addClass(OrganizationalProfessionalVO organizationalprofessionalVO,TeacherVO teacherVO){
//		   /** 系统自动生成时间**/
//		   Date createTime = new Date(System.currentTimeMillis());
//		   organizationalprofessionalVO.setType("cla");
//		   organizationalprofessionalVO.setName(organizationalprofessionalVO.getcName());
//		   organizationalprofessionalVO.setpId(iClassInFoService.selectCourseNameByID(organizationalprofessionalVO.getbName()));
//		   organizationalprofessionalVO.setParentManageRole(0);
//		   organizationalprofessionalVO.setLevel(0);
//		   organizationalprofessionalVO.setOrganizateOrder(71);
//		   organizationalprofessionalVO.setIsValid("Y");
//		   organizationalprofessionalVO.setStartDate(organizationalprofessionalVO.getStartDate());
//		   organizationalprofessionalVO.setEndDate(organizationalprofessionalVO.getEndDate());
//		   organizationalprofessionalVO.setIsEnd("n");
//		   organizationalprofessionalVO.setCreateTime(createTime);
//		   organizationalprofessionalVO.setCreator("");
//		   organizationalprofessionalVO.setModifyTime(createTime);
//		   organizationalprofessionalVO.setVersion(0);
//		   teacherVO.setOpId((iClassInFoService.selectClaByName()));
//		   teacherVO.setType1("teacher");
//		   teacherVO.setCreateTime(createTime);
//		   teacherVO.setCreator("");
//		   teacherVO.setEmployeeCode1(iClassInFoService.selectAdiser(teacherVO.getName()));
//		   teacherVO.setOpId(iClassInFoService.selectClaByName());
//		   teacherVO.setType("adviser");
//		   teacherVO.setCreateTime(createTime);
//		   teacherVO.setCreator("");
//		   teacherVO.setEmployeeCode(iClassInFoService.selectAdiser(teacherVO.getNickName()));
//		   boolean i=iClassInFoService.insertClass(organizationalprofessionalVO,teacherVO);
//		   if(i==true){
//				 return "success"; 
//		   }else{
//				return "fail"; 
//		   }
//	      }
//	   
//
//	   /**
//		 * 删除班级<BR>
//		 * 方法名：delClass<BR>
//		 * 创建人：龙金 <BR>
//		 * 时间：2015年12月30日-下午2:57:13 <BR>
//	 * @param organizationalProfessionalVO 
//		 * @return int<BR>
//		 * @exception <BR>
//		 * @since  1.0.0
//		*/
//	   @RequestMapping(value ="/delClass{id}", method = RequestMethod.POST)
//	   @ResponseBody
//	   public String delClass(Integer id){
//		int i=iClassInFoService.delClass(id);
//		 if(i>0){
//			return "success";
//		}else{
//			return "fail";
//		}
//		}
//	   //结课
//	   @RequestMapping(value ="/updateIsValid{id}", method = RequestMethod.POST)
//	   @ResponseBody
//	   public String updateIsValid(Integer id){
//		   int i=iClassInFoService.updateIsValid(id);
//		   if(i>0){
//			   return "success";
//			 }else{
//			   return "fail";
//			 }
//		}
//	   
//}
