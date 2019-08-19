package com.naren.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naren.aop.dao.AccountDAO;
import com.naren.aop.dao.MembershipDAO;
import com.naren.aop.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
//		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		
		TrafficFortuneService theFortuneService= context.getBean("trafficFortuneService",TrafficFortuneService.class);
		// call business method
		
		
		String fortune = theFortuneService.getFortune();
		
		System.out.println("fortune===>"+fortune);

		System.out.println("============finished==========");
		// close the context
		context.close();

	}

}
