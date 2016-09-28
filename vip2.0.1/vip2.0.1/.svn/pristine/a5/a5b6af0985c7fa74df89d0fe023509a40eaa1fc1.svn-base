package com.moon.vip.application.student;

import java.util.Map;

import com.moon.vip.infra.vo.onReadPage.ParamsVO;

public interface StudentClassSqlMapper {
	
	/**
	 * 根据学员id将该学员的班级信息Valid置为N<br/> 
	 * @Title: updateValidById <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月31日 下午2:19:56  <br/> 
	 * @param id
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int updateValidById(int id);
	
	/**
	 * 根据id 获取到班级id数组<br/> 
	 * @Title: selectGradeByStudentId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月4日 下午4:43:55  <br/> 
	 * @param paramsVO
	 * @return
	 * String
	 * @throws  <br/>
	 */
	public String selectGradeByStudentId(ParamsVO paramsVO);
	
	public int selectGradeInfoId(ParamsVO paramsVO);
	
    /**
      *根据班级ID获取学员数量<br/>
      * @Author：  陈海  - （怡宝 ）<br/>
      * @Title: findStuByClaId <br/>
      * @return int    返回类型 <br/>
      * @date 2016年1月19日 上午10:32:40 <br/>
      * @throws <br/>
      *
     */
	public int findStuByClaId(Integer id);
}