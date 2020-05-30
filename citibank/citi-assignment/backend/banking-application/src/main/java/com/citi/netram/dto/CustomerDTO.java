package com.citi.netram.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*This is class is used to transfer data as per requirment*/

public class CustomerDTO {
	@Getter;
	@Setter;
	@NoArgsConstructor;
	@AllArgsConstructor;
	private int custId;
	private String firstName;
	private String lastName;
	private String address;
	private int phoneNumber;
}
