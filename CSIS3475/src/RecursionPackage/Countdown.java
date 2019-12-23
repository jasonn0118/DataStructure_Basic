package RecursionPackage;

/**
 * Counts down from a given positive integer.
 * 
 * @param integer An integer > 0.
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 */
public class Countdown {

	public static void main(String[] args) {
		countDown(10);
	}

	public static void countDown(int integer) {
		System.out.println(integer);
		if(integer>0) {
			countDown(integer-1);
		}
	}
}
