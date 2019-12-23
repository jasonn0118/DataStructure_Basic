package DictionaryPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ListPackage.*;
import SortedListPackage.*;

/**
 * A class that implements the ADT dictionary by using an internal list. The
 * dictionary is unsorted or sorted depending on implementation.
 * The dictionary has distinct search keys. Search keys and
 * associated values are not null.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Implemented using ListInterface. Requires a working AList or LList implementation.
 * 
 * Uses public Node and Entry classes.
 */
public class ListDictionary<K extends Comparable<? super K>, V> 
	implements DictionaryInterface<K, V> {

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
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return null;
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



}
