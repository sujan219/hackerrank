package algorithm.implementation;

import java.util.Scanner;

public class ACMICPCTeam {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		boolean[][] data = new boolean[n][m];
		for(int i=0; i<n; ++i){
			String[] tempArr = scanner.next().split("");
            for(int j=0; j<tempArr.length; ++j){
                data[i][j] = tempArr[j].equals("1");
            }
		}
		
		int max = 0;
		int count = 0;
		for(int i=0; i<n; ++i){
			for(int j=i+1; j<n; ++j){
                int tempCount = 0;
				for(int k=0; k<m; ++k){
                    if(data[i][k]||data[j][k]){
                    	++tempCount;
                    }
                }
                
				if(tempCount>max){
					max = tempCount;
					count = 1;
				}else if(tempCount == max){
					count++;
				}
			}
		}
		System.out.println(max + "\n" + count);
	}
}
