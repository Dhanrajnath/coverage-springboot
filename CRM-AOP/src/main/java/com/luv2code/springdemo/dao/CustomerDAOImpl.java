package com.luv2code.springdemo.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
//CRUD operations
//java bean will scan @Respository annotation for Data Access Object implementation
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	Logger logger
			= Logger.getLogger(
			CustomerDAOImpl.class.getName());

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query ... sort by the lastname
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer){
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

//		currentSession.createQuery("from Customer c where c.firstName="+ theCustomer.getFirstName()).executeUpdate();

		Query<Customer> query =
				currentSession.createQuery("select c from Customer c "+
								"where c.firstName =:theCustomerFirstName and " +
								"c.lastName =:theCustomerLastName and " +
								"c.email=:theCustomerEmail",
						         Customer.class);

		// set parameter on query
		query.setParameter("theCustomerFirstName", theCustomer.getFirstName());
		query.setParameter("theCustomerLastName", theCustomer.getLastName());
		query.setParameter("theCustomerEmail", theCustomer.getEmail());

		try {
			// execute query and get instructor
			Customer temp = query.getSingleResult();
		}
		catch (Exception exe){
			logger.log(Level.INFO,"Already exists!!");
			currentSession.saveOrUpdate(theCustomer);
		}
	}

	@Override
	public Customer getCustomer(int theId) {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		//now retrieve/read from database using the primary key or id..
		Customer theCustomer = currentSession.get(Customer.class,theId);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();

		//now delete the customer using parameter theId i.e., Customer id (primary key)
		//HQL query
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

		//prev parameter theId is assigned to customerId
		theQuery.setParameter("customerId",theId);

		//this works with update, delete , so on ...
		theQuery.executeUpdate();

	}

}






