package com.moon.vip.application.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.sys.roleManage.EmpRoleRuleDataAct;
import com.moon.vip.model.sys.DataRule;

/**
 * 类名称：DataRuleSqlMapper.java<br/>
 * 日期：2016年1月8日 下午2:32:53<br/>
 * 类描述：数据权限自定义Mapper<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年1月8日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public interface DataRuleSqlMapper {

	 /**
	 * 日期：2016年1月8日 下午2:34:36<br/>
	 * 描述：根据数据操作类型及角色Code查询规则内容<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:34:36 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param type
	 * @param roleCodeList
	 * @return<br/>
	 * List<String>
	 */
	public List<String> selectByRoleActionType(@Param("type")String type, @Param("roleCodeList")List<String> roleCodeList);
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
	public List<Integer> selectByRoleActionTypeBackId(@Param("type")String type, @Param("roleCodeList")List<String> roleCodeList);
	/**
	 * 获取全部的规则<br/> 
	 * @Title: selectAllRule <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月18日 下午7:38:12  <br/> 
	 * @return
	 * List<DataRule>
	 * @throws  <br/>
	 */
	public List<DataRule> selectAllRule();
	/**
	 * 根据EmpId获取他的数据权限<br/> 
	 * @Title: selectDataActByEmpId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月28日 下午2:49:49  <br/> 
	 * @param employeeId
	 * @return
	 * EmpRoleRuleDataAct
	 * @throws  <br/>
	 */
	public List<EmpRoleRuleDataAct> selectDataActByEmpId(Integer employeeId);
}
