package com.moon.vip.service.impl.student;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.infra.vo.student.PaymentVO;
import com.moon.vip.service.student.IPaymentService;

/**
 * 类名称：TestIPaymentServiceImpl.java<br/>
 * 日期：2015年12月25日 下午4:06:23<br/>
 * 类描述：单元测试支付方式<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年12月25日 向新  TODO<br/>
 * @author Administrator</a><br/>
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestIPaymentServiceImpl {
	
	@Autowired
	private IPaymentService paymentService;
	
	@Test
	public void testSelectAllPayment(){
		List<PaymentVO> payments=new ArrayList<PaymentVO>();
		payments=paymentService.selectAllPayment(0,5);
		System.out.println(payments.size());
		System.out.println(payments);
	}
	
	@Test
	public void testUpdatePayment(){
		PaymentVO payment=new PaymentVO();
		payment.setId(126);
		payment.setCodeValue("支付宝");
		int n=paymentService.updatePayment(payment);
		if(n>0){
			System.out.println("更新成功");
		}
		
	}
	
	@Test
	public void testInsertPayment(){
		PaymentVO payment=new PaymentVO();
		payment.setCodeKey("zhifubao");
		payment.setCodeValue("支付宝");
		payment.setCodeOrder(5);
		Date nowTime = new Date(System.currentTimeMillis());
		payment.setCreateTime(nowTime);
		payment.setModifyTime(nowTime);
		payment.setCreator("xiangxin");
		int n=paymentService.insertPayment(payment);
		if(n>0){
			System.out.println("添加成功");
		}
	}
	
	@Test
	public void testDeletePayment(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(126);
		list.add(127);
		int n=paymentService.deletePayment(list);
		if(n>0){
			System.out.println("删除成功");
		}
	}
	
	@Test
	public void testCount(){
		int number=paymentService.count();
		System.out.println(number);
	}
	
	@Test
	public void testSelectCodeValue(){
		String codeValue="银行卡";
		boolean m=paymentService.checkCodeValue(codeValue);
		if(m){
			System.out.println("唯一");
		}else{
			System.out.println("不唯一");
		}
	}
}
