package com.citi.netram.service;

import java.util.List;

import com.citi.netram.entity.Account;
import com.citi.netram.exception.AccountNotFoundException;

public interface AccountService {
	public List<Account> getAccountDetails() ;
	public List<Integer> getAllAccounts();		
	public Account getAccountById(int id) throws AccountNotFoundException;
	public Account addAccount(Account account) ;
	public Account editAccount(Account account) ;
	public void deleteAccount(Account account) ;
}
