package ListWithIteratorsPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ListPackage.*;

/**
 * A class that represents an iterator for the ADT list.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class SeparateListIterator<T> implements Iterator<T> {
	private ListInterface<T> list;
	private int nextPosition; // Position of entry last returned by next()
	private boolean wasNextCalled; // Needed by remove

	public SeparateListIterator(ListInterface<T> myList) {
		list = myList;
		nextPosition = 0;
		wasNextCalled = false;
	} 
	//move forward, not backward.
	@Override
	public boolean hasNext() {
		return nextPosition < list.size();
	}

	@Override
	public T next() {
		if(hasNext()) {
			wasNextCalled = true;
			T nextEntry = list.getEntry(nextPosition);
			nextPosition++;
			return nextEntry;
		}else{
			throw new NoSuchElementException("No next element in list");
		}
	}

	public void remove() {
		if(wasNextCalled) {
			list.remove(nextPosition-1);
			nextPosition--;
			wasNextCalled=false;
		}else {
			throw new IllegalStateException("Illegal call to remove(); "+"next() was not called.");
		}
	} 

} 
