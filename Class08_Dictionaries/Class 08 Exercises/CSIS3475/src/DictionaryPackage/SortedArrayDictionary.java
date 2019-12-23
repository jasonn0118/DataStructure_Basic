package DictionaryPackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that implements the ADT dictionary by using a resizable array. The
 * dictionary is sorted and has distinct search keys. Search keys and associated
 * values are not null.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 *         Now uses public Entry class.
 */
public class SortedArrayDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {
	private Entry<K, V>[] dictionary; // Array of sorted entries by key
	private int numberOfEntries;

	private final static int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000; 

	public SortedArrayDictionary() {
		this(DEFAULT_CAPACITY); // Call next constructor
	} 

	public SortedArrayDictionary(int initialCapacity) {

		checkCapacity(initialCapacity);
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		Entry<K, V>[] tempDictionary = (Entry<K, V>[]) new Entry[initialCapacity];
		dictionary = tempDictionary;
		numberOfEntries = 0;
	}



	@Override
	public V add(K key, V value) {
		// TODO Auto-generated method stub
		// don't forget to ensureCapacity() here
		return null;
	}

	/**
	 * Doubles the size of the array dictionary if it is full.
	 */
	private void ensureCapacity() {
		if (numberOfEntries >= dictionary.length) {
			int newCapacity = 2 * dictionary.length;
			checkCapacity(newCapacity);
			dictionary = Arrays.copyOf(dictionary, newCapacity);
		}
	}

	/**
	 * Checks to see if requested capacity will fit
	 * 
	 * @param capacity requested capacity
	 */
	private void checkCapacity(int capacity) {
		if (capacity < DEFAULT_CAPACITY)
			capacity = DEFAULT_CAPACITY;
		else if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a dictionary " + "whose capacity is larger than " + MAX_CAPACITY);
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

	/**
	 * Returns the index of either the entry that contains key or the location that
	 * should contain key, if no such entry exists.
	 * 
	 * @param key
	 * @return
	 */
	private int locateIndex(K key) {
		// TODO - complete code
		return 0;
	}

	/**
	 * Makes room for a new entry at a given index by shifting array entries towards
	 * the end of the array.
	 * 
	 * @param keyIndex must be in range
	 */
	private void makeRoom(int keyIndex) {
		// Move each entry to next higher position beginning at end of list
		// and continuing until item at newPosition is moved
		
		// TODO - complete code
	
	}

	/**
	 * Removes an entry at a given index by shifting array entries toward the entry
	 * to be removed.
	 * 
	 * @param keyIndex
	 */
	private void removeArrayEntry(int keyIndex) {
		// TODO - complete code
	}

	/**
	 * Since iterators implement Iterator, methods must be public Same as
	 * ArrayDictionary
	 */
	private class KeyIterator implements Iterator<K> {
		private int currentIndex;

		private KeyIterator() {
			currentIndex = 0;
		}

		public boolean hasNext() {
			return currentIndex < numberOfEntries;
		} 

		public K next() {
			K result = null;

			if (hasNext()) {
				Entry<K, V> currentEntry = dictionary[currentIndex];
				result = currentEntry.getKey();
				currentIndex++;
			} else {
				throw new NoSuchElementException();
			}

			return result;
		}

	}

	/**
	 * Since iterators implement Iterator, methods must be public Same as
	 * ArrayDictionary
	 */
	private class ValueIterator implements Iterator<V> {
		private int currentIndex;

		private ValueIterator() {
			currentIndex = 0;
		}

		public boolean hasNext() {
			return currentIndex < numberOfEntries;
		}

		public V next() {
			V result = null;

			if (hasNext()) {
				Entry<K, V> currentEntry = dictionary[currentIndex];
				result = currentEntry.getValue();
				currentIndex++;
			} else {
				throw new NoSuchElementException();
			}

			return result;
		}
	}
}
