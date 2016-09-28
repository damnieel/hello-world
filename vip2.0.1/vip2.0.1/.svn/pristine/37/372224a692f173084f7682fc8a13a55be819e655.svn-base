package com.moon.sqlTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.application.sys.DataRuleSqlMapper;
import com.moon.vip.infra.vo.sys.roleManage.EmpRoleRuleDataAct;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestDataRuleSqlMapper {

	@Autowired
	DataRuleSqlMapper DataRuleSqlMapper;
	
	@Test
	public void TestselectDataActByEmpId() {
		List<EmpRoleRuleDataAct> s = DataRuleSqlMapper.selectDataActByEmpId(1);
		System.out.println(s);
	}
}
