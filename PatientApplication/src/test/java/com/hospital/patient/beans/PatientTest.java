package com.hospital.patient.beans;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PatientTest {
	
	@Mock
	Patient patient;
	
	List<Address> addressList = null;
	Address address = null;
	
	@InjectMocks
	Patient patient1;
	
	private SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
	
	@Before
	public void setUp() {
		
		addressList = new ArrayList<>();
		address = new Address();
		address.setCity("City");
		address.setHouseNumber(101);
		address.setState("State");
		addressList.add(address);
	}
	
	@Test
	public void getIdTest() {
		Mockito.when(patient.getId()).thenReturn(101);
		int id = patient.getId();
		Assert.assertEquals(id, 101);
	}
	
	
	@Test
	public void getNameTest() {
		Mockito.when(patient.getName()).thenReturn("Ganesh");
		String name = patient.getName();
		Assert.assertEquals(name, "Ganesh");
	}

	@Test
	public void getDobTest() throws ParseException {
		Date fixedDateTime = DATE_FORMATTER.parse("01/07/2016 16:45:00:000");
		Mockito.when(patient.getDob()).thenReturn(fixedDateTime);
		Date dob = patient.getDob();
		Assert.assertTrue(dob!=null);
	}
	
	@Test
	public void getPrimaryPhoneNumberTest() {
		Mockito.when(patient.getPrimary_phoneNumber()).thenReturn(new BigInteger("99"));
		BigInteger primary_phoneNumber = patient.getPrimary_phoneNumber();
		Assert.assertEquals(primary_phoneNumber, new BigInteger("99"));
	}
	
	@Test
	public void getSecondaryPhoneNumberTest() {
		Mockito.when(patient.getSecondary_phoneNumber()).thenReturn(new BigInteger("88"));
		BigInteger secondary_phoneNumber = patient.getSecondary_phoneNumber();
		Assert.assertEquals(secondary_phoneNumber, new BigInteger("88"));
	}
	
	@Test
	public void getAddressTest() {
		Mockito.when(patient.getAddress()).thenReturn(addressList);
		List<Address> addressListResponse = patient.getAddress();
		Assert.assertEquals(addressListResponse.get(0).getCity(), "City");
	}
	
	//setters
	@Test
	public void setIdTest() {
		//Mockito.doNothing().when(address).setHouseNumber(30);
		patient1.setId(101);
		Assert.assertEquals(patient1.getId(), 101);
	}
	
	@Test
	public void setNameTest() {
		patient1.setName("Ganesh");
		Assert.assertEquals(patient1.getName(), "Ganesh");
	}
	
	@Test
	public void setDobTest() throws ParseException {
		Date fixedDateTime = DATE_FORMATTER.parse("01/07/2016 16:45:00:000");
		patient1.setDob(fixedDateTime);
		Assert.assertTrue(patient1.getDob()!=null);
	}
	
	@Test
	public void setPrimaryPhoneNumberTest() {
		patient1.setPrimary_phoneNumber(new BigInteger("99"));
		Assert.assertEquals(patient1.getPrimary_phoneNumber(), new BigInteger("99"));
	}
	
	@Test
	public void setSecondaryPhoneNumberTest() {
		patient1.setSecondary_phoneNumber(new BigInteger("88"));
		Assert.assertEquals(patient1.getSecondary_phoneNumber(), new BigInteger("88"));
	}
	
	@Test
	public void setAddressTest() {
		patient1.setAddress(addressList);
		Assert.assertEquals(patient1.getAddress().get(0).getCity(), "City");
	}
}
