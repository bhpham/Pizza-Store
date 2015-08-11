package net.mv.service;

import net.mv.dao.CustomerDao;
import net.mv.pojos.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

	@Autowired
	CustomerDao customerDao;

	public Customer authentication(String username, String password) {
		
		 Customer customer = customerDao.retrieveCustomer(username);
		 System.out.println("retrieveCustomer: "+ customer.getUsername());
		 if (customer != null && customer.getPassword().equals(password))
		  	{
			
			 	return customer;
		  	}
		 else
		  	return null;
	
		 
	}
	
	public boolean registerdCustomer(Customer customer) {
		boolean exists = false;
		
		try {
			customerDao.createCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
			exists = true;
		}
		
		return exists;
	}
	
}
