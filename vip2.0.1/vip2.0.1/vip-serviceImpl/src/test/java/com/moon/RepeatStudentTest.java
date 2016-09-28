package com.moon;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.infra.vo.student.RepeatStudentVO;
import com.moon.vip.service.student.IRepeatStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class RepeatStudentTest {

	@Autowired
	private IRepeatStudentService iRepeatStudentService;
	
	@Test
	public void selectRepeatStudent(){
		RepeatStudentVO repeatStudentVO = new RepeatStudentVO();
		repeatStudentVO.setOffset(0);
		repeatStudentVO.setPageSize(10);
	    List<RepeatStudentVO> repeatStudent = iRepeatStudentService.selectRepeatStudent(repeatStudentVO);
	    for (RepeatStudentVO repeatStudentVO2 : repeatStudent) {
	    	repeatStudentVO2.setProfessionCode(repeatStudentVO2.getProfessionCode());
	    	repeatStudentVO2.setStuName(repeatStudentVO2.getStuName());
	    	repeatStudentVO2.setEnterDate(repeatStudentVO2.getEnterDate());
	    	repeatStudentVO2.setStatues(repeatStudentVO2.getStatues());
	    	repeatStudentVO2.setCourse(repeatStudentVO2.getCourse());
	    	System.out.println(repeatStudentVO2);
		}
	}
	
//	@Test
//	public void updateStuProCode(){
//	     RepeatStudentVO repeatStudentVO = new RepeatStudentVO();
//	     repeatStudentVO.setId(85);
//	     repeatStudentVO.setProfessionCode("A20151210");
//	     int j = iRepeatStudentService.selectStuProCode(repeatStudentVO.getProfessionCode());
//	     System.out.println(j);
//	     if(j>=1){
//	    	System.out.println("有数据了");
//	     }else{
//	    	 int i = iRepeatStudentService.updateStuProCode(repeatStudentVO);
//	    	 System.out.println(i+"====ok");
//	     }
//	}
}
