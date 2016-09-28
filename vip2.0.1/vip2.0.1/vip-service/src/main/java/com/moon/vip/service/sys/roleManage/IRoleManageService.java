package com.moon.vip.service.sys.roleManage;

import java.util.List;

import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.vo.sys.roleManage.RoleDataOperVO;
import com.moon.vip.infra.vo.sys.roleManage.RoleMenuDataOperVO;
import com.moon.vip.infra.vo.sys.roleManage.TreeVO;
import com.moon.vip.model.sys.ActionType;
import com.moon.vip.model.sys.DataRule;
import com.moon.vip.model.sys.Role;

/**
 * 
 * @ClassName: IRoleManageService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 大枫
 * @date 2016年1月20日 下午3:10:08 
 *
 */
public interface IRoleManageService {

	/**
	 * 查询用户是否有操作权限<br/> 
	 * @Title: selectHasSecurity <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月14日 上午10:16:43  <br/> 
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int selectOperType(RoleDataOperVO roleDataOperVO);
	/**
	 * 根据roleId 获取菜单，数据权限<br/> 
	 * @Title: selectDataMenuByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月16日 下午4:22:52  <br/> 
	 * @param roleId
	 * @return
	 * RoleMenuDataOperVO
	 * @throws  <br/>
	 */
	public List<RoleMenuDataOperVO> selectDataMenuByRoleId(Integer roleId);
	/**
	 * 如果roleId =0 获取所有， 如果roleId有值，就获取该角色的所有菜单<br/> 
	 * @Title: selectMenuResByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月18日 上午10:51:26  <br/> 
	 * void
	 * @throws  <br/>
	 */
	public List<TreeVO> selectMenuResByRoleId(Integer roleId);
	
	/**
	 * 如果roleId =0 获取所有， 如果roleId有值，就获取该角色的数据和操作<br/> 
	 * @Title: selectDataActByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月18日 上午10:51:26  <br/> 
	 * void
	 * @throws  <br/>
	 */
	public List<TreeVO> selectDataActByRoleId(Integer roleId);
	/**
	 * <br/> 
	 * @Title: editRoleMenuAction <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月18日 下午3:45:24  <br/> 
	 * @param menuIds
	 * @param roleId
	 * @param userCode 
	 * @return
	 * Message
	 * @throws  <br/>
	 */
	public Message editRoleMenuAction(List<Integer> menuIds, int roleId, String userCode);
	/**
	 * 获取所有的规则<br/> 
	 * @Title: selectAllRule <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月18日 下午7:40:44  <br/> 
	 * @return
	 * List<DataRule>
	 * @throws  <br/>
	 */
	public List<DataRule> selectAllRule();
	/**
	 * 获取所有的操作<br/> 
	 * @Title: selectAllAct <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月18日 下午8:00:59  <br/> 
	 * @return
	 * List<ActionType>
	 * @throws  <br/>
	 */
	public List<ActionType> selectAllAct();
	/**
	 * 插入相关选择的数据和权限<br/> 
	 * @Title: insertDataActByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月23日 下午1:46:38  <br/> 
	 * @param ruleActId
	 * @param roleId
	 * @param string 
	 * @return
	 * Message
	 * @throws  <br/>
	 */
	public Message insertDataActByRoleId(String ruleActId, String roleId, String creator);
	/**
	 * 保存新角色<br/> 
	 * @Title: insertRole <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月23日 下午6:25:23  <br/> 
	 * @param role
	 * @param userCode
	 * @return
	 * Message
	 * @throws  <br/>
	 */
	public Message insertOrUpdateRole(Role role, String userCode);
	/**
	 * 根据角色id删除该角色<br/> 
	 * @Title: deleteRoleByRoleId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月25日 下午4:58:26  <br/> 
	 * @param roleId 
	 * @param updator 
	 * @return
	 * Message
	 * @throws  <br/>
	 */
	public Message deleteRoleByRoleId(Integer roleId, String updator);
}
