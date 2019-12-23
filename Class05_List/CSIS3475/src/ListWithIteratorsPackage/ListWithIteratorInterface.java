package ListWithIteratorsPackage;
import java.util.Iterator;

import ListPackage.ListInterface;

/**
 * An interface for the ADT list that has an iterator.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public interface ListWithIteratorInterface<T> extends ListInterface<T>, Iterable<T> {
	public Iterator<T> getIterator();
} 
