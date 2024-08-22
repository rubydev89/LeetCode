package com.leetcode.binaryTree;


public class DiameterofBinaryTree {
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
	
	private int diameter = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		calculateDiameterOfBinaryTree(root);
		return diameter-1;
    }
	
	private int calculateDiameterOfBinaryTree(TreeNode node) {
		if(node == null)
			return 0;
		
		int heightLeft = calculateDiameterOfBinaryTree(node.left);
		
		int heightRight = calculateDiameterOfBinaryTree(node.right);
		
		int maxDiametere = heightLeft + heightRight + 1;
		diameter = Math.max(maxDiametere, diameter);
		
		return Math.max(heightLeft , heightRight) + 1;
    }
}
