package com.moon.vip.controller.uploadStudentData;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.moon.reader.ExcelUtil;
import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.excel.UploadErrorVO;
import com.moon.vip.infra.vo.excel.UploadStudentVO;
import com.moon.vip.service.excel.IExcelService;

/**
 * 学员上传Controller
 * @ClassName: UploadStudentController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 大枫
 * @date 2015年12月29日 上午10:51:55 
 *
 */
@Controller
@RequestMapping("admin/upload")
public class UploadStudentController extends BaseController{
	
	@Autowired
	private IExcelService iExcelService;
	
	private Logger logger = Logger.getLogger(UploadStudentController.class);

	@RequestMapping("/stuDataUpload")
	public ModelAndView stuDataUpload() {
		logger.info("进入数据上传页面");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/page/sys/stuDataUpload");
		return modelAndView;
	}
	@RequestMapping("/uploadStudentData")
	public ModelAndView uploadStudentData(
			@RequestParam(value="file", required = false) MultipartFile file, RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		logger.info(String.format("员工(%s)上传文档%s", getUserCode(), file.getOriginalFilename()));
		ModelAndView modelAndView = new ModelAndView();
		if(file.getSize() == 0) {
			redirectAttributes.addFlashAttribute("Exception", "上传失败， 您没有选择文件");
			modelAndView.setViewName("redirect:toErrorPage.htmls");
			return modelAndView;
		}
		
		EmployeeLoginVO employ = (EmployeeLoginVO) request.getSession().getAttribute("employee");
		try {
			String url = iExcelService.getExcelFile(file, request);
			/**
			 * 将excel文件存储到list中
			 */
			ExcelUtil e = new ExcelUtil(url);
			logger.info("ExcelUtil初始化完毕");
			List<Map<Integer,String>> list = e.getSheetOfExcel(0,false);
			List<UploadStudentVO> studentList = iExcelService.readFromMap(list, employ.getEmployeeCode());
			List<UploadErrorVO> errorList = iExcelService.checkUploadData(studentList);
			iExcelService.deleteFile(url);
			if(errorList.size() == 0) {
				//判断是否有重复， 并插入标志位
				errorList = iExcelService.checkRepeatData(studentList);
				if(errorList.size() == 0) {
					//没有错误，向数据库插入数据		
					iExcelService.updataOrInsertStudentData(studentList);
					redirectAttributes.addFlashAttribute("Exception", "上传成功， 您可以在在读学员中查看上传信息");
				} else {
					redirectAttributes.addFlashAttribute("Exception", "上传失败，Excel数据与系统数据库有冲突信息");
					redirectAttributes.addFlashAttribute("errorList", errorList);			
				}
			} else {
				redirectAttributes.addFlashAttribute("Exception", "上传失败， Excel有数据错误信息");
				redirectAttributes.addFlashAttribute("errorList", errorList);
			}

			logger.info("错误list数据：" + errorList);
			logger.info("上传数据信息：" + studentList);
		} catch(IllegalArgumentException e) {
			logger.error("错误文档， 您的文档不是合法的xls文档， 请使用2003版Excel");
			redirectAttributes.addFlashAttribute("Exception", "错误文档， 您的文档不是合法的xls文档， 请使用2003版Excel(IllegalArgumentException)");
			modelAndView.setViewName("redirect:toErrorPage.htmls");
			return modelAndView;
		}   catch(IOException e) {
			logger.error("错误文档， 您的文档不是合法的xls文档， 请使用2003版Excel");
			redirectAttributes.addFlashAttribute("Exception", "错误文档， 您的文档不是合法的xls文档， 请使用2003版Excel(IOException)");
			modelAndView.setViewName("redirect:toErrorPage.htmls");
			return modelAndView;
		}  catch(NullPointerException e) {
			logger.error("错误文档， 空指针异常， 请检查后重新插入");
			redirectAttributes.addFlashAttribute("Exception", "错误文档， 请检查后重新插入");
			modelAndView.setViewName("redirect:toErrorPage.htmls");
			return modelAndView;
		} catch (BusinessException e) {
			logger.error(e);
			redirectAttributes.addFlashAttribute("Exception", e.getExceptionMsg());
			modelAndView.setViewName("redirect:toErrorPage.htmls");
			return modelAndView;
		} catch (Exception e) { 
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("Exception", (String) JSON.toJSON(e).toString());
			modelAndView.setViewName("redirect:toErrorPage.htmls");
			return modelAndView;
		}
		modelAndView.setViewName("redirect:toErrorPage.htmls");
		return modelAndView;
	}
	@RequestMapping("/toErrorPage")
	public String toErrorPage() {
		return "/page/uploadExcelErrorTemplate";
	}
}
