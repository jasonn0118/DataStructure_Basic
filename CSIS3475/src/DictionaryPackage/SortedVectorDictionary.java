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
		if((key==null)||(value==null)) {
			throw new IllegalArgumentException("Cannot add null to a dictionary");
		}
		else {
			V result = null;
			//Search until either you find an entry containing key or you pass the point
			//where it should be.
			int keyIndex = locateIndex(key);
			
			if((keyIndex<dictionary.size())&&key.equals((dictionary.get(keyIndex)).getKey())) {
				//key found, return and replace old value.
				Entry<K,V> currentEntry = dictionary.get(keyIndex);
				result = currentEntry.getValue();//get current value for return.
				currentEntry.setValue(value);//replace value.
			}else {
				//add new entry.
				Entry<K,V> newEntry = new Entry<>(key,value);
				dictionary.add(keyIndex,newEntry);
			}
			return result;
		}
	}

	@Override
	public V remove(K key) {
		V result = null;
		//Search until either you find an entry containing key or you pass
		//the point where it should be.
		int keyIndex = locateIndex(key);
		
		if((keyIndex<dictionary.size())&&key.equals((dictionary.get(keyIndex)).getKey())){
			Entry<K,V> currentEntry = dictionary.remove(keyIndex); //Get and remove entry
			result = currentEntry.getValue();//get current Value for return.
		}
		return result;
	}

	@Override
	public V getValue(K key) {
		V result = null;
		
		int keyIndex = locateIndex(key);
		
		if((keyIndex<dictionary.size())&&key.equals((dictionary.get(keyIndex)).getKey())) {
			result = (dictionary.get(keyIndex)).getValue();
		}
		return result;
	}

	@Override
	public boolean contains(K key) {
		return getValue(key)!=null;
	}

	@Override
	public boolean isEmpty() {
		return dictionary.isEmpty();
	}

	@Override
	public int size() {
		return dictionary.size();
	}

	@Override
	public void clear() {
		dictionary.clear();
		
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
