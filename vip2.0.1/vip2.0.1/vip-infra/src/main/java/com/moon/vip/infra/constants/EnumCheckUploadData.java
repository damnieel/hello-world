package com.moon.vip.infra.constants;

public enum EnumCheckUploadData {
	
	E0001("name", "^[\u4e00-\u9fa5]{2,5}$"),	//姓名匹配， 2-5个汉字
	E0002("telephone", "^[0-9]{7,11}$"),	//手机号码匹配， 8-10位数字
	E0003("QQ", "^[1-9][0-9]{4,12}$"), 	//QQ匹配 ， 4-12位数字
	E0004("professionalName", "^[\u4e00-\u9fa5_a-zA-Z0-9_]{2,10}$"),//专业名称匹配， 中英文数字 2-10位
	E0005("amountPayable", "^[0-9]{1,6}(\\.[0-9]{1,2})?$"),//专业价格 ， 6位整数，两位小数
	E0006("payment", "^[0-9]{1,6}(\\.[0-9]{1,2})?$"), //实付金额 ， 6位整数，两位小数
	E0007("enterDate", "^\\d{4}\\d{1,2}\\d{1,2}$"),
	E0008("email", "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"),
	E0009("sex", "^[\u4e00-\u9fa5]{1}$|^[a-zA-Z]{1}$"), 
	E00010("YY", "^[1-9][0-9]{4,12}$"),//YY 匹配
	E00011("idCard", "(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])"), 
	E00012("emergencyPerson", "^[\u4e00-\u9fa5]{2,5}$"), 
	E00013("emergencyTelephone", "^[0-9]{7,11}$"), 
	E00014("contratRelationshipsCode", "^[\u4e00-\u9fa5_a-zA-Z0-9_]{2,10}$"), 
	E00015("payMethod", "^[\u4e00-\u9fa5]{2,5}$"), 
	E00016("professionCode", "^[a-zA-Z]{1,8}[0-9]{0,22}$"),
	;
	
	
	public String name;
	public String regularExp;
	EnumCheckUploadData(String name, String regularExp) {
		this.name = name;
		this.regularExp = regularExp;
	}
}
