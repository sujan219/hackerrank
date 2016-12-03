package nishant;

import java.util.ArrayList;
import java.util.List;

public class CommonManager {
	public static void main(String[] args){
		Node[] nodeArr = new Node[11];
		for(int i=0; i<11; ++i){
			nodeArr[i] = new Node(i+1, "Node: " + (i+1));
		}
		
		nodeArr[0].addChild(nodeArr[1], nodeArr[2], nodeArr[3]);
		nodeArr[1].addChild(nodeArr[4], nodeArr[5]);
		nodeArr[2].addChild(nodeArr[6]);
		nodeArr[3].addChild(nodeArr[7]);
		nodeArr[5].addChild(nodeArr[8], nodeArr[9]);
		nodeArr[8].addChild(nodeArr[10]);
		
		System.out.println(solve(nodeArr[0], nodeArr[8], nodeArr[9]));
	}
	
	
	private static Node solve(Node root, Node e1, Node e2){
		if(root == null || root.equals(e1) || root.equals(e2)){
			return root;
		}
		
		boolean isE1 = false;
		boolean isE2 = false;
		for(Node child:root.children){
			Node temp = solve(child, e1, e2);
			if(temp != null){
				if(temp.equals(e1)){
					isE1 = true;
				}else if(temp.equals(e2)){
					isE2 = true;
				}else{
					return temp;
				}
			}
		}
		
		if(isE1 && isE2){
			return root;
		}else if(isE1){
			return e1;
		}else if(isE2){
			return e2;
		}else{
			return null;
		}
	}
	
	
	public static class Node{
		private int id;
		private String name;
		private List<Node> children;
		
		public Node(int id, String name){
			this.id = id;
			this.name = name;
			children = new ArrayList<Node>();
		}
		
		public void addChild(Node... n){
			for(Node eachNode:n){
				children.add(eachNode);
			}
		}
		
		@Override
		public boolean equals(Object obj) {
			Node n = (Node) obj;
			return id == n.id;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
}
