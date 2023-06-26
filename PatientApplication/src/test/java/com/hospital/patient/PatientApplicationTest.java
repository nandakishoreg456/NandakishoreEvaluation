package com.hospital.patient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PatientApplicationTest {

	@Mock
	ConfigurableApplicationContext ctxt;
	
	@InjectMocks
	PatientApplication patientApplication;
	
	@Mock
	SpringApplication app;
	
	@Test
	public void main() {

		Mockito.when(app.run(new String[] {})).thenReturn(ctxt);
		patientApplication.main(new String[] {});
		
	}
	
}
