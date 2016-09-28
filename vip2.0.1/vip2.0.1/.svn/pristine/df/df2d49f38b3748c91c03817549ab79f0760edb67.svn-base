package com.moon.vip.service.sys.authManage;

import java.util.List;

import com.moon.client.vo.Message;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.student.StuAuthVO;
import com.moon.vip.infra.vo.sys.AuthSearchParams;

/**
 * 
 * 类名称：IAuthStuService.java<br/>
 * 日期：2016年6月16日 下午7:26:30<br/>
 * 类描述：学员网授权service<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年6月16日 chenhai  TODO<br/>
 * @author <a href="mailto:937870526@qq.com"></a><br/>
 * @version 1.0.0
 */
public interface IAuthStuService {
    /**
     * 
     * 日期：2016年6月17日 下午2:43:59<br/>
     * 描述：根据条件获取授权学生名单<br/>
     * 修改说明（时间、人）：<br/>
     * 下午2:43:59 chenhai <br/>
     * 修改备注：TODO<br/>
     * @param searchParams
     * @return<br/>
     * int
     */
	int getCountStuByParams(AuthSearchParams searchParams);
    
	
	/**
	 * 
	 * 日期：2016年6月17日 下午3:00:47<br/>
	 * 描述：获取授权学生信息<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午3:00:47 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param searchParams
	 * @return<br/>
	 * List<StuAuthVO>
	 */
	List<StuAuthVO> getAuthStuInfo(AuthSearchParams searchParams);
	
	
	/**
	 * 
	 * 日期：2016年6月17日 下午3:06:56<br/>
	 * 描述：取消授权学生<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午3:06:56 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @return<br/>
	 * int
	 */
	int cancelAuthStuByStuIds(String stuId,EmployeeLoginVO employee);
	
	
	/**
	 * 
	 * 日期：2016年6月17日 下午4:30:58<br/>
	 * 描述：授权学生官网账号<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午4:30:58 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param employee 
	 * @return<br/>
	 * Message
	 */
	Message authStudent(Integer stuId, String account, EmployeeLoginVO employee);
	
	

}
