package DataStructure;

import java.io.*;
import java.util.*;

public class ArrayCrush {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
    	int m,n;
    	Long max, temp;
    	Scanner scan = new Scanner(System.in);
    	m = scan.nextInt();
    	n = scan.nextInt();
    	int[] op = new int[m+1];
    	
    	int a,b;
    	Long adden;
    	
    	for (int i=0; i<m+1; i++) {
    		op[i] = 0;
    	}
    	for (int i=0; i<n; i++) {
    		a = scan.nextInt();
    		b = scan.nextInt();
    		adden = scan.nextLong();
    		op[a] += adden;
    		if (b+1<=m) op[b+1] -= adden;
    		
    	}
    	max = 0L; temp = 0L;
    	for (int i=0; i<m+1; i++) {
    		temp += op[i];
    		if (max < temp) max = temp;
    	}
    	
    	System.out.println(max);
    }
}