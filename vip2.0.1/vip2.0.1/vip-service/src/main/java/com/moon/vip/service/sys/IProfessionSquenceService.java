package com.moon.vip.service.sys;

import java.util.Date;

import com.moon.vip.infra.vo.sys.SequenceVO;

/**
 * 专业编号自动生成类
 * IProfessionSquenceService<BR>
 * 创建人:娴贵 <BR>
 * 时间：2016年1月19日-下午8:16:44 <BR>
 * @version 1.0.0
 * 
 */
public interface IProfessionSquenceService {

	/**
	 * 查询编号序列号<BR>
	 * 方法名：selectSequence<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月19日-下午8:13:09 <BR>
	 * @param sequenceVO
	 * @return SequenceVO<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public SequenceVO selectSequence(SequenceVO sequenceVO);
	
	/**
	 * 更新编号序列号<BR>
	 * 方法名：updateSequence<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月19日-下午8:13:40 <BR>
	 * @param sequenceVO
	 * @return SequenceVO<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int updateSequence(SequenceVO sequenceVO);
	
	/**
	 * 添加编号序列号<BR>
	 * 方法名：insertSequence<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月19日-下午8:13:53 <BR>
	 * @param sequenceVO
	 * @return SequenceVO<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public int insertSequence(SequenceVO sequenceVO);
	
	/**
	 * 学员专业编号生成<BR>
	 * 方法名：getStudentCode<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月20日-上午10:21:43 <BR>
	 * @param enterDate
	 * @param professionId
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	public String getStudentCode(Date enterDate,Integer professionId);
}
