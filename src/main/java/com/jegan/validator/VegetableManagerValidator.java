package com.jegan.validator;

import org.springframework.stereotype.Component;

import com.jegan.exceptions.ValidatorException;

 
@Component
public class VegetableManagerValidator {

	private VegetableManagerValidator()
	{
		//defaultconstructor
	}
	
	public static void checkForNullandEmpty(String vegetableName) {
		if(vegetableName==null || vegetableName.trim().equals(""))
		{
			throw new ValidatorException("vegetableName cannot be empty");
		}
	}
	
	public static void checkNotNumeric(String vegetableName) {
		if(!vegetableName.matches("^[a-zA-Z]*$"))
		{
			throw new ValidatorException("vegetableName cannot be Number");
		}
	}
    
	public static void checkForPriceInvalidNumandNull(Integer vegetablePrice)
	{
		if(vegetablePrice < 0 ||  vegetablePrice== 0)
		{
			throw new ValidatorException("Invalid vegetablePrice");
		}
	}
	
	public static void checkForQuantityInvalidNumandNull(Integer vegetableQuantity)
	{
		if(vegetableQuantity < 0 || vegetableQuantity == 0)
		{
			throw new ValidatorException("Invalid vegetableQuantity");
		}
	}
}
