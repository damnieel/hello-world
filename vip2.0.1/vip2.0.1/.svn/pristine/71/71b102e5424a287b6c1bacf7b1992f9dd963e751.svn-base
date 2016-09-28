package com.moon.vip.service.impl.rules;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.rules.Field;
import com.moon.vip.infra.rules.Rules;
import com.moon.vip.infra.util.StringUtil;
import com.moon.vip.service.rules.RulesResolverBase;

/**
 * 类名称：FieldResolverImpl.java<br/>
 * 日期：2015年12月29日 下午12:29:08<br/>
 * 类描述：字段解析器<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
@Service("fieldResolver")
public class FieldResolverImpl extends RulesResolverBase {
	
	private static Logger logger = Logger.getLogger(FieldResolverImpl.class);

	public void parse(Rules rules){
		super.parse(rules);
		List<Field> fList = rules.getFieldList();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		if(fList == null || fList.size() == 0) {
			throw new BusinessException(EnumCodeException.E0101);
		}
		for(int i = 0; i < fList.size(); i++) {
			Field field = fList.get(i);
			if(field == null || StringUtil.isNull(field.field)) {
				throw new BusinessException(EnumCodeException.E0102);
			}
			sb.append(field.field);
			if(i < fList.size() - 1) {
				sb.append(",");
			}
			sb.append(" ");
		}
		logger.info(String.format("Field解析器，解析结果为: %s", sb.toString()));
		rules.appendParseResult(sb);
	}

}