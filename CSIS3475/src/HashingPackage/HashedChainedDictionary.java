package HashingPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import DictionaryPackage.*;
import ListWithIteratorsPackage.*;

/**
 * 
 * Implements a hash table ADT by using an array of lists;
 * 
 * The lists must implement ListWithIteratorInterface.
 * 
 * Items in each list consist of Entry objects.
 * 
 * In general, this is a cleaner implementation than that in the textbook, and
 * uses both the dictionary and list ADT implementations created previously.
 * 
 * LListWithIterator is used here, but AListWithIterator could also be used.
 * 
 * @author mhrybyk
 *
 */
public class HashedChainedDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {
	// capacity must be prime, which checkCapacity will automatically set
	// if this is set too low with quadratic probe, search time increases.
	private static final int DEFAULT_CAPACITY = 2;
	private static final int MAX_CAPACITY = 1000000;

	private int numberOfEntries;

	// keep a count of hash table slots used.
	// the count is used to increase the table size if necessary

	private int occupiedHashTableSlots;

	// The hash table is an array of lists.
	// The list must implement Iterator.

	private ListWithIteratorInterface<Entry<K, V>>[] hashTable;

	private static final int MAX_SIZE = 2 * MAX_CAPACITY; // Max size of hash table
	private static final double MAX_LOAD_FACTOR = .5; // Fraction of hash table that can be filled

	public HashedChainedDictionary() {
		this(DEFAULT_CAPACITY); // Call next constructor
	}

	public HashedChainedDictionary(int initialCapacity) {

		// create a new hash table

		createHashTable(initialCapacity);
	}

	/**
	 * Throws an exception if the hash table becomes too large.
	 * 
	 * @param size
	 */
	private void checkSize(int size) {
		if (size > MAX_SIZE)
			throw new IllegalStateException("Dictionary has become too large.");
	}

	/**
	 * Create a new hash table of a certain size. The size will be of the next prime
	 * number over that requested. This guarantees the table will always be of prime
	 * size.
	 * 
	 * All entries from the old table are added to the new table, which rehashes all
	 * entries.
	 * 
	 * @param newSize
	 */
	private void createHashTable(int newSize) {

		// save the old table location

		ListWithIteratorInterface<Entry<K, V>>[] oldTable = hashTable;

		int oldSize = 0;

		// if the hash table already exists, save its size

		if (hashTable != null)
			oldSize = hashTable.length;

		// Initial size of hash table if it is prime;
		// otherwise increase it until it is prime size
		newSize = getNextPrime(newSize);

		checkSize(newSize); // Check that the prime size is not too large

//		System.out.println("table size increased from " + oldSize + " to " + newSize + ", occupied " + occupiedHashTableSlots);

		// create the new table

		// The cast is safe because the new array contains null entries
		// increase the size of the array
		@SuppressWarnings("unchecked")
		ListWithIteratorInterface<Entry<K, V>>[] tempTable = new CompletedLListWithIterator[newSize];

		// the internal table is now a larger array, but empty

		hashTable = tempTable;

		// reset the counters
		occupiedHashTableSlots = 0;
		numberOfEntries = 0;

		// Copy the old table to the new one.
		// Rehash dictionary entries from old array to the new and bigger array;
		// skip both null locations and slots with no entries
		// note use of add() to do this which rehashes keys

		for (int index = 0; index < oldSize; index++) {
			if (oldTable[index] != null) {
				for (Entry<K, V> entry : oldTable[index])
					add(entry.getKey(), entry.getValue());
			}
		}
	}

	@Override
	public V add(K key, V value) {

		// hash the key, and see if a slot in the table exists for it.
		// if not, create the list and add the key/value entry to it
		
		// if the slot exists, find the key in the existing list
		// if it does not exist, add the key/value entry to the existing list
		// if it does exist, simply replace the value associated with the key
		return null;
	}

	/**
	 * Look for an entry with a key in a list. The list will be one of the hash
	 * table slots.
	 * 
	 * @param list
	 * @param key
	 * @return
	 */
	private Entry<K, V> getEntry(ListWithIteratorInterface<Entry<K, V>> list, K key) {

		return null;

	}

	@Override
	public V remove(K key) {

		// hash the key, and see if a hash table slot
		// exists for the index
		// if so, find the key in the list associated with the slot
		// if found, remove it and adjust counters


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
	 * Get the next available hash index for the key
	 * 
	 * @param key
	 * @return
	 */
	private int getHashIndex(K key) {
		return 0;
	}

	/**
	 * Take a hashcode and make sure it fits in the hash table. Wraparound if
	 * necessary using mod tablelength. If the resulting index is < 0, add the table
	 * length to it.
	 * 
	 * @param index
	 * @return index % tablelength
	 */
	private int setHashIndex(int index) {
		return 0;
	}

	/**
	 * Returns true if lambda > MAX_LOAD_FACTOR for hash table;
	 * 
	 * Note that this is occupied slots, and not the number of table entries.
	 * 
	 * @return
	 */
	private boolean isHashTableTooFull() {
		return occupiedHashTableSlots > (MAX_LOAD_FACTOR * hashTable.length);
	}

	/**
	 * Returns a prime integer that is >= the given integer.
	 * 
	 * Note this should be < MAX_SIZE but is not checked.
	 * 
	 * @param anInteger
	 * @return the next prime number in the series of integers
	 */
	private int getNextPrime(int anInteger) {
		return 0;
	}

	/**
	 * From Sedgewick Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.
	 * 
	 * Checks to see if a number is prime.
	 * 
	 * Simpler code
	 * 
	 * @param n
	 * @return true if a prime number
	 */
	private boolean isPrime(int n) {

		boolean isPrime = true;

		if (n < 2)
			isPrime = false;

		// try all possible factors of n
		// if if n has a factor, then it has one less than or equal to sqrt(n),
		// so for efficiency we only need to check factor <= sqrt(n) or
		// equivalently factor*factor <= n

		for (long factor = 2; factor * factor <= n; factor++) {

			// if factor divides evenly into n, n is not prime, so break out of loop
			if (n % factor == 0) {
				isPrime = false;
				break;
			}
		}

		return (isPrime);
	}

	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}

	public Iterator<String> getStatsIterator() {
		return new StatsIterator();
	}

	/**
	 * Common iterator returning all the Entry objects in a hash table.
	 * 
	 * @author mhrybyk
	 *
	 */
	private class EntryIterator implements Iterator<Entry<K, V>> {
		private int currentIndex; // Current position in hash table

		// this is the iterator for a hash table's slot which contains a list
		// of entries

		private Iterator<Entry<K, V>> listIterator;

		private EntryIterator() {
			currentIndex = 0;
			listIterator = null;
		}

		public boolean hasNext() {

			// get the next slot that has a non-empty list

			while (currentIndex < hashTable.length) {
				// see if the list at the slot has entries
				if (hashTable[currentIndex] != null && hashTable[currentIndex].size() > 0) {
					break;
				}
				currentIndex++;
			}

			// if none found and we are at the end, the index will be the table size

			if (currentIndex < hashTable.length) {
				// if the list exists but there is no listIterator yet, return true
				// next() will allocate the listIterator.
				// otherwise look to see if the listIterator has another item in the list
				if (listIterator == null)
					return true;
				else
					return listIterator.hasNext();
			}

			// if the index is the size of the table, we are at the end

			return false;

		}

		public Entry<K, V> next() {
			Entry<K, V> result = null;

			if (hasNext()) {

				// if this is a new slot with a list, the listIterator will be null
				// so get its listIterator
				if (listIterator == null) {
					listIterator = hashTable[currentIndex].getIterator();
				}

				// get the next entry in the list.
				if (listIterator.hasNext()) {
					result = listIterator.next();

					// are we at the end of the list? If so, bump the hashtable index
					// and reset the listIterator
					if (!listIterator.hasNext()) {
						currentIndex++;
						listIterator = null;
					}

				}
			} else
				throw new NoSuchElementException();

			return result;
		}
	}

	/**
	 * Iterates through all keys in a hash table. Uses the common EntryIterator, and
	 * just returns the key.
	 * 
	 * @author mhrybyk
	 *
	 */
	private class KeyIterator implements Iterator<K> {

		private EntryIterator iterator;

		private KeyIterator() {
			iterator = new EntryIterator();
		}

		public boolean hasNext() {
			return iterator.hasNext();
		}

		public K next() {
			K result = null;

			if (hasNext()) {
				Entry<K, V> entry = iterator.next();
				result = entry.getKey();
			}
			return result;
		}
	}

	/**
	 * Iterates through all values in a hash table. Uses the common EntryIterator,
	 * and just returns the value.
	 * 
	 * @author mhrybyk
	 *
	 */
	private class ValueIterator implements Iterator<V> {

		private EntryIterator iterator;

		private ValueIterator() {
			iterator = new EntryIterator();
		}

		public boolean hasNext() {
			return iterator.hasNext();
		}

		public V next() {
			V result = null;

			if (hasNext()) {
				Entry<K, V> entry = iterator.next();
				result = entry.getValue();
			}
			return result;
		}

	}

	/**
	 * Iterates through all hash table entries, and outputs stats for each,
	 * including keys and values, and whether the table slot is allocated.
	 * 
	 * @author mhrybyk
	 *
	 */
	private class StatsIterator implements Iterator<String> {

		private int index;

		private StatsIterator() {
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return index < hashTable.length;
		}

		@Override
		public String next() {
			StringBuilder output = new StringBuilder();
			if (hashTable[index] == null)
				output.append("Slot " + index + " no list allocated");
			else {
				output.append("Slot " + index + " entries " + hashTable[index].size());
				for (Entry<K, V> entry : hashTable[index])
					output.append("\n" + entry);

			}

			index++;

			return output.toString();
		}

	}

}
