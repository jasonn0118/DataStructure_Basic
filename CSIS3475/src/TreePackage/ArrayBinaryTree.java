package TreePackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import QueuePackage.*;
import StackPackage.*;

/**
 * This class implements a binary tree by using an array.
 * 
 * Exercise 19 in Chapter 25 suggests that entries in the tree be assigned to
 * locations in the array in a level-order fashion beginning at index 0 of the
 * array. Gaps in the array correspond to missing nodes in the tree. The
 * completion of this implementation is the subject of Project 7.
 * 
 * The left child of the node at a[i] is a[2 * i + 1]. The right child of the
 * node at a[i] is a[2 * i + 2]. The parent of the node at a[i] is a[(i - 1) /
 * 2].
 * 
 * @author Charles Hoot, Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 */
public class ArrayBinaryTree<T> implements BinaryTreeInterface<T> {
	private T[] theData;
	private int height; // Of tree
	private int size; // Number of locations in array for a full tree of this height

	public ArrayBinaryTree() {
		theData = null;
		height = 0;
		size = 0;
	} 

	public ArrayBinaryTree(T rootData) {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[1]; // Unchecked cast
		theData = temp;

		height = 1;
		size = 1;
		theData[0] = rootData;
	} 

	public ArrayBinaryTree(T rootData, ArrayBinaryTree<T> leftTree, ArrayBinaryTree<T> rightTree) {
		setTree(rootData, leftTree, rightTree);
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
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		// TODO Auto-generated method stub
		
	} 
} 
