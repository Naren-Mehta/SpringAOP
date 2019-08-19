package com.naren.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.context.Theme;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger myLogger= Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.naren.springdemo.controller.*.*(..))")
	public void forControllerPackage() {
		
	}
	
	
	@Pointcut("execution(* com.naren.springdemo.service.*.*(..))")
	public void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.naren.springdemo.dao.*.*(..))")
	public void forDaoPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {
		
	}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String methodString= theJoinPoint.getSignature().toShortString();
		myLogger.info("===>> in @Before: calling method: " +methodString);
	}
	
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object result) {
		String methodString= theJoinPoint.getSignature().toShortString();
		myLogger.info("===>> in @AfterReturning: calling method: " +methodString);
		myLogger.info("===>> result: " +result);

	}
	
}
