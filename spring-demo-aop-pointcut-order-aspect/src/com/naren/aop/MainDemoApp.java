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

		Account account = new Account();
		theAccountDAO.addAccount(account, true);
		theAccountDAO.doWork();
		System.out.println("====================================================================");
		
		theAccountDAO.setName("Naren");
		theAccountDAO.setServiceCode("Silver");

		String name=theAccountDAO.getName();
		String service= theAccountDAO.getServiceCode();
		System.out.println("====================================================================");

		System.out.println();
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

		// close the context
		context.close();

	}

}
