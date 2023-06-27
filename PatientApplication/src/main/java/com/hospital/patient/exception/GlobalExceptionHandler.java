package com.hospital.patient.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** Represents a Patient.
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.2
 * @since 1.0
*/
@ControllerAdvice
public class GlobalExceptionHandler {

	/** Gets the ResponseEntity of ErrorResponse for the type of DataNotFoundException exceptions.
	 * @return A ResponseEntity<ErrorResponse> representing the ResponseEntity of ErrorResponse.
	*/
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException exception) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(new Date(), exception.getMessage()), HttpStatus.NOT_FOUND);
		
	}
	
	/** Gets the ResponseEntity of ErrorResponse for the type of BusinessException exceptions.
	 * @return A ResponseEntity<ErrorResponse> representing the ResponseEntity of ErrorResponse.
	*/
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException exception) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(new Date(), exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	/** Gets the ResponseEntity of ErrorResponse for the type of Exception class exception.
	 * @return A ResponseEntity<ErrorResponse> representing the ResponseEntity of ErrorResponse.
	*/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(new Date(), exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
