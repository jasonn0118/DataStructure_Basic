import java.util.ListIterator;

/**
 * An interface for the ADT list that has an iterator implementing the interface
 * ListIterator.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public interface ListWithIteratorInterface<T> extends Iterable<T>, ListInterface<T> {
	public ListIterator<T> getIterator();
}
