package com.moon.vip.application.questionnaire;

import com.moon.vip.model.questionnaire.Questionnaire;

public interface QuestionnaireMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vip_questionnaire
     *
     * @mbggenerated Wed Dec 23 16:01:10 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vip_questionnaire
     *
     * @mbggenerated Wed Dec 23 16:01:10 CST 2015
     */
    int insert(Questionnaire record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vip_questionnaire
     *
     * @mbggenerated Wed Dec 23 16:01:10 CST 2015
     */
    int insertSelective(Questionnaire record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vip_questionnaire
     *
     * @mbggenerated Wed Dec 23 16:01:10 CST 2015
     */
    Questionnaire selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vip_questionnaire
     *
     * @mbggenerated Wed Dec 23 16:01:10 CST 2015
     */
    int updateByPrimaryKeySelective(Questionnaire record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vip_questionnaire
     *
     * @mbggenerated Wed Dec 23 16:01:10 CST 2015
     */
    int updateByPrimaryKey(Questionnaire record);
}