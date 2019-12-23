package ListPackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List class using the java library ArrayList or LinkedList.
 * Comment out the one to use.
 * 
 * @author mhrybyk
 *
 * @param <T>
 */
public class ListUsingLibraryLinkedList<T extends Comparable<? super T>> implements ListInterface<T>  {

	private List<T> list; // java library List interface
	
	public ListUsingLibraryLinkedList() {
//		list = new LinkedList<>();
		list = new ArrayList<>();
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

}
