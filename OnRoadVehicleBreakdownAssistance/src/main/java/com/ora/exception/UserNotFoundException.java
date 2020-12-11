package com.ora.exception;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException(String message)
	{
		super(message);
		System.out.println(message);
	}

}

