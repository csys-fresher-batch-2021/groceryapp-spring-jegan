package com.jegan.validator;

import org.springframework.stereotype.Component;

import com.jegan.exceptions.ValidatorException;
import com.jegan.model.Admin;

@Component
public class AdminLoginValidator {

	private AdminLoginValidator()
	{
		//default constructor
	}

	
	public static void isValidAdmin(Admin admin)
	{
		if(admin == null)
		{
			throw new ValidatorException("Invalid Login Credentials");
		}
	}

}
