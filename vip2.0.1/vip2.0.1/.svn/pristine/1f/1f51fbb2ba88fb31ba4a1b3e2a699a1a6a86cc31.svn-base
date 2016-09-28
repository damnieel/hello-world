package com.moon.vip.application.sys;

import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.attendance.ClassIdAndParentIdVO;
import com.moon.vip.infra.vo.sys.ClassInfoVO;
import com.moon.vip.infra.vo.sys.OrgProfessionalInfoVO;
import com.moon.vip.infra.vo.sys.OrganizationalProfessionalVO;
import com.moon.vip.infra.vo.sys.TeacherVO;
import com.moon.vip.infra.vo.sys.classSearchParamsVO;
import com.moon.vip.infra.vo.sys.orgManage.OrgBaseVO;
import com.moon.vip.model.sys.OrganizationalProfessional;


/**
 * 
* @ClassName: OrganizationalProfessionalSqlMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月25日 下午5:38:57 
*
 */
public interface OrganizationalProfessionalSqlMapper {
	//结课
	public int updateIsValid(@Param("id")Integer id);
	//根据事业部查询集群
	public String selectOrgById(@Param("id")Integer id);
	//根据事业部查询查询所以的专业
	public List<OrganizationalProfessionalVO>selectAllMar(@Param("id")Integer id);
	//根据讲师和班主任来查询对应的employee_code
	public String selectTeacherByname(@Param("name") String name );
    public String selectAdiser(@Param("nickName") String nickName);
	//查询所以的讲师和班主任
	public List<OrganizationalProfessionalVO>selectTecher();
	
	public List<OrganizationalProfessionalVO>selectAdviser();
    /**
     * 根据专业id查询专业名称<BR>
     * 方法名：selectCourseNameByID<BR>
     * 创建人：龙金<BR>
     * 时间：2016年1月5日-下午8:38:19 <BR>
     * @param id
     * @return QuestionnaireVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
	public Integer selectCourseNameByID(@Param("bName") String bName);
	//根据班级名称获取班级的id
	public Integer selectClaByName();
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
   * 根据部门名称，专业名称，课程名称获取唯一课程<br/>
   * @Author：  陈海  - （怡宝 ）<br/>
   * @Title: selectClassId <br/>
   * @return List<ClassIdAndParentIdVO>    返回类型 <br/>
   * @date 2015年12月31日 下午8:11:30 <br/>
   * @throws <br/>
   *
  */
	List<ClassIdAndParentIdVO> selectClassId(@Param("orgName")String orgName, @Param("proName")String proName, @Param("className")String className);
	/**
	 * @param id 
	 * @Author:龙金—雷雷
	 * @Title: selectAllClass 
	 * @Description: TODO(显示全部数据)
	 * @return  List
	 * @date 2015年12月29号 下午4：45：30
	 */
	public List<OrganizationalProfessionalVO> selectAllClass(@Param("id")Integer id,@Param("offset")Integer offset,@Param("pageSize")Integer pageSize);
	/**
	 * @Author:龙金—雷雷
	 * @Title: selectColony 
	 * @Description: TODO(查出所有集群)
	 * @return  List
	 * @date 2015年12月29号 下午4：45：30
	 */
	List<OrganizationalProfessionalVO> selectColony();
	
	/**
	 * @Author:龙金—雷雷
	 * @Title: selectDivision 
	 * @Description: TODO(查出所有事业部)
	 * @return  List
	 * @date 2015年12月29号 下午4：46：30
	 */
	List<OrganizationalProfessionalVO> selectDivision();
	

	

	/**
	 * @Author:龙金—雷雷
	 * @Title: selectMajor 
	 * @Description: TODO(查出所有专业)
	 * @return  List
	 * @date 2015年12月29号 下午4：47：30
	 */
	List<OrganizationalProfessionalVO> selectMajor();
	
	/**
	 * @Author:龙金—雷雷
	 * @Title: selectClass 
	 * @Description: TODO(查出所有班级)
	 * @return  List
	 * @date 2015年12月29号 下午4：48：30
	 */
	List<OrganizationalProfessionalVO> selectClass();
	
	/**
	 * @Author:龙金—雷雷
	 * @Title: AddClass 
	 * @Description: TODO(增加班级)
	 * @return  int
	 * @date 2015年12月30号 上午10：48：30
	 */
	public int addClass(OrganizationalProfessionalVO organizationalprofessionalVO);
	public int addTeacher(TeacherVO teacherVO);
	/*public int addEmployee(EmployeeBaseVO employeebaseVO);*/
	
	/**
	 * @Author:龙金—雷雷
	 * @Title: updateClass 
	 * @Description: TODO(修改班级)
	 * @return  int
	 * @date 2015年12月30号 上午10：50：30
	 */
	public int updateClass(OrganizationalProfessionalVO organizationalprofessionalVO);
	
	/**
	 * @Author:龙金—雷雷
	 * @Title: delClass 
	 * @Description: TODO(删除班级)
	 * @return  int
	 * @date 2015年12月30号 上午10：51：30
	 */
	public int delClass(@Param("id")Integer id);
	
	/**
	 * 根据父id获取其子类的信息<br/>
	 * 根据专业id获取其班级id<br/> 
	 * @Title: findOrgInfoByParentId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月30日 下午4:47:47  <br/> 
	 * @param parantId
	 * @return
	 * List<OrgProfessionalInfoVO>
	 * @throws  <br/>
	 */
	List<OrgProfessionalInfoVO> selectOrgInfoByParentId(Integer parantId);
	
	/**
	 * 根据专业名称查找专业ID<br/> 
	 * @Title: selectProfByName <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月26日 下午5:11:29  <br/> 
	 * @param name
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public Integer selectProfByName(@Param("name") String name);
	
	
     /**
       * 获得该部门的子部门<br/>
       * @Author：  陈海  - （怡宝 ）<br/>
       * @param hashSet (权限集合)
       * @Title: findChildOrg <br/>
       * @return List<OrganizationalProfessional>    返回类型 <br/>
       * @date 2015年12月31日 下午8:10:52 <br/>
       * @throws <br/>
       *
      */
	List<OrganizationalProfessional> findChildOrg(@Param("parentId")Integer parentId, @Param("opClaIds")HashSet<Integer> hashSet);
	
	
  /**
    * 获得该部门下的所有专业<br/>
    * @Author：  陈海  - （怡宝 ）<br/>
 * @Title: getAllProId <br/>
    * @return List<Integer>    返回类型 <br/>
    * @date 2015年12月31日 下午8:10:31 <br/> 
    * @throws <br/>
    *
   */
	List<Integer> getAllProId(@Param("parentId")Integer parentId);

   /**
     *获取该班级下的学生编号<br/>
     * @Author：  陈海  - （怡宝 ）<br/>
     * @Title: getStuCode <br/>
     * @return List<String>    返回类型 <br/>
     * @date 2016年1月12日 下午10:03:44 <br/>
     * @throws <br/>
     *
    */
    List<String> getStuCode(@Param("classId")Integer classId);
    /**
     * 获取组织结构的子项目id字符串<br/> 
     * @Title: getChildList <br/> 
     * @Description: TODO <br/> 
     * @auther hanfeng <br/> 
     * @version 创建时间：2016年1月14日 上午10:43:27  <br/> 
     * @param OrgId
     * @return
     * String
     * @throws  <br/>
     */
    public String getChildList(int OrgId);
    
    /**
      * 根据参数获取班级信息<br/>
      * @Author：  陈海  - （怡宝 ）<br/>
      * @Title: getClassInfo <br/>
      * @return List<ClassInfoVO>    返回类型 <br/>
      * @date 2016年1月18日 下午1:52:37 <br/>
      * @throws <br/>
      *
     */
	public List<ClassInfoVO> getClassInfo(classSearchParamsVO params);
	
	
	/**
	  * 根据参数获取班级总数<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getCountClassInfo <br/>
	  * @return int    返回类型 <br/>
	  * @date 2016年1月18日 下午2:17:34 <br/>
	  * @throws <br/>
	  *
	 */
	public int getCountClassInfo(classSearchParamsVO params);
	
	
	/**
	  * 根据父节点获取所有的专业<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	 * @param set 
	  * @Title: getAllProById <br/>
	  * @return List<OrganizationalProfessional>    返回类型 <br/>
	  * @date 2016年1月18日 下午5:16:48 <br/>
	  * @throws <br/>
	  *
	 */
	public List<OrganizationalProfessional> getAllProById(@Param("id")Integer id, @Param("params")HashSet<Integer> set);
	/**
	  * 验证该班级是否存在<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	 * @param claId 
	  * @Title: checkRepeat <br/>
	  * @return int    返回类型 <br/>
	  * @date 2016年1月18日 下午6:50:07 <br/>
	  * @throws <br/>
	  *
	 */
	public int checkRepeat(@Param("id")Integer orgId, @Param("name")String className,@Param("claId") Integer claId);
	
	public List<OrgBaseVO> getAllOrgInfo();
	
	 /**
	 * 日期：2016年1月20日 下午5:19:08<br/>
	 * 描述：查询组织结构-专业顶级节点ID<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午5:19:08 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @return<br/>
	 * Integer
	 */
	public Integer selectTopNodeId();
	
	/**
	  * 判断记录属于哪个部门<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: findWhereOrg <br/>
	  * @return Integer    返回类型 <br/>
	  * @date 2016年1月28日 下午2:26:38 <br/>
	  * @throws <br/>
	  *
	 */
	public List<Integer> findWhereOrgInCla(@Param("params")String[] params);
	/**
	  *判断记录属于哪个部门<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: findWhereOrgInPro <br/>
	  * @return List<Integer>    返回类型 <br/>
	  * @date 2016年1月28日 下午2:50:24 <br/>
	  * @throws <br/>
	  *
	 */
	public List<Integer> findWhereOrgInPro(@Param("params")String[] params);
	
	/**
	  * 根据学生Id获取部门信息<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: findWhereOrgInStu <br/>
	  * @return List<Integer>    返回类型 <br/>
	  * @date 2016年1月28日 下午3:14:11 <br/>
	  * @throws <br/>
	  *
	 */
	public List<Integer> findWhereOrgInStu(@Param("params")String params);
	
	/**
	  *根据调查问卷表Id获取部门信息<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: findWhereOrgInQus <br/>
	  * @return List<Integer>    返回类型 <br/>
	  * @date 2016年1月28日 下午4:53:45 <br/>
	  * @throws <br/>
	  *
	 */
	public Integer findWhereOrgInQus(@Param("params")String params);
	/**
	  * 根据访谈表Id获取部门信息<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: findWhereOrgInItv <br/>
	  * @return Integer    返回类型 <br/>
	  * @date 2016年1月28日 下午5:01:48 <br/>
	  * @throws <br/>
	  *
	 */
	public Integer findWhereOrgInItv(@Param("params")String params);
	
	/**
	  * 根据访谈附件表获取部门信息<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: findWhereOrgInProAth <br/>
	  * @return Integer    返回类型 <br/>
	  * @date 2016年1月28日 下午7:08:10 <br/>
	  * @throws <br/>
	  *
	 */
	public Integer findWhereOrgInProAth(@Param("params")String params);
}