package com.hospital.patient.service;

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

import com.hospital.patient.beans.Patient;
import com.hospital.patient.exception.BusinessException;
import com.hospital.patient.repository.PatientRepository;

@RunWith(SpringRunner.class)
public class PatientServiceImplTest {

	@InjectMocks
	PatientServiceImpl patientServiceImpl;
	
	@Mock
	PatientRepository patientRepository;
	
	//for getPatientDetailsTest
	Patient patient = null;
	List<Patient> patients = new ArrayList<>();	
	List<Patient> patientsListWithNull = null;
	List<Patient> patientsListWithEmpty = new ArrayList<>();
	
	//create Patient
	Patient patientCreate = null;
	
	@Before
	public void setUp () {
		
		//for getPatientDetailsTest
		patient = new Patient();		
		patient.setName("Ganesh");
		patient.setDob(new Date());
		patient.setPrimary_phoneNumber(new BigInteger("9999999999"));
		patient.setSecondary_phoneNumber(new BigInteger("8888888888"));
		patients.add(patient);
		
		//create Patient
		patientCreate = patient;
		patientCreate.setId(1);
		
	}

	@Test
	public void getPatientDetailsTest() {
		Mockito.when(patientRepository.findAll()).thenReturn(patients);
		List<Patient> patients = patientServiceImpl.getPatientDetails();
		Assert.assertEquals(patients.get(0).getName(), "Ganesh");
	}
	
	@Test(expected = BusinessException.class)
	public void getPatientDetailsTestWithException() {
		Mockito.when(patientRepository.findAll()).thenReturn(patientsListWithNull);
		patientServiceImpl.getPatientDetails();
	}
	
	@Test(expected = BusinessException.class)
	public void getPatientDetailsTestWithEmptyException() {
		Mockito.when(patientRepository.findAll()).thenReturn(patientsListWithEmpty);
		patientServiceImpl.getPatientDetails();
	}
	
	@Test
	public void createPatientTest() {
		Mockito.when(patientRepository.save(patient)).thenReturn(patientCreate);
		Patient patientResponse = patientServiceImpl.createPatient(patient);
		Assert.assertEquals(patientResponse.getName(),"Ganesh");
	}
	
	@Test(expected = BusinessException.class)
	public void createPatientTestException() {
		Mockito.when(patientRepository.save(patient)).thenThrow(new BusinessException("BusinessException"));
		patientServiceImpl.createPatient(patient);
	}
	
	
	
}
