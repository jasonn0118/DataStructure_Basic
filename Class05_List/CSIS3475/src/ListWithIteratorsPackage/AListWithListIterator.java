package ListWithIteratorsPackage;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import ListPackage.*;


/**
 * A class that implements the ADT list by using an array. 
 * The list has an iterator that implements
 * the interface ListIterator. 
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Subclasses AList instead of copying code. Also all positions
 * start at 0 to be consistent.
 */
public class AListWithListIterator<T extends Comparable<? super T>> 
		extends AList<T>
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
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(T newEntry) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void add(T newEntry) {
			// TODO Auto-generated method stub
			
		} 
		

	} 
} 
