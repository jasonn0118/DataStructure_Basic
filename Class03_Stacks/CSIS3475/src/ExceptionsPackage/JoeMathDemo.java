package ExceptionsPackage;

/**
 * A demonstration of a runtime exception using the class JoeMath.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class JoeMathDemo {
	public static void main(String[] args) {
		
		// negative numbers should have i appended to the result
		
		System.out.print("The square root of 9 is ");
		System.out.println(JoeMath.squareRoot(9.0));

		System.out.print("The square root of -9 is ");
		System.out.println(JoeMath.squareRoot(-9.0));

		System.out.print("The square root of 16 is ");
		System.out.println(JoeMath.squareRoot(16.0));

		System.out.print("The square root of -16 is ");
		System.out.println(JoeMath.squareRoot(-16.0));
	} 
}
/*
The square root of 9 is 3.0
The square root of -9 is 3.0i
The square root of 16 is 4.0
The square root of -16 is 4.0i

*/
