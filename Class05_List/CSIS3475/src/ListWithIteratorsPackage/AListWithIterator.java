package ListWithIteratorsPackage;

import java.util.Iterator;
import ListPackage.*;

/**
 * Implements an AList but adds an iterator.
 * 
 * Unlike the textbook, simply extend existing AList and add Iterator methods.
 * 
 * @author mhrybyk
 *
 * @param <T> Must extend Comparable
 */
public class AListWithIterator<T extends Comparable<? super T>> 
	extends AList<T> implements ListWithIteratorInterface<T> {

	@Override
	public Iterator<T> iterator() {
		return new IteratorForArrayList();
	}

	@Override
	public Iterator<T> getIterator() {
		return iterator();
	}
	
	private class IteratorForArrayList implements Iterator<T> {
		private int nextIndex; // Index of next entry in the iteration
		private boolean wasNextCalled; // Needed by remove

		private IteratorForArrayList() {
			nextIndex = 0; // Iteration begins at list's first entry
			wasNextCalled = false;
		} 

		public boolean hasNext() {
			return nextIndex < size();
		} 

		public T next() {
			// IMPLEMENT THIS
			return null;			
		}
		
		public void remove() {
			if (wasNextCalled) {
				// nextIndex was incremented by the call to next, so it is
				// 1 larger than the position number of the entry to be removed
				AListWithIterator.this.remove(nextIndex - 1);
				nextIndex--; // Index of next entry in iteration
				wasNextCalled = false; // Reset flag
			} else
				throw new IllegalStateException("Illegal call to remove(); " + "next() was not called.");
		} 
	}

}
