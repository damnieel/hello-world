package com.moon.vip.service.impl.sys;



import java.util.Date;
import java.util.List;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.infra.vo.sys.OrganizationalProfessionalVO;
import com.moon.vip.service.sys.IClassInFoService;

/**
 * 类名称：TestClassInFoServiceImpl.java<br/>
 * 日期：2016年1月5日 上午10:55:23<br/>
 * 类描述：班级信息的测试<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * @author 龙金</a><br/>
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestClassInFoServiceImpl {
	@Autowired
	private IClassInFoService classinfo;
	@Test
	public void selectColony(){
		List<OrganizationalProfessionalVO> list=classinfo.selectColony();
	    System.out.println(list);
	    System.out.println("查询成功1！");
	}
	@Test
	public void selectDivision(){
		List<OrganizationalProfessionalVO> list=classinfo.selectDivision();
		System.out.println(list);
		System.out.println("查询成功2");
	}
	@Test
	public void selectMajor(){
		List<OrganizationalProfessionalVO> list=classinfo.selectMajor();
		System.out.println(list);
		System.out.println("查询成功3");
	}
	@Test
	public void selectClass(){
		List<OrganizationalProfessionalVO> list=classinfo.selectClass();
		System.out.println(list);
		System.out.println("查询成功4");
	}
	@Test
	public void addClass(){
		OrganizationalProfessionalVO op=new OrganizationalProfessionalVO();
		op.setType("cla");
		op.setName("Java11班");
		op.setOrganizateOrder(79);
		op.setIsValid("Y");
		op.setStartDate(null);
		op.setEndDate(null);
		op.setCreateTime(new Date());
		op.setCreator("0");
        op.setModifyTime(null);
		int i=classinfo.addClass(op);
		System.out.println(i);
	}
	
	@Test 
	public void updateClass(){
		OrganizationalProfessionalVO op=new OrganizationalProfessionalVO();
		op.setType("cla");
		op.setName("ffghf");
		op.setStartDate(new Date());
		op.setEndDate(null);
		int i=classinfo.updateClass(op);
		System.out.println(i);
	}
	
	@Test
	public void delClass(){
		int id=195;
		int i=classinfo.delClass(id);
		System.out.println(i);
		
	}
	
}

