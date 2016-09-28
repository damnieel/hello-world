package com.moon.vip.service.impl.student;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.application.student.StudentFilesMapper;
import com.moon.vip.infra.vo.student.StudentClassVO;
import com.moon.vip.infra.vo.student.StudentFilesVO;
import com.moon.vip.infra.vo.student.StudentLearnStateVO;
import com.moon.vip.infra.vo.sys.SearchVO;
import com.moon.vip.service.student.IStudentFilesService;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestStudentFilesServiceImpl {
	
	@Autowired 
	private IStudentFilesService iStudentFilesService;
	
	@Autowired 
	private StudentFilesMapper studentFilesMapper;
	
	@Test
	public void test1(){
		StudentFilesVO info=iStudentFilesService.getStudentFilesInfo(93);
		 System.out.println(info);
	}
	@Test
	public void test2(){
		//StudentLearnStateVO vo=iStudentFilesService.getLearningStateInfo(1);
		List<StudentClassVO> list =iStudentFilesService.getStudentClassInfo(1);
		//System.out.println(vo);
		System.out.println(list);
	}
	
	@Test
	public void test3(){
		StudentFilesVO info=iStudentFilesService.getIdCardPic(1);
		System.out.println(info);
	}
}
