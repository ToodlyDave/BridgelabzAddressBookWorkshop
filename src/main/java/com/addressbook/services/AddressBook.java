package com.addressbook.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.addressbook.entities.Contact;

public class AddressBook {

	// Hashset of contact class type. This is the addressbook
	public HashSet<Contact> addressBook = new HashSet<Contact>();
	
	// Hashmap of contacts and their states
	public HashMap<String, ArrayList<Contact>> stateContactMap = new HashMap<>();
	
	// Hashmap of contacts and their cities
	public HashMap<String, ArrayList<Contact>> cityContactMap = new HashMap<>();

	Scanner scan = new Scanner(System.in);

	// Read all the value of contact and create an object and return said object
	public Contact inputDetails() {

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

	// Display all the contacts in the address book arraylist
	public void displayContacts() {

		for (Contact contact : addressBook) {
			System.out.println(contact);
		}
	}

	// Method to add objects of Contact class to address book arraylist
	public void addContact() {

		System.out.print(" Please enter how many contacts you want to add: ");
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {

			Contact newContact = inputDetails();

			// If the add method returns false it means that there is a contacts of this
			// name already.
			// Since we used a hash set it'll only allow unique values to be inserted.
			if (!addressBook.add(newContact)) {
				System.out.println(" ERROR: A contact of this name already exists!\n");
				i--;
				continue;
			}
			
			if (!cityContactMap.containsKey(newContact.getCity()))
				cityContactMap.put(newContact.getCity(), new ArrayList<Contact>());
			cityContactMap.get(newContact.getCity()).add(newContact);

			if (!stateContactMap.containsKey(newContact.getState()))
				stateContactMap.put(newContact.getState(), new ArrayList<Contact>());
			stateContactMap.get(newContact.getState()).add(newContact);

			System.out.println();
		}

	}

	// Method to find a contact via name in the address book arraylist
	public Contact findContact() {

		System.out.print(" Please enter the first name: ");
		String firstName = scan.next();

		for (Contact contact : addressBook) {
			if (firstName.compareToIgnoreCase(contact.getFirstName()) == 0) {
				return contact;
			}
		}

		return null;

	}

	/*
	 * Method to delete contact. We search for the contact by name and then delete
	 * the resp. contact from the arraylist
	 */
	public void deleteContact() {

		Contact contact = findContact();

		if (contact == null) {
			System.out.println(" ERROR: No such contact");
			return;
		}

		addressBook.remove(contact);
		System.out.println(" Contact deleted!");

	}

	// Method to edit contacts. We read all the parameters for that contact and then
	// set into the array list
	public void editContact() {

		Contact contact = findContact();

		if (contact == null) {
			System.out.println(" ERROR: No such contact");
			return;
		}

		System.out.println(" Contact found! Please enter new details of the contact");
		addressBook.remove(contact);
		addressBook.add(inputDetails());
//		addressBook.set(index, inputDetails());

	}

}
