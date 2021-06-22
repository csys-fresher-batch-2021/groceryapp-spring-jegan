package com.jegan.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.jegan.exceptions.ValidatorException;

@Component
public class UserRegistrationValidator {
	
	private UserRegistrationValidator()
	{
		//default constructor
	}
	
	/**
	 * This method is used for validating userName 
	 * @param registration
	 * @return
	 */
	public static boolean validateUserName(String userName)
	{
		boolean added= false;
		int noOfCharactersInUserName = 25;
		
			int userNamelength = getLength(userName);
			if( userName == null  || userName.trim().equals("") )
			{
				throw new ValidatorException("UserName cannot be Null");
			}
			else if(userNamelength < 4 || userNamelength > noOfCharactersInUserName)
			{
			  throw new ValidatorException("UserName must be 4 to 25 Charcters");
			}
			else
			{
			   
			   added = true;
			}
		return added;	
	}
    
	/**
	 * This method is used for getting the length of particular String
	 * @param string
	 * @return
	 */
	private static int getLength(String string) {
		return string.length();
	}
    
	/**
	 * This method is used for validating user password
	 * @param registration
	 * @return
	 */
	public static boolean validateUserPassWord(String passWord)
	{
		boolean checkPassWord = false;
		
			String passWordType = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&-+=])(?=\\S+$).{8,}$";
			boolean checkPassWordType = Pattern.matches(passWordType, passWord);
			if(passWord != null && !passWord.trim().equals("") && checkPassWordType)
			{
				
			    checkPassWord = true;
			   
			}
			else
			{
				throw new ValidatorException("Invalid passWord");
			}
		return checkPassWord;
		
	}
	
	/**
	 * This method is used for validating user mobileNumber
	 * @param registration
	 * @return
	 */
    public static boolean validateUserMobileNumber(Long mobileNumber)
    {
    	boolean checkMobileNumber = false;
    
    		String mobileNumberStr = Long.toString(mobileNumber);
    		String mobileNumberType = "[[0][91]]{1,2}[6-9]{2}[0-9]{8}";
   
    		boolean checkMobileNumberType = Pattern.matches(mobileNumberType, mobileNumberStr);
    		if(mobileNumberStr != null && !mobileNumberStr.trim().equals("") && checkMobileNumberType)
    		{
    			checkMobileNumber = true;
    			
    		}
    		else
    		{
    			throw new ValidatorException("Invalid MobileNumber");
    		}
		return checkMobileNumber;
    	
    }
    
    /**
     * This method is used for validating user email
     * @param registration
     * @return
     */
	public static boolean validateUserEmail(String userEmail)
	{
		boolean checkEmail = false;
		
			String emailType = "^[a-zA-Z0-9_+&]+@(?:[a-zA-Z0-9-]*+\\.)+[a-zA-Z]{2,7}$";
			boolean checkEmailType = Pattern.matches(emailType,  userEmail);
			if(userEmail != null && !userEmail.trim().equals("") && checkEmailType)
			{
				checkEmail = true;
			
			}
			else
			{
				throw new ValidatorException("Invalid UserEmail");
			}
		return checkEmail;

}
}