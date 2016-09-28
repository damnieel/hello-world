package com.moon.vip.application.inspect;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.attendance.AttendDetailVO;
import com.moon.vip.infra.vo.attendance.AttendNumsVO;
import com.moon.vip.infra.vo.attendance.AttendSercherParams;
import com.moon.vip.infra.vo.attendance.DelAttenParamsVO;
import com.moon.vip.infra.vo.attendance.OrgNameVO;
import com.moon.vip.infra.vo.attendance.StuAttendanceVO;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
import com.moon.vip.model.inspect.InspectDetail;

/**
 * 
* @ClassName: InspectDetailSqlMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月24日 下午7:53:45 
*
 */
public interface InspectDetailSqlMapper {
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: selectId 
	* @Description: TODO(查询匹配的记录，并返回Id) 
	* @param @param record
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @date 2015年12月28日 下午12:01:35 
	* @throws
	 */
	public Integer selectId(InspectDetail record);
    
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: insertSelective 
	* @Description: TODO(批量插入考勤记录) 
	* @param @param atRecords
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @date 2015年12月28日 下午12:02:09 
	* @throws
	 */
	public Integer insertSelective(@Param("atRecords")List<InspectDetail> atRecords);
	
	
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: findStuAttendByParams 
	* @Description: TODO(获取学生考勤记录) 
	* @param @param searchParams
	* @return List<StuAttendanceVO>    返回类型 
	* @date 2015年12月28日 下午6:19:14 
	* @throws
	 */

	public List<StuAttendanceVO> findStuAttendByParams(SearchParamsWithDept searchParams);
    /**
     * 
    * @Author：  陈海  - （怡宝 ）
    * @Title: getCountStuAttendByParams 
    * @Description: TODO(获取学生考勤情况记录总数) 
    * @param @param searchParams
    * @param @return    设定文件 
    * @return int    返回类型 
    * @date 2015年12月28日 下午6:22:31 
    * @throws
     */
	public int getCountStuAttendByParams(AttendSercherParams searchParams);
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: deleteRepeat 
	* @Description: TODO(插入之前先尝试删除) 
	* @param @param atRecords
	* @param @return    设定文件 
	* @return int    返回类型 
	* @date 2015年12月28日 下午9:17:31 
	* @throws
	 */

	public List<Integer> checkRepeat();
	
    /**
     * @param repeatList 
     * 
    * @Author：  陈海  - （怡宝 ）
    * @Title: deleteRepeat 
    * @Description: TODO(删除重复记录) 
    * @return int    返回类型 
    * @date 2015年12月28日 下午9:48:13 
    * @throws
     */
	public int deleteRepeat(@Param("repeatList")List<Integer> repeatList);
	
    /**
     * 
    * @Author：  陈海  - （怡宝 ）
    * @Title: delRecordByParams 
    * @Description: TODO(根据条件删除记录) 
    * @param @param delParams
    * @param @return    设定文件 
    * @return int    返回类型 
    * @date 2015年12月29日 下午1:50:43 
    * @throws
     */
	public int delRecordByParams(DelAttenParamsVO delParams);
    
    /**
      * 获取出勤,缺勤,请假总数<br/>
      * @Author：  陈海  - （怡宝 ）<br/>
      * @Title: getStatisticData <br/>
      * @return AttendNumsVO    返回类型 <br/>
      * @date 2015年12月31日 下午8:09:49 <br/>
      * @throws <br/>
      *
     */
	public AttendNumsVO getStatisticData(@Param("list")List<Integer> list, @Param("params")StatisticSearchParams params);

	
	/**
	 * 
	*  判断该学生是否在该班级<br/>
	* @Author：  陈海  - （怡宝 ）<br/>
	* @Title: checkIsInClass <br/>
	* @return int    返回类型 <br/>
	* @date 2015年12月31日 下午8:06:52 <br/>
	* @throws <br/>
	 */
	public int checkIsInClass(@Param("classId")Integer classId, @Param("studentId")Integer studentId);


	/**
	 * 根据学员id查询是否存在考勤记录<br/> 
	 * @Title: selectCountByStudentId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月31日 上午10:46:47  <br/> 
	 * @param id
	 * @return
	 * Integer
	 * @throws  <br/>
	 */
	public int selectCountByStudentId(@Param("id")int id, 
			@Param("gradeOrgId")int gradeOrgId, @Param("profOrgId")int profOrgId);
    
	/**
	  * 获取学生考勤记录详情<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getStuAttenDetail <br/>
	  * @return List<AttendDetailVO>    返回类型 <br/>
	  * @date 2016年1月4日 下午2:49:08 <br/>
	  * @throws <br/>
	  *
	 */
	public List<AttendDetailVO> getStuAttenDetail(@Param("detailParams")DelAttenParamsVO detailParams);
     /**
       * 删除考勤记录<br/>
       * @Author：  陈海  - （怡宝 ）<br/>
       * @Title: deleteRecord <br/>
       * @return int    返回类型 <br/>
       * @date 2016年1月12日 下午9:30:17 <br/>
       * @throws <br/>
       *
      */
	public int deleteRecord(InspectDetail atRecord);
     /**
       * 获取部门（生成测试用例用）<br/>
       * @Author：  陈海  - （怡宝 ）<br/>
       * @Title: getOrg <br/>
       * @return List<OrgNameVO>    返回类型 <br/>
       * @date 2016年1月12日 下午9:30:59 <br/>
       * @throws <br/>
       *
      */
	public List<OrgNameVO> getOrg();
    
	/**
	  * 查找该班级下所有学生<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: findStudentByClassId <br/>
	  * @return List<StuAttendanceVO>    返回类型 <br/>
	  * @date 2016年3月1日 下午4:14:56 <br/>
	  * @throws <br/>
	  *
	 */
	public List<StuAttendanceVO> findStudentByClassId(AttendSercherParams searchParams);
	
	public List<StuAttendanceVO> findStuByClaIdInAtdTable(AttendSercherParams searchParams);
	
	public int getCountStudentByClassId(AttendSercherParams searchParams);
    /**
      * TODO<br/>
      * @Author：  陈海  - （怡宝 ）<br/>
      * @Title: getStudentAttendByStuIds <br/>
      * @return List<StuAttendanceVO>    返回类型 <br/>
      * @date 2016年3月1日 下午5:00:15 <br/>
      * @throws <br/>
      *
      */
	public List<StuAttendanceVO> getStudentAttendByStuIds(@Param("classId")int orgProCalId,@Param("params") List<StuAttendanceVO> list);
     /**
       * 根据学生id获取学生信息<br/>
       * @Author：  陈海  - （怡宝 ）<br/>
       * @Title: getStuArchesByStuIds <br/>
       * @return List<StuAttendanceVO>    返回类型 <br/>
       * @date 2016年3月1日 下午6:49:48 <br/>
       * @throws <br/>
       *
      */
	public List<StuAttendanceVO> getStuArchesByStuIds(@Param("orgProCalId")int orgProCalId,@Param("params")List<StuAttendanceVO> studentlists);
    /**
      *获取有缺勤记录的学生<br/>
      * @Author：  陈海  - （怡宝 ）<br/>
     * @param orgs 
      * @Title: getUnAttendStus <br/>
      * @return List<StuAttendanceVO>    返回类型 <br/>
      * @date 2016年3月1日 下午8:13:27 <br/>
      * @throws <br/>
      *
     */
	public List<StuAttendanceVO> getUnAttendStus(@Param("claIds")String[] orgs, @Param("params")AttendSercherParams params);
    /**
      *获取有缺勤记录的学生总数<br/>
      * @Author：  陈海  - （怡宝 ）<br/>
     * @param orgs 
      * @Title: getCountUnAttendStus <br/>
      * @return int    返回类型 <br/>
      * @date 2016年3月1日 下午8:27:40 <br/>
      * @throws <br/>
      *
     */
	public int getCountUnAttendStus(@Param("claIds")String[] orgs, @Param("params")AttendSercherParams params);
	
    /**
     *更新考勤记录<br/>
     * @Author： zhumin）<br/>
    * @param orgs 
     * @Title: getCountUnAttendStus <br/>
     * @return int    返回类型 <br/>
     * @date 2016年5月21日 下午8:27:40 <br/>
     * @throws <br/>
     *
    */
	int updateRecordByParams(DelAttenParamsVO record);

}