package ListDriverPackage;
import ListPackage.*;
import ListWithIteratorsPackage.*;

/**
 * A driver that demonstrates the class CompletedListWithTraversal.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 * 
 * @author mhrybyk
 * 
 * modified to use display utility class and new list interface
 */
public class LListWithTraversalDemo {
	public static void main(String[] args) {
			
		System.out.println("Adding integers to list");
		
//		CompletedLListWithTraversal<String> myList = new CompletedLListWithTraversal<>();
		LListWithTraversal<String> myList = new LListWithTraversal<>();
		System.out.println("Testing add to end: Add 15, 25, 35, 45, 55, 65, 75, 85, 95");
		myList.add("15");
		myList.add("25");
		myList.add("35");
		myList.add("45");
		myList.add("55");
		myList.add("65");
		myList.add("75");
		myList.add("85");
		myList.add("95");

		DemoUtilities.displayUsingGetEntry(myList, "List should be: 15, 25, 35, 45, 55, 65, 75, 85, 95");

		System.out.println("Testing Iterator's hasNext and next methods:");

		System.out.println("Using Iterator methods, the list contains: ");
		myList.resetTraversal();

		while (myList.hasNext())
			System.out.print(myList.next() + ", ");
		System.out.println();


		System.out.println("Return iterator to beginning of list");
		myList.resetTraversal(); // Reset iterator to beginning

		// Advance through list
		System.out.println("next() should return 15 : " + myList.next());
		System.out.println("next() should return 25 : " + myList.next());
		System.out.println("next() should return 35 : " + myList.next());
		System.out.println("next() should return 45 : " + myList.next());
		System.out.println("next() should return 55 : " + myList.next());
		System.out.println("next() should return 65 : " + myList.next());
		System.out.println("next() should return 75 : " + myList.next());
		System.out.println("next() should return 85 : " + myList.next());
		System.out.println("next() should return 95 : " + myList.next());

		System.out.println("hasNext() should return false : " + myList.hasNext());
	} 
} 

/*
Adding integers to list
Testing add to end: Add 15, 25, 35, 45, 55, 65, 75, 85, 95
Display using getEntry(): List should be: 15, 25, 35, 45, 55, 65, 75, 85, 95, size = 9
15, 25, 35, 45, 55, 65, 75, 85, 95, 
Testing Iterator's hasNext and next methods:
Using Iterator methods, the list contains: 
15, 25, 35, 45, 55, 65, 75, 85, 95, 
Return iterator to beginning of list
next() should return 15 : 15
next() should return 25 : 25
next() should return 35 : 35
next() should return 45 : 45
next() should return 55 : 55
next() should return 65 : 65
next() should return 75 : 75
next() should return 85 : 85
next() should return 95 : 95
hasNext() should return false : false

*/
