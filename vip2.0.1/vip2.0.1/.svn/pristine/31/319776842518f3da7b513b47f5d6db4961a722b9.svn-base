package com.moon.vip.service.impl.questionnaire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.questionnaire.QuestionnaireSqlMapper;
import com.moon.vip.infra.vo.questionnaire.EmployeeVO;
import com.moon.vip.infra.vo.questionnaire.QuestionnaireVO;
import com.moon.vip.service.questionnaire.IQuestionnaireService;
import com.moon.vip.service.sys.IOrgProfessionalService;

/**
 * 问卷调查
 * QuestionnaireServiceImpl<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月25日-下午4:43:54 <BR>
 * @version 1.0.0
 * 
 */
@Service("questionnaire")
public class QuestionnaireServiceImpl implements IQuestionnaireService {

	@Autowired
	private QuestionnaireSqlMapper questionnaireSqlMapper;
	
	@Autowired
	private IOrgProfessionalService iOrgProfessionalService;
	
	/***解析组织机构**/
	private QuestionnaireVO convertOrgId(QuestionnaireVO questionnaireVO){
		if(questionnaireVO.getOrganizationId() != null) {
			questionnaireVO.setSearchOpClaIds(
					iOrgProfessionalService.covertOrgSearch(questionnaireVO.getOrganizationId()));
		}
		return questionnaireVO;
	}
	
	/***根据角色查询所有数据***/
	public List<QuestionnaireVO> selectByRoleDate(QuestionnaireVO questionnaireVO) {
		questionnaireVO = convertOrgId(questionnaireVO);
		return questionnaireSqlMapper.selectByRoleDate(questionnaireVO);
	}

	/***修改问卷调查记录***/
	public int updateByRoleDate(QuestionnaireVO questionnaireVO) {
		return questionnaireSqlMapper.updateByRoleDate(questionnaireVO);
	}

	/***添加问卷调查记录***/
	public int insertByRoleDate(QuestionnaireVO questionnaireVO) {
		return questionnaireSqlMapper.insertByRoleDate(questionnaireVO);
	}
	
	/***删除问卷调查***/
	public int deleteQuestionnaire(Integer id) {
		return questionnaireSqlMapper.deleteQuestionnaire(id);
	}

	/***根据昵称查询员工信息***/
	public EmployeeVO selectByNikeName(String nickName) {
		return questionnaireSqlMapper.selectByNikeName(nickName);
	}

	/***根据工号查询昵称和姓名***/
	public EmployeeVO selectByCode(String employeeCode) {
		return questionnaireSqlMapper.selectByCode(employeeCode);
	}

	/***根据专业id查询专业名称***/
	public List<QuestionnaireVO> selectCourseNameByID(Integer id) {
		return questionnaireSqlMapper.selectCourseNameByID(id);
	}

	/***查询问卷总数***/
	public int selectCount(QuestionnaireVO questionnaireVO) {
		questionnaireVO = convertOrgId(questionnaireVO);
		return questionnaireSqlMapper.selectCount(questionnaireVO);
	}

	/***查看问卷详情***/
	public QuestionnaireVO questionnaireDetail(Integer id) {
		return questionnaireSqlMapper.questionnaireDetail(id);
	}

	/***查询集群***/
	public List<QuestionnaireVO> selectCluster(Integer id) {
		return questionnaireSqlMapper.selectCluster(id);
	}

	/***查询部门**/
	public List<QuestionnaireVO> selectDepartment(Integer id) {
		return questionnaireSqlMapper.selectDepartment(id);
	}

}
