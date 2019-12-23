package QueuePackage;

/**
 * A class that implements a queue of objects by using a chain of linked nodes
 * that has both head and tail references.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author Jeamin Shin
 * @version 5.0
 */
public final class LinkedQueue<T> implements QueueInterface<T> {
	private Node<T> firstNode; // References node at front of queue
	private Node<T> lastNode; // References node at back of queue
	int numberOfEntries;

	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	} // end default constructor

	@Override
	public void enqueue(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry,null);
		if(isEmpty()) {
			firstNode=newNode;
		}else {
			lastNode.setNextNode(newNode);
		}
		lastNode = newNode;
		numberOfEntries++;
		
		
	}

	@Override
	public T dequeue() {
		T result = getFront();
		firstNode.setData(null);
		firstNode=firstNode.getNextNode();
		if(firstNode==null) {
			lastNode =null;
		}
		numberOfEntries--;
		return result;
	}

	@Override
	public T getFront() {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		return firstNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return (firstNode==null)&&(lastNode==null);
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[])new Object[this.size()];
		
		int index=0;
		for(Node<T> currentNode = firstNode;currentNode!=null;currentNode=currentNode.getNextNode()) {
			tempQueue[index] = currentNode.getData();
			index++;
		}
		return tempQueue;
	}
} // end LinkedQueue
