package SortedListPackage;

import ListPackage.*;

/**
 * Using inheritance and polymorphism, an AList class that inserts items in the list
 * in sorted order.
 * 
 * @author mhrybyk
 *
 * @param <T>
 */
public class CompletedSortedAList<T extends Comparable<? super T>> extends AList<T> {

	public CompletedSortedAList() {
		super();
	}

	public CompletedSortedAList(int initialCapacity) {
		super(initialCapacity);
	}
	
	/**
	 * This inserts an entry into a list in sorted order (ascending)
	 */
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
	 * Finds a position in the list that an entry precedes in sorted order (ascending).
	 * 
	 * We can use getEntry() here as there is no performance issue with the array implementation.
	 * 
	 * This is different than SortedLList (although we could use the same code with an iterator)
	 * @param entry
	 * @return -1 if not found
	 */
	public int findEntryBefore(T entry) {
		
		int found = -1;

		for(int i = 0; i < size(); i++) {
			if(entry.compareTo(getEntry(i)) < 0) {
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
