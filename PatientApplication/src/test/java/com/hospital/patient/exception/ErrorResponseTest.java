package com.hospital.patient.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ErrorResponseTest {

	@MockBean
	ErrorResponse errorResponse;
	
	@InjectMocks
	ErrorResponse errorResponse1;
	
	private SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
	
	@Test
	public void getErrorMessageTest() {
		Mockito.when(errorResponse.getErrorMessage()).thenReturn("Success");
		assertEquals(errorResponse.getErrorMessage(),"Success");
	}
	
	
	@Test
	public void getTimeStampTest() throws ParseException {
		Date fixedDateTime = DATE_FORMATTER.parse("01/07/2016 16:45:00:000");
		Mockito.when(errorResponse.getTimeStamp()).thenReturn(fixedDateTime);
		assertEquals(errorResponse.getTimeStamp(), fixedDateTime);
	}
	
	@Test
	public void setErrorMessageTest() {
		//Mockito.doNothing().when(address).setHouseNumber(30);
		errorResponse1.setErrorMessage("Success");
		Assert.assertEquals(errorResponse1.getErrorMessage(), "Success");
	}
	
	@Test
	public void setTimeStampTest() throws ParseException {
		
		Date fixedDateTime = DATE_FORMATTER.parse("01/07/2016 16:45:00:000");
		errorResponse1.setTimeStamp(fixedDateTime);
		Assert.assertEquals(errorResponse1.getTimeStamp(), fixedDateTime);
	}
	
	/*
	 * @Test public void setDobTest() throws ParseException { Date fixedDateTime =
	 * DATE_FORMATTER.parse("01/07/2016 16:45:00:000");
	 * patient1.setDob(fixedDateTime); Assert.assertTrue(patient1.getDob()!=null); }
	 */

	
}
