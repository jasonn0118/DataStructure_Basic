package SearchTreesPackage;

import TreePackage.*;

/**
 * A class that implements the ADT binary search tree by extending BinaryTree.
 * Iterative version.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class BinarySearchTreeIterative<T extends Comparable<? super T>> 
	extends BinaryTree<T>
	implements SearchTreeInterface<T> {
	
	public BinarySearchTreeIterative() {
		super();
	}

	public BinarySearchTreeIterative(T rootEntry) {
		super();
		setRootNode(new BinaryNode<>(rootEntry));
	}

	// Disable setTree (see Segment 26.6)
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
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
	
	/**
	 * Locate node that contains a match for entry
	 * @param entry
	 * @return node that matches and parent
	 */
	private NodePair findNode(T entry) {
		NodePair result = new NodePair();
		boolean found = false;

		BinaryNode<T> currentNode = getRootNode();
		BinaryNode<T> parentNode = null;

		while (!found && (currentNode != null)) {
			T currentEntry = currentNode.getData();
			int comparison = entry.compareTo(currentEntry);

			if (comparison < 0) {
				parentNode = currentNode;
				currentNode = currentNode.getLeftChild();
			} else if (comparison > 0) {
				parentNode = currentNode;
				currentNode = currentNode.getRightChild();
			} else // comparison == 0
				found = true;
		} 

		if (found)
			result = new NodePair(currentNode, parentNode);
		// Located entry is currentNode.getData()

		return result;
	} 
	
	/**
	 * Gets the node that contains the inorder predecessor of currentNode.
	 * Assumes node has two children
	 * @param currentNode
	 * @return
	 */
	private NodePair getNodeToRemove(BinaryNode<T> currentNode) {
		// Find node with largest entry in left subtree by
		// moving as far right in the subtree as possible
		BinaryNode<T> leftSubtreeRoot = currentNode.getLeftChild();
		BinaryNode<T> rightChild = leftSubtreeRoot;
		BinaryNode<T> priorNode = currentNode;

		while (rightChild.hasRightChild()) {
			priorNode = rightChild;
			rightChild = rightChild.getRightChild();
		} 

		// rightChild contains the inorder predecessor and is the node to
		// remove; priorNode is its parent

		return new NodePair(rightChild, priorNode);
	} 

	/**
	 * Removes a node having at most one child.
	 * @param nodeToRemove
	 * @param parentNode
	 */
	private void removeNode(BinaryNode<T> nodeToRemove, BinaryNode<T> parentNode) {
		BinaryNode<T> childNode;

		if (nodeToRemove.hasLeftChild())
			childNode = nodeToRemove.getLeftChild();
		else
			childNode = nodeToRemove.getRightChild();

		// Assertion: if nodeToRemove is a leaf, childNode is null

		if (nodeToRemove == getRootNode())
			setRootNode(childNode);
		else if (parentNode.getLeftChild() == nodeToRemove)
			parentNode.setLeftChild(childNode);
		else
			parentNode.setRightChild(childNode);
	} 

	// Other public methods in SearchTreeInterface are inherited from BinaryTree.

	/**
	 * Class that holds two nodes, typically a node and its parent
	 *
	 */
	private class NodePair {
		private BinaryNode<T> first, second;

		public NodePair() {
			first = null;
			second = null;
		} 

		public NodePair(BinaryNode<T> firstNode, BinaryNode<T> secondNode) {
			first = firstNode;
			second = secondNode;
		} 

		public BinaryNode<T> getFirst() {
			return first;
		} 

		public BinaryNode<T> getSecond() {
			return second;
		} 
	} 

}
