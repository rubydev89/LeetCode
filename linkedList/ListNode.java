package com.leetcode.linkedList;

public class ListNode {
	int val;
	ListNode next;
	
	ListNode() {}
	
	ListNode(int val) { 
		this.val = val; 
	}
	
	ListNode(int val, ListNode next) { 
		this.val = val; 
		this.next = next; 
	}
	
	public static void display(ListNode temp) {
		while(temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println("END"); 
		
	}
}
