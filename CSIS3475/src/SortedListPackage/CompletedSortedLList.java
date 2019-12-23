package SortedListPackage;

import java.util.Iterator;

import ListPackage.*;
import ListWithIteratorsPackage.LListWithIterator;


/**
 * Using inheritance and polymorphism, an LList class that inserts items in the list
 * in sorted order.
 * 
 * This uses list traversal to insert the data, rather than using an index.
 * 
 * @author mhrybyk
 *
 * @param <T>
 */
public class CompletedSortedLList<T extends Comparable<? super T>> 
	extends LListWithIterator<T> {

	public CompletedSortedLList() {
		super();
	}

	@Override
	final public boolean add(T entry) {
	
		// find the position in sorted order that the entry precedes
		
		int position = findEntryBefore(entry);
		
		// if it is not found, simply add it to the end.
		
		if (position < 0) {
			return(super.add(entry));
		}

		// otherwise add it into the slot found
		
		return(super.add(position, entry));

	}


	/**
	 * Finds the node that is before the node that contains a given entry. Returns
	 * either a reference to the node that is before the node that contains anEntry,
	 * or -1 if no prior node exists (that is, if anEntry is or belongs at the
	 * beginning of the list).
	 * 
	 * @param anEntry
	 * @return
	 */
	private int findEntryBefore(T anEntry) {

		// traverse the list using iterator methods until we find a node with data that is greater than
		//  or equal to the one provided by the caller
		
		// this does not have the performance penalty getEntry() has.
		
		// basically, assume that anEntry is larger than anything in the list until
		//   proven wrong.
		
		int found = -1;
		Iterator<T> iterator = getIterator();
		for(int i = 0; i < size() && iterator.hasNext(); i++ ) {
			T data = iterator.next();
			if(anEntry.compareTo(data) < 0) {
				found = i;
				break;
			}
		}
		
		return found;
	}

	/**
	 * This is not allowed, or list will be unsorted.
	 */
	@Override
	public boolean add(int newPosition, T newEntry) {
		throw new UnsupportedOperationException("add() at a position is not legal for a sorted list");
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		throw new UnsupportedOperationException("replace() at a position is not legal for a sorted list");
	}
}
