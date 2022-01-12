package com.addressbook.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.addressbook.services.AddressBook;
import com.addressbook.services.AddressBookHandler;

public class FileHandler {

	public void readFromFile() {
		Path path = Paths.get("src/main/resources/AddressBookText.txt");

		try {
			System.out.println(Files.readAllLines(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeIntoFile(String adBookName, AddressBookHandler adBookHandler) {

		AddressBook adBook = adBookHandler.findAddressBook(adBookName);
		Path path = Paths.get("src/main/resources/AddressBookText.txt");

		try {
			Files.write(path, adBook.addressBook.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
