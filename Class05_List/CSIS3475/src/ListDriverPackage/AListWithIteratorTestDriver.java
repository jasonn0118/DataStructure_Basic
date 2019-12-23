package ListDriverPackage;
import java.util.Iterator;

import ListPackage.*;
import ListWithIteratorsPackage.*;

/**
 * A driver that demonstrates the class ArrayListWithIterator.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * modified to use subclassed AList instead, and new ListInterface methods
 * cleaned up code, created methods so that different lists could be used for test
 */
public class AListWithIteratorTestDriver {
	public static void main(String[] args) {
		testIteratorOperations(new CompletedLListWithIterator<>());
		testNext(new CompletedLListWithIterator<>());
		testNextAndRemove(new CompletedLListWithIterator<>());
		testNextAndRemove2(new CompletedLListWithIterator<>());		
		countingNames(new CompletedLListWithIterator<>());
		
//		testIteratorOperations(new LListWithIterator<>());
//		testNext(new LListWithIterator<>());
//		testNextAndRemove(new LListWithIterator<>());
//		testNextAndRemove2(new LListWithIterator<>());		
//		countingNames(new LListWithIterator<>());
		
//		testIteratorOperations(new CompletedAListWithIterator<>());
//		testNext(new CompletedAListWithIterator<>());
//		testNextAndRemove(new CompletedAListWithIterator<>());
//		testNextAndRemove2(new CompletedAListWithIterator<>());		
//		countingNames(new CompletedAListWithIterator<>());
		
//		testIteratorOperations(new AListWithIterator<>());
//		testNext(new AListWithIterator<>());
//		testNextAndRemove(new AListWithIterator<>());
//		testNextAndRemove2(new AListWithIterator<>());		
//		countingNames(new AListWithIterator<>());
	}

	public static void testIteratorOperations(ListWithIteratorInterface<String> myList) {
		System.out.println("======================");		
		System.out.println("testIteratorOperations()");
		System.out.println("Adding integers to list");
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

		System.out.println("Using Iterator methods, the list contains");
		Iterator<String> myIterator = myList.iterator();

		while (myIterator.hasNext())
			System.out.print(myIterator.next() + ", ");
		System.out.println();


		System.out.println("Return iterator to beginning of list");
		myIterator = myList.iterator(); // Reset iterator to beginning

		// Advance through list
		System.out.println("next() should return 15 : " + myIterator.next());
		System.out.println("next() should return 25 : " + myIterator.next());
		System.out.println("next() should return 35 : " + myIterator.next());
		System.out.println("next() should return 45 : " + myIterator.next());
		System.out.println("next() should return 55 : " + myIterator.next());
		System.out.println("next() should return 65 : " + myIterator.next());
		System.out.println("next() should return 75 : " + myIterator.next());
		System.out.println("next() should return 85 : " + myIterator.next());
		System.out.println("next() should return 95 : " + myIterator.next());

		System.out.println("hasNext() should return false : " + myIterator.hasNext());

		System.out.println("Testing Iterator's remove() method:");
		System.out.println("Return iterator to beginning of list");
		myIterator = myList.iterator(); // Reset iterator to beginning

		System.out.println("Removing current entry : " + myIterator.next() + " : should be 15");
		myIterator.remove(); // Remove entry 1
		DemoUtilities.displayUsingGetEntry(myList, "List should be: 25 35 45 55 65 75 85 95");

		System.out.println("Removing current entry: " + myIterator.next() + " : should be 25");
		myIterator.remove();
		DemoUtilities.displayUsingGetEntry(myList, "List should be: 35 45 55 65 75 85 95");

		// Advance twice
		System.out.println("Skipping over " + myIterator.next() + " : should be 35");

		System.out.println("Removing current entry: " + myIterator.next() + " : should be 45");
		myIterator.remove();
		DemoUtilities.displayUsingGetEntry(myList, "List should be: 35 55 65 75 85 95");

		// Advance 3 times
		System.out.println("Skipping over " + myIterator.next() + " : should be 55");
		System.out.println("Skipping over " + myIterator.next() + " : should be 65");
		System.out.println("Skipping over " + myIterator.next() + " : should be 75");
		System.out.println("Removing current entry: " + myIterator.next() + " : should be 85");
		myIterator.remove();
		
		DemoUtilities.displayUsingGetEntry(myList, "List should be: 35 55 65 75 95");

		System.out.println("next() should return 95 : " + myIterator.next());
		System.out.println("hasNext() should return false : " + myIterator.hasNext());
		System.out.println("======================");	
	} 

	public static void testNext(ListWithIteratorInterface<String> nameList) {
		System.out.println("======================");		
		System.out.println("testNext()");
		System.out.println("Example in Segment J4.6 of Java Interlude 4");

		nameList.add("Jamie");
		nameList.add("Joey");
		nameList.add("Rachel");
		
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Jamie, Joey, Rachel");

		Iterator<String> nameIterator = nameList.iterator();
		
		System.out.println("hasNext() should be true, is: " + nameIterator.hasNext());
		System.out.println("next() should be Jamie: " + nameIterator.next());
		System.out.println("next() should be Joey: " + nameIterator.next());
		System.out.println("next() should be Rachel: " + nameIterator.next());
		System.out.println("hasNext() should be false, is: " + nameIterator.hasNext());
		
//    nameIterator.next(); // Causes a NoSuchElementException.
		System.out.println("======================");	
	}

	public static void testNextAndRemove2(ListWithIteratorInterface<String> nameList) {
		System.out.println("======================");		
		System.out.println("testNextAndRemove2()");
		System.out.println("Similar to Question 1 in Java Interlude 4");

		nameList.add("Jamie");
		nameList.add("Joey");
		nameList.add("Rachel");

		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Jamie, Joey, Rachel");

		Iterator<String> nameIterator = nameList.iterator();
		System.out.println("next() " + nameIterator.next());
		System.out.println("next() " + nameIterator.next());
		System.out.println("remove()");
		nameIterator.remove();
		System.out.println("hasNext() should be true, is: " + nameIterator.hasNext());
		System.out.println("next() " + nameIterator.next());
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Jamie, Rachel");
		System.out.println("======================");	
	}
	
	public static void testNextAndRemove(ListWithIteratorInterface<String> nameList) {
		System.out.println("======================");		
		System.out.println("testNextAndRemove()");
		System.out.println("Example in Segment J4.8 of Java Interlude 4");
		
		nameList.add("Andy");
		nameList.add("Brittany");
		nameList.add("Chris");
		
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Andy Brittany Chris");
		
		Iterator<String> nameIterator = nameList.iterator();
		System.out.println("next() " + nameIterator.next());
		System.out.println("next() " + nameIterator.next());
		System.out.println("remove()");
		nameIterator.remove();
		System.out.println("next() " + nameIterator.next());
		
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Andy, Chris");
		
	}
	public static void countingNames(ListWithIteratorInterface<String> nameList) {
		System.out.println("======================");		
		System.out.println("countingNames()");
		System.out.println("Similar to Example in Segments J4.10 and J4.11 of Java Interlude 4");

		nameList.add("Brad");
		nameList.add("Jane");
		nameList.add("Bob");
		nameList.add("Jane");
		nameList.add("Bette");
		nameList.add("Brad");
		nameList.add("Jane");
		nameList.add("Brenda");
		
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Brad, Jane, Bob, Jane, Bette, Brad, Jane, Brenda");

		Iterator<String> nameIterator = nameList.iterator();
		while (nameIterator.hasNext()) {
			String currentName = nameIterator.next();
			int nameCount = 0;
			Iterator<String> countingIterator = nameList.iterator();
			while (countingIterator.hasNext()) {
				String nextName = countingIterator.next();
				if (currentName.equals(nextName))
					nameCount++;
			} 
			System.out.println(currentName + " occurs " + nameCount + " times.");
		}

		System.out.println("*** Output should be:");
		System.out.println("Brad occurs 2 times.");
		System.out.println("Jane occurs 3 times.");
		System.out.println("Bob occurs 1 times.");
		System.out.println("Jane occurs 3 times.");
		System.out.println("Bette occurs 1 times.");
		System.out.println("Brad occurs 2 times.");
		System.out.println("Jane occurs 3 times.");
		System.out.println("Brenda occurs 1 times.");
		System.out.println("======================");
		// ============================================================================

		// Example in Segments J4.10 and J4.11 of Java Interlude 4, but with
		// AListWithIterator and without duplicates

		System.out.println("*** Repeat without duplicates:");

		nameIterator = nameList.iterator();
		while (nameIterator.hasNext()) {
			String currentName = nameIterator.next();
			int nameCount = 0;
			Iterator<String> countingIterator = nameList.iterator();
			while (countingIterator.hasNext()) {
				String nextName = countingIterator.next();
				if (currentName.equals(nextName)) {
					nameCount++;
					if (nameCount > 1)
						countingIterator.remove();
				} 
			} 
			System.out.println(currentName + " occurs " + nameCount + " times.");
		}	
	}
	public static void displayList(ListWithIteratorInterface<String> list) {
		int numberOfEntries = list.size();

		System.out.println("\nThe list contains " + numberOfEntries + " entries, as follows:");
		for (int position = 0; position < numberOfEntries; position++)
			System.out.println(list.getEntry(position) + " is entry " + position);
		System.out.println();
	} 
} 

/*
Create a list: 
Testing add to end: Add 15, 25, 35, 45, 55, 65, 75, 85, 95

------------------------

Testing Iterator's hasNext and next methods:


List should contain
15 25 35 45 55 65 75 85 95


Using ADT list operations, the list contains 

The list contains 9 entries, as follows:
15 is entry 0
25 is entry 1
35 is entry 2
45 is entry 3
55 is entry 4
65 is entry 5
75 is entry 6
85 is entry 7
95 is entry 8



Using Iterator methods, the list contains
15 25 35 45 55 65 75 85 95 



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
----------------------




Testing Iterator's remove() method:


Return iterator to beginning of list

Removing current entry : 15 : should be 15
List should contain
25 35 45 55 65 75 85 95


Using ADT list operations, the list contains 

The list contains 8 entries, as follows:
25 is entry 0
35 is entry 1
45 is entry 2
55 is entry 3
65 is entry 4
75 is entry 5
85 is entry 6
95 is entry 7

Removing current entry: 25 : should be 25
List should contain
35 45 55 65 75 85 95


Using ADT list operations, the list contains 

The list contains 7 entries, as follows:
35 is entry 0
45 is entry 1
55 is entry 2
65 is entry 3
75 is entry 4
85 is entry 5
95 is entry 6

Skipping over 35 : should be 35
Removing current entry: 45 : should be 45
List should contain
35 55 65 75 85 95


Using ADT list operations, the list contains 

The list contains 6 entries, as follows:
35 is entry 0
55 is entry 1
65 is entry 2
75 is entry 3
85 is entry 4
95 is entry 5

Skipping over 55 : should be 55
Skipping over 65 : should be 65
Skipping over 75 : should be 75
Removing current entry: 85 : should be 85
List should contain
35 55 65 75 95


Using ADT list operations, the list contains 

The list contains 5 entries, as follows:
35 is entry 0
55 is entry 1
65 is entry 2
75 is entry 3
95 is entry 4

next() should return 95 : 95
hasNext() should return false : false
===========================================================



Example in Segment J4.6 of Java Interlude 4:
List is Jamie, Joey, Rachel
Output should be: true Jamie Joey Rachel false
true Jamie Joey Rachel false
-------------------------------
Example in Segment J4.8 of Java Interlude 4:
List is Andy, Brittany, Chris
Output should be: Andy Brittany Chris
Andy Brittany Chris 
-------------------------------
Similar to Question 1 in Java Interlude 4:
List is Jamie, Joey, Rachel
true
Rachel

The list contains 2 entries, as follows:
Jamie is entry 0
Rachel is entry 1

-------------------------------
Similar to Example in Segments J4.10 and J4.11 of Java Interlude 4:
List contains Brad, Jane, Bob, Jane, Bette, Brad, Jane, Brenda

Brad occurs 2 times.
Jane occurs 3 times.
Bob occurs 1 times.
Jane occurs 3 times.
Bette occurs 1 times.
Brad occurs 2 times.
Jane occurs 3 times.
Brenda occurs 1 times.

Output should be:
Brad occurs 2 times.
Jane occurs 3 times.
Bob occurs 1 times.
Jane occurs 3 times.
Bette occurs 1 times.
Brad occurs 2 times.
Jane occurs 3 times.
Brenda occurs 1 times.
======================

Repeat without duplicates:
Brad occurs 2 times.
Jane occurs 3 times.
Bob occurs 1 times.
Bette occurs 1 times.
Brenda occurs 1 times.


Done.

*/
