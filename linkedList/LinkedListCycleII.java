package com.leetcode.linkedList;

public class LinkedListCycleII {
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(-4);
		ListNode ln2 = new ListNode(0, ln1);
		ListNode ln3 = new ListNode(2, ln2);
		ListNode ln4 = new ListNode(3, ln3);
		ListNode list = new ListNode(4, ln4);
		
		ln1.next = ln4 ;
		
		System.out.println("Cycle starts at "+detectCycle(list).val);
	}
	
	public static ListNode detectCycle(ListNode head) {
    	ListNode first = head;
    	ListNode second = head;
    	int lengthOfCycle = lengthOfCycle(head);
    	if(lengthOfCycle > 0) {
        	for(int i=0; i< lengthOfCycle; i++) {
        		first = first.next;
        	}
        	while(first!=second) {
        		first = first.next;
        		second = second.next;
        	}
            return first;
        }
        return null;
    }

	private static int lengthOfCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		int length = 0;
		
		do {
			if(fast==null || fast.next==null) {
				return length;
			}
			fast = fast.next.next;
			slow = slow.next;
		}while(fast != slow);
		
		do {
			slow = slow.next;
			length++;
		}while(fast != slow);
		
		return length;
	}
}
