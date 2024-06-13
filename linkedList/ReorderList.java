package com.leetcode.linkedList;

/*
 * You are given the head of a singly linked-list. The list can be represented as:
 * 			L0 → L1 → … → Ln - 1 → Ln
 * 		Reorder the list to be on the following form:
 * 			L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 	
 * You may not modify the values in the list's nodes. 
 * Only nodes themselves may be changed.
 * 
 * */
public class ReorderList {

	public static void main(String[] args) {
		ListNode ln0 = new ListNode(-5);
		ListNode ln1 = new ListNode(5);
		ListNode ln2 = new ListNode(4 , ln1);
		ListNode ln3 = new ListNode(3, ln2);
		ListNode ln4 = new ListNode(2, ln3);
		ListNode list1 = new ListNode(1);
		
		ListNode.display(list1);
		
		reorderList(list1);
		
		ListNode.display(list1);

	}
	
	public static void reorderList(ListNode head) {
		if(head==null || head.next==null) {
			return;
		}
		
		//Find the mid node of the list
        ListNode mid = centerNode(head);
        
        //Reverse the 2nd half of the List
        ListNode revHead = reverse(mid);
        
        //Merge the list in order of the question
        mergeLists(head, revHead);
	}

	private static void mergeLists(ListNode head, ListNode revHead) {
		ListNode temp = head;
		ListNode tail = null;
		
		while(temp!=null && revHead!=null) {
			ListNode next = temp.next;
			ListNode revNext = revHead.next;
			
			temp.next = revHead;
			if(next == null) {
				tail = revHead;
			}
			revHead.next = next;
			revHead = revNext;
			temp = next;
		}
		if(temp==null && revHead!=null) {
			tail.next = revHead;
		}
		
	}

	private static ListNode reverse(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode newEnd = head;
		ListNode prev = head;
		ListNode temp = head.next;
		
		while(temp!=null) {
			ListNode next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		newEnd.next = null;
		
		return prev;
	}

	private static ListNode centerNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		while(fast!=null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = null;
		return slow;
	}

}
