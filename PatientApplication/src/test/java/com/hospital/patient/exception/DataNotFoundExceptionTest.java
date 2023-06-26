package com.hospital.patient.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DataNotFoundExceptionTest {
	/*
	getResourceName
	getFieldName
	getFieldValue
	*/
	
	@MockBean
	DataNotFoundException exception;
	
	@InjectMocks
	DataNotFoundException exception1;
	
	@Test
	public void getResourceTest() {
		Mockito.when(exception.getResourceName()).thenReturn("SaveOperation");
		assertEquals(exception.getResourceName(), "SaveOperation"); 
	}
	
	@Test
	public void getFieldNameTest() {
		Mockito.when(exception.getFieldName()).thenReturn("id");
		assertEquals(exception.getFieldName(), "id"); 
	}
	
	@Test
	public void getFieldValueTest() {
		Mockito.when(exception.getFieldValue()).thenReturn("101");
		assertEquals(exception.getFieldValue(), "101"); 
	}
	
	@Test
	public void setResourceTest() {
		exception1.setResourceName("SaveOperation");
		Assert.assertEquals(exception1.getResourceName(), "SaveOperation");
	}
	
	@Test
	public void setFieldNameTest() {
		exception1.setFieldName("id");
		Assert.assertEquals(exception1.getFieldName(), "id");
	}
	
	@Test
	public void setFieldValueTest() {
		exception1.setFieldValue("101");
		Assert.assertEquals(exception1.getFieldValue(), "101");
	}

}
