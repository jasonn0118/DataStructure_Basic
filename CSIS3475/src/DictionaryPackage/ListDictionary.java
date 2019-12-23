package DictionaryPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ListPackage.*;
import SortedListPackage.*;

/**
 * A class that implements the ADT dictionary by using an internal list. The
 * dictionary is unsorted or sorted depending on implementation. The dictionary
 * has distinct search keys. Search keys and associated values are not null.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 *         Implemented using ListInterface. Requires a working AList or LList
 *         implementation.
 * 
 *         Uses public Node and Entry classes.
 */
public class ListDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {

	private final static int DEFAULT_CAPACITY = 25;

	private ListInterface<Entry<K, V>> dictionary;

	public ListDictionary() {
		this(DEFAULT_CAPACITY); // Call next constructor
	}

	public ListDictionary(int initialCapacity) {

//		dictionary = new SortedAList<>(initialCapacity);
//		dictionary = new SortedLList<>();
		dictionary = new AList<>(initialCapacity);
//		dictionary = new LList<>();
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	private class KeyIterator implements Iterator<K> {
		private int currentIndex;

		private KeyIterator() {
			currentIndex = 0;
		}

		@Override
		public boolean hasNext() {
			return currentIndex < dictionary.size();
		}

		@Override
		public K next() {
			K result = null;
			if (hasNext()) {
				result = dictionary.getEntry(currentIndex).getKey();
				currentIndex++;
			} else {
				throw new NoSuchElementException();
			}
			return result;
		}

	}

	@Override
	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}

	private class ValueIterator implements Iterator<V> {
		private int currentIndex;

		private ValueIterator() {
			currentIndex = 0;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public V next() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@Override
	public V add(K key, V value) {
		if ((key == null) || (value == null))
			return null;
		// find the entry

		V result = null;
		Entry<K, V> entry = new Entry<>(key, value);
		int index = dictionary.findEntry(entry);

		// if the entry does not exist, add it.
		// if the entry exists, replace the value.
		if (index < 0) {
			dictionary.add(entry);
		} else {
			// get the original and replace the value.
			Entry<K, V> original = dictionary.getEntry(index);
			result = original.getValue();
			original.setValue(value);
		}
		return result;
	}

	@Override
	public V remove(K key) {
		if (key == null)
			return null;

		V result = null;
		// find the entry
		Entry<K, V> entry = new Entry<>(key, null);
		int index = dictionary.findEntry(entry);

		// if it exists, remove it
		// cannot use removeEntry() as the value will not be returned.

		if (index >= 0) {
			Entry<K, V> original = dictionary.remove(index);
			result = original.getValue();
		}
		return result;
	}

	@Override
	public V getValue(K key) {
		if (key == null) {
			return null;
		}
		V result = null;
		//find the entry
		
		Entry<K,V> entry = new Entry<>(key,null);// to access the entry in the Map. 
		int index = dictionary.findEntry(entry);
		
		//if it exists, get the value associated with the key
		if(index >= 0) {
			result = dictionary.getEntry(index).getValue();
		}
		return result;
	}

	@Override
	public boolean contains(K key) {
		if(key==null)
			return false;
		Entry<K,V> entry = new Entry<>(key,null);
		return dictionary.findEntry(entry)>=0;
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

}
