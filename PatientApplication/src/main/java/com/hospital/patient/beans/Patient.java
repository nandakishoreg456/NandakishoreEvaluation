package com.hospital.patient.beans;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {

	@Column(name="patient_id")
	@Id
	private int id;
	
	@Column(name="patient_name")
	private String name;
	
	@Column(name="date_of_birth")
	private Date dob;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_number")
	private BigInteger phoneNumber;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	

	
}
