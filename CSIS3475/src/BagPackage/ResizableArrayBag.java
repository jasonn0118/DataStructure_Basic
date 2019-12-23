package BagPackage;

import java.util.Arrays;

/**
 * A class that implements a bag of objects by using an array. The bag is never
 * full.
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * This is the same as Bag.java in the textbook
 */
public final class ResizableArrayBag<T> implements BagInterface<T> {
	private T[] bag; // Cannot be final due to doubling
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty bag whose initial capacity is 25. */
	public ResizableArrayBag() {
		this(DEFAULT_CAPACITY);
	} 

	/**
	 * Creates an empty bag having a given initial capacity.
	 * 
	 * @param initialCapacity The integer capacity desired.
	 */
	public ResizableArrayBag(int initialCapacity) {
		checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[initialCapacity]; // Unchecked cast
		bag = tempBag;
		numberOfEntries = 0;
	} 

	/**
	 * Creates a bag containing given entries.
	 * 
	 * @param contents An array of objects.
	 */
	public ResizableArrayBag(T[] contents) {
		checkCapacity(contents.length);
		bag = Arrays.copyOf(contents, contents.length);
		numberOfEntries = contents.length;
	}

	/**
	 * Doubles the size of the bag
	 */
	private void doubleCapacity() {
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	}

	/**
	 * Throws an exception if the client requests a bag capacity that is too large.
	 * 
	 * @param capacity requested size of bag
	 */
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a bag whose capacity exceeds " + "allowed maximum of " + MAX_CAPACITY);
	}

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
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
		return null;
	}

}
