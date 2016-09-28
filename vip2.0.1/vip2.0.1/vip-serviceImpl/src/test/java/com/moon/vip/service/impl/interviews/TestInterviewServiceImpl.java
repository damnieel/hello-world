package com.moon.vip.service.impl.interviews;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.application.interviews.InterviewsMapper;
import com.moon.vip.application.interviews.InterviewsSqlMapper;
import com.moon.vip.application.sys.OPManagerSqlMapper;
import com.moon.vip.infra.vo.interviews.InterviewsVO;
import com.moon.vip.infra.vo.interviews.OPManagerVO;
import com.moon.vip.infra.vo.sys.SearchVO;
import com.moon.vip.model.interviews.Interviews;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestInterviewServiceImpl {
	
	@Autowired
	InterviewsSqlMapper interviewsSqlMapper;
	@Autowired
	InterviewsMapper interviewsMapper;
	@Autowired
	OPManagerSqlMapper oPManagerSqlMapper;
	@Test
	public void testSelect(){
		SearchVO searchVO=new SearchVO();
		List<InterviewsVO> list=interviewsSqlMapper.selectInterviewItems(searchVO);
		System.out.println(list);
	}
	
	@Test
	public void testSelectc(){
		SearchVO searchVO=new SearchVO();
		
		Integer result=interviewsSqlMapper.selectItemsCount(null);
		
		System.out.println(result);
	}
	@Test
	public void testInsert(){
		Interviews list=new Interviews();
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
		for(int i=0;i<3;i++){
			int result=interviewsMapper.insertSelective(list);
			System.out.println(result);
		}
		
	}
	@Test
	public void testDelete(){
		List<Integer> idList=new ArrayList<Integer>();
		idList.add(5);
		idList.add(7);
		idList.add(8);
		int result=interviewsSqlMapper.deleteInterviewsById((ArrayList<Integer>) idList);
		System.out.println(result);
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
	public void test1(){
		 List<InterviewsVO> list=interviewsSqlMapper.selectAddBaseInfoByQq("782469920");
		 System.out.println(list);
	}
	
	@Test
	public void test2(){
		 List<OPManagerVO> list=oPManagerSqlMapper.selectByProfessionId(121);
		 System.out.println(list);
	}
	@Test
	public void test3(){
		 System.out.println(interviewsSqlMapper.selectProfessionCode(121, "782469920"));
	}
	
}
