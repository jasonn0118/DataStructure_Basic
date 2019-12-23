package ListWithIteratorsPackage;

import java.nio.channels.IllegalSelectorException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import ListPackage.*;

/**
 * A class that implements the ADT list by using an array. The list has an
 * iterator that implements the interface ListIterator.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 *         Subclasses AList instead of copying code. Also all positions start at
 *         0 to be consistent.
 */
public class AListWithListIterator<T extends Comparable<? super T>> extends AList<T>
		implements ListWithListIteratorInterface<T> {

	public ListIterator<T> getIterator() {
		return new ListIteratorForAList();
	}

	public Iterator<T> iterator() {
		return getIterator();
	}

	/**
	 * Movement direction.
	 *
	 */
	private enum Move {
		NEXT, PREVIOUS
	}

	private class ListIteratorForAList implements ListIterator<T> {
		private int nextIndex; // Index of next entry in the iteration
		private boolean isRemoveOrSetLegal;
		private Move lastMove;

		private ListIteratorForAList() {
			nextIndex = 0; // Iteration begins at list's first entry
			isRemoveOrSetLegal = false;
			lastMove = null;
		}

		@Override
		public boolean hasNext() {
			return nextIndex < size();
		}

		@Override
		public T next() {
			if (hasNext()) {
				lastMove = Move.NEXT;
				isRemoveOrSetLegal = true;

				T nextEntry = getEntry(nextIndex);
				nextIndex++;// advance iterator.

				return nextEntry;
			} else {
				throw new NoSuchElementException("No next element in list");
			}
		}

		@Override
		public boolean hasPrevious() {
			// is there a prior slot?
			// if nextIndex is past the end of the list, there is.
			return (nextIndex > 0) && (nextIndex <= size());
		}

		@Override
		public T previous() {
			if (hasPrevious()) {
				// reset the direction.
				lastMove = Move.PREVIOUS;
				isRemoveOrSetLegal = true;

				T previousEntry = getEntry(nextIndex - 1);

				nextIndex--;
				return previousEntry;
			} else {
				throw new NoSuchElementException("Illegal call to previous(); " + "iterator is before of list");
			}
		}

		@Override
		public int nextIndex() {
			int result;

			if (hasNext())
				result = nextIndex;
			else
				result = size();
			return result;
		}

		@Override
		public int previousIndex() {
			int result;

			if (hasPrevious()) {
				result = nextIndex - 1;
			} else
				result = -1;

			return result;
		}

		@Override
		public void remove() {
			if (isRemoveOrSetLegal) {
				isRemoveOrSetLegal = false;

				if (lastMove.equals(Move.NEXT)) {
					// next() called, but neither add() nor remove() has been called since.
					// Remove entry last returned by next().
					// nextIndex is 1 more than the index of the entry
					// returned by next()
					AListWithListIterator.this.remove(nextIndex - 1);
					nextIndex--;// Move iterator back
				} else {// lastMove.equals(Move.PREVIOUS)
						// previous() called, but neither add() nor remove() has been called since.
						// Remove entry last returned by previous().
						// nextIndex is the index of the entry returned by previous().
					AListWithListIterator.this.remove(nextIndex);
				}
			} else {
				throw new IllegalStateException("Illegal call to remove(); " + "next() or previous() not called, OR "
						+ "add() or remove() called since then.");
			}
		}

		@Override
		public void set(T newEntry) {
			if(isRemoveOrSetLegal) {
				if(lastMove.equals(Move.NEXT)) {
					replace(nextIndex-1,newEntry);
				}else {
					replace(nextIndex,newEntry);
				}
			}else {
				throw new IllegalStateException("Illegal call to set(); " + "next() or prvious() not called, OR "+"add() or remove() called since then.");
			}

		}

		@Override
		public void add(T newEntry) {
			//once we add, our direction is no longer set.
			isRemoveOrSetLegal = false;
			
			//Insert newEntry immediately before the iterator's current position
			AListWithListIterator.this.add(nextIndex,newEntry);
			nextIndex++;
			
		}

	}
}
