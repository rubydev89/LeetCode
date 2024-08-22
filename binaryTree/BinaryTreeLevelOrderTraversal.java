package com.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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
	
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> traversedList = new ArrayList();
		if(root == null) {
			return traversedList;
		}
		
		Queue<TreeNode> childQueue = new LinkedList<>();
		childQueue.add(root);
		
		while(!childQueue.isEmpty()) {
			int queueSize = childQueue.size();
			List<Integer> traversedListInThisIteration = new ArrayList<>();
			for(int i=0;i<queueSize; i++) {
				TreeNode curr = childQueue.poll();
				if(curr != null) {
					traversedListInThisIteration.add(curr.val);
					childQueue.add(curr.left);
					childQueue.add(curr.right);
				}
			}
			if(!traversedListInThisIteration.isEmpty())
				traversedList.add(traversedListInThisIteration);
		}
		return traversedList;
	}
}
