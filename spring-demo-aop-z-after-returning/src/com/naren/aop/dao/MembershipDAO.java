package com.naren.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean  addSillyMember() {
		System.out.println(getClass()+": Doing Stuff Adding a Membership Account");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass()+": Doing Stuff goToSleep a Membership Account");

	}

}
