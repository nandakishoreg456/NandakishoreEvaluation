package com.hospital.patient.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BusinessExceptionTest {

	@MockBean
	BusinessException businessException;
	
	@InjectMocks
	BusinessException businessException1;
	
	@Test
	public void getErrorMessageTest() {
		Mockito.when(businessException.getErrorMessage()).thenReturn("errorMessage");
		assertEquals(businessException.getErrorMessage(),"errorMessage");
	}
	
	@Test
	public void setErrorMessageTest() {
		businessException1.setErrorMessage("errorMessage");
		Assert.assertEquals(businessException1.getErrorMessage(), "errorMessage");
	}
}
