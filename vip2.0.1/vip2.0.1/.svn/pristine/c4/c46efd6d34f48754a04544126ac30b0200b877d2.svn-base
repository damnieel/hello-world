package com.moon.vip.infra.util.checkUploadData;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.moon.vip.infra.vo.excel.UploadStudentVO;

public class DoCheckUtil {

	private static Logger logger = Logger.getLogger(DoCheckUtil.class);
	@SuppressWarnings("unchecked")
	public static Map<String, Object> doCheck(UploadStudentVO uploadStudentVO, Class CheckUtil, int begin) {
		Field dataFields[] = UploadStudentVO.class.getDeclaredFields();
		String fieldName = "";
		String checkMethodName = "";
		boolean result = false;
		boolean resultFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
	
		for(int i=begin; i<dataFields.length; i++) {
			fieldName = dataFields[i].getName();
			
			checkMethodName = "check" + 
					fieldName.substring(0,1).toUpperCase() + 
					fieldName.substring(1) + "Param";
			try {
				Method checkMethod = CheckUtil
							.getDeclaredMethod(checkMethodName, new Class[]{dataFields[i].getType()});
				dataFields[i].setAccessible(true); 				
				result = (Boolean) checkMethod.invoke(CheckUtil, dataFields[i].get(uploadStudentVO));
				if(!result) {
					//增加错误信息
					resultFlag = false;
					map.put(fieldName, dataFields[i].get(uploadStudentVO));
				}
				dataFields[i].setAccessible(false); 
			} catch (NoSuchMethodException e) {
//				logger.info("NoSuchMethodException: " + fieldName);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}		
			
		}
		map.put("result", resultFlag);
		return map;
	}
}
