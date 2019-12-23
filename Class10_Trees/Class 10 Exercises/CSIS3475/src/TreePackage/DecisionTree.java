package TreePackage;

/**
 * A class that implements a decision tree by extending BinaryTree.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class DecisionTree<T> extends BinaryTree<T> implements DecisionTreeInterface<T> {
	private BinaryNode<T> currentNode; // Tracks where we are in the tree

	public DecisionTree() {
		super();
		resetCurrentNode();
	} 

	public DecisionTree(T rootData) {
		super(rootData);
		resetCurrentNode();
	} 

	public DecisionTree(T rootData, DecisionTree<T> leftTree, DecisionTree<T> rightTree) {
		setTree(rootData, leftTree, rightTree);
		resetCurrentNode();
	} 

	public DecisionTree(T rootData, T responseForNo, T responseForYes) {
		DecisionTree<T> leftTree = new DecisionTree<>(responseForNo);
		DecisionTree<T> rightTree = new DecisionTree<>(responseForYes);
		setTree(rootData, leftTree, rightTree);
		resetCurrentNode();
	} 

	protected BinaryNode<T> getCurrentNode() {
		return currentNode;
	}

	@Override
	public T getCurrentData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentData(T newData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResponses(T responseForNo, T responseForYes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAnswer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void advanceToNo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void advanceToYes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetCurrentNode() {
		// TODO Auto-generated method stub
		
	} 
} 
