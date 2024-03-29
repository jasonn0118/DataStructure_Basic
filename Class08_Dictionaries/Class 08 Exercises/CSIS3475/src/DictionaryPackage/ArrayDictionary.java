package DictionaryPackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that implements the ADT dictionary by using a resizable array. The
 * dictionary is unsorted and has distinct search keys. Search keys and
 * associated values are not null.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Now uses public Entry class. Keys are Comparable.
 */
public class ArrayDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {
	private Entry<K, V>[] dictionary; // Array of unsorted entries
	private int numberOfEntries;

	private final static int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000; 

	public ArrayDictionary() {
		this(DEFAULT_CAPACITY); // Call next constructor
	} 

	public ArrayDictionary(int initialCapacity) {

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
	 * Returns the array index of the entry that contains key, or
	 *    returns numberOfEntries if no such entry exists.
	 * Precondition: key is not null.
	 * @return
	 */
	private int locateIndex(K key) {
		// TODO - complete code
		return numberOfEntries;
	}
	
	/**
	 * Since iterators implement Iterator, methods must be public.
	 * Same as SortedArrayDictionary.
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
