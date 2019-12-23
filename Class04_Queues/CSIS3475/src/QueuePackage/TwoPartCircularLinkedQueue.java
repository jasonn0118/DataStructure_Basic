package QueuePackage;
/**
 * A class that implements the ADT queue by using a two-part circular chain of
 * linked nodes.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class TwoPartCircularLinkedQueue<T> implements QueueInterface<T> {
	private Node<T> queueNode; // References first node in queue
	private Node<T> freeNode; // References node after back of queue, chain of unallocated nodes
	int numberOfEntries;

	public TwoPartCircularLinkedQueue() {
		freeNode = new Node<>(null, null);
		freeNode.setNextNode(freeNode);   // links to itself
		queueNode = freeNode;  // queueNode will be at the top of the chain
	    numberOfEntries = 0;
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


	
} 
