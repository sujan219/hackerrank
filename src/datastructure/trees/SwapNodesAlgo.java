package datastructure.trees;

import java.util.Scanner;

public class SwapNodesAlgo {
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int n = scanner.nextInt();
		 TreeNode[] arr = new TreeNode[n];
		 for(int i=0; i<n; ++i){
			 arr[i] = new TreeNode(i+1);
		 }
		 
		 for(int i=0; i<n; ++i){
			 int l = scanner.nextInt();
			 int r = scanner.nextInt();
			 if(l != -1){
				 arr[i].left = arr[l-1];
				 arr[i].left.depth = arr[i].depth+1; 
			 }
			 
			 if(r != -1){
				 arr[i].right = arr[r-1];
				 arr[i].right.depth = arr[i].depth+1;
			 }
		 }
		 
		 int t = scanner.nextInt();
		 for(int i=0; i<t; ++i){
			 int k = scanner.nextInt();
			 arr[0].reverseAt(k);
			 arr[0].print();
		 }
	 }
	 
	 static class TreeNode{
		 int data;
		 int depth;
		 TreeNode left;
		 TreeNode right;
		 
		 TreeNode(int data){
			 this.data = data;
			 depth = 1;
		 }
		 
		 void reverseAt(int depth){
			 reverseAtRecursively(this, depth);
		 }
		 
		 private void reverseAtRecursively(TreeNode node, int depth){
			 if(node != null){
				 if(node.depth%depth == 0){
					 TreeNode temp = node.left;
					 node.left = node.right;
					 node.right = temp;
				 }
				 reverseAtRecursively(node.left, depth);
				 reverseAtRecursively(node.right, depth);
			 }
		 }
		 
		 void print(){
			 printHelper(this);
			 System.out.println();
		 }
		 
		 private void printHelper(TreeNode node){
			 if(node != null){
				 printHelper(node.left);
				 System.out.print(node.data + " ");
				 printHelper(node.right);
			 }
		 }
	 }
}