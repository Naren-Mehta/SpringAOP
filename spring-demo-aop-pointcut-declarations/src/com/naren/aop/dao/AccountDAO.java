package com.naren.aop.dao;

import org.springframework.stereotype.Component;

import com.naren.aop.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": Doing My DB Work: Adding An Account");
	}
	
	
	
	public void removeAccount() {
		System.out.println(getClass() + ": Doing My DB Work: Removing An Account");
	}
	
	public void doWork() {
		System.out.println(getClass() + ": Doing My DB Work: Do Work");

	}
	

}
