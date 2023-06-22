package com.hospital.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.patient.beans.Patient;
import com.hospital.patient.service.PatientService;

/** Represents a Patient Controller which have list of patient end points and interacts with Service layer
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.0
 * @since 1.0
*/
@RestController
@RequestMapping(value="/patient")
public class PatientController {
	@Autowired
	PatientService patientService;
	
	/** Gets the all patient's details.
	 * @return A List of Patients representing List of Patient details 
	*/
	@GetMapping(value="/details")
	public List<Patient> patientDetails() {
		
		return patientService.getPatientDetails();
		
	}
	
	/** Gets the patient's details based on the passed input - identifier or name
	 * @return A Patient from the Database based on input
	 * @param input A which can be either patient's id or name . 
	*/
	@GetMapping(value="/details/{input}")
	public Patient patientInformtion(@PathVariable String input) {
		return patientService.getPatientDetailsByInput(input);
	}
	
	/** Creates the patient.
	 * @return A Patient after creating Patient in the Database
	 * @param patient A Patient containing the fields id, name, dob, address, primary_phoneNumber, secondary_phoneNumber. 
	*/
	@PostMapping(value="/save")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}
	
	/** Update the patient.
	 * @return A Patient after updating Patient in the Database
	 * @param patient A Patient containing the fields id, name, dob, address, primary_phoneNumber, secondary_phoneNumber . 
	*/	
	@PutMapping(value="/update")
	public Patient updatePatient(@RequestBody Patient patient) {
		return patientService.updatePatient(patient);
	}
	
	/** delete the patient.
	 * @return A String after deleting passed Patient in the Database
	 * @param patient A Patient containing the fields id, name, dob, address, primary_phoneNumber, secondary_phoneNumber . 
	*/	
	@DeleteMapping(value="/delete")
	public String deletePatient(@RequestBody Patient patient) {
		return patientService.deletePatient(patient);
	}

}
