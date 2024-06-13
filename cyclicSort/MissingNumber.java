package com.leetcode.cyclicSort;

/*
 * 
 * PROBLEM: 
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
 * 
 * Constraints:
 * 		n == nums.length
 * 		1 <= n <= 104
 * 		0 <= nums[i] <= n
 * 		All the numbers of nums are unique.
 * 
 * */
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,6,4,9,3,8,7,0,1};
		
		System.out.println("The missing number in the arry is  : "+missingNumber(arr));

	}
	
	private static int missingNumber(int[] nums) {
		int i=0;
        while(i<nums.length) {
        	//int correctIndex = nums[i];
        	if(i != nums[i] && nums[i] < nums.length) {
        		swap(nums,i,nums[i]);
        	}
        	else {
        		i++;
        	}
        }
        
		for(int index=0; index<nums.length; index++) {
			if(nums[index] != index)
				return index;
		}
		return nums.length;
    }
	
	private static void swap(int[] arr, int first, int last) {
		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}

}
