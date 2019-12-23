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
		T rootData = null;
		if (root != null)
			rootData = root.getData();

		return rootData;
	}// end getRootData

	@Override
	public int getHeight() {
		return root.getHeight();
	}// end getHeight

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
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
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setRootData(T rootData) {
		root.setData(rootData);

	}

	@Override
	public void setTree(T rootData, GeneralTreeInterface<T>[] children) {
		privateSetTree(rootData, children);
	}

	private void privateSetTree(T rootData, GeneralTreeInterface<T>[] children) {
		root = new BinaryNode<>(rootData);

		// Find the first valid child and put it on the left of the root
		int i = 0;
		boolean found = false;
		BinaryNode<T> childList = null;

		while (i < children.length && !found) {
			// Force the child to be one of our trees
			GeneralTree<T> child = (GeneralTree<T>) children[i];

			if ((child != null) && !child.isEmpty()) {
				// Found it
				found = true;
				root.setLeftChild(child.root.copy());
				childList = (BinaryNode<T>) root.getLeftChild();
			} // end if
			i++;
		}

		// The rest of the children are turned into a chain of linked nodes
		// using right children "next" references
		while (i < children.length) {
			GeneralTree<T> child = (GeneralTree<T>) children[i];
			if ((child != null) && !child.isEmpty()) {
				childList.setRightChild(child.root.copy());
				childList = (BinaryNode<T>) childList.getRightChild();
			} // end if
			i++;
		} // end while
	} // end privateSetTree

	private class PreorderIterator implements Iterator<T> {
		private StackInterface<BinaryNode<T>> nodeStack;

		public PreorderIterator() {
			nodeStack = new LinkedStack<>();
			if (root != null)
				nodeStack.push(root);
		} // end default constructor

		public boolean hasNext() {
			return !nodeStack.isEmpty();
		} // end hasNext

		public T next() {
			T result = null;

			if (nodeStack.isEmpty()) {
				throw new NoSuchElementException();
			} else {
				BinaryNode<T> top = nodeStack.pop();
				result = top.getData();

				// Push the children on the stack, right then left.

				if (top.hasRightChild())
					nodeStack.push(top.getRightChild());
				if (top.hasLeftChild())
					nodeStack.push(top.getLeftChild());
			}

			return result;
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end PreorderIterator

	private class PostorderIterator implements Iterator<T> {
		private StackInterface<PostOrderNode> nodeStack;

		public PostorderIterator() {
			nodeStack = new LinkedStack<>();
			if (root != null)
				nodeStack.push(new PostOrderNode(root, PostOrderState.CHILDREN));
		} // end default constructor

		public boolean hasNext() {
			return !nodeStack.isEmpty();
		} // end hasNext

		public T next() {
			T result = null;
			if (nodeStack.isEmpty()) {
				throw new NoSuchElementException();
			} else {
				PostOrderNode top = nodeStack.pop();
				PostOrderState state = top.state;

				while (state != PostOrderState.TOP) {
					assert state == PostOrderState.CHILDREN;
					StackInterface<PostOrderNode> children = new LinkedStack<>();
					BinaryNode<T> child = (BinaryNode<T>) top.node.getLeftChild();
					while (child != null) {
						children.push(new PostOrderNode(child, PostOrderState.CHILDREN));
						child = (BinaryNode<T>) child.getRightChild();
					}

					// push the parent and the children on the stack
					nodeStack.push(new PostOrderNode(top.node, PostOrderState.TOP));
					while (!children.isEmpty())
						nodeStack.push(children.pop());

					top = nodeStack.pop();
					state = top.state;
				}
				result = top.node.getData();
			}

			return result;
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end PostorderIterator

	private enum PostOrderState {
		TOP, CHILDREN
	};

	private class PostOrderNode {
		public BinaryNode<T> node;
		public PostOrderState state;

		PostOrderNode(BinaryNode<T> theNode, PostOrderState theState) {
			node = theNode;
			state = theState;
		}
	}

}
