package com.moon.vip.controller.attend;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.exception.AttendanceException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.attendance.StatisticAttenDataVO;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
import com.moon.vip.service.attend.IAttenStatisticService;

/**
 * 
* @ClassName: AttendStatisticController 
* @Description: TODO(考勤统计) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月29日 下午5:21:42 
*
 */
@Controller
@RequestMapping("/admin/attenstatistic")
public class AttendStatisticController extends BaseController  {
	@Autowired
	private IAttenStatisticService attenStatisticService;
	private static Logger logger = Logger.getLogger(AttendStatisticController.class);
	
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: getStatisticPage 
	* @Description: TODO(统计界面) 
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @date 2015年12月29日 下午5:26:58 
	* @throws
	 */
	@RequestMapping("getPage")
	public ModelAndView getStatisticPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/attendance/attendstatistics");
		return mv;
	}
	
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: getStatisticData 
	* @Description: TODO(获取统计数据) 
	* @param @param params
	* @param @return    设定文件 
	* @return List<T>    返回类型 
	* @date 2015年12月30日 下午12:32:57 
	* @throws
	 */
	
	@RequestMapping("getStatistic")
	@ResponseBody
	public List<StatisticAttenDataVO> getStatisticData(StatisticSearchParams params){
		 List<StatisticAttenDataVO> list = new ArrayList<StatisticAttenDataVO>();
		try{
		  params.setOpClaIds(achieveAuth());
		  list = attenStatisticService.getStatisticData(params);
		}catch(AttendanceException e){
			logger.error(e.getCode()+":"+e.getExceptionMsg());
		}catch(BusinessException e ){
			logger.error(e.getCode()+":"+e.getExceptionMsg());
		}catch(Exception e){
			logger.error("未知错误", e);
		}
		return list;
	}
	
	
}
