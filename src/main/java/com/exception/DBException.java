package com.exception;

public class DBException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	private String message;
	public DBException() {
		
	}
	public DBException(String message) {
		this.message=message;
	}

}
