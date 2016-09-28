package com.moon.vip.infra.util;

public class DigitUtil {
	
	/**
	 * 正则匹配传入的字符串是否是数字
	 * @param str
	 * @return boolean, isDigit return true, isnotDigit return false
	 */
	public static boolean isDigit(String str){
		if(str == null)
			return false;
		
		return str.matches("^[0-9,.]*$");
	};

	public static boolean isInteger(String str){
		if(str == null)
			return false;
		return str.matches("^[0-9]*$");
	}
}
