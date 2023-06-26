package com.hospital.patient.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.hospital.patient.beans.DeleteResponse;
import com.hospital.patient.beans.Patient;
import com.hospital.patient.service.PatientService;

@RunWith(SpringRunner.class)
public class PatientControllerTest {
	
	@InjectMocks
	PatientController patientController;
	
	@Mock
	PatientService patientService;
	
	//getPatientDetails
	Patient patient = null;
	List<Patient> patientList = null;
	
	DeleteResponse deleteResponse = null;
	
	@Before
	public void setUp () {
		patientList = new ArrayList<>();
		patient = new Patient(0, "Ganesh", new Date(), new BigInteger("11"), new BigInteger("22"), null);
		patientList.add(patient);
		
		//delete operation
		deleteResponse = new DeleteResponse();
		deleteResponse.setStatus("Success");
	}
	
	@Test
	public void patientDetailsTest() {
		Mockito.when(patientService.getPatientDetails()).thenReturn(patientList);
		List<Patient> patientListResp = patientController.patientDetails();
		Assert.assertEquals(patientListResp.get(0).getName(), "Ganesh");
	}
	
	@Test
	public void createPatientTest() {
		Mockito.when(patientService.createPatient(patient)).thenReturn(patient);
		Patient patientListResp = patientController.createPatient(patient);
		Assert.assertEquals(patientListResp.getName(), "Ganesh");
	}

	@Test
	public void updatePatientTest() {
		Mockito.when(patientService.updatePatient(patient)).thenReturn(patient);
		Patient patientListResp = patientController.updatePatient(patient);
		Assert.assertEquals(patientListResp.getName(), "Ganesh");
	}
	
	@Test
	public void deletePatientTest() {
		Mockito.when(patientService.deletePatient(patient)).thenReturn(deleteResponse);
		DeleteResponse deleteResponse = patientController.deletePatient(patient);
		Assert.assertEquals(deleteResponse.getStatus(), "Success");
	}
	
	@Test
	public void getPatientByInputTest() {
		Mockito.when(patientService.getPatientDetailsByInput("0")).thenReturn(patient);
		Patient patient = patientController.patientInformtionByInput("0");
		Assert.assertEquals(patient.getName(), "Ganesh");
	}
}
