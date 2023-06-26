package com.hospital.patient.exception;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class GlobalExceptionHandlerTest {
	
	@Mock
	GlobalExceptionHandler exceptionHandler;
	
	@InjectMocks
	GlobalExceptionHandler exceptionHandlerInject;
	
	@Mock
	DataNotFoundException dataNotFoundException;
	
	@Mock
	BusinessException businessException;

	@Test
	public void handleDataNotFoundExceptionTest() {
		
		ResponseEntity<ErrorResponse> errorRespEntity = new ResponseEntity<ErrorResponse>(new ErrorResponse(new Date(), "errorMessage"), HttpStatus.NOT_FOUND);
		Mockito.when(exceptionHandler.handleDataNotFoundException(dataNotFoundException)).thenReturn(errorRespEntity);
		ResponseEntity<ErrorResponse> errorResponseEntity = exceptionHandlerInject.handleDataNotFoundException(dataNotFoundException);
		Assert.assertEquals(errorResponseEntity.getStatusCode(),errorRespEntity.getStatusCode());
	}
	
	@Test
	public void handleBusinessExceptionTest() {
		ResponseEntity<ErrorResponse> errorRespEntity = new ResponseEntity<ErrorResponse>(new ErrorResponse(new Date(), "errorMessage"), HttpStatus.INTERNAL_SERVER_ERROR);
		Mockito.when(exceptionHandler.handleBusinessException(businessException)).thenReturn(errorRespEntity);
		ResponseEntity<ErrorResponse> errorResponseEntity = exceptionHandlerInject.handleBusinessException(businessException);
		Assert.assertEquals(errorResponseEntity.getStatusCode(),errorRespEntity.getStatusCode());
		
		//Assert.assertEquals(exceptionHandlerInject.handleBusinessException(businessException),errorRespEntity);
	}
	
	@Test
	public void handleExceptionTest() {
		ResponseEntity<ErrorResponse> errorRespEntity = new ResponseEntity<ErrorResponse>(new ErrorResponse(new Date(), "errorMessage"), HttpStatus.INTERNAL_SERVER_ERROR);
		Mockito.when(exceptionHandler.handleException(businessException)).thenReturn(errorRespEntity);
		ResponseEntity<ErrorResponse> errorResponseEntity = exceptionHandlerInject.handleException(businessException);
		Assert.assertEquals(errorResponseEntity.getStatusCode(),errorRespEntity.getStatusCode());
	}
}
