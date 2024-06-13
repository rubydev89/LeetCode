package com.leetcode.arrays;

import java.util.Arrays;

/*
 * PROBLEM:
 * Given an integer array nums of length n, you want to create an array ans of length 2n 
 * where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 * Specifically, ans is the concatenation of two nums arrays.
 * Return the array ans.
*/
public class ConcatenationOfArrays {

	public static void main(String[] args) {
		int arr[] = {5,0,1,2,3,4};// {0,2,1,5,3,4};
		
		System.out.println(Arrays.toString(getConcatenation(arr)));

	}
	
	private static int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = nums[i];
            ans[nums.length+i] = nums[i];
}
              
        
        return ans;
    }

}
