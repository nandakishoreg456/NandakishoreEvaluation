package com.hospital.patient.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException exception) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(new Date(), exception.getMessage()), HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException exception) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(new Date(), exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(new Date(), exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
