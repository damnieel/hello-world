package com.moon.vip.application.student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.student.RepeatStudentVO;

/**
 * 重复数据模块
 * RepeatStudentSqlMapper<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月31日-下午1:45:59 <BR>
 * @version 1.0.0
 * 
 */
public interface RepeatStudentSqlMapper {

	/**
	 * 查询所有重复数据<BR>
	 * 方法名：selectRepeatStudent<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月31日-下午1:49:00 <BR>
	 * @param repeatStudentVO
	 * @return List<RepeatStudentVO><BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public List<RepeatStudentVO> selectRepeatStudent(RepeatStudentVO repeatStudentVO);
	
	
	/**
	 * 查询专业编号重复记录的总数<BR>
	 * 方法名：selectRepeatStudentCount<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月10日-下午2:49:49 <BR>
	 * @param repeatStudentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int selectRepeatStudentCount(RepeatStudentVO repeatStudentVO);
	
	/**
	 * 修改专业编号<BR>
	 * 方法名：updateStuProCode<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月31日-下午1:49:25 <BR>
	 * @param repeatStudentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int updateStuProCode(RepeatStudentVO repeatStudentVO);
	
	
	/**
	 * 查找修改后的专业编号是否存在 <BR>
	 * 方法名：selectStuProCode<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月31日-下午1:49:49 <BR>
	 * @param professionCode
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int selectStuProCode(@Param("id")Integer id,@Param("professionCode")String professionCode );
}
