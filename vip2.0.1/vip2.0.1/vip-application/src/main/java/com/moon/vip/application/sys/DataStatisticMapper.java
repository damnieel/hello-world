package com.moon.vip.application.sys;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.questionnaire.QstStatisticVO;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
import com.moon.vip.infra.vo.sys.ComponentVO;
import com.moon.vip.infra.vo.sys.LearningAimVO;


public interface DataStatisticMapper {
	/**
	 * 学习目的统计
	 */
	LearningAimVO selectLearnAimStatistic(@Param("param") StatisticSearchParams param);
	
	/**
	 * 学生成员统计
	 */
	
	ComponentVO selectComponentStatistic(@Param("param") StatisticSearchParams param);
	
	/**
	 * 问卷调查统计
	 */
	List<QstStatisticVO> selectQuestionStatistic(@Param("param") StatisticSearchParams param);
}