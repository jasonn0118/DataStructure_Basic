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
		int newIndex = lastIndex+1;//start at the last index of the tree.
		int parentIndex = newIndex/2;//parent is always halfway up.
		
		while((parentIndex>0)&&newEntry.compareTo(heap[parentIndex])>0) {
			
			//newEntry is larger than the parent, so move the parent to the leaf node or vacancy
			heap[newIndex] = heap[parentIndex];
			
			//vacancy is now where the parent previously existed
			newIndex = parentIndex;
			
			//go to the next parent up the tree.
			parentIndex = newIndex/2;
		}
		
		//place the entry in the vacacy/leaf and bump the last index (last node of the tree)
		heap[newIndex] = newEntry;
		lastIndex++;
		
		ensureCapacity();
		
		
	}

	@Override
	public T removeMax() {
		T root = null;
		
		if(!isEmpty()) {
			root = heap[FRONT];//return the front of the heap.
			heap[FRONT] = heap[lastIndex];//Form a semiheap.
			lastIndex--;//decrease size.
			reheap(FRONT);//Transform to a heap.		
		}
		return root;
	}
	
	private void reheap(int rootIndex) {
		boolean done = false;
		//this is the starting point. we are not sure where this will end up,
		//so it is an orphan to start
		
		T orphan = heap[rootIndex];
		
		//left child is always double the index of the parent
		//right child is one more than the left
		
		int leftChildIndex = 2*rootIndex;
		
		//iterate through the tree until the orphan is the larger one.
		
		while(!done&&(leftChildIndex<=lastIndex)) {
			
			//larger child is always the left one
			int largerChildIndex = leftChildIndex;
			
			//right child is one position more than the left.
			int rightChildIndex = leftChildIndex+1;
			
			//set the larger child to the right child if the right child is larger.
			if((rightChildIndex<=lastIndex)&&
					heap[rightChildIndex].compareTo(heap[largerChildIndex])>0) {
				largerChildIndex = rightChildIndex;
			}
			//now compare out orphan to the largest child.
			//if the orphan is smaller, move the larger child to the root,
			//and adjust the rootIndex to be the larger child.
			//then look at the next left child and start over.
			
			//if orphan is the same or larger, then we are done.
			
			if(orphan.compareTo(heap[largerChildIndex])<0) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2*rootIndex;
			}else{
				done = true;
			}
		}//end while.
		// the rootIndex has been potentially reset to a child's
		// in any case, copy the orphan to the root
		// note that if the orphan was the largest to start, it just remains at the root
		heap[rootIndex] = orphan;
	}

	@Override
	public T getMax() {
		T root = null;
		if(!isEmpty())
			root = heap[FRONT];
		return root;
	}

	@Override
	public boolean isEmpty() {
		return lastIndex<1;
	}

	@Override
	public int size() {
		return lastIndex;
	}

	@Override
	public void clear() {
		while(lastIndex>-1) {
			heap[lastIndex]=null;
			lastIndex--;
		}
		lastIndex = 0;
		
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
