package ListPackage;

import javax.imageio.IIOException;

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
public class LListWithTail<T extends Comparable<? super T>> implements ListInterface<T> {
	private Node<T> firstNode; // Reference to first node of chain
	private Node<T> lastNode; // Reference to last node of chain
	private int numberOfEntries;

	public LListWithTail() {
		initializeDataFields();
	}

	/**
	 * Reset all data in the list.
	 */
	private void initializeDataFields() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
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

		if (isEmpty()) {
			firstNode = newNode;
		} else {
			// Add to end of nonempty list
			// Make current lastNode reference new node.
			lastNode.setNextNode(newNode);
		}
		// reset lastNode to be the new one added

		lastNode = newNode;
		numberOfEntries++;

		return true;
	}

	@Override
	public boolean add(int newPosition, T newEntry) {
		if (isInRange(newPosition) || newPosition == numberOfEntries) {
			Node<T> newNode = new Node<>(newEntry);

			if (isEmpty()) {
				firstNode = newNode;
				lastNode = newNode;
			} else if (newPosition == 0) {
				// at the start, so just insert at beginning of chain
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else if (newPosition == numberOfEntries) {
				// at the end.
				lastNode.setNextNode(newNode);
				lastNode = newNode;
			} else {
				// in the middle of list.
				Node<T> nodeBefore = getNodeAt(newPosition - 1);
				Node<T> nodeAfter = nodeBefore.getNextNode();

				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T remove(int givenPosition) {
		if(!isInRange(givenPosition)) {
			throw new IndexOutOfBoundsException();
		}
		T result = null;//set initial return value.
		
		if(givenPosition==0) {
			//this is the first entry in the list
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();
		}
		else {
			//this is non-empty list.
			Node<T> nodeBefore = getNodeAt(givenPosition-1);
			Node<T> nodeToRemove = nodeBefore.getNextNode();
			
			result = nodeToRemove.getData();
			
			Node<T> nodeAfter = nodeToRemove.getNextNode();
			nodeBefore.setNextNode(nodeAfter);
			
			//if this is the last node, reset lastNode to the previous
			
			if(givenPosition==numberOfEntries-1) {
				lastNode = nodeBefore;
			}
			
		}
		numberOfEntries--;
		return result;
	}

	@Override
	public boolean removeEntry(T anEntry) {
		//find the entry, then remove it if it exists
		int position=findEntry(anEntry);
		if(position<0) {
			//entry does not exist.
			return false;
		}
		else {
			if(remove(position)!=null) {
				return true;
			}else {
				return false;
			}
		}
	}

	@Override
	public void clear() {
		initializeDataFields();

	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if(!isInRange(givenPosition)) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> desiredNode = getNodeAt(givenPosition);
		T originalEntry = desiredNode.getData();
		desiredNode.setData(newEntry);
		return originalEntry;
	}

	@Override
	public T getEntry(int givenPosition) {
		if(!isInRange(givenPosition)) {
			throw new IndexOutOfBoundsException();
		}
		return getNodeAt(givenPosition).getData();
	}

	@Override
	public int findEntry(T anEntry) {
		boolean found = false;
		int position =0;
		Node<T> currentNode =firstNode;
		while(!found&&(currentNode!=null)) {
			if(anEntry.equals(currentNode.getData())) {
				found = true;
			}else {
				currentNode=currentNode.getNextNode();
				position++;
			}
		}
		if(found==true) {
			return position;
		}else {
			return -1;
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries];
		
		int index = 0;
		Node<T> currentNode = firstNode;
		while((index<numberOfEntries)&&(currentNode!=null)) {
			//index is in the range and also node exists.
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		return findEntry(anEntry)>=0;
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries==0;
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
	 * Returns a reference to the Node<T> at a given position.
	 * 
	 * @param givenPosition
	 * @return
	 */
	private Node<T> getNodeAt(int givenPosition) {
		if(isEmpty()) {
			return null;
		}
		if(!isInRange(givenPosition))
			return null;
		
		//if the last position in the list is desired, no need to traverse it
		if(givenPosition == numberOfEntries-1) {
			return lastNode;
		}
		
		//Traverse the chain to locate the requested node.
		Node<T> currentNode = firstNode;
		for(int index=0;index<givenPosition;index++) {
			currentNode = currentNode.getNextNode();
		}
		return currentNode;
	}

}
