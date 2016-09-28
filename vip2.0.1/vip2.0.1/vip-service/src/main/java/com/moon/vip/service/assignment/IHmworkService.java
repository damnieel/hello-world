package com.moon.vip.service.assignment;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.moon.vip.infra.vo.homework.ClassHmworkVO;
import com.moon.vip.infra.vo.homework.ClassAndTeacherVO;
import com.moon.vip.infra.vo.homework.LackHmworkStudentVO;
import com.moon.vip.infra.vo.homework.StudentHmworkVO;
import com.moon.vip.infra.vo.search.LackHmworkSearchParams;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;

/**
 * 操作学生提交作业的服务
 * HomeworkService<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月24日-下午8:05:56 <BR>
 * @version 2.0.0
 *
 */
public interface IHmworkService {
	
	/**
	 * 获取“根据选择部门，搜索关键字查询班级”分页查询的记录总数<BR>
	 * 方法名：getCountAllClassByDeptAndKey<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月25日-下午4:32:39 <BR>
	 * @param searchParams
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int getCountAllClassByDeptAndKey(SearchParamsWithDept searchParams);
	/**
	 * 根据选择部门，搜索关键字查询班级<BR>
	 * 方法名：searchAllClassByDeptAndKey<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月24日-下午8:06:23 <BR>
	 * @param searchParams
	 * @return List<ClassVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<ClassAndTeacherVO> searchAllClassByDeptAndKeyPage(SearchParamsWithDept searchParams);
	/**
	 * 根据班级ID查询该班级作业提交情况的记录总数<BR>
	 * 方法名：getCountAllHmworkRecordByClassId<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月25日-下午4:33:12 <BR>
	 * @param searchParams
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int getCountAllHmworkRecordByClassId(SearchParamsWithDept searchParams);
	/**
	 * 根据班级ID查询该班级作业提交情况，分页显示，按照作业提交时间降序<BR>
	 * 方法名：seachAllHmworkRecordByClassIdPage<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月25日-下午4:33:21 <BR>
	 * @param searchParams
	 * @return List<ClassHmworkVO><BR>
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<ClassHmworkVO> seachAllHmworkRecordByClassIdPage(SearchParamsWithDept searchParams);
	/**
	 * 保存提交作业记录<BR>
	 * 方法名：saveHmworkRecord<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月25日-下午7:00:29 <BR>
	 * @param classHmworkVO
	 * @return int<BR>
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int saveHmworkRecord(ClassHmworkVO classHmworkVO);
	/**
	 * 更新提交作业记录<BR>
	 * 方法名：updateHmworkRecord<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月25日-下午7:00:44 <BR>
	 * @param classHmworkVO
	 * @return int<BR>
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int updateHmworkRecord(ClassHmworkVO classHmworkVO);
	
	/**
	 * 删除作业提交记录<BR>
	 * 方法名：removeHmorkRecord<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月25日-下午7:01:00 <BR>
	 * @param classHmworkVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int removeHmworkRecordById(ClassHmworkVO classHmworkVO);
	/**
	 * 获取缺交作业的学生搜索查询的总记录数<BR>
	 * 方法名：getCountsearchLackHmworkStudent<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午3:15:46 <BR>
	 * @param searchParams
	 * @return List<LackHmworkStudentVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int getCountSearchLackHmworkStudent(LackHmworkSearchParams searchParams);
	/**
	 * 缺交作业的学生搜索查询，按照缺交作业数降序<BR>
	 * 方法名：searchLackHmworkStudent<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月26日-下午3:13:36 <BR>
	 * @param searchParams
	 * @return List<LackHmworkStudentVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<LackHmworkStudentVO> searchLackHmworkStudentPage(LackHmworkSearchParams searchParams);
	
	/**
	 * 批量查询作业提交情况的详情<BR>
	 * 方法名：getAllStudentsHmworkBySacIds<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月5日-下午8:13:32 <BR>
	 * @param sacIds
	 * @return List<StudentHmworkVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<StudentHmworkVO> getAllStudentsHmworkBySacIds(List<Integer> sacIds);

}
