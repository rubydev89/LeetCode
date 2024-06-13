package com.leetcode.cyclicSort;

import java.util.ArrayList;
import java.util.List;

/*
 * PROBLEM:
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, 
 * return an array of all the integers that appears twice.
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * Each element in nums appears once or twice.
 * 
*/
public class DuplicatesInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,3,2,7,8,2,3,1};
		
		System.out.println("The duplicates in the array is  : "+findDuplicates(nums));

	}
	
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> duplicates = new ArrayList<>();
		int i=0;
		while(i<nums.length) {
			if(nums[i] != i+1) {
				int correctIndex = nums[i]-1;
				if(nums[i] != nums[correctIndex]) {
					swap(nums,i,correctIndex);
				}
				else {
					i++;
				}
			}else
				i++;
		}
		
		for(int j=0; j<nums.length; j++) {
			if(nums[j] != j+1)
				duplicates.add(nums[j]);
		}
		
		return duplicates;
    }
	
	private static void swap(int[] arr, int first, int last) {
		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}

}
