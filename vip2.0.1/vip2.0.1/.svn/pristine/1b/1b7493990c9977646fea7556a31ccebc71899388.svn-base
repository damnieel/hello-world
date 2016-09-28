package com.moon.vip.application.student;

import org.apache.ibatis.annotations.Param;
import com.moon.vip.infra.vo.student.PaymentVO;
import java.util.List;

/**
 * 支付方式模块
 * PaymentMapper<BR>
 * 创建人:向新 <BR>
 * 时间：2015年12月25日-下午3:14:34 <BR>
 * @version 1.0.0
 * 
 */
public interface PaymentMapper {
	
	/**
	 * 展示全部支付方式<BR>
	 * 方法名：selectAllPayment<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年12月25日-下午3:14:34 <BR>
	 * @param offset
	 * @param pageSize
	 * @return List<PaymentVO><BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	List<PaymentVO> selectAllPayment(@Param("offset")Integer offset,@Param("pageSize")Integer pageSize);
	
	 /**
	  * 添加支付方式<BR>
	  * 方法名：insertPayment<BR>
	  * 创建人：向新 <BR>
	  * 时间：2015年12月25日-下午3:14:34 <BR>
	  * @param PaymentVO
	  * @return int<BR>
	  * @exception <BR>
	  * @since  1.0.0
	  */
	int insertPayment(PaymentVO payment);
	
	/**
	 * 修改支付方式<BR>
	 * 方法名：updatePayment<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年12月25日-下午3:14:34 <BR>
	 * @param PaymentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	int updatePayment(PaymentVO payment);
	
	/**
	 * 删除支付方式<BR>
	 * 方法名：deletePayment<BR>
	 * 创建人：向新<BR>
	 * 时间：2015年12月25日-下午3:14:34 <BR>
	 * @param PaymentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	int deletePayment(List<Integer> id);
	
	/**
	 * 统计支付方式条数<BR>
	 * 方法名：count<BR>
	 * 创建人：向新<BR>
	 * 时间：2015年1月6日-下午4:14:34 <BR>
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	int count();
	
	/**
	 * 通过id查询支付方式<BR>
	 * 方法名：selectPaymentById<BR>
	 * 创建人：向新<BR>
	 * 时间：2015年1月6日-下午4:14:34 <BR>
	 * @param id
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	String selectPaymentById(Integer id);
	
	/**
	 * 查询所有支付方式<BR>
	 * 方法名：selectCodeValue<BR>
	 * 创建人：向新<BR>
	 * 时间：2015年1月11日-下午3:14:34 <BR>
	 * @return List<String><BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	List<String> selectCodeValue();
	
	/**
	 * 查询codeOrder的最大值<BR>
	 * 方法名：selectCodeOrder<BR>
	 * 创建人：向新<BR>
	 * 时间：2015年1月11日-下午3:14:34 <BR>
	 * @return int<String><BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	int selectMaxCodeOrder();
}
