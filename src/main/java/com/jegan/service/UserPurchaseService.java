package com.jegan.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jegan.dao.UserPurchaseRepository;
import com.jegan.dto.UserPurchase;

@Service
public class UserPurchaseService {
	
	@Autowired
	UserPurchaseRepository purchaseRep;
	
	public Iterable<UserPurchase> getUserPurchase()
	{
		return purchaseRep.findAll();
	}
	
	public void addUserPurchase(UserPurchase purchase)
	{
		purchase.setPurchaseDate(LocalDateTime.now());
		purchaseRep.save(purchase);
	}

}
