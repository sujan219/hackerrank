package algorithm.implementation;

import java.util.Scanner;

public class Encryption {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int row = (int)Math.ceil(Math.sqrt(str.length()));
		int column = (int)Math.ceil((double)str.length()/row);
		
		for(int i=0; i<row; ++i){
			for(int j=0; j<column; ++j){
				int index = i + j*row;
				if(index >= str.length()){
					break;
				}
				System.out.print(str.charAt(index));
			}
			System.out.print(" ");
		}
	}
}
