package com.moon.vip.service.search;

import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.druid.util.StringUtils;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.util.RegExpUtil;
import com.moon.vip.infra.vo.search.SearchParamsBase;

/**
 * 搜索基类
 * SearchBase<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月25日-上午11:04:00 <BR>
 * @version 2.0.0
 *
 */
public abstract class SearchBase<T extends SearchParamsBase, V extends Object> {
	
	private static Logger logger = Logger.getLogger(SearchBase.class);
	
	/**
	 * 获取搜索结果集总记行数<BR>
	 * 方法名：getSearchResultCount<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月25日-下午4:54:54 <BR>
	 * @param searchParams
	 * @return int<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public int getSearchResultCount(T searchParams){
		validateSearchParams(searchParams);
		return excuteGetSearchResultCount(searchParams);
	}
	
	public abstract int excuteGetSearchResultCount(T searchParams);
	
	/**
	 * 搜索步骤模板<BR>
	 * 方法名：search<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月25日-下午4:45:09 <BR>
	 * @param searchParams
	 * @return List<V><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public List<V> search(T searchParams){
		validateSearchParams(searchParams);
		return excuteSearch(searchParams);
	}
	
	/**
	 * 执行实际的搜索，需要子类实现<BR>
	 * 方法名：excuteSearch<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月23日-下午7:05:19 <BR>
	 * @return List<Object><BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public abstract List<V> excuteSearch(T searchParams);
	
	/**
	 * 验证搜索的传入参数<BR>
	 * 方法名：validateSearchParams<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月23日-下午7:05:45 <BR>
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public boolean validateSearchParams(T searchParams){
		if(searchParams == null){;
			logger.warn("搜索参数为空");
			throw new BusinessException(EnumCodeException.E0001);
		}
		if(!StringUtils.isEmpty(searchParams.getSearchKey()) 
				&& !RegExpUtil.isChineseOrDigitOrLetter(searchParams.getSearchKey())){
			logger.info(String.format("搜索关键字[%s]存在非法字符", searchParams.getSearchKey()));
			throw new BusinessException(EnumCodeException.E0005,searchParams.getSearchKey());
		}
		if(StringUtils.isEmpty(searchParams.getSearchKey())){
			searchParams.setSearchKey(null);
		}
		return true;
	}
	
}
