package TreeDriverPackage;

import java.util.Iterator;
import java.util.HashMap;

import TreePackage.*;

/**
 * A driver that demonstrates the use of any class that implements BinaryTreeInterface.
 * Currently, this is BinaryTree and ArrayBinaryTree.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Modified extensively. Now uses HashMap to store trees, including the empty tree
 * 
 * Uses CompletedBinaryTree<String>. To use other implementations,
 * change this in createTrees(), testIterativePreorder() and 
 *   testIterativeAndRecursiveInorder(). Unfortunately, the tested traversal
 *   methods are not part of the BinaryTreeInterface.
 *   Or simply comment out the test methods.
 * 
 */
public class BinaryTreeTestDriver {
	public static void main(String[] args)

	{
		
		BinaryTreeInterface<String> root;
		
		// create a tree using all other trees as subtrees
		//  show statistics
		//  then traverse, comparing against expected
		//   preorder, inorder, postorder, levelorder
		
		root = createTree1();
		showTreeStats(root, "A", 3, 7);
		testTraversals(root, "A B D E C F G", "D B E A F C G", "D E B F G C A", "A B C D E F G");

		root = createTree2();
		showTreeStats(root, "A", 3, 6);
		testTraversals(root, "A B E C F G", "B E A F C G", "E B F G C A", "A B C E F G");

		root = createTree3();
		showTreeStats(root, "A", 4, 7);
		testTraversals(root, "A B D E C F G", "D B E A F G C", "D E B G F C A", "A B C D E F G");
		
		root = createTree4();
		showTreeStats(root, "A", 4, 8);
		testTraversals(root, "A B D H E C F G", "D H B E A F C G", "H D E B F G C A", "A B C D E F G H");

		root = createTree5();
		showTreeStats(root, "A", 4, 8);
		testTraversals(root, "A B D E H C F G", "D B E H A F C G", "D H E B F G C A", "A B C D E F G H");

		root = createTree6();
		showTreeStats(root, "A", 4, 8);
		testTraversals(root, "A B D E F G C H", "D B F E G A C H", "D F G E B H C A", "A B C D E H F G");

		root = createTree7();
		showTreeStats(root, "A", 4, 11);
		testTraversals(root, "A B D E F G B D E F G", "D B F E G A D B F E G", "D F G E B D F G E B A",
				"A B B D E D E F G F G");

		root = createTreeSegment2421();
		showTreeStats(root, "A", 4, 8);	
		testTraversals(root, "A B D E F G C H", "D B F E G A C H", "D F G E B H C A", "A B C D E H F G");

		// test against the empty tree
		testEmptyTree();
		System.out.println("Done.");
	} 
	
	/**
	 * Create a set of trees with single letter names.
	 * 
	 * Use a HashMap to be able to get the tree (value) by its name (key)
	 * @return
	 */
	public static HashMap<String, BinaryTreeInterface<String>> createTrees() {
		HashMap<String, BinaryTreeInterface<String>> trees = new HashMap<>();
		String[] treeNames = { "A", "B", "C", "D", "E", "F", "G", "H", "empty" };
		
		// for each tree name, create a new tree and add it to the map with
		//  its name as a key
		
		for(String treeName : treeNames) {
//			trees.put(treeName, new CompletedArrayBinaryTree<String>(treeName));
			trees.put(treeName, new CompletedBinaryTree<String>(treeName));
//			trees.put(treeName, new ArrayBinaryTree<String>(treeName));
//			trees.put(treeName, new BinaryTree<String>(treeName));
		}
		
		// an empty tree was added to the map.
		//  clear all data in this tree, which will also set its name to null
		//  the key will remain in the HashMap so we can still retrieve it
		
		// there is a difference between a tree that is set to null 
		//   and an empty tree
		
		trees.get("empty").clear();
		return trees;
	}
	
	/** 
	 * Tests the 4 traversals of a given binary tree. */
	
	/**
	 * Tests the 4 traversals of a given binary tree
	 * @param tree tree to test
	 * @param preorder expected preorder output
	 * @param inorder expected inorder output
	 * @param postorder expected postorder output
	 * @param levelOrder expected levelorder output
	 */
	public static void testTraversals(BinaryTreeInterface<String> tree, String preorder, String inorder, String postorder,
			String levelOrder) {
		testPreorder(tree, preorder);
		
		// the following is only supported in BinaryTree, so comment out if not
		testIterativePreorder(tree, preorder);
		testInorder(tree, inorder);
		// the following is only supported in BinaryTree, so comment out if not
		testIterativeAndRecursiveInorder(tree, inorder);
		testPostorder(tree, postorder);
		testLevelOrder(tree, levelOrder);
	} 
	
	/**
	 * Reset each tree's subtrees to null. This is not the same as clearing the tree,
	 * which also sets the root data to null.
	 * 
	 * This really doesn't work for BinaryTree as the subtrees are all copied and then
	 * the original cleared. So it is unused.
	 * 
	 * @param trees HashMap of trees to reset
	 */
	public static void resetTrees(HashMap<String, BinaryTreeInterface<String>> trees) {

		for(BinaryTreeInterface<String> tree : trees.values())
			tree.setTree(tree.getRootData(), null, null);
		
		// the empty tree has the root data set to null
		trees.get("empty").clear();
	}
	
	/**
	 * Tests iterative preorder. Only used with BinaryTree.
	 * @param tree
	 * @param answer expected output
	 */
	public static void testIterativePreorder(BinaryTreeInterface<String> tree, String answer) {
		System.out.println("\nIterative Preorder:");
		System.out.println(answer + "  Expected");

		
		((CompletedBinaryTree<String>) tree).iterativePreorderTraverse();
		System.out.println(" Actual using iterativePreorderTraverse");
		System.out.println("---------------");
	} 
	
	/**
	 * Tests iterative and recursive inorder traversal. Only
	 *   used with BinaryTree
	 * @param tree
	 * @param answer expected output
	 */
	public static void testIterativeAndRecursiveInorder(BinaryTreeInterface<String> tree, String answer) {
		System.out.println("\nIterative and Recursive Inorder:");
		System.out.println(answer + "  Expected");

		((CompletedBinaryTree<String>) tree).iterativeInorderTraverse();
		System.out.println(" Actual using iterativeInorderTraverse");
		
		((CompletedBinaryTree<String>) tree).recursiveInorderTraverse();
		System.out.println(" Actual using recursiveInorderTraverse");
		System.out.println("---------------");
	} 

	public static BinaryTreeInterface<String> createTreeSegment2421() {
		
		// create each tree with no left and right subtrees
		// need to recreate all of the subtrees for each test
		//   so a simple reset doesn't work
		// because BinaryTree implementation *copies* the subtree then
		// destroys the original. So the existing HashMap is then invalid
		
		// this is NOT the case for ArrayBinaryTree :-(
		
		HashMap<String, BinaryTreeInterface<String>> trees = createTrees();
		
		System.out.println("\nTree Segment2421:\n");
		System.out.println("     A      ");
		System.out.println("   /   \\   ");
		System.out.println("  B     C   ");
		System.out.println(" / \\     \\ ");
		System.out.println("D   E     H ");
		System.out.println("   / \\     ");
		System.out.println("  F   G     ");
		System.out.println();
		
		// use the HashMap to get each tree
		// start at the bottom of the tree to set subtrees
		
		// set E node subtrees to F and G
		trees.get("E").setTree("E", trees.get("F"), trees.get("G"));
		
		// set B node subtrees to D and E
		trees.get("B").setTree("B", trees.get("D"), trees.get("E"));
		
		// set C node subtrees to empty and H. Empty has no data at all (root is null)
		trees.get("C").setTree("C", trees.get("empty"), trees.get("H"));
		
		// finally, set A node subtrees to B and C
		trees.get("A").setTree("A", trees.get("B"), trees.get("C"));
		
		// this demonstrates that the HashMap is no longer valid
		// only A exists :-(
//		for(BinaryTreeInterface<String> tree : trees.values())
//			System.out.println("Tree " + tree.getRootData() + " numberOfNodes " +  tree.getNumberOfNodes());
		
		// A is now the root and contains links to all other nodes in the tree
		// return A's tree to the caller as the root
		return trees.get("A");
	} 

	public static BinaryTreeInterface<String> createTree1() {
	
		HashMap<String, BinaryTreeInterface<String>> trees = createTrees();
		
		System.out.println("\nTree 1:\n");
		System.out.println("     A      ");
		System.out.println("   /   \\   "); // '\\' is the escape character for backslash
		System.out.println("  B     C   ");
		System.out.println(" / \\   / \\");
		System.out.println("D   E  F  G ");
		System.out.println();
		
		trees.get("B").setTree("B", trees.get("D"), trees.get("E"));
		trees.get("C").setTree("C", trees.get("F"), trees.get("G"));
		
		trees.get("A").setTree("A", trees.get("B"), trees.get("C"));
		
		return trees.get("A");
	} 

	public static BinaryTreeInterface<String> createTree2() {
	
		HashMap<String, BinaryTreeInterface<String>> trees = createTrees();
		
		System.out.println("\nTree 2:\n");
		System.out.println("     A      ");
		System.out.println("   /   \\   ");
		System.out.println("  B     C   ");
		System.out.println("   \\   / \\");
		System.out.println("    E  F  G ");
		System.out.println();
		
		trees.get("C").setTree("C", trees.get("F"), trees.get("G"));
		trees.get("B").setTree("B", null, trees.get("E"));

		
		trees.get("A").setTree("A", trees.get("B"), trees.get("C"));
		
		return trees.get("A");
	} 

	public static BinaryTreeInterface<String> createTree3() {
		
		HashMap<String, BinaryTreeInterface<String>> trees = createTrees();
		
		System.out.println("\nTree 3:\n");
		System.out.println("     A      ");
		System.out.println("   /   \\  ");
		System.out.println("  B     C  ");
		System.out.println(" / \\   /  ");
		System.out.println("D   E  F   ");
		System.out.println("        \\ ");
		System.out.println("         G ");
		System.out.println();
		
		// notice use of null entries for subtrees here rather than use of the empty tree
		// the result is the same
		
		trees.get("F").setTree("F", null, trees.get("G"));
		trees.get("B").setTree("B", trees.get("D"), trees.get("E"));
		trees.get("C").setTree("C", trees.get("F"), null);
		
		trees.get("A").setTree("A", trees.get("B"), trees.get("C"));
		
		return trees.get("A");
	} 
	
	public static BinaryTreeInterface<String> createTree4() {
		
		HashMap<String, BinaryTreeInterface<String>> trees = createTrees();
		
		System.out.println("\nTree 4:\n");
		System.out.println("     A      ");
		System.out.println("   /   \\   ");
		System.out.println("  B     C   ");
		System.out.println(" / \\   / \\");
		System.out.println("D   E  F  G ");
		System.out.println(" \\         ");
		System.out.println("  H         ");
		System.out.println();
		
		trees.get("D").setTree("D", null, trees.get("H"));
		trees.get("B").setTree("B", trees.get("D"), trees.get("E"));
		trees.get("C").setTree("C", trees.get("F"), trees.get("G"));
		
		trees.get("A").setTree("A", trees.get("B"), trees.get("C"));
		
		return trees.get("A");
	} 

	public static BinaryTreeInterface<String> createTree5() {
		
		HashMap<String, BinaryTreeInterface<String>> trees = createTrees();
		
		System.out.println("\nTree 5:\n");
		System.out.println("     A      ");
		System.out.println("   /   \\   ");
		System.out.println("  B     C   ");
		System.out.println(" / \\   / \\");
		System.out.println("D   E  F  G ");
		System.out.println("     \\     ");
		System.out.println("      H     ");
		System.out.println();
		
		trees.get("E").setTree("E", null, trees.get("H"));
		trees.get("B").setTree("B", trees.get("D"), trees.get("E"));
		trees.get("C").setTree("C", trees.get("F"), trees.get("G"));
		
		trees.get("A").setTree("A", trees.get("B"), trees.get("C"));
		
		return trees.get("A");
	} 

	public static BinaryTreeInterface<String> createTree6() {
		
		HashMap<String, BinaryTreeInterface<String>> trees = createTrees();
		
		System.out.println("\nTree 6:\n"); // Fig. 24-13
		System.out.println("     A      ");
		System.out.println("   /   \\   ");
		System.out.println("  B     C   ");
		System.out.println(" / \\     \\");
		System.out.println("D   E     H ");
		System.out.println("   / \\     ");
		System.out.println("  F   G     ");
		System.out.println();
		
		// use of empty tree instead of null
		
		trees.get("E").setTree("E", trees.get("F"), trees.get("G"));
		trees.get("B").setTree("B", trees.get("D"), trees.get("E"));
		trees.get("C").setTree("C", trees.get("empty"), trees.get("H"));
		
		trees.get("A").setTree("A", trees.get("B"), trees.get("C"));
		
		return trees.get("A");
	} 

	public static BinaryTreeInterface<String> createTree7() {
		
		HashMap<String, BinaryTreeInterface<String>> trees = createTrees();
		
		System.out.println("\nTree 7:\n");
		System.out.println("     A      ");
		System.out.println("   /   \\     ");
		System.out.println("  B     B     ");
		System.out.println(" / \\   / \\  ");
		System.out.println("D   E D   E   ");
		System.out.println("   / \\   / \\");
		System.out.println("  F   G F   G ");
		System.out.println();
		
		// two of the same subtrees are children of A
		
		// B subtree
		trees.get("E").setTree("E", trees.get("F"), trees.get("G"));
		trees.get("B").setTree("B", trees.get("D"), trees.get("E"));
		
		// A has the left and right subtree both pointing to B
		trees.get("A").setTree("A", trees.get("B"), trees.get("B"));
		
		return trees.get("A");
	} 

	public static void showTreeStats(BinaryTreeInterface<String> tree, String root, int height, int numberOfNodes) {
		if (tree.isEmpty())
			System.out.println("The tree is empty");
		else
			System.out.println("The tree is not empty");

		System.out.println("Root of tree is " + tree.getRootData() + "; should be " + root);

		System.out.println("Height of tree is " + tree.getHeight() + "; should be " + height);

		System.out.println("# nodes in tree is " + tree.getNumberOfNodes() + "; should be " + numberOfNodes);
	} 

	/**
	 * Test level order traversal
	 * @param tree
	 * @param answer expected output
	 */
	public static void testLevelOrder(BinaryTreeInterface<String> tree, String answer) {
		System.out.println("\nLevel order:");
		System.out.println(answer + "  Expected");

		Iterator<String> levelOrder = tree.getLevelOrderIterator();

		while (levelOrder.hasNext()) {
			System.out.print(levelOrder.next() + " ");
		} 

		System.out.println(" Actual using LevelOrderIterator\n---------------");
	} 
	
	/**
	 * Test preorder traversal
	 * @param tree
	 * @param answer expected output
	 */
	public static void testPreorder(BinaryTreeInterface<String> tree, String answer) {
		System.out.println("\nPreorder:");
		System.out.println(answer + "  Expected");

		Iterator<String> preorder = tree.getPreorderIterator();

		while (preorder.hasNext()) {
			System.out.print(preorder.next() + " ");
		} 

		System.out.println(" Actual using PreorderIterator");
		System.out.println("---------------");
	} 

	/**
	 * Test inorder traversal
	 * @param tree
	 * @param answer expected output
	 */
	public static void testInorder(BinaryTreeInterface<String> tree, String answer) {
		System.out.println("\nInorder:");
		System.out.println(answer + "  Expected");

		Iterator<String> inorder = tree.getInorderIterator();

		while (inorder.hasNext()) {
			System.out.print(inorder.next() + " ");
		} 

		System.out.println(" Actual using InorderIterator");

		System.out.println("---------------");
	} 
	
	/**
	 * Test postorder traversal
	 * @param tree
	 * @param answer expected output
	 */
	public static void testPostorder(BinaryTreeInterface<String> aTree, String answer) {
		System.out.println("\nPostOrder:");
		System.out.println(answer + "  Expected");

		Iterator<String> postorder = aTree.getPostorderIterator();

		while (postorder.hasNext()) {
			System.out.print(postorder.next() + " ");
		} 

		System.out.println(" Actual using PostorderIterator\n---------------");
	} 

	/**
	 * Test empty tree. Tests whether root data exists.
	 * @param emptyTree
	 */
	public static void testEmptyTree() {
		
		// this is less efficient, but lets us keep the test of 
		// a particular implementation in createTrees()
		
		HashMap<String, BinaryTreeInterface<String>> trees = createTrees();
		
		BinaryTreeInterface<String> emptyTree = trees.get("empty");
		
		System.out.println("\nTest empty tree:");
		// myTree.root is null, so myTree is empty, not null

		if (emptyTree == null)
			System.out.println("myTree is null--ERROR");
		else {
			System.out.println("myTree is not null--CORRECT.");

			if (emptyTree.isEmpty())
				System.out.println("myTree is empty--CORRECT.");
			else
				System.out.println("myTree.root is not empty--ERROR");
		} 
		System.out.println();
	} 
} 

/*

Tree 1:

     A      
   /   \   
  B     C   
 / \   / \
D   E  F  G 

The tree is not empty
Root of tree is A; should be A
Height of tree is 3; should be 3
# nodes in tree is 7; should be 7

Preorder:
A B D E C F G  Expected
A B D E C F G  Actual using PreorderIterator
---------------

Inorder:
D B E A F C G  Expected
D B E A F C G  Actual using InorderIterator
---------------

PostOrder:
D E B F G C A  Expected
D E B F G C A  Actual using PostorderIterator
---------------

Level order:
A B C D E F G  Expected
A B C D E F G  Actual using LevelOrderIterator
---------------

Tree 2:

     A      
   /   \   
  B     C   
   \   / \
    E  F  G 

The tree is not empty
Root of tree is A; should be A
Height of tree is 3; should be 3
# nodes in tree is 6; should be 6

Preorder:
A B E C F G  Expected
A B E C F G  Actual using PreorderIterator
---------------

Inorder:
B E A F C G  Expected
B E A F C G  Actual using InorderIterator
---------------

PostOrder:
E B F G C A  Expected
E B F G C A  Actual using PostorderIterator
---------------

Level order:
A B C E F G  Expected
A B C E F G  Actual using LevelOrderIterator
---------------

Tree 3:

     A      
   /   \  
  B     C  
 / \   /  
D   E  F   
        \ 
         G 

The tree is not empty
Root of tree is A; should be A
Height of tree is 4; should be 4
# nodes in tree is 7; should be 7

Preorder:
A B D E C F G  Expected
A B D E C F G  Actual using PreorderIterator
---------------

Inorder:
D B E A F G C  Expected
D B E A F G C  Actual using InorderIterator
---------------

PostOrder:
D E B G F C A  Expected
D E B G F C A  Actual using PostorderIterator
---------------

Level order:
A B C D E F G  Expected
A B C D E F G  Actual using LevelOrderIterator
---------------

Tree 4:

     A      
   /   \   
  B     C   
 / \   / \
D   E  F  G 
 \         
  H         

The tree is not empty
Root of tree is A; should be A
Height of tree is 4; should be 4
# nodes in tree is 8; should be 8

Preorder:
A B D H E C F G  Expected
A B D H E C F G  Actual using PreorderIterator
---------------

Inorder:
D H B E A F C G  Expected
D H B E A F C G  Actual using InorderIterator
---------------

PostOrder:
H D E B F G C A  Expected
H D E B F G C A  Actual using PostorderIterator
---------------

Level order:
A B C D E F G H  Expected
A B C D E F G H  Actual using LevelOrderIterator
---------------

Tree 5:

     A      
   /   \   
  B     C   
 / \   / \
D   E  F  G 
     \     
      H     

The tree is not empty
Root of tree is A; should be A
Height of tree is 4; should be 4
# nodes in tree is 8; should be 8

Preorder:
A B D E H C F G  Expected
A B D E H C F G  Actual using PreorderIterator
---------------

Inorder:
D B E H A F C G  Expected
D B E H A F C G  Actual using InorderIterator
---------------

PostOrder:
D H E B F G C A  Expected
D H E B F G C A  Actual using PostorderIterator
---------------

Level order:
A B C D E F G H  Expected
A B C D E F G H  Actual using LevelOrderIterator
---------------

Tree 6:

     A      
   /   \   
  B     C   
 / \     \
D   E     H 
   / \     
  F   G     

The tree is not empty
Root of tree is A; should be A
Height of tree is 4; should be 4
# nodes in tree is 8; should be 8

Preorder:
A B D E F G C H  Expected
A B D E F G C H  Actual using PreorderIterator
---------------

Inorder:
D B F E G A C H  Expected
D B F E G A C H  Actual using InorderIterator
---------------

PostOrder:
D F G E B H C A  Expected
D F G E B H C A  Actual using PostorderIterator
---------------

Level order:
A B C D E H F G  Expected
A B C D E H F G  Actual using LevelOrderIterator
---------------

Tree 7:

     A      
   /   \     
  B     B     
 / \   / \  
D   E D   E   
   / \   / \
  F   G F   G 

The tree is not empty
Root of tree is A; should be A
Height of tree is 4; should be 4
# nodes in tree is 11; should be 11

Preorder:
A B D E F G B D E F G  Expected
A B D E F G B D E F G  Actual using PreorderIterator
---------------

Inorder:
D B F E G A D B F E G  Expected
D B F E G A D B F E G  Actual using InorderIterator
---------------

PostOrder:
D F G E B D F G E B A  Expected
D F G E B D F G E B A  Actual using PostorderIterator
---------------

Level order:
A B B D E D E F G F G  Expected
A B B D E D E F G F G  Actual using LevelOrderIterator
---------------

Tree Segment2421:

     A      
   /   \   
  B     C   
 / \     \ 
D   E     H 
   / \     
  F   G     

The tree is not empty
Root of tree is A; should be A
Height of tree is 4; should be 4
# nodes in tree is 8; should be 8

Preorder:
A B D E F G C H  Expected
A B D E F G C H  Actual using PreorderIterator
---------------

Inorder:
D B F E G A C H  Expected
D B F E G A C H  Actual using InorderIterator
---------------

PostOrder:
D F G E B H C A  Expected
D F G E B H C A  Actual using PostorderIterator
---------------

Level order:
A B C D E H F G  Expected
A B C D E H F G  Actual using LevelOrderIterator
---------------

Test empty tree:
myTree is not null--CORRECT.
myTree is empty--CORRECT.

Done.


*/
