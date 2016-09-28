package com.moon.vip.service.attend;

import java.util.List;

import com.moon.vip.infra.vo.attendance.AttendDetailVO;
import com.moon.vip.infra.vo.attendance.AttendSercherParams;
import com.moon.vip.infra.vo.attendance.DelAttenParamsVO;
import com.moon.vip.infra.vo.attendance.StuAttendanceVO;
import com.moon.vip.infra.vo.homework.ClassAndTeacherVO;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;

/**
 * 
* @ClassName: IStudentAttendService 
* @Description: TODO(考勤记录service) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月28日 下午2:33:16 
*
 */
public interface IStudentAttendService {
   /**
    * 
   * @Author：  陈海  - （怡宝 ）
   * @Title: getClassInfoByParams 
   * @Description: TODO(根据参数获取课程信息) 
   * @param @param searchParams
   * @param @return    设定文件 
   * @return List<ClassVO>    返回类型 
   * @date 2015年12月28日 下午2:41:33 
   * @throws
    */
	public List<ClassAndTeacherVO> getClassInfoByParams(SearchParamsWithDept searchParams);
   /**
     *根据参数获取课程记录总数<br/>
     * @Author：  陈海  - （怡宝 ）<br/>
     * @Title: getCountClassByParams <br/>
     * @return int    返回类型 <br/>
     * @date 2016年1月6日 下午3:17:03 <br/>
     * @throws <br/>
     *
    */
    public int getCountClassByParams(SearchParamsWithDept searchParams);
    
  /**
    * 根据班级ID获取班级信息<br/>
    * @Author：  陈海  - （怡宝 ）<br/>
    * @Title: getClassInfoById <br/>
    * @return ClassAndTeacherVO    返回类型 <br/>
    * @date 2016年1月6日 下午3:17:22 <br/>
    * @throws <br/>
    *
    */
	public ClassAndTeacherVO getClassInfoById(Integer classId);
	
	  /**
	    * 获取学生的考勤情况<br/>
	    * @Author：  陈海  - （怡宝 ）<br/>
	    * @Title: getStuAttendanceByParams <br/>
	    * @return List<StuAttendanceVO>    返回类型 <br/>
	    * @date 2016年1月6日 下午3:17:50 <br/>
	    * @throws <br/>
	    *
	   */
	public List<StuAttendanceVO> getStuAttendanceByParams(AttendSercherParams params);
	
	/**
	  * 获取班级考勤记录总数<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getCountStuAttenByParams <br/>
	  * @return int    返回类型 <br/>
	  * @date 2016年1月6日 下午3:18:10 <br/>
	  * @throws <br/>
	  *
	 */
	public int getCountStuAttenByParams(AttendSercherParams params);
	
	/**
	 * 删除考勤记录<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: deleteAttenRecord <br/>
	  * @return String    返回类型 <br/>
	  * @date 2016年1月6日 下午3:18:45 <br/>
	  * @throws <br/>
	  *
	 */
	public String deleteAttenRecord(DelAttenParamsVO delParams, String empCode);
	
	/**
	  * 根据学生课程id.学员id,日期获取学生考勤记详情<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getStuAttenDetail <br/>
	  * @return List<AttendDetailVO>    返回类型 <br/>
	  * @date 2016年1月4日 下午2:44:09 <br/>
	  * @throws <br/>
	  *
	 */
	public List<AttendDetailVO> getStuAttenDetail(DelAttenParamsVO detailParams);
	
	/**
	  * 获取有缺勤记录的学生<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getUnAttenStus <br/>
	  * @return List<StuAttendanceVO>    返回类型 <br/>
	  * @date 2016年3月1日 下午8:06:29 <br/>
	  * @throws <br/>
	  *
	 */
	public List<StuAttendanceVO> getUnAttenStus(AttendSercherParams params);
	
	/**
	  * 获取有缺勤记录的学生总数<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getCountUnAttenStus <br/>
	  * @return int    返回类型 <br/>
	  * @date 2016年3月1日 下午8:26:22 <br/>
	  * @throws <br/>
	  *
	 */
	public int getCountUnAttenStus(AttendSercherParams params);

}
