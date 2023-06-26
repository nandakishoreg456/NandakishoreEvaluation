package com.hospital.patient.exception;

/** Represents a Patient.
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.2
 * @since 1.0
*/
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3414406767033377194L;
	private String errorMessage;

	/** Gets the patient's name.
	 * @return A String representing errorMessage.
	*/
	public String getErrorMessage() {
		return errorMessage;
	}

	/** Sets the errorMessage.
	 * @param Id A String containing the errorMessage.
	*/
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	* Creates constructor for class BusinessException
	* @param errorMessage  A String containing the errorMessage.
	*/
	public BusinessException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	
}
