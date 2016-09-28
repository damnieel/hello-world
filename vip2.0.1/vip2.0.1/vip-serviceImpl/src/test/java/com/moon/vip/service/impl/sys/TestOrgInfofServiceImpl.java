package com.moon.vip.service.impl.sys;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.infra.vo.sys.orgManage.OrgBaseVO;
import com.moon.vip.service.sys.orgManage.IOrgInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestOrgInfofServiceImpl {
	
	@Autowired
	IOrgInfoService orgService;
	
	@Test
	public void testGetChildList(){
		List<OrgBaseVO> orgList = orgService.getChildOrgList(121);
		for(OrgBaseVO org: orgList){
			System.out.println(org.toString());
		}
	}
	
	@Test
	public void testGetParentList(){
		List<OrgBaseVO> orgList = orgService.getParentOrgList(191);
		for(OrgBaseVO org: orgList){
			System.out.println(org.toString());
		}
	}
	
	@Test 
	public void testGetParentAndChild(){
		List<OrgBaseVO> orgList = orgService.getParentAndChildList(0);
		for(OrgBaseVO org: orgList){
			System.out.println(org.toString());
		}
	}
	
	@Test
	public void testGetChildIdList(){
		List<Integer> orgList = orgService.getChildIdList(0);
		for(Integer org: orgList){
			System.out.print(org+",");	
		}
		System.out.println();
	}
	
	@Test
	public void testGetParentIdList(){
		List<Integer> orgList = orgService.getParentIdList(191);
		for(Integer org: orgList){
			System.out.print(org+",");
		}
		System.out.println();
	}
}
