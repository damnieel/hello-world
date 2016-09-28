package com.moon.vip.application.student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.student.ClassVO;
import com.moon.vip.infra.vo.student.CourseVO;
import com.moon.vip.infra.vo.student.StuAuthVO;
import com.moon.vip.infra.vo.student.StuProfessionalVO;
import com.moon.vip.infra.vo.student.StudentCodeVO;
import com.moon.vip.infra.vo.student.StudentVO;
import com.moon.vip.infra.vo.sys.AuthSearchParams;

/**
 * 学员信息模块与重复数据模块
 * StudentArchivesSqlMapper<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月28日-下午8:27:13 <BR>
 * @version 1.0.0
 * 
 */
public interface StudentArchivesSqlMapper {

    /**
     * 学员信息展示列表<BR>
     * 方法名：selectAllStudent<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月28日-下午8:35:42 <BR>
     * @return List<StudentVO><BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public	List<StudentVO> selectAllStudent(StudentVO studentVO);
    
    /**
     * 查询该学员是否有欠款课程专业<BR>
     * 方法名：selectIsRefund<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月28日-下午8:39:24 <BR>
     * @param id
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int selectIsRefund(@Param("id")Integer id);
    
    /**
     * 查询学员总数<BR>
     * 方法名：selectAllStudentCount<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月31日-下午8:01:56 <BR>
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int selectAllStudentCount(StudentVO studentVO);
    
    /**
     * 查询个人信息详情<BR>
     * 方法名：selectStuDetail<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月28日-下午8:41:19 <BR>
     * @param id
     * @return StudentVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public StudentVO selectStuDetail(@Param("id")Integer id);
    
    /**
     * 删除课程专业信息<BR>
     * 方法名：deleteCourse<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月15日-上午11:20:00 <BR>
     * @param pId
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int deleteCourse(@Param("pId")Integer pId);
    
    /**
     * 根据学员id查询专业详情 <BR>
     * 方法名：selectCourseDetail<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月28日-下午8:43:09 <BR>
     * @param id
     * @return List<StudentVO><BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public List<CourseVO> selectCourseDetail(CourseVO courseVO);
    
    /**
     * 从码表获取下拉值（用于查看学员个人学历详情）<BR>
     * 方法名：selectByCodeTable<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月28日-下午8:45:37 <BR>
     * @return CodeTableVO<BR>
     * @exception <BR>
     * @since  1.0.0
     */
    public StudentVO selectByDegree(@Param("educationBackgroundKey")String educationBackgroundKey);
    
    /**
     * 从码表获取下拉值（用于查看学员个人职业详情）<BR>
     * 方法名：selectByProfessional<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月4日-下午2:44:10 <BR>
     * @param professional
     * @return StudentVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public StudentVO selectByProfessional(@Param("occupationCodeKey")String occupationCodeKey);
    
    /**
     * 从码表获取下拉值（用于查看学员专业退费详情）<BR>
     * 方法名：selectByCodeTableCourse<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月4日-下午2:22:08 <BR>
     * @param refundReason
     * @param payment
     * @return List<StudentVO><BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public CourseVO selectByRefundReason(@Param("refundReason")String refundReason);

    /**
     * 从码表获取下拉值(用于查看学员专业支付详情)<BR>
     * 方法名：selectByPayment<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月4日-下午2:45:40 <BR>
     * @param payment
     * @return CourseVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public CourseVO selectByPayment(@Param("payment")String payment);
    
    /**
     * 添加个人学员信息表<BR>
     * 方法名：insertStuArchives<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月30日-下午1:37:13 <BR>
     * @param studentVO
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int insertStuArchives(StudentVO studentVO);
    
    
    /**
     * 添加学员专业信息<BR>
     * 方法名：insertStuProfessional<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月30日-下午6:24:23 <BR>
     * @param stuProfessionalVO
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int insertStuProfessional(List<StuProfessionalVO> stuProfessionalVO);
    
    /**
     * 查询学员编号最大值<BR>
     * 方法名：studentCodeMax<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月30日-下午6:46:07 <BR>
     * @param studentCodeVO
     * @return StudentCodeVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public StudentCodeVO selectStudentCodeMax();
    
    /**
     * 根据专业时间查询专业编号最大值<BR>
     * 方法名：selectCourseCodeMax<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月9日-下午7:41:00 <BR>
     * @return StudentCodeVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    //public StudentCodeVO selectCourseCodeMax(@Param("studentCourseTime")String studentCourseTime);
    
    /**
     * 修改学员编号，专业编号最大值<BR>
     * 方法名：updateStudentCodeMax<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月30日-下午7:31:00 <BR>
     * @param studentCodeVO
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int updateStudentCodeMax(StudentCodeVO studentCodeVO);
    
    /**
     * 添加学员编号，专业编号最大值<BR>
     * 方法名：insertStudentCodeMax<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月30日-下午7:32:29 <BR>
     * @param studentCodeVO
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int insertStudentCodeMax(StudentCodeVO studentCodeVO);
    
    /**
     * 修改学员信息表<BR>
     * 方法名：updateStuArchives<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月29日-下午7:37:06 <BR>
     * @param id
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int updateStuArchives(StudentVO studentVO);
     
    /**
     * 修改专业信息表<BR>
     * 方法名：updateStuProfessional<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月29日-下午7:40:04 <BR>
     * @param id
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int updateStuProfessional(StuProfessionalVO stuProfessionalVO);
    
    /**
     * 查询所有的专业BR>
     * 方法名：selectCourse<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月5日-下午5:01:58 <BR>
     * @return List<CourseVO><BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public List<ClassVO> selectCourse(@Param("courseName")String courseName);
    
    /**
     * 根据专业id查询专业<BR>
     * 方法名：selectCourseById<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月13日-下午9:30:08 <BR>
     * @param id
     * @return ClassVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public ClassVO selectCourseById(@Param("id")Integer id);
    
    /**
     * 查询是否保存了学员基础信息<BR>
     * 方法名：selectPersonalDetail<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月8日-下午8:04:58 <BR>
     * @param studentVO
     * @return StudentVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public StudentVO selectPersonalDetail(StudentVO studentVO);
    
    /**
     * 查询是否存在该学员信息<BR>
     * 方法名：selectPersonalDetailCount<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月27日-下午2:09:20 <BR>
     * @param studentVO
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int selectPersonalDetailCount(StudentVO studentVO);
    
    /**
     * 查询生成的专业编号是否存在<BR>
     * 方法名：selectStudentCode<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月19日-下午2:53:17 <BR>
     * @param codeNo
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int selectStudentCode(@Param("codeNo")String codeNo);
    
	/**
	*  删除未分班学员信息  将is_valid更新为N<br/> 
	* @Title: setValidArchProf <br/> 
	* @Description: TODO <br/> 
	* @auther hanfeng <br/> 
	* @version 创建时间：2015年12月29日 下午8:12:30  <br/> 
	* @param id
	* @return
	* int
	* @throws  <br/>
	*/
	public int updateValidArch(int id);

	/**
	 * 删除身份证图片信息<BR>
	 * 方法名：deleteImg<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年6月16日-下午3:55:31 <BR>
	 * @param stuId
	 * @param parms
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int deleteImg(@Param("stuId")Integer stuId, @Param("parms")String parms);
	
	
	
	   
    /**
     * 
     * 日期：2016年6月17日 下午3:19:56<br/>
     * 描述：根据条件获取学生总数<br/>
     * 修改说明（时间、人）：<br/>
     * 下午3:19:56 chenhai <br/>
     * 修改备注：TODO<br/>
     * @param searchParams
     * @return<br/>
     * int
     */
	public int getCountStuByParams(AuthSearchParams searchParams);
    
	
	/**
	 * 
	 * 日期：2016年6月17日 下午4:12:31<br/>
	 * 描述：获取学生授权情况<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午4:12:31 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param searchParams
	 * @return<br/>
	 * List<StuAuthVO>
	 */
	public List<StuAuthVO> getAuthStuInfo(AuthSearchParams searchParams);
    
	/**
	 * 
	 * 日期：2016年6月17日 下午7:46:54<br/>
	 * 描述：通过官网账号获取学生<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午7:46:54 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param account
	 * @return<br/>
	 * List<StuAuthVO>
	 */
	public List<StuAuthVO> getStuByAccount(String account);
    
	
	/**
	 * 
	 * 日期：2016年6月17日 下午8:06:53<br/>
	 * 描述：将学生授权给给定官网账号<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午8:06:53 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param stuId
	 * @param account
	 * @param empCode 
	 * @return<br/>
	 * int
	 */
	public int authStudent(@Param("stuId")Integer stuId, @Param("account")String account, @Param("empCode")String empCode);
    
	/**
	 * 
	 * 日期：2016年6月17日 下午8:28:12<br/>
	 * 描述：取消授权<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午8:28:12 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param stuIdArray
	 * @return<br/>
	 * int
	 */
	public int cancelAuthByStuIds(@Param("stuIdArray")List<String> stuIdArray,@Param("empCode")String empCode);
	
	/**
	 * 
	 * 日期：2016年7月5日15:35:47<br/>
	 * 描述：验证学生档案信息(QQ)<br/>
	 * 修改说明（时间、人）：zhangxuanjiu <br/>
	 * 修改备注：TODO<br/>
	 * @param StudentVO
	 * @return<br/>
	 * int
	 */
	public int validateStuQQ(StudentVO studentVO);
}
