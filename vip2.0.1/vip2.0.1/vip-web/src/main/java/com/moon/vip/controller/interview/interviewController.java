package com.moon.vip.controller.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.util.DateUtil;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.Message;
import com.moon.vip.infra.vo.interviews.InterviewsVO;
import com.moon.vip.infra.vo.interviews.OPManagerVO;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
import com.moon.vip.infra.vo.sys.ComponentVO;
import com.moon.vip.infra.vo.sys.IVStatisticVO;
import com.moon.vip.infra.vo.sys.LearningAimVO;
import com.moon.vip.infra.vo.sys.SearchVO;
import com.moon.vip.model.interviews.Interviews;
import com.moon.vip.service.interviews.IInterviewsService;
import com.moon.vip.service.sys.IDataStatisticService;

/**
 * 
* @ClassName: interviewController 
* @Description: TODO(访谈记录)  
* @Param:   
* @author qingyu <a href="mailto:2190234029@qq.com">dengrihui</a>
* @date 2016年1月7日 下午8:21:51 
*
 */
@Controller
@RequestMapping("/interview")
public class interviewController extends BaseController{
	
	@Autowired
	private IInterviewsService iInterviewsService;
	@Autowired
	private IDataStatisticService iDataStatisticService;
	/**
	 * 显示访谈记录页面
	 */
	@RequestMapping(value ="/showPage")
	private ModelAndView showPage(SearchVO searchVO){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/interviews/interview");
		return mv;
	}
	/**
	 * 查询访谈记录总数量
	 */
	@RequestMapping("/queryTotalRecord")
	@ResponseBody
	private int queryTotalRecord(SearchVO searchVO){
		searchVO.setOpClaIds(achieveAuth());
		int result=iInterviewsService.findItemsCount(searchVO);
		return result;
	}
	/**
	 * 查询访谈记录数据模板
	 */
	@RequestMapping("/queryInterviewTemplate")
	@ResponseBody
	private ModelAndView queryInterviewTemplate(SearchVO searchVO){
		searchVO.setOpClaIds(achieveAuth());
		searchVO.setOpClaIds(achieveAuth());
		ModelAndView mv = new ModelAndView();
		List<InterviewsVO> list=iInterviewsService.getAllInterviewsInfo(searchVO);
		mv.addObject("InterviewsItems", list);
		mv.setViewName("/page/interviews/interviewTemple");
		return mv;
	}
	/**
	 * 查看访谈记录
	 */
	@RequestMapping("/interviewInfoCheck/{id}")
	@ResponseBody
	private ModelAndView interviewInfoCheck(@PathVariable Integer id){
		ModelAndView mv = new ModelAndView();
		InterviewsVO interviews =iInterviewsService.findInterviewsInfo(id);
		mv.addObject("interviews", interviews);
		mv.setViewName("/page/interviews/interviewCheck");
		return mv;
	}
	/**
	 * 添加访谈记录页面
	 */
	@RequestMapping("/interviewInfoAdd/addPage")
	@ResponseBody
	private ModelAndView interviewInfoAdd(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/interviews/interviewAdd");
		return mv;
	}
	/**
	 * 添加访谈记录处理
	 */
	@RequestMapping("/interviewInfoAddDeal")
	@ResponseBody
	private Message interviewInfoAddDeal(Interviews record){
		Message msg=new Message();
		if(null==record.getOpProId()||null==record.getStudentId()){
			msg.setResult("fail");
			msg.setMsg("请检查QQ是否能找到学生以及专业是否选择");
			return msg;
		}
		EmployeeLoginVO employeeInfo = super.getUserInfo();
		record.setCreator(employeeInfo.getEmployeeCode());
		record.setCreateTime(new Date());
		iInterviewsService.insertInterviewsInfo(record);
		msg.setResult("success");
		msg.setMsg("添加记录成功");
		return msg;
	}
	/**
	 * update访谈记录页面
	 */
	@RequestMapping("/interviewInfoUpdatePage/{id}")
	@ResponseBody
	private ModelAndView interviewInfoUpdate(@PathVariable Integer id){
		ModelAndView mv = new ModelAndView();
		InterviewsVO interview =iInterviewsService.findInterviewsInfo(id);
		mv.addObject("interview", interview);
		mv.setViewName("/page/interviews/interviewUpdate");
		return mv;
	}
	/**
	 * update访谈记录处理
	 */
	@RequestMapping("/interviewInfoUpdateDeal")
	@ResponseBody
	private int interviewInfoUpdateDeal(@RequestBody InterviewsVO interviews){
		return iInterviewsService.updateInterviewsInfo(interviews);
	}
	/**
	 * 得到添加访谈记录时所需要的基本信息
	 */
	@RequestMapping("/getAddBaseInfo")
	@ResponseBody
	private List<InterviewsVO> getAddBaseInfo(String qq){
		EmployeeLoginVO employeeInfo = super.getUserInfo();
		List<InterviewsVO> list=new ArrayList<InterviewsVO>();
		list=iInterviewsService.getAllBaseInfo(qq);
		if(null==list || list.size()==0){
			return list;
		}
		list.get(0).setInterviewerName(employeeInfo.getNickName());
		list.get(0).setInterviewerCode(employeeInfo.getEmployeeCode());
	    return list;
	}
	/**
	 * 得到添加访谈记录时所需要的讲师信息
	 */
	@RequestMapping("/teacherCode/{professionId}")
	@ResponseBody
	private List<OPManagerVO> teacherCode(@PathVariable Integer professionId){
		 List<OPManagerVO> list=iInterviewsService.getAllTeacherCode(professionId);
		 if(null==list&&list.isEmpty()){
			 return null;
		 }
		 return list;
	}
	/**
	 * 得到添加访谈记录时所需要的专业Code
	 */
	@RequestMapping("/studentProfessionCode")
	@ResponseBody
	private String studentProfessionCode(Integer professionId,String qq){
		String code=iInterviewsService.findProfessionCode(qq, professionId);
		 return code;
	}
	
	/**
	 * interviewDelete访谈记录处理
	 */
	@RequestMapping("/interviewDelete")
	@ResponseBody
	private int interviewDelete(String recordIds){
		String[] strArray=recordIds.split(",");
		List<String> strList =  Arrays.asList(strArray);
		List<Integer> idList=new ArrayList<Integer>();
		for(String str:strList){
			idList.add(Integer.parseInt(str));
		}
		if(idList.size()<1){
			return 0;
		}
		return iInterviewsService.deleteInterviewsById(idList);
	}
	
	@RequestMapping("/ivStatisticsShowPage")
	@ResponseBody
	private ModelAndView ivStatisticsShowPage(StatisticSearchParams param){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/page/interviews/interviewStatistics");
		return mv;
	}
	
	@RequestMapping("/ivStatisticsData")
	@ResponseBody
	private IVStatisticVO ivStatisticsData(StatisticSearchParams param){
		IVStatisticVO ivs=	new IVStatisticVO();
		
		param.setOpClaIds(achieveAuth());
		
		ivs=iDataStatisticService.getInterviewData(param);
		LearningAimVO lav=ivs.getLearningAimVO();
		ComponentVO c=ivs.getComponentVO();
		if(null==lav||null==c){
			return null;
		}
		if(param.getOrgProCalId()!=1){
			lav.setOrgName(lav.getClsName());
		}
		return ivs;
	}
}
