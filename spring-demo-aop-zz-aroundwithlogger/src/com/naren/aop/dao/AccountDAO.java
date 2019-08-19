package com.naren.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.naren.aop.Account;

@Component
public class AccountDAO {


	public List<Account> findAccount(boolean tripWire){
		List<Account>	accountList= new ArrayList<Account>();
		
		// Add dummy data
		
		
		if(tripWire) {
			throw new RuntimeException("No Soup for you.");
		}
		Account account1= new Account("Naren","Silver");
		Account account2= new Account("Deepak","Platium");
		Account account3= new Account("Prema","Gold");

		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);

		return accountList;
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": Doing My DB Work: Adding An Account");
	}


}
