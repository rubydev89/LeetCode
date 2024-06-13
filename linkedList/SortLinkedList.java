package com.leetcode.linkedList;

public class SortLinkedList {

	public static void main(String[] args) {
		//ListNode ln0 = new ListNode(-5);
		ListNode ln1 = new ListNode(-4);
		ListNode ln2 = new ListNode(0, ln1);
		ListNode ln3 = new ListNode(2, ln2);
		ListNode ln4 = new ListNode(3, ln3);
		ListNode list = new ListNode(4, ln4);
		
		ListNode.display(list);
		ListNode sortedList = SortList(list);
		ListNode.display(sortedList);

	}
	
	//SORT USING BUBBLE SORT
	private static ListNode SortList(ListNode head) {
		int length = lengthOfList(head);
		int noOfPass = length - 1;
		ListNode temp = head;
		
		for(int i=0; i<length; i++) {
			boolean swapped = false;
			for(int j=1; j<length-i; j++) {
				if(temp.val > temp.next.val) {
					ListNode prev = getPrev(temp, head);
					//System.out.println("-------> "+prev.val);
					if(prev == null) {
						ListNode t = temp;
						head = temp.next;
						t.next = head.next;
						head.next = t;
					}else {
						prev.next = temp.next;
						temp.next = prev.next.next;
						prev.next.next = temp;
					}
					swapped = true;
				}else
					temp = temp.next;
			}
			temp = head;
			if(!swapped) {
				break;
			}
		}
		return head;
	}

	private static ListNode getPrev(ListNode node, ListNode head) {
		ListNode temp = head.next;
		ListNode prev = head;
		if(prev == node) {
			return null;
		}
		while(temp!= null && temp != node) {
			temp = temp.next;
			prev = prev.next;
		}
		return prev;
	}

	private static int lengthOfList(ListNode head) {
		ListNode temp = head;
		int len = 0;
		while(temp != null) {
			len++;
			temp = temp.next;
		}
		//System.out.println("Length : "+len);
		return len;
	}

	//SORT USING MERGE SORT
	public static ListNode sortListMerge(ListNode head) {
		if(head==null || head.next == null) {
			return head;
		}
		
		ListNode mid = middleNode(head);
		ListNode rightList = mid.next;
		mid.next = null;
		
		ListNode left = sortListMerge(head);
		ListNode right = sortListMerge(rightList);
		
		return mergeList(left, right);
    }
	
	private static ListNode mergeList(ListNode left, ListNode right) {
		ListNode temp = new ListNode();
		ListNode head = temp;
		while(left!=null && right!=null) {
			if(left.val < right.val) {
				temp.next = left;
				left = left.next;
				temp = temp.next;
			}else {
				temp.next = right;
				right = right.next;
				temp = temp.next;
			}
		}
		
		if(left!=null) {
			temp.next = left;
		}
		
		if(right != null) {
			temp.next = right;
		}

		return head.next;
	}

	private static ListNode middleNode(ListNode head) {
		ListNode first = head;
		ListNode sec = null;
		
		while(first != null && first.next!= null){
			first = first.next.next;
			sec = (sec==null) ? head : sec.next;
		}
		//ListNode mid = sec.next;
		//sec.next = null;
		return sec;
	}

	
}
