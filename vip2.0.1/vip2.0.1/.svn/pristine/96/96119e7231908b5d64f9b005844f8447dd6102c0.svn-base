package com.moon;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.infra.vo.questionnaire.EmployeeVO;
import com.moon.vip.infra.vo.questionnaire.QuestionnaireVO;
import com.moon.vip.service.questionnaire.IQuestionnaireService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class QuestionnaireTest {

	@Autowired
	private IQuestionnaireService iQuestionnaireService;
	
	/***删除***/
	@Test
	public void deleteQuestionnaire1(){
	   int id =10;
	   int i = iQuestionnaireService.deleteQuestionnaire(id);
	   System.out.println(i);
	}
	
	
	/***查询所有***/
	@Test
	public void selectByRoleDate(){
//		List<QuestionnaireVO> questionnaireVOs =iQuestionnaireService.selectByRoleDate();
//		for (QuestionnaireVO questionnaireVO : questionnaireVOs) {
//			System.out.println(questionnaireVO);
//		}
	}
	
	/***修改***/
	@Test
	public void updateByRoleDate(){
	   QuestionnaireVO questionnaireVO =new QuestionnaireVO();
	   questionnaireVO.setId(8);
//	   questionnaireVO.setBad(10);
//	   questionnaireVO.setExcellent(45);
//	   questionnaireVO.setGood(35);
//	   questionnaireVO.setMedium(10);
	   questionnaireVO.setAnnexAddress("aaa");
	   questionnaireVO.setModifyUser("01053");
	   int i = iQuestionnaireService.updateByRoleDate(questionnaireVO);
	   System.out.println(i);
	}
	
	
	/****添加数据***/
	@Test
	public void insertByRoleDate(){
	   QuestionnaireVO questionnaireVO =new QuestionnaireVO();
	   questionnaireVO.setOpProIds("1-12-12");
	   questionnaireVO.setAnnexAddress("dfgdsg");
//	   questionnaireVO.setBad(34);
	   questionnaireVO.setCreateTime(new Date());
	   questionnaireVO.setTecherCode("00000");
	   questionnaireVO.setCreator("00000");
	   int i = iQuestionnaireService.insertByRoleDate(questionnaireVO);
	   System.out.println(i);
	}
	
	/****
	 * 1.根据讲师昵称查询工号和姓名
	 * 2.根据工号查询昵称和姓名
	 * ***/
	@Test
	public void selectByNikeName(){
		String nickName ="大枫";
        String employeeCode ="01053";
		EmployeeVO	employeeVO = iQuestionnaireService.selectByNikeName(nickName);
        EmployeeVO	employee = iQuestionnaireService.selectByCode(employeeCode);
		System.out.printf("employeeVO"+employeeVO);
		System.out.println("employee:"+employee);
	}
	
}
