package algorithm.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheTimeInWords {
	private static Map<Integer, String> timeMap;
	public static void main(String[] args){
		initTimeMap();
		Scanner scanner = new Scanner(System.in);
		int h = scanner.nextInt();
		int m = scanner.nextInt();
		
		String str = "";
		if(m == 0){
			str = timeMap.get(h) + " o' clock";
		}else if(m == 30){
			str = "half past " + timeMap.get(h);
		}else if(m<30 || h==12){
			str = timeMap.get(m) + " minutes past " + timeMap.get(h);
		}else{
			str = timeMap.get(60-m) + " minutes to " + timeMap.get(h+1);
		}
		System.out.println(str);
	}
	
	private static void initTimeMap(){
		timeMap = new HashMap<Integer, String>();
		timeMap.put(1, "one");
		timeMap.put(2, "two");
		timeMap.put(3, "three");
		timeMap.put(4, "four");
		timeMap.put(5, "five");
		timeMap.put(6, "six");
		timeMap.put(7, "seven");
		timeMap.put(8, "eight");
		timeMap.put(9, "nine");
		timeMap.put(10, "ten");
		timeMap.put(11, "eleven");
		timeMap.put(12, "twelve");
		timeMap.put(13, "thirteen");
		timeMap.put(14, "fourteen");
		timeMap.put(15, "fifteen");
		timeMap.put(16, "sixteen");
		timeMap.put(17, "seventeen");
		timeMap.put(18, "eighteen");
		timeMap.put(19, "ninteen");
		
		String[] tens = {"twenty", "thirty", "fourty", "fifty"};
		for(int i=0; i<tens.length; ++i){
			timeMap.put((i+2)*10, tens[i]);
			for(int j=0; j<9; ++j){
				timeMap.put((i+2)*10 + j+1, tens[i] + " " + timeMap.get(j+1));
			}
		}
	}
}
