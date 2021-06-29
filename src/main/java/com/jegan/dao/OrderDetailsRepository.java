package com.jegan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jegan.dto.CartItems;

@Repository
public class OrderDetailsRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemp;
	
	
	public void insert(CartItems items)
	{
		String sql = "insert into order_details(vegetableName,price,quantity,totalPrice) values(?,?,?,?)";
		
		Object[] cart = { items.getVegetableName(),items.getVegetablePrice(),items.getVegetableQuantity(),items.getTotalPrice()	};
		
		jdbcTemp.update(sql,cart);
	}

}
