package com.citi.netram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/* This is entity class for customer
 */

@Entity
@Table(name = "customer")
public class Customer {
	private int custId;
	private String firstName;
	private String lastName;
	private String address;
	private int phoneNumber;
	private int ssn;
	
	public Customer() {
		super();
	}


	public Customer(String firstName, String lastName, String address, int phoneNumber, int ssn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
	}


	@Id   
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native"  )
	@GenericGenerator(name = "native", strategy = "native"  )
	@Column(name = "custid")
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Column(name = "firstname", nullable = false)
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastname", nullable = false)
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phonenumber", nullable = false)
	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "ssn", nullable = false)
	public int getSsn() {
		return ssn;
	}


	public void setSsn(int ssn) {
		this.ssn = ssn;
	}


}
