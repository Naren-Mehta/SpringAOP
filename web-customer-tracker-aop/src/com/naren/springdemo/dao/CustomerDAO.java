package com.naren.springdemo.dao;

import java.util.List;

import com.naren.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerFromId(int customerId);

	public void deleteCustomer(int customerId);


}
