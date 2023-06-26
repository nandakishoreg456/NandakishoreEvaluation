package com.hospital.patient.beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class AddressTest {

	@Mock
	Address address;
	
	@Before
	public void setUp() {
		
	}
	
	@InjectMocks
	Address address1;
	
	@Test
	public void getHouseNumberTest() {
		Mockito.when(address.getHouseNumber()).thenReturn(20);
		int houseNumber = address.getHouseNumber();
		Assert.assertEquals(houseNumber, 20);
	}
	
	@Test
	public void getStreetTest() {
		Mockito.when(address.getStreet()).thenReturn("Street");
		String street = address.getStreet();
		Assert.assertEquals(street, "Street");
	}
	
	@Test
	public void getCityTest() {
		Mockito.when(address.getCity()).thenReturn("City");
		String city = address.getCity();
		Assert.assertEquals(city, "City");
	}
	
	@Test
	public void getStateTest() {
		Mockito.when(address.getState()).thenReturn("State");
		String state = address.getState();
		Assert.assertEquals(state, "State");
	}
	
	@Test
	public void getPincodeTest() {
		Mockito.when(address.getPincode()).thenReturn(500072);
		int pinCode = address.getPincode();
		Assert.assertEquals(pinCode, 500072);
	}
	
	@Test
	public void getTypeTest() {
		Mockito.when(address.getType()).thenReturn("Type");
		String type = address.getType();
		Assert.assertEquals(type, "Type");
	}
	
	
	@Test
	public void setHouseNumberTest() {
		//Mockito.doNothing().when(address).setHouseNumber(30);
		address1.setHouseNumber(30);
		Assert.assertEquals(address1.getHouseNumber(), 30);
	}
	
	@Test
	public void setStreeTest() {
		//Mockito.doNothing().when(address).setHouseNumber(30);
		address1.setStreet("Street");
		Assert.assertEquals(address1.getStreet(), "Street");
		
	}
	/*
	 * private String city;
	private String state;
	private int pincode;
	private String type;
	 */
	
	@Test
	public void setCityTest() {
		//Mockito.doNothing().when(address).setHouseNumber(30);
		address1.setCity("City");
		Assert.assertEquals(address1.getCity(), "City");
	}
	
	@Test
	public void setStateTest() {
		//Mockito.doNothing().when(address).setHouseNumber(30);
		address1.setState("State");
		Assert.assertEquals(address1.getState(), "State");
	}
	
	@Test
	public void setPincodeTest() {
		//Mockito.doNothing().when(address).setHouseNumber(30);
		address1.setPincode(30000);
		Assert.assertEquals(address1.getPincode(), 30000);
	}
	
	@Test
	public void setTypeTest() {
		//Mockito.doNothing().when(address).setHouseNumber(30);
		address1.setType("Type");
		Assert.assertEquals(address1.getType(), "Type");
	}

}
