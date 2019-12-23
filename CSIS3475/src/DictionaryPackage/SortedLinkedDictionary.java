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
		V result = null;
		if ((key == null) || (value == null)) {
			return null;
		} else {
			Node<Entry<K, V>> currentNode = firstNode;
			Node<Entry<K, V>> nodeBefore = null;

			// traverse the chain until key is smaller than the current node's key
			nodeBefore = findNodeBefore(key);
			if (nodeBefore != null) {
				currentNode = nodeBefore.getNextNode();
			}

			if ((currentNode != null) && key.equals(currentNode.getData().getKey())) {
				// key found in dictionary so replace corresponding value.
				result = currentNode.getData().getValue();// Got old value.
				currentNode.getData().setValue(value);// Replace value.
			} else {
				// key found in dictionary; add new node in proper order
				// first create a new with a dictionary entry
				Entry<K, V> newEntry = new Entry<>(key, value);
				// Assertion, key and value are not null.
				Node<Entry<K, V>> newNode = new Node<>(newEntry);// Create new node.

				if (nodeBefore == null) {
					// we are at the beginning, insert the new node ahead of the first one.
					// if the chain is empty, this still works
					newNode.setNextNode(firstNode);
					firstNode = newNode;
				} else {
					// insert into the chain
					// currentNode is after new node.
					newNode.setNextNode(currentNode);

					// nodeBefore is before new node
					nodeBefore.setNextNode(newNode);
				}
				numberOfEntries++;
			}
			return result;
		}
	}

	@Override
	public V remove(K key) {
		if (isEmpty() || key == null)
			return null;
		// find the node before the key
		// to remove, connect nodeBefore to nodeAfter.
		Node<Entry<K, V>> currentNode = firstNode;
		Node<Entry<K, V>> nodeBefore = null;

		// Look for the previous node to the one with the key.
		// Then get the next node which should contain the key.
		// if the key matches, then disconnect the node.

		// This would be easier with a doubly linked list.
		// we would just find the node, then link previous to next.

		nodeBefore = findNodeBefore(key);
		if (nodeBefore != null) {
			currentNode = nodeBefore.getNextNode();
		}

		// if the current node is null, it means the list was traversed to the end
		// without finding the key.
		if (currentNode == null)
			return null;

		// determine if the key matches the current node's key
		if (!key.equals(currentNode.getData().getKey())) {
			return null;
		}

		// if not at the beginning of the list, disconnect the node to remove.
		if (currentNode == firstNode)
			firstNode = firstNode.getNextNode();
		else {
			Node<Entry<K, V>> nodeAfter = currentNode.getNextNode();
			nodeBefore.setNextNode(nodeAfter);
		}

		// Save the old value to caller
		V result = currentNode.getData().getValue();
		numberOfEntries--;
		return result;
	}

	@Override
	public V getValue(K key) {
		V result = null;

		// Search for a node that contains key
		Node<Entry<K, V>> node = findNode(key);

		if (node != null) {
			// Search key found, get the value.
			Entry<K, V> foundEntry = node.getData();
			if (foundEntry != null) {
				result = foundEntry.getValue();
			}
		}
		return result;
	}

	@Override
	public boolean contains(K key) {
		return getValue(key)!=null;
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
		initializeDataFields();
	}

	/**
	 * Find the node containing a key
	 * 
	 * @param key
	 * @return null if not found, otherwise the node
	 */
	private Node<Entry<K, V>> findNode(K key) {
		if(key == null)
			return null;
		
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
	 * 
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
