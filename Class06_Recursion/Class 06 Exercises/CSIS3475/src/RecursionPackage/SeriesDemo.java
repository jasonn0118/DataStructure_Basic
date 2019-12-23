package RecursionPackage;

/**
 * Demonstrate factorial and series sum using recursion
 * @author mhrybyk
 *
 */
public class SeriesDemo  {

	public static void main(String[] args) {
		
		int input = 6;
		System.out.println("Sum of Series by algebra of " + input + " = " + (input * (input + 1) / 2));
		System.out.println("SumOfSeriesIterative of " + input + " is " + sumOfSeriesIterative(input));		
		System.out.println("SumOfSeriesRecursion of " + input + " is " + sumOfSeriesRecursion(input));
		System.out.println("TailRecursionSumOfSeries of " + input + " is " + sumOfSeriesTailRecursion(input));
	}
	
	/**
	 * Compute sum of integer series using a loop
	 * @param n last term of integer series
	 * @return sum of series
	 */
	private static int sumOfSeriesIterative(int input) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Compute sum of integer series using basic recursion
	 * 
	 * @param n last term of integer series
	 * @return sum of series
	 */
	private static int sumOfSeriesRecursion(int input) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Compute sum of integer series using tail recursion
	 * 
	 * @param n last term of integer series
	 * @return sum of series
	 */	
	private static int sumOfSeriesTailRecursion(int input) {
		// TODO Auto-generated method stub
		return 0;
	}
}
