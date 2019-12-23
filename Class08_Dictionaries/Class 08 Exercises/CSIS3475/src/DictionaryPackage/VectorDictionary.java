package DictionaryPackage;

import java.util.Iterator;
import java.util.Vector;

public class VectorDictionary<K extends Comparable<? super K>, V> 
	implements DictionaryInterface<K, V> {
	
	private Vector<Entry<K, V>> dictionary;

	public VectorDictionary() {
		dictionary = new Vector<>(); // Doubles in size, as necessary
	}

	public VectorDictionary(int initialCapacity) {
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



	// for key/value iterators, just traverse all of the entries
	// and then get either the key or the value
	
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
	}

}
