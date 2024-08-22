package com.leetcode.binaryTree;


public class FlattenBinaryTreetoLinkedList {
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
	
	public void flatten(TreeNode root) {
		if(root == null)
			return;

		TreeNode right = root.right;
        TreeNode left = root.left;
        
        if(left != null){
            root.right = left;
            TreeNode leftChildLeaf = findLeftChildLeafNode(root);
            leftChildLeaf.right = right;
        }
        	
        root.left = null;
		
        flatten(root.left);
        flatten(root.right);
	
    }
	
	public TreeNode findLeftChildLeafNode(TreeNode root) {
		if(root == null)
			return root;
		
		TreeNode node = root;
		while(node.right != null) {
			node = node.right;
		}
		
		return node;
	}
}
