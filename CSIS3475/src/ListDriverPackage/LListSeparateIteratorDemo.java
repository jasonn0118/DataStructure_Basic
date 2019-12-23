package ListDriverPackage;
import java.util.Iterator;

import ListPackage.*;
import ListWithIteratorsPackage.*;

/**
 * A driver that demonstrates the class SeparateListIterator with an
 * instance of LList.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class LListSeparateIteratorDemo {
	public static void main(String[] args) {
		testIteratorOperations();
		testExamples();
	}

	public static void testIteratorOperations() {
		System.out.println("testIteratorOperations()");
		
		ListInterface<String> myList = new LList<>();
//		ListInterface<String> myList = new AList<>();

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
		Iterator<String> myIterator = new SeparateListIterator<>(myList);

		while (myIterator.hasNext())
			System.out.print(myIterator.next() + ", ");
		System.out.println();

		System.out.println("Return iterator to beginning of list");
		myIterator = new SeparateListIterator<>(myList); // Reset iterator to beginning

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
		myIterator = new SeparateListIterator<>(myList); // Reset iterator to beginning

		System.out.println("Removing current entry : " + myIterator.next() + " : should be 15");
		myIterator.remove(); // Remove entry 1
		
		DemoUtilities.displayUsingGetEntry(myList, "List should be: 25, 35, 45, 55, 65, 75, 85, 95");

		System.out.println("Removing current entry: " + myIterator.next() + " : should be 25");
		myIterator.remove();
		
		DemoUtilities.displayUsingGetEntry(myList, "List should be: 35, 45, 55, 65, 75, 85, 95");


		// Advance twice
		System.out.println("Skipping over " + myIterator.next() + " : should be 35");

		System.out.println("Removing current entry: " + myIterator.next() + " : should be 45");
		myIterator.remove();
		
		DemoUtilities.displayUsingGetEntry(myList, "List should be: 35, 55, 65, 75, 85, 95");

		// Aadvance 3 times
		System.out.println("Skipping over " + myIterator.next() + " : should be 55");
		System.out.println("Skipping over " + myIterator.next() + " : should be 65");
		System.out.println("Skipping over " + myIterator.next() + " : should be 75");
		System.out.println("Removing current entry: " + myIterator.next() + " : should be 85");
		myIterator.remove();
		
		DemoUtilities.displayUsingGetEntry(myList, "List should be: 35, 55, 65, 75, 95");

		System.out.println("next() should return 95 : " + myIterator.next());
		System.out.println("hasNext() should return false : " + myIterator.hasNext());
		System.out.println("===============================");
	}

	public static void testExamples() {
		System.out.println("testExamples()");
		// Example in Segment J4.6 of Java Interlude 4
		System.out.println("Example in Segment J4.6 of Java Interlude 4:");
//		ListInterface<String> nameList = new LList<>();
		ListInterface<String> nameList = new AList<>();
		nameList.add("Jamie");
		nameList.add("Joey");
		nameList.add("Rachel");
		
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Jamie Joey Rachel");

		Iterator<String> nameIterator = new SeparateListIterator<>(nameList);

		System.out.println("Output should be: true Jamie Joey Rachel false");
		System.out.print(nameIterator.hasNext() + " ");
		System.out.print(nameIterator.next() + " ");
		System.out.print(nameIterator.next() + " ");
		System.out.print(nameIterator.next() + " ");
		System.out.println(nameIterator.hasNext());
//      nameIterator.next(); // Causes a NoSuchElementException.
// ============================================================================
// Example in Segment J4.8 of Java Interlude 4
		System.out.println("Example in Segment J4.8 of Java Interlude 4:");
		nameList = new AList<>();
//		nameList = new LList<>();
		nameList.add("Andy");
		nameList.add("Brittany");
		nameList.add("Chris");
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Andy Brittany Chris");

		nameIterator = new SeparateListIterator<>(nameList);
		System.out.println("Output should be: Andy Brittany Chris");
		System.out.print(nameIterator.next() + " ");
		System.out.print(nameIterator.next() + " ");
		nameIterator.remove();
		System.out.println(nameIterator.next() + " ");
		System.out.println("Brittany removed");
		
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Andy Chris");
		// ============================================================================

		// Question 1 in Java Interlude 4, but with SeparateListIterator
		System.out.println("Similar to Question 1 in Java Interlude 4:");
		nameList = new AList<>();
//		nameList = new LList<>();
		nameList.add("Jamie");
		nameList.add("Joey");
		nameList.add("Rachel");
		
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Jamie, Joey, Rachel");

		nameIterator = new SeparateListIterator<>(nameList);
		System.out.println("next() Jamie: " + nameIterator.next());
		System.out.println("next() Joey: " + nameIterator.next());
		System.out.println("remove() Joey");
		nameIterator.remove();
		System.out.println("hasNext() " + nameIterator.hasNext());
		System.out.println("next() Rachel: " + nameIterator.next());
		
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Jamie, Rachel");
		// ============================================================================

		// Example in Segments J4.10 and J4.11 of Java Interlude 4, but with
		// SeparateListIterator
		System.out.println("Similar to Example in Segments J4.10 and J4.11 of Java Interlude 4:");
		nameList = new AList<>();
//		nameList = new LList<>();

		nameList.add("Brad");
		nameList.add("Jane");
		nameList.add("Bob");
		nameList.add("Jane");
		nameList.add("Bette");
		nameList.add("Brad");
		nameList.add("Jane");
		nameList.add("Brenda");
		
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Brad, Jane, Bob, Jane, Bette, Brad, Jane, Brenda");

		System.out.println("Count the frequency of names, allowing duplicates");
		nameIterator = new SeparateListIterator<>(nameList);
		while (nameIterator.hasNext()) {
			String currentName = nameIterator.next();
			int nameCount = 0;
			Iterator<String> countingIterator = new SeparateListIterator<>(nameList);
			while (countingIterator.hasNext()) {
				String nextName = countingIterator.next();
				if (currentName.equals(nextName))
					nameCount++;
			} 
			System.out.println(currentName + " occurs " + nameCount + " times.");
		} 

		System.out.println();
		System.out.println("Output should be:");
		System.out.println("Brad occurs 2 times.");
		System.out.println("Jane occurs 3 times.");
		System.out.println("Bob occurs 1 times.");
		System.out.println("Jane occurs 3 times.");
		System.out.println("Bette occurs 1 times.");
		System.out.println("Brad occurs 2 times.");
		System.out.println("Jane occurs 3 times.");
		System.out.println("Brenda occurs 1 times.");
		System.out.println();
		// ============================================================================

		// Example in Segments J4.10 and J4.11 of Java Interlude 4, but with
		// SeparateListIterator
		// and without duplicates

		System.out.println("Repeat without duplicates:");

		nameIterator = new SeparateListIterator<>(nameList);
		while (nameIterator.hasNext()) {
			String currentName = nameIterator.next();
			int nameCount = 0;
			Iterator<String> countingIterator = new SeparateListIterator<>(nameList);
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
		System.out.println("===============================");
	} 
} 

/*
testIteratorOperations()
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
Testing Iterator's remove() method:
Return iterator to beginning of list
Removing current entry : 15 : should be 15
Display using getEntry(): List should be: 25, 35, 45, 55, 65, 75, 85, 95, size = 8
25, 35, 45, 55, 65, 75, 85, 95, 
Removing current entry: 25 : should be 25
Display using getEntry(): List should be: 35, 45, 55, 65, 75, 85, 95, size = 7
35, 45, 55, 65, 75, 85, 95, 
Skipping over 35 : should be 35
Removing current entry: 45 : should be 45
Display using getEntry(): List should be: 35, 55, 65, 75, 85, 95, size = 6
35, 55, 65, 75, 85, 95, 
Skipping over 55 : should be 55
Skipping over 65 : should be 65
Skipping over 75 : should be 75
Removing current entry: 85 : should be 85
Display using getEntry(): List should be: 35, 55, 65, 75, 95, size = 5
35, 55, 65, 75, 95, 
next() should return 95 : 95
hasNext() should return false : false
===============================
testExamples()
Example in Segment J4.6 of Java Interlude 4:
Display using getEntry(): List should be: Jamie Joey Rachel, size = 3
Jamie, Joey, Rachel, 
Output should be: true Jamie Joey Rachel false
true Jamie Joey Rachel false
Example in Segment J4.8 of Java Interlude 4:
Display using getEntry(): List should be: Andy Brittany Chris, size = 3
Andy, Brittany, Chris, 
Output should be: Andy Brittany Chris
Andy Brittany Chris 
Brittany removed
Display using getEntry(): List should be: Andy Chris, size = 2
Andy, Chris, 
Similar to Question 1 in Java Interlude 4:
Display using getEntry(): List should be: Jamie, Joey, Rachel, size = 3
Jamie, Joey, Rachel, 
next() Jamie: Jamie
next() Joey: Joey
remove() Joey
hasNext() true
next() Rachel: Rachel
Display using getEntry(): List should be: Jamie, Rachel, size = 2
Jamie, Rachel, 
Similar to Example in Segments J4.10 and J4.11 of Java Interlude 4:
Display using getEntry(): List should be: Brad, Jane, Bob, Jane, Bette, Brad, Jane, Brenda, size = 8
Brad, Jane, Bob, Jane, Bette, Brad, Jane, Brenda, 
Count the frequency of names, allowing duplicates
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

Repeat without duplicates:
Brad occurs 2 times.
Jane occurs 3 times.
Bob occurs 1 times.
Bette occurs 1 times.
Brenda occurs 1 times.
===============================


*/
