package com.citi.netram.dto;

import lombok.Data;

/**
 * This is class is used to transfer data as per requirment
 * @Data is a convenient shortcut annotation that bundles the features of 
 * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
 */
@Data
public class CustomerDTO {
	private int custId;
	private String firstName;
	private String lastName;
	private String address;
	private int phoneNumber;
} 