package algorithm.implementation;

import java.util.Scanner;

public class MatrixRotation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int r = scanner.nextInt();
		
		int[][] matrix = new int[m][n];
		for(int i=0; i<m; ++i){
			for(int j=0; j<n; ++j){
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		int noOfLines = Math.min(m, n)/2;
		int[][] lines = new int[noOfLines][];
		for(int i=0; i<noOfLines; ++i){
			lines[i] = new int[(m-i*2)*2 + (n-i*2)*2 - 4];
			int counter = 0;
			for(int j=i; j<n-i; ++j){
				lines[i][counter++] = matrix[i][j];
			}
			
			for(int k=i+1; k<m-i-1; ++k){
				lines[i][counter++] = matrix[k][n-i-1];
			}
			
			for(int j=n-i-1; j>=i; --j){
				lines[i][counter++] = matrix[m-i-1][j];
			}
			
			for(int k=m-i-2; k>i; --k){
				lines[i][counter++] = matrix[k][i];
			}
		}
		
		for(int i=0; i<lines.length; ++i){
			int arrLength = lines[i].length;
			int tempR = r%arrLength;
			int[] tempArr = new int[arrLength];
			for(int j=0; j<arrLength; ++j){
				tempArr[j] = lines[i][(j+tempR)%arrLength];
			}
			lines[i] = tempArr;
		}
		
		for(int i=0; i<lines.length; ++i){
			int counter = 0;
			int j=i, k=i;
			for(; j<(n-i); ++j){
				matrix[k][j] = lines[i][counter++];
			}
			j--;
			for(++k;k<m-i;++k){
				matrix[k][j] = lines[i][counter++];
			}
			--k;
			for(j--;j>=i;--j){
				matrix[k][j] = lines[i][counter++];
			}
			++j;
			for(k--;k>i;--k){
				matrix[k][j] = lines[i][counter++];
			}
		}
		
		for(int[] arr:matrix){
			for(int no:arr){
				System.out.print(no + " ");
			}
			System.out.println();
		}
	}
}
