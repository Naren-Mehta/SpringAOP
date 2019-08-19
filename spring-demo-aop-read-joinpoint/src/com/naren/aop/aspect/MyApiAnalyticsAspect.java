package com.naren.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	
	@Before("com.naren.aop.aspect.AppExpression.forDaoPackageNoSetterGetter()")
	public void beforePerformAnalytics() {
		System.out.println("\n===3==>>>>> Perform API Analytics");
	}

}
