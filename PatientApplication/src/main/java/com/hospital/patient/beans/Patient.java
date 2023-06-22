package com.hospital.patient.beans;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/** Represents a Patient.
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.0
 * @since 1.0
*/
@Entity
public class Patient {

	@Column(name="patient_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="patient_name")
	private String name;
	
	@Column(name="date_of_birth")
	private Date dob;
	
	@Column(name="primary_phoneNumber")
	private BigInteger primary_phoneNumber;
	
	@Column(name="secondary_phoneNumber")
	private BigInteger secondary_phoneNumber;
	
	@OneToMany(targetEntity=Address.class, cascade= {CascadeType.ALL, CascadeType.REMOVE}, fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="patient_id", name="patientid")
	private List<Address> address;
	
	/** Gets the patient's Id.
	 * @return A integer representing the patient’s Id.
	*/
	public int getId() {
		return id;
	}
	
	/** Sets the patient’s Id.
	 * @param Id A integer containing the patient's Id.
	*/
	public void setId(int id) {
		this.id = id;
	}
	
	/** Gets the patient's name.
	 * @return A String representing the patient’s name.
	*/
	public String getName() {
		return name;
	}
	
	/** Sets the patient’s name.
	 * @param address A String containing the patient's name.
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/** Gets the patient's date of birth.
	 * @return A Date representing the patient’s date of birth.
	*/
	public Date getDob() {
		return dob;
	}
	
	/** Sets the patient’s date of birth.
	 * @param dob A Date containing the patient's date of birth.
	*/
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/** Gets the patient's Primary_phoneNumber.
	 * @return A BigInteger representing the patient’s Primary_phoneNumber.
	*/
	public BigInteger getPrimary_phoneNumber() {
		return primary_phoneNumber;
	}

	/** Sets the patient’s primary_phoneNumber.
	 * @param primary_phoneNumber A String containing the patient's primary_phoneNumber.
	*/
	public void setPrimary_phoneNumber(BigInteger primary_phoneNumber) {
		this.primary_phoneNumber = primary_phoneNumber;
	}

	/** Gets the patient's Secondary_phoneNumber.
	 * @return A BigInteger representing the patient’s Secondary_phoneNumber.
	*/
	public BigInteger getSecondary_phoneNumber() {
		return secondary_phoneNumber;
	}

	/** Sets the patient’s secondary_phoneNumber.
	 * @param primary_phoneNumber A String containing the patient's secondary_phoneNumber.
	*/
	public void setSecondary_phoneNumber(BigInteger secondary_phoneNumber) {
		this.secondary_phoneNumber = secondary_phoneNumber;
	}

	/** Gets the patient's Address List.
	 * @return A List<Address> representing the patient’s Address.
	*/
	public List<Address> getAddress() {
		return address;
	}

	/** Sets the patient’s address.
	 * @param address A List<Address> containing the patient's address.
	*/
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
}