package algorithm.implementation;

import java.util.Scanner;

public class ManasaAndStones {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; ++i){
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            if(a > b){
                a = a+b;
                b = a-b;
                a = a-b;
            }
            
            for(int j=0; j<n; ++j){
                System.out.print((b*j + a*(n-j-1)) + " ");
            }
            System.out.println();
        }
    }
}
