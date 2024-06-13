package com.leetcode.recursion;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {-1,0,3,5,9,12};
		int target = 12;
		
		System.out.println("Index of target is : "+search(arr, target, 0, arr.length-1));

	}
	
	private static int search(int[] nums, int target, int start, int end) {
        if(start > end)
        	return -1;
        
        int mid = start + (end-start)/2;
        
        if(target == nums[mid])
        	return mid;
        if(target < nums[mid])
        	return search(nums, target, start, mid-1);
        else
        	return search(nums, target, mid+1, end);
        			
    }

}
