package com.naren.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	
	@Before("com.naren.aop.aspect.AppExpression.forDaoPackageNoSetterGetter()")
	public void logToCloudAsync() {
		System.out.println("\n===1==>>>>> Logging to cloud Async fashion");
	}

}
