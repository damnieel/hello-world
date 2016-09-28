package com.moon.vip.controller.sys;



import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.controller.student.PaymentController;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.sys.ClassInfoVO;
import com.moon.vip.infra.vo.sys.ClassManagerVO;
import com.moon.vip.infra.vo.sys.NewClassMsgVO;
import com.moon.vip.infra.vo.sys.OrganizationalProfessionalVO;
import com.moon.vip.infra.vo.sys.classSearchParamsVO;
import com.moon.vip.model.sys.OrganizationalProfessional;
import com.moon.vip.service.sys.IClassInFoBetaService;
import com.moon.vip.service.sys.IClassInFoService;
import com.moon.vip.service.sys.IClearCacheService;

/**
 * 
* @ClassName: ClassInFoBetaController 
* @Description: TODO(班级设置controller) 
* @author  陈海  - （怡宝 ）
* @date 2016年1月22日 下午9:02:42 
*
 */
@Controller
@RequestMapping("/classinfo/classinfo")
public class ClassInFoBetaController extends BaseController {
	private static Logger logger = Logger.getLogger(PaymentController.class);
	private static String TEACHER = "讲师";
	private static String ADVISER = "班主任";
	   @Autowired
       private IClassInFoService iClassInFoService;
	   @Autowired
       private IClassInFoBetaService classInFobetaService;
	   @Autowired
	   private IClearCacheService clearCacheService;
	   
	   @RequestMapping("/allMajorFrameInfo")
	   @ResponseBody
		public List<OrganizationalProfessionalVO> majorFrameInfo(OrganizationalProfessionalVO organizationalProfessionalVO){
		  List<OrganizationalProfessionalVO> a = iClassInFoService.selectInfoById(organizationalProfessionalVO);
		  return a;
		}
	   
	   /**
		 * 班级信息页面<BR>
		 * 方法名：classinfoList<BR>
		 * 创建人：龙金 <BR>
		 * 时间：2015年12月30日-下午2:53:17 <BR>
		 * @return ModelAndView<BR>
		 * @exception <BR>
		 * @since  1.0.0
		*/
	   @RequestMapping("/classinfoList")
	   public ModelAndView classinfoList(OrganizationalProfessionalVO organizationalProfessionalVO){
		   ModelAndView mv=new ModelAndView();
		   mv.setViewName("/page/sys/classSetting");
		   return mv;
	   }
	   
	   /**
	     * 根据条件获取班级信息<br/>
	     * @Author：  陈海  - （怡宝 ）<br/>
	     * @Title: classinfoTemplate <br/>
	     * @return ModelAndView    返回类型 <br/>
	     * @date 2016年1月18日 下午1:31:05 <br/>
	     * @throws <br/>
	     *
	    */
	   @RequestMapping("/classSettingList")
	   @ResponseBody
	   public ModelAndView getClassInfo(classSearchParamsVO params){
		   ModelAndView mv=new ModelAndView();
		   List<ClassInfoVO> list = classInFobetaService.getClaInfoByParams(params);
		   mv.addObject("list", list);
		   mv.setViewName("/page/sys/classSettingList");
		   return mv;
		}
	   
	  /**
	    * 根据部门Id获取专业<br/>
	    * @Author：  陈海  - （怡宝 ）<br/>
	    * @Title: getCountClassInfo <br/>
	    * @return List<OrganizationalProfessional>    返回类型 <br/>
	    * @date 2016年1月18日 下午4:53:56 <br/>
	    * @throws <br/>
	    *
	   */
	   @RequestMapping("/getProInfo")
	   @ResponseBody
	   public  List<OrganizationalProfessional> getProInfo(Integer id){
		   HashSet<Integer> set = achieveAuth();
		   List<OrganizationalProfessional> list = classInFobetaService.getProInfo(id,set);
		   return list;
	   }
	   
		/**
		  * 获取管理者<br/>
		  * @Author：  陈海  - （怡宝 ）<br/>
		  * @Title: getClaManagerByName <br/>
		  * @return List<ClassManagerVO>    返回类型 <br/>
		  * @date 2016年1月18日 下午9:03:36 <br/>
		  * @throws <br/>
		  *
		 */
	   @RequestMapping("/getClaManager")
	   @ResponseBody
	   public List<ClassManagerVO> getClaManagerByName(String type,String searchKey){
		   if(type.equals( "teacher")){
			   type = TEACHER;
		   }
		   else{
			   type = ADVISER;
		   }
		   List<ClassManagerVO> list = classInFobetaService.getClassMag(type,searchKey);
		   return list;
	   }
	   
	   /**
	     * 获取专业下的管理者<br/>
	     * @Author：  陈海  - （怡宝 ）<br/>
	     * @Title: getProManager <br/>
	     * @return List<ClassManagerVO>    返回类型 <br/>
	     * @date 2016年1月22日 下午7:37:45 <br/>
	     * @throws <br/>
	     *
	    */
	   @RequestMapping("/getProManager")
	   @ResponseBody
	   public List<ClassManagerVO> getProManager(String type,Integer proId){
		   List<ClassManagerVO> list = classInFobetaService.getProMag(type,proId);
		   return list;
	   }
	   
	   
	   
	   
       /**
         * 获取班级总数<br/>
         * @Author：  陈海  - （怡宝 ）<br/>
         * @Title: getCountClassInfo <br/>
         * @return int    返回类型 <br/>
         * @date 2016年1月18日 下午9:04:01 <br/>
         * @throws <br/>
         *
        */
	   @RequestMapping("/getCountClassInfo")
	   @ResponseBody
	   public int getCountClassInfo(classSearchParamsVO params){
		   int result = classInFobetaService.getCountClaInfoByParams(params);
		   return result;
	   }
	   
	   
	   
	   
	   
	   /**
	    * TODO<br/>
	     * @Author：  陈海  - （怡宝 ）<br/>
	     * @Title: addClass <br/>
	     * @return String    返回类型 <br/>
	     * @date 2016年1月18日 下午7:07:04 <br/>
	     * @throws <br/>
	     *
	    */
	   @RequestMapping("/addClass")
	   @ResponseBody
	   public String addClass(NewClassMsgVO classParams){
		 try{
			  classParams.setCreator(getUserCode());
		      String result = classInFobetaService.addClass(classParams);
		      return result;		
		 }catch(BusinessException e){
			 String err =e.getCode() + ":" +e.getExceptionMsg();
			 logger.error(err,e);
			 return err;
		 }catch (Exception e) {
			 logger.error("增加班级信息失败，发生未知错误", e);
			 return "UNKNOW_ERR";
		 }finally{
			 logger.info("清空缓存");
			 clearCacheService.clearAuthForOrgProfessional();
			 clearCacheService.clearConvertAuthToJSONArray();
			 clearCacheService.clearGetChildList();
		 }
	   }
	   
	   /**
	     * 更新班级状态<br/>
	     * @Author：  陈海  - （怡宝 ）<br/>
	     * @Title: updateClassMsg <br/>
	     * @return String    返回类型 <br/>
	     * @date 2016年1月18日 下午8:32:36 <br/>
	     * @throws <br/>
	     *
	    */
	   @RequestMapping("/upClassMsg")
	   @ResponseBody
	   public String updateClassMsg(OrganizationalProfessional params){
		 try{
			  classInFobetaService.updateStudentClassStatus(params.getId());
			  params.setModifyUser(getUserCode());
		      return  classInFobetaService.updateClass(params);
		 }catch(BusinessException e){
			 String err =e.getCode() + ":" +e.getExceptionMsg();
			 logger.error(err,e);
			 return err;
		 }catch (Exception e) {
			logger.error("修改班级信息失败，发生未知错误", e);
			return "UNKNOW_ERR";
		 }finally{
			 logger.info("清空缓存");
			 clearCacheService.clearAuthForOrgProfessional();
			 clearCacheService.clearConvertAuthToJSONArray();
			 clearCacheService.clearGetChildList();
		 }
	   }
	   
	   /**
	     *更新班级具体信息<br/>
	     * @Author：  陈海  - （怡宝 ）<br/>
	     * @Title: updateClaDetail <br/>
	     * @return String    返回类型 <br/>
	     * @date 2016年1月19日 上午10:16:25 <br/>
	     * @throws <br/>
	     *
	    */
	   @RequestMapping("/updateClaDetail")
	   @ResponseBody
	   public String updateClaDetail(NewClassMsgVO updateParams){
		 try{ 
		      return  classInFobetaService.updateClaDetail(updateParams,getUserCode());
		 }catch(BusinessException e){
			 String err =e.getCode() + ":" +e.getExceptionMsg();
			 logger.error(err,e);
			 return err;
		 }catch (Exception e) {
			logger.error("修改班级信息失败，发生未知错误", e);
			return "UNKNOW_ERR";
		 }finally{
			 logger.info("清空缓存");
			 clearCacheService.clearAuthForOrgProfessional();
			 clearCacheService.clearConvertAuthToJSONArray(); 
			 clearCacheService.clearGetChildList();
		 }
	   }
	   
	   
	   
}
