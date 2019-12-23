package ListPackage;

import java.util.Comparator;

/**
 * A linked implemention of the ADT list.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * @author Jeamin Shin
 * 
 *         modified to use a zero offset for position Uses Node class which is
 *         doubly-linked, but only use forward links here
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
	 * 
	 * @param givenPosition
	 * @return
	 */
	public boolean isInRange(int givenPosition) {
		return (givenPosition >= 0) && (givenPosition < numberOfEntries);
	}

	/**
	 * Return the first node in the list. Violates data hiding.
	 * 
	 * Only used by iterator. In production, the subclass would be final, or the
	 * iterator would be built in from the start.
	 * 
	 * @return
	 */
	protected Node<T> getFirstNode() {
		return firstNode;
	}

	@Override
	public boolean add(T newEntry) {
		Node<T> newNode = new Node<>(newEntry);

		if (isEmpty())
			firstNode = newNode;
		else {
			Node<T> lastNode = getNodeAt(numberOfEntries - 1);
			lastNode.setNextNode(newNode);
		}
		numberOfEntries++;

		return true;
	}

	@Override
	public boolean add(int givenPosition, T newEntry) {
		if (isInRange(givenPosition) || givenPosition == numberOfEntries) {
			Node<T> newNode = new Node<>(newEntry);

			if (isEmpty())
				firstNode = newNode;
			else if (givenPosition == 0) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else {
				// non Empty list
				// if ther was a doubly linked list this would be a bit simpler.
				Node<T> nodeBefore = getNodeAt(givenPosition - 1);
				Node<T> nodeAfter = nodeBefore.getNextNode();

				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
			return true;

		} else
			return false;

	}

	@Override
	public T remove(int givenPosition) {
		if (!isInRange(givenPosition))
			throw new IndexOutOfBoundsException();

		T result = null;// return value. get data as a null.

		if (givenPosition == 0) {// If list has nothing.
			// This is the first entry in the list save the data, then remove the entry.
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();// First node is going to be next node now.
		} else {
			// this is non-empty list.
			// Find the node at the position before the one we are looking for.
			// then get the next node, which is the one to remove.

			Node<T> nodeBefore = getNodeAt(givenPosition - 1);
			Node<T> nodeToRemove = nodeBefore.getNextNode();

			// save the removed node's data
			result = nodeToRemove.getData();

			// finally, remove the node by setting the pointer of the previous node to
			// remove node's next
			// Skip around the removed node.
			Node<T> nodeAfter = nodeToRemove.getNextNode();
			nodeBefore.setNextNode(nodeAfter);
		}
		numberOfEntries--;
		return result;

	}

	@Override
	public boolean removeEntry(T anEntry) {
		// find the entry, then remove it if it exists
		int position = findEntry(anEntry);
		if (position < 0) {
			// entry does not exist.
			return false;
		} else {
			// Assert this position is in range, but check for this anyway.
			if (remove(position) != null) {
				return true;
			} else
				return false;
		}
	}

	@Override
	public void clear() {
		initializeDataFields();
	}

	@Override
	public T replace(int givenPosition, T newEntry) {// replace data.
		if (!isInRange(givenPosition)) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> desiredNode = getNodeAt(givenPosition);
		// extract originalEntry data from givenPosition data.
		T originalEntry = desiredNode.getData();
		desiredNode.setData(newEntry);
		return originalEntry;
	}

	@Override
	public T getEntry(int givenPosition) {
		if (!isInRange(givenPosition)) {
			throw new IndexOutOfBoundsException();
		}
		// get the data from the node.
		// Assert that the node will not be null.
		// as it is in the list range
		return getNodeAt(givenPosition).getData();
	}

	@Override
	public int findEntry(T anEntry) {
		boolean found = false;

		int position = 0;
		Node<T> currentNode = firstNode;
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData())) {
				found = true;
			} else {
				currentNode = currentNode.getNextNode();
				position++;
			}
		}
		if (found == true) {
			return position;
		} else {
			return -1;// make it error. because we could't find.
		}
	}

	@Override
	public T[] toArray() {
		//The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries];
		
		//Traverse the list copying the data at each step
		//note that the array will have zero entries but is not null.
		//if the size is zero.
		int index = 0;
		Node<T> currentNode =firstNode;
		while((index<numberOfEntries)&&(currentNode!=null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();//move next node data
			index++;
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		return findEntry(anEntry) >= 0;
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/**
	 * Returns a reference to the Node<T> at a given position.
	 * 
	 * @param givenPosition
	 * @return
	 */
	private Node<T> getNodeAt(int givenPosition) {
		if (isEmpty())
			return null;

		if (!isInRange(givenPosition))
			throw new IndexOutOfBoundsException();

		// Traverse the chain to locate the desired node

		Node<T> currentNode = firstNode;
		for (int counter = 0; counter < givenPosition; counter++) {
			currentNode = currentNode.getNextNode();
		}
		return currentNode;
	}
}
