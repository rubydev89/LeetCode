package com.leetcode.cyclicSort;

/*
 * PROBLEM:
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * */
public class DuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,1,3,4,2};
		
		System.out.println("The duplicate number is : "+findDuplicate(nums));

	}
	
	public static int findDuplicate(int[] nums) {
        int i=0;
        
        while(i<nums.length) {
        	int correctIndex = nums[i] - 1;
        	if(i!=correctIndex) {
        		if(nums[i] != nums[correctIndex])
        			swap(nums,i,correctIndex);
        		else
        			return nums[i];
        	}
        	else
        		i++;
        }
        
        return nums[nums.length-1];
    }
	
	private static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
