package com.luv2code.springdemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

//intermediate layer for custom business logic
//service layer b/w customer controller class and customerDAO
@Service
//@Transactional will automatically begin & end transaction for hibernate code/query
@Transactional
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override

	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}

	@Override
	public void saveCustomer(Customer theCustomer){

		//call the data source through this service!
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);

	}
}





