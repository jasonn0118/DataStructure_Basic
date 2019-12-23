package SearchingPackage;

/**
 * A class of static methods for searching an array of objects. The objects in a
 * sorted array must be Comparable.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class ArraySearcher {
	// Segment 19.3
	/**
	 * Searches an unsorted array for anEntry iteratively.
	 * 
	 * @param anArray
	 * @param anEntry
	 * @return
	 */
	public static <T> boolean searchUnsortedArrayIterative(T[] anArray, T anEntry) {
		boolean found = false;
		int index = 0;

		while (!found && (index < anArray.length)) {
			if (anEntry.equals(anArray[index]))
				found = true;
			index++;
		}

		return found;
	}

	// Segment 19.6

	/**
	 * Searches an unsorted array for anEntry by calling a recursive private method.
	 * 
	 * @param anArray
	 * @param anEntry
	 * @return
	 */
	public static <T> boolean searchUnsortedArrayRecursive(T[] anArray, T anEntry) {
		return search(anArray, 0, anArray.length - 1, anEntry);
	}

	/**
	 * Recursively searches anArray[first] through anArray[last] for desiredItem.
	 * first >= 0 and < anArray.length. 
	 * last >= 0 and < anArray.length.
	 * 
	 * @param anArray
	 * @param first
	 * @param last
	 * @param desiredItem
	 * @return
	 */
	private static <T> boolean search(T[] anArray, int first, int last, T desiredItem) {
		boolean found = false;

		if (first > last)
			found = false; // No elements to search
		else if (desiredItem.equals(anArray[first]))
			found = true;
		else
			// go to next one
			found = search(anArray, first + 1, last, desiredItem);

		return found;
	} 

	// Segment 19.13
	/**
	 * Searches a sorted array for anEntry by calling a recursive private method.
	 * @param anArray
	 * @param anEntry
	 * @return
	 */
	public static <T extends Comparable<T>> boolean searchSortedArrayRecursive(T[] anArray, T anEntry) {
		return binarySearch(anArray, 0, anArray.length - 1, anEntry);
	} 

	/**
	 * Searches anArray[first] through anArray[last] for desiredItem.
	 * @param anArray
	 * @param first first >= 0 and < anArray.length.
	 * @param last last >= 0 and < anArray.length
	 * @param desiredItem
	 * @return
	 */
	private static <T extends Comparable<T>> boolean binarySearch(T[] anArray, int first, int last, T desiredItem) {
		boolean found;
		
		// calculate midpoint
		int mid = first + (last - first) / 2;

		// if we are at the end we didn't find it
		// if we found it, exit
		// otherwise divide and call recursively depending on comparison
		if (first > last)
			found = false;
		else if (desiredItem.equals(anArray[mid]))
			found = true;
		else if (desiredItem.compareTo(anArray[mid]) < 0)
			found = binarySearch(anArray, first, mid - 1, desiredItem);
		else
			found = binarySearch(anArray, mid + 1, last, desiredItem);

		return found;
	} 

	public static <T> void display(T[] anArray) {
		System.out.print("The array contains the following entries: ");
		for (int index = 0; index < anArray.length; index++) {
			System.out.print(anArray[index] + " ");
		}

		System.out.println();
	}
}
