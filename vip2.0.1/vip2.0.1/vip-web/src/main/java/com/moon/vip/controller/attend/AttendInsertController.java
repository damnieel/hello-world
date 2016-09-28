package com.moon.vip.controller.attend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;





import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.exception.AttendanceException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.attendance.AttendanceErrorVO;
import com.moon.vip.model.inspect.InspectDetail;
import com.moon.vip.service.attend.IAttendImportService;
import com.moon.vip.service.attend.IAttendInsertService;
import com.moon.vip.service.util.IExcelService;

/**
 * 
 * @ClassName: AttendInsertController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 陈海 - （怡宝 ）
 * @date 2015年12月24日 下午9:15:12
 *
 */
@Controller
@RequestMapping("admin/attendance")
public class AttendInsertController extends BaseController {
	@Autowired
	private IAttendImportService attendImportService;
	@Autowired
	private IAttendInsertService attendInsertService;
	@Autowired
	private IExcelService excelService;
	private static Logger logger = Logger.getLogger(AttendInsertController.class);
	private static final String PATH_KEY = "uploadPath";
	
	
	@RequestMapping("/updateAttend")
	@ResponseBody
     public String updateAttend(InspectDetail atrecord){
		EmployeeLoginVO emp = getUserInfo();
		atrecord.setCreator(emp.getEmployeeCode());
		atrecord.setCreateTime(new Date());
		try{
		 return attendInsertService.updateAttendRecord(atrecord);
		}catch(AttendanceException e){
			logger.error(e.getCode()+":"+e.getExceptionMsg());
			return e.getExceptionMsg();
		}catch (Exception e) {
			logger.error(String.format("更新考勤记录失败[%s]", atrecord),e);
			return "SYS_NO_KNOW_ERR";
		}
	}
	
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: uploadPage 
	* @Description: TODO(上传excel页面) 
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @date 2015年12月25日 下午1:59:46 
	* @throws
	 */
	
	@RequestMapping("/uploadpage")
	@ResponseBody
	public ModelAndView uploadPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/attendance/excelUpload");
		return mv;
	}
	
	
	
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: insertAttendRecords 
	* @Description: TODO(导入考勤记录) 
	* @param @param file
	* @return ModelAndView    返回类型 
	* @date 2015年12月25日 下午2:00:16 
	* @throws
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public ModelAndView insertAttendRecords(@RequestParam(value = "file", required = false) MultipartFile file) {
		ModelAndView mv = new ModelAndView();
		List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();
		List<AttendanceErrorVO> errRecords = new ArrayList<AttendanceErrorVO>(); //错误数据容器
		EmployeeLoginVO emp = getUserInfo();
		try {
			list = excelService.getExcel(file,PATH_KEY);  //获取excel数据
		    List<InspectDetail> targetList = attendImportService.changeList(list,errRecords,emp.getEmployeeCode(),emp.getId()); //转成目标模型，验证数据
		   if(errRecords.size() > 0){
			 logger.info(String.format("存在%s条错误数据",errRecords.size())); 
			 mv.addObject("errorList", errRecords);
			 mv.addObject("errorCode", null);
			 mv.setViewName("/page/attendance/errRecordTemp");
			 return mv;
		    }
		   attendImportService.insertAttendRecords(targetList, emp.getId()) ;
		} catch(BusinessException e){
			 String errMsg =e.getCode() + ":" + e.getExceptionMsg();
			 logger.error(errMsg);
			 mv.addObject("errorList", errRecords);
			 mv.addObject("errorCode", errMsg);
			 mv.setViewName("/page/attendance/errRecordTemp");
			 return mv;
		}
		  catch (AttendanceException e) {
			 String errMsg =e.getCode() + ":" + e.getExceptionMsg();
			 logger.error(errMsg);
			 mv.addObject("errorList", errRecords);
			 mv.addObject("errorCode", errMsg);
			 mv.setViewName("/page/attendance/errRecordTemp");
			 return mv;
		} catch (Exception e) {
			logger.error("未知异常",e);
			mv.setViewName("/page/error/error");
			mv.addObject("errormsg", "未知异常");
			mv.addObject("errorcode",e.toString());
			return mv;
		}
		return mv;
	}
	

}
