package com.naren.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.naren.aop.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect{
	
	
	
	@Before("com.naren.aop.aspect.AppExpression.forDaoPackageNoSetterGetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n===2==>>>>> Executing @Before advice on add*() ");
		
		//display the method signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("=theMethodSignature=="+theMethodSignature);
		System.out.println();
		
		Object[] objArr= theJoinPoint.getArgs();
		
		for(Object obj: objArr) {
			System.out.println(obj);
			
			if(obj instanceof Account) {
				Account account= (Account)obj;
				System.out.println("Account name: "+account.getName());
				account.setName(account.getName()+"_tracing ");
			}
			
		}
		//display method argument
	}
	
	
	
	
	
}
