package com.moon.vip.infra.vo.sys;

import java.util.HashSet;

import com.moon.vip.infra.vo.search.SearchParamsWithDept;
/**
 * 
 * 类名称：AuthSearchParams.java<br/>
 * 日期：2016年6月16日 下午7:09:57<br/>
 * 类描述：授权管理页面授权<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年6月16日 chenhai  TODO<br/>
 * @author <a href="mailto:937870526@qq.com"></a><br/>
 * @version 1.0.0
 */
public class AuthSearchParams extends SearchParamsWithDept {

	private static final long serialVersionUID = 18954404682754351L;
	/**授权状态**/
	private  String authStatus;
	
	
	/*** 搜索组织结合***/
	private HashSet<Integer> searchOpClaIds;
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
	public HashSet<Integer> getSearchOpClaIds() {
		return searchOpClaIds;
	}
	public void setSearchOpClaIds(HashSet<Integer> searchOpClaIds) {
		this.searchOpClaIds = searchOpClaIds;
	}  

}
