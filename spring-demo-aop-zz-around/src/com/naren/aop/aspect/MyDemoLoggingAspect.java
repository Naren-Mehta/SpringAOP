package com.naren.aop.aspect;

import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
public class MyDemoLoggingAspect {

	@After("execution(* com.naren.aop.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("============inside=@After (Finally)====================");
	}

	@AfterThrowing(pointcut = "execution(* com.naren.aop.dao.AccountDAO.findAccount(..))", throwing = "err")
	public void afterThrowingFindAccount(JoinPoint theJoinPoint, Throwable err) {

		System.out.println("=================Inside @@AfterThrowing========================================");

		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("===" + methodSignature);
		System.err.println("Exception is=======> " + err);
		System.out.println("=================End @@AfterThrowing========================================");

	}

	@AfterReturning(pointcut = "execution(* com.naren.aop.dao.AccountDAO.findAccount(..))", returning = "result")
	public void afterReturningFindAccount(JoinPoint theJoinPoint, List<Account> result) {

		System.out.println("=================Inside @AfterReturning========================================");
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("===" + methodSignature);

		System.out.println("\nResult is " + result);

		System.out.println("=Modifying result===");

		Iterator i = result.iterator();

		while (i.hasNext()) {
			Account acc = (Account) i.next();
			if (acc.getName().equals("Naren")) {
				acc.setName("Naren_trace");
			}
		}
		convertNameToUpperCase(result);
	}

	private void convertNameToUpperCase(List<Account> result) {
		for (Account ac : result) {
			String upperName = ac.getName().toUpperCase();
			ac.setName(upperName);
		}
	}

	@Before("com.naren.aop.aspect.AppExpression.forDaoPackageNoSetterGetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n===2==>>>>> Executing @Before advice on add*() ");

		// display the method signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("=theMethodSignature==" + theMethodSignature);
		System.out.println();

		Object[] objArr = theJoinPoint.getArgs();

		for (Object obj : objArr) {
			System.out.println(obj);

			if (obj instanceof Account) {
				Account account = (Account) obj;
				System.out.println("Account name: " + account.getName());
				account.setName(account.getName() + "_tracing ");
			}

		}
		// display method argument
	}

}
