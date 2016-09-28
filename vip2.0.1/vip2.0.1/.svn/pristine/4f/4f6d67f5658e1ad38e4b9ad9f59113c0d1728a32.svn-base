package com.moon.vip.application.student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.excel.UploadStudentVO;
import com.moon.vip.model.student.StudentArchives;

public interface ArchivesProfOrgProfSqlMapper {
	/**
	 * 根据QQ查找学员信息， 上传Excel功能<br/> 
	 * @Title: selectExcelClumByQQ <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月25日 下午7:24:52  <br/> 
	 * @param QQ
	 * @param opProId 
	 * @return
	 * UploadStudentVO
	 * @throws  <br/>
	 */
	public UploadStudentVO selectExcelClumByQQ(@Param("QQ")String QQ, @Param("opProId")String opProId);
	
	/**
	 * 根据QQ查找学员信息<br/> 
	 * @Title: selectArchByQQ <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月28日 下午6:20:15  <br/> 
	 * @param QQ
	 * @return
	 * UploadStudentVO
	 * @throws  <br/>
	 */
	public List<UploadStudentVO> selectArchByQQ(@Param("QQ")String QQ);
	
	/**
	 * 插入新学员基本信息<br/> 
	 * @Title: insertStudentData <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月26日 下午1:31:52  <br/> 
	 * @param uploadStudentVO
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int insertStudentData(StudentArchives studentArchives);
	
	/**
	 *  删除未分班学员信息  将is_valid更新为N<br/> 
	 * @Title: setValidArchProf <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月29日 下午8:12:30  <br/> 
	 * @param id
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int updateValidArchProf(int id);
}
