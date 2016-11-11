package algorithm.dynamicprogamming;

import java.util.Scanner;

public class Billboards {
	private static long[][] cache;
	
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n+1];
        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solve(a, n, k));
    }
	
	
	
	
	public static void main1(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		cache = new long[n+1][k+1];
		
		int[] boards = new int[n];
		for(int i=0; i<n; ++i){
			boards[i] = scanner.nextInt();
			for(int j=0; j<k; ++j){
				cache[i][j] = -1;
			}
			cache[i][k] = -1;
		}
		
		//System.out.println(getMaxProfit(boards, k, 0, 0));
		System.out.println(solve(boards, n, k));
	}
	
	private static long getMaxProfit(int[] boards, int k, int currentIndex, int boardSum){
		if(currentIndex == boards.length){
			return 0;
		}
		
		long profit = 0;
		if(boardSum < k){
			if(cache[currentIndex+1][boardSum+1] == -1){
				cache[currentIndex+1][boardSum+1] = getMaxProfit(boards, k, currentIndex+1, boardSum+1);
			}
			profit = boards[currentIndex] + cache[currentIndex+1][boardSum+1];
		}
		
		if(cache[currentIndex+1][0] == -1){
			cache[currentIndex+1][0] = getMaxProfit(boards, k, currentIndex+1, 0);
		}
		profit = Math.max(cache[currentIndex+1][0], profit);
		
		return profit;
	}
	
	public static long solve(int[] a, int n, int k){
        long[] dp = new long[n+1];
        dp[0] = 0;
        for(int i = 1; i <= k; i++){
            dp[i] = dp[i-1] + a[i];
        }
        for(int i = k+1; i <= n; i++){
            dp[i] = dp[i-1];
            long sum = 0;
            for(int j = i-2; j >= i -k -1; j--){
                sum += a[j+2];
                dp[i] = Math.max(dp[i], sum + dp[j]);
            }
        }

        return dp[n];
    }
}
