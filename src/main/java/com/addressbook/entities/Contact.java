package com.addressbook.entities;

public class Contact {

	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	long phone;
	String email;

	// Parameterized class for creating object
	public Contact(String firstName, String lastName, String address, String city, String state, int zip, long phone,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}

}
