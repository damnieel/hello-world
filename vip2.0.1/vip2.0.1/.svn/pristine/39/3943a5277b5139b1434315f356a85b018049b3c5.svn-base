package com.moon.vip.service.impl.sys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.sys.DataStatisticMapper;
import com.moon.vip.infra.vo.questionnaire.QstStatisticVO;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
import com.moon.vip.infra.vo.sys.ComponentVO;
import com.moon.vip.infra.vo.sys.IVStatisticVO;
import com.moon.vip.infra.vo.sys.LearningAimVO;
import com.moon.vip.model.questionnaire.Questionnaire;
import com.moon.vip.service.sys.IDataStatisticService;

@Service("dataStatisticService")
public class DataStatisticServiceImpl implements IDataStatisticService {
	@Autowired
	DataStatisticMapper dataStatisticMapper;

	public IVStatisticVO getInterviewData(StatisticSearchParams param) {
		IVStatisticVO ivs = new IVStatisticVO();
		ComponentVO c = dataStatisticMapper.selectComponentStatistic(param);
		LearningAimVO l = dataStatisticMapper.selectLearnAimStatistic(param);
		
		ivs.setComponentVO(c);
		ivs.setLearningAimVO(l);
		return ivs;
	}

	public List<QstStatisticVO> getQuestionnaireData(StatisticSearchParams param){
		List<QstStatisticVO> list=new ArrayList<QstStatisticVO>();
		list=dataStatisticMapper.selectQuestionStatistic(param);
		return list;
	}
}
