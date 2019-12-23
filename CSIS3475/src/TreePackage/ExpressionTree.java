package TreePackage;

/**
 * A class that implements an expression tree by extending BinaryTree.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface {
	public ExpressionTree() {
	} 
	
	public ExpressionTree(String data) {
		super(data);
	}

	public double evaluate() {
		return evaluate(getRootNode());
	} 

	private double evaluate(BinaryNode<String> rootNode) {
		double result;
		if (rootNode == null)
			result = 0;
		else if (rootNode.isLeaf()) {
			String variable = rootNode.getData();
			result = getValueOf(variable);
		} else {
			double firstOperand = evaluate(rootNode.getLeftChild());
			double secondOperand = evaluate(rootNode.getRightChild());
			String operator = rootNode.getData();
			result = compute(operator, firstOperand, secondOperand);
		} 

		return result;
	} 

	private double getValueOf(String variable) { // Strings allow multicharacter variables

		double result = 0;

		if(variable.equals("a"))
			result = 2;
		else if(variable.equals("b"))
			result=3;
		else if(variable.equals("c"))
			result = 4;
		else if(variable.equals("d"))
			result=5;
		else if(variable.equals("e"))
			result = 2;
		return result;

	} 

	private double compute(String operator, double firstOperand, double secondOperand) {
		double result = 0;

		if(operator.equals("+"))
			result = firstOperand+secondOperand;
		else if(operator.equals("-"))
			result = firstOperand-secondOperand;
		else if(operator.equals("*"))
			result = firstOperand*secondOperand;
		else if(operator.equals("/"))
			result = firstOperand/secondOperand;

		return result;
	} 
} 
