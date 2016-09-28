package com.moon.vip.application.assignment;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.model.assignment.SchoolAssignmentDetail;

public interface SchoolAssignmentDetailSqlMapper {
	/**
	 * 根据学员id获取其作业记录的个数<br/> 
	 * @Title: selectCountByStudentId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月31日 上午11:07:03  <br/> 
	 * @param id
	 * @param profOrgId 
	 * @param gradeOrgId 
	 * @return
	 * Integer
	 * @throws  <br/>
	 */
	public int selectCountByStudentId(@Param("id")int id,@Param("gradeOrgId")int gradeOrgId, @Param("profOrgId")int profOrgId);
	
	
    /**
     *更新作业记录<br/>
     * @Author： zhumin<br/>
     * @param record 
     * @Title: updateRecordByParams <br/>
     * @return int    返回类型 <br/>
     * @date 2016年5月21日 下午8:27:40 <br/>
     * @throws <br/>
     *
    */
	public int updateRecordByParams(@Param("id")int id,@Param("gradeOrgId")int gradeOrgId, @Param("profOrgId")int profOrgId);
}