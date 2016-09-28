package com.moon.vip.service.sys.userManage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.infra.vo.sys.userManage.UserManageVO;
import com.moon.vip.infra.vo.sys.userManage.UserParamsVO;
import com.moon.vip.infra.vo.sys.userManage.UserRoleInfoVO;

public interface IUserManageService {

	/**
	 * 用户管理页面数据<br/> 
	 * @Title: selectUserManageData <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月6日 上午11:12:21  <br/> 
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
	 * @version 创建时间：2016年1月6日 下午2:02:22  <br/> 
	 * @param employeeCode
	 * @return
	 * UserManageVO
	 * @throws  <br/>
	 */
	public UserManageVO selectEmpByEmpCode(String employeeCode);
	/**
	 * 获取角色信息<br/> 
	 * @Title: selectAllRole <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月6日 下午2:50:13  <br/> 
	 * @return
	 * List<Role>
	 * @throws  <br/>
	 */
	public List<UserRoleInfoVO> selectAllRole();
	/**
	 * 插入用户角色信息<br/> 
	 * @Title: insertEmpRole <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月6日 下午3:07:15  <br/> 
	 * void
	 * @param paramsVO 
	 * @throws  <br/>
	 */
	public Message insertEmpRole(String creator, String id, String roleId);
	/**
	 * 删除员工和角色表的信息<br/> 
	 * @Title: delEmpRole <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月7日 下午8:35:12  <br/> 
	 * @param emproleid
	 * @return
	 * Message
	 * @throws  <br/>
	 */
/*	public Message delEmpRole(String emproleid);*/
	
	
	public Message delEmpRoleBySso(HttpServletRequest request,String emproleid);
	/**
	 * 重置用户密码<br/> 
	 * @Title: resetPsw <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月7日 下午8:52:13  <br/> 
	 * @param id
	 * @return
	 * Message
	 * @throws  <br/>
	 */
	public Message resetPsw(String id);
	/**
	 * 分配角色<br/> 
	 * @Title: assignRole <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月8日 下午5:08:48  <br/> 
	 * @param paramsVO
	 * @return
	 * Message
	 * @throws  <br/>
	 */
	public Message assignRole(ParamsVO paramsVO);
	
	/**
	 * 清理更改角色的缓存<br/> 
	 * @Title: clearUserCashe <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月21日 下午4:18:19  <br/> 
	 * void
	 * @throws  <br/>
	 */
	public void clearUserCashe();
	
	/**
	 * 
	 * checkRepeat(通过工号昵称验证唯一性)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param employeeCode
	 * @param nickName
	 * @return
	 * int
	 * @exception
	 * @since  1.0.0
	 */
	public int checkRepeat(String employeeCode, String nickName);
	
	
	/**
	 * 
	 * addUser(增添用户)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param request 
	 * @param paramsVO
	 * @param creator 
	 * @return
	 * Message
	 * @exception
	 * @since  1.0.0
	 */
	public Message addUser(HttpServletRequest request, UserParamsVO paramsVO, String creator);
	
	/**
	 * 
	 * 日期：2016年3月28日 下午8:34:02<br/>
	 * 描述：计算该账号和昵称条件下的用户记录数<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午8:34:02 ruruo <br/>
	 * 修改备注：TODO<br/>
	 * @param employeeCode
	 * @param nickName
	 * @return<br/>
	 * int
	 */
	public int checkRepeatAnd(String employeeCode, String nickName);
	
	
	/**
	 * 
	 * 日期：2016年3月28日 下午9:11:32<br/>
	 * 描述：修改用户<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午9:11:32 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param paramsVO
	 * @param employeeCode
	 * @return<br/>
	 * Message
	 */
	public Message editUser(UserParamsVO paramsVO, String employeeCode);
	
	
	/**
	 * 
	 * 日期：2016年3月30日 上午10:52:58<br/>
	 * 描述：删除员工<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午10:52:58 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param request
	 * @param employeeId 
	 * @param emproleid
	 * @return<br/>
	 * Message
	 */
	public Message deleteEmpoyee(HttpServletRequest request, Integer employeeId, String employeeCode);
	
	
	
}
