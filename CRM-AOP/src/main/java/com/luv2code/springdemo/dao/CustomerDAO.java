package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

//DAO --> Data Access Object
public interface CustomerDAO {

	List<Customer> getCustomers();
    //to return all customer objects

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
