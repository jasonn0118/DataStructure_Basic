package ListWithIteratorsPackage;
import java.util.Iterator;
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

	public void remove() {

	} 

} 
