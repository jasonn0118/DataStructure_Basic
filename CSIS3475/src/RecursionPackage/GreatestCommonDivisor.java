package RecursionPackage;


/**
 * The greatest common divisor g is the largest natural number that divides both
 * a and b without leaving a remainder
 * 
 * @author mhrybyk
 *
 */
public class GreatestCommonDivisor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 21;
		int y = 6;
		int gcd;
		System.out.println("Computing GCD using Euclid of (" + x + ", " + y + ")");
		gcd = greatestCommonDivisorEuclid(x, y);
		System.out.println("GCD using Euclid of (" + x + ", " + y + ") is " + gcd);
		System.out.println("Computing GCD using Modulo operator of (" + x + ", " + y + ")");
		gcd = greatestCommonDivisorModulo(x, y);
		System.out.println("GCD using Modulo operator of (" + x + ", " + y + ") is " + gcd);
	}

	/**
	 * GCD using Euclid. 
	 * Repeatedly subtract y from x (basically mod operator) until only remainder is left
	 * Then swap.
	 * Keep going until remainder is zero.
	 * @param a
	 * @param b
	 * @return greatest common divisor
	 */
	static int greatestCommonDivisorEuclid(int a, int b) {
		System.out.println("greatestCommonDivisorEuclid(" + a + ", " + b + ")");
		if (b == 0)
			return a; // this now divides both a and b, as there is no more remainder
		else if (a < b)
			// if a is smaller than b, swap, then keep subtracting
			return greatestCommonDivisorEuclid(b, a);
		else
			// while a is larger, subtract b off it (basically modulo arithmetic)
			return greatestCommonDivisorEuclid(a - b, b);
	}

	/**
	 * GCD using Modulo operator.
	 * Take x mod y, if non-zero, then take y mod x (swap).
	 * Do until remainder is zero.
	 * @param a
	 * @param b
	 * @return greatest common divisor
	 */
	static int greatestCommonDivisorModulo(int a, int b) {
		System.out.println("greatestCommonDivisorModulo(" + a + ", " + b + ")");
		if (b == 0)
			return a;
		else
			// keep doing the following until there is no more remainder
			// swap as mod will make sure a < b
			return greatestCommonDivisorModulo(b, a % b);
	}

}
