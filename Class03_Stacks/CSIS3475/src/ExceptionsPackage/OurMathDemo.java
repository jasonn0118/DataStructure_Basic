package ExceptionsPackage;

/**
 * A demonstration of a runtime exception using the class OurMath.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class OurMathDemo {
	public static void main(String[] args) {
		System.out.print("The square root of 9 is ");
		System.out.println(OurMath.squareRoot(9.0));

		System.out.print("The square root of -9 is ");
		System.out.println(OurMath.squareRoot(-9.0));

		// this should never be reached
		System.out.print("The square root of 16 is ");
		System.out.println(OurMath.squareRoot(16.0));
	} 
} 
/*
The square root of 9 is 3.0
The square root of -9 is Exception in thread "main" SquareRootException: Attempted square root of a negative number.
	at OurMath.squareRoot(OurMath.java:19)
	at OurMathDriver.main(OurMathDriver.java:15)

*/
