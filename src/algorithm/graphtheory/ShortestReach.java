package algorithm.graphtheory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ShortestReach {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i=0; i<t; ++i){
			int no = scanner.nextInt();
			Node[] nodes = new Node[no];
			for(int j=0; j<no; ++j){
				nodes[j] = new Node(j+1);
			}
			
			int edges = scanner.nextInt();
			for(int j=0; j<edges; ++j){
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				nodes[a-1].addAdjNode(nodes[b-1]);
				nodes[b-1].addAdjNode(nodes[a-1]);
			}
			
			int j = scanner.nextInt()-1;
			for(int k=0; k<no; ++k){
				if(j != k){
					for(Node n:nodes){
						n.isVisited = false;
						n.distance = Integer.MAX_VALUE;
					}
					Queue<Node> queue = new LinkedList<Node>();
					queue.add(nodes[j]);
					nodes[j].distance = 0;
					int ret = find(queue, nodes[k]);
					if(ret<1){
						ret = -1;
					}else{
						ret = ret*6;
					}
					System.out.print(ret + " ");
				}
			}
			System.out.println();
		}
	}
	
	static int find(Queue<Node> queue, Node des){
		Node source = queue.poll();
		while(source != null){
			if(!source.isVisited){
				source.isVisited = true;
				for(Node adj:source.adjNodes){
					if(adj.equals(des)){
						return source.distance + 1;
					}else if(!adj.isVisited && adj.distance>source.distance){
						adj.distance = source.distance+1;
						queue.add(adj);
					}
				}
			}
			source = queue.poll();
		}
		
		return -1;
	}
}

class Node {
	int val;
	boolean isVisited = false;
	int distance = 0;
	Set<Node> adjNodes;
	
	Node(int v){
		val = v;
		adjNodes = new HashSet<Node>();
	}
	
	void addAdjNode(Node n){
		adjNodes.add(n);
	}
	
	@Override
	public boolean equals(Object obj) {
		Node otherNode = (Node)obj;
		return otherNode.val == val;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return val;
	}
}
