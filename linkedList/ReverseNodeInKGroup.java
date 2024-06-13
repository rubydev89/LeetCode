package com.leetcode.linkedList;

/*
 * Given the head of a linked list, reverse the nodes of the list k at a time, 
 * 		and return the modified list.
 * 		k is a positive integer and is less than or equal to the length of the linked list. 
 * 		If the number of nodes is not a multiple of k then 
 * 			left-out nodes, in the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * */
public class ReverseNodeInKGroup {

	public static void main(String[] args) {
		ListNode ln10 = new ListNode(10);
		
		ListNode ln9 = new ListNode(9, ln10);
		
		ListNode ln8 = new ListNode(8 , ln9);
		ListNode ln7 = new ListNode(7 , ln8);
		ListNode ln6 = new ListNode(6 , ln7);
		ListNode ln5 = new ListNode(5 , ln6);
		
		ListNode ln4 = new ListNode(4 , ln5);
		ListNode ln3 = new ListNode(3, ln4);
		ListNode ln2 = new ListNode(2, ln3);
		ListNode list1 = new ListNode(1,ln2);
		
		ListNode.display(list1);
		
		ListNode h = reverseAlternativeKGroup(list1, 3);
		
		ListNode.display(h);
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)
        	return head;
        
        int length = length(head);

        //Find the no. of times we need to reverse the sub nodes
        int counter = length/k;
        
        ListNode previous = null;
		ListNode temp = head;
		ListNode next = null;
		
        for(int i=1; i<=counter; i++) {
        	
        	ListNode revHead = reverseKNode(temp, k);
        	//Doing this after reverse as this will give you the first node after the
        	//reversal of the current nodes.
        	next = temp.next;
        	
        	if(previous == null) {
        		head = revHead;
        		previous = temp;
        	}else {
        		previous.next = revHead;
        	}

        	//Previously reversed sublist should point to 
        	// new head of the current reversed sub list
        	previous = temp;
        	temp = next;

        }
        
        return head;
    }
	
	private static ListNode reverseKNode(ListNode head, int k) {
		ListNode start = head;
		ListNode prev = head;
		ListNode temp = prev.next;
		for(int i=1;i<k; i++) {
			ListNode next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		start.next = temp;
		
		return prev;
	}
	
	// GeeksForGeek
	private static ListNode reverseAlternativeKGroup(ListNode head, int k) {
		ListNode tempHead = null;
		ListNode prev = null;
		ListNode current = head;
		ListNode newEnd = current; 
		
		while(current != null) {	
			int counter = k;
			while(current!= null && counter > 0) {
				ListNode next = current.next;
				
				current.next = prev; 
				
				prev = current;
				current = next;
				counter--;
			}
			
			newEnd.next = current;
			
			if(tempHead == null) {
				head = prev;
				tempHead = prev;
			}else {
				tempHead.next = prev;
			}
			
			for(int i=1; current!=null && i<=k; i++) {
				prev = current;
				current = current.next;
			}
			tempHead = prev;
			newEnd = current;
			
		}
		
		
		return head;
	}

	private static int length(ListNode head) {
		int length = 0;
		ListNode slow = head;
		while(slow != null) {
			length++;
			slow = slow.next;
		}
		return length;
		
	}

}
