package HeapPackage;

import ListPackage.*;

/**
 * Set of Heap sort methods.
 * 
 * Although utility methods are not recommended in OO design, this keeps the code simple
 * and in one place for demonstrating all of the sorting algorithms.
 * 
 * All work against any class that implements ListInterface with a type that is Comparable
 * 
 * All of the sort methods use the list methods rather than the typical array, list, ... .
 * 
 * Note that most methods are inefficient unless arrays are used. getEntry() and replace()
 * are efficient when used with arrays. These are the only methods actually used from ListInterface.
 * 
 * This is a different approach from the textbook where a new class is created for each sort algorithm.
 * 
 * 
 * @author mhrybyk
 *
 */
public final class HeapSortUtilities <T extends Comparable<? super T>>  {
	
	private HeapSortUtilities() {}; // to prevent instantiation

	/**
	 * Swap the data in the given positions in the list
	 * 
	 * @param list
	 * @param first  position to swap
	 * @param second position to swap
	 */
	static public <T> void swap(ListInterface<T> list, int first, int second) {

		if (first == second || list == null)
			return;

		T firstEntry = list.getEntry(first);
		T secondEntry = list.getEntry(second);

		list.replace(first, secondEntry);
		list.replace(second, firstEntry);

	}

	/**
	 * Heap sort using reheap to create an initial semiheap.
	 * Then swap last element with root and reheap until complete.
	 * @param list
	 * @param first
	 * @param last
	 */
	static public <T extends Comparable<? super T>> void heapSort(ListInterface<T> list, int first, int last) {
		// Create first heap
		for (int rootIndex = (last / 2); rootIndex >= first; rootIndex--)
			reheap(list, rootIndex, last);

		// exchange the last with the root, and reheap.
		
		// continue reheap until we have iterated through all of the elements
		// starting with the last element
		
		swap(list, 0, last);

		for (int lastIndex = last - 1; lastIndex > 0; lastIndex--) {
			reheap(list, 0, lastIndex);
			swap(list, 0, lastIndex);  // swap and reheap
		} 
	} 

	/**
	 * Using a list instead of an array, create a heap from a semiheap
	 * @param list
	 * @param rootIndex
	 * @param lastIndex
	 */
	static public <T extends Comparable<? super T>> void reheap(ListInterface<T> list, int rootIndex, int lastIndex) {
		boolean done = false;
		
		T orphan = list.getEntry(rootIndex);
//		System.out.println("reheap rootindex " + rootIndex + " last " + lastIndex + " orphan " + orphan);
		
		// children start at double the root index
		
		// left child is one more
		
		int leftChildIndex = (2 * rootIndex) + 1;

		while (!done && (leftChildIndex <= lastIndex)) {
			
			// assume left child is the larger one
			
			int largerChildIndex = leftChildIndex;
			
			// right child is one more than left
			
			int rightChildIndex = leftChildIndex + 1;
			
			T largerChild = list.getEntry(largerChildIndex);
			T rightChild;
			
			try {
				// get the right child data. left child data is the largest
				rightChild = list.getEntry(rightChildIndex);
			} catch (IndexOutOfBoundsException e) {
				// index is illegal, there is no right child, so set rightChild to leftChild
				rightChild = largerChild;
			}
						
			// if right is larger than left, then set larger to right child
			if ((rightChildIndex <= lastIndex) && rightChild.compareTo(largerChild) > 0) {
				largerChildIndex = rightChildIndex;
				largerChild = rightChild;
			} 
			
			// if our current root list smaller, move the larger to the root
			// and then go to its child
			// otherwise we are done
			if (orphan.compareTo(largerChild) < 0) {
				list.replace(rootIndex, largerChild);
				rootIndex = largerChildIndex;
				leftChildIndex = (2 * rootIndex) + 1;
			} else
				done = true;
		} 

		// set the current root value to the (possibly redefined) root slot
		
		list.replace(rootIndex, orphan);
	}
	
	/**
	 * Sort a list using MaxHeap. 
	 * 
	 * Need to reverse list as a second step. Would be nice if we had MinHeap!
	 * @param <T>
	 * @param list list to be sorted
	 * @param first 
	 * @param last
	 */
	static public <T extends Comparable<? super T>> void heapSortUsingMaxHeap(ListInterface<T> list, int first, int last) {
		
		// let's sort the entire list easily using the MaxHeap constructor
	
		CompletedMaxHeapUsingSwapAndAList<T> heap = new CompletedMaxHeapUsingSwapAndAList<>(list.toArray());
		
		// clear the original list
		
		list.clear();
		
		// move the heap back to the list
		
		while(heap.isEmpty() == false)
			list.add(heap.removeMax());
		
		// now need to reverse list as it is maxheap
		
		// copy the sorted list to an array
		
		Object[] tempArray = list.toArray();

		@SuppressWarnings("unchecked")
		T[] listCopy = (T[]) tempArray;
		
		// clear the list
		
		list.clear();
		
		// copy from the array to the list from back to front.
		for(int i = last; i >= first; i--)
			list.add(listCopy[i]);
			
		
	}
	
}
