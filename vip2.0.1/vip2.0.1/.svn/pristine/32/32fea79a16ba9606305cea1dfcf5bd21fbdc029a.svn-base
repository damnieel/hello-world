package com.moon.vip.service.impl.sys;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.moon.client.enums.EnumResultCode;
import com.moon.client.sso.SingleSingOn;
import com.moon.client.vo.Message;
import com.moon.vip.application.sys.EmployeeBaseSqlMapper;
import com.moon.vip.infra.vo.sys.EmployeePasswordVO;
import com.moon.vip.service.impl.sys.userManage.UserManageServiceImpl;
import com.moon.vip.service.sys.IEmployeePasswordService;

/**
 * 类名称：EmployeePasswordService.java<br/>
 * 日期：2015年12月24日 下午1:27:13<br/>
 * 类描述：修改账号密码<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * @author 向新</a><br/>
 * @version 1.0.0
 */

@Service("EmployeePasswordService")
public class EmployeePasswordServiceImpl implements IEmployeePasswordService{
	
	@Autowired
	private EmployeeBaseSqlMapper employeeBaseSqlMapper;
	private Logger logger = Logger.getLogger(EmployeePasswordServiceImpl.class);
	@Autowired
	private SingleSingOn singleSignOn;
	
	public Message updatePasswordById(EmployeePasswordVO password) {
		Message  message = new Message();
		employeeBaseSqlMapper.updatePasswordById(password);
		message.buildIsSuccess(true).buildCode(EnumResultCode.A00001.code).buildDesc("操作成功");
		return message;
	}
    /**
     * 调用SSO系统对密码进行修改
     */
	public Message updatePasswordWithSsoById(HttpServletRequest request,EmployeePasswordVO password) {
		Message message=new Message();
		if(StringUtils.isEmpty(password.getOldPwd())||StringUtils.isEmpty(password.getNewPwd())){
			message=message.buildIsSuccess(false).buildCode(EnumResultCode.B00011.message).buildDesc(EnumResultCode.B00011.code);
		}
		logger.info(String.format("密码修改账号%s",password.getEmployeeCode()));
		return singleSignOn.modifyPassword(request, password.getOldPwd(), password.getNewPwd());
	}
	
	
}
