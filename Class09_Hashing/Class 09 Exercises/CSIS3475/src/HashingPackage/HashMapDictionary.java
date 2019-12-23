package HashingPackage;

import java.util.HashMap;
import java.util.Iterator;

import DictionaryPackage.*;

/**
 * Implements DictionaryInterface using the java library HashMap
 * 
 * @author mhrybyk
 *
 * @param <K> key
 * @param <V> value
 */
public class HashMapDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {

	private HashMap<K, V> hashTable;
	
	/**
	 * Creates internal HashMap for use
	 */
	public HashMapDictionary() {
		hashTable = new HashMap<>();
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
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
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
