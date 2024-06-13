package com.leetcode.recursion;

import java.util.Arrays;

/*
 * 
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.

*/
public class ReverseString {

	public static void main(String[] args) {
		char[] str = {'H','a','n','n','a','h'};
		
		reverseString(str, 0, str.length-1);
		System.out.println("The reversed string is : "+Arrays.toString(str));

	}
	
	private static void reverseString(char[] str, int start, int end) {
        if(start >= end)
        	return;
        char temp = str[start];
        str[start++] = str[end];
        str[end--] = temp;
        
        reverseString(str, start, end);
    }

}
