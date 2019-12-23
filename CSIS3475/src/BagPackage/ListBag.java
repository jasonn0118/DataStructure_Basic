package BagPackage;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of Bag interface using either ArrayList or LinkedList from java library
 * 
 * @author mhrybyk
 *
 * @param <T> type of object to be held in the bag
 */
public class ListBag<T> implements BagInterface<T> {

	private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
	
	List<T> bag;  // use a List for our bag
	
	public ListBag() {
		
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Create bag with a size. Implemented using ArrayList, but
	 * could use LinkedList as well.
	 * @param capacity
	 */
	public ListBag(int capacity) {
//		bag = new LinkedList<T>();
		bag = new ArrayList<>(capacity);  // bag is an ArrayList of some size		
	}
	
	/**
	 * Add an array of objects to a bag.
	 * @param contents array of objects
	 */
	public ListBag(T[] contents) {
		this(contents.length);
		
		for(T item : contents) {
			bag.add(item);
		}

	}
	@Override
	public int size() {
		return bag.size();
	}

	@Override
	public boolean isEmpty() {
		return bag.isEmpty();
	}

	@Override
	public boolean add(T newEntry) {
		return bag.add(newEntry);
	}

	@Override
	public T remove() {
		// get the last element's index
		int lastIndex = size() - 1;
		
		// get the object at the last location to return to caller
		T entry = bag.get(lastIndex);
		
		// now remove it from the bag and return it to the caller
		bag.remove(lastIndex);
		return entry;
	}

	@Override
	public boolean remove(T anEntry) {
		
		return bag.remove(anEntry);
	}

	@Override
	public void clear() {
		bag.clear();
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		for(T bagEntry : bag) {
			if(bagEntry.equals(anEntry))
				count++;
		}
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		return bag.contains(anEntry);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		return (T[]) bag.toArray();
	}

}
