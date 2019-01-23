package DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

import DataStructure.LinkedListTools;


public class LinkedListTest {
	
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		Node root = null;
		
		while (value != -1) {
			root = TreeTools.InsertBST(root, value);
			TreeTools.inOrder(root);
			value = scan.nextInt();
			
		}
		scan.close();
//		Node root = new Node(5);
//		root.left = new Node(3);
//		root.right = new Node(7);
//		
		
		////////////////////////////////
		System.out.println(checkBST(root));
		
	}
	
	static boolean checkBST(Node root) {
        boolean flag = true;
        inOrder(root);
 
        for (int i = 0; i < str.size() - 1; i++) {
            if (str.get(i) >= str.get(i+1))
                flag = false;
            
        }

		return flag;
    }
    static ArrayList<Integer> str = new ArrayList<Integer>();
    
    static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        str.add(root.data);
        inOrder(root.right);
        return;
    }
		
}
	