package StackPackage;

import java.util.Vector;

/**
 * A class of stacks whose entries are stored in a vector.
 * 
 * @author Frank M. Carrano and Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * added toArray() and size() implementations to reflect modified
 * StackInterface
 */
public class VectorStack<T> implements StackInterface<T> {
	private Vector<T> stack; // Last element is the top entry in stack

	// Vector class can grow dynamically, so no need to increase
	
	private static final int DEFAULT_CAPACITY = 50;

	public VectorStack() {
		this(DEFAULT_CAPACITY);
	} 

	public VectorStack(int initialCapacity) {
		stack = new Vector<>(initialCapacity); // Size doubles as needed
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
