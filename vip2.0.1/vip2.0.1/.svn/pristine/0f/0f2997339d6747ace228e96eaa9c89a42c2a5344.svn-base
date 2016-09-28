package com.moon.vip.service.onReadStudent;

import java.util.List;
import java.util.Map;

import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.vo.onReadPage.OnReadPageStudentsVO;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.infra.vo.sys.OrgProfessionalInfoVO;

public interface IDivideGradeService {

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
	 * 查找所有已分班学员<br/> 
	 * @Title: selectUndivStudent <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月29日 下午4:17:33  <br/> 
	 * @param paramsVO 
	 * @return
	 * List<OnReadPageStudentsVO>
	 * @throws  <br/>
	 */
	public List<OnReadPageStudentsVO> selectDivedStudent(ParamsVO paramsVO);
	
	/**
	 * 判断这些员工是否有访谈记录<br/> 
	 * @Title: hasInterview <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月29日 下午6:10:54  <br/> 
	 * @param nameArray 
	 * @param idString
	 * @return
	 * boolean
	 * @throws  <br/>
	 */
	public String hasInterviews(ParamsVO paramsVO);
	
	/**
	 *  删除未分班学员信息  将is_valid更新为N<br/> 
	 * @Title: updateValidArchProf <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月29日 下午8:16:27  <br/> 
	 * @param string 
	 * @param id
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public void updateValidArchProf(String idArray, String string);
	
	/**
	 * 将这些学员分班<br/> 
	 * @Title: divideGrade <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月30日 下午3:56:15  <br/> 
	 * @param studentIds
	 * @param grades
	 * @param profName
	 * void
	 * @throws  <br/>
	 */
	public void divideGrade(ParamsVO paramsVO);
	
	/**
	 * 根据profName获取该专业下的班级id和名称<br/> 
	 * @Title: getClassesByprofName <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月30日 下午4:42:09  <br/> 
	 * @param profName
	 * void
	 * @throws  <br/>
	 */
	public List<OrgProfessionalInfoVO> getClassesByprofName(String profName);
	
	/**
	 * 删除已分班学员班级信息<br/> 
	 * @Title: delDivedStudent <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月30日 下午8:44:08  <br/> 
	 * @param paramsVO
	 * void
	 * @return 
	 * @throws  <br/>
	 */
	public Message delDivedStudent(ParamsVO paramsVO);
	/**
	 * 获取未分班总数<br/> 
	 * @Title: selectUndivStudentCount <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月31日 下午3:47:12  <br/> 
	 * @param paramsVO 
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int selectUndivStudentCount(ParamsVO paramsVO);
	/**
	 * 获取已分班总数<br/> 
	 * @Title: selectDivedStudentCount <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月31日 下午4:04:24  <br/> 
	 * @param paramsVO 
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int selectDivedStudentCount(ParamsVO paramsVO);
	
	/**
	 * 根据id 获取到班级id数组<br/> 
	 * @Title: selectGradeByStudentId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月4日 下午4:42:57  <br/> 
	 * @param paramsVO
	 * @return
	 * String
	 * @throws  <br/>
	 */
	public String selectGradeByStudentId(ParamsVO paramsVO); 
	
	/**
	 * 重新分班实现<br/> 
	 * @Title: reDivideGrade <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月5日 上午10:58:50  <br/> 
	 * @param paramsVO
	 * void
	 * @return 
	 * @throws  <br/>
	 */
	public Message reDivideGrade(ParamsVO paramsVO);
	
	public Message reDivideGradeConfirm(ParamsVO paramsVO);
	/**
	 * 根据码表内容转换显示字段<br/> 
	 * @Title: convertCodeTable <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年2月26日 下午8:41:27  <br/> 
	 * @param onReadListOriginal
	 * @return
	 * List<OnReadPageStudentsVO>
	 * @throws  <br/>
	 */
	public List<OnReadPageStudentsVO> convertCodeTable(List<OnReadPageStudentsVO> onReadListOriginal);
}
