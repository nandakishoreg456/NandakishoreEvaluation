package com.hospital.patient.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import com.hospital.patient.exception.BusinessException;
import com.hospital.patient.exception.DataNotFoundException;
import com.hospital.patient.repository.PatientRepository;

@RunWith(SpringRunner.class)
public class PatientServiceImplTest {

	@InjectMocks
	PatientServiceImpl patientServiceImpl;
	
	@Mock
	PatientServiceImpl patientServiceImplMock;
	
	@Mock
	PatientRepository patientRepository;
	
	//for getPatientDetailsTest
	Patient allPatients = null;
	List<Patient> patientsList = new ArrayList<>();	
	List<Patient> patientsListWithNull = null;
	List<Patient> patientsListWithEmpty = new ArrayList<>();
	
	//create Patient
	Patient createPatientReq = null;
	Patient createPatientResp = null;
	
	//Update Patient
	Patient updatePatient = null;
	Optional<Patient> updatePatientOptional = null;
	
	//delete Patient
	Patient deletePatient = null;
	Optional<Patient> deletePatientOptional = null;
	
	//getPatientByInput
	Optional<Patient> patientOptional =null;
	Optional<Patient> patientOptionalEmpty =null;
	
	@Before
	public void setUp () {
		//for getPatientDetailsTest
		allPatients = new Patient(0, "Ganesh", new Date(), new BigInteger("11"), new BigInteger("22"), null);		
		patientsList.add(allPatients);
		
		//create Patient
		createPatientReq = new Patient("Ram", new Date(), new BigInteger("99"), new BigInteger("88"), null);
		createPatientResp = new Patient(1, "Ram", new Date(), new BigInteger("99"), new BigInteger("88"), null);
		
		//update Patient
		updatePatient = new Patient(2, "Rama", new Date(), new BigInteger("77"), new BigInteger("66"), null);
		updatePatientOptional = Optional.of(updatePatient);
		
		//delete Patient
		deletePatient = new Patient(3, "Ramana", new Date(), new BigInteger("55"), new BigInteger("44"), null);
		deletePatientOptional = Optional.of(deletePatient);
		
		//getPatientDetailsByInput
		patientOptional = Optional.of(createPatientReq);
		patientOptionalEmpty = Optional.empty();
		
	}

	@Test
	public void getPatientDetailsTest() {
		Mockito.when(patientRepository.findAll()).thenReturn(patientsList);
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
		Mockito.when(patientRepository.save(createPatientReq)).thenReturn(createPatientResp);
		Patient patientResponse = patientServiceImpl.createPatient(createPatientReq);
		Assert.assertEquals(patientResponse.getName(),"Ram");
	}
	
	@Test(expected = BusinessException.class)
	public void createPatientTestException() {
		Mockito.when(patientRepository.save(createPatientReq)).thenThrow(new BusinessException("BusinessException"));
		patientServiceImpl.createPatient(createPatientReq);
	}
	
	@Test
	public void updatePatientTest() {
		Mockito.when(patientRepository.findById(2)).thenReturn(updatePatientOptional);
		Mockito.doReturn(updatePatient).when(patientServiceImplMock).getPatientDetailsByInput("2");
		
		Mockito.when(patientRepository.save(updatePatient)).thenReturn(updatePatient);
		Patient patientResponse = patientServiceImpl.updatePatient(updatePatient);
		Assert.assertEquals(patientResponse.getName(),"Rama");
	}
	
		
	@Test(expected = BusinessException.class)
	public void updatePatientTestException2() {
		Mockito.when(patientRepository.findById(2)).thenReturn(Optional.empty());
		Mockito.doReturn(updatePatient).when(patientServiceImplMock).getPatientDetailsByInput("2");
		
		Mockito.when(patientRepository.save(updatePatient)).thenReturn(updatePatient);
		Patient patientResponse = patientServiceImpl.updatePatient(updatePatient);
		Assert.assertEquals(patientResponse.getName(),"Rama");
	}
	
	@Test 
	public void deletePatientTest() {
		 Mockito.when(patientRepository.findById(3)).thenReturn(deletePatientOptional);
		 Mockito.doReturn(deletePatient).when(patientServiceImplMock).getPatientDetailsByInput("3");
		
		 Mockito.doNothing().when(patientRepository).delete(deletePatient);
		 DeleteResponse deleteResponse = patientServiceImpl.deletePatient(deletePatient);
		 Assert.assertEquals(deleteResponse.getStatus(),"Success"); 
	}
	
	@Test (expected=BusinessException.class)
	public void deletePatientExceptionTest() {
		 Mockito.when(patientRepository.findById(3)).thenReturn(patientOptionalEmpty);
		 Mockito.doReturn(deletePatient).when(patientServiceImplMock).getPatientDetailsByInput("3");
		
		 Mockito.doNothing().when(patientRepository).delete(deletePatient);
		 patientServiceImpl.deletePatient(deletePatient);
	}
	
	/*
	@Test
	public void updatePatientTest() {
		Mockito.when(patientRepository.save(updatePatient)).thenReturn(updatePatient);
		Patient patientResponse = patientServiceImpl.updatePatient(updatePatient);
		Assert.assertEquals(patientResponse.getName(),"Rama");
	}
	
	
	@Test(expected = BusinessException.class)
	public void updatePatientTestException() {
		Mockito.when(patientRepository.save(updatePatient)).thenThrow(new BusinessException("BusinessException"));
		patientServiceImpl.updatePatient(updatePatient);
	}
	
	@Test
	public void deletePatientTest() {
		Mockito.doNothing().when(patientRepository).delete(deletePatient);
		DeleteResponse deleteResponse = patientServiceImpl.deletePatient(updatePatient);
		Assert.assertEquals(deleteResponse.getStatus(),"Success");
	}
	
	
	@Test(expected = BusinessException.class)
	public void deletePatientTestException() {
		Mockito.doThrow(new BusinessException("BusinessException")).when(patientRepository).delete(deletePatient);
		patientServiceImpl.deletePatient(deletePatient);
	}
	*/
	
	@Test
	public void getPatientDetailsByIdTest() {
		Mockito.when(patientRepository.findById(0)).thenReturn(patientOptional);
		Patient patient = patientServiceImpl.getPatientDetailsByInput("0");
		Assert.assertEquals(patient.getName(),"Ram");
	}
	
	@Test(expected = DataNotFoundException.class)
	public void getPatientDetailsByIdTestException() {
		//Mockito.when(patientRepository.findById(1)).thenThrow(new DataNotFoundException("Data not found for ", "id", "1"));
		
		Mockito.when(patientRepository.findById(1)).thenReturn(patientOptionalEmpty).thenThrow(new DataNotFoundException("Data not found for ", "id", "1"));
		patientServiceImpl.getPatientDetailsByInput("1");
	}
	
	@Test
	public void getPatientDetailsByNameTest() {
		Mockito.when(patientRepository.findByName("Ram")).thenReturn(patientOptional);
		Patient patient = patientServiceImpl.getPatientDetailsByInput("Ram");
		Assert.assertEquals(patient.getName(),"Ram");
	}
	
	@Test(expected = DataNotFoundException.class)
	public void getPatientDetailsByNameTestException() {
		Mockito.when(patientRepository.findByName("Ramesh")).thenReturn(patientOptionalEmpty).thenThrow(new DataNotFoundException("Data not found for ", "name", "1"));
		patientServiceImpl.getPatientDetailsByInput("Ramesh");
	}
	
	
	
}
