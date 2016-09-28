package com.moon.vip.infra.constants;
/**
 * 
* @ClassName: EnumAttendException 
* @Description: TODO(考勤异常) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月25日 上午10:40:34 
*
 */
public enum EnumAttendException {
	
	/**IO异常处理**/
	IOEXP0001("IOEXP0001","配置文件未找到"),
	IOEXP0002("IOEXP0002","文件读取失败"),
	IOEXP0003("IOEXP0003","上传路径未定义"),
	IOEXP0004("IOEXP0004","文件已经被移走,系统异常"),
	IOEXP0005("IOEXP0005","文件移动失败"),
	EXCELSYSERR("EXCELSYSERR","EXCEl数据读取异常"),
	POIERR("POIERR","系统暂只支持03版本excel文件"), 
	

	ATEXP0001("ATEXP0001", "未知错误"),
	ATEXP0002("ATEXP0002", "不能定位到学生"),
	ATEXP0003("ATEXP0003", "专业错误"),
	ATEXP0004("ATEXP0004", "班级错误"),
	ATEXP0005("ATEXP0005", "日期错误"),
	ATEXP0006("ATEXP0006", "考勤状态不能为空,且只能为0,1,2"),
	ATEXP0007("ATEXP0007", "数据更新异常"),
	ATEXP0008("STU_NO_IN_CLA","该学生不在该班级内"), 
	ATEXP0009("RUN_EXP_THROW","导入操作发生异常,导入无效"),
	
	
	DAERR0001("CLASS_NO_FOUND","班级未找到"),
	DAERR0002("CLASS_FOUND_ERROR","班级定位错误"),
	DAERR0000("ORG_MSG_NULL","部门专业班级信息不完整"), 
	DAERR0003("DATA_NO_NULL","考勤日期不能为空"),
	DAERR0004("DATE_FORMMAT_ERR","日期解析错误"),
	DAERR0005("DAERR0005","考勤记录未对应时间"),
	DAERR0006("DAERR0006","考勤时间未对应出勤记录"),
	DAERR0007("DAERR0007","存在重复学号，不能定位学生"),
	DAERR0008("DAERR0008","该学号不存在对应学生"), 
	DAERR0009("PARAMS_NO_NULL","课程参数，学生参数错误"), 
	DAERR0010("DEL_FAIL_ERR","删除失败，位置异常"),
	DAERR0011("DATE_NO_NULL","时间范围参数出错"),
	DAERR0012("DELETE_PARAMS_ERR","更新记录大于一条，参数有误"), 
	
	
	
	SYSERR0000("ORG_ID_NO_SET","部门id未设置"),
	SYSERR0001("PRO_NO_FOUND","专业不能找到"), 
	;
	
	public String code;//异常错误编码
	public String msg;//异常消息
	
	EnumAttendException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	

}
