package RecursionPackage;

/**
 * Test displayArray() method with arrays of various types
 * 
 * @author mhrybyk
 *
 */
public class DisplayArrayUsingRecursionDemo {

	public static void main(String[] args) {
		String[] strings = { "a", "b", "c", "d", "e" };
		displayArray(strings, 2, 4);
		displayArrayFromMiddle(strings, 2, 4);

		Integer[] integers = { 5, 7, 9, 11, 16, 3, 4, 9 };
		displayArray(integers, 1, integers.length - 1);
		displayArrayFromMiddle(integers, 1, integers.length - 1);
	}

	/**
	 * Displays the integers in an array.
	 * 
	 * @param array An array of integers.
	 * @param first The index of the first integer displayed.
	 * @param last  The index of the last integer displayed, 0 <= first <= last <
	 *              array.length.
	 * @author Frank M. Carrano, Timothy M. Henry
	 * @version 5.0
	 * 
	 * @author mhrybyk
	 * 
	 * Made it generic and added ending newline
	 * @param <T>
	 */
	public static <T> void displayArray(T[] array, int first, int last) {
		System.out.print(array[first] + " ");
		if (first < last)
			displayArray(array, first + 1, last);
		else
			System.out.println(); // we are at the end
	}

	/**
	 * Display an array from the middle using divide and conquer
	 * @param array
	 * @param first
	 * @param last
	 */
	public static <T> void displayArrayFromMiddle(T[] array, int first, int last) {
		// need a helper methods just so we can add a newline at the end
		displayArrayFromMiddleHelper(array, first, last);
		System.out.println();
	}
	
	/**
	 * Recursive helper method to display an array from the middle using 
	 * divide and conquer.
	 * @param array
	 * @param first
	 * @param last
	 */
	private static <T> void displayArrayFromMiddleHelper(T[] array, int first, int last) {
		if (first == last)
			System.out.print(array[first] + " ");
		else {
			int mid = first + ((last - first) / 2);
			displayArrayFromMiddleHelper(array, first, mid);
			displayArrayFromMiddleHelper(array, mid + 1, last);
		}
	}
}
