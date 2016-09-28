package com.moon;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.moon.vip.infra.constants.IsValidType;
import com.moon.vip.infra.vo.student.CodeTableVO;
import com.moon.vip.infra.vo.student.CourseVO;
import com.moon.vip.infra.vo.student.StuProfessionalVO;
import com.moon.vip.infra.vo.student.StudentCodeVO;
import com.moon.vip.infra.vo.student.StudentVO;
import com.moon.vip.service.student.IProfessionalService;
import com.moon.vip.service.student.IRepeatStudentService;
import com.moon.vip.service.student.IStudentArchivesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class StudentTest {

	@Autowired
	private IStudentArchivesService iStudentArchivesService;
	
	@Autowired
	private IProfessionalService iProfessionalService;
	@Autowired
	private IRepeatStudentService iRepeatStudentService;
	
	
	
	/***学员信息展示列表***/
	@Test
	public void selectAllStudent(){
		StudentVO student =new StudentVO();
		List<StudentVO> studentVO = iStudentArchivesService.selectAllStudent(student);
		for (StudentVO studentVO2 : studentVO) {
			int i =iStudentArchivesService.selectIsRefund(studentVO2.getId());
			if(i >0){
				studentVO2.setIsArrears("是");
			}else{
				studentVO2.setIsArrears("否");
			}
			System.out.println("名字："+studentVO2.getStuName()+",手机："+studentVO2.getTelephone()
					+",qq："+studentVO2.getQQ()+",报名时间"+studentVO2.getEnterDate()+",是否欠款:"+studentVO2.getIsArrears());
		}
	}
	
	/***查看详情***/
//	@Test
//	public void selectStuDetail(){
//		/****根据学员id查询个人信息详情**/
//		StudentVO studentVO=iStudentArchivesService.selectStuDetail(1);/*缺少学历和职业*/
//		CodeTableVO codeKey =new CodeTableVO();
//		codeKey.setDegree(studentVO.getEducationBackgroundKey());/**学历key**/
//		codeKey.setProfessional(studentVO.getOccupationCodeKey());/**职业key**/
//		List<CodeTableVO> codeTableVO =iStudentArchivesService.selectByCodeTable(codeKey);/**从码表获取学历和职业**/
//		/***学历和职业赋值组合***/
//		for (CodeTableVO codeTable : codeTableVO) {
//			if(codeTable.getType().equals(IsValidType.TYPE_DEGREE)){
//				studentVO.setEducationBackgroundValue(codeTable.getCodeValue());
//			}else if(codeTable.getType().equals(IsValidType.TYPE_PROFESSIONAL)){
//				studentVO.setOccupationCodeValue(codeTable.getCodeValue());
//			}
//		}
//		System.out.println(studentVO);
//		/***根据学员id获取专业信息***/
//		List<CourseVO> student=iStudentArchivesService.selectCourseDetail(1);/*专业详情*/
//		for (CourseVO studentVO2 : student) {
//			
//			/***********************支付方式和退费原因Start**********************************/
//			codeKey.setRefundReason(studentVO2.getRefundReasonKey());/**退费原因Key**/
//			codeKey.setPayment(studentVO2.getPayMethodKey());/**支付方式Key**/
//			List<CodeTableVO> codeTable =iStudentArchivesService.selectByCodeTable(codeKey);
//			for (CodeTableVO codeTableVO2 : codeTable) {
//				if(codeTableVO2.getType().equals(IsValidType.TYPE_PAYMENT)){
//					studentVO2.setPayMethodValue(codeTableVO2.getCodeValue());
//				}else if(codeTableVO2.getType().equals(IsValidType.TYPE_REFUND_REASON)){
//					studentVO2.setRefundReasonVlaue(codeTableVO2.getCodeValue());
//				}
//			}
//			System.out.println(student);
//			/************************支付方式和退费原因end********************************/
//		}
//	}
	
	/****修改学员信息***/
	@Test
	public void updateStuArchives(){
		StudentVO studentVO = new StudentVO();
		//studentVO.setID(1);
		studentVO.setSex("女");
		studentVO.setModifyTime(new Date());
		studentVO.setModifyUser("01053");
		int i =iStudentArchivesService.updateStuArchives(studentVO);
		System.out.println();
		System.out.println(i);
	}
	
	/***修改专业信息表****/
	@Test
	public void updateStuProfessional(){
		StuProfessionalVO stuProfessionalVO = new StuProfessionalVO();
		int i=iStudentArchivesService.updateStuProfessional(stuProfessionalVO);
		System.out.println(i);
	}
	
	/****添加学员信息表****/
	@Test
	public void insertStuArchives(){
		StudentVO studentVO = new StudentVO();
		StudentCodeVO studentCodeVO = new StudentCodeVO();
		//StuProfessionalVO stuProfessionalVO = new StuProfessionalVO();
		studentVO.setStuName("韩风");
		studentVO.setNameSpell("hanfeng");
		studentVO.setBirthday(new Date());
		studentVO.setPostalCode("432522");
		StudentCodeVO studentCode = iStudentArchivesService.selectStudentCodeMax();/****查询编号最大值****/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		if(studentCode !=null){
			/***查询数据不为空的时候，就更新一条数据****/
			studentCodeVO.setId(studentCode.getId());
			studentCodeVO.setStudentCodeNumber(studentCode.getStudentCodeNumber()+1);
		    int bb=iStudentArchivesService.updateStudentCodeMax(studentCodeVO);
		    System.out.println(bb);
		    /***生成学员编号***/
		    if(studentCode.getStudentCodeTime().after(new Date()) == false){
				String s=sdf.format(new Date());
				String[] b =s.split("-");
				String a = b[0]+b[1]; 
				studentVO.setCodeNo("TZs"+a+studentCodeVO.getStudentCodeNumber());
				System.out.println("11:"+studentVO.getCodeNo());
			}
		}else{
			/***为空的时候添加一条数据***/
			studentCodeVO.setStudentCodeTime(new Date());
			int j = iStudentArchivesService.insertStudentCodeMax(studentCodeVO);
			System.out.println(j);
		}
		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//		if(studentCode.getStudentCodeTime().after(new Date()) == false){
//			String s=sdf.format(new Date());
//			String[] b =s.split("-");
//			String a = b[0]+b[1]; 
//			studentVO.setCodeNo("TZs"+a+studentCodeVO.getStudentCodeNumber());
//			System.out.println("11:"+studentVO.getCodeNo());
//		}else{
		   /***获取专业编号***/
//		   ProfessionalVO professionalVO = iProfessionalService.selectCoursePrefix("JAVA");
//		   professionalVO.getCodeKey();
//		   String aa=sdf.format(studentCode.getStudentCodeTime());
//		   String[] cc=aa.split("-");
//		   String aaa=cc[0]+cc[1];
//		   stuProfessionalVO.setProfessionCode( professionalVO.getCoursePrefix()+aaa+studentCode.getStudentCourseNumber());
//		   System.out.println("2:"+stuProfessionalVO.getProfessionCode());
		//}
		
     	//int i=iStudentArchivesService.insertStuArchives(studentVO);
     	//System.out.println(i);
	}
	
	@Test
	public void ssdgdfgdf(){
	  StudentCodeVO codeVO = iStudentArchivesService.selectStudentCodeMax();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String aa="2016-01";
		String s=sdf.format(new Date());
		String[] sss=s.split("-");
		String[] aaa=aa.split("-");
		System.out.println(Integer.valueOf(aaa[0])==Integer.valueOf(sss[0]));
		System.out.println(Integer.valueOf(aaa[0])<=Integer.valueOf(sss[0]));
		System.out.println(Integer.valueOf(aaa[0])-Integer.valueOf(sss[0])==0);
		if(Integer.valueOf(aaa[0])<Integer.valueOf(sss[0])){
			System.out.println(Integer.valueOf(aaa[0]));
			System.out.println(Integer.valueOf(sss[0]));
			System.out.println(Integer.valueOf(aaa[0]).equals(Integer.valueOf(sss[0])));
			System.out.println(Integer.valueOf(aaa[0])==Integer.valueOf(sss[0]));
		}
	}
	
	@Test
	public void ssdgdfgdfsdfs(){
		BigDecimal amt= new BigDecimal("0"); 

		int i=amt.compareTo(BigDecimal.ZERO); 
		   if(i==-1){ 
		//amt小于0  例如：amt=-10.00 
			   System.out.println("3242:"+i);
		         } 
		   if(i==0){ 
		//amt等于0，  amt=0.00 
			   System.out.println("32:"+i);
		         } 
		   if(i==1){ 
			   System.out.println("333:"+i);
		//amt大于0  例如：amt=10.00 
		} 


		if(amt.equals(BigDecimal.ZERO)){ 
			System.out.println("433:"+amt.equals(BigDecimal.ZERO));
		}

	}
	
	
	
	@Test
	public void ssss(){
		String courseList ="[{\"studentId\":473,\"opProId\":121,\"enterDate\":\"2016-01-13\",\"amountPayable\":\"555\",\"payMethod\":\"all\",\"payment\":\"555\",\"statues\":\"\",\"isRefund\":\"\",\"arrears\":\"0\",\"refundMonetary\":\"\",\"remark\":\"\"},{\"studentId\":473,\"opProId\":122,\"enterDate\":\"2016-01-13\",\"amountPayable\":\"66\",\"payMethod\":\"staging\",\"payment\":\"6\",\"statues\":\"\",\"isRefund\":\"\",\"arrears\":\"0\",\"refundMonetary\":\"\",\"remark\":\"\"}]";
		List<CourseVO> course = JSON.parseArray(courseList, CourseVO.class);
		System.out.println(course.toString());
	}
	
	
	@Test
	public void publ() {
		int aa  = 1;
        for(int i=aa;i<10;i++){
           int c=i;
           if(c>5 && c<7){
        		System.out.println("j434"+i);
        		return;
        	}
           System.out.println(c);
        }		
	}
}
