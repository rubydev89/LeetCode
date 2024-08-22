package com.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	private class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
	public List<List<Integer>> zigZagLevelOrderDeque(TreeNode root){
		List<List<Integer>> traversedList = new ArrayList<>();
		
		Deque<TreeNode> q = new LinkedList<>();
		q.offerFirst(root);
		boolean reverse = false;
		
		while(!q.isEmpty()) {
			List<Integer> currTraversedList = new ArrayList();
			int size = q.size();
			
			//Stack<TreeNode> stack = new Stack<>();
			for(int i=0; i<size; i++) {
				TreeNode currNode = null; //q.poll();
				if(reverse) {
					currNode = q.pollLast();
                    if(currNode != null){
                        currTraversedList.add(currNode.val);
                        if(currNode.right != null)
                            q.offerFirst(currNode.right);
                        if(currNode.left != null)
                            q.offerFirst(currNode.left);
                    }
				}else {
					currNode = q.pollFirst();
					if(currNode != null){
					    currTraversedList.add(currNode.val);
                        if(currNode.left != null)
                            q.offerLast(currNode.left);
                        if(currNode.right != null)
                            q.offerLast(currNode.right);
                    }
				}
				
			}
			
			reverse = !reverse;
			if(!currTraversedList.isEmpty())
				traversedList.add(currTraversedList);
		}
		
		
		return traversedList;
    
	}
	

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> traversedList = new ArrayList<>();
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		boolean leftToRight = false;
		
		while(!q.isEmpty()) {
			List<Integer> currTraversedList = new ArrayList();
			int size = q.size();
			Stack<TreeNode> stack = new Stack<>();
			for(int i=0; i<size; i++) {
				TreeNode currNode = q.poll();
				if(currNode != null) {
					if(leftToRight) {
						stack.add(currNode);
					}else {
						currTraversedList.add(currNode.val);
					}
					
					if(currNode.left != null)
						q.offer(currNode.left);
					if(currNode.right != null)
						q.offer(currNode.right);
				}
			}
			
			leftToRight = !leftToRight;
			
			if(!stack.isEmpty()) {
				currTraversedList.add(stack.pop().val);
			}
			if(stack.isEmpty() && !currTraversedList.isEmpty())
				traversedList.add(currTraversedList);
		}
		
		
		return traversedList;
    }
}
