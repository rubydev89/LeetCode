package com.leetcode.cyclicSort;

import java.util.Arrays;

/*
 * PROBLEM: 
 * You have a set of integers s, which originally contains all the numbers from 1 to n. 
 * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, 
 * which results in repetition of one number and loss of another number.
 * You are given an integer array nums representing the data status of this set after the error.
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 * 
 * Constraints:
 * 		2 <= nums.length <= 104
 * 		1 <= nums[i] <= 104
 */
public class SetMismatch {

	public static void main(String[] args) {
		int nums[] = {4,3,2,7,8,5,3,1};
		
		System.out.println("The duplicates in the array is  : "+Arrays.toString(findErrorNums(nums)));

	}
	
	private static int[] findErrorNums(int[] nums) {
        int i=0;
        int ans[] = {-1,-1};
        while(i<nums.length) {
    		int correctIndex = nums[i] - 1;
        	if(nums[i] != nums[correctIndex]) {
        		swap(nums,i,correctIndex);
        	}
        	else
        		i++;
        }
        for(int j=0; j<nums.length;j++) {
        	if(nums[j] != j+1) {
        		ans[0] = nums[j];
        		ans[1] = j+1;
        	}
        		
        }
        return ans;
    }
	
	private static void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}

}
