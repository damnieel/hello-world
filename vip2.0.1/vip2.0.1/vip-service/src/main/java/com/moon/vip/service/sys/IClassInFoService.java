package com.moon.vip.service.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.student.ProfessionalVO;
import com.moon.vip.infra.vo.sys.EmployeeBaseVO;
import com.moon.vip.infra.vo.sys.OrganizationalProfessionalVO;
import com.moon.vip.infra.vo.sys.TeacherVO;
import com.moon.vip.model.major.MajorFrame;

/** 班级信息
 * IClassInFo
 * @author 雷雷
 * 时间：2015年12月30日 下午2点16分
 */

public interface IClassInFoService {
	//结课
    public int updateIsValid(@Param("id")Integer id);
	//根据事业部查询集群
	public String selectOrgById(@Param("id")Integer id);
	//根据事业部查询查询所以的专业
	public List<OrganizationalProfessionalVO>selectAllMar(@Param("id")Integer id);
	//查询所以的讲师和班主任
	public List<OrganizationalProfessionalVO>selectTecher();
	
	public List<OrganizationalProfessionalVO>selectAdviser();
	
	//根据专业id查询专业名称
	public Integer selectCourseNameByID(@Param("bName")String bName);
	//根据班级名称获取班级的id
	public Integer selectClaByName();
	// 根据讲师和班主任名字获取employee_code 
	public String  selectTeacherByname(@Param("name") String name);
	public String  selectAdiser(@Param("nickName") String nickName);
 	
	// 根据节点id 查询出对应的信息
	List<OrganizationalProfessionalVO> selectInfoById(OrganizationalProfessionalVO id);
	/**
 	 * 获取总数<BR>
 	 * 方法名：selectClaCount<BR>
 	 * 创建人：龙金 <BR>
 	 * 时间：2016年1月8日-下午1:13:35 <BR>
 	 * @return int<BR>
 	 * @exception <BR>
 	 * @since  1.0.0
 	*/
 	public int selectClaCount(@Param("id")Integer id);
	
	/**
	 * 展示全部班级信息<BR>
	 * 方法名：selectAllClass<BR>
	 * 创建人：龙金 <BR>
	 * 时间：2015年12月23日-下午7:39:19 <BR>
	 * @param offset
	 * @param pageSize
	 * @return List<ProfessionalVO><BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public List<OrganizationalProfessionalVO> selectAllClass( @Param("id")Integer id,@Param("offset")Integer offset,@Param("pageSize")Integer pageSize);
	/**
     * 查找所有集群<BR>
     * 方法名：selectColony<BR>
     * 创建人：龙金 <BR>
     * 时间：2015年12月30日-下午2:18:37 <BR>
     * @return List<QuestionnaireVO><BR>
     * @exception <BR>
     * @since  1.0.0
    */
	public List<OrganizationalProfessionalVO> selectColony();
	
	/**
     * 查找所有事业部<BR>
     * 方法名：selectDivsion<BR>
     * 创建人：龙金 <BR>
     * 时间：2015年12月30日-下午2:20:37 <BR>
     * @return List<QuestionnaireVO><BR>
     * @exception <BR>
     * @since  1.0.0
    */
	public List<OrganizationalProfessionalVO> selectDivision();
	
	/**
     * 查找所有专业<BR>
     * 方法名：selectMajor<BR>
     * 创建人：龙金 <BR>
     * 时间：2015年12月30日-下午2:21:37 <BR>
     * @return List<QuestionnaireVO><BR>
     * @exception <BR>
     * @since  1.0.0
    */
	public List<OrganizationalProfessionalVO> selectMajor();
	
	/**
     * 查找所有班级<BR>
     * 方法名：selectMajor<BR>
     * 创建人：龙金 <BR>
     * 时间：2015年12月30日-下午2:21:37 <BR>
     * @return List<QuestionnaireVO><BR>
     * @exception <BR>
     * @since  1.0.0
    */
	public List<OrganizationalProfessionalVO> selectClass();
	
	/**
	 * @Author:龙金—雷雷
	 * @Title: AddClass 
	 * @Description: TODO(增加班级)
	 * @return  int
	 * @date 2015年12月30号 下午2：22：30
	 */
	public boolean insertClass(OrganizationalProfessionalVO org,TeacherVO teacherVO);
	public int addClass(OrganizationalProfessionalVO organizationalprofessionalVO);
	public int addTeacher(TeacherVO teacherVO);
	/*public int addEmployee(EmployeeBaseVO employeebaseVO);*/
	
	/**
	 * @Author:龙金—雷雷
	 * @Title: updateClass 
	 * @Description: TODO(修改班级)
	 * @return  int
	 * @date 2015年12月30号 下午2：24：30
	 */
	public int updateClass(OrganizationalProfessionalVO organizationalprofessionalVO);
	
	/**
	 * @Author:龙金—雷雷
	 * @Title: delClass 
	 * @Description: TODO(删除班级)
	 * @return  int
	 * @date 2015年12月30号 下午2：25：30
	 */
	public int delClass(@Param("id")Integer id);
}
