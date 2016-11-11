package algorithm.dynamicprogamming;

import java.util.Scanner;

public class Candies {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];
        for(int i=0; i<n; ++i){
            arr[i] = scanner.nextInt();
        }
        
        dp[0] = 1;
        for(int i=1; i<n; ++i){
            if(arr[i]>arr[i-1]){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = 1;
                if(dp[i-1] == 1 && arr[i] != arr[i-1]){
                    for(int j=i-1; j>=0 && dp[j]==dp[j+1]; --j){
                        dp[j]++;
                    }
                }
            }
        }
        
        int sum=0;
        for(int no:dp){
            sum += no;
        }
        System.out.println(sum);
    }
}
