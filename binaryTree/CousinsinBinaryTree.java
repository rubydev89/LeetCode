package com.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree {
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
	
	public boolean isCousins(TreeNode root, int x, int y) {
		//boolean isCousins = false;
		if(root == null) {
			return false;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depthOfX = 0;
		int depthOfY = 0;
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			for(int i=0; i<qSize; i++) {
				TreeNode node = queue.poll();
				if(node != null) {
					if(node.right != null && node.left!=null && ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x))) {
						return false;
					}
					
					if(node.val == x) {
						depthOfX = count;
					}else if(node.val == y) {
						depthOfY = count;
					}
				}
				
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
				
			}
			count++;
		}
		if(depthOfX > 0 && depthOfX==depthOfY)
			return true;
		
		return false;
    }
}
