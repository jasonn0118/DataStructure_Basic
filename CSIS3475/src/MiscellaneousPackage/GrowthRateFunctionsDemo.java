package MiscellaneousPackage;


/**
 * Shows the growth rate function for a set of integers
 * @author mhrybyk
 *
 */
public class GrowthRateFunctionsDemo {

	public static void main(String[] args) {
		
		int MAXNUMBERS = 31;
		int nOperations = 0;
		
		// show growth function for each number in the series
		
		for(int i = 1; i < MAXNUMBERS; i++) {
			nOperations = 1 << i;   // left shift raises to a power of 2
			System.out.printf("N %2d: ", i + 1);  // so this is really the next i
			System.out.printf("2^N %16d", nOperations);
			System.out.print("\tloglogN ");
			System.out.print(log2(log2(nOperations)));
			System.out.print("\tlogN ");
			System.out.print(log2(nOperations));	
			System.out.print("\tlog^2N ");
			System.out.print((int) Math.pow(log2(nOperations),2));	
			System.out.print("\tNlogN ");
			System.out.print(((i + 1) * log2(nOperations)));	
			System.out.println();
		}

	}
	
	/**
	 * Returns base 2 logarithm of an integer
	 * @param n
	 * @return base 2 logarithm
	 */
	private static int log2(int n) {
		return (int) (Math.log10(n)/Math.log10(2));
	}

}
