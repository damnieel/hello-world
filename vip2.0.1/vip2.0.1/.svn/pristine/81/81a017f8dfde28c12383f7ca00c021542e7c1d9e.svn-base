package com.moon.vip.controller.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.controller.uploadStudentData.UploadFileUtil;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.Message;
import com.moon.vip.infra.vo.student.StudentClassVO;
import com.moon.vip.infra.vo.student.StudentFilesVO;
import com.moon.vip.infra.vo.student.StudentLearnStateVO;
import com.moon.vip.infra.vo.student.StudentProfessionalVO;
import com.moon.vip.infra.vo.sys.SearchVO;
import com.moon.vip.model.student.StudentProfessional;
import com.moon.vip.model.student.StudentProfessionalAttach;
import com.moon.vip.service.student.IStudentFilesService;

/**
 * 
* @ClassName: StudentFileController 
* @Description: TODO(学员档案)  
* @Param:   
* @author qingyu <a href="mailto:2190234029@qq.com">dengrihui</a>
* @date 2016年1月4日 上午11:34:34 
*
 */
@Controller
@RequestMapping("/studentFile")
public class StudentFileController extends BaseController{
	private static Logger logger = Logger.getLogger(StudentFileController.class);
	@Autowired
	private IStudentFilesService iStudentFilesService;
	@Autowired	
	private UploadFileUtil upload;
	
	private final static String CONTRACT="contract";
	private final static String CERTIFICATE="certificate";
	private final static String UPFILE="file";
	private final static String IMAGE="img";
	private final static String SUCCESS="success";
	private final static String FAIL="fail";
	@RequestMapping(value ="/showPage")
	private ModelAndView showPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/student/stuFile");
		return mv;
	}
	
	@RequestMapping("/queryFilesTotalRecord")
	@ResponseBody
	private int queryFilesTotalRecord(SearchVO param){
		param.setOpClaIds(achieveAuth());
		int count=iStudentFilesService.selectTotalRecord(param);
		return count;
	}
	
	@RequestMapping("/queryFilesTemplate")
	@ResponseBody
	private ModelAndView queryFilesTemplate(SearchVO param){
		ModelAndView mv = new ModelAndView();
		param.setOpClaIds(achieveAuth());
		List<StudentFilesVO> list=iStudentFilesService.getAllFileInfo(param);
		mv.addObject("studentFile", list);
		mv.setViewName("/page/student/stuFileTemple");
		return mv;
	}
	/**
	 * 
	* @Title: personInfoFirst 
	* @Description: TODO(学员档案第一个页面) 
	* @param     
	* @return  ModelAndView  返回类型 
	* @throws  
	* @author  青羽
	* @date 2016年1月6日 下午4:53:19
	 */
	@RequestMapping("/personInfoFirst/{studentId}/{stuId}/{opProId}")
	@ResponseBody
	private ModelAndView personInfoFirst(@PathVariable Integer studentId,@PathVariable Integer stuId,@PathVariable Integer opProId){
		ModelAndView mv = new ModelAndView();
		StudentFilesVO studentFile=iStudentFilesService.getStudentFilesInfo(studentId);
		mv.addObject("studentFile", studentFile);
		mv.setViewName("/page/student/personInfoFirst");
		return mv;
	}
	
	@RequestMapping("/saveStudyBasis")
	@ResponseBody
	private int saveStudyBasis(String stuBasis,int id){
		
		return iStudentFilesService.updateStudyBasis(id,stuBasis);
	}
	/**
	 * 
	* @Title: personInfoSecond 
	* @Description: TODO(第二页的数据交互) 
	* @param     
	* @return  ModelAndView  返回类型 
	* @throws  
	* @author  青羽
	* @date 2016年1月11日 下午9:14:17
	 */
	@RequestMapping("/personInfoSecond/{studentId}/{stuId}/{opProId}")
	@ResponseBody
	private ModelAndView personInfoSecond(@PathVariable Integer studentId,@PathVariable Integer stuId,@PathVariable Integer opProId){
		EmployeeLoginVO employee = super.getUserInfo();
		ModelAndView mv = new ModelAndView();
		mv.addObject("stuId", stuId);
		mv.addObject("studentId", studentId);
		mv.addObject("opProId", opProId);
		StudentLearnStateVO  sls=iStudentFilesService.getLearningStateInfo(studentId);
		sls.setModifyUser(employee.getNickName());
		List<StudentClassVO> scList=iStudentFilesService.getStudentClassInfo(stuId);
		mv.addObject("scList", scList);
		mv.addObject("sls", sls);
		mv.setViewName("/page/student/personInfoSecond");
		return mv;
	}
	
	@RequestMapping("/savaLearnState")
	@ResponseBody
	private Message savaLearnState(StudentProfessional record,StudentProfessionalVO stuVo){
		Message msg=new Message();
		String scId = null,scVal = null;
		scId=stuVo.getScStrId();
		scVal=stuVo.getScStrVal();
		record.setEndDate(stuVo.getStrEndDate());
		record.setModifyTime(stuVo.getStrModifyTime());
		if(StringUtils.isEmpty(scId)||StringUtils.isEmpty(scVal)){
			msg=iStudentFilesService.updateLearningStateInfo(record);
			return msg;
		}
		String[] strArray=scId.split(",");
		List<String> strList =  Arrays.asList(strArray);
		
		List<Integer> idList=new ArrayList<Integer>();
		List<Double> scList=new ArrayList<Double>();
		try{
			for(String str:strList){
				idList.add(Integer.parseInt(str));
			}
			strArray=scVal.split(",");
			strList = Arrays.asList(strArray);
			for(String str:strList){
				scList.add(Double.parseDouble(str));
			}
			msg=iStudentFilesService.updateLearningStateInfo(record, idList, scList);
			return msg;
		}catch(NumberFormatException e){
			msg.setResult(FAIL);
			msg.setMsg("分数请填数字");
			return msg;
		}catch (Exception e) {
			msg.setResult(FAIL);
			msg.setMsg("请检查数据是否合法");
			return msg;
		}
	}
	
	
	/**
	 * 
	* @Title: personInfoSecond 
	* @Description: TODO(第三页的数据交互) 
	* @param     
	* @return  ModelAndView  返回类型 
	* @throws  
	* @author  青羽
	* @date 2016年1月11日 下午9:14:17
	* studentId vip_student_professional ID
	* stuId    vip_student_archives  ID
	* opProId  vip_organizational_professional  ID
	 */
	@RequestMapping("/personInfoThird/{studentId}/{stuId}/{opProId}")
	@ResponseBody
	private ModelAndView personInfoThird(@PathVariable Integer studentId,@PathVariable Integer stuId,@PathVariable Integer opProId){
		ModelAndView mv = new ModelAndView();
		mv.addObject("stuId", stuId);
		mv.addObject("studentId", studentId);
		mv.addObject("opProId", opProId);
		StudentFilesVO idCard=iStudentFilesService.getIdCardPic(studentId);
		mv.addObject("idCard", idCard);
		mv.setViewName("/page/student/personInfoThird");
		return mv;
	}
	/**
	 * 
	* @Title: personInfoSecond 
	* @Description: TODO(第四页的数据交互) 
	* @param     
	* @return  ModelAndView  返回类型 
	* @throws  
	* @author  青羽
	* @date 2016年1月11日 下午9:14:17
	 */
	@RequestMapping("/personInfoFourth/{studentId}/{stuId}/{opProId}")
	@ResponseBody
	private ModelAndView personInfoFourth(@PathVariable Integer studentId,@PathVariable Integer stuId,@PathVariable Integer opProId){
		ModelAndView mv = new ModelAndView();
		mv.addObject("stuId", stuId);
		mv.addObject("studentId", studentId);
		mv.addObject("opProId", opProId);
		List<StudentProfessionalAttach> attachList=	iStudentFilesService.queryProfessionalAttach(studentId,CONTRACT);
		mv.addObject("attachList", attachList);
		mv.setViewName("/page/student/personInfoFourth");
		return mv;
	}
	/**
	 * 
	* @Title: personInfoSecond 
	* @Description: TODO(第五页的数据交互) 
	* @param     
	* @return  ModelAndView  返回类型 
	* @throws  
	* @author  青羽
	* @date 2016年1月11日 下午9:14:17
	 */
	@RequestMapping("/personInfoFifth/{studentId}/{stuId}/{opProId}")
	@ResponseBody
	private ModelAndView personInfoFifth(@PathVariable Integer studentId,@PathVariable Integer stuId,@PathVariable Integer opProId){
		ModelAndView mv = new ModelAndView();
		mv.addObject("stuId", stuId);
		mv.addObject("studentId", studentId);
		mv.addObject("opProId", opProId);
		List<StudentProfessionalAttach> attachList=	iStudentFilesService.queryProfessionalAttach(studentId,CERTIFICATE);
		mv.addObject("attachList", attachList);
		mv.setViewName("/page/student/personInfoFifth");
		return mv;
	}
	
	@RequestMapping(value="/upLoadProAttach/{id}",method ={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	private Message upLoadProAttach(@PathVariable("id") Integer id,HttpServletRequest request,String type){
		StudentProfessionalAttach attach=new StudentProfessionalAttach();
		EmployeeLoginVO employee = super.getUserInfo();
		Message msg=new Message();
		try {
			 if(!type.equals(CONTRACT)&&!type.equals(CERTIFICATE)){
				 msg.setResult(FAIL);
				 msg.setMsg("系统异常，请稍后再试");
				 return msg;
			 }
			 Map<String, String> urlMap=new HashMap<String, String>();
			 if(type.equals(CONTRACT)){
				 urlMap=upload.upload(request, null,UPFILE);
			 }else if(type.equals(CERTIFICATE)){
				 urlMap=upload.upload(request, null,IMAGE);
			 }
			 String urls=urlMap.get("urls");
			 String originName= urlMap.get("fileName");
			 if(StringUtils.isEmpty(urls)&&StringUtils.isEmpty(originName)){
				 msg.setResult(FAIL);
				 msg.setMsg("系统异常，请稍后再试");
				 return msg;
			 }
			 attach.setUrlAddress(urls);
			 attach.setName(originName);
			 attach.setType(type);
			 attach.setCreateTime(new Date());
			 attach.setSpId(id);
			 attach.setCreator(employee.getEmployeeCode());
			 int result=iStudentFilesService.insertProfessionalAttach(attach);
			 if(result<1){
				 msg.setResult(FAIL);
				 msg.setMsg("系统异常，请稍后再试");
				 return msg;
			 }
			 msg.setResult(SUCCESS);
			 msg.setMsg("上传文件成功");
			 return msg;
		} catch (Exception e) {
			logger.error(e);
			msg.setResult(FAIL);
			msg.setMsg("上传文件失败，请检查上传文件类型是否合格");
			return msg;
		}
	}
	
	@RequestMapping("/deleteAttach/{attachId}")
	@ResponseBody
	private int deleteAttach(@PathVariable Integer attachId){
		
		return iStudentFilesService.deleteProfessionalAttach(attachId);
	}
	
}
