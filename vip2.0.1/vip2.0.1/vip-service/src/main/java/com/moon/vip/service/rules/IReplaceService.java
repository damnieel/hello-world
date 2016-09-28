package com.moon.vip.service.rules;

import com.moon.vip.infra.rules.Body;

/**
 * 类名称：IReplaceService.java<br/>
 * 日期：2015年12月31日 下午2:39:59<br/>
 * 类描述：占位符替换服务<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月31日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public interface IReplaceService {

	 /**
	 * 日期：2015年12月31日 下午2:47:20<br/>
	 * 描述：TODO<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:47:20 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param replace
	 * @param sql<br/>
	 * @return<br/>
	 * String
	 */
	public String replace(Body replace, String sql);

}