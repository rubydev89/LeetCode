package com.leetcode.linkedList;

/*
 * PROGRAM:
 * Given the head of a singly linked list and two integers left and right 
 * 		where left <= right, 
 * 		reverse the nodes of the list from position left to position right, 
 * 		and return the reversed list.
 * */
public class ReverseLinkedListInPart {

	public static void main(String[] args) {
		ListNode ln0 = new ListNode(-5);
		ListNode ln1 = new ListNode(5);
		ListNode ln2 = new ListNode(4, ln1);
		ListNode ln3 = new ListNode(3, ln2);
		ListNode ln4 = new ListNode(2, ln3);
		ListNode list = new ListNode(1, ln4);
		
		ListNode.display(list);
		list = reverseBetween(list, 1, 2);
		ListNode.display(list);

	}
	
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		if(left == right) {
			return head;
		}
		
        ListNode temp = head;
        ListNode prevL = null;
        
        //Finding the LeftNode and previous node to the Left Node
        for(int i=1; i<left; i++) {
        	prevL = temp;
        	temp = temp.next;
        }
        
        
		/*
		 * //Finding the LeftNode and previous node to the Left Node while(temp.val !=
		 * left) { prevL = temp; temp = temp.next; }
		 */        
        ListNode leftNode = temp;
        ListNode l = temp;
        temp = temp.next;
		
        for(int i=left+1; i<right; i++) {
			ListNode t = temp;
			if(temp != null)
				temp = temp.next;
        	t.next = l;
        	l = t;
		}
    
        leftNode.next = temp.next;
        temp.next = l;

		//If the left Node is not the 1st node in the list
        if(prevL!=null) {
        	prevL.next = temp;
        	return head;
        }
        // If the left node is the 1st node in the list
        return temp;
        
    }

}
