package ListPackage;
import java.util.Arrays;

/**
 * A class that implements the ADT list by using a fixed array.
 * Duplicate entries are allowed.
 * 
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Redone to simplify and make everything zero index based
 * Array is no longer resized, just returns false if item cannot be added.
 */
public class AList<T extends Comparable<? super T>> implements ListInterface<T> {
	private T[] list; // Array of list entries
	private int numberOfEntries;

	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public AList() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public AList(int initialCapacity) {

		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;

		// cap it at maximum capacity
		
		if (initialCapacity >= MAX_CAPACITY)
			initialCapacity = MAX_CAPACITY;

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Comparable[initialCapacity];
		list = tempList;

		numberOfEntries = 0;

	} 



	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeEntry(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findEntry(T anEntry) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Determines if a position is in the proper range of the list
	 * @param givenPosition
	 * @return
	 */
	public boolean isInRange(int givenPosition) {
		return (givenPosition >= 0) && (givenPosition < numberOfEntries);
	}

	/**
	 * Determine if there is no more room in the list to add entries
	 * @return true if the list is full
	 */
	public boolean isFull() {
		if (numberOfEntries >= list.length)
			return false;
		else
			return true;
	}

	/**
	 * Determines if there is room in the list to add entries
	 * @return true if there is room in the list
	 */
	public boolean hasRoom() {
		if(numberOfEntries < list.length)
			return true;
		else return false;
	}



} 
