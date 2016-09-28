package com.moon.vip.service.sys;

import java.util.HashSet;
import java.util.List;

import com.moon.vip.infra.constants.EnumAuthAction;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.sys.roleManage.EmpRoleRuleDataAct;

/**
 * 类名称：IRuleService.java<br/>
 * 日期：2016年1月8日 下午2:44:01<br/>
 * 类描述：规则相关服务接口<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年1月8日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public interface IRuleService {

	 /**
	 * 日期：2016年1月8日 下午2:53:29<br/>
	 * 描述：获取指定员工数据权限<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:53:29 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param employeeCode 工号
	 * @param action 操作类型
	 * @param roleCodeList 角色编码
	 * @return<br/>
	 * List<Integer>
	 */
	public HashSet<Integer> getAuthForOrgProfessional(String employeeCode, EnumAuthAction action, List<String> roleCodeList);
	/**
	 * 根据数据操作类型及角色Code查询规则ID<br/> 
	 * @Title: selectByRoleActionTypeBackId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月14日 下午6:47:30  <br/> 
	 * @param type
	 * @param roleCodeList
	 * @return
	 * List<Integer>
	 * @throws  <br/>
	 */
	public List<Integer> selectByRoleActionType(String operType, String roleCode);
	
	/**
	 * 从一个json串获取到对应的orgId<br/> 
	 * @Title: selectFromRuleJson <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月28日 下午2:35:24  <br/> 
	 * @param ruleJson
	 * @param employeeCode
	 * @param roleCode
	 * @return
	 * HashSet<Integer>
	 * @throws  <br/>
	 */
	public HashSet<Integer> selectFromRuleJson(String ruleJson, String employeeCode, String roleCode);
	/**
	 * 根据员工id获取到员工的数据权限<br/> 
	 * @Title: selectDataActByEmpId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月28日 下午3:00:49  <br/> 
	 * @param employee
	 * @param organizationId 
	 * @param logicShip 
	 * @return
	 * List<EmpRoleRuleDataAct>
	 * @throws  <br/>
	 */
	public boolean selectDataActByEmpId(EmployeeLoginVO employee, String employeeCode, Integer organizationId, String logicShip);
}
