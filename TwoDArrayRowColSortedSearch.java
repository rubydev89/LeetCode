package com.leetcode;

import java.util.Arrays;

public class TwoDArrayRowColSortedSearch {

	public static void main(String[] args) {
		int arr[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,40}};
		int target = 100 ;
		
		System.out.println("The target is at location : "+ Arrays.toString(twoDArraySearchRowColumnSorted(arr, target)));

	}
	
	private static int[] twoDArraySearchRowColumnSorted(int[][] nums, int target){
		int rowIndex = 0;
		int colIndex = nums[nums.length-1].length-1;
		System.out.println(nums[nums.length-1].length);
		while(rowIndex <= nums.length-1 && colIndex >= 0) {
			int mid = nums[rowIndex][colIndex];
			
			if(target == mid)
				return new int[] {rowIndex,colIndex};
			else if(target < mid)
				colIndex--;
			else
				rowIndex++;
		}
		
		return new int[] {-1,-1};
	}
	
	private static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(target == arr[mid])
				return mid;
			else if(target < mid)
				end = mid-1;
			else
				start = mid+1;
		}
		
		return -1;
	}

}
