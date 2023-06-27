package com.hospital.patient.exception;

import java.util.Date;

/** Represents a Patient.
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.2
 * @since 1.0
*/
public class ErrorResponse {

	private Date timeStamp;
	private String errorMessage;

	/** Gets the timeStamp.
	 * @return A Date representing the timeStamp.
	*/
	public Date getTimeStamp() {
		return timeStamp;
	}

	/** Sets the timeStamp
	 * @param timeStamp A Date containing the timeStamp.
	*/
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	/** Gets the errorMessage.
	 * @return A String representing the errorMessage.
	*/
	public String getErrorMessage() {
		return errorMessage;
	}

	/** Sets the errorMessage
	 * @param resourceName A String containing the errorMessage.
	*/
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	* Creates constructor for class ErrorResponse
	* @param timeStamp  A Date containing the timeStamp.
	* @param errorMessage  A String containing the errorMessage.
	*/
	public ErrorResponse(Date timeStamp, String errorMessage) {
		super();
		this.timeStamp = timeStamp;
		this.errorMessage = errorMessage;
	}
	
}