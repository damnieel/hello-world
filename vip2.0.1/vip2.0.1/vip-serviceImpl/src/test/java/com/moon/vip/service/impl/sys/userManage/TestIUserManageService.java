package com.moon.vip.service.impl.sys.userManage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.reader.ExcelUtil;
import com.moon.vip.application.sys.userManage.UserManagerSqlMapper;
import com.moon.vip.infra.vo.sys.roleManage.RoleDataOperVO;
import com.moon.vip.infra.vo.sys.userManage.UserManageVO;
import com.moon.vip.service.sys.roleManage.IRoleManageService;
import com.moon.vip.service.sys.userManage.IUserManageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestIUserManageService{

	@Autowired
	private IUserManageService iUserManageService;
	
	IRoleManageService iRoleManageService;
	
	@Test
	public void selectUserManageData() throws IOException {
		String url = "group1/M00/00/58/cEqFvVaQwY6AVz3xAABIAI3w0r4914.xls";
		ExcelUtil e = new ExcelUtil(url);
//		List<UserManageVO> l = iUserManageService.selectUserManageData();
//		System.out.println(l);
	}
	@Test
	public void selectUserManageDataCount() {
		RoleDataOperVO roleDataOperVO = new RoleDataOperVO();  
		roleDataOperVO.setId(1);
		roleDataOperVO.setOperType("select");
		roleDataOperVO.setRoleId(1);
		
		List<Integer> ruleList = new ArrayList<Integer>();
		ruleList.add(3);
		roleDataOperVO.setRuleIdList(ruleList);
		int k = iRoleManageService.selectOperType(roleDataOperVO);
		System.out.println(k);
	}
}
