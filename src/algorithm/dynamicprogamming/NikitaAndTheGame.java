package algorithm.dynamicprogamming;

import java.util.Scanner;

public class NikitaAndTheGame {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; ++i){
            int no = scanner.nextInt();
            int[] arr = new int[no];
            int[] dp = new int[no+1];
            dp[0] = 0;
            for(int j=0; j<no; ++j){
                arr[j] = scanner.nextInt();
                dp[j+1] = dp[j] + arr[j];
            }
            
            int max = dp[no];
            System.out.println(find(dp,max,max/2));
        }
    }
    
    private static int find(int[] dp, int no, int decre){
        if(decre>0 && no%2 == 0 && no<=dp[dp.length-1]){
            int l=0,r=dp.length-1;
            while(r>=l){
                int m=(r+l)/2;
                if(no<dp[m]){
                    r = m-1;
                }else if(no>dp[m]){
                    l = m+1;
                }else{
                    return 1+Math.max(find(dp, no + decre, decre/2), find(dp, no - decre, decre/2));
                }
            }
        }
        return 0;
    }
}
