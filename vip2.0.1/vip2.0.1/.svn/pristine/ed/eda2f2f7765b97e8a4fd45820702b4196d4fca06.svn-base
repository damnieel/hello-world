package com.moon.vip.controller.attend;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.exception.AttendanceException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.attendance.AttendDetailVO;
import com.moon.vip.infra.vo.attendance.AttendSercherParams;
import com.moon.vip.infra.vo.attendance.DelAttenParamsVO;
import com.moon.vip.infra.vo.attendance.StuAttendanceVO;
import com.moon.vip.infra.vo.homework.ClassAndTeacherVO;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;
import com.moon.vip.service.attend.IStudentAttendService;
@Controller
@RequestMapping("/admin/attend")
public class AttendRecordController  extends BaseController{
	@Autowired
	private IStudentAttendService studentAttendService;
	private static Logger logger = Logger.getLogger(AttendRecordController.class);
	
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: getClassPage 
	* @Description: TODO(返回班级页面) 
	* @return ModelAndView    返回类型 
	* @date 2015年12月28日 下午3:17:52 
	* @throws
	 */
	@RequestMapping("getPage")
	public ModelAndView getClassPage(SearchParamsWithDept searchParams){
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchParam", searchParams);
		mv.setViewName("/page/attendance/classPage");
		return mv;
	}
	
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: getClassInfoByParams 
	* @Description: TODO(获取班级信息) 
	* @param @param searchParams
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @date 2015年12月28日 下午3:09:49 
	* @throws
	 */
	@RequestMapping("getclass")
	public ModelAndView getClassInfoByParams(SearchParamsWithDept searchParams){
		ModelAndView mv =new ModelAndView();
		try{
			searchParams.setOpClaIds(achieveAuth());
			List<ClassAndTeacherVO> list = studentAttendService.getClassInfoByParams(searchParams);
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
		mv.setViewName("/page/attendance/classTemp");
		return mv;
	}
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: getCountClassByParams 
	* @Description: TODO(获取班级总数) 
	* @param @param searchParams
	* @param @return    设定文件 
	* @return int    返回类型 
	* @date 2015年12月28日 下午3:10:02 
	* @throws
	 */
	@RequestMapping("getclassCount")
	@ResponseBody
	public int getCountClassByParams(SearchParamsWithDept searchParams){
		try{
		 searchParams.setOpClaIds(achieveAuth());
		 int result = studentAttendService.getCountClassByParams(searchParams);
		 return result;
		}catch(BusinessException e){
			logger.error(String.format("获取班级总数异常,异常信息[%s]",e.getCode()+":"+e.getExceptionMsg()));
			return 0;
		}catch(Exception e){
			logger.error("未知异常",e);
			return 0;
		}
    }
	
	
	
	/**
	  * 获取缺勤学生页面<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getUnAttendPage <br/>
	  * @return ModelAndView    返回类型 <br/>
	  * @date 2016年1月6日 下午8:11:40 <br/>
	  * @throws <br/>
	  *
	 */
	@RequestMapping("getUnAttenPage")
	public ModelAndView getUnAttendPage(SearchParamsWithDept searchParams){
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchParam", JSON.toJSON(searchParams));	
		mv.setViewName("/page/attendance/unAttendPage");
		return mv;
		
	} 
	
	
/**
 * 获取班级考勤情况<br/>
  * @Author：  陈海  - （怡宝 ）<br/>
  * @Title: getAttendPageByClassId <br/>
  * @return ModelAndView    返回类型 <br/>
  * @date 2016年1月11日 下午6:33:24 <br/>
  * @throws <br/>
  *
 */
	@RequestMapping("studensAttend/{classId}")
	public ModelAndView getAttendPageByClassId(@PathVariable("classId")Integer classId){
		ModelAndView mv = new ModelAndView();
		ClassAndTeacherVO classInfo = studentAttendService.getClassInfoById(classId);
		mv.addObject("classinfo", classInfo);
		mv.addObject("orgId", classId);
		mv.setViewName("/page/attendance/studentAttend");
		return mv;
		
	} 
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: gerStuAttendanceByParams 
	* @Description: TODO(根据班级，缺勤次数获取学生考勤情况) 
	* @return List<StuAttendanceVO>    返回类型 
	* @date 2015年12月28日 下午4:19:34 
	* @throws
	 */
	@RequestMapping("getStuAttenance")
	public ModelAndView getStuAttendanceByParams(AttendSercherParams params){
		ModelAndView mv =new ModelAndView();
		try{
		   params.setOpClaIds(achieveAuth());
		   List<StuAttendanceVO> list = studentAttendService.getStuAttendanceByParams(params);
		   mv.addObject("list", list);
		}catch(BusinessException e){
			logger.error(e.getCode()+":"+e.getExceptionMsg());
		}catch(Exception e){
			logger.error("未知异常",e);
		}
		mv.setViewName("/page/attendance/stuAttenTemp");
		return mv;
	}
	
	
	
	
	/**
	  * 获取有缺勤记录的学生<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getUnAttenStu <br/>
	  * @return ModelAndView    返回类型 <br/>
	  * @date 2016年1月6日 下午7:59:53 <br/>
	  * @throws <br/>
	  *
	 */
	@RequestMapping("getUnAttenStu")
	public ModelAndView getUnAttenStus(AttendSercherParams params){
		ModelAndView mv =new ModelAndView();
		try{
		  params.setOpClaIds(achieveAuth());
		  params.setIsUnAttend(1);
		  List<StuAttendanceVO> list = studentAttendService.getUnAttenStus(params);
		  mv.addObject("list", list);
		}catch(BusinessException e){
			logger.error(e.getCode()+":"+e.getExceptionMsg());
		}catch(Exception e){
			logger.error("未知异常",e);
		}
		mv.setViewName("/page/attendance/unAttendTemp");
		return mv;
	}
	
	
	
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: getCountStuAttendanceByParams 
	* @Description: TODO(获取班级考勤情况总数) 
	* @param @param params
	* @return int    返回类型 
	* @date 2015年12月29日 下午12:41:39 
	* @throws
	 */
	@RequestMapping("getCountStuAttenance")
	@ResponseBody
	public int getCountStuAttendanceByParams(AttendSercherParams params){
		int result = 0;
		try{
		   params.setOpClaIds(achieveAuth());
		   result = studentAttendService.getCountStuAttenByParams(params);
		}catch(BusinessException e){
				logger.error(e.getCode()+":"+e.getExceptionMsg());
		}catch(Exception e){
				logger.error("未知异常",e);
		}
		return result;
	}
	
	/**
	  *获取具有缺勤记录的学生总数<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getCountUnAttenStus <br/>
	  * @return int    返回类型 <br/>
	  * @date 2016年1月6日 下午8:02:26 <br/>
	  * @throws <br/>
	  *
	  */
	@RequestMapping("getCountUnAttenStus")
	@ResponseBody
	public int getCountUnAttenStus(AttendSercherParams params){
	    params.setOpClaIds(achieveAuth());
	    params.setIsUnAttend(1);
		int result = studentAttendService.getCountUnAttenStus(params);
		return result;
	}
	
	
	
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: delAttenRecord 
	* @Description: TODO(删除记录) 
	* @param @return    设定文件 
	* @date 2015年12月29日 下午1:24:21 
	* @throws
	 */
	@RequestMapping("delAttenRecord")
	@ResponseBody
	public String delAttenRecord(DelAttenParamsVO delParams){
		String empCode = getUserInfo().getEmployeeCode();
		try{
		  String result =  studentAttendService.deleteAttenRecord( delParams,empCode);
		  return result;
		}catch(AttendanceException e){
			logger.info(e.getCode()+":"+e.getExceptionMsg());
			return e.getExceptionMsg();
		}
	}
	/**
	  * 获取考勤记录月详情<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getStuAttenDetail <br/>
	  * @return List<AttendDetailVO>    返回类型 <br/>
	  * @date 2016年1月4日 下午2:38:56 <br/>
	  * @throws <br/>
	  *
	 */
	@RequestMapping("/getStuAttenDetail")
	@ResponseBody
	public List<AttendDetailVO>  getStuAttenDetail(DelAttenParamsVO detailParams){
		List<AttendDetailVO> list = studentAttendService.getStuAttenDetail(detailParams);
		return list;
	}

}
