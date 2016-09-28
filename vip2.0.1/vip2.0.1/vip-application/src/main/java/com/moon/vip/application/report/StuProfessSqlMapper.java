package com.moon.vip.application.report;

import java.util.List;

import com.moon.vip.infra.vo.report.StuPrefessVO;
import com.moon.vip.infra.vo.search.StuProfessSearchParams;

/**
 * 专业统计
 * StuProfessSqlMapper<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月29日-下午6:24:19 <BR>
 * @version 2.0.0
 *
 */
public interface StuProfessSqlMapper {
	
	public List<StuPrefessVO> findStuProfessPool(StuProfessSearchParams searchParams);
	
	public int getCountStuProfessPool(StuProfessSearchParams searchParams);
}
