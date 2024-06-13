package com.leetcode.cyclicSort;

import java.util.Arrays;

/*
 * PROBLEM:
 * Given an unsorted integer array nums. 
 * Return the smallest positive integer that is not present in nums.
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 * Constraints:
 * 		1 <= nums.length <= 105
 * 		-231 <= nums[i] <= 231 - 1
**/
public class FirstMissingPositive {

	public static void main(String[] args) {
		int nums[] = {1};
		
		System.out.println("The duplicates in the array is  : "+firstMissingPositive(nums));

	}
	
	public static int firstMissingPositive(int[] nums) {
        int i=0;
        //int length = nums.length;
        while(i<nums.length) {
        	//We will only sort the elements from 1 to n to see which 1st +ve element is missing
        	if(nums[i] > 0) {
        		int correctIndex = nums[i]-1;
            	if(correctIndex<nums.length && nums[i] != nums[correctIndex]) {
            		swap(nums, i, correctIndex);
            	}else
            		i++;
        	}else
        		i++;
        	
        }
        
        for(int j=0; j<nums.length; j++) {
        	if(nums[j] != j+1)
        		return j+1;
        }
        
        return nums.length;
    }
	
	private static void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}

}
