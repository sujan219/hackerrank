package ctci;

import java.util.Arrays;

public class ShortestSupersequence {
	public static void main(String[] args){
		int[] values = {1, 5, 9};
		int[] data = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
		System.out.println(solve(values, data).toString());
	}
	
	public static Pair solve(int[] v, int[] d){
		int[][] ranges = getRanges(v, d);
		
		//compute the actual range
		int[] finalRange = new int[d.length];
		for(int i=0; i<finalRange.length; ++i){
			int max = -1;
			for(int j=0; j<v.length; ++j){
				if(ranges[j][i] == -1){
					max = -1;
					break;
				}
				max = Math.max(ranges[j][i], max);
			}
			finalRange[i] = max == -1 ? -1 : max-i;
		}
		
		int min = finalRange[0];
		int startInd = 0;
		for(int i=1; i<finalRange.length; ++i){
			if(min>finalRange[i] && finalRange[i] != -1){
				min = finalRange[i];
				startInd = i;
			}
		}
		return new Pair(startInd, startInd+min);
	}
	
	private static int[][] getRanges(int[] v, int[] d){
		int[][] ranges = new int[v.length][d.length];
		for(int[] arr:ranges){
			Arrays.fill(arr, -1);
		}
		int dLen = d.length;
		for(int i=0;i<v.length; ++i){
			if(d[dLen-1] == v[i]){
				ranges[i][dLen-1] = dLen-1;
			}
			for(int j=ranges[i].length-2; j>=0; --j){
				if(d[j] == v[i]){
					ranges[i][j] = j;
				}else{
					ranges[i][j] = ranges[i][j+1];
				}
			}
		}
		return ranges;
	}
	
	private static class Pair{
		int a, b;
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
		
		@Override
		public String toString() {
			return a + " " + b;
		}
	}
}