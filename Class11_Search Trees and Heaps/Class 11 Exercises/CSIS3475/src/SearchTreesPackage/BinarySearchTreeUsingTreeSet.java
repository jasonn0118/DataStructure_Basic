package SearchTreesPackage;

import java.util.Iterator;
import java.util.TreeSet;
import TreePackage.*;


/**
 * A class that implements the ADT binary search tree by using 
 * java library TreeSet
 * 
 * @author mhrybyk
 */
public class BinarySearchTreeUsingTreeSet<T extends Comparable<? super T>>  
	implements SearchTreeInterface<T> {
	
	TreeSet<T> tree;
	public BinarySearchTreeUsingTreeSet() {
		tree = new TreeSet<>();
	} 

	public BinarySearchTreeUsingTreeSet(T rootEntry) {
		this();	
		tree.add(rootEntry);
	} 

	// Disable setTree (see Segment 26.6)
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T getRootData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getEntry(T anEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T add(T anEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T anEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	} 



}
