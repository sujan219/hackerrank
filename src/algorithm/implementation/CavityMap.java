package algorithm.implementation;

import java.util.Scanner;

public class CavityMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] grid = new int[n][n];
        int[][] newGrid = new int[n][n];
        for(int i=0; i<n; ++i){
            String[] tempArr = scanner.next().split("");
            for(int j=0; j<tempArr.length; ++j){
                newGrid[i][j] = grid[i][j] = Integer.parseInt(tempArr[j]);
            }
        }
        
        for(int i=1; i<n-1; ++i){
            for(int j=1; j<n-1; ++j){
                if(grid[i-1][j] < grid[i][j] && grid[i+1][j] < grid[i][j] && grid[i][j-1] < grid[i][j] && grid[i][j+1] < grid[i][j]){
                    newGrid[i][j] = -1;
                }
            }
        }
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(newGrid[i][j] == -1){
                    System.out.print("X");
                }else{
                    System.out.print(newGrid[i][j]);
                }
            }
            System.out.println();
        }
    }
}
