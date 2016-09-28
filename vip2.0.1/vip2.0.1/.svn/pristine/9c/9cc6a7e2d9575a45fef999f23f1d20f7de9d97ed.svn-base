package com.moon.vip.service.impl.search;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moon.vip.application.assignment.HomeworkSqlMapper;
import com.moon.vip.infra.vo.homework.LackHmworkStudentVO;
import com.moon.vip.infra.vo.search.LackHmworkSearchParams;
import com.moon.vip.service.search.SearchBase;

/**
 * 
 * LackHmworkStudentSearch<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月26日-下午3:08:51 <BR>
 * @version 2.0.0
 *
 */
@Component("lackHmworkSearch")
public class LackHmworkStudentSearcher extends SearchBase<LackHmworkSearchParams, LackHmworkStudentVO> {

	private static Logger logger = Logger.getLogger(LackHmworkStudentSearcher.class);
	@Autowired
	private HomeworkSqlMapper hmworkMapper;
	
	@Override
	public int excuteGetSearchResultCount(LackHmworkSearchParams searchParams) {
		return hmworkMapper.getCountSearchLackHmworkStudent(searchParams);
	}

	@Override
	public List<LackHmworkStudentVO> excuteSearch(LackHmworkSearchParams searchParams) {
		logger.info(String.format("缺交作业学生查询，查询参数%s",searchParams.toString()));
		return hmworkMapper.searchLackHmworkStudentPage(searchParams);
	}

}
