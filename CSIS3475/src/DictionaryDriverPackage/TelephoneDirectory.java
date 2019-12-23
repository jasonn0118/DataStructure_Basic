package DictionaryDriverPackage;

import java.util.Iterator;
import java.util.Scanner;

import DictionaryPackage.*;

/**
 * A class of telephone directories.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class TelephoneDirectory {
	// Sorted dictionary with distinct search keys
	private DictionaryInterface<Name, String> phoneBook;

	public TelephoneDirectory() {
//		phoneBook = new SortedArrayDictionary<>();
//		phoneBook = new SortedLinkedDictionary<>();
		phoneBook = new CompletedSortedVectorDictionary<>();
	}

	// Segment 20.10
	/**
	 * Reads a text file of names and telephone numbers.
	 * 
	 * @param data A text scanner for the text file of data.
	 */
	public void readFile(Scanner data) {

		// get each token from a line in the file

		while (data.hasNext()) {
			String firstName = data.next();
			String lastName = data.next();
			String phoneNumber = data.next();

			Name fullName = new Name(firstName, lastName);
			phoneBook.add(fullName, phoneNumber);
		}

	}

	// Segment 20.11
	/** 
	 * Gets the phone number of a given person. 
	 * 
	 */
	public String getPhoneNumber(Name personName) {
		return phoneBook.getValue(personName);
	}
	
	/**
	 * Gets the phone number for a first and last name
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public String getPhoneNumber(String firstName, String lastName) {
		Name fullName = new Name(firstName, lastName);
		return phoneBook.getValue(fullName);
	}

	/**
	 * Using iterators, displays telephone directory
	 */
	public void display() {
		Iterator<Name> nameIterator = phoneBook.getKeyIterator();
		Iterator<String> numberIterator = phoneBook.getValueIterator();
		System.out.println("Telephone Directory has " + phoneBook.size() + " entries");
		for (int i = 0; i < phoneBook.size(); i++) {
			System.out.println("Name " + nameIterator.next() + ", Number " + numberIterator.next());

		}
	}

}
