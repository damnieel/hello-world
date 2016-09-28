package com.moon.vip.service.impl.assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.infra.vo.homework.ClassHmworkVO;
import com.moon.vip.infra.vo.homework.ClassAndTeacherVO;
import com.moon.vip.infra.vo.homework.StudentHmworkVO;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;
import com.moon.vip.service.assignment.IHmworkService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:META-INF/spring/root-test.xml"})
public class TestHmworkServiceImpl {

	@Autowired
	@Qualifier("hmworkService")
	private IHmworkService hmworkService;
	
	@Test
	public void testSearchAllClassByDeptAndKeyPage(){
		SearchParamsWithDept searchParams = new SearchParamsWithDept();
//		searchParams.setStartNumber(0);
//		searchParams.setPageSize(10);
		searchParams.setOrgProCalId(121);
		searchParams.setSearchKey("");
		HashSet<Integer> opClaIdsSet = new HashSet<Integer>();
	/*	opClaIdsSet.add(3);*/
		opClaIdsSet.add(190);
		searchParams.setOpClaIds(opClaIdsSet);
		List<ClassAndTeacherVO> classList = hmworkService.searchAllClassByDeptAndKeyPage(searchParams);
		
		for(ClassAndTeacherVO classVO : classList){
			System.out.println(classVO.toString());
		}
		
		System.out.println(hmworkService.getCountAllClassByDeptAndKey(searchParams));
	}
	
	@Test
	public void testSeachAllHmworkRecordByClassIdPage(){
		SearchParamsWithDept searchParams = new SearchParamsWithDept();
		searchParams.setOrgProCalId(191);
		System.out.println(hmworkService.getCountAllHmworkRecordByClassId(searchParams));
		
		List<ClassHmworkVO> classhmworkVOList = hmworkService.seachAllHmworkRecordByClassIdPage(searchParams);
		for(ClassHmworkVO classHmworkVO : classhmworkVOList){
			System.out.println(classHmworkVO.toString());
		}
	
	}
	
	@Test
	public void testSaveHmworkRecord() throws ParseException{
		ClassHmworkVO classHmworkVO = new ClassHmworkVO();
		classHmworkVO.setClassId(191);
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		classHmworkVO.setCheckDate(sdformat.parse("2015-12-26"));
		classHmworkVO.setCreateTime(new Date());
		classHmworkVO.setProfessionId(121);
		classHmworkVO.setCreator("1");
		StudentHmworkVO studentHmworkVO = new StudentHmworkVO();
		studentHmworkVO.setStudentId(1);
		studentHmworkVO.setProfessionCode("J2015121");
		studentHmworkVO.setCheckStatus(0);
		classHmworkVO.getStudentHomeworkList().add(studentHmworkVO);
		studentHmworkVO = new StudentHmworkVO();
		studentHmworkVO.setStudentId(93);
		studentHmworkVO.setProfessionCode("J2015123");
		studentHmworkVO.setCheckStatus(1);
		classHmworkVO.getStudentHomeworkList().add(studentHmworkVO);
		hmworkService.saveHmworkRecord(classHmworkVO);
	}
	
	@Test
	public void testRemoveHmworkRecord() throws ParseException{
		ClassHmworkVO classHmworkVO = new ClassHmworkVO();
		classHmworkVO.setId(8);
		classHmworkVO.setClassId(191);
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		classHmworkVO.setOldCheckDate(sdformat.parse("2015-12-26"));
		classHmworkVO.setCheckDate(sdformat.parse("2015-12-25"));
//		classHmworkVO.setCreateTime(new Date());
//		classHmworkVO.setProfessionId(1);
//		classHmworkVO.setCreator("1");
//		StudentHmworkVO studentHmworkVO = new StudentHmworkVO();
//		studentHmworkVO.setStudentId(1);
//		studentHmworkVO.setProfessionCode("J2015121");
//		studentHmworkVO.setCheckStatus(1);
//		classHmworkVO.getStudentHomeworkList().add(studentHmworkVO);
		hmworkService.removeHmworkRecordById(classHmworkVO);
	}
	
	@Test
	public void testUpdateHmworkRecord() throws ParseException{
		ClassHmworkVO classHmworkVO = new ClassHmworkVO();
		classHmworkVO.setId(7);
		classHmworkVO.setClassId(191);
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		classHmworkVO.setOldCheckDate(sdformat.parse("2015-12-26"));
		classHmworkVO.setCheckDate(sdformat.parse("2015-12-26"));
		classHmworkVO.setCreateTime(new Date());
		classHmworkVO.setProfessionId(121);
		classHmworkVO.setCreator("1");
		StudentHmworkVO studentHmworkVO = new StudentHmworkVO();
		studentHmworkVO.setStudentId(1);
		studentHmworkVO.setProfessionCode("J2015121");
		studentHmworkVO.setCheckStatus(0);
		classHmworkVO.getStudentHomeworkList().add(studentHmworkVO);
		hmworkService.updateHmworkRecord(classHmworkVO);
	}
	
	@Test
	public void testGetAllStudentsHmworkBySacIds(){
		List<Integer> sacIds = new ArrayList<Integer>();
		sacIds.add(9);
		System.out.println(hmworkService.getAllStudentsHmworkBySacIds(sacIds));
	}
}
