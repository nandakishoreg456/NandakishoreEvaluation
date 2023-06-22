package com.hospital.patient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.patient.beans.Patient;

/** Represents a PatientRepository which extends JpaRepository and interacts with Database
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.0
 * @since 1.0
*/
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	/** Gets the patient details based on the passed input- name
	 * @return A Patient from the Database based on input
	 * @param input A which can be either patient's name . 
	*/
	public Optional<Patient> findByName(String input);
}
