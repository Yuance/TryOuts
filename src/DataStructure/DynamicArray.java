package DataStructure;

import java.io.*;
import java.util.*;

public class DynamicArray {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
    	int n,q;
    	n = scan.nextInt();
    	q = scan.nextInt();
    	
    	int x, y;
    	int choice;
		int lastAns = 0;
		
    	ArrayList[] sequenceList = new ArrayList[n];
    	for (int i=0; i<n; i++)
    		sequenceList[i] = new ArrayList<Integer>();
    	
    	for (int i=0; i<q; i++) {
    		int seq;
    		choice = scan.nextInt();
    		x = scan.nextInt();
			y = scan.nextInt();
			seq = (x ^ lastAns) % n;
			
    		if (choice == 1) {
    			sequenceList[seq].add(y);

    		}
    	
    		else if (choice == 2) {

    			lastAns = (Integer)(sequenceList[seq].get(y % sequenceList[seq].size()));
    			System.out.println(lastAns);
    		}
    	}
    	
    }
}