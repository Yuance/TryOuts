package Algorithms;

import java.io.*;
import java.util.*;
import java.lang.*;

public class NonDivisiableSubset {
    public static boolean checkDivisiable(int div, ArrayList<Integer> ar, ArrayList<Boolean> arCheck) {
    	boolean flag=true;
    	
    	if (count(arCheck)<2) return true;
    	
    	for (int i=0; i<ar.size(); i++) {
    		if (arCheck.get(i)) {
	    		for( int j=i+1; j<ar.size(); j++) {
	    			if (arCheck.get(j)) {
		    			if((ar.get(i)+ar.get(j)) % div == 0)
		    				flag=false;
		    			else continue;
	    			}
	    			else continue;
	    			
	    			if (flag == false)
	    				return flag;
	    		}
    		}
    		else continue;
    	}
    	return flag;
    }
    
    public static int searchDown(int layer, int div, ArrayList<Integer> ar, ArrayList<Boolean> arCheck, int Max) {
    	int count=0;
    	if (layer == ar.size()) return Max;
    	
    	for(; layer<ar.size(); layer++) {
    		arCheck.set(layer, false);
    		if (checkDivisiable(div, ar, arCheck)) {
    			count = count(arCheck);
    			if (Max==0) Max=count;
    			else if (Max < count) Max = count;
    			System.out.println(arCheck);
    		}
    		Max = searchDown(layer+1, div, ar, arCheck, Max);
    		arCheck.set(layer, true);
    		
    	}
    	if (count(arCheck) == ar.size() && layer == ar.size()) {
    		System.out.println(Max);
    	}
    	return Max;
    }
  

	public static int count(ArrayList<Boolean> arCheck) {
    	int sizeCount=0;
    	for (int i=0; i<arCheck.size();i++) {
    		if (arCheck.get(i))
    			sizeCount++;
    	}
    	return sizeCount;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named FrequencySort. */
    	int n=0, k=0;
    	ArrayList<Integer> ar;
    	Scanner scan = new Scanner(System.in);
    	n=scan.nextInt();
    	k=scan.nextInt();
    	ar= new ArrayList<Integer>(n);
    	for (int i=0; i<n; i++) {
    		ar.add(scan.nextInt() % k);
    	}

    	ArrayList<Boolean> arCheck = new ArrayList<Boolean>(ar.size());

    	for(int i=0; i<ar.size(); i++) {
    		arCheck.add(i, true);
    	}
    	if (checkDivisiable(k, ar, arCheck)) {
    		System.out.println(n);
    		return;
    	}
    	else searchDown(0, k, ar, arCheck, 0);
    	return;
    	
    }
}