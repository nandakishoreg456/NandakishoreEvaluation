package com.hospital.patient.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/** Represents a Patient Address.
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.2
 * @since 1.0
*/
@Entity
public class Address {

	@Column(name="house_number")
	@Id
	private int houseNumber;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="type")
	private String type;
	
	/** Gets the patient's houseNumber.
	 * @return A integer representing the patient’s address houseNumber.
	*/
	public int getHouseNumber() {
		return houseNumber;
	}
	/** Sets the patient’s address houseNumber.
	 * @param houseNumber A Integer containing the patient's address houseNumber.
	*/
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	/** Gets the patient's address street.
	 * @return A String representing the patient’s address street.
	*/
	public String getStreet() {
		return street;
	}
	/** Sets the patient’s address street.
	 * @param street A String containing the patient's address street.
	*/
	public void setStreet(String street) {
		this.street = street;
	}
	
	/** Gets the patient's address city.
	 * @return A String representing the patient’s address city.
	*/
	public String getCity() {
		return city;
	}
	/** Sets the patient’s address city.
	 * @param city A String containing the patient's address city.
	*/
	public void setCity(String city) {
		this.city = city;
	}
	
	/** Gets the patient's address state.
	 * @return A String representing the patient’s address state.
	*/
	public String getState() {
		return state;
	}
	/** Sets the patient’s address state.
	 * @param state A String containing the patient's address state.
	*/
	public void setState(String state) {
		this.state = state;
	}
	
	/** Gets the patient's address pincode.
	 * @return A Integer representing the patient’s address pincode.
	*/
	public int getPincode() {
		return pincode;
	}
	/** Sets the patient’s address pincode.
	 * @param pincode A integer containing the patient's address pincode.
	*/
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	/** Gets the patient's address type.
	 * @return A String representing the patient’s address type.
	*/
	public String getType() {
		return type;
	}
	/** Sets the patient’s address type.
	 * @param type A String containing the patient's address type.
	*/
	public void setType(String type) {
		this.type = type;
	}
	
}
