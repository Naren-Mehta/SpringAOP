package com.naren.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	//let's start with an @Before advice
	@Pointcut("execution(* com.naren.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>>>> Executing @Before advice on add*() ");
	}
	
	@Before("forDaoPackage()")
	public void beforePerformAnalytics() {
		System.out.println("\n=====>>>>> Perform API Analytics");
	}
	
}
