package ctci;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {
	public static void main(String[] args) {
		int[] numbers = {1, 5, 2, 9, 7, 8, 6, 3, 2, 1, 5};
		double[] medians = new ContinuousMedian().getMedian(numbers);
		System.out.println(Arrays.toString(medians));
	}
	
	
	private double[] getMedian(int[] numbers) {
		PriorityQueue<Integer> minHeap, maxHeap;
		minHeap = getMinHeap();
		maxHeap = getMaxHeap();
		
		double[] medians = new double[numbers.length];
		for(int i=0; i<numbers.length; ++i){
			if(minHeap.isEmpty() || numbers[i]<minHeap.peek()){
				maxHeap.add(numbers[i]);
			}else{
				minHeap.add(numbers[i]);
			}
			
			if(maxHeap.size()>minHeap.size()+1){
				minHeap.add(maxHeap.remove());
			}else if(minHeap.size()>maxHeap.size()){
				maxHeap.add(minHeap.remove());
			}
			
			if(maxHeap.size()==minHeap.size()){
				medians[i] = (double)(maxHeap.peek()+minHeap.peek())/2;
			}else{
				medians[i] = maxHeap.peek();
			}
		}
		return medians;
	}
	
	private PriorityQueue<Integer> getMinHeap(){
		return new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
	}
	
	private PriorityQueue<Integer> getMaxHeap(){
		return new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
	}
}