package com.moon.vip.service.impl.sys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Base64Utils;

import com.moon.vip.infra.util.Md5Util;
import com.moon.vip.infra.vo.sys.EmployeePasswordVO;
import com.moon.vip.service.sys.IEmployeePasswordService;

/**
 * 类名称：TestIEmployeePasswordServiceImpl.java<br/>
 * 日期：2015年12月24日 下午4:59:23<br/>
 * 类描述：单元测试修改密码<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * @author 向新</a><br/>
 * @version 1.0.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestIEmployeePasswordServiceImpl {
	
	@Autowired
	private IEmployeePasswordService employeePassword;
	
	@Test
	public void testUpdatePasswordById(){
		//String newPwd=Base64Utils.encodeToString("123456".getBytes());
		//String oldPwd=Base64Utils.encodeToString("666666".getBytes());
		EmployeePasswordVO password = new EmployeePasswordVO();
		//password.setNewPwd(newPwd);
		//password.setOldPwd(oldPwd);
		password.setEmployeeCode("01022");
		/*int i=employeePassword.updatePasswordById(password);*/
		System.out.println(password);
		/*if(i>0){
			System.out.println("修改成功");
		}*/
	}
}
