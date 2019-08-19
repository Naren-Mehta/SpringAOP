package com.naren.aop;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naren.aop.dao.AccountDAO;
import com.naren.aop.dao.MembershipDAO;
import com.naren.aop.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger=
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	
		TrafficFortuneService theFortuneService= context.getBean("trafficFortuneService",TrafficFortuneService.class);
		// call business method
		String fortune = null;
		try {
			 fortune = theFortuneService.getFortune();

		}catch (Exception e) {
			System.out.println("========Exception============="+e);
		}
		
		myLogger.info("fortune===>"+fortune);

		myLogger.info("============finished==========");
		// close the context
		context.close();

	}

}
