package ExceptionsPackage;

/**
 * Demonstrates the behavior of a finally block. Listing J3-6 in Segement J3.11
 * of Java Interlude 3.
 * 
 * Note that NoMilkException needs to be completed
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class GetMilk {
	public static void main(String[] args) {
		try {
			openRefrigerator();
			takeOutMilk(); // will sometimes throw an exception
			pourMilk();
			putBackMilk();
		} catch (NoMilkException e) {
			System.out.println(e.getMessage());
		} finally {
			closeRefrigerator();
		}
	} 

	public static void openRefrigerator() {
		System.out.println("Open the refrigerator door.");
	} 

	/**
	 * Coin flip says we are out of milk
	 * @throws NoMilkException
	 */
	public static void takeOutMilk() throws NoMilkException {
		if (Math.random() < 0.5)
			System.out.println("Take out the milk.");
		else
			throw new NoMilkException("Out of Milk!");
	} 

	public static void pourMilk() {
		System.out.println("Pour the milk.");
	} 

	public static void putBackMilk() {
		System.out.println("Put the milk back.");
	} 

	public static void closeRefrigerator() {
		System.out.println("Close the refrigerator door.");
	} 
} 
/*
OUTPUT 1:
 Open the refrigerator door.
 Take out the milk.
 Pour the milk.
 Put the milk back.
 Close the refrigerator door.
 
OUTPUT 2:
 Open the refrigerator door.
 Out of Milk!
 Close the refrigerator door.
*/
