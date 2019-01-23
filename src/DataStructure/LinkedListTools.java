package DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedListTools {
	
	public static int compareLists(Node headA, Node headB) {
	
		if (headA == null && headB == null)
			return 1;
		else if (headA == null || headB == null)
			return 0;
    
		Node tempA = headA, 
				tempB = headB;
    
		while (tempA != null && tempB != null) {
        
			if (tempA.data == tempB.data) {
				tempA = tempA.next;
				tempB = tempB.next;
			}
			else return 0;
        
		}
    
		if (tempA == null && tempB == null ) 
			return 1;
		else return 0;
	}
	
	public static Node mergeLists(Node headA, Node headB) {
		  
	    if (headA == null) return headB;
	    else if (headB == null) return headA;
	    
	    Node tempA = headA;
	    Node tempB = headB;
	    Node newHead=null, temp=null;
	    
	    while (tempA != null && tempB != null) {
	        if (tempA.data <= tempB.data) {
	            if (newHead == null) {
	                newHead = tempA;
	                temp = newHead;
	                tempA = tempA.next;
	            }
	            else {
	                temp.next = tempA;
	                temp = temp.next;
	                tempA = tempA.next;
	            }
	        }
	        else {
	            if (newHead == null) {
	                newHead = tempB;
	                temp = newHead;
	                tempB = tempB.next;
	            }
	            else {
	                temp.next = tempB;
	                temp = temp.next;
	                tempB = tempB.next;
	            }
	        }
	    }
	    
	    if (tempA == null && tempB == null) {
	        temp.next = null;
	        return newHead;
	    }
	    else if (tempA == null ) {
	        temp.next = tempB;
	    }
	    
	    else temp.next = tempA;
	    
	    return newHead;
	
	}

	public static Node reverseSinglyList (Node head) {
		if (head == null) return head;
		Node temp = head;
	    Node next = head;
	    Node pre = head;
	    do {
	        next = temp.next;
	        if (temp.equals(head))
	        	head.next = null;
	        else temp.next = pre;
	        pre = temp;
	        temp = next;
	    } while (next != null);
	    
	    return pre;
	}
	
	public static void printList(Node head) {
		
		if (head == null) return;
		
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
	
	public static Node readList() {
		Scanner scan = new Scanner(System.in);
		Node head = null, pre = null;
		
		String LinkedList = scan.nextLine();
		String[] nodes = LinkedList.split("->");
		
		if (nodes.length == 0) return null;
	
		for (int i=0; i<nodes.length; i++) {
			Node n;
			if (nodes[i].equalsIgnoreCase("null"))
				n = null;
			else 
				n = new Node(nodes[i]);
			
			if (i == 0) 
				head = n;
			else pre.next = n;
			
			pre = n;
		}
		
		return head;
	}
	
	public static int getValueFromTail(Node head, int n) {
		
		Node temp = head;
	    int i=0;
	    
	    while (temp.next != null) {
	        i++;
	        temp = temp.next;
	    }
	    
	    i -= n;
	    
	    for (; i>0; i--) 
	        head = head.next;
	    
	    return head.data;
	}
	
	public static Node removeDuplicates(Node head) {
		
		if (head == null) return head;
	    if (head.next ==null) return head;
	    		
	    Node temp = head.next;
	    Node pre = head;
	    while (temp.next != null) {
	        if (temp.data == temp.next.data) {
	            if (temp.equals(head)) {
	                temp = head.next;
	                head = head.next;
	                pre = head;
	            }
	            else {
	            	if (pre.equals(temp))
	            		temp = temp.next;
	                pre.next = temp.next;
	                temp = pre.next;
	            }
	        }
	        else {
	            temp = temp.next;
	            pre = pre.next;
	        }
	    }
	    return head;
	}
	
	public static Node findInterleave(Node headA, Node headB) {
		
		Node tempA = headA;
	    Node tempB = headB;
	    while (tempA != tempB) {
	        if (tempA.next == null)        
	            tempA = headB;
	        else tempA = tempA.next;

	        if (tempB.next == null)
	            tempB = headA;
	        else tempB = tempB.next;
	    }
	    
	    return tempA;
	}
	
	public static Node sortedInsert(Node head, int data) {
		  if (head == null) {
		        head = new Node(data);
		        head.next = null;
		        head.prev = null;
		        return head;
		    }
		    Node pre = head;
		    Node temp = head;
		    
		    while (temp != null) {
		    	
		        if (temp.data >= data) {
		            
		            if (pre.equals(head) && temp.equals(head)) {
		                temp.prev = new Node(data);
		                head = temp.prev;
		                head.prev = null;
		                head.next = temp;
		            }
		            
		            else {
		                pre.next = new Node(data);
		                pre.next.prev = pre;
		                temp.prev = pre.next;
		                pre.next.next = temp;
		                
		            }
		            
		            return head;
		        }
		        
		        else {
		        	if (temp == pre.next) pre = pre.next;
		        	temp = temp.next;
		        }
		    }
		    pre.next = new Node(data);
		    pre.next.next = null;
		    pre.next.prev =pre;
		    return head;
	}
	
	public static Node reverseDoublyList(Node head) {
		if (head == null) return head;
		if (head.next == null) return head;
		
		Node temp = head;
		Node next = head.next;
		
		while (next != null) {
			if (temp.equals(head)){
				temp.next = null;
				temp.prev = next;
				
				temp = next;
				next = next.next;
			}
			else {
				temp.next = temp.prev;
				temp.prev = next;
				
				temp = next;
				next = next.next;
			}
		}
		
		temp.next = temp.prev;
		temp.prev = next;
		
		return temp;
		
	}
}