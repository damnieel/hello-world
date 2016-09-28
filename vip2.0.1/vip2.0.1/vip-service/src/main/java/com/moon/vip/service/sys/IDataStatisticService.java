package com.moon.vip.service.sys;

import java.util.List;

import com.moon.vip.infra.vo.questionnaire.QstStatisticVO;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
import com.moon.vip.infra.vo.sys.IVStatisticVO;

public interface IDataStatisticService {
	public IVStatisticVO getInterviewData(StatisticSearchParams param);
	
	public List<QstStatisticVO> getQuestionnaireData(StatisticSearchParams param);
	
} 
