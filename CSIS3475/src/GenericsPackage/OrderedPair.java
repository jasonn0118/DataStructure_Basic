package GenericsPackage;

/**
 * A class of ordered pairs of objects having the same data type.
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 */
public class OrderedPair<T> implements Pairable<T> {
	private T first, second;

	public OrderedPair(T firstItem, T secondItem) // NOTE: no <T> after constructor name
	{
		first = firstItem;
		second = secondItem;
	}

	/** Returns the first object in this pair. */
	public T getFirst() {
		return first;
	}

	/** Returns the second object in this pair. */
	public T getSecond() {
		return second;
	}

	/** Returns a string representation of this pair. */
	public String toString() {
		return "(" + first + ", " + second + ")";
	}

	/** Interchanges the objects in this pair. */
	public void changeOrder() {
		T temp = first;
		first = second;
		second = temp;
	}
}
