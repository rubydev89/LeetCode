package com.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
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
	
	 public List<Double> averageOfLevels(TreeNode root) {
		 List<Double> averageOfLevel = new ArrayList<>();
		 Queue<TreeNode> queue = new LinkedList<>();
		 queue.add(root);
		 
		 while(!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0;
			 for(int i=0; i<size; i++) {
				TreeNode currNode = queue.poll();
				sum += currNode.val;
                if(currNode.left != null)
                    queue.add(currNode.left);
                if(currNode.right != null)
                    queue.add(currNode.right);
			 }
             if(size != 0)
			    averageOfLevel.add(sum/size);
		 }
		 return averageOfLevel;
        
    }
}
