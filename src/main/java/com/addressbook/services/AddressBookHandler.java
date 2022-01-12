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

		System.out.print(" Please enter the name of the address book: ");
		String name = scan.next();

		if (addressBookRegistry.get(name) != null) {

			System.out.println(" ERROR: An address book of this name already exists");
			return;
		}

		addressBookRegistry.put(name, new AddressBook());

	}

	// Method to call the add contact method in the address book class
	public void addContact() {

		System.out.print(" Please enter the name of the address book: ");
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

		System.out.print(" Please enter the name of the address book: ");
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

		System.out.print(" Please enter the name of the address book: ");
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

		System.out.print(" Please enter the name of the address book: ");
		String name = scan.next();

		AddressBook adBook = findAddressBook(name);

		if (adBook == null) {
			System.out.println(" ERROR: An address book of this name does not exist");
			return;
		}

		adBook.displayContacts();

	}

	// Method to view all contacts in all address books in a particular city or
	// state
	public void viewCityState(String location, String choice) {

		addressBookRegistry.values().stream().forEach((adBook) -> {
			adBook.addressBook.stream().filter(contact -> {

				if (choice.equalsIgnoreCase("city"))
					return contact.getCity().equalsIgnoreCase(location);
				else
					return contact.getState().equalsIgnoreCase(location);
			}).forEach(contact -> System.out.println(contact));
		});

	}

	// Method to search all the addressbooks for a person in the corresponding city
	// or state
	public void searchCityState(String name, String location, String choice) {

		addressBookRegistry.values().stream().forEach((adBook) -> {
			adBook.addressBook.stream().filter(contact -> {

				if (choice.equalsIgnoreCase("city"))
					return contact.getCity().equalsIgnoreCase(location);
				else
					return contact.getState().equalsIgnoreCase(location);
			}).filter(contact -> contact.getFirstName().equalsIgnoreCase(name))
					.forEach(contact -> System.out.println(contact));
		});
	}

	// Method to count all contacts in a given state or city across all address
	// books
	public void countContact(String location, String choice) {

		int finalCount = 0;

		for (AddressBook adBook : addressBookRegistry.values()) {

			finalCount += adBook.addressBook.stream().filter(contact -> {
				if (choice.equalsIgnoreCase("city"))
					return contact.getCity().equalsIgnoreCase(location);
				else
					return contact.getState().equalsIgnoreCase(location);
			}).count();
		}

		System.out.println(" Total count: " + finalCount);
	}

	// Method to print out contacts sorted by name
	public void sortContacts(String adBookName) {

		AddressBook adBook = findAddressBook(adBookName);
		
		adBook.addressBook.stream()
				.sorted((contact1, contact2) -> contact1.getFirstName().compareToIgnoreCase(contact2.getFirstName()))
				.forEach(contact -> System.out.println(contact));

	}

}
