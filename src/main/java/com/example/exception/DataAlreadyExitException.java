package com.example.exception;

public class DataAlreadyExitException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public DataAlreadyExitException(String message) {
		super(message);
	}
	
}
