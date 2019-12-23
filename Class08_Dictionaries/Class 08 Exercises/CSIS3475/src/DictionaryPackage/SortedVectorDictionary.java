package DictionaryPackage;

import java.util.Vector;
import java.util.Iterator;

/**
 * A class that implements a dictionary by using a vector. The dictionary is
 * sorted and has distinct search keys. Search keys and associated values are
 * not null.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Now uses public Entry class.
 */
public class SortedVectorDictionary<K extends Comparable<? super K>, V> 
	implements DictionaryInterface<K, V> {
	
	private Vector<Entry<K, V>> dictionary;

	public SortedVectorDictionary() {
		dictionary = new Vector<>(); // Doubles in size, as necessary
	}

	public SortedVectorDictionary(int initialCapacity) {
		dictionary = new Vector<>(initialCapacity);
	}

	@Override
	public V add(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}

	private class KeyIterator implements Iterator<K> {
		private Iterator<Entry<K, V>> traverser;

		private KeyIterator() {
			traverser = dictionary.iterator();
		}

		public boolean hasNext() {
			return traverser.hasNext();
		}

		public K next() {
			Entry<K, V> nextEntry = traverser.next();
			return nextEntry.getKey();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class ValueIterator implements Iterator<V> {
		private Iterator<Entry<K, V>> traverser;

		private ValueIterator() {
			traverser = dictionary.iterator();
		}

		public boolean hasNext() {
			return traverser.hasNext();
		}

		public V next() {
			Entry<K, V> nextEntry = traverser.next();
			return nextEntry.getValue();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * Find next highest index compared to key, or number of entries
	 * @param key
	 * @return index or number of entries (means not found)
	 */
	private int locateIndex(K key) {
		// Search until either you find an entry containing key or
		// you pass the point where it should be
		int numberOfEntries = dictionary.size();
		int index = 0;
		while ((index < numberOfEntries) && key.compareTo((dictionary.get(index)).getKey()) > 0) {
			index++;
		}

		return index;
	}
}
