package ListPackage;

/**
 * A linked implemention of the ADT list.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * modified to use a zero offset for position Uses Node class which is
 *  doubly-linked, but only use forward links here
 */
public class LList<T extends Comparable<? super T>> implements ListInterface<T> {
	private Node<T> firstNode; // Reference to first node of chain
	private int numberOfEntries;

	public LList() {
		initializeDataFields();
	}

	/**
	 * Reset all data in the list.
	 */
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	}

	/**
	 * Determines if a position is in the proper range of the list
	 * @param givenPosition
	 * @return
	 */
	public boolean isInRange(int givenPosition) {
		return (givenPosition >= 0) && (givenPosition < numberOfEntries);
	}
	
	/**
	 * Return the first node in the list. Violates data hiding.
	 * 
	 * Only used by iterator. In production, the subclass would be final,
	 * or the iterator would be built in from the start.
	 * @return
	 */
	protected Node<T> getFirstNode() {
		return firstNode;
	}
	
	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeEntry(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findEntry(T anEntry) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Returns a reference to the Node<T> at a given position.
	 * @param givenPosition
	 * @return
	 */
	private Node<T> getNodeAt(int givenPosition) {

		return null;
	}
} 
