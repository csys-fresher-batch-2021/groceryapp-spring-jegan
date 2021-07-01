package com.jegan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jegan.dao.UserPurchaseRepository;
import com.jegan.dto.UserPurchase;
import com.jegan.service.UserPurchaseService;

@RestController
public class UserPurchaseController {
	
	@Autowired
	UserPurchaseService purchaseService;
	
	@Autowired
	UserPurchaseRepository purchaseRep;

	
	@GetMapping("PurchaseHistroy")
	public Iterable<UserPurchase> listPurchase()
	{
		return purchaseService.getUserPurchase();
	}

	@PostMapping("UserPurchase")
	public void addUserPurchase(@RequestBody UserPurchase purchase)
	{
		purchaseService.addUserPurchase(purchase);
		
	}

}
