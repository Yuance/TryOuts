package DataStructure;

import java.io.*;
import java.util.*;

public class SparseArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
    	Scanner scan = new Scanner(System.in);
    	
    	int n=0, q=0;
  
    	n = scan.nextInt();
    	scan.nextLine();
    	String[] str = new String[n];
    	for (int i=0; i<n; i++) 
    		str[i] = scan.nextLine();
    	
    	
    	q = scan.nextInt();
    	int[] count = new int[q];
    	
    	scan.nextLine();
    	String[] qstr = new String[q];
    	for(int i=0; i<q; i++) {
    		qstr[i] = scan.nextLine();
    	}
    	
    	for (int i=0; i<n; i++) {
    		for (int j=0; j<q; j++) {
    			if (str[i].equalsIgnoreCase(qstr[j])) {
    				count[j]++;
    			}
    				
    		}
    	}
    	for (int i=0; i<q; i++) {
    		System.out.println(count[i]);
    	}
    	
    }
}