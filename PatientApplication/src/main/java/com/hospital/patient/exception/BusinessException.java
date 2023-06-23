package com.hospital.patient.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3414406767033377194L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public BusinessException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	
}
