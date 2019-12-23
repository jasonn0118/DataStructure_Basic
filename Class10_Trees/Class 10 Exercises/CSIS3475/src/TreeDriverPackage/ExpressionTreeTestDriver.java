package TreeDriverPackage;

import java.util.Iterator;
import TreePackage.*;

/**
 * A driver that demonstrates the class ExpressionTree.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * To test your version, remove Completed so that ExpressionTree only remains.
 */
public class ExpressionTreeTestDriver {
	public static void main(String[] args) {
		// Build expression tree for a * (b + c * d) / e, as pictured in Figure 24-15d
		CompletedExpressionTree a = new CompletedExpressionTree("a");
		CompletedExpressionTree b = new CompletedExpressionTree("b");
		CompletedExpressionTree c = new CompletedExpressionTree("c");
		CompletedExpressionTree d = new CompletedExpressionTree("d");
		CompletedExpressionTree e = new CompletedExpressionTree("e");

		// Building from bottom up
		CompletedExpressionTree cTimes = new CompletedExpressionTree();
		cTimes.setTree("*", c, d);

		CompletedExpressionTree bPlus = new CompletedExpressionTree();
		bPlus.setTree("+", b, cTimes);

		CompletedExpressionTree aTimes = new CompletedExpressionTree();
		aTimes.setTree("*", a, bPlus);

		CompletedExpressionTree myTree = new CompletedExpressionTree();
		myTree.setTree("/", aTimes, e);

		testPreorder(myTree, "/ * a + b * c d e");
		testPostorder(myTree, "a b c d * + * e /");

		System.out.println("evaluate() returns " + myTree.evaluate() + " (should be 23)");

		System.out.println("Done.");
	} 

	public static void testPreorder(CompletedExpressionTree tree, String answer) {
		System.out.println("\nPreorder:");
		System.out.println(answer + "  Expected");

		Iterator<String> preorder = tree.getPreorderIterator();

		while (preorder.hasNext()) {
			System.out.print(preorder.next() + " ");
		} 

		System.out.println(" Actual\n---------------");
	} 

	public static void testPostorder(CompletedExpressionTree tree, String answer) {
		System.out.println("\nPostOrder:");
		System.out.println(answer + "  Expected");

		Iterator<String> postorder = tree.getPostorderIterator();

		while (postorder.hasNext()) {
			System.out.print(postorder.next() + " ");
		} 

		System.out.println(" Actual\n---------------");
	} 
}  

/*

 
 Preorder:
 / * a + b * c d e  Expected
 / * a + b * c d e  Actual
 ---------------
 
 PostOrder:
 a b c d * + * e /  Expected
 a b c d * + * e /  Actual
 ---------------
 evaluate() returns 23.0 (should be 23)
 Done.
 
*/

/*
 REMINDER--Figure 24-15d looks like this:

      /
     / \
    *   e
   / \
  a   +
     / \
    b   *
       / \
      c   d
*/     
