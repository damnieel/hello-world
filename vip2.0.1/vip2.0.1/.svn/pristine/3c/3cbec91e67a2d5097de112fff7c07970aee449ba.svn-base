package com.moon.vip.application.sys.userManage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.infra.vo.sys.userManage.UserManageVO;

public interface UserManagerSqlMapper {

	/**
	 * 用户管理页面数据<br/> 
	 * @Title: selectUserManageData <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月6日 上午11:10:43  <br/> 
	 * @param paramsVO 
	 * @return
	 * List<UserManageVO>
	 * @throws  <br/>
	 */
	public List<UserManageVO> selectUserManageData(ParamsVO paramsVO);
	/**
	 * 用户管理页面数据 总数<br/> 
	 * @Title: selectUserManageDataCount <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月6日 上午11:16:43  <br/> 
	 * @param paramsVO 
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int selectUserManageDataCount(ParamsVO paramsVO);
	/**
	 * 根据工号获取用户和部门信息<br/> 
	 * @Title: selectEmpByEmpCode <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月6日 下午1:58:54  <br/> 
	 * @param employeeCode
	 * @return
	 * UserManageVO
	 * @throws  <br/>
	 */
	public UserManageVO selectEmpByEmpCode(@Param("employeeCode")String employeeCode);
	
	
	/**
	 * 
	 * countEmployeeByParams(通过参数计算employee总数)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param employeeCode
	 * @param nickName
	 * @return
	 * int
	 * @exception
	 * @since  1.0.0
	 */
	public int countEmployeeByParams(@Param("employeeCode")String employeeCode,@Param("nickName") String nickName);

	
	/**
	 * 
	 * 日期：2016年3月28日 下午8:35:54<br/>
	 * 描述：记算员工号不是该账号，昵称的重复性<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午8:35:54 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param employeeCode
	 * @param nickName
	 * @return<br/>
	 * int
	 */
	public int countEmploye(@Param("employeeCode")String employeeCode, @Param("nickName")String nickName);
}
