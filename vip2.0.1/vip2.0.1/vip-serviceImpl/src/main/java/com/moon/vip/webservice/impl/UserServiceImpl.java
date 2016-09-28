package com.moon.vip.webservice.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.util.StringUtils;
import com.moon.client.vo.Message;
import com.moon.client.vo.UserInfoVO;
import com.moon.vip.application.sys.EmployeeBaseSqlMapper;
import com.moon.vip.application.sys.userManage.UserManagerSqlMapper;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.webservice.IUserService;
/**
 * 
* @ClassName: UserServiceImpl 
* @Description: TODO(vip webservice服务) 
* @author  陈海  - （怡宝 ）
* @date 2016年3月22日 下午7:26:57 
*
 */
public class UserServiceImpl implements IUserService {
    
	private static final long serialVersionUID = -3629352887100788845L;
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private EmployeeBaseSqlMapper employeeBaseSqlMapper;
	@Autowired
	private UserManagerSqlMapper userManagerSqlMapper;
	public UserInfoVO getUserInfoByAccount(String account) {
		UserInfoVO employee = employeeBaseSqlMapper.findEmployeeByAccount(account);
		if(employee == null){
			logger.error(String.format("该账号[%s]下找不到对应正常的用户", account));
		}
		return employee;
	}
	
	
	public Message addUser(UserInfoVO user) {
		if(user == null){
			return new Message().buildRespBody("PARAMS_NOT_NULL");
		}
		Message msg = checkParams(user);
		if(msg !=null){
			return msg; 
		}
		try{
			int i = employeeBaseSqlMapper.checkUniqueByCode(user.getUserAccount());
			if( i > 1){
				/**账户存在多于一条的情况**/
				logger.error(String.format("vip系统存在错误账户[%s]信息", user.getUserAccount()));
				return new Message().buildIsSuccess(false).buildRespBody("DATA_ERROR")
						.buildDesc("vip系统存在两条重复账户信息,联系管理员");
			}
			else if(i == 1){  
				/**账号存在唯一一条情况**/
				logger.info(String.format("用户账号[%s]已存在", user.getUserAccount()));
				int k = userManagerSqlMapper.countEmploye(user.getUserAccount(), user.getNickName()); //除去本账号，员工昵称是否重复
			    if(k == 0){
			    	  user.setStatus(SysConstantsVal.ACCOUNT_USING);
			    	  employeeBaseSqlMapper.updateEmpByCode(user);
			    	  logger.info(String.format("sso修改了一条用户记录[%s]",user.toString()));
			    }
			    else{
			    	/**与其他用户重复昵称，不能新增**/
			    	return new Message().buildIsSuccess(false).buildRespBody("NICK_NAME_REPEAT")
			    			.buildDesc("与其他用户昵称重复,在vip系统下新增用户失败");
			    }
			}
			else{
				/**账号不存在**/
				int j = employeeBaseSqlMapper.checkUniqueByNickName(user.getNickName()); //查询昵称是否存在
				if(j > 0){
			    	return new Message().buildIsSuccess(false).buildRespBody("NICK_NAME_REPEAT")
			    			.buildDesc("此昵称重复,在vip系统下新增用户失败");
				}
				user.setStatus(SysConstantsVal.ACCOUNT_USING);
		        employeeBaseSqlMapper.addUser(user);
		        logger.info(String.format("sso增加了一条用户记录[%s]",user.toString()));
		     }
			return new Message().buildIsSuccess(true).buildRespBody("ADD_USER_SUCCESS");
	    }catch(Exception e){
	    	return new Message().buildRespBody("NO_KNOW_EXCEPTION")
	    			            .buildDesc(e.toString());
	    }
	}
	
	
	private Message checkParams(UserInfoVO user){
		if(StringUtils.isEmpty(user.getUserAccount())){
			return new Message().buildRespBody("ACCOUNT_NOT_NULL");
		}
		if(StringUtils.isEmpty(user.getNickName())){
			return new Message().buildRespBody("NICKNAME_NOT_NULL");
		}
		if(StringUtils.isEmpty(user.getCreator()) ){
			return new Message().buildRespBody("CREATOR_NOT_NULL");
		}
		return null;
	}


}
