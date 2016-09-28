package com.moon.vip.service.impl.onReadStudent;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.application.interviews.InterviewsMapper;
import com.moon.vip.application.interviews.InterviewsSqlMapper;
import com.moon.vip.application.student.ArchProfOrgProfClassSqlMapper;
import com.moon.vip.infra.vo.onReadPage.OnReadPageStudentsVO;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.model.interviews.Interviews;
import com.moon.vip.service.onReadStudent.IDivideGradeService;
import com.moon.vip.service.sys.roleManage.IRoleManageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestDivideGradeServiceImpl{

	@Autowired
	private ArchProfOrgProfClassSqlMapper archivesProfOrgProfClassSqlMapper;

	@Autowired
	IDivideGradeService iDivideGradeService;	
	@Autowired
	InterviewsSqlMapper interviewsSqlMapper;
	@Autowired
	InterviewsMapper interviewsMapper;
	@Autowired
	IRoleManageService iRoleManageService;

	@Test
	public void selectUndivStudent() {
		List<OnReadPageStudentsVO> s = iDivideGradeService.selectUndivStudent(null);
		System.out.println(s);
	}
	
	@Test 
	public void testselectGradeByStudentId() {
		ParamsVO paramsVO=new ParamsVO();
		paramsVO.setIdArray("166");
		paramsVO.setProfIdArray("122");
		Integer m = interviewsSqlMapper.selectByStudentId(166, 122);
		System.out.println(m);
	}
	@Test
	public void testUpdate(){
		Interviews list=new Interviews();
		list.setId(3);
		list.setOpProId(122);
		list.setStudentId(77);
		list.setTecherCode("00712");
		list.setInterviewerCode("01020");
		list.setLearnAimCode(5);
		list.setLearnAimContent("把妹子");
		list.setSuggest("没啥");
		list.setPuzzle("请讲快一点");
		list.setNote("数到三电话");
		list.setCreateTime(new Date());
		list.setCreator("01020");
		int result=interviewsMapper.updateByPrimaryKeySelective(list);
		System.out.println(result);
	}
	@Test
	public void test() {
		iRoleManageService.selectDataMenuByRoleId(0);
	}
}
