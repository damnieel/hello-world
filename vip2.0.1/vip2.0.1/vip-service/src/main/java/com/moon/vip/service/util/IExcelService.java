package com.moon.vip.service.util;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
* @ClassName: IExcelService 
* @Description: TODO(用于获取Excel内容) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月25日 上午11:26:12 
*
 */
public interface IExcelService {

	List<Map<Integer, String>> getExcel(MultipartFile file, String pathKey);

}
