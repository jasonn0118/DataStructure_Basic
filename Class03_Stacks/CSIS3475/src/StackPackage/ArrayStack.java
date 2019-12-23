package StackPackage;

import java.util.Arrays;

/**
 * A class of stacks whose entries are stored in an array.
 * 
 * @author Frank M. Carrano and Timothy M. Henry
 * @version 5.0
 */
public final class ArrayStack<T> implements StackInterface<T> {
	private T[] stack; // Array of stack entries
	private int topIndex; // Index of top entry

	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	} 

	public ArrayStack(int initialCapacity) {

		checkCapacity(initialCapacity);   // do we have enough room?

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;

	} 

	
	/**
	 * Throws an exception if the client requests a capacity that is too large.
	 * @param capacity requested capacity
	 */
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a stack " + "whose capacity exceeds " + "allowed maximum.");
	}
	
	/**
	 * Doubles the size of the array stack if it is full
	 */
	private void ensureCapacity() {
		if (topIndex >= stack.length - 1)
		{
			// the array is full, so double the size
			
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			
			// copyOf will create a new array with
			// the larger size and copy all elements
			
			stack = Arrays.copyOf(stack, newLength);
		} 
	}

	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
} 
