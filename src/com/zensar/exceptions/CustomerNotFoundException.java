package com.zensar.exceptions;

public class CustomerNotFoundException extends Exception{
	private String str;

	public CustomerNotFoundException(String str) {
		super(str);
	}
	
	

}
