package com.moon.vip.service.impl.search;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moon.vip.application.report.StuProfessSqlMapper;
import com.moon.vip.infra.vo.report.StuPrefessVO;
import com.moon.vip.infra.vo.search.StuProfessSearchParams;
import com.moon.vip.service.search.SearchBase;

/**
 * 学生专业统计搜索查询
 * StuProfessSearcher<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月29日-下午6:20:10 <BR>
 * @version 2.0.0
 *
 */
@Component("stuProfessSearch")
public class StuProfessSearcher extends SearchBase<StuProfessSearchParams, StuPrefessVO> {

	private static Logger logger = Logger.getLogger(StuProfessSearcher.class);
	@Autowired
	private StuProfessSqlMapper stuProfessSqlMapper;
	
	@Override
	public int excuteGetSearchResultCount(StuProfessSearchParams searchParams) {
		return stuProfessSqlMapper.getCountStuProfessPool(searchParams);
	}

	@Override
	public List<StuPrefessVO> excuteSearch(StuProfessSearchParams searchParams) {
		logger.info(String.format("学生专业查询，查询参数%s",searchParams.toString()));
		return stuProfessSqlMapper.findStuProfessPool(searchParams);
	}
}
