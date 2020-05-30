package com.citi.netram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* This is entity class for account
 */

@Entity
@Table(name = "account")
public class Account {
	private int fromAccount;
	private int toAccount;
	private String acountType;
	private String transType;
	private int amount;
	
	public Account() {
		super();
	}
	public Account(int fromAccount, int toAccount, String acountType, String transType, int amount) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.acountType = acountType; 
		this.transType = transType;
		this.amount = amount;
	}
	@Id 
	@Column(name = "fromaccount", nullable = false)
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	@Column(name = "toaccount", nullable = false)
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	@Column(name = "acounttype", nullable = false)
	public String getAcountType() {
		return acountType;
	}
	public void setAcountType(String acountType) {
		this.acountType = acountType;
	}
	@Column(name = "transtype", nullable = false)
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	@Column(name = "amount", nullable = false)
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
