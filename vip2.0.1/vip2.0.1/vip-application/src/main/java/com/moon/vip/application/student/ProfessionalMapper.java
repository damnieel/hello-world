package com.moon.vip.application.student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.student.ProfessionalVO;


/**
 * 职业数据模块
 * ProfessionalMapper<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月23日-下午7:36:32 <BR>
 * @version 1.0.0
 * 
 */
public interface ProfessionalMapper {
	
	/**
	 * 展示全部职业数据<BR>
	 * 方法名：selectAllProfessional<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月23日-下午7:39:19 <BR>
	 * @param offset
	 * @param pageSize
	 * @return List<ProfessionalVO><BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public List<ProfessionalVO> selectAllProfessional(@Param("offset")Integer offset,@Param("pageSize")Integer pageSize);
   
	/**
	 * 获取总数<BR>
	 * 方法名：selectProCount<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月8日-下午1:13:35 <BR>
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int selectProCount();
	
	/**
	 * 根据id查看详情<BR>
	 * 方法名：selectDetail<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月8日-下午5:02:53 <BR>
	 * @param id
	 * @return ProfessionalVO<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public ProfessionalVO selectDetail(@Param("id")Integer id);
	
    /**
	 * 添加职业数据<BR>
	 * 方法名：insertProfessional<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月23日-下午7:40:58 <BR>
	 * @param professionalVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public int insertProfessional(ProfessionalVO professionalVO);
	
	/**
	 * 查询码表中职业数据key和order的最大值<BR>
	 * 方法名：selectMaxKey<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月24日-下午4:53:30 <BR>
	 * @return ProfessionalVO<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public ProfessionalVO selectMaxKey();
   
   /**
	 * 修改职业数据<BR>
	 * 方法名：updateProfessional<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月23日-下午7:44:25 <BR>
	 * @param professionalVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public int updateProfessional(ProfessionalVO professionalVO);

   /**
	 * 批量删除职业数据<BR>
	 * 方法名：deleteProfessional<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月23日-下午7:44:42 <BR>
	 * @param ProfessionalVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public int deleteProfessional(List<Integer> id);
   
   
    /**
	 * 根据专业查询专业的前缀（用于学员编号）<BR>
	 * 方法名：selectCoursePrefix<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月24日-下午2:04:00 <BR>
	 * @param course
	 * @return ProfessionalVO<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public ProfessionalVO selectCoursePrefix(Integer course);
	
	/**
	 * 查询所有的下拉值（用于学员信息）<BR>
	 * 方法名：selectALLDownbox<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月24日-下午2:05:58 <BR>
	 * @return List<ProfessionalVO><BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public List<ProfessionalVO> selectALLDownbox();
	
	/**
	 * 查询是否存在职业记录<BR>
	 * 方法名：selectIsExist<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月20日-下午7:09:13 <BR>
	 * @param codeValue
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int selectIsExist(@Param("codeValue")String codeValue);
}
