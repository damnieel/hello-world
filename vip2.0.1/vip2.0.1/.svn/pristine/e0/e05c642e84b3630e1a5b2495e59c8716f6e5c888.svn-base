package com.moon.vip.infra.util;

/**
 * 正则匹配规则合集
 * RegExpUtil<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月12日-下午1:19:57 <BR>
 * @version 2.0.0
 *
 */
public class RegExpUtil {

	/**
	 * 仅仅匹配汉字，英文字母，数字<BR>
	 * 方法名：hasSpecailCharacter<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月12日-下午1:20:20 <BR>
	 * @param str
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static boolean isChineseOrDigitOrLetter(String str){
		if(str==null) return false;
		String pattern = "^[\\u4E00-\\u9FA5,A-Za-z0-9]+$";
		return str.matches(pattern);
	}
	
	/**
	 * 
	 * 仅仅匹配汉字，英文字母，数字,'@','.','_','-'<BR>
	 * 方法名：isChineseOrDigitOrLetterOrEmail<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月12日-下午3:48:12 <BR>
	 * @param str
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static boolean isChineseOrDigitOrLetterOrEmailExtends(String str){
		if(str==null) return false;
		String pattern = "^[\\u4E00-\\u9FA5,A-Za-z0-9,@,\\.,_,-]+$";
		return str.matches(pattern);
	}
	
	/**
	 * 匹配email地址<BR>
	 * 方法名：isEmail<BR>
	 * 创建人：lqc <BR>
	 * 时间：2015年12月12日-下午4:26:17 <BR>
	 * @param str
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  2.0.0
	 */
	public static boolean isEmail(String str){
		if(str==null) return false;
		String pattern = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		return str.matches(pattern);
	}
}
