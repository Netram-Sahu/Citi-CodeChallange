package com.citi.netram.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.netram.entity.Account;
import com.citi.netram.exception.AccountNotFoundException;
import com.citi.netram.repository.AccountDaoRepository;

/**
 * This class is account service implementation class that perform service tasks
 * @Service annotation is used in service layer
 * 
 * */
 
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDaoRepository accountDaoRepository;

	@Override
	public List<Account> getAccountDetails() {
		List<Account> account= new ArrayList<Account>();
		account=accountDaoRepository.findAll();
		return account;
	}

	@Override
	public List<Integer> getAllAccounts() {
		List<Account> empList = accountDaoRepository.findAll();
		List<Integer> ids = empList.stream().map(Entity -> Entity.getFromAccount()).collect(Collectors.toList());
		System.out.println(ids);		
		return ids;
	}

	@Override
	public Account getAccountById(int id) throws AccountNotFoundException {
		Account account = accountDaoRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not found for this id :: " + id));
		return account;
	}

	@Override
	public Account addAccount(Account account) {
		return accountDaoRepository.save(account);
	}

	@Override
	public Account editAccount(Account account)  {
		return accountDaoRepository.save(account);
	}

	@Override
	public void deleteAccount(Account account) {
		accountDaoRepository.delete(account);
	}
	/* I want to implement this using jdbc template,due to sort time not abled to implement.
	 * 
	 * 
	public ArrayList<Account> getAccountDetails() {
		String SELECT_ALL_ACCOUNT ="select c.custId,c.firstName,c.lastname,c.address, c.phoneNumber from customer c"
				+ " where  = ? order by custId ASC ";
		return (ArrayList<Account>) jdbcTemplate.query(SELECT_ALL_ACCOUNT,new Object[]{}, new RowMapper<Customer>() {
		class AccountModelMapper implements RowMapper<Account> {
			@Override
			public Account mapRow(ResultSet rs, int arg1) throws SQLException {
				Account account = new Account();
				account.setCustId(rs.getInt("custId"));
				account.setFirstName(rs.getString("firstName"));
				account.setLastName(rs.getString("lastname"));
				account.setAddress(rs.getString("address"));
				account.setPhoneNumber(rs.getInt("phoneNumber"));
				return customer;
			}
		});
	}
*/
}
