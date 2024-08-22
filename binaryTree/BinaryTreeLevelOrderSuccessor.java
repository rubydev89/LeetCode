package com.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderSuccessor {
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
	
	 public TreeNode levelOrderSuccessor(TreeNode root, int nodeValue) {
		 TreeNode successor = null;
		 
		 if(root == null || (root.left == null && root.right == null)) {
			 return successor;
		 }
		 
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.add(root);
		 
		 while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			 if(node.left != null) {
				 queue.add(node.left);
			 }
			 if(node.right != null) {
				 queue.add(node.right);
			 }
			 if(node.val == nodeValue)
				 return queue.poll();
		 }
		 
		 return successor;
      
  }
}
