package trees;

class Node {
    String key;
    Node left, right;
 
    public Node(String item)
    {
        key = item;
        left = right = null;
    }
    
    
}
 
class BinaryTree {
    // Root of Binary Tree
    Node root;
 
    BinaryTree() { root = null; }
 
    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    void printPostorder(Node node)
    {
        if (node == null)
            return;
 
        // first recur on left subtree
        printPostorder(node.left);
 
        // then recur on right subtree
        printPostorder(node.right);
 
        // now deal with the node
        System.out.print(node.key + " ");
    }
 
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.key + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
 
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;
 
        /* first print data of node */
        System.out.print(node.key + " ");
 
        /* then recur on left subtree */
        printPreorder(node.left);
 
        /* now recur on right subtree */
        printPreorder(node.right);
    }
    
    void printExpression(Node n) {
		if (n == null) 
			return;
			System.out.print("(");
			printExpression(n.left);
			System.out.print(n.key);
			printExpression(n.right);
			System.out.print(")");
		
	}
 
    // Wrappers over above recursive functions
    void printPostorder() { printPostorder(root); }
    void printInorder() { printInorder(root); }
    void printPreorder() { printPreorder(root); }
    void printExpression() { printExpression(root); }
 
    // Driver method
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node("+");
        tree.root.left = new Node("*");
        tree.root.right = new Node("*");
        tree.root.left.left = new Node("4");
        tree.root.left.right = new Node("5");
        tree.root.right.right = new Node("2");
        tree.root.right.left = new Node("3");
 /**
        System.out.println(
            "Preorder traversal of binary tree is ");
        tree.printPreorder();
 
        System.out.println(
            "\nInorder traversal of binary tree is ");
        tree.printInorder();
 
        System.out.println(
            "\nPostorder traversal of binary tree is ");
        tree.printPostorder();
        
      */
       tree.printExpression();
    }
}
