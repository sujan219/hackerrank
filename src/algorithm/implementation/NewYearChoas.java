package algorithm.implementation;

import java.util.Scanner;

public class NewYearChoas {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; ++i){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int j=0; j<n; ++j){
                arr[j] = scanner.nextInt();
            }
            
            int j=0;
            int mainCount = 0;
            
            for(; j<n; ++j){
                if(arr[j] > 1){
                	int count = 0;
                   	for(int k=j+1; k<n&&count<3&& k<j+5; ++k){
                        if(arr[j]>arr[k]){
                            ++count;
                        }
                   	}
                    
                    mainCount += count;
                    if(count>2){
                        break;
                    }
                }
            }
            
            if(j<n){
                System.out.println("Too chaotic");
            }else{
                System.out.println(mainCount);
            }
        }
	}
}