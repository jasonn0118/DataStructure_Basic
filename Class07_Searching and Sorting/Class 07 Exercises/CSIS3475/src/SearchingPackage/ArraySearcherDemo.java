package SearchingPackage;

import java.util.Arrays;

/**
 * A driver that demonstrates the class ArraySearcher.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class ArraySearcherDemo {
	public static void main(String[] args) {
		Integer[] unsortedArray = { 20, 24, 4, 12, 8, 14 };
		Integer[] sortedArray = { 4, 8, 12, 14, 20, 24 };

		System.out.println("Iterative sequential search of an unsorted array: ");
		ArraySearcher.display(unsortedArray);

		System.out.println(
				"Is 4 in the array? " + ArraySearcher.searchUnsortedArrayIterative(unsortedArray, 4) + " (should be true)");
		System.out.println("Is 24 in the array? " + ArraySearcher.searchUnsortedArrayIterative(unsortedArray, 24)
				+ " (should be true)");
		System.out.println("Is 14 in the array? " + ArraySearcher.searchUnsortedArrayIterative(unsortedArray, 14)
				+ " (should be true)");
		System.out.println("Is 10 in the array? " + ArraySearcher.searchUnsortedArrayIterative(unsortedArray, 10)
				+ " (should be false)");

		System.out.println("\nRecursive sequential search of an unsorted array: ");
		ArraySearcher.display(unsortedArray);
		System.out.println(
				"Is 4 in the array? " + ArraySearcher.searchUnsortedArrayRecursive(unsortedArray, 4) + " (should be true)");
		System.out.println("Is 24 in the array? " + ArraySearcher.searchUnsortedArrayRecursive(unsortedArray, 24)
				+ " (should be true)");
		System.out.println("Is 14 in the array? " + ArraySearcher.searchUnsortedArrayRecursive(unsortedArray, 14)
				+ " (should be true)");
		System.out.println("Is 10 in the array? " + ArraySearcher.searchUnsortedArrayRecursive(unsortedArray, 10)
				+ " (should be false)");

		System.out.println("\nRecursive binary search of a sorted array: ");
		ArraySearcher.display(sortedArray);

		System.out.println(
				"Is 4 in the array? " + ArraySearcher.searchSortedArrayRecursive(sortedArray, 4) + " (should be true)");
		System.out.println(
				"Is 24 in the array? " + ArraySearcher.searchSortedArrayRecursive(sortedArray, 24) + " (should be true)");
		System.out.println(
				"Is 14 in the array? " + ArraySearcher.searchSortedArrayRecursive(sortedArray, 14) + " (should be true)");
		System.out.println(
				"Is 3 in the array? " + ArraySearcher.searchSortedArrayRecursive(sortedArray, 3) + " (should be false)");
		System.out.println(
				"Is 15 in the array? " + ArraySearcher.searchSortedArrayRecursive(sortedArray, 15) + " (should be false)");
		System.out.println(
				"Is 30 in the array? " + ArraySearcher.searchSortedArrayRecursive(sortedArray, 30) + " (should be false)");
		
		System.out.println("\nJava library sequential search of a sorted array: ");
		ArraySearcher.display(sortedArray);
		System.out.println(
				"Is 4 in the array? " + Arrays.binarySearch(sortedArray, 4) + " (should be 0 position)");
		System.out.println(
				"Is 24 in the array? " + Arrays.binarySearch(sortedArray, 24) + " (should be 5 position)");
		System.out.println(
				"Is 14 in the array? " + Arrays.binarySearch(sortedArray, 14) + " (should be 3 position)");
		System.out.println(
				"Is 3 in the array? " + Arrays.binarySearch(sortedArray, 3) + " (should be -1 insertion)");
		System.out.println(
				"Is 15 in the array? " + Arrays.binarySearch(sortedArray, 15) + " (should be -5 insertion)");
		System.out.println(
				"Is 30 in the array? " + Arrays.binarySearch(sortedArray, 30) + " (should be -7 insertion)");
	} 
} 
/*
Iterative sequential search of an unsorted array: 
The array contains the following entries: 20 24 4 12 8 14 
Is 4 in the array? true (should be true)
Is 24 in the array? true (should be true)
Is 14 in the array? true (should be true)
Is 10 in the array? false (should be false)

Recursive sequential search of an unsorted array: 
The array contains the following entries: 20 24 4 12 8 14 
Is 4 in the array? true (should be true)
Is 24 in the array? true (should be true)
Is 14 in the array? true (should be true)
Is 10 in the array? false (should be false)

Recursive binary search of a sorted array: 
The array contains the following entries: 4 8 12 14 20 24 
Is 4 in the array? true (should be true)
Is 24 in the array? true (should be true)
Is 14 in the array? true (should be true)
Is 3 in the array? false (should be false)
Is 15 in the array? false (should be false)
Is 30 in the array? false (should be false)

Java library sequential search of a sorted array: 
The array contains the following entries: 4 8 12 14 20 24 
Is 4 in the array? 0 (should be 0 position)
Is 24 in the array? 5 (should be 5 position)
Is 14 in the array? 3 (should be 3 position)
Is 3 in the array? -1 (should be -1 insertion)
Is 15 in the array? -5 (should be -5 insertion)
Is 30 in the array? -7 (should be -7 insertion)

 */
