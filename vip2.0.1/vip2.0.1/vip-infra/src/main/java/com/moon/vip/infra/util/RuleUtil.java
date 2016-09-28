package com.moon.vip.infra.util;

import java.util.List;

import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.EnumReplaceType;
import com.moon.vip.infra.exception.BusinessException;

/**
 * 类名称：RuleUtil.java<br/>
 * 日期：2016年1月5日 下午2:46:00<br/>
 * 类描述：规则解析工具类<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年1月5日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class RuleUtil {

	 /**
	 * 日期：2016年1月5日 下午2:50:02<br/>
	 * 描述：将List对象转换为String类型参数串<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:50:02 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param type
	 * @param list
	 * @return<br/>
	 * StringBuilder
	 */
	@SuppressWarnings("rawtypes")
	public static String listToParams(EnumReplaceType type, List list) {
		StringBuilder params = new StringBuilder();
		boolean isString = true;
		boolean isAppend = false;
		String mark = "";
		switch (type) {
		case STRING:
			isString = true;
			break;
		case INTEGER:
			isString = false;
			break;
		default: 
			throw new BusinessException(EnumCodeException.E0112);
		}
		if(isString) {
			mark = "'";
		}
//		if(list != null && list.size() > 1) {
//			params.append("(");
//			isAppend = true;
//		}
		for(int i = 0; list != null && i < list.size(); i++) {
			Object obj = list.get(i);
			params.append(mark).append(obj.toString()).append(mark);
			if(i < list.size() - 1) {
				params.append(",");
			}
		}
//		if(isAppend) {
//			params.append(")");
//		}
		return params.toString();
	}

}
