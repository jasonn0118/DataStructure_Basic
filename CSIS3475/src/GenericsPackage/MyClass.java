package GenericsPackage;

/**
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class MyClass {
	// First draft and INCORRECT:
	public static <T> T arrayMinimum(T[] anArray) {
		T minimum = anArray[0];
		for (T arrayEntry : anArray) {
// this produces a syntax error as you need Comparable
//         if (arrayEntry.compareTo(minimum) < 0)
//            minimum = arrayEntry;
		} // end for

		return minimum;
	} // end arrayMinimum
} // end MyClass
