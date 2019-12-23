package TreePackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import StackPackage.*;

/**
 * Implementation of a general tree using a binary tree. Solves Project 5a in
 * Chapter 25.
 * 
 * @author Charles Hoot
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class GeneralTree<T> implements GeneralTreeInterface<T> {
	private BinaryNode<T> root;

	public GeneralTree() {
		root = null;
	} 

	public GeneralTree(T rootData) {
		root = new BinaryNode<>(rootData);
	} 

	public GeneralTree(T rootData, GeneralTree<T>[] children) {
		setTree(rootData, children);
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
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRootData(T rootData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTree(T rootData, GeneralTreeInterface<T>[] children) {
		// TODO Auto-generated method stub
		
	} 


} 
