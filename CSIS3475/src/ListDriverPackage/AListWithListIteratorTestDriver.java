package ListDriverPackage;
import java.util.ListIterator;

import ListPackage.*;
import ListWithIteratorsPackage.*;

/**
 * A driver that demonstrates the class ArrayListWithListIterator.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class AListWithListIteratorTestDriver {
	public static void main(String[] args) {
//		testIteratorBasicOperations(new CompletedAListWithListIterator<>());
//		testIteratorRemoveOperations(new CompletedAListWithListIterator<>());
//		testAddAndSet(new CompletedAListWithListIterator<String>());
//		testIllegalOps(new CompletedAListWithListIterator<>());
		
		testIteratorBasicOperations(new AListWithListIterator<>());
		testIteratorRemoveOperations(new AListWithListIterator<>());
		testAddAndSet(new AListWithListIterator<String>());
		testIllegalOps(new AListWithListIterator<>());

	} 

	public static void testIteratorBasicOperations(ListWithListIteratorInterface<String> nameList) {
		System.out.println("testIteratorBasicOperations()");

		nameList.add("Jess");
		nameList.add("Jim");
		nameList.add("Josh");
		DemoUtilities.displayUsingGetEntry(nameList, "List should be: Jess, Jim, Josh");


		System.out.println(
				"Testing ListIterator's methods hasNext, next, nextIndex, hasPrevious, previous, and previousIndex:");
		ListIterator<String> traverse = nameList.getIterator();

		System.out.println("nextIndex     " + traverse.nextIndex() + "    " + "should be 0");
		System.out.println("hasNext       " + traverse.hasNext() + " " + "should be true");
		System.out.println("previousIndex " + traverse.previousIndex() + " " + "should be -1");
		System.out.println("hasPrevious   " + traverse.hasPrevious() + "  " + "should be false");
		System.out.println();

		System.out.println("next      " + traverse.next() + "      " + "should be Jess");
		System.out.println("nextIndex " + traverse.nextIndex() + " " + "should be 1");
		System.out.println("hasNext   " + traverse.hasNext() + "   " + "should be true");
		System.out.println();

		System.out.println("previousIndex " + traverse.previousIndex() + " " + "should be 0");
		System.out.println("hasPrevious   " + traverse.hasPrevious() + "   " + "should be true");
		System.out.println("previous      " + traverse.previous() + "      " + "should be Jess");
		System.out.println("nextIndex     " + traverse.nextIndex() + "     " + "should be 0");
		System.out.println("hasNext       " + traverse.hasNext() + "       " + "should be true");
		System.out.println("next          " + traverse.next() + "          " + "should be Jess");
		System.out.println("================");
	}
	public static void testIteratorRemoveOperations(ListWithListIteratorInterface<String> myList) {
		System.out.println("testIteratorRemoveOperations()");

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

		System.out.println("Using ListIterator methods, the list contains");
		ListIterator<String> myIterator = myList.getIterator();

		while (myIterator.hasNext())
			System.out.print(myIterator.next() + " ");
		System.out.println();

		myIterator = myList.getIterator();
		System.out.println("Removing current entry : " + myIterator.next() + " should be 15");
		myIterator.remove(); // Remove entry 1

		DemoUtilities.displayUsingGetEntry(myList, "List should be: 25 35 45 55 65 75 85 95");

		System.out.println("Removing current entry: " + myIterator.next() + " should be 25");
		myIterator.remove();

		DemoUtilities.displayUsingGetEntry(myList, "List should be: 35 45 55 65 75 85 95");

		// Advance twice
		System.out.println("Skipping over " + myIterator.next() + " should be 35");

		System.out.println("Removing current entry: " + myIterator.next() + " should be 45");
		myIterator.remove();

		DemoUtilities.displayUsingGetEntry(myList, "List should be: 35 55 65 75 85 95");

		// Advance 3 times
		System.out.println("Skipping over " + myIterator.next() + " should be 55");
		System.out.println("Skipping over " + myIterator.next() + " should be 65");
		System.out.println("Skipping over " + myIterator.next() + " should be 75");

		System.out.println("Removing current entry: " + myIterator.next() + " should be 85");
		myIterator.remove();

		DemoUtilities.displayUsingGetEntry(myList, "List should be: 35 55 65 75 95");

		System.out.println("next() should return 95 : " + myIterator.next());
		System.out.println("hasNext() should return false : " + myIterator.hasNext());

		System.out.println("The iterator is at the end of the list.\n"
				+ "Testing ListIterator's hasPrevious and previous methods\n" + "by traversing backward:");
		while (myIterator.hasPrevious())
			System.out.print(myIterator.previous() + " ");
		System.out.println();

		System.out.println("The iterator is at the beginning of the list.\n"
				+ "Testing ListIterator's hasNext and next methods\n" + "by traversing forward:");
		while (myIterator.hasNext())
			System.out.print(myIterator.next() + " ");
		System.out.println();

		System.out.println("Using Iterator methods, the list contains");
		ListIterator<String> yourIterator = myList.getIterator();

		while (yourIterator.hasNext())
			System.out.print(yourIterator.next() + " ");
		System.out.println();
		
		System.out.println("Testing ListIterator's remove() method:");
		
		System.out.println("Return iterator to beginning of list, next(), remove()");
		myIterator = myList.getIterator(); // Reset iterator to beginning
		myIterator.next();
		myIterator.remove();

		DemoUtilities.displayUsingGetEntry(myList, "List should be: 55 65 75 95");
		System.out.println("================");
	} 

	public static void testAddAndSet(ListWithListIteratorInterface<String> myList) {
		System.out.println("testAddAndSet()");

		ListIterator<String> traverse = myList.getIterator();

		myList.add("Jamie");
		myList.add("Doug");
		myList.add("Jill");

		DemoUtilities.displayUsingGetEntry(myList, "List should be: Jamie Doug Jill");
		
		System.out.println("nextIndex = " + traverse.nextIndex() + "; should be 0");
		System.out.println("hasNext = " + traverse.hasNext() + "; should be true");
		System.out.println("previousIndex = " + traverse.previousIndex() + "; should be -1");
		System.out.println("hasPrevious = " + traverse.hasPrevious() + "; should be false");

		System.out.println();

		System.out.println("next = " + traverse.next() + "; should be Jamie");
		System.out.println("nextIndex = " + traverse.nextIndex() + "; should be 1");
		System.out.println("hasNext = " + traverse.hasNext() + "; should be true");

		System.out.println();

		System.out.println("previousIndex " + traverse.previousIndex() + "; should be 0");
		System.out.println("hasPrevious   " + traverse.hasPrevious() + "; should be true");
		System.out.println("previous      " + traverse.previous() + "; should be Jamie");
		System.out.println("nextIndex     " + traverse.nextIndex() + "; should be 0");
		System.out.println("hasNext       " + traverse.hasNext() + "; should be true");
		System.out.println("next          " + traverse.next() + "; should be Jamie");

// Test set
		System.out.println("Testing ListIterator's set method:");
		System.out.println("Replace entry that next() just returned (Jamie) with Bob:");
		traverse.set("Bob");

		DemoUtilities.displayUsingGetEntry(myList, "List should be: Bob Doug Jill");

		System.out.println("previousIndex " + traverse.previousIndex() + "    " + "should be 0");
		System.out.println("hasPrevious   " + traverse.hasPrevious() + " " + "should be true");
		;

		System.out.println("nextIndex     " + traverse.nextIndex() + "    " + "should be 1");
		System.out.println("hasNext       " + traverse.hasNext() + " " + "should be true");

// Test add
		System.out.println("Testing ListIterator's add method:");
		System.out.println("Before add");

		System.out.println("nextIndex     " + traverse.nextIndex() + " should be 1");
		System.out.println("previousIndex " + traverse.previousIndex() + " should be 0");

		System.out.println("add Kerry before (or at) position " + (1 + traverse.nextIndex()));
		traverse.add("Kerry");
		DemoUtilities.displayUsingGetEntry(myList, "List should be: Bob Kerry Doug Jill");

		System.out.println("After add");
		System.out.println("nextIndex     " + traverse.nextIndex() + " should be 2");
		System.out.println("previousIndex " + traverse.previousIndex() + " should be 1");

// Choose 1 of the following groups:
		System.out.println("next          " + traverse.next() + " should be Doug");
		traverse.remove();
		System.out.println("After removing Doug");
		
		DemoUtilities.displayUsingGetEntry(myList, "List should be: Bob Kerry Jill");

		/*
		 * System.out.println("previous      " + traverse.previous() +
		 * " should be Kerry"); traverse.remove();
		 * System.out.println("After removing Kerry"); displayList(myList);
		 */
		
		System.out.println("Clear the list");
		myList.clear();

		myList.add("Bob");
		myList.add("Kerry");
		myList.add("Doug");
		myList.add("Jill");
		DemoUtilities.displayUsingGetEntry(myList, "List should be: Bob Kerry Doug Jill");
		
		traverse = myList.getIterator();
		System.out.println("Traversing Bob then Kerry, then previous() Kerry, then remove() Kerry");
		System.out.println("next() " + traverse.next());
		System.out.println("next() " + traverse.next());
// Current is Doug
		System.out.println("previous() " + traverse.previous()); // Move back to Kerry
 
		traverse.remove(); // Remove Kerry
		DemoUtilities.displayUsingGetEntry(myList, "List should be: Bob Doug Jill");
		
		System.out.println("================");

	} 

	public static void testIllegalOps(ListWithListIteratorInterface<String> myList) {
		System.out.println("testIllegalOps()");

		ListIterator<String> traverse = myList.getIterator();

		myList.add("Jamie");
		myList.add("Doug");
		myList.add("Jill");
		
		DemoUtilities.displayUsingGetEntry(myList, "List should be: Jamie Doug Jill");

		System.out.println("The sequence next, set, set, remove is legal.");
		System.out.println("next() " + traverse.next());
		traverse.set("XX");
		
		DemoUtilities.displayUsingGetEntry(myList, "List should be: XX Doug Jill");
		
		System.out.println("Set to XX to XX again, then remove, which is legal");
		traverse.set("XX");
		traverse.remove();
		
		DemoUtilities.displayUsingGetEntry(myList, "List should be: Doug Jill");

		System.out.print("The following sequence is illegal and causes an exception:");

		// Choose one sequence to test; disable the others
		
//		// 1 
//		System.out.println(" next, remove, remove\n"); traverse.next();
//		traverse.remove();
//		traverse.remove();
//
//		// 2 
//		System.out.println(" previous, remove, remove\n"); traverse.previous();
//		traverse.remove();
//		traverse.remove();
//
//		// 3 
//		System.out.println(" previous, set, remove\n"); traverse.previous();
//		traverse.set("XX");
//		traverse.remove();
//
//		// 4 
//		System.out.println(" previous, add, remove\n"); traverse.previous();
//		traverse.add("YY");
//		traverse.remove();
//
//		// 5 
//		System.out.println(" next, set, add, remove\n"); traverse.next();
//		traverse.set("XX");
//		traverse.add("XX");
//		traverse.remove();

		// 6
		System.out.println(" next, set, add, set\n");
		traverse.next();
		traverse.set("XX");
		traverse.add("XX");
		traverse.set("ZZ");

	} 
} 

/*
testIteratorBasicOperations()
Display using getEntry(): List should be: Jess, Jim, Josh, size = 3
Jess, Jim, Josh, 
Testing ListIterator's methods hasNext, next, nextIndex, hasPrevious, previous, and previousIndex:
nextIndex     0    should be 0
hasNext       true should be true
previousIndex -1 should be -1
hasPrevious   false  should be false

next      Jess      should be Jess
nextIndex 1 should be 1
hasNext   true   should be true

previousIndex 0 should be 0
hasPrevious   true   should be true
previous      Jess      should be Jess
nextIndex     0     should be 0
hasNext       true       should be true
next          Jess          should be Jess
================
testIteratorRemoveOperations()
Display using getEntry(): List should be: 15, 25, 35, 45, 55, 65, 75, 85, 95, size = 9
15, 25, 35, 45, 55, 65, 75, 85, 95, 
Using ListIterator methods, the list contains
15 25 35 45 55 65 75 85 95 
Removing current entry : 15 should be 15
Display using getEntry(): List should be: 25 35 45 55 65 75 85 95, size = 8
25, 35, 45, 55, 65, 75, 85, 95, 
Removing current entry: 25 should be 25
Display using getEntry(): List should be: 35 45 55 65 75 85 95, size = 7
35, 45, 55, 65, 75, 85, 95, 
Skipping over 35 should be 35
Removing current entry: 45 should be 45
Display using getEntry(): List should be: 35 55 65 75 85 95, size = 6
35, 55, 65, 75, 85, 95, 
Skipping over 55 should be 55
Skipping over 65 should be 65
Skipping over 75 should be 75
Removing current entry: 85 should be 85
Display using getEntry(): List should be: 35 55 65 75 95, size = 5
35, 55, 65, 75, 95, 
next() should return 95 : 95
hasNext() should return false : false
The iterator is at the end of the list.
Testing ListIterator's hasPrevious and previous methods
by traversing backward:
95 75 65 55 35 
The iterator is at the beginning of the list.
Testing ListIterator's hasNext and next methods
by traversing forward:
35 55 65 75 95 
Using Iterator methods, the list contains
35 55 65 75 95 
Testing ListIterator's remove() method:
Return iterator to beginning of list, next(), remove()
Display using getEntry(): List should be: 55 65 75 95, size = 4
55, 65, 75, 95, 
================
testAddAndSet()
Display using getEntry(): List should be: Jamie Doug Jill, size = 3
Jamie, Doug, Jill, 
nextIndex = 0; should be 0
hasNext = true; should be true
previousIndex = -1; should be -1
hasPrevious = false; should be false

next = Jamie; should be Jamie
nextIndex = 1; should be 1
hasNext = true; should be true

previousIndex 0; should be 0
hasPrevious   true; should be true
previous      Jamie; should be Jamie
nextIndex     0; should be 0
hasNext       true; should be true
next          Jamie; should be Jamie
Testing ListIterator's set method:
Replace entry that next() just returned (Jamie) with Bob:
Display using getEntry(): List should be: Bob Doug Jill, size = 3
Bob, Doug, Jill, 
previousIndex 0    should be 0
hasPrevious   true should be true
nextIndex     1    should be 1
hasNext       true should be true
Testing ListIterator's add method:
Before add
nextIndex     1 should be 1
previousIndex 0 should be 0
add Kerry before (or at) position 2
Display using getEntry(): List should be: Bob Kerry Doug Jill, size = 4
Bob, Kerry, Doug, Jill, 
After add
nextIndex     2 should be 2
previousIndex 1 should be 1
next          Doug should be Doug
After removing Doug
Display using getEntry(): List should be: Bob Kerry Jill, size = 3
Bob, Kerry, Jill, 
Clear the list
Display using getEntry(): List should be: Bob Kerry Doug Jill, size = 4
Bob, Kerry, Doug, Jill, 
Traversing Bob then Kerry, then previous() Kerry, then remove() Kerry
next() Bob
next() Kerry
previous() Kerry
Display using getEntry(): List should be: Bob Doug Jill, size = 3
Bob, Doug, Jill, 
================
testIllegalOps()
Display using getEntry(): List should be: Jamie Doug Jill, size = 3
Jamie, Doug, Jill, 
The sequence next, set, set, remove is legal.
next() Jamie
Display using getEntry(): List should be: XX Doug Jill, size = 3
XX, Doug, Jill, 
Set to XX to XX again, then remove, which is legal
Display using getEntry(): List should be: Doug Jill, size = 2
Doug, Jill, 
The following sequence is illegal and causes an exception: next, set, add, set

Exception in thread "main" java.lang.IllegalStateException: Illegal call to set(); next() or previous() not called, OR add() or remove() called since then.
	at ListPackage.CompletedAListWithListIterator$ListIteratorForAList.set(CompletedAListWithListIterator.java:159)
	at ListPackage.CompletedAListWithListIterator$ListIteratorForAList.set(CompletedAListWithListIterator.java:1)
	at AListWithListIteratorTestDriver.testIllegalOps(AListWithListIteratorTestDriver.java:290)
	at AListWithListIteratorTestDriver.main(AListWithListIteratorTestDriver.java:17)

 */
