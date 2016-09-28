package com.moon.vip.service.impl.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.student.StudentRepeatSqlMapper;
import com.moon.vip.infra.vo.student.StudentVO;
import com.moon.vip.service.student.IStudentRepeatService;
import com.moon.vip.service.sys.IOrgProfessionalService;

/**
 * 查询所有学员信息
 * StudentRepeatServiceImpl<BR>
 * 创建人:娴贵 <BR>
 * 时间：2016年1月23日-下午2:00:03 <BR>
 * @version 1.0.0
 * 
 */
@Service("StudentRepeatService")
public class StudentRepeatServiceImpl implements IStudentRepeatService {
	@Autowired
	private StudentRepeatSqlMapper repeatSqlMapper;

	@Autowired
	private IOrgProfessionalService iOrgProfessionalService;
	
	/***解析组织机构**/
	private StudentVO convertOrgId(StudentVO studentVO){
		if(studentVO.getOrganizationId() != null) {
			studentVO.setSearchOpClaIds(
					iOrgProfessionalService.covertOrgSearch(studentVO.getOrganizationId()));
		}
		return studentVO;
	}
	
	/***查询所有的学员信息***/
	public List<StudentVO> allStudentArchives(StudentVO studentVO) {
		studentVO = convertOrgId(studentVO);
		return repeatSqlMapper.allStudentArchives(studentVO);
	}

	/***删除重复的学员信息***/
	public int deleteStudentArchives(Integer id) {
		return repeatSqlMapper.deleteStudentArchives(id);
	}

	/***查询重复的记录是否有关联的专业***/
	public int stuRelevanceProfessional(Integer id) {
		return repeatSqlMapper.stuRelevanceProfessional(id);
	}

	/***查询学员信息所有记录的总数***/
	public int allStudentArchivesCount(StudentVO studentVO) {
		studentVO = convertOrgId(studentVO);
		return repeatSqlMapper.allStudentArchivesCount(studentVO);
	}

}
