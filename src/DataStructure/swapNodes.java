package DataStructure;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class swapNodes {
	public static Node swapSubtree(int height, Node root) {
		Queue<Node> queueA = new LinkedList<Node>();
		Queue<Node> queueB = new LinkedList<Node>();
		Queue<Node> queueRef;
		
		queueA.add(root);
		Node temp = root;
		Node swapTemp;
		int heightRec = 1;
		queueRef = queueA;
		while (heightRec != height) {
			
			while (!queueRef.isEmpty()) {
				temp = queueRef.poll();
				
				if (queueRef.equals(queueA))
					queueRef = queueB;
				else queueRef = queueA;
				
				if (temp.left != null)
					queueRef.add(temp.left);
				if (temp.right != null)
					queueRef.add(temp.right);
				
				if (queueRef.equals(queueA))
					queueRef = queueB;
				else queueRef = queueA;
			}
			
			if (queueRef.equals(queueA))
				queueRef = queueB;
			else queueRef = queueA;
			
			heightRec++;
			
		}
		while (!queueRef.isEmpty()) {
			temp = queueRef.poll();
			swapTemp = temp.left;
			temp.left = temp.right;
			temp.right = swapTemp;
		}
		return root;
	}
	public static Node InsertTree(Node root, int[] left, int[] right, int n) {
    	
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node temp;
		int i = 0;
		for (int j = 0; j < n; j++) {
			temp = queue.poll();
			if (left[i] != -1) {
				Node leftNode = new Node(left[i]);
				temp.left = leftNode;
				queue.add(leftNode);
			}
			else temp.left = null;
			
			if (right[i] != -1) {
				Node rightNode = new Node (right[i]);
				temp.right = rightNode;
				queue.add(rightNode);
			}
			else temp.right = null;
			
			i++;
		}
		return root;
	}
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named FrequencySort. */
    	Scanner scan = new Scanner(System.in);
    	
    	int n = scan.nextInt();
    	Node root = new Node(1);
    	int[] left = new int[n];
    	int[] right = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		left[i] = scan.nextInt();
    		right[i] = scan.nextInt();
    	}
    	root = InsertTree(root, left, right, n);
    	
    	int Ops = scan.nextInt();
    	int[] k = new int[Ops];
    	
    	for (int i = 0; i < Ops; i++) {
    		k[i] = scan.nextInt();
    		int height = TreeTools.height(root) + 1;
    		
    		for (int j = 1; j <= height / k[i]; j++) {
    			root = swapSubtree(k[i]*j, root);
    		}
			TreeTools.inOrder(root);
    	}
    	return;
    }
}