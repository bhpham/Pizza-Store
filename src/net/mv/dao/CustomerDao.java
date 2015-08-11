package net.mv.dao;

import java.util.List;

import net.mv.pojos.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomerDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Customer retrieveCustomer(String username) {
		Customer customer = new Customer();
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customers = session.createCriteria(Customer.class).list();
		
		/*
		 * Traverse through the list of customers from Dbms and get the valid customer
		 * based on the username
		 */
		for (Customer custFromDB : customers) {
			if (custFromDB.getUsername().equals(username)){
				customer = custFromDB;
			}
		}

		return customer;
	}
	
	@Transactional
	public void createCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);
	}
	
	
}
