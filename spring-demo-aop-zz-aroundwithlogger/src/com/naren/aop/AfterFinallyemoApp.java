package com.naren.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naren.aop.dao.AccountDAO;
import com.naren.aop.dao.MembershipDAO;

public class AfterFinallyemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call business method
		List<Account> listAccounts = null;
		try {
			boolean tripWire = true;
			// boolean tripWire=true;

			listAccounts = theAccountDAO.findAccount(tripWire);

		} catch (Exception e) {
			System.err.println("Main program caught exception." + e.getMessage() + "\n");
		}
		System.out.println("====================================================================");

		System.out.println("result accounts=> " + listAccounts);

		System.out.println("====================================================================");

		// close the context
		context.close();

	}

}
