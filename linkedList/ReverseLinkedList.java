package com.leetcode.linkedList;


public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode ln0 = new ListNode(-5);
		ListNode ln1 = new ListNode(-4);
		ListNode ln2 = new ListNode(0, ln1);
		ListNode ln3 = new ListNode(2, ln2);
		ListNode ln4 = new ListNode(3, ln3);
		ListNode list = new ListNode(4, ln4);
		
		ListNode.display(list);
		ListNode revHead = reverseList(list);
		
		ListNode temp = revHead;
		ListNode.display(temp);

	}
	
	public static ListNode reverseList(ListNode head) {
		ListNode revHead = null;
		
		while(head != null) {
			ListNode temp = head;
			head = head.next;
			temp.next = revHead;
			revHead = temp;
		}
		return revHead;
    }

}
