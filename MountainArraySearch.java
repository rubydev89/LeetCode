package com.leetcode;

public class MountainArraySearch {

	public static void main(String[] args) {
		int[] arr = {2,3,5,9,14,16,18,19,20,21,22,23,24,25,26,27,28,29,11,8,4,1};
		int target = 29;
		
		System.out.println("The index of target in the mountain array is : "+findInMountainArray(target, arr));

	}
	
		private static int findInMountainArray(int target, int[] mountainArr) {
	        
	        int peakIndex = peakIndexOfMountainArray(mountainArr);
	        int index = searchTarget(mountainArr, target, 0, peakIndex, true);
	        if(index == -1){
	            index = searchTarget(mountainArr, target, peakIndex+1, mountainArr.length-1, false);
	        }
	        return index;
	    }
	
	    private static int peakIndexOfMountainArray(int[] mountainArr){
	        int start = 0;
	        int end = mountainArr.length-1;
	
	        while(start != end){
	            int mid = start + (end - start)/2;
	            if(mountainArr[mid] < mountainArr[mid+1])
	                start = mid + 1;
	            else
	                end = mid;
	        }
	        return start;
	    }
	
	    private static int searchTarget(int[] mountainArr, int target, int start, int end, boolean isAsc){
	        while(start <= end){
	            int mid = start + (end - start)/2;
	            if(isAsc){
	                if(mountainArr[mid] == target)
	                    return mid;
	                else if(target < mountainArr[mid])
	                    end = mid - 1;
	                else
	                    start = mid + 1;
	            }else{
	                if(mountainArr[mid] == target)
	                    return mid;
	                else if(target < mountainArr[mid])
	                    start = mid + 1;
	                else
	                    end = mid - 1;
	            }
	        }
	        return -1;
	    }

}
