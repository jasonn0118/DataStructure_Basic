package ListWithIteratorsPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ListPackage.*;

/**
 * LList with traversal using Iterator. Just extends LList.
 * 
 * Note need for getFirstNode(), which violates data hiding. But saves us from
 * copying lots of code.
 * 
 * @author mhrybyk
 *
 * @param <T>
 */
public final class LListWithTraversal<T extends Comparable<? super T>> extends LList<T> implements Iterator<T> {

	private Node<T> nextNode; // Node containing next entry in iteration

	public LListWithTraversal() {
		super();
		resetTraversal();
	}

	@Override
	public boolean hasNext() {
		return nextNode != null;
	}

	@Override
	public T next() {
		if(hasNext()) {
			Node<T> returnNode = nextNode;//getNext node.
			nextNode = nextNode.getNextNode();//Advance iterator
			return returnNode.getData();
		}else {
			throw new NoSuchElementException("No next element in list");
		}
	}

	public void remove() {
		throw new UnsupportedOperationException("remove() is not " + "supported by this iterator");
	}

	/**
	 * Sets the traversal to the beginning of the list. This method is NOT in the
	 * interface Iterator.
	 */
	public void resetTraversal() {
		nextNode = super.getFirstNode();
	}

}
