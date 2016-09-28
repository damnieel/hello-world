package com.moon.vip.application.student;

import java.util.List;

import com.moon.vip.infra.vo.onReadPage.OnReadPageStudentsVO;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
public interface ArchProfOrgProfClassSqlMapper {
	/**
	 * 查找所有未分班学员<br/> 
	 * @Title: selectUndivStudent <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月29日 下午2:20:39  <br/> 
	 * @return
	 * List<OnReadPageStudentsVO>
	 * @throws  <br/>
	 */
	public List<OnReadPageStudentsVO> selectUndivStudent(ParamsVO paramsVO);
	
	/**
	 * 获取未分班总数<br/> 
	 * @Title: selectUndivStudentCount <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月31日 下午3:45:09  <br/> 
	 * @param paramsVO 
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int selectUndivStudentCount(ParamsVO paramsVO);

	/**
	 * 查找所有已分班学员<br/> 
	 * @Title: selectUndivStudent <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月29日 下午4:14:52  <br/> 
	 * @return
	 * List<OnReadPageStudentsVO>
	 * @throws  <br/>
	 */
	public List<OnReadPageStudentsVO> selectDivedStudent(ParamsVO paramsVO);
	/**
	 * 获取已分班总数<br/> 
	 * @Title: selectUndivStudentCount <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月31日 下午3:45:09  <br/> 
	 * @param paramsVO 
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int selectDivedStudentCount(ParamsVO paramsVO);
	
	/**
	 * 查找非在读学员的总数<br/> 
	 * @Title: selectNotReadStudentCount <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月5日 下午4:02:20  <br/> 
	 * @param paramsVO 
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int selectNotReadStudentCount(ParamsVO paramsVO);
	/**
	 * 查找非在读学员的详细信息<br/> 
	 * @Title: selectNotReadStudent <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月5日 下午4:04:08  <br/> 
	 * @param paramsVO
	 * @return
	 * List<OnReadPageStudentsVO>
	 * @throws  <br/>
	 */
	public List<OnReadPageStudentsVO> selectNotReadStudent(ParamsVO paramsVO);
} 
