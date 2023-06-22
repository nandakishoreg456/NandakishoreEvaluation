package com.hospital.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.patient.beans.Patient;
import com.hospital.patient.service.PatientService;

@RestController
@RequestMapping(value="/patient")
public class PatientController {
	@Autowired
	PatientService patientService;
	
	@RequestMapping(method=RequestMethod.GET, value="/details")
	public List<Patient> patientDetails() {
		
		return patientService.getPatientDetails();
		
	}

}
