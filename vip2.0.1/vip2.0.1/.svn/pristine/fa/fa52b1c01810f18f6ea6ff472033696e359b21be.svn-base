package com.moon.vip.application.questionnaire;

import java.util.List;



import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.questionnaire.EmployeeVO;
import com.moon.vip.infra.vo.questionnaire.QuestionnaireVO;

/**
 * 问卷调查
 * QuestionnaireSqlMapper<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月25日-下午4:03:03 <BR>
 * @version 1.0.0
 * 
 */
public interface QuestionnaireSqlMapper {

	  
    /**
     * 根据角色获取全部数据<BR>
     * 方法名：selectByRoleDate<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月25日-下午4:41:37 <BR>
     * @return List<QuestionnaireVO><BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public List<QuestionnaireVO> selectByRoleDate(QuestionnaireVO questionnaireVO);
    
    /**
     * 根据专业id查询专业名称<BR>
     * 方法名：selectCourseNameByID<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月5日-下午8:38:19 <BR>
     * @param id
     * @return QuestionnaireVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public List<QuestionnaireVO> selectCourseNameByID(@Param("id")Integer id);
    
    
    /**
     * 查询集群<BR>
     * 方法名：selectCluster<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月14日-下午6:59:59 <BR>
     * @param id
     * @return QuestionnaireVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public List<QuestionnaireVO> selectCluster(@Param("id")Integer id);
    
    
    /**
     * 查询部门<BR>
     * 方法名：selectDepartment<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月14日-下午7:00:17 <BR>
     * @param id
     * @return QuestionnaireVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public List<QuestionnaireVO> selectDepartment(@Param("id")Integer id);
    
    /**
     * 查询总数<BR>
     * 方法名：selectCount<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月5日-下午9:01:18 <BR>
     * @param questionnaireVO
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int selectCount(QuestionnaireVO questionnaireVO);
    
    /**
     * 查看问卷详情<BR>
     * 方法名：questionnaireDetail<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年1月6日-下午8:46:20 <BR>
     * @param id
     * @return QuestionnaireVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public QuestionnaireVO questionnaireDetail(@Param("id")Integer id);
    
    /**
     * 修改问卷调查记录<BR>
     * 方法名：updateByRoleDate<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月25日-下午4:42:04 <BR>
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int updateByRoleDate(QuestionnaireVO questionnaireVO);
    
    /**
     * 添加问卷调查记录<BR>
     * 方法名：insertByRoleDate<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月25日-下午4:42:24 <BR>
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int insertByRoleDate(QuestionnaireVO questionnaireVO);
	
    /**
     * 删除调查问卷<BR>
     * 方法名：deleteQuestionnaire<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月25日-下午4:03:28 <BR>
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int deleteQuestionnaire(Integer id);
    
    /**
     * 根据昵称查询员工信息<BR>
     * 方法名：selectByNikeName<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月26日-下午6:16:24 <BR>
     * @param nickName
     * @return EmployeeVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public EmployeeVO selectByNikeName(String nickName);
    
    /**
     * 根据工号查询昵称和姓名<BR>
     * 方法名：selectByCode<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月26日-下午6:38:32 <BR>
     * @param employeeCode
     * @return EmployeeVO<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public EmployeeVO selectByCode(String employeeCode);
    
}