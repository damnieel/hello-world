package com.moon.vip.tag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.service.sys.IRuleService;
/**
 * 
 * @ClassName: SecurityTag 
 * @Description: 系统权限自定义标签
 * @author 大枫
 * @date 2016年1月13日 下午5:00:54 
 *
 */
public class SecurityTag extends BodyTagSupport{

	private static final long serialVersionUID = -5878713607954923160L;
	
	private static Logger logger = Logger.getLogger(SecurityTag.class);
	/**
	 * 逻辑关系
	 */
	private String logicShip;
	/**
	 * 操作类型
	 */
	private String operType;	
	/**
	 * 数据是属于哪个班级或者专业的
	 */
	private Integer organizationId;

	@Override
	public int doAfterBody() throws JspException {
		
		try {
			// 如果认证通过就显示标签正文，否则跳过标签正文
			if (isAuthentificated(operType)) {
				if (bodyContent != null) {
					JspWriter out = bodyContent.getEnclosingWriter();
					bodyContent.writeOut(out);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new JspException();
		}
		return SKIP_BODY;
	}
	
	private boolean isAuthentificated(String operType) {
		EmployeeLoginVO employee = (EmployeeLoginVO) this.pageContext.getSession()
											.getAttribute("employee");
		
		IRuleService iRuleService = (IRuleService) WebApplicationContextUtils.getRequiredWebApplicationContext(
				this.pageContext.getServletContext()).getBean("ruleService");
		
		boolean res = iRuleService.selectDataActByEmpId(employee, operType, organizationId, logicShip);
		return res;
	}
	
	public void setOperType(String operType) {
		this.operType = operType;
	}

	public String getOperType() {
		return operType;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getLogicShip() {
		return logicShip;
	}

	public void setLogicShip(String logicShip) {
		this.logicShip = logicShip;
	}
}
