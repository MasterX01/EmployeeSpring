package com.employeepayroll.exception;

public class PayrollException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final exceptionType type;
	
	public enum exceptionType{
		EMPLOYEE_NOT_FOUND
	}
	
	public PayrollException(exceptionType exception, String message) {
		super(message);
		this.type = exception;
	}

}
