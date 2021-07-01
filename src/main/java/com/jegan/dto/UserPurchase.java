package com.jegan.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value="user_purchase_histroy")
public class UserPurchase {
	
	@Id
	private Integer id;
	@Column("useremail")
	private String userEmail;
	@Column("totalamount")
	private Integer totalAmount;
	@Column("purchase_date")
	private LocalDateTime purchaseDate;
}
