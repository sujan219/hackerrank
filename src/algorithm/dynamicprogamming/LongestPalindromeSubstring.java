package algorithm.dynamicprogamming;

public class LongestPalindromeSubstring {
	public static void main(String[] args) {
		String word = "agdcda";
		System.out.println(solve(word));
	}
	
	private static String solve(String word){
		int a=0,b=0,c=0;
		for(int i=0; i<word.length()-1; ++i){
			int temp = helper(word, i, i);
			if(temp>c){
				a = i;
				b = i;
				c = temp;
			}
			
			if((temp = helper(word, i, i+1))>c){
				a = i;
				b = i+1;
				c = temp;
			}
		}
		return word.substring(a-c, b+c+1);
	}
	
	private static int helper(String word, int i, int j){
		int counter = 0;
		while(i-counter>=0 && j+counter<word.length()){
			if(word.charAt(i-counter) == word.charAt(j+counter)){
				++counter;
			}else{
				break;
			}
		}
		return counter-1;
	}
}
