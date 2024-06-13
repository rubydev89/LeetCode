package com.leetcode.linkedList;

/*
 * Given the head of a linked list, 
 * 		rotate the list to the right by k places.
 * 
 * */
public class RotateList {

	public static void main(String[] args) {

		ListNode ln10 = new ListNode(10);
		
		ListNode ln9 = new ListNode(9, ln10);
		
		ListNode ln8 = new ListNode(8 , ln9);
		ListNode ln7 = new ListNode(7 , ln8);
		ListNode ln6 = new ListNode(6 , ln7);
		ListNode ln5 = new ListNode(5 );
		
		ListNode ln4 = new ListNode(4 , ln5);
		ListNode ln3 = new ListNode(3, ln4);
		ListNode ln2 = new ListNode(2);
		ListNode list1 = new ListNode(1,ln2);
		
		ListNode.display(list1);
		
		ListNode newHead = rotateRight(list1, 4);
		
		ListNode.display(newHead);

	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		if(k <= 0 || head == null || head.next == null) {
			return head;
		}
		
		int lengthOfList = length(head, k);
		int rotateCount = k % lengthOfList;
		
		if(rotateCount == 0)
			return head;
		
		int skipCount = lengthOfList - rotateCount;
		
        ListNode curr = head;
        ListNode prev = null;
        
        
        for(int i=1; i<=skipCount; i++) {
        	prev = curr;
        	curr = curr.next;
        }
        
        head = curr;
        prev.next = null;
		
        return head;
        	
    }

	private static int length(ListNode head, int k) {
		ListNode temp = head;
		ListNode last = null;
		int length = 0;
		while(temp!=null) {
			last = temp;
			temp = temp.next;
			length++;
		}
		if(k%length != 0)
			last.next = head;
		return length;
	}

}
