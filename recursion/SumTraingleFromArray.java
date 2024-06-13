package com.leetcode.recursion;

import java.util.Arrays;

/*
 * PROBLEM:
 * Given an array of integers, print a sum triangle from it such that 
 * 		the first level has all array elements. 
 * 		From then, at each level number of elements is one less than the previous level 
 * 		and elements at the level is be the Sum of consecutive two elements in the previous level. 
 * 
 * Input : A = {1, 2, 3, 4, 5}
 * Output : [48]
		[20, 28] 
		[8, 12, 16]
		[3, 5, 7, 9]
		[1, 2, 3, 4, 5] 
 *
 **/
public class SumTraingleFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 4, 5};
		sumTraingleFromArrayPrint(arr, arr.length-1, 0, new int[arr.length-1]);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Sum of the traingle is : "+sumTraingleFromArray(arr, arr.length-1, 0, new int[arr.length-1]));
	}
	
	private static void sumTraingleFromArrayPrint(int[] arr, int row, int col, int[] sumArray) {
		if(row == 0) {
			return;
		}
		if(row > col) {
			sumArray[col] = arr[col] + arr[col+1];
			sumTraingleFromArrayPrint(arr,row,col+1,sumArray);
		}else {
			sumTraingleFromArrayPrint(sumArray,row-1,0,new int[sumArray.length-1]);
			System.out.println(Arrays.toString(sumArray));
		}
	}
	
	private static int sumTraingleFromArray(int[] arr, int row, int col, int[] sumArray) {
		if(row == 0) {
			return arr[0];
		}
		if(row > col) {
			sumArray[col] = arr[col] + arr[col+1];
			return sumTraingleFromArray(arr,row,col+1,sumArray);
		}else {
			return sumTraingleFromArray(sumArray,row-1,0,new int[sumArray.length-1]);
			//System.out.println(Arrays.toString(sumArray));
		}
	}

}
