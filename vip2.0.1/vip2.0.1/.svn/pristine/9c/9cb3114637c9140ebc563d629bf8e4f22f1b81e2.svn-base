package com.moon.vip.service.impl.sys.authManage;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.client.vo.Message;
import com.moon.vip.application.student.StudentArchivesSqlMapper;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.student.StuAuthVO;
import com.moon.vip.infra.vo.sys.AuthSearchParams;
import com.moon.vip.service.sys.IOrgProfessionalService;
import com.moon.vip.service.sys.authManage.IAuthStuService;

/**
 * 
 * 类名称：AuthStuServiceImpl.java<br/>
 * 日期：2016年6月16日 下午7:28:12<br/>
 * 类描述：学院网授权管理实现<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年6月16日 chenhai  TODO<br/>
 * @author <a href="mailto:937870526@qq.com"></a><br/>
 * @version 1.0.0
 */
@Service("authStuService")
public class AuthStuServiceImpl implements IAuthStuService {
	@Autowired
	private StudentArchivesSqlMapper studentArchivesSqlMapper;
	@Autowired 
	private IOrgProfessionalService orgProfessionalService;
	@Autowired
	private BaseDateClient baseDateClient;
	private static Logger logger = Logger.getLogger(AuthStuServiceImpl.class);
	public int getCountStuByParams(AuthSearchParams searchParams) {
		checkAndAdd(searchParams);
		return studentArchivesSqlMapper.getCountStuByParams(searchParams);
		
	}

	public List<StuAuthVO> getAuthStuInfo(AuthSearchParams searchParams) {
	     checkAndAdd(searchParams);
	     return studentArchivesSqlMapper.getAuthStuInfo(searchParams);
	}
   
	public int cancelAuthStuByStuIds(String stuIds, EmployeeLoginVO employee) {
		if(stuIds == null){
			throw new BusinessException(EnumCodeException.E0003);
		}
		String[] ids = stuIds.split(",");
		List<String> stuIdArray = Arrays.asList(ids);
		int i =  studentArchivesSqlMapper.cancelAuthByStuIds(stuIdArray,employee.getEmployeeCode());
		logger.info(String.format("员工%s[%s]取消了学生组[%s]的授权,共影响记录[%s]条",
				       employee.getNickName(),employee.getEmployeeCode(),stuIds,i));
		return i;
	}
	
	private  void checkAndAdd(AuthSearchParams searchParams){
		if(searchParams.getOrgProCalId() == 0){
			throw new BusinessException(EnumCodeException.E0003);
		}
		if(searchParams.getAuthStatus().equals("A")){
			searchParams.setAuthStatus(null);
		}
		searchParams.setSearchOpClaIds(orgProfessionalService.covertOrgSearch(searchParams.getOrgProCalId()));
	}

	public Message authStudent(Integer stuId, String account, EmployeeLoginVO employee) {
		Message msg = new Message();
		if(stuId == null || account == null){
			throw new BusinessException(EnumCodeException.E0003);
		}
		if(!checkAccoutValid(account,msg)){ //检测官网账号是否有效
			return msg;
		}
		studentArchivesSqlMapper.authStudent(stuId,account,employee.getEmployeeCode());
		logger.info(String.format("员工%s[%s]给学生[%s]授权给了账号[%s]",
				       employee.getNickName(),employee.getEmployeeCode(),stuId,account));
		msg.setSuccess(true);
		return msg;
	}
   
	private boolean checkAccoutValid(String account,Message msg) {
		// 1: 是否已绑定
		List<StuAuthVO> stu = studentArchivesSqlMapper.getStuByAccount(account);
		if(stu != null && stu.size() > 1){
			msg.setSuccess(false);
			msg.setCode("2");
			msg.setRespBody("存在错误数据,同一官网账号绑定多名学员，请联系管理员");
			logger.error(String.format("数据库存在异常数据,同一账号[%s]绑定多个学员",account));
			return false;
		}
		if(stu != null && stu.size() == 1){
			String name = stu.get(0).getName();
			msg.setSuccess(false);
			msg.setCode("2");
			msg.setRespBody(String.format("您输入的帐号[%s]已与[%s]绑定授权，请重新授权！",account,name));
			return false;
		}
		// 2: 是否存在
		if(!baseDateClient.accountIsExist(account)){
			msg.setSuccess(false);
			msg.setCode("2");
			msg.setRespBody(String.format("您输入的帐号[%s]不存在",account));
			return false;
		}
		return true;
	}
	

}
