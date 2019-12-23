package DictionaryPackage;

import java.util.Iterator;
import ListPackage.*;

/**
 * A class that implements the ADT dictionary by using a chain of linked nodes.
 * The dictionary is sorted and has distinct search keys. Search keys and
 * associated values are not null.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 *         Now uses public Node and Entry classes. Key must implement
 *         Comparable.
 *         
 *         remove() changed to use findNode, which is inefficient, but clearer
 */
public class SortedLinkedDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {
	private Node<Entry<K, V>> firstNode; // Reference to first node of chain
	private int numberOfEntries;

	public SortedLinkedDictionary() {
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

	/**
	 * Find the node containing a key
	 * @param key 
	 * @return null if not found, otherwise the node
	 */
	private Node<Entry<K, V>> findNode(K key) {

		Node<Entry<K, V>> currentNode = firstNode;

		while (currentNode != null) {
			if (key.equals(currentNode.getData().getKey()))
				break;
			currentNode = currentNode.getNextNode();

		}
		return currentNode;

	}

	/**
	 * Find the previous node of the one containing a key
	 * @param key
	 * @return null if at the beginning or not found, otherwise the previous node
	 */
	private Node<Entry<K, V>> findNodeBefore(K key) {
		if (isEmpty())
			return null;

		Node<Entry<K, V>> currentNode = firstNode;
		Node<Entry<K, V>> nodeBefore = null;

		// iterate until the key is less than or equal to the current node's key
		while (currentNode != null) {
			if (key.compareTo(currentNode.getData().getKey()) <= 0)
				break;
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}

		// if not found, it will be null
		// if less than the first node, null will be returned as well
		
		return nodeBefore;

	}



	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	} 

	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	} 

	private class KeyIterator implements Iterator<K> {
		private Node<Entry<K, V>> nextNode;

		private KeyIterator() {
			nextNode = firstNode;
		} 

		public boolean hasNext() {
			return nextNode != null;
		} 

		public K next() {
			K result;

			if (hasNext()) {
				result = nextNode.getData().getKey();
				nextNode = nextNode.getNextNode();
			} else {
				return null;
			} 

			return result;
		} 
	} 

	private class ValueIterator implements Iterator<V> {
		private Node<Entry<K, V>> nextNode;

		private ValueIterator() {
			nextNode = firstNode;
		} 

		public boolean hasNext() {
			return nextNode != null;
		} 

		public V next() {
			V result;

			if (hasNext()) {
				result = nextNode.getData().getValue();
				nextNode = nextNode.getNextNode();
			} else {
				return null;
			} 

			return result;
		} 
	}

}
