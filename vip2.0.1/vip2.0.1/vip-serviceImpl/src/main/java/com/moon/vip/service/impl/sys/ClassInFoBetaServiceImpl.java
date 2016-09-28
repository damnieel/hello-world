package com.moon.vip.service.impl.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.moon.vip.application.student.StudentClassSqlMapper;
import com.moon.vip.application.sys.EmployeeBaseSqlMapper;
import com.moon.vip.application.sys.OPManagerMapper;
import com.moon.vip.application.sys.OPManagerSqlMapper;
import com.moon.vip.application.sys.OrganizationalProfessionalMapper;
import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.IsValidType;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.util.StringUtil;
import com.moon.vip.infra.vo.sys.ClassInfoVO;
import com.moon.vip.infra.vo.sys.ClassManagerVO;
import com.moon.vip.infra.vo.sys.NewClassMsgVO;
import com.moon.vip.infra.vo.sys.classSearchParamsVO;
import com.moon.vip.model.sys.OPManager;
import com.moon.vip.model.sys.OrganizationalProfessional;
import com.moon.vip.service.sys.IClassInFoBetaService;
/**
 * 班级信息
 * ClassInFoServiceImpl<BR>
 * 创建人:龙金 <BR>
 * 时间：2015年12月30日-下午3:30:54 <BR>
 * @version 1.0.0
 * 
 */
@Service("classinfobeta")
public class ClassInFoBetaServiceImpl implements IClassInFoBetaService{
    private static Logger logger =Logger.getLogger(ClassInFoBetaServiceImpl.class);
	private static String TEACHER = "teacher";
	private static String ADVISER = "adviser";
    @Autowired
	private OrganizationalProfessionalSqlMapper organizationalprofessionalSqlMapper;
	@Autowired
	private OrganizationalProfessionalMapper organizationalProfessionalMapper;
	@Autowired
	private OPManagerMapper oPManagerMapper;
	@Autowired
	private OPManagerSqlMapper oPManagerSqlMapper;
	@Autowired
	private EmployeeBaseSqlMapper employeeBaseSqlMapper;
	@Autowired
	private StudentClassSqlMapper studentClassSqlMapper;
	public List<ClassInfoVO> getClaInfoByParams(classSearchParamsVO params) {
		List<ClassInfoVO> list = organizationalprofessionalSqlMapper.getClassInfo(params);
		return list;
	}
	public int getCountClaInfoByParams(classSearchParamsVO params) {
		int result =organizationalprofessionalSqlMapper.getCountClassInfo(params);
		return result;
	}
	public List<OrganizationalProfessional> getProInfo(Integer id,HashSet<Integer> set) {
		if(id == null){
			return null;
		}
		List<OrganizationalProfessional> list = new ArrayList<OrganizationalProfessional>();
		list = organizationalprofessionalSqlMapper.getAllProById(id,set);
		return list;
	}
	public String addClass(NewClassMsgVO classParams) {
		validParams(classParams);
		int count = organizationalprofessionalSqlMapper.checkRepeat(classParams.getOrgId(),classParams.getClassName(),null);
		if(count > 0){
			logger.error(String.format("该专业下[%s]存在重复班级[%s]", classParams.getOrgId(),classParams.getClassName()));
			throw new BusinessException(EnumCodeException.E0122);
		}
		int id = insertClassBaseInfo(classParams);
		insertClaManager(classParams,0,id);
		insertClaManager(classParams,1,id);
		logger.info(String.format("[%s]增加了一条班级记录[%s]", classParams.getCreator(),classParams.toString()));
		return "success";
	}
	private int insertClassBaseInfo(NewClassMsgVO classParams) {
		OrganizationalProfessional cla = new OrganizationalProfessional();
		cla.setPartentId(classParams.getOrgId());
		cla.setType("cla");
		cla.setName(classParams.getClassName());
		cla.setLevel(4);
		cla.setParentManageRole(getParentManageRole());
		cla.setIsValid(IsValidType.Y_VALUE);
		cla.setStartDate(classParams.getStartDate());
		cla.setEndDate(classParams.getEndDate());
		cla.setIsEnd(IsValidType.N_VALUE);
		cla.setCreateTime(new Date());
		cla.setCreator(classParams.getCreator());
		organizationalProfessionalMapper.insertRecId(cla);
		if (cla.getId() == null){
		  throw new BusinessException(EnumCodeException.E0121);
		}
		return cla.getId();
	}
	
	/**
	  * 插入班级管理者<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: insertClaManager <br/>
	  * @return void    返回类型 <br/>
	  * @date 2016年1月18日 下午7:42:06 <br/>
	  * @throws <br/>
	  *
	 */
	private void insertClaManager(NewClassMsgVO classParams,int type,int id){
		OPManager op = new OPManager();
		/** 0:teacher,1:adviser**/
		if(type == 0){
			op.setEmployeeCode(classParams.getTeachCode());
			op.setType(TEACHER);
		}
		else{
			op.setEmployeeCode(classParams.getAdvCode());
			op.setType(ADVISER);
		}
		op.setCreateTime(new Date());
		op.setCreator(classParams.getCreator());
		op.setOpId(id);
	    oPManagerMapper.insertSelective(op);
	}
	private void validParams(NewClassMsgVO classParams){
		if(classParams.getOrgId() == null){
			throw new BusinessException(EnumCodeException.E0117);
		}
		if(StringUtil.isNull(classParams.getClassName())){
			throw new BusinessException(EnumCodeException.E0120);
		}
		if(classParams.getStartDate()== null || classParams.getEndDate() == null){
			throw new BusinessException(EnumCodeException.E0118);
		}
		if(classParams.getAdvCode()== null || classParams.getTeachCode() == null){
			throw new BusinessException(EnumCodeException.E0119);
		}
		classParams.setClassName(replaceBlank(classParams.getClassName()));
	}
	/**目前字段无意义**/
	private Integer getParentManageRole(){
		return 0;
	}
	public List<ClassManagerVO> getClassMag(String type,String searchKey) {
		if(StringUtil.isNull(type)){
			logger.warn("类型为空");
			return null;
		}
		List<ClassManagerVO> list = employeeBaseSqlMapper.getClassMag(type,searchKey);
		return list;
	}
	public String updateClass(OrganizationalProfessional params) {
		if(params.getId() == null){
			throw new BusinessException(EnumCodeException.E0117);
		}
		if(params.getIsValid() != null){ //执行删除之前判断
		  checkHasStu(params.getId());
		}
		params.setModifyTime(new Date());
	    organizationalProfessionalMapper.updateByPrimaryKeySelective(params);
	    logger.info(String.format("[%s]更新了班级信息[%s],isValid[%s],isEnd[%s]",params.getModifyUser(),params.getId(),params.getIsValid(),params.getIsEnd()));
		return "success";
	}
	
    private void checkHasStu(Integer id) {
    	if(studentClassSqlMapper.findStuByClaId(id) > 0){
    		throw new BusinessException(EnumCodeException.E0123);
    	};
	}
	public  String replaceBlank(String str) {
	        if (str!=null) {
	            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	            Matcher m = p.matcher(str);
	            str = m.replaceAll("");
	        }
	        return str;
	    }
	public String updateClaDetail(NewClassMsgVO updateParams, String userCode) {
		if(updateParams.getOrgId() == null || updateParams.getParentId() ==null){
		  throw new BusinessException(EnumCodeException.E0117);
		}
		if(updateParams.getClassName() != null){
			updateParams.setClassName(replaceBlank(updateParams.getClassName()));
		}
		int count = organizationalprofessionalSqlMapper.checkRepeat(updateParams.getParentId(),updateParams.getClassName(),updateParams.getOrgId());
		if(count > 0){
			logger.error(String.format("改专业下[%s]存在重复班级[%s]", updateParams.getParentId(),updateParams.getClassName()));
			throw new BusinessException(EnumCodeException.E0122);
		}
	    updateOrgTable( updateParams, userCode);//更新组织机构表
	    updateClaManager(updateParams,userCode);
	    logger.info(String.format("[%s]修改了班级信息[%s]", userCode,updateParams.toString()));
		return "success";
	}
    /**更新组织机构表里面的班级信息**/
	private void updateOrgTable(NewClassMsgVO updateParams, String userCode){
		OrganizationalProfessional o = new OrganizationalProfessional();
		o.setId(updateParams.getOrgId());
		o.setModifyUser(userCode);
		o.setStartDate(updateParams.getStartDate());
		o.setEndDate(updateParams.getEndDate());
		o.setName(updateParams.getClassName());
		updateClass(o);
	}
	/**更新班级管理人员**/
	private void updateClaManager(NewClassMsgVO updateParams, String userCode){
		int i = oPManagerSqlMapper.updateByClaIdAndType(updateParams.getOrgId(),updateParams.getTeachCode(),TEACHER,userCode);
		int j = oPManagerSqlMapper.updateByClaIdAndType(updateParams.getOrgId(),updateParams.getAdvCode(),ADVISER,userCode);
		if(i > 1 || j > 1 ){
			throw new BusinessException(EnumCodeException.E0124);
		}
	}
	public List<ClassManagerVO> getProMag(String type, Integer proId) {
		List<ClassManagerVO> list = new ArrayList<ClassManagerVO>();
		if(StringUtils.isEmpty(type) || proId == null){
			return list;
		}
		list = oPManagerSqlMapper.getProMag(type,proId);
		return list;
	}
	
	/***班级结课，修改该班级的所有学员的状态 xiangui***/
	public int updateStudentClassStatus(Integer opClaId) {
		return organizationalProfessionalMapper.updateStudentClassStatus(opClaId);
	}
	
	

}
