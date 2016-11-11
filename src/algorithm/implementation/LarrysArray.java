package algorithm.implementation;

import java.util.Scanner;

public class LarrysArray {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i=0; i<t; ++i){
			int n = scanner.nextInt();
			int[] arr = new int[n];
			
			for(int j=0; j<n; ++j){
				arr[j] = scanner.nextInt();
			}
			
			int inversions = 0;
			
			for(int j=0; j<n; ++j){
				for(int k=j+1; k<n; ++k){
					if(arr[j]>arr[k]){
						++inversions;
					}
				}
			}
			
			if(inversions%2 == 0){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}