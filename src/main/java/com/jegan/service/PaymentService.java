package com.jegan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jegan.dao.OrderDetailsRepository;
import com.jegan.dto.CartItems;



@Service
public class PaymentService {
	
	@Autowired
    OrderDetailsRepository order;
	
	public int calculateGrossTotal(List<CartItems> cartItems)
	{
		int grossTotal = 0;
		for(CartItems item: cartItems)
		{
			grossTotal = grossTotal + item.getTotalPrice() ;
			//OrderDetailsDAO dao = new OrderDetailsDAO();
			//dao.save(item);
			order.insert(item);
		}
		return grossTotal;
	}
}

