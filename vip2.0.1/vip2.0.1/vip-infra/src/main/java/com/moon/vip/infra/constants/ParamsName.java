package com.moon.vip.infra.constants;

import java.util.HashMap;
import java.util.Map;

import com.moon.vip.infra.vo.UrlInfoVO;

/**
 * 
* @ClassName: ParamsName 
* @Description: TODO(需要拦截前端请求的参数名称) 
* @author  陈海  - （怡宝 ）
* @date 2016年1月27日 下午5:26:48 
*
 */
public class ParamsName {
	private static Map<String,UrlInfoVO> paramsName;
	static{
		paramsName = new HashMap<String, UrlInfoVO>();
		paramsName.put("/admin/attend/studensAttend" ,
				new UrlInfoVO( EnumAuthAction.SELECT,UrlInfoMsg.ROAD_PATH, UrlInfoMsg.ORGANIZATION_ID,1));
		 
		 /********xiangui*******/
	    paramsName.put("student/studentDetail/personalDetail" ,/***查看学员详情**/
				new UrlInfoVO( EnumAuthAction.SELECT,UrlInfoMsg.ROAD_PATH, UrlInfoMsg.STUDENT_ID,1));
		paramsName.put("student/studentDetail/addStudentMessage" ,/***编辑学员信息***/
				new UrlInfoVO( EnumAuthAction.SELECT,UrlInfoMsg.ROAD_PATH, UrlInfoMsg.STUDENT_ID,1));
		paramsName.put("questionnaire/questionnaire/questionnaireAdds" ,/***问卷调查添加***/
				new UrlInfoVO( EnumAuthAction.INSERT,"proId", UrlInfoMsg.ORGANIZATION_ID));
	    /**********************/
		 
		 
		 /****作业登记，add by lqc***********/
	    paramsName.put("/educational/homework/showHomework",
	    		new UrlInfoVO(EnumAuthAction.SELECT,"opClaId", UrlInfoMsg.ORGANIZATION_ID));
	    paramsName.put("/educational/homework/getCountHomework", 
	    		new UrlInfoVO(EnumAuthAction.SELECT,"orgProCalId", UrlInfoMsg.ORGANIZATION_ID));
	    paramsName.put("/educational/homework/listHomework", 
	    		new UrlInfoVO(EnumAuthAction.SELECT,"orgProCalId", UrlInfoMsg.ORGANIZATION_ID));
	    paramsName.put("/educational/homework/updateHomeworkRecord", 
	    		new UrlInfoVO(EnumAuthAction.UPDATE,"classId", UrlInfoMsg.ORGANIZATION_ID));
	    /**************/

	    
	    
	    /********by chenhai*************/
	   /* paramsName.put("/classinfo/classinfo/getProInfo", 
	    		new UrlInfoVO(EnumAuthAction.SELECT,"id", UrlInfoMsg.ORGANIZATION_ID));*/
	    paramsName.put("/classinfo/classinfo/getProManager", 
	    		new UrlInfoVO(EnumAuthAction.SELECT,"proId", UrlInfoMsg.ORGANIZATION_ID));
	    paramsName.put("/classinfo/classinfo/upClassMsg", 
	    		new UrlInfoVO(EnumAuthAction.UPDATE,"id", UrlInfoMsg.ORGANIZATION_ID));
	    paramsName.put("/admin/attend/delAttenRecord", 
	    		new UrlInfoVO(EnumAuthAction.DELETE,"classId", UrlInfoMsg.ORGANIZATION_ID));
	    /*************************/
	    


	    /**
	     * 学员档案，by qingyu
	     */
	    paramsName.put("/studentFile/savaLearnState", new UrlInfoVO(EnumAuthAction.UPDATE, "id", UrlInfoMsg.PROFESSION_ID));
	    paramsName.put("/studentFile/saveStudyBasis", new UrlInfoVO(EnumAuthAction.UPDATE, "id", UrlInfoMsg.PROFESSION_ID));
	    paramsName.put("/studentFile/personInfoFirst", new UrlInfoVO(EnumAuthAction.SELECT, UrlInfoMsg.ROAD_PATH, UrlInfoMsg.PROFESSION_ID, 3));
	    paramsName.put("/studentFile/personInfoSecond" ,new UrlInfoVO( EnumAuthAction.SELECT,UrlInfoMsg.ROAD_PATH, UrlInfoMsg.PROFESSION_ID,3));
	    
	    paramsName.put("/studentFile/personInfoThird", new UrlInfoVO(EnumAuthAction.SELECT, UrlInfoMsg.ROAD_PATH, UrlInfoMsg.PROFESSION_ID, 3));
	    
	    paramsName.put("/studentFile/personInfoFourth", new UrlInfoVO(EnumAuthAction.SELECT, UrlInfoMsg.ROAD_PATH, UrlInfoMsg.PROFESSION_ID, 3));
	    paramsName.put("/studentFile/personInfoFifth", new UrlInfoVO(EnumAuthAction.SELECT, UrlInfoMsg.ROAD_PATH, UrlInfoMsg.PROFESSION_ID, 3));
	    
	    paramsName.put("/studentFile/upLoadProAttach", new UrlInfoVO(EnumAuthAction.INSERT, UrlInfoMsg.ROAD_PATH, UrlInfoMsg.PROFESSION_ID, 1));
	    paramsName.put("/studentFile/deleteAttach", new UrlInfoVO(EnumAuthAction.DELETE, UrlInfoMsg.ROAD_PATH, UrlInfoMsg.PROFESSION_ATTACH_ID, 1));
	    /**
	     * 访谈记录 by qingyu
	     */
	    paramsName.put("/interview/interviewInfoCheck", new UrlInfoVO(EnumAuthAction.SELECT, UrlInfoMsg.ROAD_PATH, UrlInfoMsg.INTERVIEW_ID, 1));
	    paramsName.put("/interview/interviewInfoAddDeal", new UrlInfoVO(EnumAuthAction.INSERT, "opProId", UrlInfoMsg.ORGANIZATION_ID));
	    paramsName.put("/interview/interviewInfoUpdatePage", new UrlInfoVO(EnumAuthAction.SELECT, UrlInfoMsg.ROAD_PATH, UrlInfoMsg.INTERVIEW_ID, 1));
	    //paramsName.put("/interview/interviewInfoUpdateDeal", new UrlInfoVO(EnumAuthAction.UPDATE, "id", UrlInfoMsg.INTERVIEW_ID));
	    paramsName.put("/interview/interviewDelete", new UrlInfoVO(EnumAuthAction.DELETE, "recordIds", UrlInfoMsg.INTERVIEW_ID,true));
	} 

	public static Map<String,UrlInfoVO> getParamsName(){
		return paramsName;
	}

}
