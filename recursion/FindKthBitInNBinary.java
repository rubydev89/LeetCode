package com.leetcode.recursion;

import java.util.Arrays;

public class FindKthBitInNBinary {

	public static void main(String[] args) {
		int n = 4, k = 9;
		System.out.println(k+"th bit in "+n+"th binary is : "+findKthBit(n,k));

	}
	
	public static char findKthBit(int n, int k) {
        String nThBinary = findKthBit(n);
		return nThBinary.charAt(k-1);
    }
	
	private static String findKthBit(int n) {
		if(n == 1)
			return "0";
		String nMinus1ThBit = findKthBit(n-1);
		String reverseInverseStr = reverseInvert(nMinus1ThBit);
		String nThStr = nMinus1ThBit + "1" + reverseInverseStr;
		
		return nThStr;
	}
	
	private static String reverseInvert(String str) {
		char[] ans = str.toCharArray();
		int length = ans.length;
		int start = 0;
		int end = length - 1;
		
		while(start <= end) {
			char cStart = (char) ((int)ans[end] ^ 1);
			char cEnd = (char) ((int)ans[start] ^ 1);
			
			ans[start++] = cStart;
			ans[end--] = cEnd;
		}
		
		return new String(ans);
	}

}
