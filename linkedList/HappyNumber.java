package com.leetcode.linkedList;

public class HappyNumber {
	public static void main(String[] args) {
		int num = 19;
		
		System.out.println("Is the no. happy? "+ isHappy(num));

	}
	
	public static boolean isHappy(int n) {
        if(n < 0) {
        	return false;
        }
        int sumSlow = sumOfSquareOfDigit(n, 's');
    	int sumFast = sumOfSquareOfDigit(n, 'f');
    	
    	while(sumFast != 1 || sumSlow!=1) {
    		if(sumSlow == sumFast) {
    			return false;
    		}
    		sumFast = sumOfSquareOfDigit(sumFast, 'f');
    		sumSlow = sumOfSquareOfDigit(sumSlow, 's');
    	}
    	return true;
    }
	
	private static int sumOfSquareOfDigit(int n, char c) {
		int sum = 0;
    	while(n >= 1){
    		int digit = n%10;
    		sum = sum + (digit*digit);
    		n = n/10;
    	}
    	if(c == 's')
    		return sum;
    	else
    		return sumOfSquareOfDigit(sum, 's');
	}

}
