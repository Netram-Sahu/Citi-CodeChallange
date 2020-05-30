package com.citi.netram.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.netram.entity.Customer;
import com.citi.netram.exception.AccountNotFoundException;
import com.citi.netram.exception.CustomerNotFoundException;
import com.citi.netram.service.CustomerService;

/**
 * This is a controller class for Customer details
 * @RestController annotation is used to create RESTful web services
 * @RequestMapping annotation configure the mapping of web requests
 * @Autowired annotation is used for automatic dependency injection
 * 
 * */ 

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	/**
	 * This method is used to get all customer details
	 * */
	@GetMapping("/getAllCustomerDetails")
	public List<Customer> getCustomersDetails() {
		System.out.println("......Netram Sahu in getAllCustomerDetails().....");
		return customerService.getCustomerDetails();
	}
	
	/**
	 * This method is used to get all customer details
	 **/
	@GetMapping("/allCustomers")
	public List<Integer> getAllCustomers() {
		System.out.println("......Netram Sahu in getAllCustomers().....");
		return customerService.getAllCustomers();
	}
	
	/**
	 * This method is used to get customer details by custId
	 * */
	@GetMapping("/customerBy/{custId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "custId") int custId) {
		System.out.println("......Netram Sahu in getCustomerById().....");
		Customer customer = null;
		try {
			customer = customerService.getCustomerById(custId);
		} catch (CustomerNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer);
	}
	
	/**This method is used to add new customer details
	 * */
	@PostMapping("/addCustomer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) throws Exception{
		System.out.println("......Netram Sahu in addCustomer().....");
		customer.setFirstName(customer.getFirstName());
		customer.setLastName(customer.getLastName());
		customer.setAddress(customer.getAddress());
		customer.setPhoneNumber(customer.getPhoneNumber());
		customer.setSsn(customer.getSsn());
		try{
			customerService.addCustomer(customer);
		}catch(Exception e) {
			throw new AccountNotFoundException("Failed to add");
		}
		return customer;
	}
	
	/**
	 * This method is used to edit customer details by custId
	 * */
	@PutMapping("/editCustomer/{custId}")
	public ResponseEntity<Customer> editCustomer(@Valid @RequestBody Customer customer, @PathVariable int custId) throws Exception {
		System.out.println("......Netram Sahu in editCustomer().....");
		Customer editCustomer =new Customer();
		try{
			editCustomer.setCustId(custId);
			editCustomer.setFirstName(customer.getFirstName());
			editCustomer.setLastName(customer.getLastName());
			editCustomer.setAddress(customer.getAddress());
			editCustomer.setPhoneNumber(customer.getPhoneNumber());
			editCustomer.setSsn(customer.getSsn());
		}catch(Exception e){
			throw new AccountNotFoundException("Failed to edit");
		}
		return ResponseEntity.ok(editCustomer);
	}

	/**
	 * This method is used to delete customer details
	 * */
	@DeleteMapping("/deleteCustomer/{custId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int custId) throws Exception  {
		System.out.println("......Netram Sahu in deleteCustomer()......");
		Customer delCustomer =new Customer();
		try {
			delCustomer.setCustId(custId);
			customerService.deleteCustomer(delCustomer);
		}catch(Exception e){
			throw new AccountNotFoundException("Failed to delete");
		}
		return ResponseEntity.ok(delCustomer);
	}
}
