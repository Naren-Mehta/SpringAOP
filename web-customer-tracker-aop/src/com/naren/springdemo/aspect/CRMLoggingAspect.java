package com.naren.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger myLogger= Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.naren.springdemo.aspect.controller.*.*(..))")
	public void forControllerPackage() {
		
	}
	
	
	@Pointcut("execution(* com.naren.springdemo.aspect.service.*.*(..))")
	public void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.naren.springdemo.aspect.dao.*.*(..))")
	public void forDaoPackage() {
		
	}
	
	@Pointcut("")
	public void forDaoPackage() {
		
	}
	
}
