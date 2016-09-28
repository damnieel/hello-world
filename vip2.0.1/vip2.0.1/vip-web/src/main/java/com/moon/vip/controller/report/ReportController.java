package com.moon.vip.controller.report;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.util.DateUtil;
import com.moon.vip.infra.vo.report.ReportVO;
import com.moon.vip.infra.vo.report.StuPrefessVO;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
import com.moon.vip.infra.vo.search.StuProfessSearchParams;
import com.moon.vip.service.report.IReportService;
import com.moon.vip.service.search.SearchBase;

@Controller("reportController")
@RequestMapping("/statistic")
public class ReportController extends BaseController {

	private static Logger logger = Logger.getLogger(ReportController.class);
	@Autowired
	@Qualifier("stuProfessSearch")
	private SearchBase<StuProfessSearchParams, StuPrefessVO> stuProfessSeacher;
	@Autowired
	@Qualifier("hmworkRptService")
	private IReportService<ReportVO> hmworkRptService;
	@Autowired
	@Qualifier("leaveSchoolRptService")
	private IReportService<ReportVO> leaveSchlRptService;
	
	/**
	 * 跳转至学生专业统计<BR>
	 * 方法名：showStuProfession<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月8日-下午8:06:12 <BR>
	 * @param params
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/showStuProfess")
	public ModelAndView showStuProfession(StatisticSearchParams params){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/page/report/stuProfess/stuProfess");
		return mav;
	}
	
	/**
	 * 获取学生专业统计查询的记录数<BR>
	 * 方法名：getCountStuProcess<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月8日-下午7:41:42 <BR>
	 * @param searchParams
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/getCountStuProfess")
	@ResponseBody
	public int getCountStuProcess(StuProfessSearchParams searchParams){
		int count = 0;
		try{
			if(searchParams == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			searchParams.setOpClaIds(achieveAuth());
			count = stuProfessSeacher.getSearchResultCount(searchParams);
		} catch(BusinessException e){
			logger.warn(e.getExceptionMsg());
		}
		return count;
	}
	
	/**
	 * 学生专业统计<BR>
	 * 方法名：studentProfessReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午5:28:19 <BR>
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/stuProfessPage")
	public ModelAndView studentProfessPage(StuProfessSearchParams searchParams){
		ModelAndView mav = new ModelAndView();
		try{
			if(searchParams == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			searchParams.setOpClaIds(achieveAuth());
			List<StuPrefessVO>  stuPrefessVOList = stuProfessSeacher.search(searchParams);
			mav.addObject("stuProfessVOs", stuPrefessVOList);
			mav.addObject("param", searchParams);
		} catch(BusinessException e){
			logger.warn(e.getExceptionMsg());
			mav.addObject("error",e.getCode());
		}
		mav.setViewName("/page/report/stuProfess/stuProfessTemplate");
		return mav;
	}
	
	@RequestMapping("/stuProfessRpt")
	public ModelAndView studentProfessRepot(StuProfessSearchParams searchParams){
		ModelAndView mav = new ModelAndView();
		mav.addObject("param", searchParams);
		mav.setViewName("/page/report/stuProfess/stuProfess");
		return mav;
	}
	
	@RequestMapping("/showHomeworkRpt")
	public ModelAndView showHomeworkReport(StatisticSearchParams params){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/page/report/stuHmwork/stuHmworkStatistic");
		return mav;
	}
	
	/**
	 * 作业统计<BR>
	 * 方法名：homeworkReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午5:28:33 <BR>
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/homeworkRpt")
	@ResponseBody
	public List<ReportVO> homeworkReport(StatisticSearchParams params){
		List<ReportVO> reportVOList = null;
		try{
			if(params == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			int type = params.getTimeRangeType();
			Date today = new Date();
			HashSet<Integer> opClaIds = achieveAuth();
			switch(type){
				case 0: reportVOList = hmworkRptService.getWeeklyReport(DateUtil.getLastWeek(today), params.getOrgProCalId() ,opClaIds);
				break;
				case 1: reportVOList = hmworkRptService.getTimesRangeReport(DateUtil.getWeekStartTime(today), today, params.getOrgProCalId(), opClaIds);
				break;
				case 2: reportVOList = hmworkRptService.getMonthlyReport(DateUtil.getLastMonth(today), params.getOrgProCalId(), opClaIds);
				break;
				case 3: reportVOList = hmworkRptService.getTimesRangeReport(DateUtil.getMonthStartTime(today), today, params.getOrgProCalId(), opClaIds);
				break;
				case 4: reportVOList = hmworkRptService.getTimesRangeReport(params.getStartDate(), params.getEndDate(), params.getOrgProCalId(), opClaIds);
				break;
				default: reportVOList = hmworkRptService.getTimesRangeReport(DateUtil.getWeekStartTime(today), today, params.getOrgProCalId(), opClaIds);
			}
			
		} catch(BusinessException e){
			logger.warn(e.getExceptionMsg());
		}
		
		return reportVOList;
	}
	
	@RequestMapping("/showLeaveSchoolReport")
	public ModelAndView showLeaveSchoolReport(StatisticSearchParams params){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/page/report/leaveSchl/leaveSchlStatistic");
		return mav;
	}
	
	/**
	 * 退学统计<BR>
	 * 方法名：leaveSchoolReport<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月30日-下午5:28:47 <BR>
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	@RequestMapping("/leaveSchlRpt")
	@ResponseBody
	public List<ReportVO> leaveSchoolReport(StatisticSearchParams params){
		List<ReportVO> reportVOList = null;
		try{
			if(params == null){
				throw new BusinessException(EnumCodeException.E0001);
			}
			int type = params.getTimeRangeType();
			Date today = new Date();
			HashSet<Integer> opClaIds = achieveAuth();
			switch(type){
				case 0: reportVOList = leaveSchlRptService.getWeeklyReport(DateUtil.getLastWeek(today), params.getOrgProCalId() ,opClaIds);
				break;
				case 1: reportVOList = leaveSchlRptService.getTimesRangeReport(DateUtil.getWeekStartTime(today), today, params.getOrgProCalId() ,opClaIds);
				break;
				case 2: reportVOList = leaveSchlRptService.getMonthlyReport(DateUtil.getLastMonth(today), params.getOrgProCalId() ,opClaIds);
				break;
				case 3: reportVOList = leaveSchlRptService.getTimesRangeReport(DateUtil.getMonthStartTime(today), today, params.getOrgProCalId() ,opClaIds);
				break;
				case 4: reportVOList = leaveSchlRptService.getTimesRangeReport(params.getStartDate(), params.getEndDate(), params.getOrgProCalId() ,opClaIds);
				break;
				default: reportVOList = leaveSchlRptService.getTimesRangeReport(DateUtil.getWeekStartTime(today), today, params.getOrgProCalId() ,opClaIds);
			}
		} catch(BusinessException e){
			logger.warn(e.getExceptionMsg());
		}
		return reportVOList;
	}
}
