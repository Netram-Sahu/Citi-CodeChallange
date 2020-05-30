package com.citi.netram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.citi.netram.entity.Account;

/**
 * This class is account repository class to perform crud operation
 * */

public interface AccountDaoRepository extends JpaRepository<Account, Integer>{

}
