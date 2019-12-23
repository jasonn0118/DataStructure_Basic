package ExceptionsPackage;

/**
 * A class of static methods to perform various mathematical computations,
 * including the square root.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class JoeMath {
	/**
	 * Computes the square root of a real number.
	 * 
	 * @param value A real value whose square root is desired.
	 * @return A string containing the square root.
	 */
	public static String squareRoot(double value) {
		String result = "";
		// take the square root
		// if exception thrown, then make 
		// the value positive, and append an i to result string
		// for an imaginary value
		try {
			Double temp = OurMath.squareRoot(value);
			result = temp.toString();
		} catch (SquareRootException e) {
			Double temp = OurMath.squareRoot(-value);
			result = temp.toString() + "i";
		}

		return result;
	}
}
