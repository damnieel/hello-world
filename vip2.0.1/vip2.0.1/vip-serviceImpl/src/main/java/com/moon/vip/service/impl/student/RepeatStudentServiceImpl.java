package com.moon.vip.service.impl.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.student.RepeatStudentSqlMapper;
import com.moon.vip.infra.vo.student.RepeatStudentVO;
import com.moon.vip.service.student.IRepeatStudentService;
import com.moon.vip.service.sys.IOrgProfessionalService;

/**
 * 重复数据模块（专业编号相同）
 * RepeatStudentServiceImpl<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月31日-下午1:54:48 <BR>
 * @version 1.0.0
 * 
 */
@Service("RepeatStudentService")
public class RepeatStudentServiceImpl implements IRepeatStudentService{

	@Autowired
	private RepeatStudentSqlMapper repeatStudentService;
	
	@Autowired
	private IOrgProfessionalService iOrgProfessionalService;

	/***解析组织机构**/
	private RepeatStudentVO convertOrgId(RepeatStudentVO repeatStudentVO){
		if(repeatStudentVO.getOrganizationId() != null) {
			repeatStudentVO.setSearchOpClaIds(
					iOrgProfessionalService.covertOrgSearch(repeatStudentVO.getOrganizationId()));
		}
		return repeatStudentVO;
	}
	
	/***查询所有的重复数据***/
	public List<RepeatStudentVO> selectRepeatStudent(RepeatStudentVO repeatStudentVO) {
		repeatStudentVO = convertOrgId(repeatStudentVO);
		return repeatStudentService.selectRepeatStudent(repeatStudentVO);
	}

	/***修改学员专业编号***/
	public int updateStuProCode(RepeatStudentVO repeatStudentVO) {
		return repeatStudentService.updateStuProCode(repeatStudentVO);
	}

	/***查询修改后的专业编号是否存在***/
	public int selectStuProCode(Integer id,String professionCode) {
		return repeatStudentService.selectStuProCode(id,professionCode);
	}

	/***查询专业编号重复记录的总数***/
	public int selectRepeatStudentCount(RepeatStudentVO repeatStudentVO) {
		repeatStudentVO = convertOrgId(repeatStudentVO);
		return repeatStudentService.selectRepeatStudentCount(repeatStudentVO);
	}

}
