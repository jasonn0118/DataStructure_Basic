package HeapPackage;

import QueuePackage.*;

/**
 * A class that implements the ADT priority queue by using a maxheap.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	private MaxHeapInterface<T> pq;

	public HeapPriorityQueue() {
		pq = new MaxHeap<>();
	} 

	public void add(T newEntry) {
		pq.add(newEntry);
	} 

	@Override
	public T remove() {
		return pq.removeMax();
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return pq.getMax();
	}

	@Override
	public boolean isEmpty() {
		return pq.isEmpty();
	}

	@Override
	public int size() {
		return pq.size();
	}

	@Override
	public void clear() {
		pq.clear();
	}

}
