package com.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	
	//Solution without Queue OR without using extra space
	public Node connect(Node root) {
        if(root == null) {
        	return root;
        }
        
        connect(root, null);
        
        return root;
    }
	
	private Node connect(Node node, Node rightSibling) {
        if(node == null) {
        	return node;
        }
        
        node.next = rightSibling;

        if(node.left != null && node.right != null){
            connect(node.left, node.right);
            Node currSibling = (rightSibling != null) ? rightSibling.left : null;
            connect(node.right, currSibling);
        }

        return node;
    }
	
	//Solution using the Queue
	public Node connectUsingQueue(Node root) {
        if(root == null) {
        	return root;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
        	int qSize = queue.size();
        	while(qSize != 0) {
        		Node curr = queue.poll();
        		if(curr != null) {
        			if(qSize > 1)
        				curr.right = queue.peek();
        			else {
        				curr.right = null;
        			}
        			if(curr.left != null)
        				queue.offer(curr.left);
        			if(curr.right != null)
        				queue.offer(curr.right);
        		}
        		qSize--;
        	}
        }
        
        return root;
    }
}
