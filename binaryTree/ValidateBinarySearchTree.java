package com.leetcode.binaryTree;


public class ValidateBinarySearchTree {
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
	
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		
		return isValidBST(root, null, null);
    }
	
	public boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if(root == null)
			return true;
		
		if(min != null && root.val <= min)
			return false;

        if(max != null && root.val >= max)
			return false;
		
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
