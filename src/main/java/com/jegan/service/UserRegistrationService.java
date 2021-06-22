package com.jegan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jegan.dao.UserRepository;
import com.jegan.exceptions.ServiceException;
import com.jegan.model.UserRegistration;
import com.jegan.validator.UserRegistrationValidator;


@Service
public class UserRegistrationService {
	
	private UserRegistrationService()
	{
		//default constructor
	}
	
	@Autowired
    UserRepository userRep;
	
	
	public Iterable<UserRegistration> getAllUser()
	{
		return userRep.findAll();
	}
    
	
	/**
	 * Adding userDetails to the userDetails list
	 * @param registration
	 * @return
	 */
	public boolean addUser(UserRegistration registration) {
		boolean validUser = false;
		try {
			boolean validUserName =UserRegistrationValidator.validateUserName(registration.getUserName());
			boolean validPassword = UserRegistrationValidator.validateUserPassWord(registration.getPassWord());
			boolean validMobileNumber = UserRegistrationValidator.validateUserMobileNumber(registration.getMobileNumber());
			boolean validEmail = UserRegistrationValidator.validateUserEmail(registration.getUserEmail());

			if (validUserName && validPassword && validEmail && validMobileNumber) 
			{
				userRep.save(registration);
				validUser = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("unable to Register");
		}
		return validUser;
	}

}
