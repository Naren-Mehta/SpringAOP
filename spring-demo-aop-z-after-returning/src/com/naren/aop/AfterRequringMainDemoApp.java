package com.naren.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naren.aop.dao.AccountDAO;
import com.naren.aop.dao.MembershipDAO;

public class AfterRequringMainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call business method
		List<Account> listAccounts = theAccountDAO.findAccount();
		System.out.println("====================================================================");
		
		System.out.println(listAccounts);
		
		System.out.println("====================================================================");

		// close the context
		context.close();

	}

}
