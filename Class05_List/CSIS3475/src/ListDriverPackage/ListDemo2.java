package ListDriverPackage;
import ListPackage.*;

/**
 * A driver that demonstrates the class LList.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * modified substantially to account for new ListInterface
 *  and display() method
 */
public class ListDemo2 {
	public static void main(String[] args) {

		// uncomment the implementation to test
		
//		ListInterface<String> myList = new CompletedAList<>();
//		ListInterface<String> myList = new CompletedLList<>();
//		ListInterface<String> myList = new CompletedLListWithTail<>();
//		ListInterface<String> myList = new CompletedListUsingLibrary<>();
		
		ListInterface<String> myList = new AList<>();
//		ListInterface<String> myList = new LList<>();
//		ListInterface<String> myList = new LListWithTail<>();
//		ListInterface<String> myList = new ListUsingLibrary<>();

		System.out.println("Testing add to end: Add 15, 25, 35, 45");
		myList.add("15");
		myList.add("25");
		myList.add("35");
		myList.add("45");

		DemoUtilities.display(myList, "List should contain 15 25 35 45");

		System.out.println("Is List empty? " + myList.isEmpty());

		System.out.println("Add more entries to end: Add 55, 65, 75, 85, 95");
		myList.add("55");
		myList.add("65");
		myList.add("75");
		myList.add("85");
		myList.add("95");

		System.out.println("Is List empty? " + myList.isEmpty());

		DemoUtilities.display(myList, "List should contain 15 25 35 45 55 65 75 85 95");

		System.out.println("Testing clear()");
		myList.clear();

		System.out.println("List should be empty: ");
		System.out.println("Is list empty? " + myList.isEmpty());

		System.out.println("Create a new list");
		
		// uncomment the implementation to test
		
//		myList = new CompletedAList<>();
//		myList = new CompletedLList<>();
//		myList = new CompletedLListWithTail<>();
//		myList = new CompletedListUsingLibrary<>();
		
		myList = new AList<>();
//		myList = new LList<>();
//		myList = new LListWithTail<>();
//		myList = new ListUsingLibrary<>();

		System.out.println("Add 15 at position 0");
		myList.add(0, "15");
		System.out.println("Add 25 at position 1");
		myList.add(1, "25");
		System.out.println("Add 35 at position 2");
		myList.add(2, "35");

		DemoUtilities.display(myList, "List should contain 15 25 35");

		System.out.println("Is List empty? " + myList.isEmpty());

		System.out.println("Add 19 at position 0");
		myList.add(0, "19");
		System.out.println("Add 39 at position 2");
		myList.add(2, "39");
		System.out.println("Add 29 at position 1");
		myList.add(1, "29");
		System.out.println("Add 55 at position 6");
		myList.add(myList.size(), "55");
		System.out.println("Add 65 at position 7");
		myList.add(7, "65");

		DemoUtilities.display(myList, "List should contain 19 29 15 39 25 35 55 65");

		System.out.println("Is List empty? " + myList.isEmpty());

		System.out.println("Testing remove() ");
		System.out.println("Removing 15 at position 2: returns " + myList.remove(2));
		System.out.println("Removing 19 at position 0: returns " + myList.remove(0));
		System.out.println("Removing 65 at position 5: returns " + myList.remove(5));

		DemoUtilities.display(myList, "List should contain 29 39 25 35 55");

		System.out.println("Testing replace() ");
		System.out.println("Replace 29 at position 0 with 92 : returns " + myList.replace(0, "92"));
		System.out.println("Replace 39 at position 1 with 93 : returns " + myList.replace(1, "93"));
		System.out.println("Replace 25 at position 2 with 52 : returns " + myList.replace(2, "52"));
		System.out.println("Replace 35 at position 3 with 53 : returns " + myList.replace(3, "53"));
		System.out.println("Replace 55 at position 4 with 50 : returns " + myList.replace(4, "50"));

		DemoUtilities.display(myList, "List should contain 92 93 52 53 50");

		System.out.println("Is List empty? " + myList.isEmpty());
		
		DemoUtilities.displayUsingGetEntry(myList, "List should contain 92 93 52 53 50");

		System.out.println("Testing contains() [results should be TRUE]");
		System.out.println("List contains 92: " + myList.contains("92"));
		System.out.println("List contains 52: " + myList.contains("52"));
		System.out.println("List contains 53: " + myList.contains("53"));
		System.out.println("List contains 50: " + myList.contains("50"));

		System.out.println("Testing contains() [results should be FALSE]");
		System.out.println("List contains 91 returns : " + myList.contains("91"));
		System.out.println("List contains 55 returns : " + myList.contains("55"));
		System.out.println("List contains 4  returns : " + myList.contains("4"));
		System.out.println("List contains 12 returns : " + myList.contains("12"));

	} 
} 
/*
Testing add to end: Add 15, 25, 35, 45
Display: List should contain 15 25 35 45, size = 4
15, 25, 35, 45, 
Is List empty? false
Add more entries to end: Add 55, 65, 75, 85, 95
Is List empty? false
Display: List should contain 15 25 35 45 55 65 75 85 95, size = 9
15, 25, 35, 45, 55, 65, 75, 85, 95, 
Testing clear()
List should be empty: 
Is list empty? true
Create a new list
Add 15 at position 0
Add 25 at position 1
Add 35 at position 2
Display: List should contain 15 25 35, size = 3
15, 25, 35, 
Is List empty? false
Add 19 at position 0
Add 39 at position 2
Add 29 at position 1
Add 55 at position 6
Add 65 at position 7
Display: List should contain 19 29 15 39 25 35 55 65, size = 8
19, 29, 15, 39, 25, 35, 55, 65, 
Is List empty? false
Testing remove() 
Removing 15 at position 2: returns 15
Removing 19 at position 0: returns 19
Removing 65 at position 5: returns 65
Display: List should contain 29 39 25 35 55, size = 5
29, 39, 25, 35, 55, 
Testing replace() 
Replace 29 at position 0 with 92 : returns 29
Replace 39 at position 1 with 93 : returns 39
Replace 25 at position 2 with 52 : returns 25
Replace 35 at position 3 with 53 : returns 35
Replace 55 at position 4 with 50 : returns 55
Display: List should contain 92 93 52 53 50, size = 5
92, 93, 52, 53, 50, 
Is List empty? false
Display using getEntry(): List should contain 92 93 52 53 50, size = 5
92, 93, 52, 53, 50, 
Testing contains() [results should be TRUE]
List contains 92: true
List contains 52: true
List contains 53: true
List contains 50: true
Testing contains() [results should be FALSE]
List contains 91 returns : false
List contains 55 returns : false
List contains 4  returns : false
List contains 12 returns : false

*/
