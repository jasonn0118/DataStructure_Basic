package QueuePackage;
/**
 * A class that implements a queue of objects by using a chain of linked nodes
 * that has both head and tail references.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class LinkedQueue<T> implements QueueInterface<T> {
	private Node<T> firstNode; // References node at front of queue
	private Node<T> lastNode; // References node at back of queue

	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	} // end default constructor

	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub

	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
} // end LinkedQueue
