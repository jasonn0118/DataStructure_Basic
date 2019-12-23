package DictionaryPackage;

/**
 * Dictionary Entry with a key and a value
 * 
 * The key needs to extend Comparable.
 * 
 * Entry implements Comparable but *only* compares keys for compareTo() and equals().
 * Data value is not compared.
 * 
 * This assumes keys will be unique.
 * 
 * @author mhrybyk
 *
 * @param <K>
 * @param <V>
 */
public class Entry<K extends Comparable<? super K>, V> 
	implements Comparable<Entry<K,V>> {
	
	private K key;
	private V value;

	public Entry(K searchKey, V dataValue) {
		key = searchKey;
		value = dataValue;
	} 

	public K getKey() {
		return key;
	} 

	public V getValue() {
		return value;
	} 

	public void setValue(V dataValue) {
		value = dataValue;
	}

	@Override
	public int compareTo(Entry<K, V> obj) {
		// if only looking for the key, a new entry
		//  with a value of null will have to be used
		
		// if this is the same object, then we are equal
		if (this == obj)
			return 0;
		
		// if the object we are comparing is null,
		// then we are higher
		if(obj == null)
			return 1;
		
		Entry<K, V> other = (Entry<K, V>) obj;
		
		// if we are null, we are lower
		// if both are null, then return equals
		
		if (key == null) {
			// null is always lower
			if (other.key != null)
				return -1;
			else return 0;
		}
		
		// this is a repeat of above for safety
		
		if(other.key == null)
			return 1;
		
		// done accounting for nulls, simply return compareTo()
		
		return key.compareTo(other.key);
	}

	@Override
	public boolean equals(Object obj) {
		
		// if only looking for the key, a new entry
		//  with a value of null will have to be used
		
		// this code is auto-generated by eclipse
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		// simply compare the keys for equality
		//  we don't really care about the value
		//  as keys must be unique
		@SuppressWarnings("unchecked")
		Entry<K, V> other = (Entry<K, V>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;

		return true;
	}
	
	@Override
	public String toString() {
		return "[Key: " + key + ", Value: " + value + "]";
	}
	
	
}
