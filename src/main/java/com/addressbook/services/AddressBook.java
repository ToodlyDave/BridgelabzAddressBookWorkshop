package com.addressbook.services;

import java.util.Scanner;

import com.addressbook.entities.Contact;

public class AddressBook {

	public void addContact() {
		
		Scanner scan = new Scanner(System.in);

		System.out.print(" Please enter the first name: ");
		String firstName = scan.next();
		
		System.out.print(" Please enter the last name: ");
		String lastName = scan.next();
		
		System.out.print(" Please enter the address: ");
		String address = scan.next();
		
		System.out.print(" Please enter the city: ");
		String city = scan.next();
		
		System.out.print(" Please enter the state: ");
		String state = scan.next();
		
		System.out.print(" Please enter the zip: ");
		int zip = scan.nextInt();
		
		System.out.print(" Please enter the phone number: ");
		long phone = scan.nextLong();
		
		System.out.print(" Please enter the email: ");
		String email = scan.next();
		
		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
		
		
	}
}