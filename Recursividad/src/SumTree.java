

class Node {

    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
    
    public boolean isLeaf() {
    	if(left == null && right == null) {
    		return true;
    	}else return false;
    }
}

public class SumTree {
	
	Node root;
	
	
	
	
	 public SumTree() {
		super();
	}

	 
     
	public int sum(Node raiz){
		
	        if (raiz.isLeaf()) {
	        	//System.out.println("isleaf");
	        	return raiz.data;
	        	
	        }else {
	        	
	        	int left  = 0;
	    	    int right = 0;
		        
		        if(raiz.left != null) {
		        	
		        	
		            left += sum(raiz.left);
		            System.out.println("left: "+left);
		            
		        }
		        
		        if(raiz.right != null) {
		        	right += sum(raiz.right);
		        	System.out.println("right: "+right);
		        }
		        
		        
		        return raiz.data + (left + right);
	        }
	        
	        
	    }
	
	 public boolean checkSum() {
		 if(root.data == sum(root)) {
			 return true;
		 } else {
			 return false;
		 }
	 }
	 
	 public static void main(String args[]) {
	        
	        SumTree tree = new SumTree();
	        tree.root = new Node(0);
	        tree.root.left = new Node(9);
	        tree.root.right = new Node(13);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        tree.root.right.left = new Node(7);
	        tree.root.right.right = new Node(6);
	        
	        tree.root.data = tree.sum(tree.root);
	        System.out.println(tree.root.data);
	 }
}
