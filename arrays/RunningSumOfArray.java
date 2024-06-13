package com.leetcode.arrays;

import java.util.Arrays;

/*
 * PROBLEM:
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 * */
public class RunningSumOfArray {

	public static void main(String[] args) {
		int arr[] = {3,1,2,10,1};// {0,2,1,5,3,4};
		
		System.out.println(Arrays.toString(runningSum(arr)));

	}
	
	private static int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
        	sum += nums[i];
        	ans[i] = sum;
        }
        return ans;
    }

}
