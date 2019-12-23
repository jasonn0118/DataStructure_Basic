package HeapPackage;

import java.util.Arrays;

/**
 * A class that implements the ADT maxheap by using an array.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
	private T[] heap; // Array of heap entries; ignore heap[0]
	private int lastIndex; // Index of last entry and number of entries

	private static final int FRONT = 1;  // the first element in the heap
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public MaxHeap() {
		this(DEFAULT_CAPACITY); // Call next constructor
	} 

	public MaxHeap(int initialCapacity) {
		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else // Is initialCapacity too big?
			checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[initialCapacity + FRONT];
		heap = tempHeap;
		lastIndex = 0;
	} 

	/**
	 * Throws an exception if the client requests a capacity
	 *   that is either too small or too large.
	 * @param capacity
	 */
	private void checkCapacity(int capacity) {
		if (capacity < DEFAULT_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a heap " + "whose capacity is smaller than " + DEFAULT_CAPACITY);
		else if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a heap " + "whose capacity is larger than " + MAX_CAPACITY);
	} 
	
	/**
	 * Doubles the capacity of the array heap if it is full.
	 */
	private void ensureCapacity() {
		int numberOfEntries = lastIndex;
		int capacity = heap.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity); // Is capacity too big?
			heap = Arrays.copyOf(heap, newCapacity + FRONT);
		} 
	}

	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	} 

	public void display() {
        for (int i = 1; i <= lastIndex / 2; i++ )
        {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2*i]
                  + " RIGHT CHILD :" + heap[2 * i  + 1]);
 
            System.out.println();
        }
    }

} 
