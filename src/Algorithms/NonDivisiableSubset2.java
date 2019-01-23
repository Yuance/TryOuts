package Algorithms;

import java.util.*;

public class NonDivisiableSubset2 {

    public static void main(String args[]) {
    	
        int n=0, k=0;
        int result = 0;
        
    	Scanner scan = new Scanner(System.in);
    	n=scan.nextInt();
    	k=scan.nextInt();
    	
    	int [] count = new int[k+1];
    	int [] ar = new int[n];
    	
    	for (int i=0; i<=k/2+1; i++)
    		count[i]=0;
        for (int i=0; i<n; i++) {
        	ar[i] = scan.nextInt()%k;
        	count[ar[i]]++;
        }
        
        for (int i=1; i<=k/2; i++) {
        	if (count[i] < count[k-i])
        		result += count[k-i];
        	else result += count[i];
        
        }
        if (k%2 == 0 && count[k/2] !=0) {
        	result -= count[k/2];
        	result++;
        }

        if (count[0] != 0) result++;
        
        System.out.println(result);
        return;
    }
    
}