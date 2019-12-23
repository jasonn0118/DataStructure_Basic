package HashingPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import DictionaryPackage.*;

/**
 * A class that implements the ADT dictionary by using hashing and linear
 * probing to resolve collisions. The dictionary is unsorted and has distinct
 * search keys. Notes: Uses probe for add, remove, and getValue. Uses linear
 * probing, but includes code for quadratic probing. Has a display method for
 * illustration and testing.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class HashedDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {
	
	// The dictionary:
	private int numberOfEntries;

	// capacity must be prime, which checkCapacity will automatically set
	// if this is set too low with quadratic probe, search time increases.
	private static final int DEFAULT_CAPACITY = 5;
	private static final int MAX_CAPACITY = 1000000;

	// The hash table:
	private Entry<K, V>[] hashTable;

	private static final int MAX_SIZE = 2 * MAX_CAPACITY; // Max size of hash table
	private static final double MAX_LOAD_FACTOR = 0.5; // Fraction of hash table that can be filled

	private final Entry<K, V> AVAILABLE = new Entry<>(null, null); // Occupies locations in the hash table in the
																	// available state (locations whose entries were
																	// removed)

	public HashedDictionary() {
		this(DEFAULT_CAPACITY); // Call next constructor
	}

	public HashedDictionary(int initialCapacity) {
		initialCapacity = checkCapacity(initialCapacity);
		numberOfEntries = 0; // Dictionary is empty

		// Set up hash table:
		// Initial size of hash table is same as initialCapacity if it is prime;
		// otherwise increase it until it is prime size
		int tableSize = getNextPrime(initialCapacity);
		checkSize(tableSize); // Check that the prime size is not too large

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		Entry<K, V>[] temp = (Entry<K, V>[]) new Entry[tableSize];
		hashTable = temp;

	}

	/**
	 * Display the hash table. Should really be done in a utility function with some
	 * other methods to determine state. Just for illustration
	 */
	public void displayHashTable() {
		System.out.println("***** Displaying hash table size = " + hashTable.length + ":");
		for (int index = 0; index < hashTable.length; index++) {

			Entry<K, V> entry = hashTable[index];
			if (entry == null)
				System.out.println("null ");
			else if (entry == AVAILABLE)
				System.out.println("removed state");
			else {
				K key = entry.getKey();
				V value = entry.getValue();
				int hashIndex = getHashIndex(key);
				System.out.println(
						"index " + hashIndex + " (" + (hashIndex % hashTable.length) + ") key " + key + " " + value);
			}
		}
		System.out.println();
	}

	

	private int getHashIndex(K key) {
		int hashIndex = setHashIndex(key.hashCode());
		//check for and resolve collision
		hashIndex = linearProbe(hashIndex, key);
		return hashIndex;		
		
	}

	private int setHashIndex(int index) {
		index = index%hashTable.length;
		if(index<0) {
			index = index+hashTable.length;
		}
		return index;
	}
	
	//Strategy for resolving collisions or keys that map to same index in a hash table.
	private int linearProbe(int index,K key) {
		boolean found = false;
		
		//Index of first available location(from which an entry was removed.)
		int availableIndex = -1;
		
		//Start looking at keys at the index location, then increment until key is found.
		while(!found&&(hashTable[index]!=null)) {
			//if there is an entry in the location test for equality.
			
			if(hasAnEntry(index)) {
				if(key.equals(hashTable[index].getKey()))
					found = true;					
			}else {
				//skip entries that were removed
				//but save index of first location in removed state.
				if(availableIndex == -1) {
					availableIndex = index;
				}
			}
			//if there was an entry but it wasn't the key, increment the index and try again.
			if(!found)
				index=setHashIndex(index+1);//Linear Probing.
		}
		//if the key is found return the location
		//if we did not find the key and there are only null entries, return first.
		//null entry.
		
		//otherwise, return the first available index.
		if(found||(availableIndex==-1))
			return index;//index of either key or null.
		else
			return availableIndex;//index of an available location.
	}
	@Override
	public V add(K key, V value) {
		if((key==null)||(value==null)) {
			return null;
		}
		
		V oldValue;
		
		//get the next available hash index for the key
		int index = getHashIndex(key);
		
		//Assertion: index is within legal range for hashTable
		assert(index>=0)&&(index<hashTable.length);
		
		if(!hasAnEntry(index)) {
			//key not found, so insert new entry.
			hashTable[index]=new Entry<>(key,value);
			numberOfEntries++;
			oldValue=null;
		}else {
			//key found; get old value for return and then replace it.
			oldValue = hashTable[index].getValue();
			hashTable[index].setValue(value);
		}
		
		if(isHashTableTooFull()) {
			enlargeHashTable();
		}
		return oldValue;
	}

	@Override
	public V remove(K key) {
		V removedValue = null;
		int index = getHashIndex(key);//get the location in the table.
		
		if(hasAnEntry(index)) {
			//key found; flag entry as removed and return its value.
			removedValue = hashTable[index].getValue();
			hashTable[index]=AVAILABLE;
			numberOfEntries--;
		}
		
		return removedValue;
	}

	@Override
	public V getValue(K key) {
		V result = null;
		int index = getHashIndex(key);
		
		if(hasAnEntry(index)) {
			result = hashTable[index].getValue();
			//key found, get value. 
		}
		
		return result;
	}

	@Override
	public boolean contains(K key) {
		boolean found = false;
		KeyIterator ki = new KeyIterator();
		while(!found&&ki.hasNext()) {
			if(ki.next().equals(key)) {
				found = true;
				break;
			}
		}
		return found;
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
		@SuppressWarnings("Unchecked")
		Entry<K,V>[] temp = (Entry<K,V>[]) new Entry[DEFAULT_CAPACITY];
		hashTable = temp;
		numberOfEntries=0;
		
	}

	/**
	 * Checks to see if the index into the hash table is occupied
	 * 
	 * @param index
	 * @return true if there is an entry
	 */
	public boolean hasAnEntry(int index) {
		return (hashTable[index] != null) && (hashTable[index] != AVAILABLE);
	}

	public Iterator<K> getKeyIterator() {
		KeyIterator ki = new KeyIterator();
		Iterator<K> result = null;
		ArrayList<K> list = new ArrayList<K>();
		while(ki.hasNext()) {
			list.add(ki.next());
		}
		result = list.iterator();
		return result;
	}

	public Iterator<V> getValueIterator() {
		ValueIterator vi = new ValueIterator();
		Iterator<V> result =null;
		ArrayList<V> list = new ArrayList<V>();
		while(vi.hasNext()) {
			list.add(vi.next());
		}
		result = list.iterator();
		return result;
	}


	/**
	 * Increases the size of the hash table to a prime >= twice its old size. In
	 * doing so, this method must rehash the table entries.
	 */
	private void enlargeHashTable() {
		Entry<K, V>[] oldTable = hashTable;
		int oldSize = hashTable.length;
		int newSize = getNextPrime(oldSize + oldSize);
		checkSize(newSize); // Check that the prime size is not too large

		// The cast is safe because the new array contains null entries
		// increase the size of the array
		@SuppressWarnings("unchecked")
		Entry<K, V>[] tempTable = (Entry<K, V>[]) new Entry[newSize];

		// the internal table is now a larger array, but empty

		hashTable = tempTable;
		numberOfEntries = 0; // Reset number of dictionary entries, since
								// it will be incremented by add during rehash

		// Rehash dictionary entries from old array to the new and bigger array;
		// skip both null locations and removed entries
		// note use of add() to do this which rehashes keys

		for (int index = 0; index < oldSize; index++) {
			if ((oldTable[index] != null) && (oldTable[index] != AVAILABLE))
				add(oldTable[index].getKey(), oldTable[index].getValue());
		}
	}

	/**
	 * Returns true if lambda > MAX_LOAD_FACTOR for hash table;
	 * 
	 * @return
	 */
	private boolean isHashTableTooFull() {
		return numberOfEntries > MAX_LOAD_FACTOR * hashTable.length;
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
		// if even, add 1 to make odd
		if (anInteger % 2 == 0) {
			anInteger++;
		}

		// test odd integers
		while (!isPrime(anInteger)) {
			anInteger = anInteger + 2;
		}

		return anInteger;
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

		// The definition of a prime number is a positive integer that has exactly two positive divisors. 
		// However, 1 only has one positive divisor (1 itself), so it is not prime.
		
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

	/**
	 * Check to see if a number is prime Original code from Carrano.
	 * 
	 * Needlessly complex.
	 * 
	 * @param anInteger
	 * @return
	 */
	private boolean isPrime2(int anInteger) {
		boolean result;
		boolean done = false;

		// 1 and even numbers are not prime
		// FIX this looks to be 2 is not prime?? - mwh
		if ((anInteger == 1) || (anInteger % 2 == 0)) {
			result = false;
		}

		// 2 and 3 are prime
		else if ((anInteger == 2) || (anInteger == 3)) {
			result = true;
		}

		else // anInteger is odd and >= 5
		{
			assert (anInteger % 2 != 0) && (anInteger >= 5);

			// a prime is odd and not divisible by every odd integer up to its square root
			result = true; // assume prime
			for (int divisor = 3; !done && (divisor * divisor <= anInteger); divisor = divisor + 2) {
				if (anInteger % divisor == 0) {
					result = false; // divisible; not prime
					done = true;
				}
			}
		}

		return result;
	}

	/**
	 * Ensures that the client requests a capacity that is not too small or too
	 * large.
	 * 
	 * @param capacity
	 * @return
	 */
	private int checkCapacity(int capacity) {
		if (capacity < DEFAULT_CAPACITY)
			capacity = DEFAULT_CAPACITY;
		else if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a dictionary " + "whose capacity is larger than " + MAX_CAPACITY);
		return capacity;
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

	private class KeyIterator implements Iterator<K> {
		private int currentIndex; // Current position in hash table
		private int numberLeft; // Number of entries left in iteration

		private KeyIterator() {
			currentIndex = 0;
			numberLeft = numberOfEntries;
		}



		public void remove() {
			throw new UnsupportedOperationException();
		}



		@Override
		public boolean hasNext() {
			return numberLeft>0;
		}



		@Override
		public K next() {
			K result = null;
			
			if(hasNext()) {
				//skip table locations that do not contain a current entry.
				while(!hasAnEntry(currentIndex)) {
					currentIndex++;
				}//end while.
			}else {
				throw new NoSuchElementException();
			}
			return result;
		}
	}

	private class ValueIterator implements Iterator<V> {
		private int currentIndex;
		private int numberLeft;

		private ValueIterator() {
			currentIndex = 0;
			numberLeft = numberOfEntries;
		}



		public void remove() {
			throw new UnsupportedOperationException();
		}



		@Override
		public boolean hasNext() {
			return numberLeft>0;
		}



		@Override
		public V next() {
			V result = null;
			if(hasNext()) {
				while(!hasAnEntry(currentIndex)) {
					currentIndex++;
				}
				result = hashTable[currentIndex].getValue();
				numberLeft--;
				currentIndex++;
			}else
				throw new NoSuchElementException();
			
			return result;
		}
	}
}
