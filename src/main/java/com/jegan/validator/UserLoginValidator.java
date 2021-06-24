package com.jegan.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jegan.exceptions.ValidatorException;
import com.jegan.model.UserRegistration;

@Component
public class UserLoginValidator {
	private UserLoginValidator()
	{
		//default constructor
	}

	
	public static void isValidUser(Optional<UserRegistration> user)
	{
		if(user.isEmpty())
		{
			throw new ValidatorException("Invalid Login Credentials");
		}
	}

}
