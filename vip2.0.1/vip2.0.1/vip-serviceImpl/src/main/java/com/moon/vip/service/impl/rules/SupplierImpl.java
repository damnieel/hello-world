package com.moon.vip.service.impl.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.EnumOperation;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.rules.Body;
import com.moon.vip.infra.util.RuleUtil;
import com.moon.vip.service.rules.ISupplierService;

/**
 * 类名称：SupplierImpl.java<br/>
 * 日期：2015年12月30日 下午6:55:54<br/>
 * 类描述：替换服务提供者<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月30日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
@Service("supplierService")
public class SupplierImpl implements ISupplierService {
	
	private static Logger logger = Logger.getLogger(SupplierImpl.class);

	public String replaceTeacher(Body content, String sql) {
		return dealSingleValue(content, sql);
	}

	public String replaceAdviser(Body content, String sql) {
		return dealSingleValue(content, sql);
	}

	public String replaceEmployee(Body content, String sql) {
		return dealMultiValue(content, sql);
	}

	public String replaceSubNode(Body content, String sql) {
		return dealMultiValue(content, sql);
	}

	public String replaceCustom(Body content, String sql) {
		return dealMultiValue(content, sql);
	}

	 /**
	 * 日期：2015年12月31日 下午2:17:21<br/>
	 * 描述：单值处理<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:17:21 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param content
	 * @param sql<br/>
	 * @return<br/>
	 * String
	 */
	private String dealSingleValue(Body content, String sql) {
		if(content.getValues() == null || content.getValues().size() == 0) {
			throw new BusinessException(EnumCodeException.E0111);
		}
		if(content.getValues().size() != 1) {
			throw new BusinessException(EnumCodeException.E0110);
		}
		return repalceValues(content, sql);
	}
	
	 /**
	 * 日期：2015年12月31日 下午2:17:37<br/>
	 * 描述：多值处理<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:17:37 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param content
	 * @param sql<br/>
	 * @return<br/>
	 * String
	 */
	private String dealMultiValue(Body content, String sql) {
		if(content.getValues() == null || content.getValues().size() == 0) {
			throw new BusinessException(EnumCodeException.E0111);
		}
		return repalceValues(content, sql);
	}

	 /**
	 * 日期：2015年12月31日 下午2:18:47<br/>
	 * 描述：替换SQL中的占位符<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:18:47 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param content
	 * @param sql<br/>
	 * @return<br/>
	 * String
	 */
	private String repalceValues(Body content, String sql) {
		checkOperateParams(content, sql);
		sql = sql.replaceAll(content.getReference().type, RuleUtil.listToParams(content.getType(), content.getValues()));
		logger.info(String.format("处理结果:%s", sql));
		return sql;
	}

	 /**
	 * 日期：2016年1月4日 下午3:58:17<br/>
	 * 描述：如果Body中values属性包含参数大于1，那么操作符必须为in或not in<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午3:58:17 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param content
	 * @param sql<br/>
	 * void
	 */
	private void checkOperateParams(Body content, String sql) {
		if (content.getValues() != null && content.getValues().size() > 1) {
			String regEx = ".*(" + EnumOperation.IN.key + "|" + EnumOperation.NOT_IN.key + ")" + "\\s{1,}\\("
					+content.getReference().type + ".*";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(sql);
			if(!matcher.matches()) {
				throw new BusinessException(EnumCodeException.E0115);
			}
		}
	}
	
	public static void main(String[] args) {
//		String regEx = "\\s{1,}";
		String regEx = ".*(in|not in)\\s{1,}\\(:current_employee.*";
		String sql = "SELECT op.ID  FROM vip_organizational_professional op left join vip_OP_manager manager  on op.ID = manager.op_id  WHERE 1 = 1  and (manager.type = 'adviser' and manager.employee_code in (:current_employee )) and (op.is_valid in ('Y','N'))";
//		System.out.println(sql.replaceAll(regEx, " "));
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(sql);
		System.out.println(matcher.matches());
	
	}
}