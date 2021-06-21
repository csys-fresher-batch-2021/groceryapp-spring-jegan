package com.jegan.exceptions;

public class ServiceException extends RuntimeException{
	
	/**
	 * This Exception is for Invalid Details
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This method will rise the exception when there is any validation issues
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}


}
