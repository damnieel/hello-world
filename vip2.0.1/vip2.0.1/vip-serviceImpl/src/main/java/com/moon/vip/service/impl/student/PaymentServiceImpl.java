package com.moon.vip.service.impl.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.student.PaymentMapper;
import com.moon.vip.infra.vo.student.PaymentVO;
import com.moon.vip.service.student.IPaymentService;

/**
 * 支付方式模块
 * PaymentServiceImpl<BR>
 * 创建人:向新 <BR>
 * 时间：2015年12月25日-下午3:44:05 <BR>
 * @version 1.0.0
 * 
 */
@Service("PaymentService")
public class PaymentServiceImpl implements IPaymentService{

	@Autowired
	private PaymentMapper paymentMapper;
	
	/** 展示全部支付方式 **/
	public List<PaymentVO> selectAllPayment(Integer offset, Integer pageSize) {
		return paymentMapper.selectAllPayment(offset, pageSize);
	}

	/** 添加支付方式**/
	public int insertPayment(PaymentVO payment) {
		return paymentMapper.insertPayment(payment);
	}

	/** 修改支付方式**/
	public int updatePayment(PaymentVO payment) {
		return paymentMapper.updatePayment(payment);
	}

	/** 删除支付方式**/
	public int deletePayment(List<Integer> id) {
		return paymentMapper.deletePayment(id);
	}
	
	/** 统计数据条数**/
	public int count() {
		int number=paymentMapper.count();
		return number;
	}
	
	/** 生成一个codeOrder**/
	public int createCodeOrder() {
		/** 通过查询codeOrder最大值**/
		int number=paymentMapper.selectMaxCodeOrder();
		/** 判断是否存在数据**/
		if(number<0){
			number=1;
		}else{
		number++;
		}
		return number;
	}
	
	/** 通过id号查询支付方式**/
	public String selectPaymentById(Integer id) {
		return paymentMapper.selectPaymentById(id);
	}
	
	/** 比较codeValue是否重复**/
	public boolean checkCodeValue(String codeValue) {
		List<String> codeValues=paymentMapper.selectCodeValue();
		boolean flag=true;
		for(int i=0;i<codeValues.size();i++){
			if(codeValues.get(i).equals(codeValue)){
				flag=false;
				break;
			}
		}
		/** 返回true则表示没有相同的**/
		if(flag==true){
			return true;
		}
		return false;
	}
	
}
