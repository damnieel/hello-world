package com.moon.vip.application.student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.onReadPage.ParamsVO;

/**
 * 
* @ClassName: StudentProfessionalSqlMapper 
* @Description: TODO(学生专业表sqlmapper) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月26日 下午5:27:08 
*
 */
public interface StudentProfessionalSqlMapper {
	/**
	 * 
	* @Author：  陈海  - （怡宝 ）
	* @Title: getStudentIdByCode 
	* @Description: TODO(根据学员编号获取学生Id) 
	* @param @param studentCode
	* @param @return    设定文件 
	* @return List<Integer>    返回类型 
	* @date 2015年12月26日 下午5:28:37 
	* @throws
	 */
	public List<Integer> getStudentIdByCode(String studentCode);
	
	/**
	*  删除未分班学员专业信息  将is_valid更新为N<br/> 
	* @Title: setValidArchProf <br/> 
	* @Description: TODO <br/> 
	* @auther hanfeng <br/> 
	* @version 创建时间：2015年12月29日 下午8:12:30  <br/> 
	 * @param integer 
	* @param id
	* @return
	* int
	* @throws  <br/>
	*/
	public int updateValidProfByStudentId(@Param("studentId")int studentId, @Param("profOrgId")int profOrgId);
	
	/**
	 * 获取专业信息id ，并检测数据是否正确<br/> 
	 * @Title: selectProfIdtoUpdata <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月5日 下午7:02:17  <br/> 
	 * @param paramsVO
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int selectProfIdtoUpdata(ParamsVO paramsVO);
}