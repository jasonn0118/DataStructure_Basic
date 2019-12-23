package ListWithIteratorsPackage;

import java.util.Iterator;

import ListPackage.*;

public class LListWithIterator<T extends Comparable<? super T>> 
	extends LList<T> implements ListWithIteratorInterface<T> {

	@Override
	public Iterator<T> iterator() {
		return new IteratorForLList();
	}

	@Override
	public Iterator<T> getIterator() {
		return iterator();
	}

	private class IteratorForLList implements Iterator<T> {
		
		// we need to track the position in the list in order to remove
		
		private int nextIndex; // Index of next entry in the iteration
		private boolean wasNextCalled; // Needed by remove

		private Node<T> nextNode; // Node containing next entry in iteration

		private IteratorForLList() {
			nextIndex = 0;
			nextNode = getFirstNode();
			wasNextCalled = false;
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public T next() {
			// implement this
			return null;
		}

		public void remove() {
			if (wasNextCalled) {
				// nextIndex was incremented by the call to next, so it is
				// 1 larger than the position number of the entry to be removed
				
				// we don't have a method to remove a node, so we will use
				// the list position instead to remove
				// not efficient, but we don't have to reimplement with Node
				LListWithIterator.this.remove(nextIndex - 1);
				nextIndex--; // Index of next entry in iteration
				wasNextCalled = false; // Reset flag
			} else
				throw new IllegalStateException("Illegal call to remove(); " + "next() was not called.");
		}
	}

}
