package com.jegan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jegan.dao.AdminRepository;
import com.jegan.exceptions.ServiceException;
import com.jegan.model.Admin;
import com.jegan.validator.AdminLoginValidator;

@Service
public class AdminLoginService {

	private AdminLoginService()
	{
		//default constructor
	}
	
	@Autowired
	AdminRepository adminRep;
	
	@Autowired
	AdminLoginValidator adminValidator;
	
	public void adminLogin(String userEmail , String passWord)
	{
		try {
			Admin admin = adminRep.findByUserEmailAndPassword(userEmail, passWord);
			AdminLoginValidator.isValidAdmin(admin);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
}
