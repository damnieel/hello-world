package com.moon.vip.service.student;

import org.apache.ibatis.annotations.Param;
import com.moon.vip.infra.vo.student.PaymentVO;
import java.util.List;


/**
 * 支付方式模块
 * IPaymentService<BR>
 * 创建人:向新 <BR>
 * 时间：2015年12月25日-下午3:24:34 <BR>
 * @version 1.0.0
 * 
 */
public interface IPaymentService {
	
	/**
	 * 展示全部支付方式<BR>
	 * 方法名：selectAllPayment<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年12月25日-下午3:24:34 <BR>
	 * @param offset
	 * @param pageSize
	 * @return List<PaymentVO><BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public List<PaymentVO> selectAllPayment(@Param("offset")Integer offset,@Param("pageSize")Integer pageSize);
	
	/**
	 * 添加支付方式<BR>
	 * 方法名：insertPayment<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年12月25日-下午3:26:34 <BR>
	 * @param PaymentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public int insertPayment(PaymentVO payment);
	
	/**
	 * 修改支付方式<BR>
	 * 方法名：updatePayment<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年12月25日-下午3:26:34 <BR>
	 * @param PaymentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public int updatePayment(PaymentVO payment);
	
	/**
	 * 删除支付方式<BR>
	 * 方法名：deletePayment<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年12月25日-下午3:26:34 <BR>
	 * @param List<Integer>
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public int deletePayment(List<Integer> id);
	
	/**
	 * 计算数据条数<BR>
	 * 方法名：count<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年12月25日-下午3:26:34 <BR>
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public int count();
	
	/**
	 * 生成一个codeOrder<BR>
	 * 方法名：createCodeOrder<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年12月25日-下午3:26:34 <BR>
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public int createCodeOrder();
	
	/**
	 * 通过id号查询支付方式<BR>
	 * 方法名：selectPaymentById<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年12月25日-下午3:26:34 <BR>
	 * @param id
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public String selectPaymentById(Integer id);
	
	/**
	 * 查询所有支付方式<BR>
	 * 方法名：checkCodeValue<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年1月11日-下午3:26:34 <BR>
	 * @param codeValue
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public boolean checkCodeValue(String codeValue);
}
