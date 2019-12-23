package QueuePackage;
/**
 * A class that implements the ADT deque by using a doubly linked chain of
 * nodes.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class LinkedDeque<T> implements DequeInterface<T> {
	private DoublyLinkedNode<T> firstNode; // References node at front of deque
	private DoublyLinkedNode<T> lastNode; // References node at back of deque

	public LinkedDeque() {
		firstNode = null;
		lastNode = null;
	}

	@Override
	public void addToFront(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToBack(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeBack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getBack() {
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
