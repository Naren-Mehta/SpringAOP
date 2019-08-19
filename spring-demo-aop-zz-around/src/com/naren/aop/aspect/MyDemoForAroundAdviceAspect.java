package com.naren.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoForAroundAdviceAspect {

	@Around("execution( * com.naren.aop.service.TrafficFortuneService.getFortune(..))")
	public Object getFortuneObject(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		System.out.println("============Inside @Around=======================");

		String methodSignature= theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("====methodSignature==="+methodSignature);
		long begin = System.currentTimeMillis();

		
		Object result=theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		long duration = end - begin;
		System.out.println("===duration====" + duration);

		return result;

	}

}
