package com.addressbook.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookHandler {

	// Map of the names and address books
	HashMap<String, AddressBook> addressBookRegistry = new HashMap<>();

	Scanner scan = new Scanner(System.in);

	// Method to find address book object in the hash map
	public AddressBook findAddressBook(String adBookName) {

		for (Map.Entry<String, AddressBook> itr : addressBookRegistry.entrySet()) {
			if (itr.getKey().equalsIgnoreCase(adBookName)) {
				return itr.getValue();
			}
		}

		return null;

	}

	// Method to create a new address book in the hash map. Ensures that the names
	// are unique
	public void addAddressBook() {

		System.out.println(" Please enter the name of the address book: ");
		String name = scan.next();

		if (addressBookRegistry.get(name) != null) {

			System.out.println(" ERROR: An address book of this name already exists");
			return;
		}

		addressBookRegistry.put(name, new AddressBook());

	}

	// Method to call the add contact method in the address book class
	public void addContact() {

		System.out.println(" Please enter the name of the address book: ");
		String name = scan.next();

		AddressBook adBook = findAddressBook(name);
		
		if (adBook == null) {
			System.out.println(" ERROR: An address book of this name does not exist");
			return;
		}

		adBook.addContact();

	}

	// Method to call the edit contact method in the address book class
	public void editContact() {

		System.out.println(" Please enter the name of the address book: ");
		String name = scan.next();

		AddressBook adBook = findAddressBook(name);
		
		if (adBook == null) {
			System.out.println(" ERROR: An address book of this name does not exist");
			return;
		}

		adBook.editContact();

	}

	// Method to call the delete contact method in the address book class
	public void deleteContact() {

		System.out.println(" Please enter the name of the address book: ");
		String name = scan.next();

		AddressBook adBook = findAddressBook(name);
		
		if (adBook == null) {
			System.out.println(" ERROR: An address book of this name does not exist");
			return;
		}

		adBook.deleteContact();

	}

	// Method to display contacts in address book
	public void displayContacts() {

		System.out.println(" Please enter the name of the address book: ");
		String name = scan.next();

		AddressBook adBook = findAddressBook(name);
		
		if (adBook == null) {
			System.out.println(" ERROR: An address book of this name does not exist");
			return;
		}

		adBook.displayContacts();

	}

}
