package SortingDemoPackage;

import ListPackage.*;
import SortedListPackage.InsertionSortAList;
import SortedListPackage.InsertionSortLList;
import SortedListPackage.ListWithSortInterface;

/**
 * Demonstrates use of sort algorithms. 
 * 
 * Change the SortUtilities method to demonstrate a particular algorithm.
 * @author mhrybyk
 *
 */

public class SortDemo {

	public static void main(String[] args) {

		// make two lists of integers, each the same, so we can compare sort methods
		
		ListInterface<String> originalListOfIntegers = new AList<>();
		ListInterface<String> aListOfIntegers = new AList<>();
		ListWithSortInterface<String> sortAListOfIntegers = new InsertionSortAList<>();
		
		// need to call the internal sort for this object
		InsertionSortLList<String> linkedGroupListOfIntegers = new InsertionSortLList<>();	
			
		// first generate a list of integers, and display them
		
		DemoUtilities.generateListOfNumbers(originalListOfIntegers, 10, 8);
		DemoUtilities.display(originalListOfIntegers, "Original List of random Integers");
		System.out.println();
		
		// for each sort, copy the original list of random numbers to the AList, then sort
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		SortUtilities.selectionSort(aListOfIntegers, 0, originalListOfIntegers.size() - 1);	
		DemoUtilities.display(aListOfIntegers, "Integers Selection Sort");
		System.out.println();
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		SortUtilities.insertionSort(aListOfIntegers, 0, originalListOfIntegers.size() - 1);	
		DemoUtilities.display(aListOfIntegers, "Integers Insertion Sort");
		System.out.println();
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		SortUtilities.recursiveInsertionSort(aListOfIntegers, 0, originalListOfIntegers.size() - 1);	
		DemoUtilities.display(aListOfIntegers, "Integers Recursive Insertion Sort");
		System.out.println();
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		SortUtilities.sortUsingLibrary(aListOfIntegers, 0, originalListOfIntegers.size() - 1);			
		DemoUtilities.display(aListOfIntegers, "Integers Java Library Sort");			
		System.out.println();
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		SortUtilities.quickSort(aListOfIntegers, 0, originalListOfIntegers.size() - 1);	
		DemoUtilities.display(aListOfIntegers, "Integers Quick Sort");	
		System.out.println();
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		SortUtilities.mergeSort(aListOfIntegers, 0, originalListOfIntegers.size() - 1);	
		DemoUtilities.display(aListOfIntegers, "Integers Merge Sort");	
		System.out.println();
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, linkedGroupListOfIntegers);
		linkedGroupListOfIntegers.insertionSort();		
		DemoUtilities.display(linkedGroupListOfIntegers, "Integers InsertionSortLList");
		System.out.println();
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, sortAListOfIntegers);
		sortAListOfIntegers.sort(0, sortAListOfIntegers.size() - 1);;		
		DemoUtilities.display(sortAListOfIntegers, "Integers InsertionSortAList");
	}

}
