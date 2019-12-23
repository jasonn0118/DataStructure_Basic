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
		if((key==null)||(value==null)) {
			return null;
		}else {
			V result = null;
			Entry<K,V> entry = new Entry<>(key,value);
			
			//Search chain for a node containing key
			Node<Entry<K,V>> node = findNode(key);
			
			if(node==null) {
				//key not in dictionary; add new node at beginning of chain
				Node<Entry<K,V>> newNode = new Node<>(entry);
				newNode.setNextNode(firstNode);
				firstNode = newNode;
				numberOfEntries++;
			}else {
				//key in dictionary; replace corresponding value.
				Entry<K,V> original = node.getData();
				result = original.getValue();//Get ready to return removed entry
				original.setValue(value);//Replace value.
			}
			return result;
		}
	}

	@Override
	public V remove(K key) {
		V result = null;
		if(!isEmpty()) {
			//Search chain for a node containing key.
			//Save reference to preceding node.
			Entry<K,V> entry = new Entry<>(key,null);
			Node<Entry<K,V>> currentNode = firstNode;
			Node<Entry<K,V>> nodeBefore = null;
			
			while((currentNode!=null)&&!entry.equals(currentNode.getData())) {
				nodeBefore = currentNode;
				currentNode = currentNode.getNextNode();
			}
			if(currentNode!=null) {
				//node found, remove it.
				//Node after the one to be removed
				Node<Entry<K,V>> nodeAfter = currentNode.getNextNode();
				
				//if there was no preceding node, then the current node is actually firstNode
				//so set the firstNode to the one following.
				if(nodeBefore==null)
					firstNode = nodeAfter;
				else {
					nodeBefore.setNextNode(nodeAfter);//Disconnect the node to be removed
				}
				result = currentNode.getData().getValue();
				numberOfEntries--;
			}
		}
		return result;
	}

	@Override
	public V getValue(K key) {
		V result = null;
		
		//Search for a node that contains key
		Node<Entry<K,V>> node = findNode(key);
		
		if(node!=null) {
			//Search key found, get the value.
			Entry<K,V> foundEntry = node.getData();
			if(foundEntry!=null) {
				result = foundEntry.getValue();
			}
		}
		return result;
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
		
		Node<Entry<K,V>> node = firstNode;
		
		//iterate until entry is found.
		while(node != null) {
			Entry<K,V> entry = node.getData();
			if(entry!=null&&key.equals(entry.getKey())) {
				break;
			}
			node = node.getNextNode();
		}
		return node;
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
