package GenericsPackage;

import java.util.ArrayList;

/**
 * 
 * Test demo of OrderedPair class implementing Pairable interface Shows use of
 * generics
 * 
 * @author mhrybyk
 *
 */
public class OrderedPairDemo {

	private static final int NPAIRS = 10;

	public static void main(String[] args) {

		// list of ordered pairs

		ArrayList<OrderedPair<Integer>> pairs = new ArrayList<>();

		// add ordered pairs to the list

		for (int i = 0; i < NPAIRS; i++)
			pairs.add(new OrderedPair<Integer>(1, i + 1));

		System.out.println("Displaying pairs");
		displayPairs(pairs);

		changePairsOrder(pairs);

		System.out.println("Displaying pairs after changed order");
		displayPairs(pairs);
		
		// now do the same thing with an array

		// illegal!!
		// OrderedPair<String>[] pairsOfStrings = new OrderedPair<String>[NPAIRS];

		@SuppressWarnings("unchecked")
		OrderedPair<String>[] pairsOfStrings = new OrderedPair[NPAIRS];

		for (int i = 0; i < NPAIRS; i++)
			pairsOfStrings[i] = new OrderedPair<String>("10a", String.valueOf(i + 1));

		System.out.println("Displaying pairs");
		displayPairs(pairsOfStrings);

		changePairsOrder(pairsOfStrings);

		System.out.println("Displaying pairs after changed order");
		displayPairs(pairsOfStrings);
	}

	// use overloading to avoid converting ArrayList to Array or vice versa
	// OrderedPair<T>[] pairsArray = (OrderedPair<T>[]) pairs.toArray(new OrderedPair[pairs.size()]);
	// is ugly

	/**
	 * display a list of ordered pairs
	 * @param <T> Type of an OrderedPair
	 * @param pairs ArrayList of ordered pairs
	 */
	public static <T> void displayPairs(ArrayList<OrderedPair<T>> pairs) {
		for (OrderedPair<T> pair : pairs)
			System.out.println(pair);
	}
	
	/**
	 * change the order of each pair in an ordered pair
	 * @param <T> Type of an OrderedPair
	 * @param pairs ArrayList of ordered pairs
	 */
	public static <T> void changePairsOrder(ArrayList<OrderedPair<T>> pairs) {
		for (OrderedPair<T> pair : pairs)
			pair.changeOrder();
	}

	/**
	 * display an array of ordered pairs
	 * @param <T> Type of an OrderedPair
	 * @param pairs array of ordered pairs
	 */
	public static <T> void displayPairs(OrderedPair<T>[] pairs) {
		for (OrderedPair<T> pair : pairs)
			System.out.println(pair);
	}

	/**
	 * change the order of each pair in an ordered pair
	 * @param <T> Type of an OrderedPair
	 * @param pairs array of ordered pairs
	 */
	public static <T> void changePairsOrder(OrderedPair<T>[] pairs) {
		for (OrderedPair<T> pair : pairs)
			pair.changeOrder();
	}
}
/*
Displaying pairs
(1, 1)
(1, 2)
(1, 3)
(1, 4)
(1, 5)
(1, 6)
(1, 7)
(1, 8)
(1, 9)
(1, 10)
Displaying pairs after changed order
(1, 1)
(2, 1)
(3, 1)
(4, 1)
(5, 1)
(6, 1)
(7, 1)
(8, 1)
(9, 1)
(10, 1)
Displaying pairs
(10a, 1)
(10a, 2)
(10a, 3)
(10a, 4)
(10a, 5)
(10a, 6)
(10a, 7)
(10a, 8)
(10a, 9)
(10a, 10)
Displaying pairs after changed order
(1, 10a)
(2, 10a)
(3, 10a)
(4, 10a)
(5, 10a)
(6, 10a)
(7, 10a)
(8, 10a)
(9, 10a)
(10, 10a)

*/
