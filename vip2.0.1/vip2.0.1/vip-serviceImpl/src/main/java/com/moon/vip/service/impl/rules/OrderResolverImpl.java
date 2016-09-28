package com.moon.vip.service.impl.rules;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.rules.Order;
import com.moon.vip.infra.rules.Rules;
import com.moon.vip.infra.util.StringUtil;
import com.moon.vip.service.rules.RulesResolverBase;

/**
 * 类名称：OrderResolverImpl.java<br/>
 * 日期：2015年12月29日 下午12:29:56<br/>
 * 类描述：排序解析器<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月29日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
@Service("orderResolver")
public class OrderResolverImpl extends RulesResolverBase {

	private static Logger logger = Logger.getLogger(OrderResolverImpl.class);
	
	public void parse(Rules rules){
		super.parse(rules);
		List<Order> orderList = rules.getOrderList();
		StringBuilder sb = new StringBuilder();
		if(orderList == null || orderList.size() == 0) {
			return;
		}
		sb.append(" ORDER BY ");
		for(int i = 0; i < orderList.size(); i++) {
			Order order = orderList.get(i);
			if(order == null) {
				throw new BusinessException(EnumCodeException.E0108);
			}
			if(order.field == null || StringUtil.isNull(order.field.field)) {
				throw new BusinessException(EnumCodeException.E0109);
			}
			sb.append(order.field.field).append(" ").append(order.eOrder.method);
			if(i < orderList.size() - 1) {
				sb.append(",");
			}
		}
		logger.info(String.format("Order解析器，解析结果为: %s", sb.toString()));
		rules.appendParseResult(sb);
	}

}