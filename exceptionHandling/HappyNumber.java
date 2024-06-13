package com.leetcode.exceptionHandling;

public class HappyNumber {

	public static void main(String[] args) {
		int num = 21;
		
		System.out.println("Is the no. happy? "+ isHappy(num));

	}
	
	public static boolean isHappy(int n) {
        if(n < 0) {
        	return false;
        }
        try {
        	int sum = sumOfSquareOfDigit(n);
        	if(sum == 1) {
        		return true;
        	}
        	return isHappy(sum);
        }catch (StackOverflowError e) {
			System.err.println(e.toString());
			return false;
		}
    }
	
	private static int sumOfSquareOfDigit(int n) {
		int sum = 0;
    	while(n >= 1){
    		int digit = n%10;
    		sum = sum + (digit*digit);
    		n = n/10;
    	}
    	return sum;
	}

}
