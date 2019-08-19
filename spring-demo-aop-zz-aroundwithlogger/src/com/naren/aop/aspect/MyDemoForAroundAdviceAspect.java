package com.naren.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoForAroundAdviceAspect {
	
	public static Logger myLogger= Logger.getLogger(MyDemoForAroundAdviceAspect.class.getName());
	
	@Around("execution( * com.naren.aop.service.TrafficFortuneService.getFortune(..))")
	public Object getFortuneObject(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		myLogger.info("\n============Inside @Around=======================\n");

		String methodSignature= theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====methodSignature==="+methodSignature+"\n");
		long begin = System.currentTimeMillis();

		Object result=null;
		try {
			result=theProceedingJoinPoint.proceed();
		}catch (Exception e) {
			myLogger.warning("==@Advice exception====");
			throw e;
		}
		
		long end = System.currentTimeMillis();
		long duration = end - begin;
		myLogger.info("===duration====" + duration);

		myLogger.info("\n============End @Around=======================\n");

		return result;

	}

}
