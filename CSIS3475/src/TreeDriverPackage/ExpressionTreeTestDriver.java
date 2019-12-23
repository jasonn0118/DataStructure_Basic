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
		ExpressionTree a = new ExpressionTree("a");
		ExpressionTree b = new ExpressionTree("b");
		ExpressionTree c = new ExpressionTree("c");
		ExpressionTree d = new ExpressionTree("d");
		ExpressionTree e = new ExpressionTree("e");

		// Building from bottom up
		ExpressionTree cTimes = new ExpressionTree();
		cTimes.setTree("*", c, d);

		ExpressionTree bPlus = new ExpressionTree();
		bPlus.setTree("+", b, cTimes);

		ExpressionTree aTimes = new ExpressionTree();
		aTimes.setTree("*", a, bPlus);

		ExpressionTree myTree = new ExpressionTree();
		myTree.setTree("/", aTimes, e);

		testPreorder(myTree, "/ * a + b * c d e");
		testPostorder(myTree, "a b c d * + * e /");

		System.out.println("evaluate() returns " + myTree.evaluate() + " (should be 23)");

		System.out.println("Done.");
	} 

	public static void testPreorder(ExpressionTree tree, String answer) {
		System.out.println("\nPreorder:");
		System.out.println(answer + "  Expected");

		Iterator<String> preorder = tree.getPreorderIterator();

		while (preorder.hasNext()) {
			System.out.print(preorder.next() + " ");
		} 

		System.out.println(" Actual\n---------------");
	} 

	public static void testPostorder(ExpressionTree tree, String answer) {
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
