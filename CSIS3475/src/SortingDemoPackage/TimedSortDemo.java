package SortingDemoPackage;

import ListPackage.*;

/**
 * Demonstrates use of sort algorithms. 
 * 
 * Change the SortUtilities method to demonstrate a particular algorithm.
 * @author mhrybyk
 *
 */

public class TimedSortDemo {

	public static void main(String[] args) {

		// make two lists of integers, each the same, so we can compare sort methods
		long startTime;
		long endTime;
		int listSize = 5000;
		int displaySize = 20;
		
		ListInterface<String> originalListOfIntegers = new CompletedAList<>(listSize);
		ListInterface<String> aListOfIntegers = new CompletedAList<>(listSize);
		
//		// as noted, the sort utility methods are very inefficient using LList.
//		// do not use for large lists
//		ListInterface<String> originalListOfIntegers = new CompletedLList<>();
//		ListInterface<String> aListOfIntegers = new CompletedLList<>();

			
		// first generate a list of integers, and display them
		
		DemoUtilities.generateListOfNumbers(originalListOfIntegers, listSize, listSize);
		DemoUtilities.displayTruncated(originalListOfIntegers, "Original List of random Integers", displaySize);
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);	
		startTime = System.currentTimeMillis();
		SortUtilities.selectionSort(aListOfIntegers, 0, aListOfIntegers.size() - 1);	
		endTime = System.currentTimeMillis();
		DemoUtilities.displayTruncated(aListOfIntegers, "Integers Selection Sort, time = " + (endTime - startTime), displaySize);
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		startTime = System.currentTimeMillis();
		SortUtilities.insertionSort(aListOfIntegers, 0, aListOfIntegers.size() - 1);		
		endTime = System.currentTimeMillis();
		DemoUtilities.displayTruncated(aListOfIntegers, "Integers Insertion Sort, time = " + (endTime - startTime), displaySize);
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		startTime = System.currentTimeMillis();
		SortUtilities.recursiveInsertionSort(aListOfIntegers, 0, aListOfIntegers.size() - 1);		
		endTime = System.currentTimeMillis();
		DemoUtilities.displayTruncated(aListOfIntegers, "Integers Recursive Insertion Sort, time = " + (endTime - startTime), displaySize);	

		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		startTime = System.currentTimeMillis();
		SortUtilities.quickSort(aListOfIntegers, 0, aListOfIntegers.size() - 1);		
		endTime = System.currentTimeMillis();
		DemoUtilities.displayTruncated(aListOfIntegers, "Integers Quick Sort, time = " + (endTime - startTime), displaySize);	
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		startTime = System.currentTimeMillis();
		SortUtilities.mergeSort(aListOfIntegers, 0, aListOfIntegers.size() - 1);		
		endTime = System.currentTimeMillis();
		DemoUtilities.displayTruncated(aListOfIntegers, "Integers Merge Sort, time = " + (endTime - startTime), displaySize);	
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		startTime = System.currentTimeMillis();
		SortUtilities.sortUsingLibrary(aListOfIntegers, 0, aListOfIntegers.size() - 1);		
		endTime = System.currentTimeMillis();
		DemoUtilities.displayTruncated(aListOfIntegers, "Integers Library Sort, time = " + (endTime - startTime), displaySize);	
		
	}

}
