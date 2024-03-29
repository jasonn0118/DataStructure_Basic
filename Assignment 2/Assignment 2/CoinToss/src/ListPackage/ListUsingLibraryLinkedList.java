package ListPackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * List class using the java library ArrayList or LinkedList.
 * Comment out the one to use.
 * 
 * @author mhrybyk
 * @author Jeamin Shin
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
		return list.add(newEntry);
	}

	@Override
	public boolean add(int newPosition, T newEntry) {
		if(isInRange(newPosition)) {
			list.add(newPosition,newEntry);
			return true;
		}else if(newPosition ==size()) {
//			the request is to the next free slot past the end of the list, so simply add it
			list.add(newEntry);
			return true;			
		}
		else {
			return false;
		}
	}

	@Override
	public T remove(int givenPosition) {
		if(!isInRange(givenPosition))
			throw new IndexOutOfBoundsException();
		return list.remove(givenPosition);
	}

	@Override
	public boolean removeEntry(T anEntry) {
		return list.remove(anEntry);
	}

	@Override
	public void clear() {

		list.clear();
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if(!isInRange(givenPosition)) {
			throw new IndexOutOfBoundsException();
		}
		return list.set(givenPosition, newEntry);
	}

	@Override
	public T getEntry(int givenPosition) {
		if(!isInRange(givenPosition))
			throw new IndexOutOfBoundsException();
		return list.get(givenPosition);
	}

	@Override
	public int findEntry(T anEntry) {
		return list.indexOf(anEntry);
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Comparable[list.size()];
		return list.toArray(result);
	}

	@Override
	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public boolean isInRange(int givenPosition) {
		return (givenPosition>=0)&&(givenPosition<size());
	}
}
