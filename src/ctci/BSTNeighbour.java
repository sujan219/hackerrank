package ctci;

import java.util.LinkedList;
import java.util.Queue;

public class BSTNeighbour {
	
	public static void main(String[] args) {
		Node[] arr = new Node[11];
		for(int i=0; i<arr.length; ++i){
			arr[i] = new Node(i);
		}
		
		arr[0].left = arr[1].depth(1);
		arr[0].right = arr[2].depth(1);
		arr[1].left = arr[3].depth(2);
		arr[1].right = arr[4].depth(2);
		arr[2].left = arr[5].depth(2);
		arr[3].left = arr[6].depth(3);
		arr[3].right = arr[7].depth(3);
		arr[4].left = arr[8].depth(3);
		arr[4].right = arr[9].depth(3);
		arr[5].right = arr[10].depth(3);
		
		updateNeighbours(arr[0]);
		for(Node n:arr){
			System.out.println(n);
		}
	}
	
	private static void updateNeighbours(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node n = queue.remove();
			if(queue.peek() != null && queue.peek().depth == n.depth){
				n.neighbour = queue.peek();
			}
			
			if(n.left != null){
				queue.add(n.left);
			}
			
			if(n.right != null){
				queue.add(n.right);
			}
		}
	}
	
	public static class Node{
		Node left;
		Node right;
		int data;
		int depth;
		Node neighbour;
		
		Node(int data){
			this.data = data;
		}
		
		Node depth(int d){
			this.depth = d;
			return this;
		}
		
		@Override
		public String toString() {
			if(neighbour == null){
				return data+"->NULL";
			}else{
				return data+"->"+neighbour.data;
			}
		}
	}
}