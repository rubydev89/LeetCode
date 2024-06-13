package com.leetcode;

public class SplitLargestArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,2,5,10,8};
		int k = 2;
		System.out.println(splitArray(arr, k));
		

	}
	
	private static int splitArray(int[] nums, int k) {
		
		//find the start and the end i.e the range of all the sums that any sub arrays formed from the array can give
		int start = 0;
		int end = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > start)
				start = nums[i];
			end += nums[i];
		}
		
		//System.out.println("Range is -> "+start+ " : "+end);
		
		while(start < end) {
			int mid = start + (end-start)/2;
			int subArrayCount = 1;
			int sum = 0;
			for(int num : nums) {
				//sum += num;
				if(sum + num > mid) {
					subArrayCount++;
					sum = num;
				}else {
					sum += num;
				}
			}
			
			if(subArrayCount <= k) {
				end = mid;
			}
			else
				start = mid+1;
		}
        
		return end;
    }
	
	public int splitArrayFromLeetCode(int[] nums, int k) {
        int start = 0;
		int end = 0;
		
		for(int i=0; i<nums.length; i++) {
			start = Math.max(start,nums[i]);
			end += nums[i];
		}
		
		while(start < end) {
			int mid = start + (end-start)/2;
			int subArrayCount = 1;
			int sum = 0;
			for(int num : nums) {
				//sum += num;
				if(sum + num > mid) {
					subArrayCount++;
					sum = num;
				}else {
					sum += num;
				}
			}
			
			if(subArrayCount <= k) {
				end = mid;
			}
			else
				start = mid+1;
		}
        
		return start;
    }
	
	//private static findSum()

}
