package com.leetcode.cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * PROBLEM:
 * Given an array nums of n integers where nums[i] is in the range [1, n], 
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 * 
 * Constraints:
 * 		n == nums.length
 * 		1 <= n <= 105
 * 		1 <= nums[i] <= n
 * */

public class FindDisappearedNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1};
		
		System.out.println("The missing number in the arry is  : "+findDisappearedNumbers(arr));

	}
	
	private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        
        int i=0;
        while(i<nums.length) {
        	int correctIndex = nums[i]-1;
        	if(nums[i] != nums[correctIndex] && correctIndex < nums.length) {
        		swap(nums, i, correctIndex);
        	}else {
        		i++;
        	}
        }
        
        for(int j = 0 ; j<nums.length; j++) {
        	if(nums[j] != j+1) {
        		missingNumbers.add(j+1);
        	}
        }
        return missingNumbers;
    }
	
	private static void swap(int[] arr, int first, int last) {
		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}

}
