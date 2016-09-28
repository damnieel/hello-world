package com.moon.vip.application.assignment;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.homework.ClassAndTeacherVO;
import com.moon.vip.infra.vo.homework.LackHmworkStudentVO;
import com.moon.vip.infra.vo.homework.StudentHmworkVO;
import com.moon.vip.infra.vo.search.LackHmworkSearchParams;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;
import com.moon.vip.model.assignment.SchoolAssignmentClass;
import com.moon.vip.model.assignment.SchoolAssignmentDetail;

public interface HomeworkSqlMapper {
    /**
     * 获取学员作业中查询学生班级信息总数<BR>
     * 方法名：getCountClassInfoByOrgProCalIdAndKey<BR>
     * 创建人：lqc <BR>
     * 时间：2015年12月28日-下午5:19:41 <BR>
     * @param searchParams
     * @return int<BR>
     * @exception <BR>
     * @since  2.0.0
     */
	public int getCountClassInfoByOrgProCalIdAndKey(SearchParamsWithDept searchParams);
	/**
	 * 获取学员作业中查询学生班级信息的分页数据<BR>
	 * 方法名：findClassInfoByOrgProCalIdAndKeyPage<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:21:02 <BR>
	 * @param searchParams
	 * @return List<ClassVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<ClassAndTeacherVO> findClassInfoByOrgProCalIdAndKeyPage(SearchParamsWithDept searchParams);
	/**
	 * 根据班级ID获取该班级的提交作业记录总数<BR>
	 * 方法名：getCountAllHmworkRecordByClassId<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:21:28 <BR>
	 * @param searchParams
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int getCountAllHmworkRecordByClassId(SearchParamsWithDept searchParams);
	/** 
	 * 根据班级ID获取该班级的提交作业记录的分页显示，按照班级ID降序<BR>
	 * 方法名：findAllHmworkRecordByClassIdPage<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:22:07 <BR>
	 * @param searchParams
	 * @return List<SchoolAssignmentClass><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<SchoolAssignmentClass> findAllHmworkRecordByClassIdPage(SearchParamsWithDept searchParams);
	/**
	 * 保存作业提交日统计数据<BR>
	 * 方法名：insertSAClassSelective<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:25:13 <BR>
	 * @param saClass
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int insertSAClassSelective(SchoolAssignmentClass saClass);
	/**
	 * 根据主键更新作业提交登记数据<BR>
	 * 方法名：updateSAClassByPrimaryKeySelective<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:25:49 <BR>
	 * @param saClass
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int updateSAClassByPrimaryKeySelective(SchoolAssignmentClass saClass);
	/**
	 * 保存作业提交情况明细数据（每个学生是否提交数据）<BR>
	 * 方法名：insertSADetailSelectiveBatch<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:26:12 <BR>
	 * @param schoolAssignmentDetail
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int insertSADetailSelectiveBatch(List<SchoolAssignmentDetail> schoolAssignmentDetail);
	/**
	 * 根据班级ID，作业提交日期删除作业提交数据<BR>
	 * 方法名：deleteHmworkRecordByClassIdAndCheckDate<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:27:12 <BR>
	 * @param classId
	 * @param checkDate
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int deleteHmworkRecordByClassIdAndCheckDate(@Param("classId")Integer classId, @Param("checkDate")Date checkDate);
	/**
	 * 根据ID删除作业提交日统计数据<BR>
	 * 方法名：deleteHmworkRecordById<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:28:03 <BR>
	 * @param id
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int deleteHmworkRecordById(@Param("id")Integer id);
	/**
	 * 根据作业提交日统计数据的ID删除明细数据<BR>
	 * 方法名：deleteHmworkDetailBySacId<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:28:31 <BR>
	 * @param sacId
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int deleteHmworkDetailBySacId(@Param("sacId")Integer sacId);
	/**
	 * 根据条件获取缺交作业的学生总数，用于分页<BR>
	 * 方法名：getCountSearchLackHmworkStudent<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:28:59 <BR>
	 * @param searchParams
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int getCountSearchLackHmworkStudent(LackHmworkSearchParams searchParams);
	/**
	 * 根据条件获取缺交作业学生的分页数据<BR>
	 * 方法名：searchLackHmworkStudent<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:29:46 <BR>
	 * @param searchParams
	 * @return List<LackHmworkStudentVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<LackHmworkStudentVO> searchLackHmworkStudentPage(LackHmworkSearchParams searchParams);
	/**
	 * 根据作业提交情况日统计数据ID，获取明细数据总数BR>
	 * 方法名：getCountSADetailBySacId<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:34:37 <BR>
	 * @param sacId
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int getCountSADetailBySacId(@Param("sacId")Integer sacId);
	/**
	 * 根据作业提交情况日统计数据ID，获取分页明细数据数据<BR>
	 * 方法名：findSADetailBySacIds<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月28日-下午5:32:43 <BR>
	 * @param sacIds
	 * @return List<SchoolAssignmentDetail><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<StudentHmworkVO>findSADetailBySacIds(List<Integer> sacIds);
	
	/**
	 * 获取班级学生列表<BR>
	 * 方法名：findStudentsByClassId<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月5日-下午7:51:37 <BR>
	 * @param classId
	 * @return List<StudentHmworkVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<StudentHmworkVO>findStudentsByClassId(@Param("classId")Integer classId);
	
}
