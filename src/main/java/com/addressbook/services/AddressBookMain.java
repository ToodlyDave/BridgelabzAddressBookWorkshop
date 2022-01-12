package com.addressbook.services;

import java.util.Scanner;

import com.addressbook.utilities.FileHandler;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println(" Welcome to the Address Book Program");

		Scanner scan = new Scanner(System.in);

		AddressBookHandler adBook = new AddressBookHandler();

		// The choice is stored in this variable
		String ch;

		// This will display the menu in a loop until the user stops it
		while (true) {
			System.out.println(" ---- MENU ----");
			System.out.println(" 1. Add contacts\n 2. Display contacts\n 3. Edit contacts\n 4. Delete contact\n"
					+ " 5. Add address book\n 6. Search for contact\n 7. View contacts by city or state\n"
					+ " 8. Count contacts by city or state\n 9. Sort contacts\n" + " 10. File IO\n 11. Exit");
			System.out.print("\n Please enter your choice: ");

			ch = scan.next();

			switch (ch) {

			// Add new contact(s) to the address book arraylist
			case "1":
				adBook.addContact();
				break;

			// Display all the contacts stored in the address book arraylist
			case "2":
				adBook.displayContacts();
				break;

			// Edit a contact in the address book
			case "3":
				adBook.editContact();
				break;

			// Delete a contact from the address book
			case "4":
				adBook.deleteContact();
				break;

			// Add a new address book to the list
			case "5":
				adBook.addAddressBook();
				break;

			// Search for a contact by city or state
			case "6":
				System.out.print(" Please enter the name of the contact you want to find: ");
				String name = scan.next();

				System.out.print(" Please enter to search by city or state(city/state): ");
				String choice = scan.next();

				System.out.print(" Please enter the location: ");
				String location = scan.next();

				adBook.searchCityState(name, location, choice);
				break;

			// View all contacts by city or state
			case "7":
				System.out.print(" Please enter to view by city or state(city/state): ");
				String viewChoice = scan.next();

				System.out.print(" Please enter the location: ");
				String viewLocation = scan.next();

				adBook.viewCityState(viewLocation, viewChoice);
				break;

			// Count all contacts in a particular city or state
			case "8":
				System.out.print(" Please enter to count by city or state(city/state): ");
				String countChoice = scan.next();

				System.out.print(" Please enter the location: ");
				String countLocation = scan.next();

				adBook.countContact(countLocation, countChoice);
				break;

			// Sort the contacts in an address book by name, city, state or zip
			case "9":
				System.out.print(" Please enter which address book to sort: ");
				String sortAdBook = scan.next();

				System.out.print(" Please enter to sort by name, city, state or zip: ");
				String sortChoice = scan.next();

				adBook.sortContacts(sortAdBook, sortChoice);
				break;

			// Handles file io operations
			case "10":
				FileHandler file = new FileHandler();

				System.out.print(" Please enter to perform read or write: ");
				String fileOption = scan.next();
				
				System.out.print(" Please enter which format to operate in (txt/csv/json): ");
				String fileFormatOption = scan.next();
				
				if (fileFormatOption.equalsIgnoreCase("txt")) {
					if (fileOption.equalsIgnoreCase("read") || fileOption.equalsIgnoreCase("r"))
						file.readFromFile();
					else {
						System.out.print(" Please enter which address book to write: ");
						String adBookFile = scan.next();

						file.writeIntoFile(adBookFile, adBook);
					}
				}
				else if (fileFormatOption.equalsIgnoreCase("csv")) {
					if (fileOption.equalsIgnoreCase("read") || fileOption.equalsIgnoreCase("r"))
						file.readCSVFile();
					else {
						System.out.print(" Please enter which address book to write: ");
						String adBookFile = scan.next();

						file.writeCSVFile(adBookFile, adBook);
					}
				}
				else if (fileFormatOption.equalsIgnoreCase("json")) {
					if (fileOption.equalsIgnoreCase("read") || fileOption.equalsIgnoreCase("r"))
						file.readJSONFile();
					else {
						System.out.print(" Please enter which address book to write: ");
						String adBookFile = scan.next();
						
						file.writeJSONFile(adBookFile, adBook);
					}
				}

				
				break;

			// Exit the program
			case "11":
				System.out.println(" Good bye!");
				return;

			// This is in case the user enters an invalid choice
			default:
				System.out.println(" Please enter a valid choice: ");
			}
		}
	}
}
