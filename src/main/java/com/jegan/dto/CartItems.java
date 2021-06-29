package com.jegan.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value="order_details")
public class CartItems {
	
	@Id
	private Integer id;
	@Column("vegetablename")
	private String vegetableName;
	@Column("price")
	private Integer vegetablePrice ;
	@Column("quantity")
	private Integer vegetableQuantity ;
	@Column("totalprice")
	private  Integer totalPrice;


}
