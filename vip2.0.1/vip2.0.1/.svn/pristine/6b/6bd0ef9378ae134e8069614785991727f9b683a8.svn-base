package com.moon.vip.infra.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 类名称：MethodMonitorAop.java<br/>
 * 日期：2015年10月21日 下午7:16:59<br/>
 * 类描述：方法监控AOP<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2015年10月21日 luofangyi TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">luofangyi</a><br/>
 * @version 1.0.0
 */
@Component
@Aspect
public class MethodMonitorAop {

	private static Logger logger = Logger.getLogger(MethodMonitorAop.class);
	
	@Pointcut("execution (* com.moon.vip.service.impl..*.*(..))")
	private void pointCut() {

	}
	@Before(value="pointCut()")  
	public void before() {

	}
	@After (value="pointCut()")
	public void after() {

	}
	
	 /**
	 * 日期：2015年10月21日 下午7:58:38<br/>
	 * 描述：环绕方法<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午7:58:38 luofangyi <br/>
	 * 修改备注：TODO<br/>
	 * @param point
	 * @return<br/>
	 * Object
	 * @throws Throwable 
	 */
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		StopWatch clock = new StopWatch();
		clock.start();
		Object result = null;
		String method = point.getTarget().getClass() + "." + point.getSignature().getName();
		
		try {
			result = point.proceed();
		} catch (Throwable e) {
			logger.error(String.format("方法[%s]执行发生异常, 异常信息: %s", method, e.getLocalizedMessage()));
			throw e;
		}
		clock.stop();
		logger.info(String.format("方法[%s]执行时间[%s]ms", method, clock.getTotalTimeMillis()));
		return result;
	}
	
	@AfterThrowing(pointcut="pointCut()", throwing="ex")
	public void doThrowing(JoinPoint jp,Throwable ex){
       logger.error(String.format("异常引发源: %s, 详情: %s", jp.getSourceLocation(), ex.getLocalizedMessage()));    
    }
}
