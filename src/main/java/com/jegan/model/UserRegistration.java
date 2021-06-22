package com.jegan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value = "user_details")
public class UserRegistration {

	@Id
	private Integer id;
	@Column("username")
	private String userName;
	@Column("password")
	private String passWord;
	@Column("usermobilenumber")
	private Long mobileNumber;
	@Column("useremail")
	private String userEmail;
	
}
