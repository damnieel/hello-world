package com.moon.vip.controller.student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.controller.BaseController;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.student.PaymentVO;
import com.moon.vip.service.student.IPaymentService;

/**
 * 类名称：PaymentController.java<br/>
 * 日期：2015年12月31日 下午3:46:43<br/>
 * 类描述：支付方式控制器<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * @author 向新</a><br/>
 * @version 1.0.0
 */

@Controller
@RequestMapping("/admin/payment")
public class PaymentController extends BaseController{
	
	private static Logger logger = Logger.getLogger(PaymentController.class);
	@Autowired
	private IPaymentService paymentService;
	
	@RequestMapping("/payment")
	public ModelAndView payment(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/page/paymentWay/payment");
		return mv;
	}
	
	/**
	 * 显示支付方式<BR>
	 * 方法名：PaymentList<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年1月6日-下午1:27:10 <BR>
	 * @return ModelAndView<BR>
	 * @throws SQLException 
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping("/paymentList")
	public ModelAndView PaymentList(Integer offset,Integer pageSize) throws SQLException{
		ModelAndView mv=new ModelAndView();
		List<PaymentVO> paymentList=new ArrayList<PaymentVO>();
		/** 返回查询到的数据**/
		paymentList=paymentService.selectAllPayment(offset,pageSize);
		/** 查询数据条数用于分页**/
		int count=paymentService.count();
		if(null == paymentList || paymentList.size() == 0){
			logger.error("查询支付方式出错");
			throw new SQLException("查询支付方式出错");
		}
		/** 返回用于分页控制**/
		mv.addObject("offset",offset);
		mv.addObject("count",count);
		mv.addObject("paymentList",paymentList);
		mv.setViewName("/page/paymentWay/paymentList");
		return mv;
	}
	
	/**
	 * 添加支付方式<BR>
	 * 方法名：insertPayment<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年1月6日-下午1:17:10 <BR>
	 * @param PaymentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping("/insertPayment")
	@ResponseBody
	public Message insertPayment(PaymentVO payment){
		Message message=new Message();
		/** 系统自动生成时间**/
		Date createTime = new Date(System.currentTimeMillis());
		payment.setCreateTime(createTime);
		/** 获取保存在session中的信息**/
		EmployeeLoginVO employee=getUserInfo();
		/** 获取修改人的工号**/
		payment.setCreator(employee.getEmployeeCode());
		payment.setCodeOrder(paymentService.createCodeOrder());
		payment.setCodeKey(String.valueOf(paymentService.createCodeOrder()));
		/** 验证codeValue是否重复**/
		if(paymentService.checkCodeValue(payment.getCodeValue())){
			int number=paymentService.insertPayment(payment);
			if(number>0){
				message.setMsg("true");
			}else{
				message.setMsg("false");
			}
		}
		else{
			message.setMsg("equals");
		}
		return message;
	}
	
	/**
	 * 修改支付方式<BR>
	 * 方法名：updatePayment<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年1月6日-下午1:20:10 <BR>
	 * @param PaymentVO
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping("/updatePayment")
	@ResponseBody
	public Message updatePayment(PaymentVO payment){
		Message message=new Message();
		/** 系统自动生成时间**/
		Date modifyTime = new Date(System.currentTimeMillis());
		payment.setModifyTime(modifyTime);
		/** 验证codeValue是否重复**/
		if(paymentService.checkCodeValue(payment.getCodeValue())){
			int number=paymentService.updatePayment(payment);
			if(number>0){
				message.setMsg("true");
			}else {
				message.setMsg("false");
			}
		}else{
			message.setMsg("equals");
		}
		return message;
	}
	
	/**
	 * 删除支付方式<BR>
	 * 方法名：deletePayment<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年1月6日-下午1:20:10 <BR>
	 * @param List<Integer>
	 * @return int<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping("/deletePayment")
	@ResponseBody
	public Message deletePayment(String id){
		Message message=new Message();
		List<Integer> ids=new ArrayList<Integer>();
		String[] ids_1=id.split(",");
		for(int i=0;i<ids_1.length;i++){
			ids.add(Integer.valueOf(ids_1[i]));
		}
		int number=paymentService.deletePayment(ids);
		if(number>0){
			message.setMsg("true");
		}else{
			message.setMsg("false");
		}
		return message;
	}
	
	/**
	 * 查询支付方式<BR>
	 * 方法名：selectPaymentById<BR>
	 * 创建人：向新 <BR>
	 * 时间：2015年1月6日-下午1:20:10 <BR>
	 * @param id<Integer>
	 * @return message<BR>
	 * @exception <BR>
	 * @since  1.0.0
	*/
	@RequestMapping(value ="/showPayment/{id}")
	@ResponseBody
	public Map<Integer, Object> selectPaymentById(Integer id){
		String codeValue=paymentService.selectPaymentById(id);
		Map<Integer, Object> m = new HashMap<Integer, Object>();
		m.put(1,codeValue);
		m.put(2,id);
		return m;
	}
	
}
