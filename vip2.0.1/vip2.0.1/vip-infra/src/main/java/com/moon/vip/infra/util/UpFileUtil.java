package com.moon.vip.infra.util;
import org.springframework.stereotype.Component;



/**
 * 类名称：UploadUtil.java<br/>
 * 日期：2015年9月24日 下午8:12:04<br/>
 * 类描述：上传工具类<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年9月24日 cGod TODO<br/>
 * @author <a href="Email:244976837@qq.com">cGod</a><br/>
 * @version 1.0.0
 */
@Component
public class UpFileUtil {

	/*@Autowired
	private IStoreProcess dfsStoreProcess;

	public HashMap<String, String> upload(HttpServletRequest request,List<Integer> sizes,String type) throws Exception {
		*//** 创建一个通用的多部分解析器**//*
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
				.getServletContext());
		HashMap<String, String> result=new HashMap<String, String>();
		*//**判断 request 是否有文件上传,即多部分请求**//*
		if (multipartResolver.isMultipart(request)) {
			*//** 转换成多部分request**//*
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			*//** 取得request中的所有文件名**//*
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				*//** 取得上传文件**//*
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					*//** 取得输出流**//*
					InputStream in = file.getInputStream();
					*//**文件别名**//*
					String originName = file.getName();
					*//** 取得上传file名称**//*
					String myFileName = file.getOriginalFilename();
					*//** 取得上传文件后缀名**//*
					String fileExtName = myFileName.substring(myFileName.lastIndexOf(".") + 1);
					HashMap<Integer, String> attribute = new HashMap<Integer, String>();
					*//**根据size里面的数据进行压缩图片**//*
					if(null!=sizes&&sizes.size()>=1){
						for(Integer size:sizes){
							attribute.put(size, fileExtName);
						}
					}
					*//** 存取上传文件*//*
					if(type.equals("img")){
						String urls = dfsStoreProcess.store(in, fileExtName, attribute);
						result.put("urls", urls);
					}else if(type.equals("file")){
						String urls=dfsStoreProcess.fileStore(in, fileExtName);
						result.put("urls", urls);
						result.put("fileName", myFileName);
						result.put("originName", originName);
					}
				}
			}
		}
		return result;
	}
	
	public int deleteFile(String path,Map<String, String> attribute) throws Exception{
		
		return dfsStoreProcess.delete(path, attribute);
	}*/
}