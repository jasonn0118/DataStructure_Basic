package DictionaryPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ListPackage.*;

/**
 * A class that implements the ADT dictionary by using a chain of nodes. The
 * dictionary is unsorted and has distinct search keys.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Uses public Node and Entry classes. Added findNode() method
 */
public class LinkedDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {
	private Node<Entry<K,V>> firstNode; // Reference to first node of chain
	private int numberOfEntries;

	public LinkedDictionary() {
		initializeDataFields();
	} 
	
	/**
	 * Initializes the class's data fields to indicate an empty list.
	 */
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
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

	/**
	 * Find the node containing a key
	 * 
	 * @param key
	 * @return null if not found, otherwise the node
	 */
	private Node<Entry<K, V>> findNode(K key) {
		// TODO - complete code
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
		Node<Entry<K, V>> nextNode;

		private KeyIterator() {
			nextNode = firstNode;
		} 

		public boolean hasNext() {
			return nextNode != null;
		} 

		public K next() {
			K result;

			if (hasNext()) {
				Entry<K, V> original = nextNode.getData();	
				result = original.getKey();
				nextNode = nextNode.getNextNode();
			} else {
				throw new NoSuchElementException();
			} 

			return result;
		} 
	} 

	private class ValueIterator implements Iterator<V> {
		Node<Entry<K, V>> nextNode;

		private ValueIterator() {
			nextNode = firstNode;
		} 

		public boolean hasNext() {
			return nextNode != null;
		} 

		public V next() {
			V result;

			if (hasNext()) {
				Entry<K, V> original = nextNode.getData();	
				result = original.getValue();
				nextNode = nextNode.getNextNode();
			} else {
				throw new NoSuchElementException();
			} 

			return result;
		} 
	} 
} 
