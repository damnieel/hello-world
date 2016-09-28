package com.moon.vip.application.student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.student.StudentVO;

/**
 * 查询学员信息
 * StudentRepeatSqlMapper<BR>
 * 创建人:娴贵 <BR>
 * 时间：2016年1月23日-下午1:47:08 <BR>
 * @version 1.0.0
 * 
 */
public interface StudentRepeatSqlMapper {

	/**
	 * 查询所有的学员信息<BR>
	 * 方法名：AllStudentArchives<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月23日-下午1:47:46 <BR>
	 * @param studentVO
	 * @return List<StudentVO><BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public List<StudentVO> allStudentArchives(StudentVO studentVO);
	
	/**
	 * 查询学员信息所有记录的总数<BR>
	 * 方法名：allStudentArchivesCount<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月23日-下午2:13:17 <BR>
	 * @param studentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int allStudentArchivesCount(StudentVO studentVO);
	
	/**
	 * 删除重复的学员信息<BR>
	 * 方法名：deleteStudentArchives<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月23日-下午1:48:13 <BR>
	 * @param id
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int deleteStudentArchives(@Param("id")Integer id);
	
	/**
	 * 查询重复的记录是否有关联的专业<BR>
	 * 方法名：StuRelevanceProfessional<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月23日-下午1:49:48 <BR>
	 * @param id
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int stuRelevanceProfessional(@Param("id")Integer id);
	
	/**
	 * 查询学员是否有多个<BR>
	 * 方法名：stuProfessionalCount<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月23日-下午6:44:15 <BR>
	 * @param studentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int stuProfessionalCount(StudentVO studentVO);
}
