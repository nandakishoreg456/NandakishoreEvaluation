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

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ErrorResponse(Date timeStamp, String errorMessage) {
		super();
		this.timeStamp = timeStamp;
		this.errorMessage = errorMessage;
	}
	
}