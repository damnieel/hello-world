package com.moon.vip.application.sys;

import com.moon.vip.infra.vo.sys.SequenceVO;

/**
 * 类名称：ProfessionSequenceSqlMapper.java<br/>
 * 日期：2016年1月19日 下午6:19:16<br/>
 * 类描述：专业序列号对应表<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年1月19日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public interface ProfessionSequenceSqlMapper {

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

}
