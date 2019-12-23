package ListWithIteratorsPackage;

import java.util.ListIterator;

import ListPackage.ListInterface;

/**
 * An interface for the ADT list that has an iterator implementing the interface
 * ListIterator.
 * 
 * Extends Iterable which has one method: iterator()
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public interface ListWithListIteratorInterface<T> extends Iterable<T>, ListInterface<T> {
	/**
	 * Gets the ListIterator that allows for list traversal
	 * @return
	 */
	public ListIterator<T> getIterator();
} 
