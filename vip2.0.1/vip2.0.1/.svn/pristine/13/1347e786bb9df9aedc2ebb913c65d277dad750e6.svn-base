package com.moon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.application.student.StudentClassSqlMapper;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.infra.vo.student.ProfessionalVO;
import com.moon.vip.service.student.IProfessionalService;
/**
 * 职业数据测试
 * ProfessionalTest<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月26日-下午12:21:56 <BR>
 * @version 1.0.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class ProfessionalTest{
	
	@Autowired
	private IProfessionalService iProfessionalService;
	

	@Autowired
	StudentClassSqlMapper studentClassSqlMapper;
	
	/***获取下拉值****/
    @Test
	public void selectALLDownbox(){
		List<ProfessionalVO> professionalVO = iProfessionalService.selectALLDownbox();
		for (ProfessionalVO professionalVO2 : professionalVO) {
			if(professionalVO2.getType().equals("refund_reason")){
				professionalVO2.setCodeKey(professionalVO2.getCodeKey());
				professionalVO2.setCodeValue(professionalVO2.getCodeValue());
				System.out.println("key:"+professionalVO2.getCodeKey()+",====value:"+professionalVO2.getCodeValue());
			}
		}
	}
    
    /***搜索全部职业数据进行分页***/
    @Test
	public void selectAllProfessional(){
		List<ProfessionalVO> professionalVO = iProfessionalService.selectAllProfessional(0,1);
		for (ProfessionalVO professionalVO2 : professionalVO) {
				professionalVO2.setCodeKey(professionalVO2.getCodeKey());
				professionalVO2.setCodeValue(professionalVO2.getCodeValue());
				System.out.println("key:"+professionalVO2.getCodeKey()+",====value:"+professionalVO2.getCodeValue());
		}
	}
    
    /***添加职业数据***/
	@Test
	public void insertProfessional(){
		ProfessionalVO professional =new ProfessionalVO();
		ProfessionalVO professionalVO =iProfessionalService.selectMaxKey();
    	if(professionalVO !=null){
    		professional=professionalVO;
    		int a =Integer.valueOf(professional.getCodeKey())+1;
    		int b =professional.getCodeOrder()+1;
    		professional.setCodeKey(String.valueOf(a));
    		professional.setCodeValue("aa");
    		professional.setCodeOrder(b);
    	}else{
    		professional.setCodeKey("1");
    		professional.setCodeValue("安卓");
    		professional.setCodeOrder(1);
    	}
    	professional.setType("professional");
    	professional.setTypeName("职业");
    	professional.setCreateTime(new Date());
    	professional.setCreator("00839");
    	professional.setModifyTime(new Date());
    	professional.setIsValid("Y");
		int i = iProfessionalService.insertProfessional(professional);
		System.out.println("2222222:"+i);
	}
    
    /***批量删除职业数据***/
    @Test
	public void deleteProfessional(){
    	String id2 ="124,125";
    	String[] id1 =id2.split(",");
    	List<Integer> id =new ArrayList<Integer>();
    	for (int i = 0; i < id1.length; i++) {
			id.add(Integer.valueOf(id1[i]));
		}
    	int i =iProfessionalService.deleteProfessional(id);
		System.out.println(i);
	}
    
    /***更新职业数据***/
    @Test
    public void updateProfessional(){
    	ProfessionalVO professionalVO =new ProfessionalVO();
    	professionalVO.setCodeValue("java架构师");
    	professionalVO.setId(115);
        int i = iProfessionalService.updateProfessional(professionalVO);
        System.out.println(i);
    }
    
    
    /***查询专业前缀***/
//    @Test
//    public void selectCoursePrefix(){
//    	String course = "安卓";
//    	ProfessionalVO professionalVO = iProfessionalService.selectCoursePrefix(course);
//    	professionalVO.setCoursePrefix(professionalVO.getCoursePrefix());
//    	System.out.println(professionalVO.getCoursePrefix());
//    }
    
    /***查询所有下拉值***/
    @Test
    public void selectALLDownbox1(){
        List<ProfessionalVO> professionalVO = iProfessionalService.selectALLDownbox();
        for (ProfessionalVO professionalVO2 : professionalVO) {
			System.out.println("type:"+professionalVO2.getType()
					+"codeKey:"+professionalVO2.getCodeKey()+"codeValue:"+professionalVO2.getCodeValue()+"/n");
		}
    }
	
}
