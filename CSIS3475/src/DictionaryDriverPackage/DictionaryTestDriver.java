package DictionaryDriverPackage;

import java.util.Iterator;

import DictionaryPackage.*;

// Comment this out when testing Dictionaries only. Uncomment this when
// testing BinarySearchTreeDictionary
//import SearchTreesPackage.*;

/**
 * A driver that demonstrates the class SortedLinkedDictionary.
 * 
 * @author Frank M. Carrano
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * modified to add test cases, and to accommodate various dictionary classes
 */
public class DictionaryTestDriver {
	public static void main(String[] args) {

		String dirk = "Dirk";
		String abel = "Abel";
		String miguel = "Miguel";
		String tabbie = "Tabatha";
		String tom = "Tom";
		String sam = "Sam";
		String reiss = "Reiss";
		String bette = "Bette";
		String carole = "Carole";
		String derek = "Derek";
		String nancy = "Nancy";

		// Create a dictionary
//		DictionaryInterface<String, String> nameList = new CompletedListDictionary<>();
//		DictionaryInterface<String, String> nameList = new CompletedSortedArrayDictionary<>();
//		DictionaryInterface<String, String> nameList = new CompletedSortedListDictionary<>();
//		DictionaryInterface<String, String> nameList = new CompletedSortedVectorDictionary<>();
//		DictionaryInterface<String, String> nameList = new CompletedSortedLinkedDictionary<>();
//		DictionaryInterface<String, String> nameList = new CompletedLinkedDictionary<>();
//		DictionaryInterface<String, String> nameList = new CompletedArrayDictionary<>();
//		DictionaryInterface<String, String> nameList = new CompletedVectorDictionary<>();
//		DictionaryInterface<String, String> nameList = new CompletedBinarySearchTreeDictionary<>();
		
//		DictionaryInterface<String, String> nameList = new ListDictionary<>();
//		DictionaryInterface<String, String> nameList = new SortedArrayDictionary<>();
//		DictionaryInterface<String, String> nameList = new SortedListDictionary<>();
//		DictionaryInterface<String, String> nameList = new SortedVectorDictionary<>();
//		DictionaryInterface<String, String> nameList = new SortedLinkedDictionary<>();
//		DictionaryInterface<String, String> nameList = new LinkedDictionary<>();
//		DictionaryInterface<String, String> nameList = new ArrayDictionary<>();
		DictionaryInterface<String, String> nameList = new VectorDictionary<>();
//		DictionaryInterface<String, String> nameList = new BinarySearchTreeDictionary<>();

		System.out.println("Create a dictionary");
		System.out.println("Initial dictionary should be empty; isEmpty() returns " + nameList.isEmpty());

		// Test add
		System.out.println("Testing add():");
		nameList.add(dirk, "555-1234");
		nameList.add(abel, "555-5678");
		nameList.add(miguel, "555-9012");
		nameList.add(tabbie, "555-3456");
		nameList.add(tom, "555-5555");
		nameList.add(sam, "555-7890");
		nameList.add(reiss, "555-2345");
		nameList.add(bette, "555-7891");
		nameList.add(carole, "555-7892");
		nameList.add(derek, "555-7893");
		nameList.add(nancy, "555-7894");

		System.out.println("Size " + nameList.size() + " (should be 11) items in dictionary, as follows:");

		display(nameList);

		// Test getValue
		System.out.println("Testing getValue():");
		System.out.println("Abel:   " + nameList.getValue(abel) + " should be 555-5678");
		System.out.println("Sam:    " + nameList.getValue(sam) + " should be 555-7890");
		System.out.println("Tom:    " + nameList.getValue(tom) + " should be 555-5555");
		System.out.println("Reiss:  " + nameList.getValue(reiss) + " should be 555-2345");
		System.out.println("Miguel: " + nameList.getValue(miguel) + " should be 555-9012");

		// Test contains
		System.out.println("Testing contains():");

		if (nameList.contains(sam))
			System.out.println("Sam is in dictionary - OK");
		else
			System.out.println("Error in contains()");

		if (nameList.contains(abel))
			System.out.println("Abel is in dictionary - OK");
		else
			System.out.println("Error in contains()");

		if (nameList.contains(miguel))
			System.out.println("Miguel is in dictionary - OK");
		else
			System.out.println("Error in contains()");

		if (nameList.contains(tom))
			System.out.println("Tom is in dictionary - OK");
		else
			System.out.println("Error in contains()");

		if (!nameList.contains("Bo"))
			System.out.println("Bo is not in dictionary - OK");
		else
			System.out.println("Error in contains()");

		// Remove first item
		System.out.println(
				"Removing first item Abel - Abel's number is " + nameList.remove(abel) + " should be 555-5678");

		// Test replacing value
		System.out.println("Replacing phone number of Reiss and Miguel:");
		String oldNumber = nameList.add(reiss, "555-5432");
		System.out.println("Reiss's old number " + oldNumber + " is replaced by 555-5432");
		oldNumber = nameList.add(miguel, "555-2109");
		System.out.println("Miguel's old number " + oldNumber + " is replaced by 555-2109");

		System.out.println("Size " + nameList.size() + " (should be 10) items in dictionary, as follows:");
		display(nameList);

		// Remove interior and last items
		System.out.println("Removing interior item Reiss:");
		nameList.remove(reiss);
		System.out.println("Size " + nameList.size() + " (should be 9) items in dictionary, as follows:");
		display(nameList);
		System.out.println("Removing Tom:");
		nameList.remove(tom);
		System.out.println("Size " + nameList.size() + " (should be 8) items in dictionary, as follows:");
		display(nameList);

		// Remove Bo (not in dictionary)
		System.out.println("Removing Bo (not in dictionary):");
		String result = nameList.remove("Bo");
		if (result == null)
			System.out.println("Bo was not found in the dictionary.");
		else
			System.out.println("Error in remove().");

		// Remove Bo (not in dictionary)
		System.out.println("Removing Aaron (not in dictionary):");
		result = nameList.remove("Aaron");
		if (result == null)
			System.out.println("Aaron was not found in the dictionary.");
		else
			System.out.println("Error in remove().");

		System.out.println("Removing Zeno (not in dictionary):");
		result = nameList.remove("Zeno");
		if (result == null)
			System.out.println("Zeno was not found in the dictionary.");
		else
			System.out.println("Error in remove().");

		System.out.println("Size " +  + nameList.size() + " (should be 8) items in dictionary, as follows:");
		display(nameList);

		// Test clear
		System.out.println("Testing clear():");
		nameList.clear();

		System.out.println("Dictionary should be empty; isEmpty() returns " + nameList.isEmpty());
	}

	public static void display(DictionaryInterface<String, String> dictionary) {
		Iterator<String> keyIterator = dictionary.getKeyIterator();
		Iterator<String> valueIterator = dictionary.getValueIterator();

		while (keyIterator.hasNext() && valueIterator.hasNext())
			System.out.println(keyIterator.next() + " : " + valueIterator.next());
		System.out.println();
	} 
} 
/*
 * Output: note that this is for sorted, unsorted will be the order in which the entries are added
 * 
 Create a dictionary
Initial dictionary should be empty; isEmpty() returns true
Testing add():
Size 11 (should be 11) items in dictionary, as follows:
Abel : 555-5678
Bette : 555-7891
Carole : 555-7892
Derek : 555-7893
Dirk : 555-1234
Miguel : 555-9012
Nancy : 555-7894
Reiss : 555-2345
Sam : 555-7890
Tabatha : 555-3456
Tom : 555-5555

Testing getValue():
Abel:   555-5678 should be 555-5678
Sam:    555-7890 should be 555-7890
Tom:    555-5555 should be 555-5555
Reiss:  555-2345 should be 555-2345
Miguel: 555-9012 should be 555-9012
Testing contains():
Sam is in dictionary - OK
Abel is in dictionary - OK
Miguel is in dictionary - OK
Tom is in dictionary - OK
Bo is not in dictionary - OK
Removing first item Abel - Abel's number is 555-5678 should be 555-5678
Replacing phone number of Reiss and Miguel:
Reiss's old number 555-2345 is replaced by 555-5432
Miguel's old number 555-9012 is replaced by 555-2109
Size 10 (should be 10) items in dictionary, as follows:
Bette : 555-7891
Carole : 555-7892
Derek : 555-7893
Dirk : 555-1234
Miguel : 555-2109
Nancy : 555-7894
Reiss : 555-5432
Sam : 555-7890
Tabatha : 555-3456
Tom : 555-5555

Removing interior item Reiss:
Size 9 (should be 9) items in dictionary, as follows:
Bette : 555-7891
Carole : 555-7892
Derek : 555-7893
Dirk : 555-1234
Miguel : 555-2109
Nancy : 555-7894
Sam : 555-7890
Tabatha : 555-3456
Tom : 555-5555

Removing Tom:
Size 8 (should be 8) items in dictionary, as follows:
Bette : 555-7891
Carole : 555-7892
Derek : 555-7893
Dirk : 555-1234
Miguel : 555-2109
Nancy : 555-7894
Sam : 555-7890
Tabatha : 555-3456

Removing Bo (not in dictionary):
Bo was not found in the dictionary.
Removing Aaron (not in dictionary):
Aaron was not found in the dictionary.
Removing Zeno (not in dictionary):
Zeno was not found in the dictionary.
Size 8 (should be 8) items in dictionary, as follows:
Bette : 555-7891
Carole : 555-7892
Derek : 555-7893
Dirk : 555-1234
Miguel : 555-2109
Nancy : 555-7894
Sam : 555-7890
Tabatha : 555-3456

Testing clear():
Dictionary should be empty; isEmpty() returns true

  */
