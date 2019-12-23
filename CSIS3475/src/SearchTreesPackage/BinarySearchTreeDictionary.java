package SearchTreesPackage;

import java.util.Iterator;

import DictionaryPackage.*;

/**
 * A class that implements the ADT dictionary by using a binary search tree. The
 * dictionary is sorted and has distinct search keys.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class BinarySearchTreeDictionary<K extends Comparable<? super K>, V> 
	implements DictionaryInterface<K, V> {
	
	private SearchTreeInterface<Entry<K, V>> binarySearchTree;

	public BinarySearchTreeDictionary() {
		binarySearchTree = new BinarySearchTree<>();
	} 


	public boolean isEmpty() {
		return binarySearchTree.isEmpty();
	} 

	public int size() {
		return binarySearchTree.getNumberOfNodes();
	} 

	public void clear() {
		binarySearchTree.clear();
	} 

	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	} 

	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	} 

	private class KeyIterator implements Iterator<K> {
		Iterator<Entry<K, V>> localIterator;

		public KeyIterator() {
			localIterator = binarySearchTree.getInorderIterator();
		} 

		public boolean hasNext() {
			return localIterator.hasNext();
		} 

		public K next() {
			Entry<K, V> nextEntry = localIterator.next();
			return nextEntry.getKey();
		} 

		public void remove() {
			throw new UnsupportedOperationException();
		} 
	} 

	private class ValueIterator implements Iterator<V> {
		Iterator<Entry<K, V>> localIterator;

		public ValueIterator() {
			localIterator = binarySearchTree.getInorderIterator();
		} 

		public boolean hasNext() {
			return localIterator.hasNext();
		} 

		public V next() {
			Entry<K, V> nextEntry = localIterator.next();
			return nextEntry.getValue();
		} 

		public void remove() {
			throw new UnsupportedOperationException();
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
} 
