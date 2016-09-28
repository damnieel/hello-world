package com.moon.vip.service.impl.assignment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.service.assignment.IClassService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:META-INF/spring/root-test.xml"})
public class TestClassServiceImpl {
	@Autowired
	@Qualifier("classService")
	private IClassService classService;

	@Test
	public void testGetAllStudentsByClassId(){
		int classId= 191;
		System.out.println(classService.getAllStudentsByClassId(classId));
	}
}
