
package com.citi.netram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.citi.netram.entity.Account;
import com.citi.netram.entity.Customer;

/**
 * This class is customer repository class to perform crud operation
 * */

public interface CustomerDaoRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Account> {

}
