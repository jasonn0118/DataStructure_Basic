package HashingPackage;

import java.util.Collection;
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
		hashTable.put(key, value);
		return hashTable.get(key);
	}

	@Override
	public V remove(K key) {
		return hashTable.remove(key);
	}

	@Override
	public V getValue(K key) {
		return hashTable.get(key);
	}

	@Override
	public boolean contains(K key) {
		return hashTable.containsKey(key);
	}

	@Override
	public Iterator<K> getKeyIterator() {
		Iterator<K> keyIterator;
		Collection<K> keyList = hashTable.keySet();
		keyIterator = (Iterator<K>) keyList.iterator();
		return keyIterator;
	}

	@Override
	public Iterator<V> getValueIterator() {
		Iterator<V> valueIterator;
		Collection<V> valueList = (Collection<V>) hashTable.entrySet();
		valueIterator =(Iterator<V>) valueList.iterator();
		return valueIterator;
	}

	@Override
	public boolean isEmpty() {
		return hashTable.isEmpty();
	}

	@Override
	public int size() {
		return hashTable.size();
	}

	@Override
	public void clear() {
		hashTable.clear();
		
	}



}
