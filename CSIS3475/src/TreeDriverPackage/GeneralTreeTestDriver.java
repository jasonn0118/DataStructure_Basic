package TreeDriverPackage;

import java.util.Iterator;
import TreePackage.*;

/**
 * A driver that demonstrates the class CompletedGeneralTree.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * To test your version, remove Completed so that GeneralTree only remains.
 */
public class GeneralTreeTestDriver {
	public static void main(String[] args) {
		// Figure 24-1
		System.out.println("\nThe tree in Figure 24-1:\n");
		System.out.println("         Carole");
		System.out.println("        /   |  \\"); // '\\' is the escape character for backslash
		System.out.println("       /    |   \\");
		System.out.println("      /     |    \\");
		System.out.println("   Brett Jennifer Brian");
		System.out.println("    /     / \\");
		System.out.println("   /     /   \\");
		System.out.println("  /     /     \\");
		System.out.println("Susan Jared  Jamie ");
		System.out.println();

		// Leaves
		GeneralTreeInterface<String> brianTree = new GeneralTree<>("Brian");
		GeneralTreeInterface<String> susanTree = new GeneralTree<>("Susan");
		GeneralTreeInterface<String> jaredTree = new GeneralTree<>("Jared");
		GeneralTreeInterface<String> jamieTree = new GeneralTree<>("Jamie");

		// Subtrees:
		// The casts are safe because the new arrays contains null entries
		@SuppressWarnings("unchecked")
		GeneralTreeInterface<String>[] brettChildren = new GeneralTree[2];
		brettChildren[0] = susanTree;
		brettChildren[1] = null;
		GeneralTreeInterface<String> brettTree = new GeneralTree<>();
		brettTree.setTree("Brett", brettChildren);

		@SuppressWarnings("unchecked")
		GeneralTreeInterface<String>[] jenniferChildren = new GeneralTree[2];
		jenniferChildren[0] = jaredTree;
		jenniferChildren[1] = jamieTree;
		GeneralTreeInterface<String> jenniferTree = new GeneralTree<>();
		jenniferTree.setTree("Jennifer", jenniferChildren);

		@SuppressWarnings("unchecked")
		GeneralTreeInterface<String>[] caroleChildren = new GeneralTree[3];
		caroleChildren[0] = brettTree;
		caroleChildren[1] = jenniferTree;
		caroleChildren[2] = brianTree;
		GeneralTreeInterface<String> caroleTree = new GeneralTree<>();
		caroleTree.setTree("Carole", caroleChildren);

		showTreeStats(caroleTree, "carole", 7);
		testTraversals(caroleTree, "carole brett susan jennifer jared jamie brian",
				"susan brett jared jamie jennifer brian carole");

		testEmptyTree();

		System.out.println("Done.");
	} 

	/** Tests the 4 traversals of a given binary tree. */
	public static void testTraversals(GeneralTreeInterface<String> aTree, String preorder, String postorder) {
		testPreorder(aTree, preorder);
		testPostorder(aTree, postorder);
	} 

	public static void showTreeStats(GeneralTreeInterface<String> tree, String root, int numberOfNodes) {
		if (tree.isEmpty())
			System.out.println("The tree is empty");
		else
			System.out.println("The tree is not empty");

		System.out.println("Root of tree is " + tree.getRootData() + "; s/b " + root);

		System.out.println("# nodes in tree is " + tree.getNumberOfNodes() + "; s/b " + numberOfNodes);
	} 

	public static void testPreorder(GeneralTreeInterface<String> tree, String answer) {
		System.out.println("\nPreorder:");
		System.out.println(answer + "  Expected");

		Iterator<String> preorder = tree.getPreorderIterator();

		while (preorder.hasNext()) {
			System.out.print(preorder.next() + " ");
		} 

		System.out.println(" Actual using PreorderIterator");
		System.out.println("---------------");
	} 

	public static void testPostorder(GeneralTreeInterface<String> tree, String answer) {
		System.out.println("\nPostOrder:");
		System.out.println(answer + "  Expected");

		Iterator<String> postorder = tree.getPostorderIterator();

		while (postorder.hasNext()) {
			System.out.print(postorder.next() + " ");
		} 

		System.out.println(" Actual using PostorderIterator\n---------------");
	} 

	public static void testEmptyTree() {
		System.out.println("\nTest empty tree:");
		GeneralTreeInterface<String> myTree = new GeneralTree<>();
		// myTree.root is null, so myTree is empty, not null

		if (myTree == null)
			System.out.println("myTree is null--ERROR");
		else {
			System.out.println("myTree is not null--CORRECT.");

			if (myTree.isEmpty())
				System.out.println("myTree is empty--CORRECT.");
			else
				System.out.println("myTree.root is not empty--ERROR");
		} 
		System.out.println();
	} 
} 

/*


 The tree in Figure 24-1:
 
          Carole
         /   |  \
        /    |   \
       /     |    \
    Brett Jennifer Brian
     /     / \
    /     /   \
   /     /     \
 Susan Jared  Jamie
 
 The tree is not empty
 Root of tree is Carole; s/b carole
 # nodes in tree is 7; s/b 7
 
 Preorder:
 carole brett susan jennifer jared jamie brian  Expected
 Carole Brett Susan Jennifer Jared Jamie Brian  Actual using PreorderIterator
 ---------------
 
 PostOrder:
 susan brett jared jamie jennifer brian carole  Expected
 Susan Brett Jared Jamie Jennifer Brian Carole  Actual using PostorderIterator
 ---------------
 
 Test empty tree:
 myTree is not null--CORRECT.
 myTree is empty--CORRECT.
 
 Done.

 */
