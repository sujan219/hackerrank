package algorithm.implementation;

import java.util.Scanner;

public class GridSearch {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int i=0; i<T; ++i){
			int R = scanner.nextInt();
			int C = scanner.nextInt();
			
			StringBuffer grid = new StringBuffer();
			for(int j=0; j<R; ++j){
				grid.append(scanner.next());
			}
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			
			String[] pattern = new String[r];
			for(int j=0; j<r; ++j){
				pattern[j] = scanner.next();
			}
			
			System.out.println(findPattern(grid.toString(), C, pattern)?"YES":"NO");
		}
	}
	
	private static boolean findPattern(String grid, int columnCount, String[] pattern){
		int patternLength = pattern[0].length();
		int indexDiff = columnCount - patternLength;
		int gridIndex = -1;
		do{
			gridIndex = grid.indexOf(pattern[0], gridIndex+1);
			if(gridIndex%columnCount+patternLength<=columnCount){
				for(int i=1; i<pattern.length; ++i){
					String test = grid.substring(gridIndex + (indexDiff + patternLength)*i, gridIndex + (indexDiff + patternLength)*i + patternLength);
					if(!test.equals(pattern[i])){
						break;
					}else if(i==pattern.length-1){
						return true;
					}
				}
			}
		}while(gridIndex != -1);
		return false;
	}
}
