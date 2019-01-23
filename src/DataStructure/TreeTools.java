package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import DataStructure.Node;

public class TreeTools {
	
	public static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		if (root == null)
	        return;
	    postOrder(root.left);
	    postOrder(root.right);
	    System.out.print(root.data + " ");
	}
	
	public static void inOrder(Node root) {
	    
	    if (root == null)
	        return;
	    inOrder(root.left);
	    System.out.print(root.data + " ");
	    inOrder(root.right);
	    
	}
	
	public static int height(Node root) {

        if (root == null)
           return 0;
        
        if (root.left == null && root.right == null)
	       return 0;
		
		int left = height(root.left);
		int right = height(root.right);
		
        
		return (left > right? left:right) + 1; 
        
    }
	
	static int countTopView = 0;
	
	public static void top_view(Node root) {
		
		if(root.left!=null && countTopView>=0){
		    countTopView++;
		    top_view(root.left);
		}

		System.out.print(root.data+ " ");
		countTopView--;

		if(root.right!=null && countTopView<0){
		    countTopView--;
		    top_view(root.right);

		}
	}

	public static void levelOrder(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
			
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
			
		}
		System.out.println("");
	}
	
	public static Node InsertBST(Node root, int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			return root;
		}
		Node temp = root;
		while (true) {
			if (value < temp.data) {
				if (temp.left == null) {
					temp.left = newNode;
					return root;
				}
				else temp = temp.left;
				
			}
			else if (value > temp.data) {
				if (temp.right == null) {
					temp.right = newNode;
					return root;
				}
				else temp = temp.right;
			}
			
		}
	}
	/*  
	   class Node
	      public  int frequency; // the frequency of this tree
	       public  char data;
	       public  Node left, right;
	    
	*/ 

	void decode(String S ,Node root) {
	    
        char c = S.charAt(0);
        
        Node temp = root;
		for (int i = 0; i < S.length(); i++) {
            
            c = S.charAt(i);
            
            if (c == '1') {
                if (temp.data == '\0') {
                    temp = temp.right;
                    if (temp.data != '\0') {
                        System.out.print(temp.data);
                        temp = root;
                    }
                }
            }
            else if (c == '0') {
                if (temp.data == '\0') { 
                    temp = temp.left;
                    if (temp.data != '\0') {
                        System.out.print(temp.data);
                        temp = root;
                    }
                
                }
            }
        }
		
	}
	public static Node lca(Node root, int v1, int v2) {
		if (root.data < v1 && root.data < v2)
			root = lca(root.right, v1, v2);
		else if (root.data > v1 && root.data > v2)
			root = lca(root.left,v1 ,v2);
		
		else return root;
		
		return root;
	}

	    

}