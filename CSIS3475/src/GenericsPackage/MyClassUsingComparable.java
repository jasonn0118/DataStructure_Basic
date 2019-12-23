package GenericsPackage;

/**
 * Utility class to find the minimum of an array 
 * Demonstrates use of wildcard
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class MyClassUsingComparable {
	public static <T extends Comparable<T>> T arrayMinimum(T[] anArray)
//	public static <T extends Comparable<? super T>> T arrayMinimum(T[] anArray)
	{
		// set first element to minimum
		// if a new minimum is found, set minimum to that element
		
		T minimum = anArray[0];
		for (T arrayEntry : anArray) {
			if (arrayEntry.compareTo(minimum) < 0)
				minimum = arrayEntry;
		} 

		return minimum;
	} 

} 
