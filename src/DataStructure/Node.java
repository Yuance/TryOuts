package DataStructure;


public class Node {
		int data;
		Node next = null;
		Node prev = null;
		Node left = null;
		Node right = null;
		
		public Node(String data) {
			this.data = Integer.parseInt(data);
		}

		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}
}