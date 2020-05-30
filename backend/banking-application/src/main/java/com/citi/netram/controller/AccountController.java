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

import com.citi.netram.entity.Account;
import com.citi.netram.exception.AccountNotFoundException;
import com.citi.netram.service.AccountService;

/**
 * This is a controller class for Account details
 * @RestController annotation is used to create RESTful web services
 * @RequestMapping annotation configure the mapping of web requests
 * @Autowired annotation is used for automatic dependency injection
 * 
 * */

@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	/**
	 * This method is used to get all account details
	 * */
	@GetMapping("/getAllAccountDetails")
	public List<Account> getCustomersDetails() {
		System.out.println("......Netram Sahu in getAllCustomerDetails().....");
		return accountService.getAccountDetails();
	}
	
	/**
	 * This method is used to get all account details
	 * */
	@GetMapping("/allAccounts")
	public List<Integer> getAllAccounts() {
		System.out.println("......Netram Sahu in getAllCustomers().....");
		return accountService.getAllAccounts();
	}

	/**
	 * This method is used to get account details by custId
	 * */
	@GetMapping("/accountBy/{custId}")
	public ResponseEntity<Account> getAccountById(@PathVariable(value = "custId") int custId) {
		System.out.println("......Netram Sahu in getAccountById().....");
		Account account = null;
		try {
			account = accountService.getAccountById(custId);
		} catch (AccountNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(account);
	}
	
	/**
	 * This method is used to add new account details
	 * */
	@PostMapping("/addAccount")
	public Account addAccount(@Valid @RequestBody Account account) throws Exception{
		System.out.println("......Netram Sahu in addAccount().....");
		account.setAcountType(account.getAcountType());
		account.setFromAccount(account.getFromAccount());
		account.setToAccount(account.getToAccount());
		account.setAmount(account.getAmount());
		account.setTransType(account.getTransType());
		try{
			accountService.addAccount(account);
		}catch(Exception e) {
			throw new AccountNotFoundException("Failed to add");
		}
		return account;
	}
	
	/**
	 * This method is used to edit account details by custId
	 * */
	@PutMapping("/editAccount/{custId}")
	public ResponseEntity<Account> editAccount(@Valid @RequestBody Account account, @PathVariable int custId) throws Exception {
		System.out.println("......Netram Sahu in editAccount().....");
		Account editAccount =new Account();
		try{
			editAccount.setFromAccount((custId));
			editAccount.setAcountType(account.getAcountType());
			editAccount.setFromAccount(account.getFromAccount());
			editAccount.setToAccount(account.getToAccount());
			editAccount.setAmount(account.getAmount());
			editAccount.setTransType(account.getTransType());
		}catch(Exception e){
			throw new AccountNotFoundException("Failed to edit");
		}
		return ResponseEntity.ok(editAccount);
	}
	
	/**
	 * This method is used to delete account details
	 * */
	@DeleteMapping("/deleteAccount/{custId}")
	public ResponseEntity<Account> deleteAccount(@PathVariable int custId) throws Exception  {
		System.out.println("......Netram Sahu in deleteAccount()......");
		Account delAccount=new Account();
		try {
			delAccount.setFromAccount(custId);
			accountService.deleteAccount(delAccount);
		}catch(Exception e){
			throw new AccountNotFoundException("Failed to delete");
		}
		return ResponseEntity.ok(delAccount);
	}
}
