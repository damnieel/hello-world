package com.moon.vip.service.sys;

import java.util.HashSet;
import java.util.List;

import com.moon.vip.infra.vo.sys.ClassInfoVO;
import com.moon.vip.infra.vo.sys.ClassManagerVO;
import com.moon.vip.infra.vo.sys.NewClassMsgVO;
import com.moon.vip.infra.vo.sys.classSearchParamsVO;
import com.moon.vip.model.sys.OrganizationalProfessional;

/**
 * 
* @ClassName: IClassInFoBetaService 
* @Description: TODO(班级信息service) 
* @author  陈海  - （怡宝 ）
* @date 2016年1月18日 下午1:39:09 
*
 */
public interface IClassInFoBetaService {
    /**
      * 根据查询条件获取班级信息<br/>
      * @Author：  陈海  - （怡宝 ）<br/>
      * @Title: getClaInfoByParams <br/>
      * @return List<ClassInfoVO>    返回类型 <br/>
      * @date 2016年1月18日 下午1:49:44 <br/>
      * @throws <br/>
      *
     */
	public List<ClassInfoVO> getClaInfoByParams(classSearchParamsVO params);
    /**
      * 根据查询条件获取班级总数<br/>
      * @Author：  陈海  - （怡宝 ）<br/>
      * @Title: getCountClaInfoByParams <br/>
      * @return int    返回类型 <br/>
      * @date 2016年1月18日 下午2:16:27 <br/>
      * @throws <br/>
      *
     */
	public int getCountClaInfoByParams(classSearchParamsVO params);
	
	/**
	  * 根据Id获取专业<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @param set 
	  * @Title: getProInfo <br/>
	  * @return List<OrganizationalProfessional>    返回类型 <br/>
	  * @date 2016年1月18日 下午4:54:51 <br/>
	  * @throws <br/>
	  *
	 */
	public List<OrganizationalProfessional> getProInfo(Integer id, HashSet<Integer> set);
	
	/**
	  * 新增班级<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: addClass <br/>
	  * @return String    返回类型 <br/>
	  * @date 2016年1月18日 下午6:23:36 <br/>
	  * @throws <br/>
	  *
	 */
	public String addClass(NewClassMsgVO classParams);
	
	/**
	  * 根据角色类型获取员工<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @param searchKey 
	  * @Title: getClassMag <br/>
	  * @return List<ClassManagerVO>    返回类型 <br/>
	  * @date 2016年1月18日 下午8:51:16 <br/>
	  * @throws <br/>
	  *
	 */
	public List<ClassManagerVO> getClassMag(String type, String searchKey);
	
	/**
	  * 更新班级信息<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: updateClass <br/>
	  * @return String    返回类型 <br/>
	  * @date 2016年1月18日 下午9:07:30 <br/>
	  * @throws <br/>
	  *
	 */
	public String updateClass(OrganizationalProfessional params);
	
	/**
	  * 修改班级名称，周期，班主任，讲师<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: updateClaDetail <br/>
	  * @return String    返回类型 <br/>
	  * @date 2016年1月19日 上午10:47:04 <br/>
	  * @throws <br/>
	  *
	 */
	public String updateClaDetail(NewClassMsgVO updateParams, String userCode);
	
	/**
	  * 获取专业下管理员<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getProMag <br/>
	  * @return List<ClassManagerVO>    返回类型 <br/>
	  * @date 2016年1月22日 下午7:43:36 <br/>
	  * @throws <br/>
	  *
	 */
	public List<ClassManagerVO> getProMag(String type, Integer proId);
	
	/**
	 *  班级结课，修改该班级的所有学员的状态  <BR>
	 * 方法名：updateStudentClassStatus<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年3月10日-下午2:45:53 <BR>
	 * @param opClaId
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int updateStudentClassStatus(Integer opClaId);
}
