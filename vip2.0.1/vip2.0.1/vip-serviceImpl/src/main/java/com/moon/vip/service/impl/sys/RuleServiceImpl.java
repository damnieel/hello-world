package com.moon.vip.service.impl.sys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;
import com.moon.vip.application.sys.DataRuleSqlMapper;
import com.moon.vip.application.sys.RuleSqlMapper;
import com.moon.vip.infra.constants.AuthCode;
import com.moon.vip.infra.constants.EnumAuthAction;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.EnumReference;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.sys.roleManage.EmpRoleRuleDataAct;
import com.moon.vip.service.rules.IResolverPlanService;
import com.moon.vip.service.rules.ISubscriberReplaceService;
import com.moon.vip.service.sys.IOrgProfessionalService;
import com.moon.vip.service.sys.IRuleService;

/**
 * 类名称：RuleServiceImpl.java<br/>
 * 日期：2016年1月8日 下午2:56:47<br/>
 * 类描述：实现规则相关服务<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年1月8日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
@Service("ruleService")
//@Scope("request")
public class RuleServiceImpl implements IRuleService {
	
	private static Logger logger = Logger.getLogger(RuleServiceImpl.class);
	
	@Autowired
	@Qualifier("resolverPlanService")
	private IResolverPlanService resolverPlanService;
	@Autowired
	@Qualifier("subscriberReplaceService")
	private ISubscriberReplaceService subscriberReplaceService;
	
	@Autowired
	private RuleSqlMapper ruleSqlMapper;
	@Autowired
	private DataRuleSqlMapper dataRuleSqlMapper;
	@Autowired
	private IOrgProfessionalService iOrgProfessionalService;
	
	@Cacheable(value = "AuthForOrgProfessional")
	public HashSet<Integer> getAuthForOrgProfessional(String employeeCode, EnumAuthAction action, List<String> roleCodeList) {
		logger.info(String.format("获取数据权限方法输入参数[员工: %s,操作类型: %s, 角色Code: %s", employeeCode, action.type, roleCodeList.toString()));
		HashSet<Integer> authList = Sets.newHashSet();
		/**
		 * 如果该员工权限中有超级管理员，就直接返回结果集 为 1 大枫20160114
		 */
		if(roleCodeList.contains(SysConstantsVal.SUPERSECURITY)) {
			authList.add(1);
			logger.info("超级管理员， 直接返回结果集为1");
			return authList;
		}
		
		List<String> ruleList = dataRuleSqlMapper.selectByRoleActionType(action.type, roleCodeList);
		for(String ruleJson : ruleList) {
			String resolverResult = resolverPlanService.resolverJson(ruleJson);
			logger.info(String.format("解析json结果: %s", resolverResult));
			subscriberReplaceService = subscriberReplaceService.createReplaceContent(resolverResult)
					.setString(EnumReference.CURRENT_EMPLOYEE, employeeCode);
			for(String roleCode : roleCodeList) {
				setOtherParams(roleCode);
			}
			String sql = subscriberReplaceService.excute();
			logger.info(String.format("替换之前结果: %s", sql));
			sql = sql.replaceAll("and \\(1 = 1 \\)", "");//druid连接池做了防注入处理，故去除多余的1=1条件
			checkParamsReplace(sql);
			logger.info(String.format("替换之后结果: %s", sql));
			List<Map<String, Object>> resultList = ruleSqlMapper.excutRule(sql);
			for(Map<String, Object> map : resultList) {
				for(String key : map.keySet()) {
					if(map.get(key) != null){
						authList.add((Integer)map.get(key));
					}
				}
			}
		}
		logger.info(String.format("获取数据权限数目: %s, 详情: %s", authList.size(), authList.toString()));
		return authList;
	}
	
	public HashSet<Integer> selectFromRuleJson(String ruleJson, String employeeCode, String roleCode) {
		HashSet<Integer> authList = new HashSet<Integer>();
		String resolverResult = resolverPlanService.resolverJson(ruleJson);
		logger.info(String.format("解析json结果: %s", resolverResult));
		subscriberReplaceService = subscriberReplaceService.createReplaceContent(resolverResult)
				.setString(EnumReference.CURRENT_EMPLOYEE, employeeCode);
		setOtherParams(roleCode);
		String sql = subscriberReplaceService.excute();
		logger.info(String.format("替换之前结果: %s", sql));
		sql = sql.replaceAll("and \\(1 = 1 \\)", "");//druid连接池做了防注入处理，故去除多余的1=1条件
		checkParamsReplace(sql);
		logger.info(String.format("替换之后结果: %s", sql));
		List<Map<String, Object>> resultList = ruleSqlMapper.excutRule(sql);
		for(Map<String, Object> map : resultList) {
			for(String key : map.keySet()) {
				if(map.get(key) != null){
					authList.add((Integer)map.get(key));
				}
			}
		}
		
		return authList;
	}

	 /**
	 * 日期：2016年1月14日 上午11:26:07<br/>
	 * 描述：校验SQL语句参数替换是否完整<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午11:26:07 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param sql<br/>
	 * void
	 */
	public void checkParamsReplace(String sql) {
		if(sql.contains(":")) {
			logger.error(String.format("规则SQL语句参数解析不完整: %s", sql));
			throw new BusinessException(EnumCodeException.E0116);
		}
	}

	 /**
	 * 日期：2016年1月8日 下午4:19:36<br/>
	 * 描述：其他需替换参数信息设置， 仅仅需要设置班主任、讲师信息，其它参数无需设置<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午4:19:36 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param roleCode<br/>
	 * void
	 */
	public void setOtherParams(String roleCode) {
		EnumReference reference = null;
		if(AuthCode.ADVISER.equals(roleCode)) {
			reference = EnumReference.CURRENT_ADVISER;
		} else if(AuthCode.TEACHER.equals(roleCode)) {
			reference = EnumReference.CURRENT_TEACHER;
		}
		if(reference != null) {
			subscriberReplaceService.setString(reference, roleCode);
		}
	}

	public List<Integer> selectByRoleActionType(String operType, String roleCode) {
		List<String> roleCodeList = new ArrayList<String>();
		roleCodeList.add(roleCode);		
		return dataRuleSqlMapper.selectByRoleActionTypeBackId(operType, roleCodeList);
	}
	
	@Cacheable(value = "SelectDataActByEmpId")
	public boolean selectDataActByEmpId
				(EmployeeLoginVO employee, String operType, Integer organizationId, String logicShip) {
		List<EmpRoleRuleDataAct> dataAuthList = dataRuleSqlMapper.selectDataActByEmpId(employee.getId());
		for(EmpRoleRuleDataAct e: dataAuthList) {
			HashSet<Integer> authSet = selectFromRuleJson(
					e.getRuleContent(), employee.getEmployeeCode(), e.getRoleCode());
			authSet = iOrgProfessionalService.convertSecurity(authSet);
			if(authSet.size() == 0) {
				authSet.add(0);
			}
			e.setOrgAuthSet(authSet);
		}
		
		List<EmpRoleRuleDataAct> resAuthList = new ArrayList<EmpRoleRuleDataAct>();
		boolean flag = false;
		for(EmpRoleRuleDataAct e: dataAuthList) {
			if(resAuthList.size() == 0) {
				resAuthList.add(e);
				resAuthList.get(resAuthList.size() - 1).getActList().add(e.getActType());
			} else {
				for(EmpRoleRuleDataAct res: resAuthList) {
					if(e.getRuleId().equals(res.getRuleId())) {
						res.getActList().add(e.getActType());
						flag = true;
					} 
				}
				if(!flag) {
					resAuthList.add(e);
					resAuthList.get(resAuthList.size() - 1).getActList().add(e.getActType());
				}
			}
		}

		String[] operArray = operType.split(",");	
		List<String> operList = new ArrayList<String>();
		for(String s: operArray) {
			operList.add(s);
		}
		if(logicShip != null && logicShip.equalsIgnoreCase(SysConstantsVal.ORRELATION)) {
			for(EmpRoleRuleDataAct e: resAuthList) {
				if(organizationId == null) {
					for(String s: operList) {
						if(e.getActList().contains(s)) {
							return true;
						}						
					}
				} else {
					if(e.getOrgAuthSet().contains(organizationId)) {
						for(String s: operList) {
							if(e.getActList().contains(s)) {
								return true;
							}						
						}
					}				
				}
			}
			
		} else {
			for(EmpRoleRuleDataAct e: resAuthList) {
				if(organizationId == null) {
					if(e.getActList().containsAll(operList)) {
						return true;
					}
				} else {
					if(e.getOrgAuthSet().contains(organizationId)) {
						if(e.getActList().containsAll(operList)) {
							return true;
						}
					}				
				}
			}
		}
		
		return false;
	}

}
