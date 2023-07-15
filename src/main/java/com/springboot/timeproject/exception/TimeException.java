package com.springboot.timeproject.exception;

public class TimeException extends RuntimeException{
	
	public TimeException() {
	 super();
	}
	
	public TimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public TimeException(String message) {
		super(message);
	}
	
	public TimeException(Throwable cause) {
		super(cause);
	}
	
}
