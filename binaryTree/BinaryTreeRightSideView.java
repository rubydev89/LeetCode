package com.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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

	//Using Queue
	public List<Integer> rightSideViewWithQueue(TreeNode root) {
        List<Integer> rightNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
        	int qSize = queue.size();
            while(qSize!=0){
        		TreeNode node = queue.poll();
        		if(node != null) {
            		if(qSize == 1) {
            			rightNodes.add(node.val);
            		}
            		if(node.left != null)
            			queue.offer(node.left);
            		if(node.right != null)
            			queue.offer(node.right);
        		}
                qSize--;
        	}
        }
		return rightNodes;
    }
	
	//Without using Queue or any extra spaces
	/*
	 * public List<Integer> rightSideView(TreeNode root) { List<Integer>
	 * rightSeenNodes = new ArrayList<>(); if(root == null) { return rightSeenNodes;
	 * }
	 * 
	 * TreeNode rightSibling = null; rightSideView(root, rightSibling,
	 * rightSeenNodes);
	 * 
	 * return rightSeenNodes; }
	 * 
	 * private void rightSideView(TreeNode node, TreeNode rightSibling,
	 * List<Integer> rightSeenNodes) { if(node == null) { return; }
	 * 
	 * if(rightSibling == null) { rightSeenNodes.add(node.val); }
	 * 
	 * rightSideView(node.left, node.right, rightSeenNodes); if(rightSibling !=
	 * null) { rightSideView(node.right, rightSibling.left, rightSeenNodes); }
	 * 
	 * }
	 */

}
