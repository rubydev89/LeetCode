package com.leetcode.recursion;

/*
 * PROBLEM:
 * Given an integer num, return the number of steps to reduce it to zero.
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 * 
 * */
public class NoOfStepsToZero {

	public static void main(String[] args) {
		int num = 123;
		System.out.println("The number of steps to reduce to 0 is : "+numberOfStepsToZero(num, 0));

	}

	private static int numberOfSteps(int num) {
       	int count = 0 ;
       	return numberOfStepsToZero(num, count);
    }
	
	private static int numberOfStepsToZero(int num, int count) {
		//count++;
		if(num == 0)
			return count;
		count++;
		if(num % 2 == 0) {
			return numberOfStepsToZero(num/2, count);
		}else
			return numberOfStepsToZero(num-1, count);
	}
}
