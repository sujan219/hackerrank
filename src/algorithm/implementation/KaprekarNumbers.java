package algorithm.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class KaprekarNumbers {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		boolean isFound = false;
		for(int i=a; i<=b; ++i){
			if(isKaprekar(i)){
				isFound = true;
				System.out.print(i + " ");
			}
		}
		
		if(!isFound){
			System.out.println("INVALID RANGE");
		}
	}
	
	private static boolean isKaprekar(int no){
		BigInteger square = new BigInteger(no+"");
		square = square.multiply(square);
        if(square.compareTo(new BigInteger("10")) == -1){
			return square.intValue() == no;
		}
		
		String squareString = square.toString();
		int length = squareString.length();
		int a = Integer.parseInt(squareString.substring(0, (int)Math.ceil(length/2)));
		int b = Integer.parseInt(squareString.substring((int)Math.ceil(length/2), length));
		return a+b == no;
	}
}
