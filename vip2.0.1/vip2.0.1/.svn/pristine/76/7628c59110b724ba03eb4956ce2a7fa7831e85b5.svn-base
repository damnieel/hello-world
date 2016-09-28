package com.moon.vip.service.impl.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.student.ProfessionalVO;
import com.moon.vip.infra.vo.sys.EmployeeBaseVO;
import com.moon.vip.infra.vo.sys.OrganizationalProfessionalVO;
import com.moon.vip.infra.vo.sys.TeacherVO;
import com.moon.vip.model.major.MajorFrame;
import com.moon.vip.service.sys.IClassInFoService;
/**
 * 班级信息
 * ClassInFoServiceImpl<BR>
 * 创建人:龙金 <BR>
 * 时间：2015年12月30日-下午3:30:54 <BR>
 * @version 1.0.0
 * 
 */
@Service("classinfo")
public class ClassInFoServiceImpl implements IClassInFoService{
    private static Logger logger =Logger.getLogger(ClassInFoServiceImpl.class);
	@Autowired
	private OrganizationalProfessionalSqlMapper organizationalprofessionalSqlMapper;
	//结课
	public int updateIsValid(Integer id) {
		
		return organizationalprofessionalSqlMapper.updateIsValid(id);
	}

	//根据事业不查询聚群
	public String selectOrgById(Integer id) {
		
		return organizationalprofessionalSqlMapper.selectOrgById(id);
	}
    //根据事业部查询查询所以的专业
	public List<OrganizationalProfessionalVO> selectAllMar(Integer id) {
		
		return organizationalprofessionalSqlMapper.selectAllMar(id);
	}
	
	//根据专业id查询专业名称
	public Integer selectCourseNameByID(String bName) {
		
		return organizationalprofessionalSqlMapper.selectCourseNameByID(bName);
	}
	//根据班级名称获取班级的id
	public Integer selectClaByName() {
		
		return organizationalprofessionalSqlMapper.selectClaByName();
	}
	// 根据讲师和班主任获取employee_code 
	public String selectTeacherByname(String name) {
		
		return organizationalprofessionalSqlMapper.selectTeacherByname(name);
	}
	public String  selectAdiser(String nickName){
		
		return organizationalprofessionalSqlMapper.selectAdiser(nickName);
	}
	/**查出集群**/ 
	public List<OrganizationalProfessionalVO> selectColony() {
		return organizationalprofessionalSqlMapper.selectColony();
		
	}
	
    /**查出事业部**/
	public List<OrganizationalProfessionalVO> selectDivision() {
		return organizationalprofessionalSqlMapper.selectDivision();
	}

	/**查出专业**/
	public List<OrganizationalProfessionalVO> selectMajor() {
		return organizationalprofessionalSqlMapper.selectMajor();
	}

	/**查出班级**/
	public List<OrganizationalProfessionalVO> selectClass() {
		return organizationalprofessionalSqlMapper.selectClass() ;
	}
	
    
	public boolean insertClass(OrganizationalProfessionalVO org,TeacherVO teacherVO){
		try{
			addClass(org);
			addTeacher(teacherVO);
			/*addEmployee(employeebaseVO);*/
			
			return true;
		}catch(Exception e){
			logger.error("插入班级失败");
			throw new BusinessException(EnumCodeException.E0116);
		}
		//return "success";
		
	}
	//**增加班级**//*
	public int addClass(OrganizationalProfessionalVO organizationalprofessionalVO) {
		
		return organizationalprofessionalSqlMapper.addClass(organizationalprofessionalVO);
	}
	public int addTeacher(TeacherVO teacherVO) {
	    return organizationalprofessionalSqlMapper.addTeacher(teacherVO);
	}

	/*public int addEmployee(EmployeeBaseVO employeebaseVO) {
		return organizationalprofessionalSqlMapper.addEmployee(employeebaseVO);
	}*/



	/**更新班级**/
	public int updateClass(OrganizationalProfessionalVO organizationalprofessionalVO) {
		return organizationalprofessionalSqlMapper.updateClass(organizationalprofessionalVO);
	}

	/**删除班级**/
	public int delClass(Integer id){
		return organizationalprofessionalSqlMapper.delClass(id);
	}
  
	
    /**展现全部班级**/
	public List<OrganizationalProfessionalVO> selectAllClass(Integer id,Integer offset, Integer pageSize) {
		
		return organizationalprofessionalSqlMapper.selectAllClass(id,offset, pageSize);
	}
    /**班级总数**/
	public int selectClaCount(Integer id ) {
	
		return organizationalprofessionalSqlMapper.selectClaCount(id);
	}

	public List<OrganizationalProfessionalVO> selectInfoById(OrganizationalProfessionalVO id) {
	
		id.setId(1); //初始化
		return organizationalprofessionalSqlMapper.selectInfoById(id);
	}
    //查询老师和班主任
	public List<OrganizationalProfessionalVO> selectTecher() {
		
		return organizationalprofessionalSqlMapper.selectTecher();
	}

	public List<OrganizationalProfessionalVO> selectAdviser() {
	
		return organizationalprofessionalSqlMapper.selectAdviser();
	}

	

	
	
	

}
