package com.leetcode;

public class SearchInInfiniteArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,5,9,14,16,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
		int target = 23;
		int start = 0;
		int end = 1;
		
		while(target>arr[end]) {
			int newStart = end + 1;
			end = end + (end - start + 1)*2 ;
			start = newStart;
		}
		//System.out.println();
		System.out.println("The index of the number is : "+searchInfiniteArray(arr, target, start, end));

		
	}
	
	private static int searchInfiniteArray(int[] arr, int target, int start, int end) {
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(target == arr[mid])
				return mid;
			else if(target > arr[mid])
				start = mid + 1;
			else
				end = mid - 1;		
		}
		return -1;
	}

}
