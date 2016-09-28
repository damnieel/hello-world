package com.moon.vip.service.sys;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import com.alibaba.fastjson.JSONArray;
import com.moon.vip.infra.vo.sys.OrgProfessionalInfoVO;

/**
 * 
* @ClassName: IOrganizationalProfessionalService 
* @Description: TODO()  
* @Param:   
* @author qingyu <a href="mailto:2190234029@qq.com">dengrihui</a>
* @date 2015年12月28日 下午3:08:57 
*
 */
public interface IOrgProfessionalService {
	
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
	public String convertAuthToJSONArray(HashSet<Integer> authSet) throws Exception;
	/**
	 * 转化系统权限<br/> 
	 * @Title: convertSecurity <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月14日 上午11:22:17  <br/> 
	 * @param authList
	 * @return
	 * List<String>
	 * @throws  <br/>
	 */
	public HashSet<Integer> convertSecurity(HashSet<Integer> authList);
	/**
	 * 获取搜索组织结构id下的子组织<br/> 
	 * @Title: covertOrgSearch <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月14日 上午11:31:36  <br/> 
	 * @param organizationId
	 * @return
	 * String
	 * @throws  <br/>
	 */
	public HashSet<Integer> covertOrgSearch(int organizationId);
	
	 /**
	 * 日期：2016年1月20日 下午5:20:18<br/>
	 * 描述：或者组织结构顶级节点ID<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午5:20:18 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @return<br/>
	 * Integer
	 */
	public Integer findTopNodeId();
	
}
