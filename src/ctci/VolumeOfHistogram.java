package ctci;

import java.util.Arrays;

public class VolumeOfHistogram {
	public static void main(String[] args) {
		int[] arr = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0};
		System.out.println(new VolumeOfHistogram().volume(arr));
	}
	
	private int volume(int[] arr) {
		int[] min = new int[arr.length];
		Arrays.fill(min, Integer.MAX_VALUE);
		int max = 0;
		for(int i=0; i<arr.length; ++i){
			if(max < arr[i]){
				max = arr[i];
			}
			min[i] = Math.min(min[i], max);
		}
		
		max = 0;
		int volume = 0;
		for(int i=arr.length-1; i>=0; --i){
			if(max < arr[i]){
				max = arr[i];
			}
			min[i] = Math.min(min[i], max);
			volume += min[i]<arr[i]? 0:min[i] - arr[i];
		}
		
		return volume;
	}
}