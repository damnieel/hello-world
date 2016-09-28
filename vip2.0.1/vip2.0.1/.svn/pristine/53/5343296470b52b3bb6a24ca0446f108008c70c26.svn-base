package com.moon.vip.service.sys.orgManage;

import java.util.List;

import com.moon.vip.infra.vo.sys.orgManage.OrgBaseVO;

public interface IOrgInfoService {
	
	/**
	 * 加载机构表有效的数据<BR>
	 * 方法名：getAllOrganization<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月20日-下午2:04:53 <BR>
	 * @return List<OrgBaseVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<OrgBaseVO> getAllOrganization();
	
	/**
	 * 获取指定id的所有机构列表<BR>
	 * 方法名：getChildOrgList<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月20日-下午2:05:08 <BR>
	 * @param id
	 * @return List<OrgBaseVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<OrgBaseVO> getChildOrgList(int id);
	
	/**
	 * 获取指定id的所有父级对象列表，包含给定的id对应的节点<BR>
	 * 方法名：getParentOrgList<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月20日-下午2:05:45 <BR>
	 * @param id
	 * @return List<OrgBaseVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<OrgBaseVO> getParentOrgList(int id);
	
	/**
	 * 指定id获取父级对象和所有子级对象，不包含给定的id对应的节点<BR>
	 * 方法名：getParentAndChildList<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月20日-下午2:59:54 <BR>
	 * @param id
	 * @return List<OrgBaseVO><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<OrgBaseVO> getParentAndChildList(int id);

	/**
	 * 获取父级节点id列表，包含指定id<BR>
	 * 方法名：getParentIdList<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月21日-上午9:55:28 <BR>
	 * @param id
	 * @return List<Integer><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<Integer> getParentIdList(int id);
	
	/**
	 * 获取所有子节点id列表，包含指定id<BR>
	 * 方法名：getChildIdList<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月21日-上午9:55:38 <BR>
	 * @param id
	 * @return List<Integer><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<Integer> getChildIdList(int id);
}
