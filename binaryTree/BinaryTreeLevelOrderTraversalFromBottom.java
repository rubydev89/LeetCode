package com.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalFromBottom {
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
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> traversedList = new ArrayList<>();
		
		if(root == null) {
			return traversedList;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currList = new ArrayList<>();
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				if(node != null) {
					currList.add(node.val);
					if(node.left != null)
						queue.offer(node.left);
					if(node.right != null)
						queue.offer(node.right);
				}
			}
			traversedList.add(0, currList);
		}
		
		
		return traversedList;
    }
}
