package com.moon.vip.service.excel;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.moon.vip.infra.vo.excel.UploadErrorVO;
import com.moon.vip.infra.vo.excel.UploadStudentVO;

public interface IExcelService {
	
	/**
	 * 将从前端读取的excel map转化为<br/> 
	 * @Title: readFromMap <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月24日 下午6:52:12  <br/> 
	 * @param uploadStudentVO
	 * @return
	 * Map<String,Object>
	 * @throws ParseException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws  <br/>
	 */
	public List<UploadStudentVO> readFromMap(List<Map<Integer, String>> list, String string) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ParseException;
	
	/**
	 * 将file存储到系统路径upload，并返回地址<br/> 
	 * @Title: getExcelFile <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月25日 上午11:00:42  <br/> 
	 * @param file
	 * @param request
	 * @return
	 * String
	 * @throws  <br/>
	 */
	public String getExcelFile(MultipartFile file, HttpServletRequest request);
	
	/**
	 * 检查参数是否有内容错误<br/> 
	 * @Title: checkUploadData <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月25日 下午3:10:53  <br/> 
	 * @param list
	 * @return
	 * List<UploadStudentVO>
	 * @throws  <br/>
	 */
	public List<UploadErrorVO> checkUploadData(List<UploadStudentVO> list);
	
	/**
	 * 向数据库中更新或者插入数据<br/>  
	 * @Title: updataOrInsertStudentData <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月25日 下午4:45:54  <br/> 
	 * @param studentList
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int updataOrInsertStudentData(List<UploadStudentVO> studentList);

	/**
	 * 检查数据是否有与数据库冲突的地方<br/> 
	 * 更换全款、预定等数据信息为英文<br/>
	 * @Title: checkRepeatData <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月25日 下午6:51:21  <br/> 
	 * @param studentList
	 * @return
	 * List<UploadErrorVO>
	 * @throws  <br/>
	 */
	public List<UploadErrorVO> checkRepeatData(List<UploadStudentVO> studentList);

	/**
	 * 删除服务器文件<br/> 
	 * @Title: deleteFile <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月9日 下午4:47:27  <br/> 
	 * @param url
	 * @return
	 * boolean
	 * @throws  <br/>
	 */
	public boolean deleteFile(String url);
}
