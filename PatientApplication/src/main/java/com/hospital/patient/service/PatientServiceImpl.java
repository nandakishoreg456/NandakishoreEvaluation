package com.hospital.patient.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.patient.beans.DeleteResponse;
import com.hospital.patient.beans.Patient;
import com.hospital.patient.exception.BusinessException;
import com.hospital.patient.exception.DataNotFoundException;
import com.hospital.patient.repository.PatientRepository;

/** Represents a Patient Service which have business and interacts with Repository layer
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.2
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
		
		 List<Patient> patientsList = patientRepository.findAll();
		 
		 if(patientsList == null || (patientsList != null && patientsList.isEmpty())) {
			 throw new BusinessException("Patients data is empty");
		 }
		 
		 return patientsList;
	}

	/** Creates the patient.
	 * @return A Patient after creating Patient in the Database
	 * @param patient A Patient containing the fields id, name, dob, address, primary_phoneNumber, secondary_phoneNumber . 
	*/	
	@Override
	public Patient createPatient(Patient patient) {
		try {
			return patientRepository.save(patient);
		} catch(Exception e) {
			throw new BusinessException("Save operation failed for Id:"+patient.getId()+""
					+ ", due to"+ e.getMessage());
		}
		
	}

	/** Gets the patient's details based on the passed input - identifier or name
	 * @return A Patient from the Database based on input
	 * @param input A which can be either patient's id or name . 
	*/	
	@Override
	public Patient getPatientDetailsByInput(String input) {
		Patient patient = null;
		
		
		if(StringUtils.isNumeric(input)) { 
			patient =  patientRepository.findById(Integer.parseInt(input)).orElseThrow(() -> new DataNotFoundException("Data not found for ", "id", input)); 
		} else { 
			patient =  patientRepository.findByName(input).orElseThrow(() -> new DataNotFoundException("Data not found for ", "name", input)); 
		}
		 
		return patient;
	}

	/** Update the patient.
	 * @return A Patient after updating Patient in the Database
	 * @param patient A Patient containing the fields id, name, dob, address, primary_phoneNumber, secondary_phoneNumber. 
	*/
	@Override
	public Patient updatePatient(Patient patient) {
		Patient patientUpdateResponse = null;
		try {
			Patient patientDetails = getPatientDetailsByInput(String.valueOf(patient.getId()));
			if(patientDetails!= null && patient.getId() == patient.getId()) {
				patientUpdateResponse = patientRepository.save(patient);
			}
			return patientUpdateResponse;	
		} catch(Exception e) {
			throw new BusinessException("Update operation failed for Id:"+patient.getId()+""
					+ ", due to "+ e.getMessage());
		}
	}

	/** delete the patient.
	 * @return A String after deleting passed Patient in the Database
	 * @param patient A Patient containing the fields id, name, dob, address, primary_phoneNumber, secondary_phoneNumber . 
	*/	
	@Override
	public DeleteResponse deletePatient(Patient patient) {
		DeleteResponse deleteResponse = null;
		try {
			Patient patientDetails = getPatientDetailsByInput(String.valueOf(patient.getId()));
			if(patientDetails!= null && patient.getId() == patient.getId()) {
				patientRepository.delete(patient);
				deleteResponse = new DeleteResponse();
				deleteResponse.setStatus("Success");
			}
		}
		catch(Exception e) {
			throw new BusinessException("Delete operation failed for Id: "+patient.getId() +""
					+ ", due to "+ e.getMessage());
		}
		return deleteResponse;
	}

}
