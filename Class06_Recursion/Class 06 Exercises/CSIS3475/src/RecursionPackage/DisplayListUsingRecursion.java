package RecursionPackage;
import java.util.Iterator;

import ListPackage.*;
import ListWithIteratorsPackage.*;

/**
 * Display a list using recursion using an iterator or an index to move through the list
 * 
 * @author mhrybyk
 *
 */
public class DisplayListUsingRecursion {

	public static void main(String[] args) {
		
		// create a list of strings and traverse forwards and backwards
		
		ListWithIteratorInterface<String> stringsList = new CompletedLListWithIterator<>();
//		ListWithIteratorInterface<String> stringsList = new CompletedAListWithIterator<>();
//		ListWithIteratorInterface<String> stringsList = new LListWithIterator<>();
//		ListWithIteratorInterface<String> stringsList = new AListWithIterator<>();
		
		stringsList.add("a");
		stringsList.add("b");		
		stringsList.add("c");
		stringsList.add("d");
		traverseWithIterator(stringsList);
		traverseBackwardWithIterator(stringsList);
		
		// create a list of integers and traverse forwards and backwards
		
		ListWithIteratorInterface<Integer> integersList = new CompletedLListWithIterator<>();
//		ListWithIteratorInterface<Integer> integersList = new CompletedAListWithIterator<>();
//		ListWithIteratorInterface<Integer> integersList = new LListWithIterator<>();
//		ListWithIteratorInterface<Integer> integersList = new AListWithIterator<>();
		
		integersList.add(1);
		integersList.add(2);
		integersList.add(3);
		integersList.add(4);
		traverseWithIterator(integersList);
		traverseBackwardWithIterator(integersList);
		
		// create another list of integers and traverse forwards and backwards
		
		ListInterface<Integer> anotherIntegerList = new CompletedLList<>();
//		ListWithIteratorInterface<Integer> anotherIntegerList = new CompletedAList<>();
//		ListWithIteratorInterface<Integer> anotherIntegerList = new LList<>();
//		ListWithIteratorInterface<Integer> anotherIntegerList = new AList<>();
		
		anotherIntegerList.add(11);
		anotherIntegerList.add(12);
		anotherIntegerList.add(13);
		anotherIntegerList.add(14);
		traverseWithIndex(anotherIntegerList);
		traverseWithIndexBackward(anotherIntegerList);
	}



	/**
	 * Traverse the list forwards and display each element
	 * @param <T>
	 * @param list
	 */
	static public <T> void traverseWithIterator(ListWithIteratorInterface<T> list) {
		System.out.println("Traversing list forward");
		Iterator<T> iterator = list.getIterator();
		displayWithIterator(iterator);
		System.out.println();	
	}

	/**
	 * Display a list's data and an iterator, using
	 * recursion to walk the chain from beginning of the list recursively.
	 * @param <T>
	 * @param iterator
	 */
	static public <T> void displayWithIterator(Iterator<T> iterator) {
		if (iterator.hasNext()) {
			T data = iterator.next();  // get data
			System.out.print(data + " "); // display data
			displayWithIterator(iterator); // Display rest of the list
		}		
	}
	
	/**
	 * Traverse the list backwards and display each element
	 * This acts like a stack.
	 * @param <T>
	 * @param list
	 */
	static public <T> void traverseBackwardWithIterator(ListWithIteratorInterface<T> list) {
		System.out.println("Traversing list backward");
		Iterator<T> iterator = list.getIterator();
		displayWithIteratorBackward(iterator);
		System.out.println();	
	}

	/**
	 * Display the list backwards, using an iterator to get the next element, then recursively
	 * call until there are no more elements.
	 * @param <T>
	 * @param iterator
	 */
	private static <T> void displayWithIteratorBackward(Iterator<T> iterator) {
		if (iterator.hasNext()) {
			T data = iterator.next();  // get data
			displayWithIteratorBackward(iterator); // display rest of the list
			System.out.print(data + " "); // display data 
		}
		
	}
	
	// the following are the same except using an index to traverse
	
	private static <T> void traverseWithIndex(ListInterface<T> list) {
		System.out.println("Traversing list with index forward");
		int i = 0;
		displayWithIndex(list, i);
		System.out.println();
		
	}

	private static <T> void displayWithIndex(ListInterface<T> list, int i) {
		if(i < list.size()) {
			T data = list.getEntry(i);  // get data
			System.out.print(data + " "); // display data
			displayWithIndex(list, i + 1); // Display rest of the list
		}
		
	}
	
	private static <T> void traverseWithIndexBackward(ListInterface<T> list) {
		System.out.println("Traversing list with index backward");
		int i = 0;
		displayWithIndexBackward(list, i);
		System.out.println();
		
	}

	private static <T> void displayWithIndexBackward(ListInterface<T> list, int i) {
		if(i < list.size()) {
			T data = list.getEntry(i);  // get data
			displayWithIndexBackward(list, i + 1); // Display rest of the list
			System.out.print(data + " "); // display data
		}	
	}
}
