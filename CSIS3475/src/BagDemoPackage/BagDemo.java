package BagDemoPackage;

import BagPackage.*;

/**
 * A test of all methods in an implementation of the BagInterface.
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Made this more general, applied to all implementations
 */
public class BagDemo {
	public static void main(String[] args) {
		// A bag that is not full
//		BagInterface<String> aBag = new CompletedFixedSizeArrayBag<>();
//		BagInterface<String> aBag = new CompletedLinkedBagWithNodeMethods<>();
//		BagInterface<String> aBag = new CompletedLinkedBag<>();
//		BagInterface<String> aBag = new CompletedResizableArrayBag<>();
		
		BagInterface<String> aBag = new FixedSizeArrayBag<>();
//		BagInterface<String> aBag = new LinkedBagWithNodeMethods<>();
//		BagInterface<String> aBag = new LinkedBag<>();
//		BagInterface<String> aBag = new ResizableArrayBag<>();

		
		System.out.println("Testing an initially empty bag:");

		// Removing a string from an empty bag:
		String[] testStrings1 = { "", "B" };
		testRemove(aBag, testStrings1);

		testFrequency(aBag, testStrings1);
		testContains(aBag, testStrings1);

		// Adding strings
		String[] contentsOfBag1 = { "A", "A", "B", "A", "C", "A" };
		testAdd(aBag, contentsOfBag1);

		testIsEmpty(aBag, false);
		String[] testStrings2 = { "A", "B", "C", "D", "Z" };
		testFrequency(aBag, testStrings2);
		testContains(aBag, testStrings2);

		// Removing strings
		String[] testStrings3 = { "", "B", "A", "C", "Z" };
		testRemove(aBag, testStrings3);

		System.out.println("\nClearing the bag:");
		aBag.clear();
		testIsEmpty(aBag, true);
		displayBag(aBag);

		// A bag that will be full

//		aBag = new CompletedLinkedBagWithNodeMethods<>();
//		aBag = new CompletedLinkedBag<String>();
//		aBag = new CompletedFixedSizeArrayBag<String>(7);
//		aBag = new CompletedResizableArrayBag<>();
		
		aBag = new FixedSizeArrayBag<String>(7);
//		aBag = new LinkedBagWithNodeMethods<>();
//		aBag = new LinkedBag<>();
//		aBag = new ResizableArrayBag<>();
		
		System.out.println("\nA new empty bag:");

		testIsEmpty(aBag, true);
		testFrequency(aBag, testStrings1);
		testContains(aBag, testStrings1);
		// Removing a string from an empty bag:
		testRemove(aBag, testStrings1);

		// Adding strings
		String[] contentsOfBag2 = { "A", "B", "A", "C", "B", "C", "D" };
		testAdd(aBag, contentsOfBag2);
		
		// Tests on a bag that is full
		testIsEmpty(aBag, false);
		testFrequency(aBag, testStrings2);
		testContains(aBag, testStrings2);
		
		// Removing strings
		System.out.println("\nRemoving strings:");
		testRemove(aBag, testStrings3);

		System.out.println("\nClearing the bag:");
		aBag.clear();

		testIsEmpty(aBag, true);
		displayBag(aBag);
	}

	/**
	 * Adds an array of strings to the bag
	 * 
	 * @param aBag    the bag
	 * @param content array of strings
	 */
	private static void testAdd(BagInterface<String> aBag, String[] content) {
		System.out.print("Adding the following strings to the bag: ");
		for (int index = 0; index < content.length; index++) {
			if (aBag.add(content[index]))
				System.out.print(content[index] + " ");
			else
				System.out.print("Unable to add " + content[index] + " to the bag.");
		} 
		System.out.println();

		displayBag(aBag);
	} 

	/**
	 * Test remove() methods
	 * 
	 * @param aBag  the bag
	 * @param tests strings to remove
	 */
	private static void testRemove(BagInterface<String> aBag, String[] tests) {
		System.out.println("Testing the two remove methods:");
		for (int index = 0; index < tests.length; index++) {
			String aString = tests[index];
			if (aString.equals("") || (aString == null)) {
				// test remove()
				System.out.println("Removing a null or empty string from the bag:");
				String removedString = aBag.remove();
				System.out.println("remove() returns " + removedString);
			} else {
				// Test remove(aString)
				System.out.println("Removing \"" + aString + "\" from the bag:");
				boolean result = aBag.remove(aString);
				System.out.println("remove(\"" + aString + "\") returns " + result);
			}

			displayBag(aBag);
		}
	}

	/**
	 * Tests isEmpty methods. Basically a truth table of all possibilities
	 * 
	 * @param aBag          the bag to test
	 * @param correctResult the correct result should be true or false
	 */
	private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult) {
		System.out.print("Testing isEmpty() with ");
		if (correctResult)
			System.out.println("an empty bag:");
		else
			System.out.println("a bag that is not empty:");

		System.out.print("isEmpty() finds the bag is ");
		if (correctResult && aBag.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aBag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");
	}

	/**
	 * Tests getFrequencyOf() method against an array of strings
	 * @param aBag the bag
	 * @param tests an array of strings to test
	 */
	private static void testFrequency(BagInterface<String> aBag, String[] tests) {
		System.out.println("\nTesting the method getFrequencyOf:");
		for (int index = 0; index < tests.length; index++)
			System.out
					.println("In this bag, the count of " + tests[index] + " is " + aBag.getFrequencyOf(tests[index]));
	} 
	
	/**
	 * Tests contains() method against an array of strings
	 * @param aBag the bag
	 * @param tests an array of strings to test
	 */
	private static void testContains(BagInterface<String> aBag, String[] tests) {
		System.out.println("\nTesting the method contains:");
		for (int index = 0; index < tests.length; index++)
			System.out.println("Does this bag contain " + tests[index] + "? " + aBag.contains(tests[index]));
	} 

	/**
	 * Display the bag using toArray method
	 * 
	 * @param aBag
	 */
	private static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag contains " + aBag.size() + " string(s), as follows:");
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++) {
			System.out.print(bagArray[index] + " ");
		}

		System.out.println();
	} 
} 

/*
Testing an initially empty bag:
Testing the two remove methods:
Removing a null or empty string from the bag:
remove() returns null
The bag contains 0 string(s), as follows:

Removing "B" from the bag:
remove("B") returns false
The bag contains 0 string(s), as follows:


Testing the method getFrequencyOf:
In this bag, the count of  is 0
In this bag, the count of B is 0

Testing the method contains:
Does this bag contain ? false
Does this bag contain B? false
Adding the following strings to the bag: A A B A C A 
The bag contains 6 string(s), as follows:
A A B A C A 
Testing isEmpty() with a bag that is not empty:
isEmpty() finds the bag is not empty: OK.

Testing the method getFrequencyOf:
In this bag, the count of A is 4
In this bag, the count of B is 1
In this bag, the count of C is 1
In this bag, the count of D is 0
In this bag, the count of Z is 0

Testing the method contains:
Does this bag contain A? true
Does this bag contain B? true
Does this bag contain C? true
Does this bag contain D? false
Does this bag contain Z? false
Testing the two remove methods:
Removing a null or empty string from the bag:
remove() returns A
The bag contains 5 string(s), as follows:
A A B A C 
Removing "B" from the bag:
remove("B") returns true
The bag contains 4 string(s), as follows:
A A C A 
Removing "A" from the bag:
remove("A") returns true
The bag contains 3 string(s), as follows:
A A C 
Removing "C" from the bag:
remove("C") returns true
The bag contains 2 string(s), as follows:
A A 
Removing "Z" from the bag:
remove("Z") returns false
The bag contains 2 string(s), as follows:
A A 

Clearing the bag:
Testing isEmpty() with an empty bag:
isEmpty() finds the bag is empty: OK.
The bag contains 0 string(s), as follows:


A new empty bag:
Testing isEmpty() with an empty bag:
isEmpty() finds the bag is empty: OK.

Testing the method getFrequencyOf:
In this bag, the count of  is 0
In this bag, the count of B is 0

Testing the method contains:
Does this bag contain ? false
Does this bag contain B? false
Testing the two remove methods:
Removing a null or empty string from the bag:
remove() returns null
The bag contains 0 string(s), as follows:

Removing "B" from the bag:
remove("B") returns false
The bag contains 0 string(s), as follows:

Adding the following strings to the bag: A B A C B C D 
The bag contains 7 string(s), as follows:
A B A C B C D 
Testing isEmpty() with a bag that is not empty:
isEmpty() finds the bag is not empty: OK.

Testing the method getFrequencyOf:
In this bag, the count of A is 2
In this bag, the count of B is 2
In this bag, the count of C is 2
In this bag, the count of D is 1
In this bag, the count of Z is 0

Testing the method contains:
Does this bag contain A? true
Does this bag contain B? true
Does this bag contain C? true
Does this bag contain D? true
Does this bag contain Z? false

Removing strings:
Testing the two remove methods:
Removing a null or empty string from the bag:
remove() returns D
The bag contains 6 string(s), as follows:
A B A C B C 
Removing "B" from the bag:
remove("B") returns true
The bag contains 5 string(s), as follows:
A C A C B 
Removing "A" from the bag:
remove("A") returns true
The bag contains 4 string(s), as follows:
B C A C 
Removing "C" from the bag:
remove("C") returns true
The bag contains 3 string(s), as follows:
B C A 
Removing "Z" from the bag:
remove("Z") returns false
The bag contains 3 string(s), as follows:
B C A 

Clearing the bag:
Testing isEmpty() with an empty bag:
isEmpty() finds the bag is empty: OK.
The bag contains 0 string(s), as follows:


*/
