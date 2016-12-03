package nishant;

import java.util.LinkedList;
import java.util.Queue;

public class MazeSolution implements Solution {
	
//	private boolean[][] isVisited;
	private int[][] maze;
	private int endRow, endCol;
	private int rows, cols;
	
	private boolean isComputed = false;
	private int result = -1;
	
	public MazeSolution(int[][] maze, int endRow, int endCol, int rows, int cols) {
		this.maze = maze;
		this.endRow = endRow;
		this.endCol = endCol;
		this.rows = rows;
		this.cols = cols;
//		isVisited = new boolean[rows][cols];
	}
	
	private class Node{
		private int x, y;
		private int length;
		
		private Node(int x, int y, int length){
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
	
	@Override
	public int solve(){
		if(isComputed){
			return result;
		}else{
			isComputed = true;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(new Node(0, 0, 0));
			while(!queue.isEmpty()){
				Node node = queue.remove();
				maze[node.x][node.y] = 1;
				checkRightNode(node, queue);
				checkLeftNode(node, queue);
				checkTopNode(node, queue);
				checkBottomNode(node, queue);
				
				if(node.x == endRow && node.y == endCol){
					result = node.length;
					return result;
				}
			}
			return -1;
		}
	}
	
	private void checkRightNode(Node node, Queue<Node> queue){
		if(node.x+1<rows && maze[node.x+1][node.y] == 0){
			queue.add(new Node(node.x+1, node.y, node.length+1));
		}
	}
	
	private void checkLeftNode(Node node, Queue<Node> queue){
		if(node.x-1>=0 && maze[node.x-1][node.y] == 0){
			queue.add(new Node(node.x-1, node.y, node.length+1));
		}
	}
	
	private void checkTopNode(Node node, Queue<Node> queue){
		if(node.y-1>=0 && maze[node.x][node.y-1] == 0){
			queue.add(new Node(node.x, node.y-1, node.length+1));
		}
	}
	
	private void checkBottomNode(Node node, Queue<Node> queue){
		if(node.y+1<cols && maze[node.x][node.y+1] == 0){
			queue.add(new Node(node.x, node.y+1, node.length+1));
		}
	}
}