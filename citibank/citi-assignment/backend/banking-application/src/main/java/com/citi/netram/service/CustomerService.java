package com.citi.netram.service;

import java.util.List;
import com.citi.netram.entity.Customer;
import com.citi.netram.exception.CustomerNotFoundException;

public interface CustomerService {
	
	public List<Customer> getCustomerDetails() ;
	public List<Integer> getAllCustomers();		
	public Customer getCustomerById(int id) throws CustomerNotFoundException;
	public Customer addCustomer(Customer customer) ;
	public Customer editCustomer(Customer customer) ;
	public void deleteCustomer(Customer customer) ;

}
