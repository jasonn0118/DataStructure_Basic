package BagPackage;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 * 
 * This uses the public Node class and its methods
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Modified to use public Node class and methods
 */
public final class LinkedBagWithNodeMethods<T> implements BagInterface<T> {
	private Node<T> firstNode; // Reference to first node
	private int numberOfEntries;

	public boolean add(T newEntry) // OutOfMemoryError possible
	{
		// make new node reference first node, bascially putting it
		// at the front.
		Node<T> newNode = new Node<T>(newEntry, firstNode);
		firstNode = newNode; // New node is at beginning of chain
		numberOfEntries++;

		return true;
	} 


	public boolean contains(T anEntry) {
		return getReferenceTo(anEntry) != null ? true : false;

	} 

	/**
	 * Locates a given entry within this bag. Returns a reference to the node
	 * containing the entry, if located, or null otherwise.
	 * 
	 * @param anEntry the data to look for in the list of nodes
	 * @return the node containing the data
	 */
	private Node<T> getReferenceTo(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}

		return currentNode;
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
