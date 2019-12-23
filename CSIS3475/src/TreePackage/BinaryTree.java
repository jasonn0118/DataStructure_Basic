package TreePackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import QueuePackage.*;
import StackPackage.*;

/**
 * A class that implements the ADT binary tree.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {
	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	} 

	/**
	 * Create the tree with a single root node from data
	 * 
	 * @param rootData
	 */
	public BinaryTree(T rootData) {
		root = new BinaryNode<>(rootData);
	} 

	/**
	 * Create the tree from a new root node and two other trees that will now become
	 * subtrees from root.
	 * 
	 * @param rootData
	 * @param leftTree
	 * @param rightTree
	 */
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		initializeTree(rootData, leftTree, rightTree);
	} 

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		initializeTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
	} 

	/**
	 * Combine two subtrees into a single tree with a new root.
	 * 
	 * @param rootData
	 * @param leftTree
	 * @param rightTree
	 */
	private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		// < FIRST DRAFT - See Segments 25.4 - 25.7 for improvements. >
		root = new BinaryNode<T>(rootData);

		if (leftTree != null)
			root.setLeftChild(leftTree.root);

		if (rightTree != null)
			root.setRightChild(rightTree.root);
	} 

	@Override
	public T getRootData() {
		if(isEmpty())
			return null;
		else
			return root.getData();
		
	}

	/**
	 * @return the root
	 */
	public BinaryNode<T> getRootNode() {
		return root;
	}

	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	}

	@Override
	public int getHeight() {
		int height = 0;
		if(root!=null) {
			height = root.getHeight();
		}
		return height;
	}
	

	@Override
	public int getNumberOfNodes() {
		int numberOfNodes = 0;
		if(root!= null) {
			numberOfNodes = root.getNumberOfNodes();
		}
		return numberOfNodes;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;

	}

	@Override
	public Iterator<T> getPreorderIterator() {
		return new PreorderIterator();
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		return new PostorderIterator();
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		return new LevelOrderIterator();
	}

	@Override
	public void setRootData(T rootData) {
		root.setData(rootData);

	}

	/*
	 * Implementations of setRootData, getRootData, getHeight, getNumberOfNodes,
	 * isEmpty, clear, and the methods specified in TreeIteratorInterface are here.
	 * . . .
	 */
	
	private class InorderIterator implements Iterator<T>{
		private StackInterface<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;
		
		public InorderIterator() {
			nodeStack = new LinkedStack<>();
			currentNode = root;
		}
		//end default constructor.
		
		public boolean hasNext() {
			return !nodeStack.isEmpty()||(currentNode!=null);
		}
		//end hasNext.
		public T next() {
			BinaryNode<T> nextNode = null;
			
			//find leftmost node with no left child.
			while(currentNode!=null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			//end while
			
			//get leftmost node, then move to its right subtree
			if(!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();
				//Assertion: newxtNode != null, since nodeStack was not empty.
				//before the pop
				currentNode = nextNode.getRightChild();
			}
			else
				throw new NoSuchElementException();
			
			return nextNode.getData();
		}
		//end next.
		
		public void remove() {
			throw new UnsupportedOperationException();
		}//end remove
	}//End InorderIterator.
	
	private class PreorderIterator implements Iterator<T>{
		private StackInterface<BinaryNode<T>> nodeStack;
		
		public PreorderIterator() {
			nodeStack = new LinkedStack<>();
			if(root!=null)
				nodeStack.push(root);
		}//end default constructor.
		
		public boolean hasNext() {
			return !nodeStack.isEmpty();
		}
		public T next() {
			BinaryNode<T> nextNode = null;
			if(hasNext()) {
				nextNode = nodeStack.pop();
				BinaryNode leftChild = nextNode.getLeftChild();
				BinaryNode rightChild = nextNode.getRightChild();
				
				if(rightChild!=null)
					nodeStack.push(rightChild);
				if(leftChild!=null)
					nodeStack.push(leftChild);
			}
			return nextNode.getData();
		}//end next.
		public void remove() {
			throw new UnsupportedOperationException();
		}//end remove.
	}//end PreorderIterator.
	
	private class PostorderIterator implements Iterator<T>{
		private StackInterface<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;
		
		public PostorderIterator() {
			nodeStack = new LinkedStack<>();
			currentNode = root;
		}//end default constructor.
		
		public boolean hasNext() {
			return !nodeStack.isEmpty()||currentNode!=null;
		}//end hasNext
		
		public T next() {
			BinaryNode<T> leftChild, rightChild, nextNode = null;
			boolean foundNext = false;
			
			//find leftmost node
			while(currentNode!=null) {
				nodeStack.push(currentNode);
				leftChild = currentNode.getLeftChild();
				if(leftChild==null){
					currentNode = currentNode.getRightChild();
				}
				else
					currentNode =  leftChild;
			}
			
			if(!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();
				//nextNode != null since stack was not empty before pop
				BinaryNode<T> parent = nodeStack.peek();
				if(parent != null&&nextNode==parent.getLeftChild())
					currentNode = parent.getRightChild();
				else
					currentNode = null;				
			}
			else {
				throw new NoSuchElementException();
			}
			return nextNode.getData();
		}//end next.
		public void remove() {
			throw new UnsupportedOperationException();
		}//end remove
		
	}//end PostorderIterator.

	private class LevelOrderIterator implements Iterator<T>{
		private QueueInterface<BinaryNode<T>> nodeQueue;
		
		public LevelOrderIterator() {
			nodeQueue = new LinkedQueue<>();
			if(root!=null)
				nodeQueue.enqueue(root);
		}
		public boolean hasNext() {
			return !nodeQueue.isEmpty();
		}
		public T next() {
			BinaryNode<T> nextNode;
			
			if(hasNext()) {
				nextNode = nodeQueue.dequeue();
				BinaryNode<T> leftChild= nextNode.getLeftChild();
				BinaryNode<T> rightChild = nextNode.getRightChild();
				
				// Add to queue in order of recursive calls.
				if(leftChild!=null)
					nodeQueue.enqueue(leftChild);
				if(rightChild!=null) {
					nodeQueue.enqueue(rightChild);
				}
			}
			else {
				throw new NoSuchElementException();
			}
			return nextNode.getData();
		}
	}
	public void recursiveInorderTraverse() {
		recursiveInorderTraverse(root);
	}
	private void recursiveInorderTraverse(BinaryNode<T> node) {
		if(node!=null) {
			recursiveInorderTraverse(node.getLeftChild());
			System.out.print(node.getData()+" ");
			recursiveInorderTraverse(node.getRightChild());
		}
	}
	public void iterativeInorderTraverse() {
		StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
		BinaryNode<T> currentNode = root;
		
		while(!nodeStack.isEmpty()||(currentNode!=null)) {
			//find leftmost node with no left child.
			while(currentNode!=null) {
				nodeStack.push(currentNode);
				currentNode= currentNode.getLeftChild();
			}
			
			//visit leftmost node, then traverse its right subtree
			if(!nodeStack.isEmpty()) {
				BinaryNode<T> nextNode = nodeStack.pop();
				//Assertion: nextNode !=null, since nodeStack was not empty.
				//before the pop
				
				System.out.print(nextNode.getData()+" ");
				currentNode = nextNode.getRightChild();
			}
		}
	}
	public void iterativePreorderTraverse()
	   {
	      StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
	      if (root != null)
	         nodeStack.push(root);
	      BinaryNode<T> nextNode;
	      while (!nodeStack.isEmpty())
	      {
				nextNode = nodeStack.pop();
				BinaryNode<T> leftChild = nextNode.getLeftChild();
				BinaryNode<T> rightChild = nextNode.getRightChild();
				
				// Push into stack in reverse order of recursive calls
				if (rightChild != null)
					nodeStack.push(rightChild);
	         
				if (leftChild != null)
					nodeStack.push(leftChild);
	         
	         System.out.print(nextNode.getData() + " ");
	      } // end while
	   } // end iterativePreorderTraverse
	
} //end BinaryTree.
