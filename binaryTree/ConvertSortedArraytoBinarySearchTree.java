package com.leetcode.binaryTree;

import java.util.Arrays;


public class ConvertSortedArraytoBinarySearchTree {
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
	
    private TreeNode root = null;

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
			return null;
		else if(nums.length == 1) {
			insert(nums[0], root);
		}else{
			int mid = nums.length/2;
			insert(nums[mid], root);
			sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
			sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
        }
		return root;
    }
	
	private void insert(int val, TreeNode node) {
		if(node == null) {
			node = new TreeNode(val);
            root = node;
			return;
		}
		if(val < node.val) {
			if(node.left == null) {
				TreeNode left = new TreeNode(val);
				node.left = left;
			}else
				insert(val, node.left); 
		}else {
			if(node.right == null) {
				TreeNode right = new TreeNode(val);
				node.right = right;
			}else
				insert(val, node.right); 
		}
	}
}
