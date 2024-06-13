package com.leetcode.linkedList;

public class LinkedListCycle {

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(-4);
		ListNode ln2 = new ListNode(0, ln1);
		ListNode ln3 = new ListNode(2, ln2);
		ListNode ln4 = new ListNode(3, ln3);
		ListNode list = new ListNode(4, ln4);
		
		ln1.next = ln3 ;
		System.out.println("Has Cycle : "+hasCycle(list));
		System.out.println("Length of cycle is : "+lengthOfCycle(list));

	}
	//Finding if there is a cycle PLUS count the no. of nodes in the cycle
	public static boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) { // TRUE when there is a cycle in the list.
				return true;
			}
		}
		
		return false;

    }
	//Finding if there is a cycle PLUS count the no. of nodes in the cycle
	public static int lengthOfCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		int length = 0;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) { // TRUE when there is a cycle in the list.
				// Counting the no. of nodes in the cycle
				fast = fast.next;
				length++;
				while(fast != slow) {
					length++;
					fast = fast.next;
				}
				return length;
			}
		}
		
		return length;

    }
	
	public static boolean hasCycleRec(ListNode head) {
		if(head==null || head.next==null || head.next.next==null) {
			return false;
		}
		return hasCycleFastNSlowPointer(head.next.next, head);
    }
	
	public static boolean hasCycleFastNSlowPointer(ListNode fastP, ListNode slowP) {
		
		if(fastP==null || fastP.next==null || fastP.next.next==null) {
			return false;
		}
		
		if(fastP == slowP) {
			return true;
		}
		
		return hasCycleFastNSlowPointer(fastP.next.next, slowP.next);
    }
	
	public static boolean hasCycleBruteForce(ListNode head) {
		ListNode temp = head;
		
		if(temp.next==null) {
			return false;
		}
		
		if(temp.next.val==Integer.MIN_VALUE) {
			return true;
		}
		
		temp.val = Integer.MIN_VALUE;
		
		return hasCycleBruteForce(temp.next);
    }

}
