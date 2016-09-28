package com.moon.vip.controller.uploadStudentData;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.moon.commons.external.dfs.IStoreProcess;
import com.moon.platform.commons.util.BlankUtil;

@Component
public class UploadUtil {

	@Autowired
	private IStoreProcess dfsStoreProcess;

	public Map<String, String> upload(HttpServletRequest request,List<Integer> sizes) throws Exception {
		Map<String, String> fileName = new HashMap<String, String>();
		/** 创建一个通用的多部分解析器**/
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
				.getServletContext());
		String urls = null;
		/**判断 request 是否有文件上传,即多部分请求**/
		if (multipartResolver.isMultipart(request)) {
			/** 转换成多部分request**/
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			/** 取得request中的所有文件名**/
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				/** 取得上传文件**/
				MultipartFile file = multiRequest.getFile(iter.next());
				String s = null;
				if (file != null) {
					s = file.getName();
					/** 取得输出流**/
					InputStream in = file.getInputStream();
					/** 取得上传文件名称**/
					String myFileName = file.getOriginalFilename();
					/** 取得上传文件后缀名**/
					String fileExtName = myFileName.substring(myFileName.lastIndexOf(".") + 1);
					HashMap<Integer, String> attribute = new HashMap<Integer, String>();
					/**根据size里面的数据进行压缩图片**/
					if(null!=sizes&&sizes.size()>=1){
						for(Integer size:sizes){
							attribute.put(size, fileExtName);
						}
					}
					if(BlankUtil.isAnyBlank(myFileName,fileExtName)){
						/** 存取上传文件*/
						urls="";
					}else{
						urls = dfsStoreProcess.store(in, fileExtName, attribute);
					}
				}
				if(BlankUtil.isBlank(s)){
					s="url";
				}
				fileName.put(s, urls);
			}
		}
		
		
		return fileName;
	}
}