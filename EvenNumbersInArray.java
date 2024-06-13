package com.leetcode;

public class EvenNumbersInArray {
	/*
	 * PROBLEM STATEMENT
	 * Find the count of numbers in an array which has even digits
	 * 
	 * ALGORITHM:
	 * 
	 * for each element in the array
	 * 		while the n is greater than 0
	 * 			increament count of digits 
	 * 			n = n/10
	 * 		if count of digits % 2 = 0
	 * 		increament count of even digit numbers
	 * 
	 * return the count of even digit numbers
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2345,46587,1243,345,678,24,678,5682345,-6701, -2};
		
		System.out.println("The no. of even numbers in the array is  : "+evenNumberCount(nums));
		

	}
	
	private static int evenNumberCount(int[] arr) {
		int numberWithEvenDigits = 0;
		for(int a : arr) {
			int digitCount = 0;
			while(a > 0) {
				digitCount++;
				a /= 10;
			}
			if(digitCount>0 && digitCount % 2 == 0) {
				numberWithEvenDigits++;
			}
		}
		
		return numberWithEvenDigits;
	}

}
