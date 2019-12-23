package Task1_SortingAlgorithmEvaluation;

import ListPackage.*;
import SortingDemoPackage.*;

/**
 * Demonstrates use of sort algorithms. 
 * 
 * Change the SortUtilities method to demonstrate a particular algorithm.
 * @author mhrybyk
 *
 */

public class SortMethodEvaluation {

	public static void main(String[] args) {

		// make two lists of integers, each the same, so we can compare sort methods
		long startTime;
		long endTime;
		
		int startingInteger = 10000;
		
		int[] testListSizes = {100, 200, 400, 800, 1600, 3200, 6400};
		
		
		for(int size : testListSizes) {
			
			// create a list of random numbers of a a particular size, and copy to the test list
			
			// use ArrayList inside of ListUsingLibraryLinkedList
			
			ListInterface<String> originalListOfIntegers = new ListUsingLibraryLinkedList<>();
			ListInterface<String> testListOfIntegers = new ListUsingLibraryLinkedList<>();
			System.out.println("Testing sorting of LibraryLinkedList size =  " + size);
			
//			ListInterface<String> originalListOfIntegers = new AList<>();
//			ListInterface<String> testListOfIntegers = new AList<>();
//			System.out.println("Testing sorting of AList size =  " + size);
			
			// generate the list of numbers
			
			DemoUtilities.generateListOfNumbers(originalListOfIntegers, startingInteger, size);
			
			// sort test for each sorting method
			// first copy the original list of random numbers to the test list
			// set the starting time
			// run the sort method on the test list
			// get the end time
			// display the elapsed time result
			// do the same for the sort method on the already sorted list
			
			//SELECTION SORT
			DemoUtilities.copyListOfNumbers(originalListOfIntegers, testListOfIntegers);
			startTime = System.nanoTime();
			SortUtilities.selectionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Selection Sort Time");
			
			startTime = System.nanoTime();
			SortUtilities.selectionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Selection Sort Time on sorted list");
			
			// do the same for Insertion Sort, Shell Sort, Merge Sort, and Quick Sort here
			
			//INSERTION SORT
			startTime = System.nanoTime();
			SortUtilities.insertionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Insertion Sort Time");
			
			startTime = System.nanoTime();
			SortUtilities.insertionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Insertion Sort Time on sorted list");
			
			//SHELL SHORT
			startTime = System.nanoTime();
			SortUtilities.shellSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Shell Sort Time");
			
			startTime = System.nanoTime();
			SortUtilities.shellSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Shell Sort Time on sorted list");
			
			//MERGE SORT
			startTime = System.nanoTime();
			SortUtilities.mergeSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Merge Sort Time");
			
			startTime = System.nanoTime();
			SortUtilities.mergeSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Merge Sort Time on sorted list");
			
			//QUICK SORT
			startTime = System.nanoTime();
			SortUtilities.quickSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Quick Sort Time");
			
			startTime = System.nanoTime();
			SortUtilities.quickSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Quick Sort Time on sorted list");
			
			//Commented out for the Testing sorting of LibraryLinkedList below.
//			//RECURSIVE SELECTION SORT
//			startTime = System.nanoTime();
//			SortUtilities.recursiveSelectionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
//			endTime = System.nanoTime();
//			System.out.println(elapsedTime(startTime, endTime) + " Recursive Selection Sort Time");
//			
//			startTime = System.nanoTime();
//			SortUtilities.recursiveSelectionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
//			endTime = System.nanoTime();
//			System.out.println(elapsedTime(startTime, endTime) + " Recursive Selection Sort Time on sorted list");
//			
//			//RECURSIVE INSERTION SORT
//			startTime = System.nanoTime();
//			SortUtilities.recursiveInsertionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
//			endTime = System.nanoTime();
//			System.out.println(elapsedTime(startTime, endTime) + " Recursive Insertion Sort Time");
//			
//			startTime = System.nanoTime();
//			SortUtilities.recursiveInsertionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
//			endTime = System.nanoTime();
//			System.out.println(elapsedTime(startTime, endTime) + " Recursive Insertion Sort Time on sorted list");
//			
			//SORT USING LIBRARY
			startTime = System.nanoTime();
			SortUtilities.sortUsingLibrary(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Using Library Sort Time");
			
			startTime = System.nanoTime();
			SortUtilities.sortUsingLibrary(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println(elapsedTime(startTime, endTime) + " Using Library Sort Time on sorted list");
			System.out.println("------------------------");
			
			
			
			
			
		}
	
		
	}
	
	private static String elapsedTime(double start, double end) {
		return String.format("%12.5fms", (end - start)/1000000);
	}

}
