package com.moon.vip.infra.constants;

/**
 * 
 * @ClassName: SysConstantsVal 
 * @Description: 系统常量设置
 * @author 大枫
 * @date 2016年1月8日 上午9:30:06 
 *
 */
public class SysConstantsVal {
	/**
	 * 初始密码
	 */
	public static final String INITPASSWORD ="f7ee99f4edc016f00c4ec99ea7379755";
	/**
	 * 上传文件地址配置文件
	 */
	public static final String UPLOADCONFIGFILE = "uploadpath.properties";
	/**
	 * 超级管理员
	 */
	public static final String SUPERSECURITY = "super";
	
	/**
	 * 学员专业编号中序列号长度限制
	 */
	public static final Integer SEQ_LENGTH = 3;
	
	/**
	 * 码表专业前缀type
	 */
	public static final String PROFESSIONAL_PREX = "professional_prefix";
	/**
	 * sql异常， Duplicate entry 'dafeng' for key 'uq_code'
	 */
	public static final String DUPLICATEENTRY = "uq_code";
	/**
	 * 学员上传数据，第一个字段
	 */
	public static final String UPLOADFIRSTFIELD = "professionCode";
	/**
	 * 学员上传数据，第一个字段
	 */
	public static final String ORRELATION = "or";
	/**
	 * 是否启用SSO登录
	 */
	public static boolean SSO = false;
	
	/**
	 * 账户使用中
	 */
	public static String ACCOUNT_USING = "using";
	
	/**
	 * 新增班级时的未节课状态
	 */
	public static String IS_END="N";
	
	/**可用**/
	public static String IS_VALID="Y";
	/**
	 * 班级的type
	 */
	public static String CLASS_TYPE="cla";
}
