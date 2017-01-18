package algorithm.dynamicprogamming;

public class MaximizeStockProfit {
	public static void main(String[] args) {
		int k = 3;
		int[] prices = {12, 14, 17, 10, 14, 13, 12, 15};
		System.out.println(profit(k, prices));
	}
	
	public static int profit(int k, int[] prices){
		int[][] dp = new int[k+1][prices.length];
		
		for(int i=1; i<=k; ++i){
			int max = Integer.MIN_VALUE;
			for(int j=1; j<prices.length; ++j){
				max = Math.max(dp[i-1][j-1]-prices[j-1], max);
				dp[i][j] = Math.max(dp[i][j-1], max+prices[j]);					
			}
		}
		return dp[k][prices.length-1];
	}
}