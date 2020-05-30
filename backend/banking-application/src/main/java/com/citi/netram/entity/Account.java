package com.citi.netram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * This is entity class for customer
 * @Entity annotation specifies that the class is an entity and is mapped to a database table
 * @Data is a convenient shortcut annotation that bundles the features of 
 * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
 */ 

@Entity
@Table(name = "account")
@Data
public class Account { 
	@Id 
	@Column(name = "fromaccount", nullable = false)
	private int fromAccount;
	
	@Column(name = "toaccount", nullable = false)
	private int toAccount;
	
	@Column(name = "acounttype", nullable = false)
	private String acountType;
	
	@Column(name = "transtype", nullable = false)
	private String transType;
	
	@Column(name = "amount", nullable = false)
	private int amount;
}
