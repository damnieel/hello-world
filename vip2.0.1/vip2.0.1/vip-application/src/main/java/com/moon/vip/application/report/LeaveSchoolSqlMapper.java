package com.moon.vip.application.report;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.report.ReportVO;

/**
 * 退学率相关数据持久化层操作
 * LeaveSchoolSqlMapper<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月29日-下午1:45:36 <BR>
 * @version 2.0.0
 *
 */
public interface LeaveSchoolSqlMapper {
	/**
	 * 根据机构ID，获取该机构ID下属直接子机构的退学率统计<BR>
	 * 方法名：getPercenageOfDeptOnTimesRange<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月29日-下午1:46:28 <BR>
	 * @param startDate
	 * @param endDate
	 * @param organizationId
	 * @return List<ReportVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<ReportVO> getPercenageOfDeptOnTimesRange(
			@Param("startDate")Date startDate, 
			@Param("endDate")Date endDate, 
			@Param("orgId")Integer organizationId,
			@Param("opClaIds")HashSet<Integer> opClaIds);

}
