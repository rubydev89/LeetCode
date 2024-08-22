package com.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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
	
	//Using single queue
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return false;
		if(root.left != null & root.right != null && (root.left.val != root.left.val))
			return false;
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root.left);
        queue.offer(root.right);
        
        while(!queue.isEmpty()) {
        	int qSize = queue.size();
        	
        	for(int i=0; i<qSize; i++) {
        		TreeNode lNode = queue.poll();
        		TreeNode rNode = queue.poll();
        		
        		if(lNode != null && rNode != null) {
        			if(lNode.val != rNode.val) {
        				return false;
        			}
        			
        			queue.offer(lNode.left);
        			queue.offer(rNode.right);
        			queue.offer(lNode.right);
        			queue.offer(rNode.left);

        		}else if((lNode != null && rNode == null) || (lNode == null && rNode != null))
        			return false;
        	}
        }
		
		return true;
    }
	
	//Using 2 queues
	public boolean isSymmetricUsingTwoQueue(TreeNode root) {
		if(root == null)
			return false;
		if(root.left != null & root.right != null && (root.left.val != root.left.val))
			return false;
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        
        while(!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
        	int leftQSize = leftQueue.size();
        	int rightQSize = rightQueue.size();
        	if(leftQSize != rightQSize)
        		return false;
        	for(int i=0; i<leftQSize; i++) {
        		TreeNode lNode = leftQueue.poll();
        		TreeNode rNode = rightQueue.poll();
        		
        		if(lNode != null && rNode != null) {
        			if(lNode.val != rNode.val) {
        				return false;
        			}
        			if(lNode.left!=null) {
        				leftQueue.offer(lNode.left);
        			}
        			if(lNode.right!=null) {
        				leftQueue.offer(lNode.right);
        			}
        			if(rNode.right!=null) {
        				rightQueue.offer(rNode.right);
        			}
        			if(rNode.left!=null) {
        				rightQueue.offer(rNode.left);
        			}
        		}else
        			return false;
        	}
        }
        if(leftQueue!=null || rightQueue!= null)
        	return false;
		
		return true;
    }
}
