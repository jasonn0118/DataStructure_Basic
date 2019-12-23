package GenericsPackage;

/**
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class DisplayArrayDemo {
	public static <T> void displayArray(T[] anArray) {
		for (T arrayEntry : anArray) {
			System.out.print(arrayEntry);
			System.out.print(' ');
		} 
		System.out.println();
	} 

	public static void main(String args[]) {
		String[] stringArray = { "apple", "banana", "carrot", "dandelion" };
		System.out.print("stringArray contains ");
		displayArray(stringArray);

		Character[] characterArray = { 'a', 'b', 'c', 'd' };
		System.out.print("characterArray contains ");
		displayArray(characterArray);
	} 
} 
/*
 stringArray contains apple banana carrot dandelion
 characterArray contains a b c d
*/
