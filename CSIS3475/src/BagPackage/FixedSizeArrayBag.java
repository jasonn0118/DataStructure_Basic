package BagPackage;

import java.util.Arrays;

/**
 * A class of bags whose entries are stored in a fixed-size array.
 * 
 * Methods to be completed.
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 */
public final class FixedSizeArrayBag<T> implements BagInterface<T> {
	@SuppressWarnings("unused")
	private final T[] bag;
	@SuppressWarnings("unused")
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;

	/** Creates an empty bag whose initial capacity is 25. */
	public FixedSizeArrayBag() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates an empty bag having a given initial capacity.
	 * 
	 * @param desiredCapacity The integer capacity desired.
	 */
	public FixedSizeArrayBag(int desiredCapacity) {
		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
		bag = tempBag;
		numberOfEntries = 0;
	} // end constructor

	/**
	 * Returns true if the array bag is full, or false if not.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean isArrayFull() {
		// To be defined
		return numberOfEntries >= bag.length;
	} // end isArrayFull

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(T newEntry) {
		boolean result = true;
		if (isArrayFull()) {
			result = false;
		} else {
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		return result;

	}

	@Override
	public T remove() {
//		T result = removeEntry(numberOfEntries-1);
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return Arrays.copyOf(bag, numberOfEntries);
	}

}
