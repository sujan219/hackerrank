package algorithm.dynamicprogamming;

public class LongestPalindromeSubsequence {
	public static void main(String[] args) {
		System.out.println(solve("agdbda"));
	}
	
	public static String solve(String word){
		char[] arr = word.toCharArray();
		int n = arr.length;
		int dp[][] = new int[n][n];
		
		//every single character is palindrome
		for(int i=0; i<n; ++i){
			dp[i][i] = 1;
		}
		
		for(int gap=1; gap<n; ++gap){
			for(int i=0; i+gap<n; ++i){
				if(arr[i] == arr[i+gap]){
					if(gap == 1){
						dp[i][i+gap] = 2;
					}else{
						dp[i][i+gap] = 2 + dp[i+1][i-1+gap];
					}
				}else{
					dp[i][i+gap] = Math.max(dp[i][i+gap-1], dp[i+1][i+gap]);
				}
			}
		}
		
		return findString(dp, arr);
	}

	private static String findString(int[][] dp, char[] arr) {
		String str = "";
		String str2 = "";
		int i=0, j=arr.length-1;
		while(dp[i][j] > 0){
			int c = dp[i][j];
			int l = dp[i][j-1];
			int b = dp[i+1][j];
			
			if(c == l){
				j--;
			}else if(c == b){
				i++;
			}else{
				str += arr[j];
				if(dp[i][j] != 1){
					str2 = arr[j]+str2;
				}
				i++;
				j--;
			}
		}
		return str+str2;
	}
}