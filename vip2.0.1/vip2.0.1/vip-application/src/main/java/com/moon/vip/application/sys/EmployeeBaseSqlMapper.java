package com.moon.vip.application.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.client.vo.UserInfoVO;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.LoginInfoVO;
import com.moon.vip.infra.vo.sys.ClassManagerVO;
import com.moon.vip.infra.vo.sys.EmployeePasswordVO;

public interface EmployeeBaseSqlMapper {
  
	/**
	 * 获取登陆人信息<br/> 
	 * @Title: findEmployeeByCodeAndPwd <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月8日 下午12:26:49  <br/> 
	 * @param loginInfoVO
	 * @return
	 * EmployeeLoginVO
	 * @throws  <br/>
	 */
	public List<EmployeeLoginVO> findEmployeeByCodeAndPwd(LoginInfoVO loginInfoVO);
	
	/**
	 * 获取登陆人信息SSO用<br/> 
	 * @Title: findEmployeeByCodeAndPwd <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月8日 下午12:26:49  <br/> 
	 * @param loginInfoVO
	 * @return
	 * EmployeeLoginVO
	 * @throws  <br/>
	 */
	public List<EmployeeLoginVO> findEmployeeBySSOCodeAndPwd(LoginInfoVO loginInfoVO);
	
	/**
	 * 初始化密码<br/> 
	 * @Title: updatePasswordById <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月8日 上午11:13:10  <br/> 
	 * @param employeePassword
	 * @return
	 * int
	 * @throws  <br/>
	 */
	int updatePasswordById(EmployeePasswordVO employeePassword);
	/**
	 * 验证登陆密码<br/> 
	 * @Title: selectByloginInfo <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月8日 下午12:28:12  <br/> 
	 * @param loginInfoVO 
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int selectByloginInfo(LoginInfoVO loginInfoVO);
    
	/**
	  * 根据角色获取班级管理者<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	 * @param searchKey 
	  * @Title: getClassMag <br/>
	  * @return List<ClassManagerVO>    返回类型 <br/>
	  * @date 2016年1月18日 下午8:56:10 <br/>
	  * @throws <br/>
	  *
	 */
	public List<ClassManagerVO> getClassMag(@Param("type")String type, @Param("key")String searchKey);
    
	
	/**
	  * 根据账号获取用户信息<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: findEmployeeByAccount <br/>
	  * @return EmployeeBase    返回类型 <br/>
	  * @date 2016年3月21日 下午2:36:59 <br/>
	  * @throws <br/>
	  *
	 */
	public UserInfoVO findEmployeeByAccount(String account);
    
	/**
	  * 验证用户昵称唯一性<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: checkUnique <br/>
	  * @return int    返回类型 <br/>
	  * @date 2016年3月22日 下午4:27:45 <br/>
	  * @throws <br/>
	  *
	 */
	public int checkUniqueByNickName(@Param("nickName") String nickName);
	
	
	/**
	 * 
	 * 日期：2016年3月30日 下午2:53:03<br/>
	 * 描述：验证账号唯一性<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:53:03 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param account
	 * @param nickName
	 * @return<br/>
	 * int
	 */
	public int checkUniqueByCode(@Param("account")String account);
    
	/**
	  * 添加用户<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: addUser <br/>
	  * @return int    返回类型 <br/>
	  * @date 2016年3月22日 下午4:40:58 <br/>
	  * @throws <br/>
	  *
	 */
	public int addUser(UserInfoVO user);
    
	
	/**
	 * 
	 * 日期：2016年3月30日 下午3:25:36<br/>
	 * 描述：根据员工账号更新员工基础信息<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午3:25:36 ruruo <br/>
	 * 修改备注：TODO<br/>
	 * @param user
	 * @return<br/>
	 * int
	 */
	public int updateEmpByCode(UserInfoVO user);
	
}