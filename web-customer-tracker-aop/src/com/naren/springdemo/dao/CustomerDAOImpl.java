package com.naren.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.naren.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer order by lastName");
		List<Customer> customerList = query.list();

		return customerList;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session session = sessionFactory.getCurrentSession();

//		session.save(theCustomer);
		session.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomerFromId(int customerId) {

		Session session = sessionFactory.getCurrentSession();
		Customer customer = null;
		try {
			customer = session.get(Customer.class, customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Query query = session.createQuery("delete from Customer where id=:id");
			query.setParameter("id", customerId);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
