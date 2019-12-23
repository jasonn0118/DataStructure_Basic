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
		ListInterface<String> listOfIntegers = new CompletedAList<>();
//		ListInterface<String> listOfIntegers = new CompletedListUsingLibrary<>();
		
//		ListInterface<String> listOfIntegers = new LList<>();
//		ListInterface<String> listOfIntegers = new LListWithTail<>();
//		ListInterface<String> listOfIntegers = new AList<>();
//		ListInterface<String> listOfIntegers = new ListUsingLibrary<>();
		
		// create a second list in which to save the original list
		
		ListInterface<String> anotherListOfIntegers = new CompletedAList<>();
//		ListInterface<String> anotherListOfIntegers = new AList<>();

		// first generate a list of 20 random integers starting at 10, and display them
		
		DemoUtilities.generateListOfNumbers(listOfIntegers, 10, 20);
		DemoUtilities.display(listOfIntegers, "Original List of random Integers");
		
		// make a copy
		
		DemoUtilities.copyListOfNumbers(listOfIntegers, anotherListOfIntegers);
		DemoUtilities.display(anotherListOfIntegers, "Copy of List of random Integers");
		
		// adds to last position, but it needs to be the next available
		listOfIntegers.add(listOfIntegers.size(), "21"); 
		
		// adds to the front
		listOfIntegers.add(0, "21"); 
		
		// then to position 3 but including the new item at position 0
		listOfIntegers.add(3, "23");  
		
		// this will not be allowed to add if the array is smaller than 25
		listOfIntegers.add(25, "30"); 

		DemoUtilities.display(listOfIntegers, 
				"Integers with 21 added to front and end, 23 added to position 3, 30 added to position 25 (illegal)");

		listOfIntegers.replace(3, "24");
		DemoUtilities.display(listOfIntegers,
				"Integers position 3 changed to 24");
		listOfIntegers.remove(5);
		listOfIntegers.remove(0); // first removed
		listOfIntegers.remove(listOfIntegers.size() - 1); // removes the end

		DemoUtilities.display(listOfIntegers,
				"Integers position 5 and front/back removed");

		if(listOfIntegers.removeEntry("24") == false)
			System.out.println("Can't remove 24");

		// swap the first and second items in the list
		String temp0 = listOfIntegers.getEntry(0);
		String temp1 = listOfIntegers.getEntry(1);
		
		listOfIntegers.replace(0, temp1);
		listOfIntegers.replace(1, temp0);

		DemoUtilities.display(listOfIntegers, 
				"First integer entry with value of 24 removed and positions 0 1 swapped");
		

	}

}

/*
Output (will be different each run due to random number generation):

Display: Original List of random Integers, size = 20
27, 18, 18, 16, 25, 29, 23, 24, 10, 21, 18, 20, 15, 10, 26, 10, 19, 11, 21, 27, 
Display: Copy of List of random Integers, size = 20
27, 18, 18, 16, 25, 29, 23, 24, 10, 21, 18, 20, 15, 10, 26, 10, 19, 11, 21, 27, 
Display: Integers with 21 added to front and end, 23 added to position 3, 30 added to position 25 (illegal), size = 23
21, 27, 18, 23, 18, 16, 25, 29, 23, 24, 10, 21, 18, 20, 15, 10, 26, 10, 19, 11, 21, 27, 21, 
Display: Integers position 3 changed to 24, size = 23
21, 27, 18, 24, 18, 16, 25, 29, 23, 24, 10, 21, 18, 20, 15, 10, 26, 10, 19, 11, 21, 27, 21, 
Display: Integers position 5 and front/back removed, size = 20
27, 18, 24, 18, 25, 29, 23, 24, 10, 21, 18, 20, 15, 10, 26, 10, 19, 11, 21, 27, 
Display: First integer entry with value of 24 removed and positions 0 1 swapped, size = 19
18, 27, 18, 25, 29, 23, 24, 10, 21, 18, 20, 15, 10, 26, 10, 19, 11, 21, 27, 
*/
