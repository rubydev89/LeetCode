package com.leetcode.linkedList;

public class MergeTwoSortedList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode ln1 = new ListNode(7);
		ListNode ln2 = new ListNode(4, ln1);
		ListNode ln3 = new ListNode(4, ln2);
		ListNode ln4 = new ListNode(2, ln3);
		ListNode ln5 = new ListNode(1, ln4);
		
		ListNode ln11 = new ListNode(5);
		ListNode ln21 = new ListNode(5, ln11);
		ListNode ln31 = new ListNode(4, ln21);
		ListNode ln41 = new ListNode(2, ln31);
		//ListNode ln51 = new ListNode(1, ln41);
		
		ListNode.display(ln5);
		ListNode.display(ln41);
		
		ListNode head = mergeTwoLists(ln5, ln41 );
		
		//deleteDuplicatesRecursive(head);
		//deleteDuplicates(head);
		ListNode.display(head);

	}
	
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode head = new ListNode();
		ListNode temp = head;
		
		if(list1 == null) {
			return list2;
		}else if(list2 == null) {
			return list1;
		}
		
		while(list1!=null && list2!=null) {
			if(list1.val < list2.val) {
				temp.next = list1;
				list1 = list1.next;
				temp = temp.next;
			
			}else if(list2.val < list1.val) {
				temp.next = list2;
				list2 = list2.next;
				temp = temp.next;
			
			}else { 
				temp.next = list1; 
				list1 = list1.next; 
				temp = temp.next; 
				temp.next = list2; 
				list2 = list2.next; 
				temp = temp.next; 
			} 
		}
		
		if(list1!=null) {
			temp.next = list1;
		}
		
		if(list2!=null) {
			temp.next = list2;
		}
		
		return head.next;
	}

}
