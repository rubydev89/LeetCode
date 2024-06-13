package com.leetcode.bitwise;

/*
 * 
 * PROBLEM:
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * */
public class AddBinary {

	public static void main(String[] args) {
		String a = "11", b = "1";

		System.out.println("The binary sum is : "+addBinary(a,b));

	}
	
	private static String addBinary(String a, String b) {
		int largestLength = (a.length() > b.length()) ? a.length() : b.length();
        StringBuilder ans = new StringBuilder(largestLength+1);
        int carryOver = 0;
        for(int i=largestLength-1;i>=0;i--) {
        	System.out.println("i is : "+i);
        	int aDigit = (a.length() > i) ? (int) a.charAt(i) : 0;
        	int bDigit = (b.length() > i) ? (int) b.charAt(i) : 0;
        	int sum = carryOver + aDigit + bDigit;
        	carryOver = 0;
        	ans.setCharAt(i, (char)sum);
        	if(sum > 1) {
        		carryOver = 1;
        		ans.setCharAt(i, '0');
        	}
        }
        if(carryOver > 0)
        	ans.setCharAt(0, '1');
        return ans.toString();
    }

}
