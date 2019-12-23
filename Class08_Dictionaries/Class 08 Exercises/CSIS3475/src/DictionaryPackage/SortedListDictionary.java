package DictionaryPackage;

import java.util.Iterator;

import SortedListPackage.*;

/**
 * A class that implements the ADT dictionary by using a fixed size array. The
 * dictionary is kept sorted and has distinct search keys. Search keys and
 * associated values are not null.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Implemented using SortedAList or SortedLList. Requires a working SortedAList/SortedLList implementation.
 * 
 * Uses public Node and Entry classes.
 * 
 * If SortedAList/SortedLList had iterators, we wouldn't have to add them here.
 */
public class SortedListDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {

	private final static int DEFAULT_CAPACITY = 25;

	private SortedAList<Entry<K, V>> dictionary;

	public SortedListDictionary() {
		this(DEFAULT_CAPACITY); // Call next constructor
	}

	public SortedListDictionary(int initialCapacity) {

		dictionary = new SortedAList<>(initialCapacity);
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

	@Override
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	@Override
	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}

	private class KeyIterator implements Iterator<K> {
		private int currentIndex;

		private KeyIterator() {
			currentIndex = 0;
		}

		public boolean hasNext() {
			return currentIndex < dictionary.size();
		}

		public K next() {
			K result = null;

			if (hasNext()) {
				result = dictionary.getEntry(currentIndex).getKey();
				currentIndex++;
			} else {
				return null;
			}

			return result;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class ValueIterator implements Iterator<V> {
		private int currentIndex;

		private ValueIterator() {
			currentIndex = 0;
		}

		public boolean hasNext() {
			return currentIndex < dictionary.size();
		}

		public V next() {
			V result = null;

			if (hasNext()) {
				result = dictionary.getEntry(currentIndex).getValue();
				currentIndex++;
			} else {
				return null;
			}

			return result;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
