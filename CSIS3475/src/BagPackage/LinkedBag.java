package BagPackage;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class LinkedBag<T> implements BagInterface<T> {
	private Node firstNode; // Reference to first node
	private int numberOfEntries;

	public LinkedBag() {
		firstNode = null;  // denotes an empty chain
		numberOfEntries = 0;
	} 

	public boolean contains(T anEntry) {	
		return getReferenceTo(anEntry) != null ? true : false;
	} 

	/**
	 * Locates a given entry within this bag.
	 * Returns a reference to the node containing the entry, if located,
	 * or null otherwise.
	 * @param anEntry the data to look for in the list of nodes
	 * @return the node containing the data
	 */
	private Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} 

		return currentNode;
	}

	private class Node {
		private T data; // Entry in bag
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} 

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} 
	} 

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
} 
