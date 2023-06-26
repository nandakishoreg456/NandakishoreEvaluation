package com.hospital.patient.service;

import java.util.List;

import com.hospital.patient.beans.DeleteResponse;
import com.hospital.patient.beans.Patient;

public interface PatientService {

	public List<Patient> getPatientDetails();
	
	public Patient getPatientDetailsByInput(String input);

	public Patient createPatient(Patient patient);
	
	public Patient updatePatient(Patient patient);

	public DeleteResponse deletePatient(Patient patient);

}
