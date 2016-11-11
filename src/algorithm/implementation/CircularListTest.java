package algorithm.implementation;

public class CircularListTest {

	public static void main(String[] args){
		
		int arr[] = {-1,-7,7,-4,19,6,-9,-5,-2,-5};
		ListNode node = null;
		for(int i=arr.length-1; i>=0; --i){
			ListNode nextNode = node;
			node = new ListNode(arr[i]);
			node.next = nextNode;
		}
		
		System.out.println(findCircularPoint(node).val);
	}
 
	private static ListNode findCircularPoint(ListNode headNode){
		ListNode priorityNode = headNode;
		while(priorityNode != null){
			ListNode priorityNextNode = priorityNode.next;
			ListNode innerTempNode = headNode;
			while(innerTempNode != null && priorityNextNode != null){
				if(innerTempNode.val == priorityNextNode.val){
					return innerTempNode;
				}else if(innerTempNode.val == priorityNode.val){
					break;
				}
				innerTempNode = innerTempNode.next;
			}
			priorityNode = priorityNextNode;
		}
		return null;
	}
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
