package com.naren.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AppExpression {

	@Pointcut("execution(* com.naren.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}
	
	@Pointcut("execution(* com.naren.aop.dao.*.set*(..))")
	public void setter() {
	}
	
	@Pointcut("execution(* com.naren.aop.dao.*.get*(..))")
	public void getter() {
	}
	
	@Pointcut("forDaoPackage() && !(getter() || setter()) ")
	public void forDaoPackageNoSetterGetter() {
	}
	
}
