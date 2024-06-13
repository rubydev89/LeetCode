package com.leetcode.linkedList;


public class RemoveDuplicateFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode ln1 = new ListNode(3);
		ListNode ln2 = new ListNode(3, ln1);
		ListNode ln3 = new ListNode(2, ln2);
		ListNode ln4 = new ListNode(2, ln3);
		ListNode ln5 = new ListNode(1, ln4);
		
		ListNode head = ln5;
		head.display(head);
		//deleteDuplicatesRecursive(head);
		deleteDuplicates(head);
		head.display(head);

	}
	
	public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        
        while(temp != null) {
        	if(temp.next!=null && temp.val == temp.next.val) {
        		ListNode n = temp.next;
        		temp.next = temp.next.next;
        		n.next = null;
        	}else {
        		temp = temp.next;
        	}
        }
        
        return head;
    }

	public static ListNode deleteDuplicatesRecursive(ListNode head) {
        return deleteDuplicatesRecursive(head, head);
    }
	
	private static ListNode deleteDuplicatesRecursive(ListNode currentNode, ListNode head) {
		if((currentNode!=null && currentNode.next==null) || head==null) {
        	return head;
        }
        
        if(currentNode.val == currentNode.next.val) {
        	ListNode temp = currentNode.next;
        	currentNode.next = temp.next;
        	temp.next = null;
        	return deleteDuplicatesRecursive(currentNode, head);
        }
        
        return deleteDuplicatesRecursive(currentNode.next, head);
        
    }

}
