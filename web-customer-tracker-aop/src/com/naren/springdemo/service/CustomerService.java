package com.naren.springdemo.service;

import java.util.List;

import com.naren.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerFromId(int customerId);

	public void deleteCustomer(int customerId);
	
}
