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

	private CompletedSortedAList<Entry<K, V>> dictionary;

	public SortedListDictionary() {
		this(DEFAULT_CAPACITY); // Call next constructor
	}

	public SortedListDictionary(int initialCapacity) {

		dictionary = new CompletedSortedAList<>(initialCapacity);
	}

	@Override
	public V add(K key, V value) {
		if((key==null)||(value==null))
			return null;
		V result = null;
		Entry<K,V> entry = new Entry<>(key,value);
		int index = dictionary.findEntry(entry);
		
		if(index<0) {
			dictionary.add(entry);
		}else {
			Entry<K,V> original = dictionary.getEntry(index);
			result = original.getValue();
			original.setValue(value);
		}
		return result;
	}

	@Override
	public V remove(K key) {
		if(key==null)
			return null;
		
		V result = null;
		Entry<K,V> entry = new Entry<>(key,null);
		int index = dictionary.findEntry(entry);
		
		if(index>=0) {
			Entry<K,V> original = dictionary.remove(index);
			result = original.getValue();
		}
		return result;
	}

	@Override
	public V getValue(K key) {
		if(key==null)
			return null;
		
		V result = null;
		
		Entry<K,V> entry = new Entry<>(key,null);
		int index = dictionary.findEntry(entry);
		
		if(index>=0) {
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
