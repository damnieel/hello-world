package com.moon.vip.service.impl.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.moon.vip.infra.rules.Body;
import com.moon.vip.service.rules.IReplaceService;
import com.moon.vip.service.rules.ISupplierService;

/**
 * 类名称：TeacherReplaceImpl.java<br/>
 * 日期：2015年12月31日 下午2:44:36<br/>
 * 类描述：班主任占位符<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月31日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
@Service("teacherReplaceService")
public class TeacherReplaceImpl implements IReplaceService {

	@Autowired
	@Qualifier("supplierService")
	private ISupplierService supplierService;

	public String replace(Body replace, String sql){
		return supplierService.replaceTeacher(replace, sql);
	}

}