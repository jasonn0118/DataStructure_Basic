package RecursionPackage;

/**
 * Raises a base number to a set of powers using recursion
 * 
 * @author mhrybyk
 *
 */
public class RaiseToAPowerDemo {

	static int numberOfOperations;  // keep count of the number of multiplies

	public static void main(String[] args) {
		int base = 2;
		int max = 16;

		// test case: calculate for a series of non-zero exponents
		for (int i = 0; i <= max; i++)
			power(base, i);

	}

	/**
	 * Raise a number to a power. Calls a helper function in order to count
	 * the number of multiplies
	 * @param n
	 * @param exponent
	 * @return
	 */
	static public int power(int n, int exponent) {
		numberOfOperations = 0;
		System.out.println("++++ Calculating " + n + " to the " + exponent + " power");
		int result = powerHelper(n, exponent);
		System.out.println(" result = " + result + ", operations = " + numberOfOperations);
		return result;
	}

	/**
	 * Method to calculate the a number raised to a power, using
	 * recursion.
	 * 
	 * Algorithm:
	 * For even pow = n^(e/2)*n^(e/2)
	 * For odd pow = n * n^(e/2)*n^(e/2
	 * 
	 * where e/2 is integer division
	 * 
	 * this is O(logN).
	 * 
	 * Example for n^6
	 * 
	 * pow(n^6) 
	 * pow n^3 * n^3   split in half
	 * pow (n^3)       calculate the half
	 * pow n * (n * n) if odd, multiply by the base as well
	 * 
	 * Example for 2^6 
	 * 
	 * 2^6
	 * 2^3 * 2^3 = 8 * 8 [1 multiply]
	 * 
	 * 2^3
	 * 2 * 2 * 2 = 8 (2 multiplies)
	 * @param n
	 * @param exponent
	 * @return
	 */
	static public int powerHelper(int n, int exponent) {
		System.out.println(" entering powerHelper method " + n + " " + exponent);
		
		// base case 
		if (exponent == 0) {
			System.out.println(" base case returns 1");
			return 1;
		}

		// halve exponent and get the result
		// we will square this later
		
		int halfExponent = exponent / 2;
		int halfResult = powerHelper(n, halfExponent);

		System.out.println(" after method returns half result " + halfResult 
				+ " = " + n + " to the " + halfExponent + " power");

		// this will be the result returned to the caller
		int result = 0;
		
		// square the result if odd exponent, multiply by another copy of the base n
		
		if (exponent % 2 == 1) {
			// if the result is > 1, two multiplies will be needed
			if (halfResult > 1)
				numberOfOperations += 2; 
			result = n * halfResult * halfResult;
			System.out.println(" full result " + result 
					+ " = " + n + " to the " + exponent + " power odd ");

			return result;
		} else {
			numberOfOperations++;
			result = halfResult * halfResult;
			System.out.println(" full result " + result 
					+ " = " + n + " to the " + exponent + " power");
			return result;
		}

	}
}

