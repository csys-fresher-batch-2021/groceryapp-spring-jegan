package com.jegan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value="employees")
public class Admin {

	@Id
	private Integer id;
	@Column("useremail")
	private String userEmail;
	@Column("password")
	private String passWord;
}
