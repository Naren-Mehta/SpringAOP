package com.naren.aop.dao;

import org.springframework.stereotype.Component;

import com.naren.aop.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println("===Account name==="+account.getName());
		System.out.println(getClass() + ": Doing My DB Work: Adding An Account");
	}

	public void doWork() {
		System.out.println(getClass() + ": Doing My DB Work: Do Work");

	}

	public String getName() {
		
		System.out.println(getClass() + ": Doing My DB Work: in getName()");

		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": Doing My DB Work: in setName");

		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": Doing My DB Work: in getServiceCode()");

		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": Doing My DB Work: in setServiceCode()");

		this.serviceCode = serviceCode;
	}

}
