package com.hospital.patient.beans;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

	
@RunWith(SpringRunner.class)
public class DeleteResponseTest {

	@Mock
	DeleteResponse deleteResponse;
	
	@InjectMocks
	DeleteResponse deleteResponse1;
	
	@Test
	public void getStatusTest(){
		Mockito.when(deleteResponse.getStatus()).thenReturn("Success");
		String status = deleteResponse.getStatus();
		Assert.assertEquals(status, "Success");
	}
	
	@Test
	public void setStatusTest(){
		//Mockito.doNothing().when(deleteResponse1).setStatus("Success");//.thenReturn("Success");
		deleteResponse1.setStatus("Success");
		Assert.assertEquals(deleteResponse1.getStatus(), "Success");
	}
}
