package com.hospital.patient.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.patient.beans.Patient;
import com.hospital.patient.exception.DataNotFoundException;
import com.hospital.patient.repository.PatientRepository;

/** Represents a Patient Service which have business and interacts with Repository layer
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.0
 * @since 1.0
*/
@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository patientRepository;
	
	/** Gets the all patient's details.
	 * @return A List of Patients representing List of Patient details 
	*/
	public List<Patient> getPatientDetails() {
		
		return patientRepository.findAll();
	}

	/** Creates the patient.
	 * @return A Patient after creating Patient in the Database
	 * @param patient A Patient containing the fields id, name, dob, address, primary_phoneNumber, secondary_phoneNumber . 
	*/	
	@Override
	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	/** Gets the patient's details based on the passed input - identifier or name
	 * @return A Patient from the Database based on input
	 * @param input A which can be either patient's id or name . 
	*/	
	@Override
	public Patient getPatientDetailsByInput(String input) {
		Optional<Patient> patient = null;
		
		
		if(StringUtils.isNumeric(input)) { 
			patient =  Optional.ofNullable(patientRepository.findById(Integer.parseInt(input)).orElseThrow(() -> new DataNotFoundException("Data not found for ", "id", input))); 
		} else { 
			patient =  Optional.ofNullable(patientRepository.findByName(input).orElseThrow(() -> new DataNotFoundException("Data ", "input", input))); 
		}
		 
		return patient.isEmpty()?null:patient.get();
	}

	/** Update the patient.
	 * @return A Patient after updating Patient in the Database
	 * @param patient A Patient containing the fields id, name, dob, address, primary_phoneNumber, secondary_phoneNumber. 
	*/
	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	/** delete the patient.
	 * @return A String after deleting passed Patient in the Database
	 * @param patient A Patient containing the fields id, name, dob, address, primary_phoneNumber, secondary_phoneNumber . 
	*/	
	@Override
	public String deletePatient(Patient patient) {
		try {
			patientRepository.delete(patient);
		} catch(Exception e) {
			return "delete operation failed";
		}
		return "Delete Successfully";
		
	}

}
