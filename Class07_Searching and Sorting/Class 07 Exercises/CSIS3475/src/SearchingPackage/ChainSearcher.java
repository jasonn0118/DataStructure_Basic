package SearchingPackage;

import ListPackage.*;

/**
 * A class of methods for searching a linked chain of nodes. The objects in a
 * sorted chain must be Comparable.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Using add() and size() to conform to ListInterface.
 * However, many methods unimplemented. 
 * 
 * This is just to demonstrate searching in a linked list
 */
public class ChainSearcher<T extends Comparable<T>> implements ListInterface<T> {
	private Node<T> firstNode; // Head reference to first node
	private Node<T> lastNode; // Tail reference to last node
	private int numberOfEntries; // Number of entries in chain

	public ChainSearcher() {
		initializeDataFields();
	} 

	/**
	 * Display all entries in the list
	 */
	public void display() {
		System.out.print("The chain contains the following entries: ");
		Node<T> currentNode = firstNode;
		for (int counter = 0; counter < numberOfEntries; counter++) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNextNode();
		} 

		System.out.println();
	}

	/**
	 * Initializes the class's data fields to indicate an empty list.
	 */
	private void initializeDataFields() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	} 
	
	// Segment 19.18

	/**
	 * Searches an unsorted chain for anEntry iteratively.
	 * @param anEntry
	 * @return
	 */
	public boolean searchUnsortedChainIterative(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} 
		return found;
	} 

	// Segment 19.20

	/**
	 * Searches an unsorted chain for anEntry by calling a recursive private method.
	 * @param anEntry
	 * @return
	 */
	public boolean searchUnsortedChainRecursive(T anEntry) {
		return search(firstNode, anEntry);
	} 

	/**
	 * Recursively searches a chain of nodes sequentially for desiredItem,
	 *  beginning with the node that currentNode references.
	 * @param currentNode
	 * @param desiredItem
	 * @return
	 */
	private boolean search(Node<T> currentNode, T desiredItem) {
		boolean found;
		if (currentNode == null)
			found = false;
		else if (desiredItem.equals(currentNode.getData()))
			found = true;
		else
			found = search(currentNode.getNextNode(), desiredItem);
		return found;
	} 

	// Segment 19.22.
	
	/**
	 * Searches a sorted chain for anEntry sequentially and iteratively.
	 * @param anEntry
	 * @return
	 */
	public boolean searchSortedChainIterative(T anEntry) {
		Node<T> currentNode = firstNode;
		while ((currentNode != null) && (anEntry.compareTo(currentNode.getData()) > 0)) {
			currentNode = currentNode.getNextNode();
		} 

		return (currentNode != null) && anEntry.equals(currentNode.getData());
	}

	public final void clear() {
		initializeDataFields();
	} 

	@Override
	public int size() {
		return numberOfEntries;
	} 

	public boolean isEmpty() {
		boolean result;

		if (numberOfEntries == 0) // Or getLength() == 0
		{
			// Assertion: firstNode == null
			result = true;
		} else {
			// Assertion: firstNode != null
			result = false;
		} 

		return result;
	} 

	public boolean add(T newEntry) {
		Node<T> newNode = new Node<>(newEntry);

		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);

		lastNode = newNode;
		numberOfEntries++;
		
		return true;
	}

	// the rest of the methods are left unimplemented
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
		return 0;
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
} 
