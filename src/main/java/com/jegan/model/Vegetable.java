package com.jegan.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value="vegetables")
public class Vegetable {
	
	@Id
	private Integer id;
	@Column("vegetablename")
	private String vegetableName;
	private Integer price;
	private Integer quantity;

}

