package algorithm.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorial {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println(factorial(scanner.nextInt()));
	}
	
	private static BigInteger factorial(int no){
		BigInteger fact = new BigInteger("1");
		for(int i=2; i<=no; ++i){
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}
}
