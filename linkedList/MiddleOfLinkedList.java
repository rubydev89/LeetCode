package com.leetcode.linkedList;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		ListNode ln0 = new ListNode(-5);
		ListNode ln1 = new ListNode(-4);
		ListNode ln2 = new ListNode(0, ln1);
		ListNode ln3 = new ListNode(2, ln2);
		ListNode ln4 = new ListNode(3, ln3);
		ListNode list = new ListNode(4, ln4);
		
		ListNode.display(list);
		System.out.println(middleNode(list).val);

	}
	
	public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!= null && fast.next!=null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        return slow;
    }
	
	//BRUTE FORCE O(N)
	public static ListNode middleNodeBruteForce(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while(temp!=null) {
        	length++;
        	temp = temp.next;
        }
        
        int mid = length/2;
        temp = head;
        //ListNode middle = head;
        for(int i=1; i<=mid; i++) {
        	temp = temp.next;
        }
        
        return temp;
    }

}
