package com.moon.vip.controller.educational;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.homework.ClassAndTeacherVO;
import com.moon.vip.infra.vo.homework.ClassHmworkVO;
import com.moon.vip.infra.vo.homework.LackHmworkStudentVO;
import com.moon.vip.infra.vo.homework.StudentHmworkVO;
import com.moon.vip.infra.vo.search.LackHmworkSearchParams;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;
import com.moon.vip.service.assignment.IClassService;
import com.moon.vip.service.assignment.IHmworkService;

/**
 * 学生作业控制器
 * StuHmworkController<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月30日-下午5:17:25 <BR>
 * @version 2.0.0
 *
 */
@Controller("hmworkController")
@RequestMapping("/educational/homework")
public class StuHmworkController extends BaseController {
    
	private static Logger logger = Logger.getLogger(StuHmworkController.class);
	@Autowired
	@Qualifier("hmworkService")
	private IHmworkService  hmworkService;
	@Autowired
	@Qualifier("classService")
	private IClassService classService;
	
	/**
	 * 展示待录入提交作业情况的班级列表<BR>
	 * 方法名：listClasses<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午5:18:01 <BR>
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/getCountClasses")
	@ResponseBody
	public int getCountClasses(SearchParamsWithDept searchParams){
		int count = 0;
		try{
			if(searchParams == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			searchParams.setOpClaIds(achieveAuth());
			count = hmworkService.getCountAllClassByDeptAndKey(searchParams);
		} catch(BusinessException e){
			logger.warn(e.getExceptionMsg());
		} catch (Exception e){
			logger.warn(e.getStackTrace());
		}
		return count;
	}
	
	
	@RequestMapping("/showClasses")
	public ModelAndView showClasses(SearchParamsWithDept searchParams){
		ModelAndView mav = new ModelAndView();
		mav.addObject("searchParam", searchParams);
		mav.setViewName("/page/educational/classes");
		return mav;
	}
	
	@RequestMapping("/listClasses")
	public ModelAndView listClassesPage(SearchParamsWithDept searchParams){
		ModelAndView mav = new ModelAndView();
		try{
			if(searchParams == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			searchParams.setOpClaIds(achieveAuth());
			List<ClassAndTeacherVO> classVOList = hmworkService.searchAllClassByDeptAndKeyPage(searchParams);
			mav.addObject("classVOs", classVOList);
		} catch (BusinessException e){
			logger.warn(e.getExceptionMsg());
		} catch (Exception e){
			logger.warn(e.getStackTrace());
		}
		mav.setViewName("/page/educational/classesTemplate");
		return mav;
	}
	/**
	 * 获取一个班级的作业记录数<BR>
	 * 方法名：getCountHomework<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月4日-下午2:21:51 <BR>
	 * @param searchParams
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/getCountHomework")
	@ResponseBody
	public int getCountHomework(SearchParamsWithDept searchParams){
		int count = 0;
		try{
			if(searchParams == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			count = hmworkService.getCountAllHmworkRecordByClassId(searchParams);
		} catch(BusinessException e){
			logger.warn(e.getExceptionMsg());
		} catch (Exception e){
			logger.warn(e.getStackTrace());
		}
		return count;
	}
	/**
	 * 进入班级学生作业提交情况页面<BR>
	 * 方法名：showHomeworkRecord<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月4日-下午2:23:02 <BR>
	 * @param searchParams
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/showHomework")
	public ModelAndView showHomeworkRecord(SearchParamsWithDept searchParams, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String opClaId = request.getParameter("opClaId");
		String opProId = request.getParameter("opProId");
		String opClaName = request.getParameter("opClaName");
		String operate = request.getParameter("operate");
		List<StudentHmworkVO> studentList = classService.getAllStudentsByClassId(Integer.parseInt(opClaId));
		mav.addObject("searchParam", JSON.toJSON(searchParams));
		mav.addObject("students", JSON.toJSON(studentList));
		mav.addObject("operate",operate);
		mav.addObject("opClaId",opClaId);
		mav.addObject("opProId",opProId);
		mav.addObject("opClaName",opClaName);
		mav.setViewName("/page/educational/homework");
		return mav;
	}
	
	/**
	 * 展示一个班级的历史提交作业的情况<BR>
	 * 方法名：listHomeworkRecord<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午5:18:21 <BR>
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/listHomework")
	public ModelAndView listHomeworkRecord(SearchParamsWithDept searchParams, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		try{
			if(searchParams == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			String operate = request.getParameter("operate");
			List<ClassHmworkVO> classHmworkVOList = hmworkService.seachAllHmworkRecordByClassIdPage(searchParams);
			List<Integer> sacIdList = new ArrayList<Integer>();
			for(ClassHmworkVO chwVO : classHmworkVOList){
				if(chwVO.getId()!=null){
					sacIdList.add(chwVO.getId());
				}
			}
			List<StudentHmworkVO> stuHmworkVOList = null;
			if(sacIdList != null && sacIdList.size() > 0){
				stuHmworkVOList = hmworkService.getAllStudentsHmworkBySacIds(sacIdList);
			}
			mav.addObject("operate",operate);
			mav.addObject("classHmworks", classHmworkVOList);
			mav.addObject("stuHmworkVOList",JSON.toJSON(stuHmworkVOList));
		} catch (BusinessException e){
			logger.warn(e.getExceptionMsg());
		} catch (Exception e){
			logger.warn(e.getStackTrace());
		}
		mav.setViewName("/page/educational/homeworkRecordTemplate");
		return mav;
	}
	
	/**
	 * 更新提交作业的记录<BR>
	 * 方法名：updateHomeworkRecord<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午5:20:57 <BR>
	 * @return String<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/updateHomeworkRecord")
	@ResponseBody
	public Message updateHomeworkRecord(ClassHmworkVO classHmworkVO, 
			@RequestParam(value = "stuIds[]", required=false) int[] stuIds,
			@RequestParam(value = "chkStatus[]", required=false) int[] chkStatus,
			HttpSession session){
		Message msg = new Message();
		try{
			if(classHmworkVO == null) {
				throw new BusinessException(EnumCodeException.E0001);
			}
			if (stuIds != null) {
				StudentHmworkVO studentHmworkVO;
				for(int i = 0; i < stuIds.length ; i ++) {
					studentHmworkVO = new StudentHmworkVO();
					studentHmworkVO.setStudentId(stuIds[i]);
					studentHmworkVO.setCheckStatus(chkStatus[i]);
					classHmworkVO.getStudentHomeworkList().add(studentHmworkVO);
				}
			}
			if(classHmworkVO.getId() == null) {
				classHmworkVO.setCreateTime(new Date());
			    classHmworkVO.setCreator(getUserCode());
				hmworkService.saveHmworkRecord(classHmworkVO);
			} else {
				classHmworkVO.setCreateTime(new Date());
			    classHmworkVO.setCreator(getUserCode());
				classHmworkVO.setModifyTime(new Date());
			    classHmworkVO.setModifyUser(getUserCode());
				hmworkService.updateHmworkRecord(classHmworkVO);
			}
		} catch (DuplicateKeyException e){
			logger.error(e.getMessage());
			msg.setMsg("作业登记的日期重复");
			msg.setResult(false);
			return msg;
		} catch (BusinessException e){
			logger.warn(e.getExceptionMsg());
			msg.setMsg(e.getExceptionMsg());
			msg.setResult(false);
			return msg;
		} catch (Exception e){
			logger.warn(e.getStackTrace());
			msg.setResult(false);
			msg.setMsg("系统内部错误！");
			return msg;
		}
		msg.setResult(true);
		return msg;
	}
	
	/**
	 * 删除提交作业的记录<BR>
	 * 方法名：removeHomeWorkRecord<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午5:21:13 <BR>
	 * @return String<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/removeHomeworkRecord")
	@ResponseBody
	public Message removeHomeWorkRecord(ClassHmworkVO classHmworkVO){
		Message msg = new Message();
		try{
			if(classHmworkVO == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			hmworkService.removeHmworkRecordById(classHmworkVO);
		} catch (BusinessException e){
			logger.warn(e.getExceptionMsg());
			msg.setMsg(e.getExceptionMsg());
			msg.setResult(false);
			return msg;
		} catch (Exception e){
			logger.warn(e.getStackTrace());
			msg.setResult(false);
			msg.setMsg("系统内部错误！");
			return msg;
		}
		msg.setResult(true);
		return msg;
	}
	
	/**
	 * 跳转到缺交作业页面<BR>
	 * 方法名：showlackwork<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月8日-下午2:04:53 <BR>
	 * @param searchParams
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/showlackwork")
	public ModelAndView showlackwork(SearchParamsWithDept searchParams){
		ModelAndView mav = new ModelAndView();
		mav.addObject("searchParam", JSON.toJSON(searchParams));
		mav.setViewName("/page/educational/lackHmwork");
		return mav;
	}
	/**
	 * 获取缺交作业的学生数<BR>
	 * 方法名：getCountLackwork<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月8日-下午2:15:00 <BR>
	 * @param searchParams
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/getCountLackwork")
	@ResponseBody
	public int getCountLackwork(LackHmworkSearchParams searchParams){
		int count = 0;
		try{
			if(searchParams == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			searchParams.setOpClaIds(achieveAuth());
			count = hmworkService.getCountSearchLackHmworkStudent(searchParams);
		} catch(BusinessException e){
			logger.warn(e.getExceptionMsg());
		} catch (Exception e){
			logger.warn(e.getStackTrace());
		}
		return count;
	}
	
	/**
	 * 展示缺交作业的学生<BR>
	 * 方法名：lackHmworkStudents<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午5:21:28 <BR>
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/lackHmworkStudents")
	public ModelAndView lackHmworkStudents(LackHmworkSearchParams searchParams){
		ModelAndView mav = new ModelAndView();
		try{
			if(searchParams == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			searchParams.setOpClaIds(achieveAuth());
			List<LackHmworkStudentVO> lackHmworkVOList = hmworkService.searchLackHmworkStudentPage(searchParams);
			mav.addObject("lackHmworkVOs", lackHmworkVOList);
		} catch (BusinessException e){
			logger.warn(e.getExceptionMsg());
		} catch (Exception e){
			logger.warn(e.getStackTrace());
		}
		mav.setViewName("/page/educational/lackHmworkTemplate");
		return mav;
	}
}
