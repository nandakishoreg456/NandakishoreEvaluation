package com.hospital.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.patient.beans.Patient;
import com.hospital.patient.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository patientRepository;
	
	public List<Patient> getPatientDetails() {
		
		return patientRepository.findAll();
	}

}
