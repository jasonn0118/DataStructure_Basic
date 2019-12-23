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
 * @author Jeamin Shin
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
		ensureCapacity();
		if((key==null)||(value==null)) {
			return null;
		}
		else {
			V result = null;
			int keyIndex = locateIndex(key);
			if((keyIndex<numberOfEntries)&&key.equals(dictionary[keyIndex].getKey())) {
				//key found, return and replace entry's value
				result = dictionary[keyIndex].getValue();
				dictionary[keyIndex].setValue(value);
			}
			else {
				//key has not found, add new entry to dictionary
				makeRoom(keyIndex);
				dictionary[keyIndex] = new Entry<>(key,value);
				numberOfEntries++;
			}
			return result;
		}
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
		V result = null;
		int keyIndex = locateIndex(key);
		if((keyIndex<numberOfEntries)&&key.equals(dictionary[keyIndex].getKey())) {
			result = dictionary[keyIndex].getValue();
			removeArrayEntry(keyIndex);
			numberOfEntries--;
		}
		return result;
	}

	@Override
	public V getValue(K key) {
		V result = null;
		int keyIndex = locateIndex(key);
		
		//position is found, if key matches, return the value.
		if((keyIndex<numberOfEntries)&&key.equals(dictionary[keyIndex].getKey())) {
			result = dictionary[keyIndex].getValue();//key found, return value.
		}
		return result;
	}

	@Override
	public boolean contains(K key) {
		return getValue(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries==0;
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public void clear() {
		
		for(int i =0;i<=numberOfEntries;i++) {
			dictionary[i] = null;
		}
		numberOfEntries=0;
		
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
		int index = 0;
		while((index<numberOfEntries)&&key.compareTo(dictionary[index].getKey())>0) {
			index++;
		}
		return index;
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
		for(int index = numberOfEntries-1;index>=keyIndex;index--) {
			dictionary[index+1] = dictionary[index];//Shift right.
		}
	
	}

	/**
	 * Removes an entry at a given index by shifting array entries toward the entry
	 * to be removed.
	 * 
	 * @param keyIndex
	 */
	private void removeArrayEntry(int keyIndex) {
		for(int frontIndex =  keyIndex+1;frontIndex<numberOfEntries;frontIndex++) {
			dictionary[frontIndex-1] = dictionary[frontIndex];//shift left.
		}
		dictionary[numberOfEntries-1]=null;
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
