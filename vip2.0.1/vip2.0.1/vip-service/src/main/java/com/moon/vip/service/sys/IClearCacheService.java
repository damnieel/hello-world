package com.moon.vip.service.sys;

/**
 * 类名称：ICleanCacheService.java<br/>
 * 日期：2016年1月8日 下午6:21:08<br/>
 * 类描述：缓存清空服务<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年1月8日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public interface IClearCacheService {

	 /**
	 * 日期：2016年1月8日 下午6:22:24<br/>
	 * 描述：清空专业-组织机构数据权限缓存<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午6:22:24 Roy <br/>
	 * 修改备注：TODO<br/><br/>
	 * void
	 */
	public void clearAuthForOrgProfessional();
	 /**
	 * 日期：2016年1月9日 下午3:57:34<br/>
	 * 描述：权限对象转换为JSONArray<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午3:57:34 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param authSet
	 * @return<br/>
	 * JSONArray
	 */
	public void clearConvertAuthToJSONArray();
	
	/**
	 * 清理主菜单缓存<br/> 
	 * @Title: clearGetMainMenu <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月11日 下午3:25:58  <br/> 
	 * void
	 * @throws  <br/>
	 */
	public void clearGetMainMenu();
	/**
	 * 清理子菜单缓存<br/> 
	 * @Title: clearGetSubMenu <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月11日 下午3:26:14  <br/> 
	 * void
	 * @throws  <br/>
	 */
	public void clearGetSubMenu();	
	/**
	 * 清理查询子机构缓存<br/> 
	 * @Title: clearGetSubMenu <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月11日 下午3:26:14  <br/> 
	 * void
	 * @throws  <br/>
	 */
	public void clearGetChildList();	
	
	/**
	 * 清理所有子菜单缓存<br/> 
	 * @Title: clearGetSubMenu <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月11日 下午3:26:14  <br/> 
	 * void
	 * @throws  <br/>
	 */
	public void clearGetAllSubMenu();
	
	/**
	 * 清理查询父机构的缓存<BR>
	 * 方法名：clearGetParentOrgList<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月20日-下午1:39:03 <BR> void<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public void clearGetParentOrgList();
	
	/**
	 * 清理查询子机构的缓存<BR>
	 * 方法名：clearGetChildOrgList<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月20日-下午1:39:41 <BR> void<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public void clearGetChildOrgList();
	
	/**
	 * 清理所有机构的数据缓存<BR>
	 * 方法名：clearGetAllOrganization<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月20日-下午1:42:40 <BR> void<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public void clearGetAllOrganization();
	
	/**
	 * 清除Url信息缓存<BR>
	 * 方法名：clearUrlInfomation<BR>
	 * 创建人：陈海 <BR>
	 * 时间：2016年1月27日-下午20:42:40 <BR> void<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public void clearUrlInfomation();
	/**
	 * 清理所有机构的数据缓存<BR>
	 * 方法名：clearGetAllOrganization<BR>
	 * 创建人：lqc <BR>
	 * 时间：2016年1月20日-下午1:42:40 <BR> void<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public void clearSelectDataActByEmpId();
	
	
	
	
}
