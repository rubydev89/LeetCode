package com.leetcode;

import java.util.Arrays;

public class TwoDArrayFullSortedSearch {

	public static void main(String[] args) {
		int arr[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,40}};
		int target = 10 ;
		
		System.out.println("The target is at location : "+ searchMatrix(arr, target));

	}
	
	private static boolean searchMatrix(int[][] nums, int target) {
        //return bruteForceSearch(nums,target);
        int totalColumn = nums[0].length;
        int rStart = 0;
        int rEnd = nums.length - 1;

        while(rStart <= rEnd){
            int rMid = rStart + (rEnd - rStart)/2;
            if((target == nums[rMid][0]) || (target == nums[rMid][totalColumn - 1]))
                return true;
            else if(target < nums[rMid][0])
                rEnd = rMid - 1;
            else if(target > nums[rMid][totalColumn - 1])
                rStart = rMid + 1;
            else
                return binarySearch(nums[rMid], target);
        }

        return false;
    }

    private static boolean binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == arr[mid])
                return true;
            else if(target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

}
