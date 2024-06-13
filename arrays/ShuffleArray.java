package com.leetcode.arrays;

import java.util.Arrays;

/*
 * PROBLEM:
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
*/
public class ShuffleArray {

	public static void main(String[] args) {
		int nums[] = {2,5,1,3,4,7};// {0,2,1,5,3,4};
		int n = 3;
		
		System.out.println("Shuffled array is: "+Arrays.toString(shuffle(nums, n)));

	}
	
	private static int[] shuffle(int[] nums, int n) {
        int ans[] = new int[nums.length];
        int ansIndex = 0;
        for(int i=0; i<n; i++) {
        	ans[ansIndex++] = nums[i];
        	ans[ansIndex++] = nums[i+n];
        }
        return ans;
    }

}
