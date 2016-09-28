package com.moon.vip.controller.sys;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.util.DateUtil;
import com.moon.vip.infra.vo.questionnaire.QstStatisticVO;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
import com.moon.vip.service.sys.IDataStatisticService;


@Controller
@RequestMapping("/dataStatistic")
public class DataStatisticController extends BaseController{
	
	@Autowired
	private IDataStatisticService iDataStatisticService;
	
	@RequestMapping("/queStatisticShowPage")
	@ResponseBody
	private ModelAndView queStatisticShowPage(StatisticSearchParams param){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/page/questionnaire/questionnaireStatistics");
		return mv;
	}
	
	@RequestMapping("/queStatisticData")
	@ResponseBody
	private List<QstStatisticVO> queStatisticData(StatisticSearchParams param){
		List<QstStatisticVO> list= new ArrayList<QstStatisticVO>();
		int type = param.getTimeRangeType();
		Date today = new Date();
		HashSet<Integer> opClaIds = achieveAuth();
		switch(type){
		case 1:param.setStartDate(DateUtil.getWeekStartTime(DateUtil.getLastWeek(today))); param.setEndDate(DateUtil.getWeekEndTime(DateUtil.getLastWeek(today)));
		break;
		case 2:param.setStartDate(DateUtil.getWeekStartTime(today)); param.setEndDate(today);
		break;
		case 3:param.setStartDate(DateUtil.getMonthStartTime(DateUtil.getLastMonth(today))); param.setEndDate(DateUtil.getMonthEndTime(DateUtil.getLastMonth(today)));
		break;
		case 4:param.setStartDate(DateUtil.getMonthStartTime(today)); param.setEndDate(today);
		break;
		case 5:
		break;
		default:param.setStartDate(DateUtil.getWeekStartTime(today)); param.setEndDate(today);
		}
		param.setOpClaIds(opClaIds);
		list=iDataStatisticService.getQuestionnaireData(param);
		return list;
	}
}
