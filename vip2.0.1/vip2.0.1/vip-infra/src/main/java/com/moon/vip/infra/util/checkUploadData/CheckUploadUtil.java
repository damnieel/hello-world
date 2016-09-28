package com.moon.vip.infra.util.checkUploadData;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.moon.vip.infra.constants.EnumCheckUploadData;

public class CheckUploadUtil {

	private static Logger logger = Logger.getLogger(CheckUploadUtil.class);
	public static boolean checkProfessionCodeParam(String professionCode) {		
		if(StringUtils.isEmpty(professionCode)) {
			logger.error("空判断：professionCode is " + professionCode);
			return false;
		} else if(professionCode.length() < 7 || professionCode.length() > 22) {
			logger.error("长度超出：professionCode length is " + professionCode.length());
			return false;
		} else if(!professionCode.matches(EnumCheckUploadData.E00016.regularExp)) {
			logger.error("professionCode不符合正则表达式规范。" + professionCode);
			return false;
		} else {
			return true;
		}
	}
	public static boolean checkNameParam(String name) {		
		if(StringUtils.isEmpty(name)) {
			logger.error("空判断：name is " + name);
			return false;
		} else if(name.length() > 10) {
			logger.error("长度超出：name length is " + name.length());
			return false;
		} else if(!name.matches(EnumCheckUploadData.E0001.regularExp)) {
			logger.error("name不符合正则表达式规范。" + name);
			return false;
		} else {
			return true;
		}
	}
	public static boolean checkEmailParam(String email) {
		
		if(email == null || "".equals(email)) {
			return true;
		}
		if(!email.matches(EnumCheckUploadData.E0008.regularExp)) {
			logger.error("email不符合正则表达式规范" + email);
			return false;
		} else {
			return true;
		}
	}
	public static boolean checkSexParam(String sex) {
		
		if(sex == null || "".equals(sex)) {
			return true;
		}
		if(!sex.matches(EnumCheckUploadData.E0009.regularExp)) {
			logger.error("sex不符合正则表达式规范" + sex);
			return false;
		} else {
			return true;
		}
	}
	public static boolean checkTelephoneParam(String telephone) {
		if(StringUtils.isEmpty(telephone)) {
			logger.error("空判断：telephone is " + telephone);
			return false;
		} else if(telephone.length() > 12 || telephone.length() < 7) {
			logger.error("长度超出：telephone length is " + telephone.length());
			return false;
		} else if(!telephone.matches(EnumCheckUploadData.E0002.regularExp)) {
			logger.error("telephone不符合正则表达式规范。" + telephone);
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkQQParam(String QQ) {
		if(StringUtils.isEmpty(QQ)) {
			logger.error("空判断：QQ is " + QQ);
			return false;
		} else if(QQ.length() < 4 || QQ.length() > 50) {
			logger.error("长度超出：QQ length is " + QQ.length());
			return false;
		} else if(!QQ.matches(EnumCheckUploadData.E0003.regularExp)) {
			logger.error("QQ不符合正则表达式规范。" + QQ);
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkYYParam(String YY) {
		
		if(YY == null || "".equals(YY)) {
			return true;
		}
		if(!YY.matches(EnumCheckUploadData.E00010.regularExp)) {
			logger.error("YY不符合正则表达式规范" + YY);
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkIdCardParam(String idCard) {
		
		if(idCard == null || "".equals(idCard)) {
			return true;
		}
		if(!idCard.matches(EnumCheckUploadData.E00011.regularExp)) {
			logger.error("idCard不符合正则表达式规范" + idCard);
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkEmergencyPersonParam(String emergencyPerson) {
		
		if(emergencyPerson == null || "".equals(emergencyPerson)) {
			return true;
		}
		if(!emergencyPerson.matches(EnumCheckUploadData.E00012.regularExp)) {
			logger.error("emergencyPerson不符合正则表达式规范" + emergencyPerson);
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkEmergencyTelephoneParam(String emergencyTelephone) {
		
		if(emergencyTelephone == null || "".equals(emergencyTelephone)) {
			return true;
		}
		if(!emergencyTelephone.matches(EnumCheckUploadData.E00013.regularExp)) {
			logger.error("emergencyTelephone不符合正则表达式规范" + emergencyTelephone);
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkContratRelationshipsCodeParam(String contratRelationshipsCode) {
		
		if(contratRelationshipsCode == null || "".equals(contratRelationshipsCode)) {
			return true;
		}
		if(!contratRelationshipsCode.matches(EnumCheckUploadData.E00014.regularExp)) {
			logger.error("contratRelationshipsCode不符合正则表达式规范" + contratRelationshipsCode);
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean checkProfessionalNameParam(String professionalName) {
		if(StringUtils.isEmpty(professionalName)) {
			logger.error("空判断：professionalName is " + professionalName);
			return false;
		} 
/*			去掉专业名称正则表达式验证
 * 			else if(!professionalName.matches(EnumCheckUploadData.E0004.regularExp)) {
			logger.error("professionalName不符合正则表达式规范。" + professionalName);
			return false;
		} */
		else {
			return true;
		}
		//添加其他判断
		
	}
	public static boolean checkAmountPayableParam(double amountPayable) {
		if(Double.compare(amountPayable, 0) == 0) {
			logger.error("空判断：amountPayable is " + amountPayable);
			return false;			
		} else if(Double.compare(amountPayable, 1000000.00) == 1) {
			logger.error("超值判断：amountPayable is " + amountPayable);
			return false;
		} else if(!String.valueOf(amountPayable).matches(EnumCheckUploadData.E0005.regularExp)) {
			logger.error("amountPayable不符合正则表达式规范。" + amountPayable);
			return false;
		} else {
			return true;
		}
	}
	public static boolean checkPayMethodParam(String payMethod) {
		if(StringUtils.isEmpty(payMethod)) {
			logger.error("空判断：payMethod is " + payMethod);
			return false;
		} else if(!payMethod.matches(EnumCheckUploadData.E00015.regularExp)) {
			logger.error("payMethod不符合正则表达式规范。" + payMethod);
			return false;
		} else {
			return true;
		}				
	}
	public static boolean checkPaymentParam(double payment) {
		if(Double.compare(payment, 0) == 0) {
			logger.error("空判断：amountPayable is " + payment);
			return false;			
		} else if(Double.compare(payment, 1000000.00) == 1) {
			logger.error("超值判断：amountPayable is " + payment);
			return false;
		} else if(!String.valueOf(payment).matches(EnumCheckUploadData.E0005.regularExp)) {
			logger.error("amountPayable不符合正则表达式规范。" + payment);
			return false;
		}  else {
			return true;
		}
	}	
	
}
