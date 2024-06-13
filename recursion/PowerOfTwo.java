package com.leetcode.recursion;

/*
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 * 
*/
public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=-2147483648;
		String binary = Integer.toBinaryString(n);
		//System.out.println("Is no."+ n +" power of 2 : "+isPowerOfTwo(binary, 0, 0));
		System.out.println("Is no."+ n +" power of 2 : " + isPowerOfTwo(n,0));

	}
	
	public static boolean isPowerOfTwo(String str, int start,int count) {
		System.out.println(str);
		if(count > 1)
			return false;
		if(start > str.length()-1) {
			if(count == 1)
				return true;
			else
				return false;
		}
		
		if(str.charAt(start) == '1')
			count++;
		return isPowerOfTwo(str, start+1, count);
        	
    }
	
	public static boolean isPowerOfTwo(int n,int count) {
		
		return n!=0 && (n & (n-1)) == 0;
		
		
		//return false;
		//return isPowerOfTwo(n, n+1, count);
        	
    }
	
	

}
