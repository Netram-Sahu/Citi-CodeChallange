package com.citi.netram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

/**
 * This is entity class for customer
 * @Entity annotation specifies that the class is an entity and is mapped to a database table
 * @Data is a convenient shortcut annotation that bundles the features of 
 * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
 */
 
@Entity
@Table(name = "customer")
@Data 
public class Customer {
	@Id   
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native"  )
	@GenericGenerator(name = "native", strategy = "native"  )
	@Column(name = "custid")
	private int custId;
	
	@Column(name = "firstname", nullable = false)
	private String firstName;
	
	@Column(name = "lastname", nullable = false)
	private String lastName;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "phonenumber", nullable = false)
	private int phoneNumber;
	
	@Column(name = "ssn", nullable = false)
	private int ssn;
}
