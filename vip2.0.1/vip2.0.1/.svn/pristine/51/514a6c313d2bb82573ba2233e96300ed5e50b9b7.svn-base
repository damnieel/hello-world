/**
 *Description：提供部分字符串公用函数
 *Author：肖建军
 *Copyright版权所有
 */

package com.moon.vip.infra.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 获取<a>123</a>字符串中的123
	 * @param p_soure String
	 * @param p_tag String
	 * @return String
	 */
	public static String getConfigStr(String p_source,String p_tag){
		String record = p_source;
		String ret = "";
		int i1 ,i2;

		if(record.indexOf("<"+p_tag+">") >=0){
			i1 = record.indexOf("<"+p_tag+">");
			i2 = record.indexOf("</"+p_tag+">");
			if(i2 >=0){
				ret = record.substring(i1 + p_tag.trim().length() + 2, i2);
			}else{
				ret = "";
			}
		}
		return ret;
	}

	/**
	 * 取字符串的前toCount个字符
	 *
	 * @param str 被处理字符串
	 * @param toCount 截取长度
	 * @version 2004.11.24
	 * @author zhulx
	 * @return String
	 */
	public static String substring(String str, int p1, int toCount) {
		int reInt = 0;
		String reStr = "";
		if (str == null) {
			return "";
		}
		char[] tempChar = str.toCharArray();

		if (tempChar.length - 1 < p1) {
			return "";
		}
		if (toCount > tempChar.length - p1) {
			reInt = tempChar.length - p1;
		}
		else {
			reInt = toCount;
		}

		for (int kk = p1; kk < p1 + reInt; kk++) {
//			String s1 = str.valueOf(tempChar[kk]);
//			byte[] b = s1.getBytes();
//			reInt += b.length;
			reStr += tempChar[kk];
		}
		return reStr;
	}

	/**如果p1等于p2时用p3替换p1
	 * @param p1 需要格式化的字符串
	 * @param p2 格式化条件
	 * @param p3 替换字符串
	 * @return String
	 */
	public static String replace(String p1, String p2, String p3) {
		return p1.trim().equals(p2.trim()) ? p3.trim() : p1.trim();
	}

	/**
	 * 将字符串p1中的子串p2用p3替换
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return
	 */
	public static String replaceChar(String p1, String p2, String p3) {
		int i_index = p1.indexOf(p2);
		while (i_index >= 0) {
			p1 = p1.substring(0, i_index) + p3 +
			p1.substring(i_index + p2.length(), p1.length());
			i_index = p1.indexOf(p2);
		}
		return p1;
	}

	/**
	 * @param pSource 原字符串
	 * @param pLen 格式化长度
	 * @param pChr 补充长度
	 * @return String
	 */
	public static String lpad(String pSource, int pLen, String pChr) {
		int i_len = pSource.length();
		for (int i = 0; i < pLen - i_len; i++) {
			pSource = pChr + pSource;
		}
		return pSource;
	}

	/**
	 * 判断数据串是否为整数
	 * @param p_data
	 * @return
	 */
	public static boolean isNumber(String p_data) {
		for (int i = 0; i < p_data.length(); i++) {
			char c = p_data.charAt(i);
			Character chr = new Character(c);
			if (!Character.isDigit(c)) {
				if (i == 0) {
					if (! (c == '+' || c == '-')) {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 判断数据串是否为数字
	 * @param p_data
	 * @return
	 */
	public static boolean isDigit(String p_data) {
		for (int i = 0; i < p_data.length(); i++) {
			char c = p_data.charAt(i);
			
			Character chr = new Character(c);

			if(chr.toString().equals(".")){
				if(i==0 || i==p_data.length()-1)
					return false;
				continue;
			}
			if (!chr.isDigit(c)) {

				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串中是否包含中文
	 * @param p_data
	 * @return
	 */
	public static boolean isContainChn(String p_data) {
		for (int i = 0; i < p_data.length(); i++) {
			char c = p_data.charAt(i);
			Character chr = new Character(c);
			if (chr.hashCode() > 125) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断数据串是否小数
	 * @param p_data
	 * @return
	 */
	public static boolean isDouble(String p_data) {
		int i_point_count = 0; //小数点个数
		for (int i = 0; i < p_data.length(); i++) {
			char c = p_data.charAt(i);
			Character chr = new Character(c);
			if (!Character.isDigit(c)) {
				if (i == 0) {
					if (! (c == '+' || c == '-' || c == '.')) {
						return false;
					}
					if (c == '.') {
						i_point_count++;
					}
				}
				else {
					if (c == '.') {
						i_point_count++;
						if (i_point_count > 1) {
							return false;
						}
					}
					else {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * 按指定的数据格式输出数据项
	 * @param s_value
	 * @param p_format
	 * @return
	 */
	public static String formatData(String s_value, String p_format) {
		DecimalFormat a = new DecimalFormat(p_format);
		return a.format(Double.valueOf(s_value));
	}


	public static boolean isDate(String p_date) {
		if (!isDigit(p_date)) {
			return false;
		}
		p_date = String.valueOf(Long.valueOf(p_date).longValue());
		if (p_date.length() != 8) {
			return false;
		}
		String s_year = p_date.substring(0, 4);
		String s_month = p_date.substring(4, 6);
		String s_day = p_date.substring(6, 8);
		int i_year = Integer.valueOf(s_year).intValue();
		int i_month = Integer.valueOf(s_month).intValue();
		int i_day = Integer.valueOf(s_day).intValue();
		if (i_year < 1900 || i_year > 2050) {
			return false;
		}
		if (i_month < 1 || i_month > 12) {
			return false;
		}
		if (i_day < 1 || i_day > getMaxDay(i_year, i_month)) {
			return false;
		}
		return true;
	}

	public static int getMaxDay(int p_year, int p_month) {
		if (p_month == 4 || p_month == 6 || p_month == 9 || p_month == 11) {
			return 30;
		}
		else if (p_month == 2) {
			if ( ( (p_year % 4) == 0) &&
					( ( (p_year % 100) != 0) || ( (p_year % 400) == 0))) {
				return 29;
			}
			else {
				return 28;
			}
		}
		return 31;
	}

	/**
	 * 判断该字符串是否为空,false:不为空；true：空
	 * @param s String
	 * @return boolean
	 */
	public static boolean isNull(String s) {
		if (s != null && s.trim().length() > 0) {
			return false;
		}
		else {
			return true;
		}
	}

	public static String getNormalLine(String line) { //去掉字符串的空格
		Pattern p = Pattern.compile(" ");
		Matcher m = p.matcher(line);
		String s = m.replaceAll("");
		return s;

	}

	public static String getEmptyStringIfNull(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}

	public static String getShorterString(String str, int maxLength) throws
	Exception {
		if (maxLength < 0) {
			throw new Exception("The maxLength < 0 is not allowed.");
		}
		if (str == null) {
			return "";
		}
		if (str.length() <= maxLength) {
			return str;
		}
		return str.substring(0, maxLength) + "...";
	}

	public static String getJspName(String url)
	{
		int begn =0;
		int end =0;
		begn = url.lastIndexOf("/");
		end = url.lastIndexOf(".jsp");
		if(begn>=0 && begn<end ){
			url = url.substring(begn+1,end);
		}
		return url;
	}
	public static String arrayToDelimitedString(Object[] arr, String delim) {
		if (arr == null) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				sb.append(delim);
			}
			sb.append(arr[i]);
		}
		return sb.toString();
	}
	/**
	 * Convenience method to return a Collection as a delimited (e.g. CSV)
	 * String. E.g. useful for toString() implementations.
	 * @param coll Collection to display
	 * @param delim delimiter to use (probably a ",")
	 * @param prefix string to start each element with
	 * @param suffix string to end each element with
	 */
	public static String collectionToDelimitedString(Collection coll, String delim, String prefix, String suffix) {
		if (coll == null) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		Iterator it = coll.iterator();
		int i = 0;
		while (it.hasNext()){
			if (i > 0) {
				sb.append(delim);
			}
			
			sb.append(prefix).append(it.next().toString().trim()).append(suffix);
			
			i++;
		}
		return sb.toString();
	}

	/**
	 * Convenience method to return a Collection as a delimited (e.g. CSV)
	 * String. E.g. useful for toString() implementations.
	 * @param coll Collection to display
	 * @param delim delimiter to use (probably a ",")
	 */
	public static String collectionToDelimitedString(Collection coll, String delim) {
		return collectionToDelimitedString(coll, delim, "", "");
	}
	
	public static String[] toStringArray(Collection collection) {
		if (collection == null) {
			return null;
		}
		return (String[]) collection.toArray(new String[collection.size()]);
	}

	public static List delimitedListToStringList(String str, String delimiter) {
		if (str == null||delimiter == null) {
			return new ArrayList();
		}
		List result = new ArrayList();
		if ("".equals(delimiter)) {
			for (int i = 0; i < str.length(); i++) {
				result.add(str.substring(i, i + 1));
			}
		}
		else {
			int pos = 0;
			int delPos = 0;
			while ((delPos = str.indexOf(delimiter, pos)) != -1) {
				result.add(str.substring(pos, delPos));
				pos = delPos + delimiter.length();
			}
			if (str.length() > 0 && pos <= str.length()) {
				// Add rest of String, but not in case of empty input.
				result.add(str.substring(pos));
			}
		}
		return result;
	}

	public static List delimitedListToByteList(String str, String delimiter) {
		if (str == null||delimiter == null) {
			return new ArrayList();
		}
		List result = new ArrayList();
		if ("".equals(delimiter)) {
			for (int i = 0; i < str.length(); i++) {
				result.add(str.substring(i, i + 1));
			}
		}
		else {
			int pos = 0;
			int delPos = 0;
			while ((delPos = str.indexOf(delimiter, pos)) != -1) {
				result.add(str.substring(pos, delPos));
				pos = delPos + delimiter.length();
			}
			if (str.length() > 0 && pos <= str.length()) {
				// Add rest of String, but not in case of empty input.
				result.add(str.substring(pos));
			}
		}
		return result;
	}

	public static String[] delimitedStringToStringArray(String str, String delimiter) {
		if (str == null) {
			return new String[0];
		}
		if (delimiter == null) {
			return new String[] {str};
		}

		return toStringArray(delimitedListToStringList(str, delimiter));
	}

	public static String[] delimitedListToStringArray(List list) {
		if (list == null) {
			return new String[0];
		}

		return toStringArray(list);
	}

	/**
	 * Convert a CSV list into an array of Strings.
	 * @param str CSV list
	 * @return an array of Strings, or the empty array if s is null
	 */
	public static String[] commaDelimitedListToStringArray(String str) {
		return delimitedStringToStringArray(str, ",");
	}

	/**
	 * 
	 * 根据指定的分格符将字符串打散成数组
	 * author mjz
	 * @param str   		源字符串
	 * @param regex   		分隔符
	 * 
	 * */
	public static String [] spliptStr(String str,String regex){
		if(str!=null&&!"".equals(str.trim())&&regex!=null&&!"".equals(regex.trim())){
			String array[]=str.split(regex);
			return array;
		}
		return null;
	}


	/***根据指定的标记取出标记以前的所有字符串***/
	public static String substringStrByFlag(String strSrc,char flag){
		if(strSrc!=null){
			int count=strSrc.indexOf(flag);
			if(count>0&&strSrc.trim().length()>=1){
				strSrc=strSrc.substring(0, count);
			}
			strSrc=strSrc.trim();			
		}
		return strSrc;
	}


	/*****
	 * 
	 * 去掉字符串末尾的标记字符
	 */
	public static String removeStrLastByFlag(String strSrc,String flag){
		if(strSrc!=null&&!"".equals(strSrc.trim())&&flag!=null&&!"".equals(flag.trim())){
			int len=strSrc.length();
			len=(len<=0)?0:len;
			String tmp=strSrc.substring(len-1,len);
			if(tmp.equals(flag)){
				return strSrc.substring(0,len-1);
			}else{
				return strSrc;
			}
		}
		return strSrc;
	}


	/****如果以标记开头的字符串将被替换成空****/
	public static String replaceBlankByStartFlag(String str,String flag){			
		if(flag!=null&&str!=null&&str.trim().length()>=1&&str.trim().substring(0,1).equals(flag)){			
			return "";
		}else{
			return str;
		}
	}


	/**
	 * 获到临时表的名称,将表名后面截去5个字符,然后加上_temp为临时表名
	 * @param tabName
	 * @return
	 */
	public static String getTempTabName(String tabName){
		return tabName+"_temp";
//		String str=null;
//		int end=tabName.length()-5;
//		end=(end>0)?end:0;
//		str=tabName.substring(0,end)+"_temp";
//		return str;
	}

	/**
	 * 比较新旧id，将没有在新的id中出现过的旧id清理出来组成字符串（格式为id，id...），得到要删除的id
	 * @param newId			新的id串		格式为id，id...
	 * @param oldId			旧的id串		格式为id，id...
	 * @param newIdCode		新的id串用来split的符号
	 * @param oldIdCode		旧的id串用来split的符号
	 * @param resultCode	结果的id串用来连接id的符号
	 * @return
	 */
	public static String compareId(String newId,String oldId,String newIdCode,String oldIdCode,String resultCode)
	{
		StringBuffer resultStr = new StringBuffer("");
		try{
			if (oldId == null || oldId.equals("")) {
				return "";
			}
			if (newId == null || newId.equals("")) {
				return oldId;
			}
			String[] newIds = newId.split(newIdCode);
			String[] oldIds = oldId.split(oldIdCode);
			for(int i=0;i<oldIds.length;i++)
			{
				boolean flg=true;//如果为真，则要删除
				for(int j=0;j<newIds.length;j++)
				{
					if(newIds[j].equals(oldIds[i]))
					{
						flg=false;
						break;
					}
				}
				if(flg)
				{
					resultStr.append(oldIds[i]).append(resultCode);
				}				
			}
			if(resultStr.length()>0)
			{
				return resultStr.substring(0, resultStr.length()-1);				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return resultStr.toString();
	}
	
	/**
	 * 将一个字符串转换为Long列表，每个Long值以逗号（ , ）分隔，若其中单个Long值转换失败，将被忽略
	 * 
	 * @param idList
	 *            形式如 11,22,33 的字符串
	 * @return 转换后的Long数组
	 */
	public static Long[] strSequenceToLongArr(String idList) {
		String[] sa = idList.split(",");
		Long[] rs = new Long[sa.length];
		int i = 0;
		for (String s : sa) {
			try {
				rs[i++] = Long.parseLong(s.trim());
			} catch (NumberFormatException f) {
				System.err.println("WARING:转换数字失败");
			}
		}
		if (i < sa.length) {// trim
			Long[] tmp = rs;
			rs = new Long[i];
			System.arraycopy(tmp, 0, rs, 0, i);
		}
		return rs;
	}
	
	
	public static void main(String args[]){
		String str21 = "胡小宝";
		String str = "李军 ";
		System.out.print(getNormalLine(str));
//		System.out.print(getNormalLine(str21));
//		String str=null;
//		System.out.println(removeStrLastByFlag(str,"#"));
//		List list=new ArrayList();
//		
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		
//		System.out.println(collectionToDelimitedString(list,",","'","'"));
//		
//		System.out.println(delimitedListToStringList("12,345", ","));
	}

}
