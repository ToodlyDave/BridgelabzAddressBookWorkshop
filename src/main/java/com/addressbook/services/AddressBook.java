package com.addressbook.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.addressbook.entities.Contact;

public class AddressBook {

	public static ArrayList<Contact> addressBook = new ArrayList<Contact>();

	public Contact inputDetails() {
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

		// Creating a new object of the contact class with the parameter values filled
		// by user
		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);

		return contact;

	}

	public void displayContacts() {

		for (Contact contact : addressBook) {
			System.out.println(contact);
		}
	}

	// Method to create an object of Contact class with user input
	public void addContact() {

		addressBook.add(inputDetails());

	}

	// Method to find a contact via name in the address book arraylist
	public int findContact() {

		Scanner scan = new Scanner(System.in);

		System.out.print(" Please enter the first name: ");
		String firstName = scan.next();

		for (Contact contact : addressBook) {
			if (firstName.compareToIgnoreCase(contact.getFirstName()) == 0) {
				return addressBook.indexOf(contact);
			}
		}

		return -1;

	}

	public void deleteContact() {

		int index = findContact();
		
		if (index == -1) {
			System.out.println(" ERROR: No such contact");
			return;
		}
		
		addressBook.remove(index);
		System.out.println(" Contact deleted!");

	}

	public void editContact() {

		int index = findContact();

		if (index == -1) {
			System.out.println(" ERROR: No such contact");
			return;
		}

		System.out.println(" Contact found! Please enter new details of the contact");
		addressBook.set(index, inputDetails());

	}

}
