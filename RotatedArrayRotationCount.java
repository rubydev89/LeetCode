package com.leetcode;

public class RotatedArrayRotationCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,5,6,7,8,1,2,3};
		//int target = 3;
		int pivoteIndex = pivoteIndex(arr);
		System.out.println("The rotation count in the rotated sorted array is : "+(pivoteIndex+1));

	}
	
	private static int pivoteIndex(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		
		while(start < end) {
			int mid = start + (end-start)/2;
			
			if(mid<end && arr[mid] > arr[mid+1])
				return mid;
			if(mid > start && arr[mid]< arr[mid-1])
				return mid-1;
			
			if(arr[mid] < arr[0]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return -1;
	}

}
