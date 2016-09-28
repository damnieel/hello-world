package com.moon.vip.service.attend;

import java.util.List;

import com.moon.vip.infra.vo.attendance.StatisticAttenDataVO;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
/**
 * 
* @ClassName: IAttenStatisticService 
* @Description: TODO(考勤统计service) 
* @author  陈海  - （怡宝 ）
* @date 2016年1月6日 下午3:15:44 
*
 */
public interface IAttenStatisticService {
  /**
    * 获取考勤统计数据<br/>
    * @Author：  陈海  - （怡宝 ）<br/>
    * @Title: getStatisticData <br/>
    * @return List<StatisticAttenDataVO>    返回类型 <br/>
    * @date 2016年1月6日 下午3:16:03 <br/>
    * @throws <br/>
    *
   */
	List<StatisticAttenDataVO> getStatisticData(StatisticSearchParams params);

}
