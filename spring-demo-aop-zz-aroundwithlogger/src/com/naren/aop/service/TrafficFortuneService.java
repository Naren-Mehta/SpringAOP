package com.naren.aop.service;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		
		try {
			Thread.sleep(5000);
			throw new RuntimeException("Error on fortune");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Expect Heavy Traffice this Morning...";
	}
	

}
