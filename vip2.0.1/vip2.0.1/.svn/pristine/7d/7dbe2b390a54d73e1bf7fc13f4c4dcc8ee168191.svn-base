package com.moon.vip.service.impl.search;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moon.vip.application.assignment.HomeworkSqlMapper;
import com.moon.vip.infra.vo.homework.ClassAndTeacherVO;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;
import com.moon.vip.service.search.SearchBase;

/**
 * 学生提交作业情况搜索类
 * StudentHomeworkRecordSearcher<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月23日-下午7:55:26 <BR>
 * @version 2.0.0
 *
 */
@Component("HmworkRecordSearch")
public class HmworkRecordSearcher extends SearchBase<SearchParamsWithDept,ClassAndTeacherVO>{
	
	private static Logger logger = Logger.getLogger(HmworkRecordSearcher.class);
	@Autowired
	private HomeworkSqlMapper homeworkSqlMpper;
	
	@Override
	public List<ClassAndTeacherVO> excuteSearch(SearchParamsWithDept searchParams) {
		logger.info(String.format("学生作业搜索,部门：[%d],关键字：[%s]", searchParams.getOrgProCalId(),searchParams.getSearchKey()));
		return homeworkSqlMpper.findClassInfoByOrgProCalIdAndKeyPage(searchParams);
	}

	@Override
	public int excuteGetSearchResultCount(SearchParamsWithDept searchParams) {
		return homeworkSqlMpper.getCountClassInfoByOrgProCalIdAndKey(searchParams);
	}

}
