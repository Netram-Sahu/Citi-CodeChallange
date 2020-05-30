package com.citi.netram.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.netram.dto.CustomerDTO;
import com.citi.netram.entity.Customer;
import com.citi.netram.exception.CustomerNotFoundException;
import com.citi.netram.repository.CustomerDaoRepository;

/**
 * This class is customer service implementation class that perform service tasks
 * @Service annotation is used in service layer
 * @Autowired annotation is used for automatic dependency injection
 * */

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDaoRepository customerDaoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Customer> getCustomerDetails() {
		List<Customer> customer= new ArrayList<Customer>();
		customer=customerDaoRepository.findAll();
		customer.stream()
        		.map(this::mapToDto)
        		.collect(Collectors.toList());
		return customer;
	}

	@Override
	public List<Integer> getAllCustomers() {
		List<Customer> empList = customerDaoRepository.findAll();
		List<Integer> ids = empList.stream().map(Entity -> Entity.getCustId()).collect(Collectors.toList());
		System.out.println(ids);		
		return ids;
	}

	@Override
	public Customer getCustomerById(int id) throws CustomerNotFoundException {
		Customer customer = customerDaoRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found for this id :: " + id));
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDaoRepository.save(customer);
	}

	@Override
	public Customer editCustomer(Customer customer)  {
		return customerDaoRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDaoRepository.delete(customer);
	}
	
	private CustomerDTO mapToDto(Customer post) {
		CustomerDTO customerDTO = modelMapper.map(post, CustomerDTO.class);
		customerDTO.setCustId(post.getCustId());
		return customerDTO;
	}
	
	/* I want to implement this using jdbc template,due to sort time not abled to implement.
	 * 
	 * 
	public ArrayList<Customer> getCustomerDetails() {
		String SELECT_ALL_CUSTOMER ="select c.custId,c.firstName,c.lastname,c.address, c.phoneNumber from customer c"
				+ " where  = ? order by custId ASC ";
		return (ArrayList<Customer>) jdbcTemplate.query(SELECT_ALL_CUSTOMER,new Object[]{}, new RowMapper<Customer>() {
		class CustomerModelMapper implements RowMapper<Customer> {
			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				Customer customer = new Customer();
				customer.setCustId(rs.getInt("custId"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastname"));
				customer.setAddress(rs.getString("address"));
				customer.setPhoneNumber(rs.getInt("phoneNumber"));
				return customer;
			}
		});
	}
*/
}



