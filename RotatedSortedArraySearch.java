package com.leetcode;

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,5,6,7,8,9,10,2,3};
		int target = 3;
		
		System.out.println("The index of target in the rotated sorted array is : "+search(arr, target));

	}
	
	private static int search(int[] nums, int target) {
		int peakIndex = indexOfPeakElement(nums);
        //System.out.println(peakIndex);
        if(target == nums[peakIndex])
        	return peakIndex;
        if(target == nums[0])
            return 0;
        else if(target > nums[0])		
        	return searchTarget(nums, target, 1, peakIndex-1);
        else
            return searchTarget(nums, target, peakIndex+1, nums.length-1);
        //return index;
    }

    private static int indexOfPeakElement(int[] nums){
    	int start = 0;
        int end = nums.length - 1;
        while(start != end){
            int mid = start + (end-start)/2;
            if(mid<end && nums[mid] > nums[mid+1]) // >=
                return mid;
            if(mid>start && nums[mid] < nums[mid-1]) // <=
                return mid-1;
            if(nums[mid] < nums[0]) // <= for duplicates
                end = mid-1;
            else
                start = mid+1;
        }
        return start;
    }

    private static int searchTarget(int[] arr, int target, int start, int end){
    	while(start <= end){
            int mid = start + (end-start)/2;
            if(target == arr[mid])
                return mid;
            else if(target < arr[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }

}
