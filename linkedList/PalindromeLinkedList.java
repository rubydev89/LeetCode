package com.leetcode.linkedList;

/*
 * Given the head of a singly linked list, 
 * 		return true if it is a palindrome 
 * 		or false otherwise.
 * */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode ln0 = new ListNode(-5);
		ListNode ln1 = new ListNode(5);
		ListNode ln2 = new ListNode(2, ln1);
		ListNode ln3 = new ListNode(3, ln2);
		ListNode ln4 = new ListNode(2, ln3);
		ListNode list = new ListNode(1, ln4);
		
		ListNode.display(list);
		System.out.println("Is Palindrome : "+ isPalindrome(list));

	}
	
	public static boolean isPalindrome(ListNode head) {
		if(head.next == null){
            return true;
        }
		
		// without using fast and slow method
		int mid = size(head) / 2;
        
        ListNode temp = head;
        ListNode prevNonRev = null;

        while(mid > 0) {
        	prevNonRev = temp;
        	temp = temp.next;
        	mid--;
        }
        
        ListNode revHead = reverse(temp);
        
        boolean isPalindrome =  compareForPalindrome(head, revHead);
        
        prevNonRev.next = reverse(revHead);
        
        return isPalindrome;
    }

	private  static boolean compareForPalindrome(ListNode head, ListNode revHead) {
		ListNode temp = head;
		ListNode tempRev = revHead;
		while(temp!=null && tempRev!=null) {
			if(temp.val != tempRev.val)
				return false;
			temp = temp.next;
			tempRev = tempRev.next;
		}
		return true;
	}

	private  static ListNode reverse(ListNode head) {
		if(head.next == null) {
			return head;
		}
		
		ListNode temp = head.next;
		ListNode prev = head;
		ListNode newEnd = prev;
		while(temp != null) {
			ListNode next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		newEnd.next = null;
		return prev;
	}

	private  static int size(ListNode head) {
		ListNode temp = head;
		int len = 0;
		while(temp != null) {
			len++;
			temp = temp.next;
		}
		
		System.out.println("Length of the Linked List is : "+len);
		return len;
	}
	
	private static ListNode centerNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast!= null && fast.next!= null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}

}
