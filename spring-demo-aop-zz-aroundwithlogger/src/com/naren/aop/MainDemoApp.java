package com.naren.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naren.aop.dao.AccountDAO;
import com.naren.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call business method
		System.out.println("====================================================================");

		Account account = new Account();
		account.setName("Naren");
		theAccountDAO.addAccount(account, true);
		System.out.println("====================================================================");
		
		// close the context
		context.close();

	}

}
