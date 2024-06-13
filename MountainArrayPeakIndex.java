package com.leetcode;

public class MountainArrayPeakIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,5,9,14,16,18,19,20,21,22,23,24,25,26,27,28,29,11,8,4,1};
		int target = 23;
		
		System.out.println("The peak index in the mountain array is : "+peakIndexInMountainArray(arr));

	}
	
	private static int peakIndexInMountainArray(int[] arr) {
        /* BRUTE FORCE METHOD
        int start = 0;
        int end = 1;
        while(arr[start] < arr[end]){
            start = end;
            end = start + 1;
        }
        return start;
        */
        //OPTIMISED METHOD
        
        int start = 0;
        int end = arr.length - 1;
        
        while(start!=end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

}
