package ListDriverPackage;
import ListPackage.*;

/**
 * demonstrates revised AList and LList classes
 * 
 * @author mhrybyk
 *
 */

public class ListDemo {

	public static void main(String[] args) {

		// uncomment the implementations to test
		
		// create the first list of integers
		
//		ListInterface<String> listOfIntegers = new CompletedLList<>();
//		ListInterface<String> listOfIntegers = new CompletedLListWithTail<>();
//		ListInterface<String> listOfIntegers = new CompletedAList<>();
//		ListInterface<String> listOfIntegers = new CompletedListUsingLibraryLinkedList<>();
		
		ListInterface<String> listOfIntegers = new LList<>();
//		ListInterface<String> listOfIntegers = new LListWithTail<>();
//		ListInterface<String> listOfIntegers = new AList<>();
//		ListInterface<String> listOfIntegers = new ListUsingLibraryLinkedList<>();
		
		// create a second list in which to save the original list
		
//		ListInterface<String> anotherListOfIntegers = new CompletedAList<>();
//		ListInterface<String> anotherListOfIntegers = new CompletedLList<>();
//		ListInterface<String> anotherListOfIntegers = new CompletedLListWithTail<>();
//		ListInterface<String> anotherListOfIntegers = new CompletedListUsingLibraryLinkedList<>();
		
//		ListInterface<String> anotherListOfIntegers = new AList<>();
		ListInterface<String> anotherListOfIntegers = new LList<>();
//		ListInterface<String> anotherListOfIntegers = new LListWithTail<>();
//		ListInterface<String> anotherListOfIntegers = new ListUsingLibraryLinkedList<>();

		// first generate a list of 20 random integers starting at 10, and display them
		
		DemoUtilities.generateListOfNumbers(listOfIntegers, 10, 20);
		DemoUtilities.display(listOfIntegers, "Original List of random Integers");
		System.out.println();
		
		// make a copy
		
		DemoUtilities.copyListOfNumbers(listOfIntegers, anotherListOfIntegers);
		DemoUtilities.display(anotherListOfIntegers, "Copy of List of random Integers");
		System.out.println();
		
		// adds to last position, but it needs to be the next available
		listOfIntegers.add(listOfIntegers.size(), "21"); 
		
		// adds to the front
		listOfIntegers.add(0, "21"); 
		
		// then to position 3 but including the new item at position 0
		listOfIntegers.add(3, "23");  
		
		// this will not be allowed to add if the array is smaller than 25
		listOfIntegers.add(25, "30"); 

		DemoUtilities.display(listOfIntegers, 
				"Integers with 21 added to front and back, 23 added to position 3, 30 added to position 25 (illegal)");
		System.out.println();

		listOfIntegers.replace(3, "24");
		DemoUtilities.display(listOfIntegers,
				"Integers position 3 changed to 24");
		System.out.println();
		
		listOfIntegers.remove(5);
		listOfIntegers.remove(0); // first removed
		listOfIntegers.remove(listOfIntegers.size() - 1); // removes the end

		DemoUtilities.display(listOfIntegers,
				"Integers position 5 and front/back removed");
		System.out.println();

		if(listOfIntegers.removeEntry("24") == false)
			System.out.println("Can't remove 24");

		// swap the first and second items in the list
		String temp0 = listOfIntegers.getEntry(0);
		String temp1 = listOfIntegers.getEntry(1);
		
		listOfIntegers.replace(0, temp1);
		listOfIntegers.replace(1, temp0);

		DemoUtilities.display(listOfIntegers, 
				"First integer entry with value of 24 removed and positions 0 and 1 swapped");
		System.out.println();
		
		try {
			System.out.println("Attempting to replace a value at location 50, should cause an exception");
			listOfIntegers.replace(50, "50");
		}
		catch (Exception e) {
			System.out.println("Exception caught trying to replace value at location 50");
		}
		
		try {
			System.out.println("Attempting to remove a value at location 50, should cause an exception");
			listOfIntegers.remove(50);
		}
		catch (Exception e) {
			System.out.println("Exception caught trying to remove value at location 50");
		}
		
		try {
			System.out.println("Attempting to get a value at location 50, should cause an exception");
			listOfIntegers.getEntry(50);
		}
		catch (Exception e) {
			System.out.println("Exception caught trying to get a value at location 50");
		}


	}

}

/*
Output (will be different each run due to random number generation):

Display: Original List of random Integers, size = 20
18, 28, 16, 11, 24, 11, 27, 12, 22, 11, 10, 27, 26, 22, 22, 15, 26, 17, 19, 22, 

Display: Copy of List of random Integers, size = 20
18, 28, 16, 11, 24, 11, 27, 12, 22, 11, 10, 27, 26, 22, 22, 15, 26, 17, 19, 22, 

Display: Integers with 21 added to front and back, 23 added to position 3, 30 added to position 25 (illegal), size = 23
21, 18, 28, 23, 16, 11, 24, 11, 27, 12, 22, 11, 10, 27, 26, 22, 22, 15, 26, 17, 19, 22, 21, 

Display: Integers position 3 changed to 24, size = 23
21, 18, 28, 24, 16, 11, 24, 11, 27, 12, 22, 11, 10, 27, 26, 22, 22, 15, 26, 17, 19, 22, 21, 

Display: Integers position 5 and front/back removed, size = 20
18, 28, 24, 16, 24, 11, 27, 12, 22, 11, 10, 27, 26, 22, 22, 15, 26, 17, 19, 22, 

Display: First integer entry with value of 24 removed and positions 0 and 1 swapped, size = 19
28, 18, 16, 24, 11, 27, 12, 22, 11, 10, 27, 26, 22, 22, 15, 26, 17, 19, 22, 

Attempting to replace a value at location 50, should cause an exception
Exception caught trying to replace value at location 50
Attempting to remove a value at location 50, should cause an exception
Exception caught trying to remove value at location 50
Attempting to get a value at location 50, should cause an exception
Exception caught trying to get a value at location 50


*/
